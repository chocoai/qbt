/**
 * Created by Administrator on 2017/8/8.
 */
angular.module('app.views')
.controller('infiniteCheckDetailCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.status = '1';
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  $scope.addCheck = function () {
    if(!$scope.checkName){
      showWarn('券活动名称不能为空')
      return false;
    }
    if($scope.check===''||!$scope.check){
      showWarn('优惠券金额不能为空')
      return false;
    }
    if (!$scope.startDate || !$scope.endDate){
      showWarn('券活动时间不能为空');
      return false;
    }else if($scope.startDate>=$scope.endDate){
      showWarn('券活动开始时间不能大于结束时间');
      return false;
    }
    if(!$scope.limitAmount || $scope.limitAmount==='' ){
      showWarn('券限制金额不能为空');
      return false;
    }
    if(!$scope.limitDate){
      showWarn('券限制天数不能为空');
      return false;
    }
    if(!$scope.status){
      showWarn('状态不能为空');
      return false;
    }
    CommonService.httpRequest({
      url:'/activity/add.api',
      method:'post',
      data:{
        activityEndTime:$scope.endDate,
        activityStartTime:$scope.startDate,
        couponAmount:$scope.check,
        couponLimitAmount:$scope.limitAmount,
        couponLimitDay:$scope.limitDate,
        status:$scope.status,
        type:2,
        name:$scope.checkName
      }
    }).then(function (data) {
      showInfo('新增成功',function () {
        tabOpenParent({name: 'infiniteCheck', url: 'infiniteCheck.html', displayName: '不限量现金券活动'});
      })
    })
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