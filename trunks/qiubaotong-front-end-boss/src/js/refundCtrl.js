"use strict";
angular.module("app.views")
.controller('refundCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight: true
    });

    $scope.list = [];
    $scope.search = {
        status : '',
        orderId : ''
    }

    $scope.getList = function(page){
            if($scope.startTime > $scope.endTime){
                showWarn('开始时间不能大于结束时间');
                return;
            }
        CommonService.pagination({
        	url : '/refund/findByPage.api',
        	data :{
        		pageNo : page || 1,
                orderNumber : $scope.search.orderId,
                status : $scope.search.status,
                startTime : $scope.startTime || '',
                endTime : $scope.endTime || '',
            }
        }).then(function(data){
        	$scope.list = data.item;
        	$scope.page = data.page;
        });
    };
    $scope.getList();

    $scope.update = function(id){
        layer.confirm("确认已处理该退款?",function(index){
            CommonService.httpRequest({
                url : '/refund/update.api',
                method : 'post',
                data : {
                    id : id
                }
            }).then(function(){
                $scope.getList();
            });
            layer.close(index);
        })
    };
    $scope.orderDetail = function(id){
        tabOpenParent({
            name:'orderDetail' +id,
            url:'orderDetail.html?id='+id,
            displayName: '订单' + id
        });
    };
    //导出
    $scope.refundDownload = function(){
    	if(!$scope.startTime || !$scope.endTime){
            showWarn('开始时间和结束时间不能为空');
            return;
        }
    	else{
            if($scope.startTime > $scope.endTime){
                showWarn('开始时间不能大于结束时间');
                return;
            }
            $scope.startDate1 = $scope.startTime + ' 00:00:00';
            $scope.endDate1 = $scope.endTime + ' 00:00:00';
	    	window.open(rBasetUrl + '/orderRefund/export.api?token=' + localStorage.getItem('token') + '&startDate=' + $scope.startDate1 +
	    	 '&endDate=' + $scope.endDate1 + '&orderNumber=' + $scope.search.orderId + '&status=' + $scope.search.status );
   		}
    }

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if(e && e.keyCode==13){ // enter 键
            $('select').blur();
            $('#search').focus();
            $scope.getList();
        }
    };

}]);
