/**
 * Created by Administrator on 2017/6/30.
 */
angular.module("app.views")
.controller('qrcodeManageCtrl',['$scope','CommonService',function ($scope,CommonService) {
  $('body').niceScroll({cursorcolor: "#337ab7"});
  $scope.codeNm = '';
  $scope.identify = '';
  $scope.addCode = function () {
    localStorage.removeItem("manages");
    tabOpenParent({name:'addCode',url:'addCode.html',displayName:'新增渠道二维码'});
  };
  $scope.goCode = function (val) {
    localStorage.setItem('code',val);
    tabOpenParent({name:'userCheck',url:'userCheck.html',displayName:'微信用户查询'});
  };
  $scope.getList = function (num) {
    CommonService.pagination({
      url:'/channelQrcodeInfo/findByPage.api',
      method:'post',
      data:{
        pageNo:num||'1',
        name:$scope.codeNm,
        channelQrcodeCode:$scope.identify,
        remark:$scope.mark
      }
    }).then(function (data) {
      $scope.list=data.item;
      $scope.page=data.page;
    });
  };
  $scope.getList();
  $scope.updateCode = function (item) {
    localStorage.setItem("manages", item);
    tabOpenParent({name:'addCode',url:'addCode.html',displayName:'渠道二维码详情'});
  };
  $scope.updateStatus = function (id,state) {
    CommonService.httpRequest({
      url:'/channelQrcodeInfo/updateStatus.api',
      method:'get',
      data:{
        id : id,
        status : state===1?2:1
      }
    }).then(function (data) {
      if(state===1){
        showInfo("禁用成功",function(){
          location.href = 'qrcodeManage.html';
        });
      }
      else{
        showInfo("启用成功",function(){
          location.href = 'qrcodeManage.html';
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
