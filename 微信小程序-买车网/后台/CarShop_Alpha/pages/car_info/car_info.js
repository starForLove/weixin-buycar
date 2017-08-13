// pages/car_info/car_info.js
Page({
  data:{
    car_name:"",
    price_range:"",
    brand_name:"",
    size:"",
    top:[],
    condition:[],
    Type:"",
    list:[],
    currentTab:0,
    currentTab2:0,
    list2:[],
    year:"",
    font:"",
    font2:""
  

  },
  onLoad:function(options){
    // 页面初始化 options为页面跳转所带来的参数
        wx.setNavigationBarTitle({
          title: options.car_name
        })
    var that=this
    that.setData({
      car_name:options.car_name,
      price_range:options.price_range,
      brand_name:options.brand_name,
      size:options.size
    })
    wx.request({
      url: 'http://localhost:8080/wx_CarShop/CarInfoServlet?method=1',
      data: {
        "car_name":that.data.car_name
      },
      method: 'post', 
      header:{ 'content-type': 'application/x-www-form-urlencoded'},
       success: function(obj){
       // console.log("fffffffffffffffffffffffffffffff===="+JSON.stringify(obj))


    //状态去重
    console.log(JSON.stringify(obj.data.data[0].condition))
        var res2=[]
        res2[0]={"condition":obj.data.data[0].condition}    
         for(var i=1;i<obj.data.data.length;i++)
       {
     
         var repeat=false
        for(var j=0;j<res2.length;j++)
        {
           
          if(obj.data.data[i].condition==res2[j].condition)
          {
            repeat=true
           
            break;
          }
        } 
          if(!repeat)
          {
            res2.push({"condition":obj.data.data[i].condition})
          }
        
       }
       
         //年份去重
         var list = []
         var f = []

         for (var i = 0; i < res2.length; i++) {
           for (var j = 0; j < obj.data.data.length; j++) {
             if (res2[i].condition == obj.data.data[j].condition) {

               var repeat = false
               for (var k = 0; k < f.length; k++) {
                 if (f[k].year == obj.data.data[j].year) {
                   var repeat = true
                   break;
                 }
               }
               if (!repeat) {
                 f.push({ "year": obj.data.data[j].year, "condition": res2[i].condition })
               }
             }
           }
         }


       var c=[]
       for(var i=0;i<res2.length;i++)
       { c=[]
         for(var j=0;j<f.length;j++)
         {
          
           
           if(res2[i].condition==f[j].condition)
           {
             c.push(f[j].year)
           }
         }
         //console.log(JSON.stringify(c))
         list.push({"type":res2[i].condition,"year":c})
       }

       var list2=list[0].year
       var s=list[0].type
       var y=list2[0]
     // console.log("fdddsdsf"+JSON.stringify(list2[0]))
      var font=obj.data.data[0].output+"T "+obj.data.data[0].air_admission+" "+obj.data.data[0].horsepower+"马力"
       var image_url=obj.data.data[0].image_url

        that.setData({
          top:image_url,
         condition:list,
         list:list2,
          Type:s,
          year:y,
          font:font
         

        })
       //  console.log("df"+JSON.stringify(that.data.Type))
        that.getMessage()
      },
      fail: function() {
        // fail
      },
      complete: function() {
        // complete
      }
    })
  },
  onReady:function(){
    // 页面渲染完成
  },
  onShow:function(){
    // 页面显示
  },
  onHide:function(){
    // 页面隐藏
  },
  onUnload:function(){
    // 页面关闭
  },

    swichNav: function( e ) {  
      var that=this
  // console.log(JSON.stringify(e))
  // console.log(e.target.dataset.current)
  //  console.log(e.target.dataset.type)
  that.setData({
    list:e.target.dataset.year,
    Type:e.target.dataset.type,
    currentTab:e.target.dataset.current  
  })
   console.log(JSON.stringify(that.data.currentTab))
  that.setData({
    year:that.data.list[0]
  })
  that.getMessage()
 
  
    if( this.data.currentTab === e.target.dataset.current ) {  
      return false;  
    } else {  
      that.setData( {  
        currentTab: e.target.dataset.current  
      })  
    }  
  } ,

    swichNav2: function( e ) {  
 console.log("fddf"+JSON.stringify(e.target.dataset.type))
      this.setData({
        year:e.target.dataset.year,
        currentTab2:e.target.dataset.current  
        
      })
      this.getMessage()
    // console.log(JSON.stringify(e.target.dataset))
    // if( this.data.currentTab2 === e.target.dataset.current ) {  
    //   return false;  
    // } else {  
    //   that.setData( {  
    //     currentTab2: e.target.dataset.current,
    //     year:e.target.dataset.value 
    //   })  
    // }
    
  
  },
  getMessage:function(){
      var that = this;  
     //  console.log("list2"+JSON.stringify(that.data.year))
      wx.request({
      url: 'http://localhost:8080/wx_CarShop/CarInfoServlet?method=0',
      data: {
        "car_name":that.data.car_name,
        "year":that.data.year,
        "condition":that.data.Type
      },
      method: 'post', 
      header:{ 'content-type': 'application/x-www-form-urlencoded'},
      success: function(res){
         var font=res.data.data[0].output+"T "+res.data.data[0].air_admission+" "+res.data.data[0].horsepower+"马力"
     that.setData({
       list2:res.data.data,
       font:font
     })
     console.log("list2"+JSON.stringify(res.data))
      },
      fail: function() {
        // fail
      },
      complete: function() {
        // complete
      }
    }) 
  },
  jumpViewPicture: function (res) {
    var that = this
    var id = res.currentTarget.id
    var index = res.currentTarget.dataset.index
    var configuration_id = that.data.list2[index].configuration_id
    console.log("ressssss" + JSON.stringify(res.currentTarget.dataset.index))
    console.log("fsadfsdfsdf" + JSON.stringify(that.data.top))
    wx.navigateTo({
      url: '../viewPicture/viewPicture?id=' + that.data.list2[index].id + '&car_model=' + that.data.list2[index].car_model + '&car_name=' + that.data.car_name + '&img_url=' + that.data.top +'&price=' + that.data.list2[index].price,
    })
  },
  jumpAskPrice: function (res) {
    var that = this
    var index = res.currentTarget.dataset.index
    var id = res.currentTarget.id
 //   var configuration_id = that.data.list2[id].configuration_id
    console.log("jumpAskPrice1" + JSON.stringify(res.currentTarget.id))
    wx.navigateTo({
      url: '../askPrice/askPrice?id=' + that.data.list2[index].id+'&car_model=' + that.data.list2[index].car_model + '&car_name=' + that.data.car_name + '&img_url=' + that.data.top,

          })
  },


  jumpCarConfig: function (res) {
    var that = this
    var id = res.currentTarget.id
    var index = res.currentTarget.dataset.index
    wx.navigateTo({
      url: '../configrtion/configrtion?id=' + id + '&car_model=' + that.data.list2[index].car_model,
    })
  }
  
})