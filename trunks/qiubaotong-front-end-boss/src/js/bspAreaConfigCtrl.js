"use strict";
angular.module("app.views")
.controller('bspAreaConfigCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/bspAreaConfig/findByPage.api',
            data :{
                pageNo : num || "1"
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.addServerManage = function(){
    	tabOpenParent({name:'bspAreaConfigDetail_add',url:'bspAreaConfigDetail.html',displayName:'新增bsp地区配置'});
    }

    $scope.deleteServerConfig = function(id){
    	CommonService.httpRequest({
                  url : '/bspAreaConfig/delete.api',
                  method : 'get',
                  data :{
                      id : id
                  }
              }).then(function(data){
                  showInfo("删除成功",function(){
                    location.href = 'bspAreaConfig.html';
                });
              });
    };
    $scope.layerDeleteConfig = function(id){
        layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
          $scope.deleteServerConfig(id);
          layer.close(index);
        },function(index){
            layer.close(index);
        });
    };

     // document.onkeydown=function(event){
     //    var e = event || window.event || arguments.callee.caller.arguments[0];          
     //             if(e && e.keyCode==13){ // enter 键
     //               $scope.getList();
     //           }
     //       };

}]);
