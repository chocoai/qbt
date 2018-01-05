/**
 * Created by Administrator on 2017/5/9.
 */
"use strict";
angular.module('app.views')
.controller('addPromoCtrl',['$scope','CommonService',function($scope,CommonService){
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  $scope.isLimit='-1';
  $scope.isWork="1";
  //限制次数改变input属性方法
  $scope.getCount=function(){
    if($scope.isLimit==='-1'){
      $('#promoCount').attr('readonly','readonly').val('');
    }else{
      $('#promoCount').removeAttr('readonly');
    }
  };
  //提交按钮
  $scope.addPromoCode=function(){
    if(!$scope.promoName){
      showWarn("优惠码名称不能为空");
      return false;
    }
    if(!$scope.startTime){
      showWarn("券码开始时间不能为空");
      return false;
    }
    if(!$scope.endTime){
      showWarn("券码结束时间不能为空");
      return false;
    }
    if(!$scope.enoughNum){
      showWarn("满的金额不能为空");
      return false;
    }else{
      if($scope.enoughNum>999999){
        showWarn("满的金额不能超过999999");
        return false;
      }
    }
    if(!$scope.cutNum){
      showWarn("减的金额不能为空");
      return false;
    }else {
      if($scope.cutNum>999999){
        showWarn("减的金额不能超过999999");
        return false;
      }
    }
    if($scope.startTime>$scope.endTime){
      showWarn('活动开始时间不能大于活动结束时间');
      return;
    }
    if($scope.enoughNum<0){
      showWarn('满的金额不能小于0');
      return false;
    }
    if($scope.cutNum<0){
      showWarn('减的金额不能小于0');
      return false;
    }
    if(/[\.]/.test($scope.enoughNum)){
      showWarn('满的金额不能包含小数点');
      return false;
    }
    if(/[\.]/.test($scope.cutNum)){
      showWarn('减的金额不能包含小数点');
      return false;
    }
    if(($scope.isLimit==='2')&&(!$scope.count)){
      showWarn('优惠次数不能为空');
      return false;
    }
    if(($scope.isLimit==='1'&&$scope.count>999999)||($scope.isLimit==='1'&&$scope.count<0)){
      showWarn('优惠次数不能大于999999或小于0');
      return false;
    }
    // if(($scope.isLimit==='2')&&){
    //   showWarn('优惠次数不能小于0');
    //   return false;
    // }
    CommonService.httpRequest({
      url:'/couponCodeActivity/add.api',
      method:'post',
      data:{
        count:$scope.isLimit==='-1'?-1:parseInt($scope.count),
        endTime:$scope.endTime,
        name:$scope.promoName,
        remark:$scope.remark,
        ruleFull:$scope.enoughNum,
        ruleReduce:$scope.cutNum,
        startTime:$scope.startTime,
        status:parseInt($scope.isWork)
      }
    }).then(function(data){
        showInfo('新增成功',function(){
          tabOpenParent({name:'promoCode',url:'promoCode.html',displayName:'优惠码活动'});
        });
    });
  };
  var id = localStorage.getItem('manages');
  console.log(id)
  $scope.getList=function(id){
    CommonService.httpRequest({
      url : '/couponCodeActivity/findById.api',
      method : 'get',
      data : {
        id : id
      }
    }).then(function(data){
      var manages = data.datas;
      $scope.id = manages.id;
      $scope.name = manages.name;
      $scope.startTime = manages.startTime;
      $scope.endTime = manages.endTime;
      $scope.enoughNum = manages.ruleFull;
      $scope.cutNum = manages.ruleReduce;
      $scope.isW = manages.status + '';
      $scope.isLimit = manages.counts;
      $scope.count = manages.count;
      $scope.remark = manages.remark;
    });
  };
  //根据id获取优惠码详情
  if(id){
    $scope.getList(id);
  }
  //提交修改
  $scope.updateList=function(){
    CommonService.httpRequest({
      method:'post',
      url:'/couponCodeActivity/updateById.api',
      data:{
        id:id,
        remark:$scope.remark,
        status:parseInt($scope.isW)
      }
    }).then(function(data){
      showInfo("更新成功",function(){
        tabOpenParent({name:'promoCode',url:'promoCode.html',displayName:'优惠码活动'});
      });
    });
    localStorage.removeItem('manages');
  };
}]);