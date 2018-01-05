"use strict";
angular.module("app.views")
.controller('vipBuyRecordDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.id = CommonService.getQueryString('id') || '';
    $scope.getList = function(num){
    	CommonService.httpRequest({
    		method : 'get',
    		url : '/vipOrder/findById.api',
    		data:{
    			id : $scope.id
    		}
    	}).then(function(data){
    		var messages = data.datas;
    		$scope.mobile = messages.mobile;
    		$scope.name = messages.name;
        $scope.vipNo = messages.vipNo;
    		$scope.number = messages.number;
    		$scope.payAmount = messages.payAmount;
    		$scope.payBakNo = messages.payBakNo;
    		$scope.payId = messages.payId;
    		$scope.payMethod = messages.payMethod;
    		$scope.payNumber = messages.payNumber;
    		$scope.settlementStatus = messages.settlementStatus;
    		$scope.updateTime = messages.updateTime;
    		$scope.userName = messages.userName;
    		$scope.valid = messages.valid;
    		$scope.validDesc = messages.validDesc;
        $scope.vipCardType = messages.vipCardType;
    		$scope.salesmanName = messages.salesmanName;
    	});
    }
    if(!!$scope.id){
    	$scope.getList();
    }

    $scope.changeSettlementStatus = function(){
        CommonService.httpRequest({
            method : 'get',
            url : '/vipOrder/upSettlement.api',
            data:{
                id : parseInt($scope.id)
            }
        }).then(function(data){
            showInfo('操作成功',function(){
                $scope.getList();
            });
        });
    };
    $scope.layerChangeSettlementStatus = function(){
        layer.confirm('确认收款吗?', {icon: 3, title:'提示'}, function(index){
          $scope.changeSettlementStatus();
          layer.close(index);
        },function(index){
            layer.close(index);
        });
    };

}]);
