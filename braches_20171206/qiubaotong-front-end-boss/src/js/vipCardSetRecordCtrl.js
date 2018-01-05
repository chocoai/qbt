"use strict";
angular.module("app.views")
.controller('vipCardSetRecordCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight:true
    });

    $scope.list = [];
    $scope.clearTime = function(){
        $scope.createDate = '';
    }

    $scope.getVipType = function(num){
        CommonService.pagination({
            url : '/vipType/findByPage.api',
            data :{
                pageNo : num || "1",
                pageSize:100
            }
        }).then(function(data){
            $scope.vipTypes = data.item;
        });
    };

    $scope.getList = function(num){
        CommonService.pagination({
            url : '/vipCreate/findByPage.api',
            data :{
                pageNo : num || "1",
                vipTypeId  : $scope.vipTypeId,
                name : $scope.name,
                createDate : $scope.createDate && new Date($scope.createDate).getTime(),
                vipNo : $scope.vipNo
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });

    }
    $scope.getList();
    $scope.getVipType();

    $scope.exportVipCard = function(id){
        window.open(rBasetUrl + '/vipCreate/export.api?token=' + localStorage.getItem('token') + '&vipCreateId=' + id);
    }

    $scope.detail = function(id,name){
        tabOpenParent({name:'vipCardSetRecordDetail'+id,url:'vipCardSetRecordDetail.html?vipCreateId=' + id + '&vipNo=' + ($scope.vipNo || ''),displayName:name+'详情'});
    }


    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if(e && e.keyCode==13){ // enter 键
           $scope.getList();
        }
    };



}]);
