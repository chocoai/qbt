"use strict";
angular.module("app.views")
.controller('reportOrderDetailCtrl',['$scope','CommonService',function($scope,CommonService){
	$('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight : true
    });
    $scope.clearStartTime = function(){
        $scope.startTime = '';
    }
    $scope.clearEndTime = function(){
        $scope.endTime = '';
    }
    $scope.startTime = new Date().Format('yyyy-MM-dd');
    $scope.endTime = new Date().Format('yyyy-MM-dd');

    $scope.getList = function(num){
        CommonService.pagination({
        	url : '/orderSituation/findByPage.api?token=' + localStorage.getItem('token'),
            baseUrl:rBasetUrl,
        	data :{
        		pageNo : num || "1",
                startDate:$scope.startTime,
                endDate:$scope.endTime
            }
        }).then(function(data){
        	$scope.list = data.item;
        	$scope.totalOrder = 0; // 总订单数
        	$scope.effectiveTotalOrder = 0; // 有效的总订单数
          $scope.waitTotalPay = 0; // 待付款的总订单数
          $scope.destroyTotalOrder = 0; // 无效的总订单数
          $scope.cancelTotalOrder = 0; // 取消的总订单数
        	for(var i = 0; i < $scope.list.length; i++){
            $scope.totalOrder = $scope.totalOrder + $scope.list[i].total;
            $scope.effectiveTotalOrder = $scope.effectiveTotalOrder +$scope.list[i].effectiveOrder
            $scope.waitTotalPay = $scope.waitTotalPay +$scope.list[i].waitPay;
            $scope.destroyTotalOrder = $scope.destroyTotalOrder +$scope.list[i].destroyOrder;
            $scope.cancelTotalOrder = $scope.cancelTotalOrder +$scope.list[i].cancelOrder;
          }
        	$scope.page = data.page;
        });
    }
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
	    	window.open(rBasetUrl + '/orderSituation/export.api?token=' + localStorage.getItem('token') + '&startDate=' + $scope.startTime1 +
	    	 '&endDate=' + $scope.endTime1);
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
