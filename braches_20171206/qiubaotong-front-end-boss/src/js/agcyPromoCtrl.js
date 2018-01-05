/**
 * Created by Administrator on 2017/7/28.
 */
angular.module("app.views")
.controller('agcyPromoCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  $scope.list = '';
  $scope.goUserList = function (id) {
    localStorage.setItem('groupId',id);
    tabOpenParent({name:'groupUserDetail',url:'groupUserDetail.html',displayName:'机构用户'});
  };
  $scope.addGroup = function () {
    localStorage.removeItem('manages');
    tabOpenParent({name:'agcyDetail',url:'agcyDetail.html',displayName:'新增机构'});
  };
  // 清除选择时间
  $scope.clearStartTime = function(){
    $scope.startDate = '';
  }
  $scope.clearEndTime = function(){
    $scope.endDate = '';
  }
  $scope.getList =function (num) {
    if($scope.startDate && $scope.endDate ){
      if($scope.startDate > $scope.endDate){
        showWarn('开始时间不能大于结束时间');
        return false;
      }
    }
    CommonService.pagination({
      url:'/orgGroup/findByPage.api',
      method:'post',
      data:{
        pageNo:num || 1,
        endDate:$scope.endDate,
        name:$scope.agcy,
        startDate:$scope.startDate,
        status:$scope.status
      }
    }).then(function (data) {
      $scope.list = data.item;
      $scope.page = data.page;
    })
  };
  $scope.getList();
  $scope.updateStatus = function (id,state) {
    CommonService.httpRequest({
      url:'/orgGroup/updateStatus.api',
      method:'post',
      data:{
        id:id,
        status:state===1?2:1
      }
    }).then(function (data) {
      if(state===1){
        showInfo("禁用成功",function(){
          location.href = 'agcyPromo.html';
        });
      }
      else{
        showInfo("启用成功",function(){
          location.href = 'agcyPromo.html';
        });
      }
    })
  };
  $scope.deleteGroup = function (id) {
    CommonService.httpRequest({
      url:'/orgGroup/delete.api',
      method:'get',
      data:{
        id:id
      }
    }).then(function (data) {
      showInfo('删除成功',function () {
        $scope.getList(1);
      })
    })
  };
  $scope.goGroupList = function (id) {
    localStorage.setItem('orgId',id);
    tabOpenParent({name:'groupOrder',url:'groupOrder.html',displayName:'机构订单查询'});
  };
  $scope.goDetail = function (id) {
    localStorage.setItem('manages',id);
    tabOpenParent({name:'agcyDetail',url:'agcyDetail.html',displayName:'机构详情'});
  };
  document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
      $('select').blur();
      $scope.getList();
    }
  };
}]);