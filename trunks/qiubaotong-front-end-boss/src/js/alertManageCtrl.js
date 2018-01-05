"use strict";
angular.module("app.views")
.controller('alertManageCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.conditionTypes = Constants.condition_type;
    $scope.alertPlatforms = Constants.alert_platform;
    $scope.list = [];
    $scope.type = '';
    $scope.position = '';
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/popUp/findByPage.api',
            data :{
                pageNo : num || "1",
                conditionType : $scope.conditionType,
                name : $scope.name,
                platform : $scope.platform,
                sort : $scope.sort
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.add = function(){
        tabOpenParent({name:'alertManage_add',url:'alertManageDetail.html',displayName:'新增弹框'});
    }
    $scope.update = function(id,name){
        tabOpenParent({name:'alertManage_update'+id,url:'alertManageDetail.html?id=' + id, displayName:name+'详情'});
        
    }

    $scope.deleteAlert = function(id){
        CommonService.httpRequest({
                  url : '/popUp/delete.api',
                  method : 'get',
                  data :{
                      id : id
                  }
              }).then(function(data){
                  showInfo("删除成功",function(){
                    $scope.getList();
                });
              });
    };
    $scope.layerDeleteAlert = function(id){
        layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
          $scope.deleteAlert(id);
          layer.close(index);
        },function(index){
            layer.close(index);
        });
    };

    $scope.updateStatus = function(id,status){
      CommonService.httpRequest({
        url : '/popUp/updateStatus.api',
        method : 'post',
        data :{
          id : id,
          status: status == 1 ? 2 : 1
        }
      }).then(function(data){
        if(status == 2){
          showInfo("启用成功",function(){
            $scope.getList();
          });
        }
        else{
          showInfo("禁用成功",function(){
            $scope.getList();
          });
        }

      });
    }


    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                  $('select').blur();
                   $scope.getList();
               }
           };


}]);
