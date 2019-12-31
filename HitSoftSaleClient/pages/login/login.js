// pages/login/login.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    client_id: null,
    client_pass: null
  },

  login: function() {
    if (this.data.client_id == null || this.data.client_id == "") {
      wx.showModal({
        title: '请输入用户名'
      })
    } else if (this.data.client_pass == null || this.data.client_pass == "") {
      wx.showModal({
        title: '请输入密码'
      })
    } else {
      wx.request({
        url: app.globalData.host + '/sale/login/client/' + this.data.client_id + "/" + this.data.client_pass,
        data: {},
        header: {
          'context-type': 'application/json'
        },
        success(res) {
          console.log(res.data)
          if (res.data == ""){
            wx.showModal({
              title: '用户名或密码错误'
            })
          }else{
            app.globalData.userId = res.data.client_id
            app.globalData.userName = res.data.client_name
            app.globalData.userWallet = res.data.wallet
            app.globalData.userPoint = res.data.points
            wx.redirectTo({
              url: '../product/product',
            })
            wx.switchTab({
              url: '../product/product',
            })
          }
          
        }
      })
    }
  },

  usernameInput: function(e) {
    this.setData({
      client_id: e.detail.value
    })
  },

  passwordInput: function(e) {
    this.setData({
      client_pass: e.detail.value
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