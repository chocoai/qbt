"use strict";
angular.module("app.views")
.controller('serviceManageCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/kf/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.serverManageName
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.addServerManage = function(){
    	localStorage.removeItem('manages');
    	tabOpenParent({name:'serviceManageDetail_add',url:'serviceManageDetail.html',displayName:'新增客服'});
    }
    $scope.updateServerManage = function(item){
    var itemStr=JSON.stringify(item);
		localStorage.setItem("manages", itemStr);
    tabOpenParent({name:'serviceManageDetail_update',url:'serviceManageDetail.html',displayName:'更新客服'});
   		
    }

    $scope.deleteServerManage = function(id){
    	CommonService.httpRequest({
                  url : '/kf/delete.api',
                  method : 'get',
                  data :{
                      id : id
                  }
              }).then(function(data){
                  showInfo("删除成功",function(){
                    location.href = 'serviceManage.html';
                });
              });
    };
    $scope.layerDeleteServerManage = function(id){
        layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
          $scope.deleteServerManage(id);
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
