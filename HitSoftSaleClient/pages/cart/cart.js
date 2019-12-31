// pages/cart/cart.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  updata_client: function () {
    var that = this
    wx.request({
      url: app.globalData.host + '/sale/client/search/client/' + app.globalData.userId,
      data: {
        x: '',
        y: ''
      },
      header: {
        'context-type': 'application/json'
      },
      success(res) {
        app.globalData.userPoint = res.data.points
        app.globalData.userWallet = res.data.wallet
      }
    })
  },

  updateData: function() {
    var sum = 0.0
    var temp_products = []
    for (var i = 0; i < app.globalData.products.length; i++) {
      for (var j = 0; j < app.globalData.resData.length; j++) {
        if (app.globalData.resData[j].product_id == app.globalData.products[i].product_id) {
          var product = {}
          product.product_id = app.globalData.resData[j].product_id
          product.product_name = app.globalData.resData[j].product_name
          product.num = app.globalData.resData[j].count
          product.count = app.globalData.products[i].count
          product.retail_price = app.globalData.resData[j].retail_price
          sum += product.count * product.retail_price
          temp_products.push(product)
          break;
        }
      }
    }
    sum = sum.toString()
    if (sum.indexOf(".") != -1) {
      sum = sum.substring(0, sum.indexOf(".") + 3);
    }
    this.setData({
      list: temp_products,
      sumup: sum
    })
  },

  addProduct: function(e) {
    var that = this
    console.log(e.target.id)
    for (var i = 0; i < app.globalData.products.length; i++) {
      if (app.globalData.products[i].product_id == e.target.id) {
        for (var j = 0; j < app.globalData.resData.length; j++) {
          if (app.globalData.resData[j].product_id == app.globalData.products[i].product_id) {
            if (app.globalData.resData[j].count > app.globalData.products[i].count) {
              app.globalData.products[i].count += 1
              this.updateData()
            }
          }
        }
        break;
      }
    }
  },

  reduceProduct: function(e) {
    var that = this
    console.log(e.target.id)
    for (var i = 0; i < app.globalData.products.length; i++) {
      if (app.globalData.products[i].product_id == -e.target.id) {
        app.globalData.products[i].count -= 1
        if (app.globalData.products[i].count == 0) {
          app.globalData.products.splice(i, 1)
        }
        this.updateData()
        break;
      }
    }
    this.onShow()
  },

  submit: function() {
    var that = this
    var orderProduct = {}
    orderProduct.client_id = app.globalData.userId
    orderProduct.products = app.globalData.products
    wx.request({
      url: app.globalData.host + '/sale/client/pay',
      data: orderProduct,
      method: "POST",
      header: {
        'context-type': 'application/json;charset=UTF-8'
      },
      success(res) {
        console.log(res)
        if (res.data == "success") {
          app.globalData.products = null;
          wx.showToast({
            title: '购买成功',
          })
          setTimeout(function() {
            wx.switchTab({
              url: '../product/product'
            })
          }, 1000)
          that.updata_client()
        } else {
          wx.showModal({
            title: '余额不足',
          })
        }
      }
    })

  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    if (app.globalData.userId == null) {
      wx.redirectTo({
        url: '../login/login',
      })
    } else {
      var that = this;
      if (app.globalData.products == null || app.globalData.products.length == 0) {
        this.setData({
          testtrue: true
        })
      } else {
        this.setData({
          testtrue: false
        })
        this.updateData()

      }
    }
  },



  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})