"use strict";
angular.module("app.views")
.controller('invoiceCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
	$('body').niceScroll({cursorcolor:"#337ab7"});
	$scope.orderNumArr=[];

	$scope.billingStatus = Constants.billingStatus;
	$('.date-picker').datepicker({
	    format : 'yyyy-mm-dd',
	    autoclose: true
	});

	$scope.updateVipInfo = function(id){
    	tabOpenParent({name:'invoiceDetail_update'+id,url:'invoiceDetail.html?id=' + id,displayName:'发票详情'});

	}
	$scope.getList = function(num){
    	CommonService.pagination({
	        url : '/bill/findByPage.api',
	        data :{
		        pageNo : num || 1,
		        startTime : $("#startDate").val(),
		        endTime : $("#endDate").val(),
		        orderNumber : $scope.orderNum || "",
		        number : $("#invoiceNum").val(),
		        status : $scope.billStatus,
	        }
	    }).then(function(data){
	        $scope.list = data.item;
	        $scope.page = data.page;
	    });
	}

	$scope.export = function(){
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		if(startDate != ''){
			var start = new Date(startDate);
			var now = new Date();
			var end = new Date(endDate);
			if(start > now){
				layer.msg('申请开始日期不能大于当前日期');
				return;
			}
			if(endDate != ''){
				if(start > end){
					layer.msg('申请开始日期不能大于申请结束日期');
					return;
				}
			}
		}
		// var string = $("#invoiceNum").val();
		// if(string != ''){
		// 	if (string.length < 15){
		// 		layer.msg('请输入完整的发票号码');
		// 		return;
		// 	}
		// }
		window.open(rBasetUrl + '/billExport/export.api?token=' + localStorage.getItem('token') + '&startTime=' +
	    	 $("#startDate").val() + '&endTime=' + $("#endDate").val() + '&orderNumber='+($scope.orderNum || "")+
	    	 '&number='+$("#invoiceNum").val()+'&status='+$scope.billStatus);
	}

	$scope.seach = function(){
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		if(startDate != ''){
			var start = new Date(startDate);
			var now = new Date();
			var end = new Date(endDate);
			if(start > now){
				layer.msg('申请开始日期不能大于当前日期');
				return;
			}
			if(endDate != ''){
				if(start > end){
					layer.msg('申请开始日期不能大于申请结束日期');
					return;
				}
			}
		}
		// var string = $("#invoiceNum").val();
		// if(string != ''){
		// 	if (string.length < 15){
		// 		layer.msg('请输入完整的发票号码');
		// 		return;
		// 	}
		// }
		$scope.getList();
	}

	$scope.detail = function(id){
	    tabOpenParent({
	      name:'orderDetail' +id,
	      url:'orderDetail.html?id='+id,
	      displayName: '订单' + id
	    });
  	};

	$scope.billindFn = function(id,status){
		if(status!=1) return;
		$("#_invoiceNum").val("");
		layer.open({
	        type: 1,
	        title:'发票号码录入',
	        skin: 'layui-layer-rim', //加上边框
	        area: ['420px', '240px'], //宽高
	        content: $("#remark"),
	        btn:['确定','关闭'],
	        yes:function(index, layero){
	        	if($("#_invoiceNum").val() == ""){
	        		layer.msg('请先输入发票号码');
	        		return;
	        	}else{
	        		// if($("#_invoiceNum").val().length<15){
	        		// 	layer.msg('请先输入完整的发票号码');
	        		// 	return;
	        		// }
	        	}
	        	layer.close(index);
	        	CommonService.httpRequest({
			        url : '/bill/openBill.api',
			        method : 'get',
			        data :{
			          id : id,
			          number : $("#_invoiceNum").val()
			        }
			    }).then(function(data){
			    	$scope.getList();
			    });
	        }
        });
	}

	$scope.getList();

	$scope.getSplitorderNumber=function (orderNumber) {
		return orderNumber.split(',');
	}
}]);
