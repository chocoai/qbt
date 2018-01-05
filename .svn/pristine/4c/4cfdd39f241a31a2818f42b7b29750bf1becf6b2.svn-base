"use strict";
angular.module("app.views")
.controller('logSearchCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.datePicker').datetimepicker({
        format: 'yyyy-mm-dd hh:ii:00',
        autoclose: true,
        minView : 0,
        maxView : 3
    });
    
    $scope.serviceNameType = Constants.serviceName_type;
    $scope.list = [];
    $scope.beginTime = '';
    $scope.endTime = '';

    $scope.getList = function(num){
        if($scope.beginTime && $scope.endTime){
            if($scope.beginTime > $scope.endTime){
                showWarn('开始时间不能大于结束时间');
                return;
            }
        }
        CommonService.pagination({
            url : '/baseSfExpressLog/findByPage.api',
            data :{
                pageNo : num || "1",
                keyword : $scope.keyword,
                status : $scope.status,
                beginTime : $scope.beginTime,
                endTime : $scope.endTime,
                serviceName : $scope.serviceName
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.toDetail = function(id){
        tabOpenParent({name:'logSearchDetail'+id,url:'logSearchDetail.html?id='+id,displayName:'报文日志详情'});
    };

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
        if(e && e.keyCode==13){ // enter 键
            $('select').blur();
            $scope.getList();
        }
    };



    
}]);
