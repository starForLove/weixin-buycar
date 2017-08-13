// pages/configrtion/configrtion.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    titleName:"基本参数",
    arraylist: [
      {
      
       },
  
    
    ], 
   
   car_model:"",

    jumpY: 0,
   
  
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var id = options.id;
    this.setData({
      car_model:options.car_model
    })   

    wx.setNavigationBarTitle({
      title: options.car_model
    })


    console.log(JSON.stringify(options));
    //请求
    wx.request({
      url: 'http://localhost:8080/wx_CarShop/BuycarServlet?method=3&id=1',

      header: {
        "Content-type": "application/json"
      },
      method: 'POST',
      success: function (res) {
        var y = [];
        var i = 0;
        y.push({
          "brand_name": res.data.data[i].brandname,
          "car_name": res.data.data[i].carname,
          "factory_price": res.data.data[i].factoryprice,
          "least_price": res.data.data[i].leastprice,
          "companyname": res.data.data[i].companyname,
          "level": res.data.data[i].level,
          "date": res.data.data[i].date,
          "speed": res.data.data[i].speed,
          "engine": res.data.data[i].engine,
          "aidmoney": res.data.data[i].aidmoney,
          "gear_box": res.data.data[i].gearbox,
          "length": res.data.data[i].length,
          "height": res.data.data[i].height,
          "width": res.data.data[i].width,
          "structure": res.data.data[i].structure,
          "accelerate": res.data.data[i].accelerate,
          "oil_wear": res.data.data[i].oilwear,
          "oil_cost": res.data.data[i].oilcost,
          "wheelbase": res.data.data[i].wheelbase,
          "front_gauge": res.data.data[i].frontgauge,
          "back_gauge": res.data.data[i].backgauge,
          "mass": res.data.data[i].mass,
          "door_num": res.data.data[i].doornum,
          "seat_num": res.data.data[i].seatnum,
          "fuel_tank": res.data.data[i].fueltank,
          "output": res.data.data[i].output,
          "cylinder_num": res.data.data[i].cylindernum,
          "horsepower": res.data.data[i].horsepower,
          "capacity": res.data.data[i].capacity,
          "mass": res.data.data[i].mass,
          "fuel": res.data.data[i].fuel,
          "fuel_model": res.data.data[i].fuelmodel,
          "env_standards": res.data.data[i].envstandards,
          "gear_box_name": res.data.data[i].gearboxname,
          "gear_num": res.data.data[i].gearnum,
          "gear_box_style": res.data.data[i].gearboxstyle,
          "drive_system": res.data.data[i].drivesystem,
          "power_type": res.data.data[i].powertype,
          "carbody_structure": res.data.data[i].carbodystructure,
          "front_brake": res.data.data[i].frontbrake,
          "back_brake": res.data.data[i].backbrake,
          "parking_brake": res.data.data[i].parkingbrake,
          "front_tyre": res.data.data[i].fronttyre,
          "back_tyre": res.data.data[i].backtyre,
          "spare_tire": res.data.data[i].sparetire,
          "structure": res.data.data[i].structure

           
        })

        that.setData({

          arraylist: y



        });

        console.log(JSON.stringify(y));
      },
      fail: function (err) {
        console.log("失败")
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function (obj) {
    

    
  
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
  scrollChange: function (obj) {
    //console.log(JSON.stringify(obj))
    console.log(obj.detail.scrollTop)
    var sh = obj.detail.scrollTop
    if (sh >= 0 && sh <= 800) {
      this.setData({
        titleName: "基本参数"
      })
    } else if (sh >= 800 && sh <= 1249) {
      this.setData({
        titleName: "车身"
      })
    } else if (sh >=1250 && sh <= 1749) {
      this.setData({
        titleName: "发动机"
      })
    } else if (sh >= 1750 && sh <= 2000) {
      this.setData({
        titleName: "变速箱"
      })
    }

  },
  
  
})



