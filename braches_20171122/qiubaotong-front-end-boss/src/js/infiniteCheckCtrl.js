/**
 * Created by Administrator on 2017/8/8.
 */
angular.module("app.views")
.controller('infiniteCheckCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.addCheck = function () {
    tabOpenParent({name:'infiniteCheckDetail',url:'infiniteCheckDetail.html',displayName:'新增现金券活动'})
  }
  $scope.getList = function(num){
    CommonService.pagination({
      url : '/activity/findByPage.api',
      data :{
        pageNo : num || "1",
        name : $scope.activityName,
        type:2
      }
    }).then(function(data){
      $scope.list = data.item;
      $scope.page = data.page;
    });
  }
  $scope.getList(1);
  // 修改状态
  $scope.updateStatus = function (id,state) {
    CommonService.httpRequest({
      url:'/activity/updateStatus.api',
      method:'post',
      data:{
        id:id,
        status:state===1?2:1
      }
    }).then(function (data) {
      if(state===1){
        showInfo("禁用成功",function(){
          location.href = 'infiniteCheck.html';
        });
      }
      else{
        showInfo("启用成功",function(){
          location.href = 'infiniteCheck.html';
        });
      }
    })
  };

  document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
      $('select').blur();
      $scope.getList();
    }
  };
}]);