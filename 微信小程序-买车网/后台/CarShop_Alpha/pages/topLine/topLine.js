// pages/topLine/topLine.js
var getList = function(that){
  that.setData({
    lastId:0
  })
  wx.request({
   url: 'http://localhost:8080/wx_CarShop/CarArticleServlet?method=0',
    data: { "name": "Tom", "password": 123 },
    header: {
      "Content-type": "application/x-www-form-urlencoded"
    },
    method: 'post',
    success:function (res) {
         console.log("返回值值："+JSON.stringify(res))
         var x=JSON.parse(res.data.obj[0].picture)
         var y = []
         console.log("sss"+JSON.stringify(res));
         console.log(JSON.parse(res.data.obj[0].picture));
         for(var i=0;i<res.data.obj.length;i++){
           y.push({
             "picture":JSON.parse(res.data.obj[i].picture),
             "topBrowes":res.data.obj[i].topBrowes,
             "topCont":res.data.obj[i].topCont,
             "topId":res.data.obj[i].topId,
             "topTime":res.data.obj[i].topTime,
             "topTitle":res.data.obj[i].topTitle
           })
         }
        var id = that.data.lastId + 5

         that.setData({
         artType: y,
         lastId:id
         });
         
        

         
    },
    fail: function (err) {
       
    }
  })
}
var loadMore = function(that){
  console.log("loadmoresid "  +JSON.stringify(that.data.lastId))
  var sid = that.data.lastId
  console.log("sid"+sid)
  wx.request({
   url: 'http://localhost:8080/wx_CarShop/CarArticleServlet?method=4&id=' +sid,
    data: {},
    header: {
      "Content-type": "application/x-www-form-urlencoded"
    },
    method: 'get',
    success: function (res) {
      console.log("后台返回值值："+JSON.stringify(res))
      // console.log("加载3条数据")

      // console.log('obj.data.data[0]'+JSON.stringify(obj.data.data[0]))
       var list = that.data.artType
       var id = that.data.lastId +5
       var y = []
       for (var i = 0; i < res.data.data.length;i++){
            y.push({
              "picture": JSON.parse(res.data.data[i].picture),
              "topBrowes": res.data.data[i].topBrowes,
              "topCont": res.data.data[i].topCont,
              "topId": res.data.data[i].topId,
              "topTime": res.data.data[i].topTime,
              "topTitle": res.data.data[i].topTitle
            })
      }
      console.log("y数组的值是是："+JSON.stringify(y))
      
      for (var i = 0; i < res.data.data.length;i++){
         list.push(y[i])
         console.log("fresh")
     }

       console.log("组合后的数组"+JSON.stringify(list))
       that.setData({
         artType:list,
         lastId: id
       })
    },
    fail: function (err) {
      console.log("翻到头了")
    }
  })
}
Page({
  data:{
      artType:['1','2','3','4','5'],
      flag :false,
      id:"",
      objlist:[],
      scrollHeight:0,
      lastId:0
  },
  onLoad:function(options){
    // 页面初始化 options为页面跳转所带来的参数
    
    var that= this;
    getList(that)
    
    
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
  onPullDownRefresh: function () {
    var that = this
    getList(that)
    wx.stopPullDownRefresh()

    console.log("pulldown")
  },
  onReachBottom: function () {
    var that = this
    loadMore(that)
  },
  goarticle:function(obj){
    var   that = this
     console.log("ttt"+JSON.stringify(obj))
     this.setData({
       id:obj.currentTarget.dataset.id
     })
     wx.request({
      url: 'http://localhost:8080/wx_CarShop/CarArticleServlet?method=1',
      data: { 
        id:this.data.id
       },
      header:{
        "Content-type":"application/x-www-form-urlencoded"
      },
      method:'get',
      
       success:function (res) {
        console.log("res:"+JSON.stringify(obj))
        var x=JSON.parse(res.data.obj[0].picture)
         var y = []
         console.log("sss"+JSON.stringify(res));
         console.log(JSON.parse(res.data.obj[0].picture));
         for(var i=0;i<res.data.obj.length;i++){
           y.push({
             "picture":JSON.parse(res.data.obj[i].picture),
             "topBrowes":res.data.obj[i].topBrowes,
             "topCont":res.data.obj[i].topCont,
             "topId":res.data.obj[i].topId,
             "topTime":res.data.obj[i].topTime,
             "topTitle":res.data.obj[i].topTitle
           })
         }
         that.setData({
         artType: y
         
         });
      },
      fail:function(err){
         console.log("sgddf")
      }
    })
     wx.navigateTo({
       url: '../TopLinePage/TopLinePage?id=' + obj.currentTarget.dataset.id,
       success: function (res) { },
       fail: function (res) { },
       complete: function (res) { },
     })
  }
})