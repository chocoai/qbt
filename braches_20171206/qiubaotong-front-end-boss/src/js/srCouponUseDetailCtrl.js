/**
 * Created by Administrator on 2017/8/24.
 */
angular.module("app.views")
.controller('srCouponUseDetailCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  $scope.bagNum = localStorage.getItem('bagCode') ? localStorage.getItem('bagCode') : '';
  $scope.endDate = '';
  $scope.keyWords = '';
  $scope.orderNo = '';
  $scope.startDate = '';
  $scope.isS = '';
  $scope.clearStartTime = function () {
    $scope.startDate = '';
  };
  $scope.clearEndTime = function () {
    $scope.endDate = '';
  };
  $scope.getList = function (num) {
    if($scope.startDate && $scope.endDate){
      if($scope.startDate>=$scope.endDate){
        showWarn('开始时间不能大于等于结束时间')
        return false
      }
    }
    CommonService.pagination({
      url : '/bagCodeOrder/findByPage.api',
      method : 'post',
      data: {
        bagCode : $scope.bagNum,
        endTime : $scope.endDate,
        keyword : $scope.keyWords,
        orderNumber : $scope.orderNo,
        startTime : $scope.startDate,
        status : $scope.isS!=='' ? parseInt($scope.isS) : '',
        pageNo : num || 1,
        pageSize : 10
      }
    }).then(function (data) {
      $scope.list = data.item;
      $scope.page = data.page;
      localStorage.removeItem('bagCode');
    })
  };
  $scope.getList();
  $scope.reportDownload = function () {
    if($scope.startDate!==''&&$scope.endDate!==''){
      if($scope.startDate >= $scope.endDate){
        showWarn('开始时间不能大于等于结束时间');
        return;
      }
    }
    $scope.startDate1 = ($scope.startDate!=='' ? $scope.startDate + ' 00:00:00':'');
    $scope.endDate1 = ($scope.endDate!=='' ? $scope.endDate + ' 00:00:00':'');
    window.open( rBasetUrl + '/bagCodeOrder/export.api?token=' + localStorage.getItem('token') + '&startTime=' +$scope.startDate1 + '&endTime=' +$scope.endDate1 + '&keyword=' + $scope.keyWords + '&orderNumber=' + $scope.orderNo + '&status=' + $scope.isS + '&bagCode=' + $scope.bagNum);
  };
  $scope.goOrder = function (id) {
    tabOpenParent({
      name:'orderDetail' +id,
      url:'orderDetail.html?id='+id,
      displayName: '订单' + id
    });
  }

  document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
      $('select').blur();
      $scope.getList();
    }
  };
}]);