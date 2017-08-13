// pages/viewPicture/viewPicture.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    imgList:[],
    font_color: ["gray", "gray", "gray", "gray", "gray"],
    car_model:"",
    price:0.0,
    carId:0,
    car_name:"",
    img_url:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(JSON.stringify(options))
    this.setData({
      car_model:options.car_model,
      price:options.price,
      carId:options.id,
      car_name:options.car_name,
      img_url:options.img_url
    })


    var that = this
    var xlist = ["white", "gray", "gray", "gray", "gray"]
    this.setData({
      font_color: xlist
    }) 
    wx.request({
      url: 'http://localhost:8080/wx_CarShop/CarViewPictureServlet?method=0&flag=exterior&car_model=' + that.data.car_model,
      data: { "name": "Tom", "password": 123 },
      header: {
        "Content-type": "application/x-www-form-urlencoded"
      },
      method: 'get',
      success: function (obj) {
        console.log(JSON.stringify(obj.data.data))
        var list = obj.data.data
        that.setData({
          imgList: list
        })

      },
      fail: function (err) {

      }
    })


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
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },
  click:function(obj){
    var sid = obj.target.id
    var flag
    if(sid==0){
      flag ="exterior"
    }else if(sid ==1){
      flag = "center"
    } else if (sid == 2) {
      flag = "chair"
    } else if (sid == 3) {
      flag = "other"
    } else if (sid == 4) {
      flag = "picinfo"
    }

    var xlist = ["gray", "gray", "gray", "gray", "gray"]
    xlist[obj.target.id] = "white"
    this.setData({
      font_color: xlist
    }) 

    var that=this

    wx.request({
      url: 'http://localhost:8080/wx_CarShop/CarViewPictureServlet?method=0&flag=' + flag+'&car_model='+that.data.car_model,
      data: { "name": "Tom", "password": 123 },
      header: {
        "Content-type": "application/x-www-form-urlencoded"
      },
      method: 'get',
      success: function (obj) {
        console.log(JSON.stringify(obj.data.data))
        var list = obj.data.data
        that.setData({
          imgList:list
        })

      },
      fail: function (err) {

      }
    })



  },
  askprice:function(){
    var that = this
    console.log("thattttttttttttttt"+JSON.stringify(that.options))
    wx.navigateTo({
      url: '../askPrice/askPrice?id=' + that.options.id + '&car_model=' + that.options.car_model + '&car_name=' + that.options.car_name + '&img_url=' + that.options.img_url,
    })
  }
})