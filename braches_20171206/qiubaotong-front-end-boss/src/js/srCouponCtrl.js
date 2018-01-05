/**
 * Created by Administrator on 2017/8/22.
 */
angular.module("app.views")
.controller('srCouponCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  $scope.addSr = function () {
    localStorage.removeItem('manages');
    tabOpenParent({name:'srCouponDetail',url:'srCouponDetail.html',displayName:'新增包包码'});
  };
  $scope.goViper = function (id) {
    localStorage.setItem('bagId',id);
    tabOpenParent({name:'srCouponUser',url:'srCouponUser.html',displayName:'包包码用户明细'});
  };
  $scope.goUseDetail = function (obj) {
    localStorage.setItem('bagCode',obj);
    tabOpenParent({name:'srCouponUseDetail',url:'srCouponUseDetail.html',displayName:'包包码使用管理'});
  };
  $scope.goDetail = function (id) {
    localStorage.setItem('manages',id);
    tabOpenParent({name:'srCouponDetail',url:'srCouponDetail.html',displayName:'包包码详情'});
  }
  $scope.clearStartTime = function () {
    $scope.startDate = '';
  };
  $scope.clearEndTime = function () {
    $scope.endDate = '';
  }
  $scope.getList = function (num) {
    if($scope.startDate && $scope.endDate){
      if($scope.startDate>=$scope.endDate){
        showWarn('开始时间不能大于等于结束时间')
        return false
      }
    }
    CommonService.pagination({
      url : '/bagCodePartner/findByPage.api',
      method : 'post',
      data : {
        endTime : $scope.endDate,
        keyword : $scope.keyWord,
        pageNo : num || 1,
        pageSize : 10,
        startTime : $scope.startDate,
        status : $scope.status
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