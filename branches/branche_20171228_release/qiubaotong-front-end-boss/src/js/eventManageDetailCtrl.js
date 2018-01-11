/**
 * Created by Administrator on 2017/9/11.
 */
angular.module('app.views')
.controller('eventManageDetailCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.type = '1';
  var id = localStorage.getItem('event');
  $scope.submitData = function () {
    if($scope.name===''){
      showWarn('事件名称不能为空');
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
    if(!id){
      CommonService.httpRequest({
        url : '/baseEvent/add.api',
        method : 'post',
        data : {
          name : $scope.name,
          remark : $scope.remark,
          type : parseInt($scope.type),
          weight : parseInt($scope.num)
        }
      }).then(function (data) {
        showInfo('新增成功',function () {
          tabOpenParent({name: 'eventManage', url: 'eventManage.html', displayName: '事件管理'});
        });
      });
    }else{
      CommonService.httpRequest({
        url : '/baseEvent/update.api',
        method : 'post',
        data : {
          id : id,
          name : $scope.name,
          remark : $scope.remark,
          type : parseInt($scope.type),
          weight : parseInt($scope.num)
        }
      }).then(function (data) {
        showInfo('更新成功',function () {
          tabOpenParent({name: 'eventManage', url: 'eventManage.html', displayName: '事件管理'});
        });
      });
      localStorage.removeItem('event');
    }
  };
  $scope.getList = function (id) {
    CommonService.httpRequest({
      url : '/baseEvent/detail.api',
      method : 'get',
      data :{
        id : id
      }
    }).then(function (data) {
      var manages = data.datas;
      $scope.name = manages.name;
      $scope.num = manages.weight;
      $scope.remark = manages.remark;
      $scope.type = manages.type + '';
    });
  };
  if(id){
    $scope.getList(id);
  }
}]);