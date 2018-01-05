/**
 * Created by Administrator on 2017/8/1.
 */
angular.module("app.views")
.controller('addGroupUserCtrl',['$scope','CommonService',function ($scope,CommonService) {
  $('body').niceScroll({cursorcolor: "#337ab7"});
  var groupId = localStorage.getItem('groupId');
  var userId = localStorage.getItem('groupUser');
  $scope.getList = function (id) {
    CommonService.httpRequest({
      url:'/orgGroupUser/detail.api',
      method:'get',
      data:{
        id:id
      }
    }).then(function (data) {
      var manages = data.datas;
      $scope.id = manages.id;
      $scope.groupUser = manages.name;
      $scope.phoneNum = manages.mobile;
      $scope.remark = manages.remark;
      $scope.status = manages.status + '';
    })
  }
  if(userId){
    $scope.getList(userId);
  }
  $scope.submitData = function () {
    if(!$scope.groupUser){
      showWarn('用户姓名不能为空');
      return false
    }
    if(!$scope.phoneNum){
      showWarn("联系电话不能为空");
      return false;
    }
    // if(!(/^1[34578]\d{9}$/.test($scope.phoneNum))||!(/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/.test($scope.phoneNum))) {
    // if(!/\d/.test($scope.phoneNum)){
    if($scope.phoneNum.length<10){
      showWarn("联系电话格式不对");
      return false;
    }
    if(!userId){
      CommonService.httpRequest({
        url:'/orgGroupUser/add.api',
        method:'post',
        data:{
          mobile:$scope.phoneNum,
          name:$scope.groupUser,
          orgId:parseInt(groupId),
          remark:$scope.remark
        }
      }).then(function (data) {
        showInfo('新增成功',function () {
          tabOpenParent({name: 'groupUserDetail', url: 'groupUserDetail.html', displayName: '机构用户详情'});
        })
      })
    }else{
      CommonService.httpRequest({
        url:'/orgGroupUser/update.api',
        method:'post',
        data:{
          id:userId,
          mobile:$scope.phoneNum,
          name:$scope.groupUser,
          orgId:groupId,
          remark:$scope.remark
        }
      }).then(function (data) {
        showInfo('更新成功',function () {
          tabOpenParent({name: 'groupUserDetail', url: 'groupUserDetail.html', displayName: '机构用户详情'});
        })
      })
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
  }
  window.mouseBlur = function (obj) {

  }
}]);