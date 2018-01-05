"use strict";
angular.module("app.views")
.controller('orderEvalCtrl',['$scope','CommonService',function($scope,CommonService){
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $scope.list = [];
  $scope.status = '';
  $scope.getList = function(num){
    CommonService.pagination({
      url : '/comment/findByPage.api',
      data :{
        pageNo : num || "1",
        orderNumber : $scope.orderNumber,
        userName : $scope.userName,
        status : $scope.status
      }
    }).then(function(data){
     $scope.list = data.item;
     $scope.page = data.page;
   });
  }
  $scope.getList();

  $scope.orderEval = function(item){
    var itemStr=JSON.stringify(item);
    localStorage.setItem("manages", itemStr);
    tabOpenParent({name:'orderEvalDetail_check',url:'orderEvalDetail.html',displayName:'订单评价详情'});
  }
  $scope.updateOrderEval = function(item){
    var itemStr=JSON.stringify(item);
    localStorage.setItem("manages", itemStr);
    tabOpenParent({name:'orderEvalDetail_update',url:'orderEvalDetail.html',displayName:'订单评价审核'});

  };

  $scope.detail = function(id){
        tabOpenParent({
            name:'orderDetail' +id,
            url:'orderDetail.html?id='+id,
            displayName: '订单' + id
        });
    };

  document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getList();
               }
           };


}]);
