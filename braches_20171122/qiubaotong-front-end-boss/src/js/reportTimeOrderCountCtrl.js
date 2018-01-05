"use strict";
angular.module("app.views")
.controller('reportTimeOrderCountCtrl',['$scope','CommonService',function($scope,CommonService){
	$('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight : true
    });
    $('.datePicker').datetimepicker({
	    format: 'yyyy-mm-dd hh:00:00',
	    autoclose: true,
        minView : 1,
        maxView : 1
	});
    $scope.clearStartTime = function(){
        $scope.startTime = '';
    }
    $scope.clearEndTime = function(){
        $scope.endTime = '';
    }
    $scope.clearOrderStartTime = function(){
    	$scope.orderStartTime = '';
    }
    $scope.clearOrderEndTime = function(){
    	$scope.orderEndTime = '';
    }
    $scope.startTime = new Date().Format('yyyy-MM-dd');
    $scope.endTime = new Date().Format('yyyy-MM-dd');
    $scope.orderStartTime = new Date().Format('yyyy-MM-dd hh:00:00');
    $scope.orderEndTime = new Date().Format('yyyy-MM-dd hh:00:00');

    $scope.getList = function(num){
        CommonService.pagination({
        	url : '/orderUserCountTime/findByPage.api?token=' + localStorage.getItem('token'),
        	baseUrl:rBasetUrl,
            data :{
        		pageNo : num || "1",
                startDate : $scope.startTime,
                endDate : $scope.endTime,
                sendSfStartTime:$scope.orderStartTime,
                sendSfEndTime:$scope.orderEndTime

            }
        }).then(function(data){
        	$scope.list = data.item;
        	$scope.page = data.page;
        });
    };
    // $scope.getList(1);


    $scope.reportDownload = function(){
    	if(!$scope.startTime || !$scope.endTime){
            showWarn('开始时间和结束时间不能为空');
            return;
        }
    	else{
            if($scope.startTime > $scope.endTime){
                showWarn('开始时间不能大于结束时间');
                return;
            }
            $scope.startTime1 = $scope.startTime + ' 00:00:00';
            $scope.endTime1 = $scope.endTime + ' 00:00:00';
	    	window.open(rBasetUrl + '/orderUserCountTime/export.api?token=' + localStorage.getItem('token') 
                + '&startDate=' + $scope.startTime1 
                + '&endDate=' + $scope.endTime1 
                + '&sendSfStartTime=' + $scope.orderStartTime 
                + '&sendSfEndTime=' + $scope.orderEndTime);
   		}
    }

    $('#search').focus();
    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getList();
               }
           };

}]);
