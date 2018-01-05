/**
 * Created by Administrator on 2017/8/22.
 */
angular.module("app.views")
.controller('srCouponDetailCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  $scope.mobile = '';
  $scope.status = '1';
  $scope.isJ = 'true';
  $scope.isRandom = 'false';
  $scope.statusId = '';
  var id = localStorage.getItem('manages');

  $scope.getAward = function () {
    CommonService.httpRequest({
      url:'/rewardActitvity/findCurrentCoupon.api',
      method:'get',
      data:{
        type:2
      }
    }).then(function (data) {
      $scope.coupon = data.datas;
    });
  };
  $scope.getAward();
  $scope.submitSr = function () {
    if(!$scope.groupName || $scope.groupName===''){
      showWarn("合作机构名称不能为空");
      return false;
    }
    if(!$scope.startDate || !$scope.endDate){
      showWarn("时间选择不能为空");
      return false;
    }else{
      if($scope.startDate>=$scope.endDate){
        showWarn("开始时间不能大于等于结束时间");
        return false;
      }
    }
    // if(!$scope.name || $scope.name=== ''){
    //   showWarn("联系人不能为空");
    //   return false;
    // }
    if($scope.mobile!==''){
      if($scope.mobile.length<10){
        showWarn("电话格式错误");
        return false;
      }
    }
    if(!$scope.bagNum || $scope.bagNum ===''){
      showWarn("包包码不能为空");
      return false;
    }else{
      if($scope.bagNum.length!==3){
        showWarn("包包码必须为3位数");
        return false;
      }
    }
    if(!$scope.award || $scope.award===''){
      showWarn("券活动不能为空");
      return false;
    }
    if(!id){
      CommonService.httpRequest({
        url : '/bagCodePartner/add.api',
        method : 'post',
        data : {
          activityId : parseInt($scope.award),
          bagCode : 'sr'+$scope.bagNum,
          contact : $scope.name,
          endDate : $scope.endDate,
          mobile : $scope.mobile,
          name : $scope.groupName,
          remark : $scope.remark,
          sameInfo : eval($scope.isJ),
          senderRandom : eval($scope.isRandom),
          startDate : $scope.startDate
        }
      }).then(function (data) {
        showInfo("新增成功", function () {
          tabOpenParent({name: 'srCoupon', url: 'srCoupon.html', displayName: '包包码管理'});
        });
      })
    }else{
      CommonService.httpRequest({
        url : '/bagCodePartner/update.api',
        method : 'post',
        data : {
          activityId : parseInt($scope.award),
          contact : $scope.name,
          endDate : $scope.endDate,
          id : id,
          mobile : $scope.mobile,
          name : $scope.groupName,
          remark : $scope.remark,
          startDate : $scope.startDate,
          status : parseInt($scope.status)
        }
      }).then(function (data) {
        showInfo("更新成功", function () {
          tabOpenParent({name: 'srCoupon', url: 'srCoupon.html', displayName: '包包码管理'});
        });
      })
      localStorage.removeItem('manages')
    }
  };
  $scope.getList = function (id) {
    CommonService.httpRequest({
      url : '/bagCodePartner/detail.api',
      method : 'get',
      data : {
        id : id
      }
    }).then(function (data) {
      var manages = data.datas;
      $scope.statusId = manages.id;
      $scope.groupName = manages.name;
      $scope.bagNo = manages.bagCode.indexOf('sr')!==-1 ? manages.bagCode.substr(manages.bagCode.indexOf('sr')+2,3) : manages.bagCode;
      $scope.bagNum = manages.bagCode.indexOf('sr')!==-1 ? manages.bagCode.substr(manages.bagCode.indexOf('sr')+2,3) : manages.bagCode
      $scope.name = manages.contact;
      $scope.mobile = manages.mobile;
      $scope.award = manages.activityId + '';
      $scope.startDate = manages.startDateStr;
      $scope.endDate = manages.endDateStr;
      $scope.isR = manages.senderRandom ;
      $scope.isS = manages.sameInfo ;
      $scope.status = manages.status + '';
      $scope.remark = manages.remark;
    })
  };
  if(id){
    $scope.getList(id)
  }

  window.checkNum = function (obj) {
    if(!obj.value || obj.value ===''){
      showWarn("包包码不能为空");
      $('#bagCode').focus()
      return false;
    }else{
      if(obj.value.length!==3){
        showWarn("包包码必须为3位数");
        $('#bagCode').focus()
        return false;
      }
    }
  }
  /*输入控制两位小数-start*/
  window.keyUpTwoDecimal = function(obj){
    obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符
    obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的
    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数
    // if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额
    //   obj.value= parseFloat(obj.value);
    // }
    $(obj).trigger("change");
  };
}]);