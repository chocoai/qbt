"use strict";
angular.module("app.views")
.controller('courseUserCheckCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.desc = 1;
    var courseName = localStorage.getItem('manages');
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/adminUserAssistant/findByPage.api',
            data :{
                pageNo : num || "1",
                siteName : $scope.courseSelect || courseName,
                name : $scope.nameSelect,
                mobile : $scope.mobileSelect
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.toDisable = function(id){
      layer.confirm('确定设置为禁用吗？', {
          btn: ['确定','取消'] //按钮
        }, function(index){
          CommonService.httpRequest({
                  url : '/userAssistantApply/updateStatus.api',
                  method : 'post',
                  data :{
                      assistantId : parseInt(id),
                      status:'4'
                  }
              }).then(function(data){
                  $scope.getList(1);
                  layer.close(index);
              });
        }, function(index){
          layer.close(index);
        });
    };

    $scope.toEnable = function(id){
      layer.confirm('确定设置为启用吗？', {
          btn: ['确定','取消'] //按钮
        }, function(index){
          CommonService.httpRequest({
                  url : '/userAssistantApply/updateStatus.api',
                  method : 'post',
                  data :{
                      assistantId : parseInt(id),
                      status:'5'
                  }
              }).then(function(data){
                  $scope.getList(1);
                  layer.close(index);
              });
        }, function(index){
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
