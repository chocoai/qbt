"use strict";
angular.module("app.views")
.controller('systemlogCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true
    });
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/sysLogs/findByPage.api',
            data :{
                pageNo : num || "1",
                startTime : $scope.startTime,
                endTime : $scope.endTime
            }
        }).then(function(data){
            $scope.systemlogs = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

}]);
