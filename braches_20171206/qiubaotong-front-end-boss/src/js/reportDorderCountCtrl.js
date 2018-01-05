"use strict";
angular.module("app.views")
.controller('reportDorderCountCtrl',['$scope','CommonService',function($scope,CommonService){
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
        	url : '/orderUserCount/findByPage.api?token=' + localStorage.getItem('token'),
        	baseUrl:rBasetUrl,
            data :{
        		pageNo : num || "1",
                startDate : $scope.startTime,
                endDate : $scope.endTime
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
	    	window.open(rBasetUrl + '/orderUserCount/export.api?token=' + localStorage.getItem('token') + '&startDate=' + $scope.startTime1 +
	    	 '&endDate=' + $scope.endTime1 + '&isFirst=' + $scope.isFirst + 
	    	 '&orderStatus=' + $scope.orderStatus + '&isFavored=' + $scope.isFavored + '&expressType=' + $scope.expressType);
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
