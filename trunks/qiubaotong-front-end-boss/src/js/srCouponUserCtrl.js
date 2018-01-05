/**
 * Created by Administrator on 2017/8/24.
 */
angular.module("app.views")
.controller('srCouponUserCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor: "#337ab7"});
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  $scope.bagId = localStorage.getItem('bagId');
  $scope.startDate = '';
  $scope.endDate = '';
  $scope.keyWord = '';
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
      url : '/bagCodeUser/findByPage.api',
      method : 'post',
      data : {
        bagCodePartnerId : $scope.bagId,
        endTime : $scope.endDate,
        keyword : $scope.keyWord,
        startTime : $scope.startDate,
        pageNo : num || 1,
        pageSize : 10
      }
    }).then(function (data) {
      $scope.list = data.item;
      $scope.page = data.page;
    })
  };
  $scope.getList();
  $scope.goWechat = function(id,nickname){
    localStorage.removeItem('bagId');
    tabOpenParent({name:'userCheckDetail'+id,url:'userCheckDetail.html?id='+id,displayName:nickname + '详情'});
  };
  $scope.reportDownload = function () {
    if($scope.startDate!==''&&$scope.endDate!==''){
      if($scope.startDate >= $scope.endDate){
        showWarn('开始时间不能大于等于结束时间');
        return;
      }
    }
    $scope.startDate1 = ($scope.startDate!=='' ? $scope.startDate + ' 00:00:00':'');
    $scope.endDate1 = ($scope.endDate!=='' ? $scope.endDate + ' 00:00:00':'');
    window.open( rBasetUrl + '/bagCodeUser/export.api?token=' + localStorage.getItem('token') + '&startTime=' +$scope.startDate1 + '&endTime=' +$scope.endDate1 + '&keyword=' + $scope.keyWord + '&bagCodePartnerId=' +$scope.bagId);
  };

  document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
      $('select').blur();
      $scope.getList();
    }
  };
}]);