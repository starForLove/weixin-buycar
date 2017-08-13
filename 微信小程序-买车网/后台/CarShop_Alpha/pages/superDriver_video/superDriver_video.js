// pages/superDriver_video/superDriver_video.js
var getList = function (that) {
  that.setData({
    lastId: 0
  })
  console.log("this is page id ="+JSON.stringify(that))
  wx.request({
    url: 'http://localhost:8080/wx_CarShop/CarReviewServlet?method=0&table=videoreview&id='+that.options.id,
    data: { "name": "Tom", "password": 123 },
    header: {
      "Content-type": "application/x-www-form-urlencoded"
    },
    method: 'get',
    success: function (obj) {
      console.log("obj" + JSON.stringify(obj))
      var list = obj.data.data
      var id = that.data.lastId + 3
      that.setData({
        objlist: list,
        lastId: id
      })
      // console.log('lastId'+JSON.stringify(that.data.lastId))
    },
    fail: function (err) {

    }
  })
}
var loadMore = function (that) {
  var sid = that.data.lastId
  // console.log("sid"+sid)
  wx.request({
    url: 'http://localhost:8080/wx_CarShop/CarReviewServlet?method=1&table=videoreview&id=' + sid + '&sid=' + that.options.id,
    data: {},
    header: {
      "Content-type": "application/x-www-form-urlencoded"
    },
    method: 'get',
    success: function (obj) {
      // console.log("加载3条数据")

      // console.log('obj.data.data[0]'+JSON.stringify(obj.data.data[0]))
      var list = that.data.objlist
      var id = that.data.lastId + 3
      for (var i = 0; i < obj.data.data.length; i++) {
        list.push(obj.data.data[i])
      }

      // console.log(JSON.stringify(list))
      that.setData({
        objlist: list,
        lastId: id
      })
    },
    fail: function (err) {
      console.log("翻到头了")
    }
  })
}
Page({

  /**
   * 页面的初始数据
   */
  data: {
    video_page:[],
    title:"",
    author:"",
    date:"",
    video_url:"",
    icon_url:"",
    objlsit:[],
    lastId:0,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("JSIJFEWOJFOWEJ"+JSON.stringify(options.id))
    var that = this
    wx.request({
      url: 'http://localhost:8080/wx_CarShop/CarVideoServlet?method=1&id='+options.id,
      data: { "name": "Tom", "password": 123 },
      header: {
        "Content-type": "application/x-www-form-urlencoded"
      },
      method: 'get',
      success: function (obj) {
        console.log(JSON.stringify(obj.data.data))
        var list = obj.data.data
        console.log("list:"+JSON.stringify(list));
        that.setData({
          title:list[0].title,
          author: list[0].author,
          date: list[0].date,
          video_url: list[0].video_url,
          icon_url: list[0].icon_url
        })
        
      },
      fail: function (err) {

      }
    })
    getList(that)
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    var that = this
    loadMore(that)
    console.log("ReachBottom")
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})