/**
 * Created by Administrator on 2017/9/6.
 */
angular.module("app.views")
.controller('earlyWarnDetailCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.deploys = [];
  $scope.id = localStorage.getItem('warn');
  $scope.getList = function () {
    CommonService.httpRequest({
      url : '/baseWarning/detail.api',
      method : 'get',
      data : {
        id : $scope.id
      }
    }).then(function (data) {
      var manages = data.datas;
      $scope.name = manages.name;
      $scope.num = manages.weight;
      $scope.remark = manages.remark;
      $scope.code = manages.code;
      $scope.deploys = manages.configs;
    });
  };
  $scope.getList();
  $scope.submitData = function () {
    if($scope.name===''){
      showWarn('预警名称不能为空');
      return false;
    }
    if($scope.num===''){
      showWarn('显示权重不能为空');
      return false;
    }else{
      if(parseInt($scope.num)>9){
        showWarn('显示权重不能大于9');
        return false;
      }
    }
    for(var i=0;i<$scope.deploys.length;i++){
      if($scope.deploys[i].name==='' || $scope.deploys[i].value===''){
        showWarn('配置项不能为空');
        return false;
      }
    }
    CommonService.httpRequest({
      url : '/baseWarning/update.api',
      method : 'post',
      data : {
        id : $scope.id,
        name : $scope.name,
        remark : $scope.remark,
        weight : parseInt($scope.num),
        configs : $scope.deploys
      }
    }).then(function (data) {
      showInfo('更新成功',function () {
        tabOpenParent({name: 'earlyWarn', url: 'earlyWarn.html', displayName: '预警管理'});
      });
    });
  };
}]);