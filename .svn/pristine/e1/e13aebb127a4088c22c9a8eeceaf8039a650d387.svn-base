"use strict";
angular.module("app.views")
.controller('paymentListCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.payMethodType = Constants.payMethod_type;
    $scope.payStatusType = Constants.payStatus_type;

    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight : true
    });
    $scope.clearStartTime = function(){
        $scope.startDate = '';
    }
    $scope.clearEndDate = function(){
        $scope.endDate = '';
    }
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/payment/findByPage.api',
            data :{
                pageNo : num || "1",
                startDate : $scope.startDate,
                endDate : $scope.endDate,
                uuid : $scope.uuid,
                orderNumber : $scope.orderNumber,
                payMethod : $scope.payMethod,
                status : $scope.status,
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

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
