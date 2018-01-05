/**
 * Created by Administrator on 2017/8/8.
 */
angular.module("app.views")
.controller('thirdChannelCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor: "#337ab7"});
  $scope.status = '';
  $scope.addChannel = function () {
    localStorage.removeItem('manages');
    tabOpenParent({name:'channelDetail',url:'channelDetail.html',displayName:'新增渠道'})
  }
  $scope.goUserList = function (id) {
    sessionStorage.setItem('thirdId',id)
    tabOpenParent({name:'userCheck',url:'userCheck.html',displayName:'微信用户查询'})
  }
  $scope.goOrderList = function (id) {
    sessionStorage.setItem('thirdId',id)
    tabOpenParent({name:'orderMgr',url:'orderMgr.html',displayName:'订单查询'})
  }
  // 点击进入详情
  $scope.goDetail = function (id) {
    localStorage.setItem('manages',id)
    tabOpenParent({name:'channelDetail',url:'channelDetail.html',displayName:'渠道详情'})
  }
  $scope.getList = function (num) {
    CommonService.pagination({
      url:'/thirdOrg/findByPage.api',
      method:'post',
      data:{
        pageNo : num || 1,
        organizationName : $scope.channelName,
        status : $scope.status ? parseInt($scope.status) : '',
        contacts : $scope.name
      }
    }).then(function (data) {
      $scope.list = data.item;
      $scope.page = data.page;
    })
  };
  $scope.getList();

  document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
      $('select').blur();
      $scope.getList();
    }
  };
}]);