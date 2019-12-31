// pages/client/client.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    money: null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

  },

  validate: function(num) {
    var reg = /^\d+(?=\.{0,1}\d+$|$)/
    if (reg.test(num)) return true;
    return false;
  },

  save_money: function() {
    if (!this.validate(this.data.money)){
      wx.showModal({
        title: '请输入数字',
      })
      return;
    }
    var that = this
    var client = {}
    client.client_id = app.globalData.userId
    client.wallet = parseInt(this.data.money)
    wx.request({
      url: app.globalData.host + '/sale/client/save/money',
      method: "POST",
      data: client,
      header: {
        "Content-Type": "application/json;charset=UTF-8"
      },
      success(res) {
        console.log(res)
        wx.showModal({
          title: '充值成功'
        })
        that.data.money = 0
        that.setData({
          inpuv:""
        })
        that.updata_client()
      }
    })
  },

  p2m: function() {
    var that = this
    wx.request({
      url: app.globalData.host + '/sale/client/points_for_cash/' + app.globalData.userId,
      data: {
        x: '',
        y: ''
      },
      header: {
        'context-type': 'application/json'
      },
      success(res) {
        if (res.data.status == 500) {
          wx.showModal({
            title: '无可提现积分',
          })
        } else {
          wx.showToast({
            title: '提现成功',
          })
        }
        that.updata_client()
      }
    })
  },

  updata_client: function() {
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
        that.onShow()
      }
    })
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
      var sum = app.globalData.userWallet.toString()
      if (sum.indexOf(".") != -1) {
        sum = sum.substring(0, sum.indexOf(".") + 3);
      }
      this.setData({
        client_name: app.globalData.userName,
        client_wallet: sum,
        client_point: app.globalData.userPoint,
      })
    }

  },

  moneyInput: function(e) {
    this.setData({
      money: e.detail.value
    })
    console.log(this.validate(this.data.money))
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