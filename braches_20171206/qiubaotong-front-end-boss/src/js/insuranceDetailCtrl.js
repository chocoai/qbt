"use strict";
angular.module("app.views")
.controller('insuranceDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.state = '1';
    $scope.getList = function(num){
       var manages = localStorage.getItem('manages');
       if(manages != '' && manages != null){
	       manages = JSON.parse(manages);
	       $scope.id = manages.id;
	       $scope.name = manages.name;
	       $scope.insuredRates = manages.insuredRates;
	       $scope.insuredOriginRates = manages.insuredOriginRates;
	       $scope.freeInsured = manages.freeInsured;
	       $scope.insuredMinimum = manages.insuredMinimum;
	       $scope.insuredMaximum = manages.insuredMaximum;
	       $scope.descInsuredMinimum = manages.descInsuredMinimum;
	       $scope.descInsuredMaximum = manages.descInsuredMaximum;
	       $scope.state = manages.state + '';
	       $scope.remark = manages.remark;
       }
    }

    $scope.getList();

    $scope.addInsurance = function(){
    	if(!$scope.name){
            showWarn("保价名称不能为空");
            return false;
        }
        if(!$scope.insuredRates && $scope.insuredRates != 0){
            showWarn("保价费率不能为空");
            return false;
        }
        else if($scope.insuredRates >= 1){
            showWarn("保价费率为0到1之间");
            return false;
        }
        else{
            var insuredRatesString = $scope.insuredRates + '';
            var insuredRatesLength = insuredRatesString.substring(insuredRatesString.indexOf('.')+1,insuredRatesString.length);
            if(insuredRatesLength.length > 3){
                showWarn("保价率小数点后不能超过3位");
                return false;
            }
        }
        if(!$scope.insuredOriginRates || $scope.insuredOriginRates < 0){
          showWarn("原保价费率不能为空或小于0");
          return false;
        }
        else if($scope.insuredOriginRates>=1){
            showWarn("原保价费率为0到1之间");
            return false;
        }
        else {
          var insuredOriginRatesString = $scope.insuredOriginRates + '';
          var insuredOriginRatesLength = insuredOriginRatesString.substring(insuredOriginRatesString.indexOf('.')+1,insuredOriginRatesString.length);
          if(insuredOriginRatesLength.length > 3){
            showWarn("原保价率小数点后不能超过3位");
            return false;
          }
        }
        if(!$scope.freeInsured && $scope.freeInsured != 0){
            showWarn("免费保价金额不能为空");
            return false;
        }
        else{
            if($scope.freeInsured > 999999999.99){
                showWarn("免费保价金额不能大于999999999.99");
                return false;
            }
        }
        if(!$scope.insuredMinimum && $scope.insuredMinimum != 0){
            showWarn("最小保价金额不能为空");
            return false;
        }
        else{
            if($scope.insuredMinimum > 999999999.99){
                showWarn("最小保价金额不能大于999999999.99");
                return false;
            }
        }
        if(!$scope.insuredMaximum && $scope.insuredMaximum != 0){
            showWarn("最大保价金额不能为空");
            return false;
        }
        else{
            if($scope.insuredMaximum > 999999999.99){
                showWarn("最大保价金额不能大于999999999.99");
                return false;
            }
        }
        if(!$scope.state){
            showWarn("状态不能为空");
            return false;
        }

    	if(!$scope.id){
    		CommonService.httpRequest({
	            method : 'post',
	            url : '/baseInsTemp/add.api',
	            data:{
	            	name : $scope.name,
	            	insuredRates : parseFloat($scope.insuredRates),
                insuredOriginRates : parseFloat($scope.insuredOriginRates),
	            	freeInsured : parseFloat($scope.freeInsured),
	            	insuredMinimum : parseFloat($scope.insuredMinimum),
	            	insuredMaximum : parseFloat($scope.insuredMaximum),
	            	descInsuredMinimum : $scope.descInsuredMinimum,
	            	descInsuredMaximum : $scope.descInsuredMaximum,
	            	state : parseInt($scope.state),
	            	remark : $scope.remark
	            }
	        }).then(function(data){
                showInfo("新增成功",function(){
                     tabOpenParent({name:'insurance',url:'insurance.html',displayName:'保价管理'});
                });
            });
    	}
    	else{
    		CommonService.httpRequest({
	            method : 'post',
	            url : '/baseInsTemp/updateById.api',
	            data:{
	            	id : parseInt($scope.id),
	            	name : $scope.name,
	            	insuredRates : parseFloat($scope.insuredRates),
                insuredOriginRates : parseFloat($scope.insuredOriginRates),
	            	freeInsured : parseFloat($scope.freeInsured),
	            	insuredMinimum : parseFloat($scope.insuredMinimum),
	            	insuredMaximum : parseFloat($scope.insuredMaximum),
	            	descInsuredMinimum : $scope.descInsuredMinimum,
	            	descInsuredMaximum : $scope.descInsuredMaximum,
	            	state : parseInt($scope.state),
	            	remark : $scope.remark
	            }
	        }).then(function(data){
                showInfo("更新成功",function(){
                    tabOpenParent({name:'insurance',url:'insurance.html',displayName:'保价管理'});
                });
            });
            localStorage.removeItem('manages');
    	}
    }

}]);
