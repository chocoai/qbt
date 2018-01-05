"use strict";
angular.module("app.views")
.controller('vipCardSetRecordDetailCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});

    $scope.vipCardActiveType = Constants.vipCard_active_type;
    $scope.vipCreateId = CommonService.getQueryString('vipCreateId');
    $scope.vipNo = CommonService.getQueryString('vipNo') || '';
    $scope.isSelect = false;
    $scope.allCheck = false;
    $scope.ids = [];
    $scope._list = [];
    $scope.__list = [];
    $scope.updateVipCard = {
    	ids : [],
    	payAmount : '',
    	payMethod : ''
    };

    $scope.list = [];

    $scope.getResetList = function(num){
        $scope.allCheck = false;
        $scope._list = [];
        $scope.__list = [];
        CommonService.pagination({
            url : '/vipCreateInfo/findByPage.api',
            data :{
                pageNo : num || "1",
                vipNo : $scope.vipNo || '',
                sellStatus : $scope.sellStatus,
                activateStatus : $scope.activateStatus,
                status : $scope.status,
                vipCreateId: $scope.vipCreateId,
                pageSize: 30
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
            $scope.ids = [];
            $scope.list.forEach(function(i){
                $scope.ids.push(i.id);
            });
        });
    };

    $scope.getList = function(num){
        $scope.listNum = num;
        CommonService.pagination({
            url : '/vipCreateInfo/findByPage.api',
            data :{
                pageNo : num || "1",
                vipNo : $scope.vipNo || '',
                sellStatus : $scope.sellStatus,
                activateStatus : $scope.activateStatus,
                status : $scope.status,
                vipCreateId: $scope.vipCreateId,
                pageSize: 30
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
            $scope.ids = [];
            $scope.list.forEach(function(i){
            	$scope.ids.push(i.id);
            });
            if($scope.__list.length > 0){
                //跳不同页
                if($scope.list[0].id != $scope.__list[0].id){
                    $scope.updateVipCard.ids = [];
                    $scope.allCheck = false;
                }
                //跳同一页
                else{
                    for(var i = 0; i < $scope.list.length; i++){
                        $scope.list[i].isSelect = $scope.__list[i].isSelect;
                    }
                }
            }
        });
    }
    $scope.getList();

    $scope.selectId = function(id){
    	var idx = $scope.updateVipCard.ids.indexOf(id);
    	if(idx == -1){
    		$scope.updateVipCard.ids.push(id);
    	}
    	else{
    		$scope.updateVipCard.ids.splice(idx,1);
    	}

        if($scope.updateVipCard.ids.length == $scope.ids.length){
            $scope.allCheck = true;
        }
        else{
            $scope._list = angular.copy($scope.list);
            $scope.allCheck = false;
        }

    }

    $scope.$watch('allCheck',function(newVal,oldVal){

        if(newVal){
            $scope.list.forEach(function(index){
                index.isSelect = true;
            });
            $scope.updateVipCard.ids = angular.copy($scope.ids);
        }
        else{
            if($scope._list.length > 0){
                $scope.list = $scope._list;
            }
            else{
                $scope.list.forEach(function(index){
                    index.isSelect = false;
                });
                $scope.updateVipCard.ids = [];
            }
        }
        $scope._list = [];

    });

    $scope.updateVipCards = function(){

    	if($scope.updateVipCard.ids.length == 0){
    		showWarn('请勾选需要更新的实体卡');
    		return;
    	}
        if((!$scope.updateVipCard.payAmount && $scope.updateVipCard.payAmount !== 0) && !$scope.updateVipCard.payMethod){
            showWarn('支付金额和支付方式需选择一个');
            return false;
        }
        if($scope.updateVipCard.payAmount){
        	if(!(/^([1-9][\d]{0,5}|0)(\.[\d]{1,2})?$/.test($scope.updateVipCard.payAmount))){
        		showWarn('金额为0~99999.99');
        		return;
        	}
        }
        var sureMsg = '批量';
        if($scope.updateVipCard.ids.length == 1){
            sureMsg = '';
        }
        else{
            sureMsg = '批量';
        }

    		CommonService.httpRequest({
    			url: '/vipCreateInfo/updateBatch.api',
    			method: 'post',
    			data: {
    				ids: $scope.updateVipCard.ids,
    				payAmount: $scope.updateVipCard.payAmount,
    				payMethod: $scope.updateVipCard.payMethod
    			}
    		}).then(function(){
    			showInfo(sureMsg + '更新成功',function(){
                    $scope.__list = angular.copy($scope.list);
    				$scope.getList($scope.listNum);
    			});
    		});

    }

    $scope.payAmountChange = function(){
        if($scope.updateVipCard.payAmount <= 0){
            $scope.updateVipCard.payMethod = '';
        }
    }


    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getResetList();
               }
           };

}]);
