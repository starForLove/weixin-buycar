// pages/car_index/car_index.js
Page({
  data:{
    name:"",
    logo:"",
    list:[],
    list_line:[],
    s:[],
    count:[],
    Null:""
  
  },
  onLoad:function(options){
    // 页面初始化 options为页面跳转所带来的参数
    var that=this
    var res=[]
    var x=[]
    var f=""
    var s=[]
    var con = []
    wx.setNavigationBarTitle({
  title: options.name
})
   
      this.setData({
        name:options.name,
        logo:options.logo
      })
         wx.request({
      url: 'http://localhost:8080/wx_CarShop/CarKindServlet?method=0',
      data: { "name": "Tom", "password": 123 },
      header: {
        "Content-type": "application/x-www-form-urlencoded"
      },
      method: 'get',
      success: function (obj) {
       var c = 0
       //去重
         if(obj.data.data[0].brand_name==that.data.name)
        {
          res[0]=obj.data.data[0].kind
        }
       for(var i=1;i<obj.data.data.length;i++)
       {
          if(obj.data.data[i].brand_name==that.data.name)
        {
     
         var repeat=false
        for(var j=0;j<res.length;j++)
        {
           
          if(obj.data.data[i].kind==res[j])
          {
            repeat=true
           
            break;
          }
        } 
          if(!repeat)
          {
            res.push(obj.data.data[i].kind)
          }
        }
       }

      // 计数
      for(var i=0;i< res.length;i++)
          {
            
            for(var j=0;j<obj.data.data.length;j++)
          {
           if( res[i]==obj.data.data[j].kind)
           {
            c++
           }
          
          }
           con.push(c)
           c=0
          }
          //数组拼接
        for(var i=0;i<res.length;i++)
        {
          for(var j=0;j<obj.data.data.length;j++)
          {
            if(res[i]==obj.data.data[j].kind)
            {
              if(f!=res[i]){
                f=res[i]
                  x.push({"car_kind":f,"count":con[i],"flag":0})
              x.push({"list":obj.data.data[j],"flag":1})
          
              }else{
                 x.push({"list":obj.data.data[j],"flag":1})
            
              }
              
            
            }
            

          }
          
  
        }
         
          
       console.log(JSON.stringify(that.data.count))
        that.setData({
         list:obj.data.data,
         list_line:res,
         s:x
        })
        // console.log(JSON.stringify(that.data.))
        console.log(JSON.stringify(that.data.s))
        console.log(JSON.stringify(con))
      },
      fail: function (err) {

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
  onUnload:function(option){
    // 页面关闭
   
  },
  jumptoCarInfo:function(e){
      var car_name=""
    var price_range=""
    var brand_name=""
    var size=""
    console.log("jumptocarInfoEEEE"+JSON.stringify(e))
    console.log(JSON.stringify(e.currentTarget.dataset.value))
 
      car_name=e.currentTarget.id
      price_range=e.currentTarget.dataset.value
      brand_name=e.currentTarget.dataset.key
      size=e.currentTarget.dataset.size
      console.log("jumpInfo:" + JSON.stringify(car_name + "   " + price_range + "   " + brand_name + "   " +size))
     wx.navigateTo({
   url: '../car_info/car_info?car_name='+car_name+'&price_range='+price_range+'&brand_name='+brand_name+'&size='+size,

})

  }
})