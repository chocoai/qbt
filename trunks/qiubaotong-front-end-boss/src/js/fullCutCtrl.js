"use strict";
angular.module("app.views")
.controller('fullCutCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/activityOff/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.fullCutName
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.addFullCut = function(){
        localStorage.removeItem('manages');
        tabOpenParent({name:'fullCutDetail_add',url:'fullCutDetail.html',displayName:'新增满减活动'});
    }
    $scope.updateFullCut = function(item){
        localStorage.setItem("manages", item);
        tabOpenParent({name:'fullCutDetail_update',url:'fullCutDetailShow.html',displayName:'满减活动详情'});
        
    }

    $scope.diableStatus = function(id){
      CommonService.httpRequest({
                url : '/activityOff/update.api',
                method : 'get',
                data :{
                    id : id
                }
            }).then(function(data){
                showInfo("禁用成功",function(){
                    location.href = 'fullCut.html';
                });
            });
    };
    $scope.layerDiableStatus = function(id){
        layer.confirm('确定禁用吗?', {icon: 3, title:'提示'}, function(index){
          $scope.diableStatus(id);
          layer.close(index);
        },function(index){
            layer.close(index);
        });
    };

    $scope.fullOrderDetail = function(id){
        tabOpenParent({name:'fullOrderDetail',url:'fullOrderDetail.html?id='+id,displayName:'活动订单详情'});
    }

    $scope.deleteFullCut = function(id){
        CommonService.httpRequest({
                  url : '/activityOff/delete.api',
                  method : 'get',
                  data :{
                      id : id
                  }
              }).then(function(data){
                  showInfo("删除成功",function(){
                    location.href = 'fullCut.html';
                });
              });
    }
    $scope.layerDeleteFullCut = function(id){
        layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
          $scope.deleteFullCut(id);
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
