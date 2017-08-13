// pages/superDriver_video/superDriver_video.js
var WxParse = require('../../wxParse/wxParse.js');

var getReviewList = function (that) {
  that.setData({
    lastId: 0
  })
  console.log("this is page id =" + JSON.stringify(that))
  wx.request({
    url: 'http://localhost:8080/wx_CarShop/CarReviewServlet?method=0&table=article_review&id=' + that.options.id,
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
    url: 'http://localhost:8080/wx_CarShop/CarReviewServlet?method=1&table=article_review&id=' + sid + '&sid=' + that.options.id,
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
    video_page: [],
    title: "",
    author: "",
    date: "",
    video_url: "",
    icon_url: "",
    objlsit: [],
    lastId: 0,

    nodes: [{
      name: 'div',
      attrs: {
        class: 'div_class',
        style: 'line-height: 60px; color: red;'
      },
      children: [{
        type: 'text',
        text: 'Hello&nbsp;World!3h'
      }]
    }],
    article1:""


  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({
      title: "文章详情"
    })
    var that = this
    var text = that.data.nodes[0].children[0].text
    wx.request({
      url: 'http://localhost:8080/wx_CarShop/TopLinePageServlet?method=0&id=' + options.id,
      data: { "name": "Tom", "password": 123 },
      header: {
        "Content-type": "application/x-www-form-urlencoded"
      },
      method: 'get',
      success: function (obj) {
        console.log("obj.data.data"+JSON.stringify(obj.data.data[0].page))
        var list = obj.data.data
        var node = obj.data.data[0].page



        console.log("list:" + JSON.stringify(list[0]));
        that.setData({
          title: list[0].toptitle,
          author: list[0].author,
          date: list[0].toptime,
          icon_url: list[0].authoricon,
          article1:node
        })
        



        var article = node;
        /**
        * WxParse.wxParse(bindName , type, data, target,imagePadding)
        * 1.bindName绑定的数据名(必填)
        * 2.type可以为html或者md(必填)
        * 3.data为传入的具体数据(必填)
        * 4.target为Page对象,一般为this(必填)
        * 5.imagePadding为当图片自适应是左右的单一padding(默认为0,可选)
        */
        WxParse.wxParse('article', 'html', article, that, 5);





      },
      fail: function (err) {

      }
    })
    getReviewList(that)


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