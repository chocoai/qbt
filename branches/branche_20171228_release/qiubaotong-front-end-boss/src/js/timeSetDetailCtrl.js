"use strict";
angular.module("app.views")
.controller('timeSetDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight : true
    });

    $scope.times = {
    	id: CommonService.getQueryString('id')
    };

    $scope.getDetail = function(id){
    	CommonService.httpRequest({
    		url: '/baseSfTime/findById.api',
    		method: 'get',
    		data:{
    			id: id
    		}
    	}).then(function(data){
    		$scope.times = data.datas;
    		$scope.times.startDate = new Date($scope.times.startDate).Format('yyyy-MM-dd');
    		$scope.times.endDate = new Date($scope.times.endDate).Format('yyyy-MM-dd');
    		$scope.times.adjustDate = new Date($scope.times.adjustDate).Format('yyyy-MM-dd');
    		$scope.times.referenceDate = new Date($scope.times.referenceDate).Format('yyyy-MM-dd');
    	});
    };

    if($scope.times.id){
    	$scope.getDetail($scope.times.id);
    }

    $scope.addTimeSet = function(){

        if(!$scope.times.name){
            showWarn("节假日名称不能为空");
            return false;
        }
        if(!$scope.times.startDate){
            showWarn("开始日期不能为空");
            return false;
        }
        if(!$scope.times.endDate){
            showWarn("结束日期不能为空");
            return false;
        }
        if($scope.times.startDate > $scope.times.endDate){
        	showWarn('开始日期不能大于结束日期');
        	return false;
        }
        if(!$scope.times.adjustDate){
            showWarn("调整日期不能为空");
            return false;
        }
        else{
            if($scope.times.adjustDate > $scope.times.endDate || $scope.times.adjustDate < $scope.times.startDate){
                showWarn('调整日期在开始日期和结束日期之间');
                return false;
            }
        }
        if(!$scope.times.referenceDate){
            showWarn("时效参考日期不能为空");
            return false;
        }
        else{
            if($scope.times.referenceDate <= $scope.times.endDate){
                showWarn('时效参考日期需大于结束日期');
                return false;
            }
        }
        // if(!$scope.times.remark){
        //     showWarn("备注不能为空");
        //     return false;
        // }
        if($scope.times.id){
	        CommonService.httpRequest({
	        	url : '/baseSfTime/updateById.api',
	        	method : 'post',
	        	data:{
	        		id            : $scope.times.id,
	        		name          : $scope.times.name,
	        		startDate     : $scope.times.startDate,
	        		endDate       : $scope.times.endDate,
	        		adjustDate    : $scope.times.adjustDate,
	        		referenceDate : $scope.times.referenceDate,
	        		remark        : $scope.times.remark
	        	}
	        }).then(function(data){
	        	showInfo("更新成功",function(){
	        		tabOpenParent({name:'timeSet',url:'timeSet.html',displayName:'节假日时效调整'});
	        	});
	        });
        }
        else{
        	CommonService.httpRequest({
	        	url : '/baseSfTime/add.api',
	        	method : 'post',
	        	data:{
	        		name          : $scope.times.name,
	        		startDate     : $scope.times.startDate,
	        		endDate       : $scope.times.endDate,
	        		adjustDate    : $scope.times.adjustDate,
	        		referenceDate : $scope.times.referenceDate,
	        		remark        : $scope.times.remark
	        	}
	        }).then(function(data){
	        	showInfo("新增成功",function(){
	        		tabOpenParent({name:'timeSet',url:'timeSet.html',displayName:'节假日时效调整'});
	        	});
	        });
        }
    }

}]);
