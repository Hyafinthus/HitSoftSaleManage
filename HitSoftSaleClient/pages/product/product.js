// pages/product.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  addProduct: function(e) {
    // console.log(e.target.id)
    // console.log(app.globalData.orderProduct)
    // console.log(app.globalData.resData)
    if (app.globalData.userId == null) {
      wx.navigateTo({
        url: '../login/login',
        success: function(res) {},
        fail: function(res) {},
        complete: function(res) {},
      })
    } else {
      if (app.globalData.products == null) {
        var products = []
        var product = {}
        product.product_id = e.target.id;
        product.count = 1
        products.push(product)
        wx.showToast({
          title: '添加成功！',
        })
        app.globalData.products = products
      } else {
        var hasPro = false;
        for (var i = 0; i < app.globalData.products.length; i++) {
          if (app.globalData.products[i].product_id == e.target.id) {
            for (var j = 0; j < app.globalData.resData.length; j++) {
              if (app.globalData.resData[j].product_id == app.globalData.products[i].product_id) {
              if (app.globalData.resData[j].count > app.globalData.products[i].count) {
                app.globalData.products[i].count += 1
                wx.showToast({
                  title: '添加成功！',
                })
              }
            }
          }
          hasPro = true;
          break;
        }
      }
      if (!hasPro) {
        var product = {}
        product.product_id = e.target.id;
        product.count = 1
        wx.showToast({
          title: '添加成功！',
        })
        app.globalData.products.push(product)
      }
    }
  }
  console.log(app.globalData.products)
},

/**
 * 生命周期函数--监听页面加载
 */
onLoad: function(options) {
  

  // var str = '[{"bonus": 0,"count": 43,"order_id": 0,"product_id": 9,"product_name": "IPHONEX",           "purchase_price": 1000,"retail_price": 0,"type": "手机","unit": "盒","wholesale_price": 6000}, {"bonus": 0,    "count": 178,"order_id": 0,"product_id": 10,"product_name": "IPHONE8","purchase_price": 4000,"retail_price": 0,    "type": "手机","unit": "盒","wholesale_price": 5000}]'
  // console.log(JSON.parse(str))
  // that.setData({
  //   list: JSON.parse(str)
  // })
  // app.globalData.resData = JSON.parse(str)


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
  var that = this;
  wx.request({
    url: app.globalData.host + '/sale/client/search/products?page=1&limit=10000000',
    data: {
      x: '',
      y: ''
    },
    header: {
      'context-type': 'application/json'
    },
    success(res) {
      console.log(res.data.data)
      app.globalData.resData = res.data.data
      that.setData({
        list: res.data.data
      })
    }
  })
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