"use strict";
angular.module("app.views")
.controller('systemlogDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.getList = function(num){
       var manages = localStorage.getItem('manages');
       if(manages != '' && manages != null){
	       manages = JSON.parse(manages);
	       $scope.id = manages.id;
	       $scope.types = manages.type + '';
	       $scope.status = manages.status + '';
	       $scope.memo = manages.memo;
       }
    }

    $scope.getList();

    $scope.addSystemLog = function(){
    	if(!$scope.id){
    		CommonService.httpRequest({
	            method : 'post',
	            url : '/sysLogs/add.api',
	            data:{
	            	type : parseInt($scope.types),
	            	status : parseInt($scope.status),
	            	memo : $scope.memo
	            }
	        }).then(function(data){
                showInfo("新增成功",function(){
                    location.href = 'systemlog.html';
                });
            });
    	}
    	else{
    		CommonService.httpRequest({
	            method : 'post',
	            url : '/sysLogs/updateById.api',
	            data:{
	            	id : $scope.id,
	            	type : parseInt($scope.types),
	            	status : parseInt($scope.status),
	            	memo : $scope.memo
	            }
	        }).then(function(data){
                showInfo("更新成功",function(){
                    location.href = 'systemlog.html';
                });
            });
            localStorage.removeItem('manages');
    	}
    }

}]);
