"use strict";
angular.module("app.views")
.controller('fullOrderDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    var window_url = window.location.search;
    $scope.activityId = window_url.substring(window_url.indexOf('=') + 1,window_url.length);
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/orderActivityBook/findByPage.api',
            data :{
                pageNo : num || "1",
                activityId : $scope.activityId,
                activityName : $scope.activityName,
                orderId : $scope.orderName
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    };
    $scope.detail = function(id){
        tabOpenParent({
            name:'orderDetail' +id,
            url:'orderDetail.html?id='+id,
            displayName: '订单' + id
        });
    };
    $scope.getList();

}]);
