"use strict";
angular.module("app.views")
.controller('vipTypeDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.id = CommonService.getQueryString('id') || '';
    $scope.status = '1';
    $scope.getList = function(num){
    	CommonService.httpRequest({
    		method : 'get',
    		url : '/vipType/findById.api',
    		data:{
    			id : $scope.id
    		}
    	}).then(function(data){
    		var messages = data.datas;
    		$scope.amount = messages.amount;
    		$scope.name = messages.name;
    		$scope.orderAmount = messages.orderAmount;
    		$scope.status = messages.status + '';
    		$scope.valid = messages.valid;
    		$scope.validDesc = messages.validDesc;
            $scope.rules = messages.rules;
    	});
    }
    if(!!$scope.id){
    	$scope.getList();
    }

    $scope.addVipType = function(){
        if(!$scope.name){
            showWarn("会员卡类型名称不能为空");
            return false;
        }
        if(!$scope.amount){
            showWarn("购买金额不能为空或0");
            return false;
        }
        else{
            if($scope.amount > 999999999){
                showWarn('购买金额过大');
                return false;
            }
        }
        if(!$scope.orderAmount){
            showWarn("下单金额不能为空或0");
            return false;
        }
        else{
            if($scope.orderAmount > 999999999){
                showWarn('下单金额过大');
                return false;
            }
        }
        if(!$scope.valid){
            showWarn("有效期不能为空或0");
            return false;
        }
        else if($scope.valid > 999999999){
            showWarn('有效期过大');
            return false;
        }
        else {
            if(String($scope.valid).indexOf('.') != -1){
                showWarn('有效期需为整数');
                return false;
            }
        }
        if(!$scope.validDesc){
            showWarn("有效期描述不能为空");
            return false;
        }
        if(!$scope.rules){
            showWarn('细则不能为空');
            return false;
        }

    	if(!$scope.id){
    		CommonService.httpRequest({
	            method : 'post',
	            url : '/vipType/add.api',
	            data:{
	            	amount : $scope.amount,
	            	name : $scope.name,
	            	orderAmount : $scope.orderAmount,
	            	status : $scope.status,
	            	valid : $scope.valid,
	            	validDesc : $scope.validDesc,
                    rules : $scope.rules
	            }
	        }).then(function(data){
                showInfo("新增成功",function(){
                     tabOpenParent({name:'vipType',url:'vipType.html',displayName:'会员卡类型查询'});
                });
            });
    	}
    }

}]);
