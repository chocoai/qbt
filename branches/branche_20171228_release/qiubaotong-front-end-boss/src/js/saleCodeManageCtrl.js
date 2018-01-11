"use strict";
angular.module("app.views")
.controller('saleCodeManageCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight:true
    });
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/saleQrcodeCreateInfo/findByPage.api',
            data :{
                pageNo : num || "1",
                createTime  : $scope.createTime,
                name : $scope.name,
                salesmanCode : $scope.salesmanCode
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });

    }
    $scope.getList();
    $scope.exportCode = function(id){
        window.open(fBaseUrl+'/images/qrcode_'+ id +'/qrcode_'+ id +'.zip');
    }

    $scope.detail = function(id,name){
        tabOpenParent({name:'saleCodeManageDetail'+id,url:'saleCodeManageDetail.html?salesmanCode=' + id,displayName:name+'详情'});
    }
    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if(e && e.keyCode==13){ // enter 键
           $scope.getList();
        }
    };
}]);
