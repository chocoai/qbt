/**
 * Created by Administrator on 2017/8/8.
 */
angular.module("app.views")
.controller('channelDetailCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor: "#337ab7"});
  $scope.status = '1';
  var id = localStorage.getItem('manages');
  $scope.submitChannel = function () {
    if(!$scope.channelName || $scope.channelName===''){
      showWarn("渠道名称不能为空");
      return false;
    }
    if(!$scope.name || $scope.name===''){
      showWarn("姓名不能为空");
      return false;
    }
    if(!$scope.mobile || $scope.mobile===''){
      showWarn('电话不能不为空');
      return false
    }else{
      if($scope.mobile.length<10){
        showWarn('电话格式错误');
        return false
      }
    }
    if(!id){
      CommonService.httpRequest({
        url : '/thirdOrg/insert.api',
        method : 'post',
        data : {
          organizationName : $scope.channelName,
          status : parseInt($scope.status),
          contacts : $scope.name,
          mobile : $scope.mobile,
          messageUrl : $scope.orderInfo,
          remark : $scope.remark
        }
      }).then(function (data) {
        showInfo("新增成功", function () {
          tabOpenParent({name: 'thirdChannel', url: 'thirdChannel.html', displayName: '第三方渠道管理'});
        });
      })
    }else{
      CommonService.httpRequest({
        url : '/thirdOrg/update.api',
        method : 'post',
        data : {
          id : parseInt(id),
          organizationName : $scope.channelName,
          status : parseInt($scope.status),
          contacts : $scope.name,
          mobile : $scope.mobile,
          messageUrl : $scope.orderInfo,
          remark : $scope.remark
        }
      }).then(function (data) {
        showInfo("更新成功", function () {
          tabOpenParent({name: 'thirdChannel', url: 'thirdChannel.html', displayName: '第三方渠道管理'});
        });
      })
    }
    localStorage.removeItem('manages')
  };
  $scope.getList = function (id) {
    CommonService.httpRequest({
      url : '/thirdOrg/findById.api',
      method : 'get',
      data : {
        id :id
      }
    }).then(function (data) {
      var manages = data.datas;
      $scope.channelName = manages.organizationName;
      $scope.orderInfo = manages.messageUrl;
      $scope.name = manages.operatorName;
      $scope.mobile = manages.mobile;
      $scope.status = manages.status + '';
      $scope.remark = manages.remark;
    })
  };
  if(id){
    $scope.getList(id)
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