"use strict";
angular.module("app.views")
.controller('suggestionCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/feedBack/findByPage.api',
            data :{
                pageNo : num || "1",
                userNickname : $scope.userNickname,
                mobile : $scope.mobile,
                content : $scope.content
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.userDetail = function(id){
        tabOpenParent({name:'userCheckDetail'+id,url:'userCheckDetail.html?id='+id,displayName:'用户详情查询'+id});
    };

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getList();
               }
           };



    
}]);
