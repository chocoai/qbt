angular.module("app.views")
.controller('couponBuyRecordCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  $scope.list = '';
  
  $scope.getList =function (num) {
    CommonService.pagination({
      url:'/ticketPackageOrder/findByPage.api',
      method:'post',
      data:{
        pageNo:num || 1,
        status:$scope.status,
        payStatus:$scope.getpay
      }
    }).then(function (data) {
      $scope.list = data.item;
      $scope.page = data.page;
    })
  };
  $scope.getList();
  //禁用或启用
  $scope.updateStatus = function (id,status) {
    CommonService.httpRequest({
      url:'/ticketPackageOrder/updateTicketPackageOrder.api',
      method:'post',
      data:{
        id:id,
        status:status===1?0:1,
      }
    }).then(function (data) {
      if(status===1){
        showInfo("禁用成功",function(){
          location.href = 'couponBuyRecord.html';
        });
      }
      else{
        showInfo("启用成功",function(){
          location.href = 'couponBuyRecord.html';
        });
      }
    })
  };
  
  $scope.goManyCoupon = function (id) {
    localStorage.setItem('managess',id);
    tabOpenParent({name:'couponToMany',url:'couponToMany.html',displayName:'多个券包'});
  };
  document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
      $('select').blur();
      $scope.getList();
    }
  };
}]);