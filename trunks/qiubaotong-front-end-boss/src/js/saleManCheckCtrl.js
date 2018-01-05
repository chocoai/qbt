"use strict";
angular.module("app.views")
.controller('saleManCheckCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/saleUser/findByPage.api',
            data :{
                pageNo : num || "1",
                pageSize : 30,
                isApply : false,
                name : $scope.name,
                mobile : $scope.mobile,
                salesmanCode : $scope.salesmanCode,
                idcard : $scope.idcard,
                company : $scope.company
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.toDetail = function(id,name){
        tabOpenParent({name:'saleManManageDetail'+id,url:'saleManManageDetail.html?id='+id,displayName:'销售人员'+name});
    }

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getList();
               }
           };

    
}]);
