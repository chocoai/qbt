/**
 * Created by Administrator on 2017/6/30.
 */
angular.module("app.views")
.controller('awardDetailCtrl',['$scope','CommonService',function ($scope,CommonService) {
  $('body').niceScroll({cursorcolor: "#337ab7"});
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  var reg = /^[0-9]*[1-9][0-9]*$/,
        id = localStorage.getItem('manages');
  $scope.addNew = function () {
    if(!$scope.awardName){
      showWarn("中奖活动名称不能为空");
      return false;
    }
    if(!$scope.beginTime){
      showWarn("中奖活动开始时间不能为空");
      return false;
    }
    if(!$scope.endTime){
      showWarn("中奖活动结束时间不能为空");
      return false;
    }
    if($scope.beginTime>$scope.endTime){
      showWarn('活动开始时间不能大于活动结束时间');
      return false;
    }
    if(!$scope.setAward){
      showWarn("中奖活动概率分子不能为空");
      return false;
    }else{
      if($scope.setAward<0 || $scope.setAward>10000|| !reg.test($scope.setAward)){
        showWarn("中奖活动概率分子必须为大于0或者小于10000的整数");
        return false;
      }
    }
    if(!$scope.getAward){
      showWarn("中奖活动类型不能为空");
      return false;
    }
    if(!$scope.awardType){
      showWarn("奖励类型不能为空");
      return false;
    }
    if(!$scope.awardThing){
      showWarn("奖励物品不能为空");
      return false;
    }
    if(!$scope.stateVal){
      showWarn("状态不能为空");
      return false;
    }
    if(!id){
      CommonService.httpRequest({
        url:'/rewardActitvity/insert.api',
        method:'post',
        data:{
          actitvityName:$scope.awardName,
          startDate:$scope.beginTime,
          endDate:$scope.endTime,
          actitvityType:parseInt($scope.getAward),
          rewardType:parseInt($scope.awardType),
          probability:parseInt($scope.setAward),
          prize:$scope.awardThing,
          status:parseInt($scope.stateVal),
          remark:$scope.remark
        }
      }).then(function (data) {
          showInfo('新增成功',function(){
          tabOpenParent({name:'getAward',url:'getAward.html',displayName:'中奖活动'});
        });
      });
    }else{
      CommonService.httpRequest({
        url:'/rewardActitvity/updateById.api',
        method:'post',
        data:{
          id:id,
          actitvityName:$scope.awardName,
          startDate:$scope.beginTime,
          endDate:$scope.endTime,
          actitvityType:parseInt($scope.getAward),
          rewardType:parseInt($scope.awardType),
          probability:parseInt($scope.setAward),
          prize:$scope.awardThing,
          status:parseInt($scope.stateVal),
          remark:$scope.remark
        }
      }).then(function (data) {
        showInfo("更新成功",function(){
          tabOpenParent({name:'getAward',url:'getAward.html',displayName:'中奖活动'});
        });
      });
      localStorage.removeItem('manages');
    }
  }
  $scope.getList = function(){
    CommonService.httpRequest({
      url : '/rewardActitvity/findById.api',
      method : 'get',
      data : {
        id : id
      }
    }).then(function(data){
      var manages = data.datas;
      $scope.id = manages.id;
      $scope.awardName = manages.actitvityName;
      $scope.beginTime= manages.sd;
      $scope.endTime = manages.ed;
      $scope.getAward = manages.actitvityType+'';
      $scope.awardType = manages.rewardType+'';
      $scope.stateVal = manages.status+'';
      $scope.setAward = manages.probability;
      $scope.awardThing = manages.prize;
      $scope.remark = manages.remark;
    });
  };
  if(id){
    $scope.aid = id;
    $scope.getList(id);
  }
  $scope.getCoupon = function () {
    CommonService.httpRequest({
      url:'/rewardActitvity/findCurrentCoupon.api',
      method:'get',
      data:{
        type:1
      }
    }).then(function (data) {
      $scope.coupon = data.datas;
    });
  };
  $scope.getCoupon();
}]);