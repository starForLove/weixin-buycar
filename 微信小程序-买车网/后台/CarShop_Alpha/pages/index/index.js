Page({
  data:{
    toView:"",
    aplha:["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"],
    logo_list:[],
    list:[],
    aplha_list:[],
    toTop:0,
    all_list:[],
    current_data:[],
    
  },
  onLoad:function(options){
    // 页面初始化 options为页面跳转所带来的参数
    var that=this
    var l = []
    var x = []
    var f = ""
    var a=[]
    var s=[]
wx.setNavigationBarTitle({
  title: '买车网'
})


  //请求
   wx.request({
      //url: 'http://10.1:8080/wx_CarShop/CarBrandServlet?method=0',
      url: 'http://localhost:8080/wx_CarShop/CarBrandServlet?method=0',
      data:{},
      header:{ 'content-type': 'application/x-www-form-urlencoded'},         
      method:'post',
      success:function(obj){
    console.log(JSON.stringify(obj.data.quantity))
  for(var i=0;i<that.data.aplha.length;i++)
  {
    for(var j=0;j<obj.data.data.length;j++)
    {
      if(that.data.aplha[i]===obj.data.data[j].aplha_code)
      {
        if(f!=that.data.aplha[i])
        {
          f=that.data.aplha[i]
          x.push(f)
          l.push({"aplha_code":f,"flag":0})
          l.push({"list":obj.data.data[j],"flag":1})
        }
        else{  l.push({"list":obj.data.data[j],"flag":1})}
        
      }
    }
  }
  
  for(var k=0;k<10;k++)
  {
    a.push(obj.data.data[k])
  }
  for(var k=0;k<obj.data.data.length;k++)
  {
    s.push(obj.data.data[k])
  }
   console.log("a"+JSON.stringify(l))
    that.setData({  
        list:l,
        logo_list:a,
        aplha_list:x,
        all_list:s
    })

      },
      
      
      fail:function(err){

      }
  })
  },
  onReady:function(){
    // 页面渲染完成
    
  },
  onShow:function(){
  
  },
  onHide:function(){
    // 页面隐藏
  },
  onUnload:function(){
    // 页面关闭
  },
  tapName:function(options){
 
  console.log(options.target.dataset.hi
)
  this.setData({
      toView:options.target.dataset.hi

    })
  },
  jumpToTop:function(){


    this.setData({
      toTop:0
    })
  },
  jumpToCar_index:function(e){
    var name=""
    var logo=""
    console.log(JSON.stringify(e.currentTarget.dataset.value))
 
      name=e.currentTarget.id
      logo=e.currentTarget.dataset.value
      console.log(JSON.stringify(logo))
     wx.navigateTo({
   url: '../car_index/car_index?name='+name+'&logo='+logo,

})
  }
})