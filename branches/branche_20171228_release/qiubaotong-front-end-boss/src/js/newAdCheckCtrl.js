/**
 * Created by Administrator on 2017/10/10.
 */
angular.module("app.views")
.controller("newAdCheckCtrl",['$scope','CommonService','Constants','$timeout',function ($scope,CommonService,Constants,$timeout) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.getList = function(num){
    CommonService.pagination({
      url : '/baseAdvert/findByPage.api',
      data :{
        pageNo : num || "1",
        name : $scope.name,
        status : $scope.status,
        flatType: $scope.type ? parseInt($scope.type) : ''
      }
    }).then(function(data){
      $scope.list = data.item;
      $scope.page = data.page;
    });
  };
  $scope.getList();
  // 更改状态 --0禁用1启用
  $scope.updateStatus = function (id,state) {
    CommonService.httpRequest({
      url:'/baseAdvert/updateStatus.api',
      method:'get',
      data:{
        id:id,
        status:state===1?0:1
      }
    }).then(function (data) {
      if(state===0){
        showInfo("启用成功",function(){
          location.href = 'newAdCheck.html';
        });
      }
      else{
        showInfo("禁用成功",function(){
          location.href = 'newAdCheck.html';
        });
      }
    });
  };
  $scope.goDetail = function (id) {
    localStorage.setItem('advertId',id);
    tabOpenParent({name:'newAdCheckDetail',url:'newAdCheckDetail.html',displayName:'广告位详情'});
  };

  document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
      $('select').blur();
      $scope.getList();
    }
  };
}]);