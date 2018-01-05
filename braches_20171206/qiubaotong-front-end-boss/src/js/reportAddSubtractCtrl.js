"use strict";
angular.module("app.views")
.controller('reportAddSubtractCtrl',['$scope','CommonService',function($scope,CommonService){
	$('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight : true
    });
    $scope.clearStartTime = function(){
        $scope.startDate = '';
    }
    $scope.clearEndTime = function(){
        $scope.endDate = '';
    }
    // $scope.startDate = new Date().Format('yyyy-MM-dd');
    // $scope.endDate = new Date().Format('yyyy-MM-dd');

    $scope.getList = function(num){
		if($scope.startDate > $scope.endDate){
			showWarn('开始时间不能大于结束时间');
			return;
		}
        CommonService.pagination({
        	url : '/orderCostItem/findByPage.api?token=' + localStorage.getItem('token'),
            baseUrl : rBasetUrl,
        	data :{
        		pageNo : num || "1",
				startDate:$scope.startDate,
                endDate:$scope.endDate,

            }
        }).then(function(data){
        	$scope.list = data.item;
        	$scope.page = data.page;
        });
    }
    // $scope.getList(1);


	$scope.reportDownload = function(){
    	if(!$scope.startDate || !$scope.endDate){
            showWarn('开始时间和结束时间不能为空');
            return;
        }
    	else{
            if($scope.startDate > $scope.endDate){
                showWarn('开始时间不能大于结束时间');
                return;
            }
            $scope.startDate1 = $scope.startDate + ' 00:00:00';
            $scope.endDate1 = $scope.endDate + ' 00:00:00';
	    	window.open(rBasetUrl + '/orderCostItem/export.api?token=' + localStorage.getItem('token') + '&startDate=' + $scope.startDate1 +
	    	 '&endDate=' + $scope.endDate1);
   		}
    }

    $('#search').focus();
    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
                 if(e && e.keyCode==13){ // enter 键
                    $('select').blur();
                   $scope.getList();
               }
           };

}]);
