/**
 * Created by Administrator on 2017/9/11.
 */
angular.module("app.views")
.controller('eventManageCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.goDetail = function (id) {
    localStorage.setItem('event',id);
    tabOpenParent({name:'eventManageDetail',url:'eventManageDetail.html',displayName:'事件详情'});
  };
  $scope.addEvent = function () {
    localStorage.removeItem('event');
    tabOpenParent({name:'eventManageDetail',url:'eventManageDetail.html',displayName:'新增事件'});
  };
  $scope.getList = function (num) {
    CommonService.pagination({
      url : '/baseEvent/findByPage.api',
      method : 'post',
      data : {
        name : $scope.name,
        status : $scope.status ? parseInt($scope.status) : '',
        pageNo : num || 1,
        pageSize : 10
      }
    }).then(function (data) {
      $scope.list = data.item;
      $scope.page = data.page;
    });
  };
  $scope.getList();
  $scope.updateStatus = function (id,state) {
    CommonService.httpRequest({
      url:'/baseEvent/updateStatus.api',
      method:'post',
      data:{
        id:id,
        status:state===1?2:1
      }
    }).then(function (data) {
      if(state===1){
        showInfo("禁用成功",function(){
          location.href = 'eventManage.html';
        });
      }
      else{
        showInfo("启用成功",function(){
          location.href = 'eventManage.html';
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