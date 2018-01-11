"use strict";
angular.module("app.views")
.controller('timeSetCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.datePicker').datetimepicker({
	    format: 'yyyy',
	    autoclose: true,
	    startView:4,
        minView : 4,
        maxView : 4,
        todayHighlight : true
	});
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/baseSfTime/findByPage.api',
            data :{
                pageNo : num || "1",
                startDate : $scope.startDate ? ($scope.startDate + '-01-01') : ''
            }
        }).then(function(data){
            $scope.lists = data.item;
            $scope.page = data.page;
        });
    };
    $scope.getList();
    $scope.add = function(){
    	tabOpenParent({name:'timeSetDetail_add',url:'timeSetDetail.html',displayName:'新增时效调整'});
    };

    $scope.update = function(id,name){
    	tabOpenParent({name:'timeSetDetail_update',url:'timeSetDetail.html?id=' + id,displayName: name + '详情'});
    };

    $scope.delete = function(id){
        CommonService.httpRequest({
            url : '/baseSfTime/deleteById.api',
            method : 'get',
            data :{
            	id : id
            }
    	}).then(function(data){
        	showInfo("删除成功",function(){
            	$scope.getList();
        	});
    	});
    };
    $scope.layerDelete = function(id){
        layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
          	$scope.delete(id);
          	layer.close(index);
        },function(index){
            layer.close(index);
        });
    };

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
        if(e && e.keyCode==13){ // enter 键
            $scope.getList();
        }
    };


}]);
