"use strict";
angular.module("app.views")
.controller('orderChangeCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight:true
    });

    $scope.list = [];
    $scope.search = {
        startTime : '',
        endTime : ''
    }
    $scope.getList = function(page){
        if(!!$scope.search.startTime && !!$scope.search.startTime){
            if($scope.search.startTime > $scope.search.startTime){
                showWarn('开始时间不能大于结束时间');
                return;
            }
        }
        CommonService.pagination({
        	url : '/orderChangeBook/findByPage.api',
        	data :{
        		pageNo : page || 1,
                orderNumber : $scope.search.orderNum || '',
                mailNo : $scope.search.mailNo || '',
                startTime : $scope.search.startTime && new Date(($scope.search.startTime + ' 00:00:00').replace(/-/g,"/")).getTime(),
                endTime : $scope.search.endTime && new Date(($scope.search.endTime + ' 00:00:00').replace(/-/g,"/")).getTime()
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
