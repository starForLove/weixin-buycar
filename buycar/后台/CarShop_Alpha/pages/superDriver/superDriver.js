// pages/superDriver/superDriver.js

var getList = function(that){
  that.setData({
    lastId: 0
  })
  wx.request({
    url: 'http://localhost:8080/wx_CarShop/CarVideoServlet?method=0',
    data: { "name": "Tom", "password": 123 },
    header: {
      "Content-type": "application/x-www-form-urlencoded"
    },
    method: 'get',
    success: function (obj) {
      console.log("obj"+JSON.stringify(obj))
      var list = obj.data.data
      var id = that.data.lastId + 3
      that.setData({
        objlist: list,
        lastId:id
      })
      // console.log('lastId'+JSON.stringify(that.data.lastId))
    },
    fail: function (err) {

    }
  })
}
var loadMore = function(that){
  var sid = that.data.lastId
  // console.log("sid"+sid)
  wx.request({
    url: 'http://localhost:8080/wx_CarShop/CarVideoServlet?method=2&id=' +sid,
    data: {},
    header: {
      "Content-type": "application/x-www-form-urlencoded"
    },
    method: 'get',
    success: function (obj) {
      // console.log("加载3条数据")

      // console.log('obj.data.data[0]'+JSON.stringify(obj.data.data[0]))
      var list = that.data.objlist
      var id = that.data.lastId +3
      for(var i=0;i<obj.data.data.length;i++){
        list.push(obj.data.data[i])
      }

      // console.log(JSON.stringify(list))
      that.setData({
        objlist:list,
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
    objlist:[],
    scrollHeight:0,
    lastId:0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
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
  
  },
  onPullDownRefresh: function () {
    var that = this
    getList(that)
    wx.stopPullDownRefresh()

    console.log("pulldown")
  },
  click:function(rs){
    var id = rs.currentTarget.id
    console.log("this is id"+id)
    wx.navigateTo({
      url: '../superDriver_video/superDriver_video?id='+id,
    })
  }

})