"use strict";
angular.module("app.views")
.controller('vipTypeCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.status = '';
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/vipType/findByPage.api',
            data :{
                pageNo : num || "1",
                name   : $scope.name,
                status : $scope.status
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    };
    $scope.getList();

    $scope.addVipType = function(){
        tabOpenParent({name:'vipTypeDetail_add',url:'vipTypeAdd.html',displayName:'新增会员卡类型'});
    }
    $scope.updateVipType = function(id){
        tabOpenParent({name:'vipTypeDetail_update'+id,url:'vipTypeDetail.html?id=' + id,displayName:'会员卡类型详情'+id});
        
    }

    $scope.typeDisabled = function(id,status){
      CommonService.httpRequest({
        url : '/vipType/updateStatus.api',
        method : 'post',
        data :{
          id : id,
          status: status  == 1 ? 2 : 1
        }
      }).then(function(data){
        if(status == 1){
          showInfo("禁用成功",function(){
            $scope.getList();
          });
        }
        else{
          showInfo("启用成功",function(){
            $scope.getList();
          });
        }
        
      });
    };


    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getList();
               }
           };

}]);
