angular.module("app.views")
.controller('couponToManyCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  $scope.list = '';
  $scope.activityId = parseInt(localStorage.getItem('managess'));
  $scope.getList =function (id) {
    CommonService.httpRequest({
      url:'/ticketPackageOrder/detail.api',
      methods:'get',
      data:{
        id : $scope.activityId,
      }
    }).then(function (data) {
      $scope.manages = data.datas;
      $scope.list = data.datas.userActivityOrderDetailVos;
    })
  };
  $scope.getList();

  //禁用或启用
  $scope.updateStatus = function (id,status) {
    CommonService.httpRequest({
      url:'/ticketPackageOrder/updateTicketPackageOrderDetail.api',
      method:'post',
      data:{
        id:id,
        status:status===1?0:1
      }
    }).then(function (data) {
      if(status===1){
        showInfo("禁用成功",function(){
          location.href = 'couponToMany.html';
        });
      }
      else{
        showInfo("启用成功",function(){
          location.href = 'couponToMany.html';
        });
      }
    })
  };
  
  $scope.goDetail = function (ticketVos) {
    var ticketVosJson = JSON.stringify(ticketVos);
    localStorage.setItem('ticketDetail',ticketVosJson);
    tabOpenParent({name:'couponDetail',url:'couponDetail.html',displayName:'券包详情'});
  };
}]);