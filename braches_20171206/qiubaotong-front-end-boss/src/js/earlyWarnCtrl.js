/**
 * Created by Administrator on 2017/9/6.
 */
angular.module("app.views")
.controller('earlyWarnCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.goDetail = function (id) {
    localStorage.setItem('warn',id);
    tabOpenParent({name:'earlyWarnDetail',url:'earlyWarnDetail.html',displayName:'预警详情'});
  };
  $scope.getList = function (num) {
    CommonService.pagination({
      url : '/baseWarning/findByPage.api',
      method : 'post',
      data : {
        pageNo : num || 1,
        pageSize :10,
        name : $scope.name,
        status : $scope.status ? parseInt($scope.status) : ''
      }
    }).then(function (data) {
        $scope.list = data.item;
        $scope.page = data.page;
    });
  };
  $scope.getList();
  $scope.updateStatus = function (id,state) {
    CommonService.httpRequest({
      url:'/baseWarning/updateStatus.api',
      method:'post',
      data:{
        id:id,
        status:state===1?2:1
      }
    }).then(function (data) {
      if(state===1){
        showInfo("禁用成功",function(){
          location.href = 'earlyWarn.html';
        });
      }
      else{
        showInfo("启用成功",function(){
          location.href = 'earlyWarn.html';
        });
      }
    });
  };
  document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
      $('select').blur();
      $scope.getList();
    }
  };
}]);