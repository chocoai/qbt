"use strict";
angular.module("app.views")
.controller('messageEductioinCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/baseTeachCenter/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.name,
                address : $scope.address
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.addServerManage = function(){
    	localStorage.removeItem('manages');
    	tabOpenParent({name:'messageEductioinDetail_add',url:'messageEductioinDetail.html',displayName:'新增教学中心信息'});
    }
    $scope.updateServerManage = function(item){
		localStorage.setItem("manages", item);
    tabOpenParent({name:'messageEductioinDetail_update',url:'messageEductioinDetail.html',displayName:'更新教学中心信息'});
   		
    }

    $scope.deleteServerManage = function(id){
    	CommonService.httpRequest({
                  url : '/baseTeachCenter/deleteById.api',
                  method : 'get',
                  data :{
                      id : id
                  }
              }).then(function(data){
                  showInfo("删除成功",function(){
                    location.href = 'messageEductioin.html';
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
