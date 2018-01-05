/**
 * Created by Administrator on 2017/6/30.
 */
angular.module("app.views")
.controller('getAwardCtrl',['$scope','CommonService',function ($scope,CommonService) {
  $('body').niceScroll({cursorcolor: "#337ab7"});
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  $scope.awardNm = '';
  $scope.getAward = '';
  $scope.awardType = '';
  $scope.beginTime = '';
  $scope.endTime = '';
  $scope.getList = function (num) {
    CommonService.pagination({
      url:'/rewardActitvity/findByPage.api',
      method:'post',
      data:{
        pageNo:num||'1',
        actitvityName:$scope.awardNm,
        actitvityType:$scope.getAward,
        rewardType:$scope.awardType,
        startDate:$scope.beginTime,
        endDate:$scope.endTime
      }
    }).then(function (data) {
      $scope.list = data.item;
      $scope.page=data.page;
    });
  };
 $scope.getList();
 $scope.addAward = function () {
   localStorage.removeItem('manages');
   tabOpenParent({name:'awardDetail',url:'awardDetail.html',displayName:'新增中奖活动'});
 };
 $scope.updateAward = function (item) {
   localStorage.setItem("manages",item);
   tabOpenParent({name:'awardDetail',url:'awardDetail.html',displayName:'修改中奖活动'});
 };
 $scope.goNotes = function (obj) {
   localStorage.setItem('award',obj);
   tabOpenParent({name:'awardNotes',url:'awardNotes.html',displayName:'中奖活动记录'});
 };
 document.onkeydown=function(event){
   var e = event || window.event || arguments.callee.caller.arguments[0];
   if(e && e.keyCode==13){ // enter 键
     $('select').blur();
     $scope.getList();
   }
 };
}]);