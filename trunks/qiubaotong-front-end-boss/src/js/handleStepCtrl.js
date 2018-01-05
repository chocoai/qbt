/**
 * Created by Administrator on 2017/9/7.
 */
angular.module("app.views")
.controller('handleStepCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.addHandle = function () {
    localStorage.removeItem('manage');
    tabOpenParent({name:'handleStepDetail',url:'handleStepDetail.html',displayName:'新增处理步骤'});
  };
  $scope.goDetail = function (id) {
    localStorage.setItem('manage',id);
    tabOpenParent({name:'handleStepDetail',url:'handleStepDetail.html',displayName:'处理步骤详情'});
  };
  $scope.selectObj = function (type) {
    if(type!== ''){
      CommonService.httpRequest({
        url : '/baseHandle/listByType.api',
        method : 'get',
        data : {
          type : parseInt(type),
        }
      }).then(function (data) {
        $scope.objs = data.datas;
        $scope.handleObj = '';
      });
    }else{
      $scope.handleObj = '';
      $scope.objs = '';
    }
  };
  $scope.getList = function (num) {
    CommonService.pagination({
      url : '/baseHandle/findByPage.api',
      method : 'post',
      data : {
        pageNo : num || 1,
        name : $scope.handleNm,
        objectName : $scope.handleObj?$scope.handleObj.split('|')[1]:'',
        status : $scope.status,
        type : $scope.handleType?parseInt($scope.handleType):''
      }
    }).then(function (data) {
        $scope.list = data.item;
        $scope.page = data.page;
    });
  };
  $scope.getList();
  $scope.updateStatus = function (id,state) {
    CommonService.httpRequest({
      url:'/baseHandle/updateStatus.api',
      method:'get',
      data:{
        id:id,
        status:state===1?2:1
      }
    }).then(function (data) {
      if(state===1){
        showInfo("禁用成功",function(){
          location.href = 'handleStep.html';
        });
      }
      else{
        showInfo("启用成功",function(){
          location.href = 'handleStep.html';
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