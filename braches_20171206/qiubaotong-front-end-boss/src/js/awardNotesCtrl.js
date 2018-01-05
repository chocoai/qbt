/**
 * Created by Administrator on 2017/7/12.
 */
angular.module("app.views")
.controller('awardNotesCtrl',['$scope','CommonService',function ($scope,CommonService) {
  $('body').niceScroll({cursorcolor: "#337ab7"});
  var id = localStorage.getItem('award');
  $scope.getList = function (num) {
    CommonService.httpRequest({
      url:'/rewardActitvity/findWinnerListByPage.api',
      method:'post',
      data:{
        pageNo:num||'1',
        rewardActivityId:id,
        status:$scope.status
      }
    }).then(function (data) {
      $scope.list = data.datas;
      $scope.page = data.page;
    })
  };
  $scope.getList();
  document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
      $('select').blur();
      $scope.getList();
    }
  };
}]);