// pages/operation/operation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    id:undefined,
    name:'',
    location:'',
    addUrl:"http://192.168.1.102:8080/xcx/add",//新增URL
    modifyUrl:"http://192.168.1.102:8080/xcx/modify"//修改URL
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {//页面加载，注意理解和onShow的区别
    var that = this;
    this.setData({
      id: options.id
    });
    if (options.id == undefined){//区别新增还是修改，页面没有id表示新增，直接返回，否则要请求后台拿到需要修改的数据
      return;
    }
    wx.request({
      url: 'http://192.168.1.102:8080/xcx/findOneById',
      data: { "id": options.id },
      method:"GET",
      success:function(res){
        var shop = res.data;
        if (shop==undefined){
          var toastText="获取数据失败"+res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon:'',
            duration:2000
          });
        }else{
          that.setData({
            name:shop.name,
            location:shop.location
          });
        }
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
  /**
   * 新增和编辑
   */
  formSubmit:function(e){//e 表示表单
    //1、判断是新增还是修改造作
    var that = this;//初始化页面的值
    var formData = e.detail.value;//表单的值(id,name,location),拿到封装在formData里面
    var url = '';//局部变量url
    if(that.data.id != undefined){//如果需提交表单ID有值，则表示修改操作
      formData.id = that.data.id;//1、设置表单id
      url = that.data.modifyUrl;//2、设置请求路径为modify
    }else{//新增
      url = that.data.addUrl;//1、新增则设置新增路径add
    }

    //2、请求后台
    wx.request({
      url:url,
      data: {"id": formData.id,"name":formData.name,"location":formData.location},
      method:'POST',
      success:function(res){
        //2.1、接受后台返回信息
        var result=res.data.success;
        var toastText = '操作成功';
        if(result!=true){
          toastText = "操作失败"+res.data.errMsg;
        }

        //2.2、显示返回信息
        wx.showToast({
          title:toastText,
          icon:'',
          duration:2000
        });

        //2.3、新增和修改成功后都跳转列表页
        if (result == true){
          wx.redirectTo({
            url: '../list/list',
          })
        }
      }
    });
    //
  }
})