//index.js
//获取应用实例
var tcity = require("../../utils/citys.js");

var app = getApp()
Page({
  data: {
    provinces: [],
    province: "",
    citys: [],
    city: "",
    countys: [],
    county: '',
    value: [0, 0, 0],
    values: [0, 0, 0],
    condition: false,
    name:"",
    phone:"",
    area:"",
    items: [
      {name: 'USA', value: '北京'},
      {name: 'CHN', value: '中国', checked: 'true'},
      {name: 'BRA', value: '巴西'},
      {name: 'JPN', value: '日本'},
      {name: 'ENG', value: '英国'},
      {name: 'TUR', value: '法国'},
    ],
    arryArea:[],
    carId:"",
    address:"",
    
    address1:"",
    price1:"",
    inputName:"",
    inputPhone:"",
    chexbox:"",
    car_name:"",
    car_model:"",
    img_url:""
  },
  

  bindChange: function(e) {
    console.log("e:"+JSON.stringify(e));
    var val = e.detail.value
     console.log("val:"+e.detail.value)
    var t = this.data.values;
    console.log("t:"+this.data.values)
    var cityData = this.data.cityData;
    
    if(val[0] != t[0]){
      console.log('province no ');
      const citys = [];
      const countys = [];

      for (let i = 0 ; i < cityData[val[0]].sub.length; i++) {
        citys.push(cityData[val[0]].sub[i].name)
      }
      for (let i = 0 ; i < cityData[val[0]].sub[0].sub.length; i++) {
        countys.push(cityData[val[0]].sub[0].sub[i].name)
      }

      this.setData({
        province: this.data.provinces[val[0]],
        city: cityData[val[0]].sub[0].name,
        citys:citys,
        county: cityData[val[0]].sub[0].sub[0].name,
        countys:countys,
        values: val,
        value:[val[0],0,0]
        
      })
      

      return;
    }
    if(val[1] != t[1]){
      console.log('city no');
      const countys = [];

      for (let i = 0 ; i < cityData[val[0]].sub[val[1]].sub.length; i++) {
        countys.push(cityData[val[0]].sub[val[1]].sub[i].name)
      }
      
      this.setData({
        city: this.data.citys[val[1]],
        county: cityData[val[0]].sub[val[1]].sub[0].name,
        countys:countys,
        values: val,
        value:[val[0],val[1],0]
      })
      return;
    }
    if(val[2] != t[2]){
      console.log('county no');
      this.setData({
        county: this.data.countys[val[2]],
        values: val
      })
      return;
    }
    

  },
  open:function(){
    var that = this;
    this.setData({
      condition:!this.data.condition,
      address:this.data.province+"-"+this.data.city+"-"+this.data.county
    })
    console.log("address:"+this.data.address)
     wx.request({
   url: 'http://localhost:8080/wx_CarShop/UserCarServlet?method=0',
    data: { "carId": this.data.carId, "address":this.data.province},
    header: {
      "Content-type": "application/x-www-form-urlencoded"
    },
    method: 'post',
    success:function (res) {
        console.log("e:"+JSON.stringify(res))
        that.setData({
           address1:res.data.objlist
        })
       
        

    }
    
    })
    console.log("address1:"+JSON.stringify(this.data.address1) )
  },
  onLoad: function (options) {
    wx.setNavigationBarTitle({
      title: "询底价"
    })
     
    //console.log("id:"+JSON.stringify(options))
    this.setData({
      carId:options.id,
      car_name:options.car_name,
      car_model:options.car_model,
      img_url:options.img_url
    });
    
    console.log("id:"+this.data.carId)
   



    console.log("onLoad");
    var that = this;
    
    tcity.init(that);

    var cityData = that.data.cityData;

    
    const provinces = [];
    const citys = [];
    const countys = [];

    for(let i=0;i<cityData.length;i++){
      provinces.push(cityData[i].name);
    }
    console.log('省份完成');
    for (let i = 0 ; i < cityData[0].sub.length; i++) {
      citys.push(cityData[0].sub[i].name)
    }
    console.log('city完成');
    for (let i = 0 ; i < cityData[0].sub[0].sub.length; i++) {
      countys.push(cityData[0].sub[0].sub[i].name)
    }

    that.setData({
      'provinces': provinces,
      'citys':citys,
      'countys':countys,
      'province':cityData[0].name,
      'city':cityData[0].sub[0].name,
      'county':cityData[0].sub[0].sub[0].name
    })
    console.log('初始化完成');


  },
  userName:function(e){
      console.log("jj"+JSON.stringify(e))
      console.log("nn"+e.detail.value)
      this.setData({
         name:e.detail.value
      })
      console.log("vv"+this.data.name)
  },
  userPhone:function(e){
    console.log("hh"+JSON.stringify(e))
    this.setData({
         phone:e.detail.value
      })

  },
  userCity:function(e){
    console.log("gg"+JSON.stringify(e))
    this.setData({
         area:this.data.province+"-"+this.data.city
      })
    //console.log("area:"+this.data.area)
  },



  //询问价格的方法
  askPrice:function(e){
       var that= this
       if(this.data.name==""){
          wx.showToast({
          title: '名字不能为空',
          icon: 'success',
          duration: 3000,
          mask:true
        })
   
     }
      else if(this.data.phone==""){
          wx.showToast({
          title: '手机不能为空',
          icon: 'success',
          duration: 3000,
          mask:true
        })
     }
     else {
         wx.showToast({
          title: '询价成功,将以电话的形式联系你',
          icon: 'success',
          duration: 3000,
          mask:true
        })
        that.setData({
          inputName:e.detail.value.input1,
          inputPhone:e.detail.value.input2,
          chexbox:e.detail.checkbox
        })
        console.log("附带的value值为为："+JSON.stringify(e))
        console.log("input1:"+this.data.inputName)
       wx.request({
          url: 'http://localhost:8080/wx_CarShop/UserCarServlet?method=0',
            data: { 
              "userName": this.data.inputName, 
              "userPhone":this.data.inputPhone,
              "shops":this.data.chexbox,
              "carid":1
              },
            header: {
              "Content-type": "application/x-www-form-urlencoded"
            },
            method: 'post',
            success:function (res) {
                console.log("e:"+JSON.stringify(res))
               
                }
    
       })


     }
    
  },
  checkboxChange: function(e) {
    
    console.log("ss"+JSON.stringify(e))
    this.setData({
       arryArea:e.detail.value
    })
    console.log('checkbox发生change事件，携带value值为：'+ this.data.arryArea)
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
  }

})
