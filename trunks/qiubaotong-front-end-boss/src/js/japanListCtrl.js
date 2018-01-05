"use strict";
angular.module("app.views")
.controller('japanListCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/languageMobile/findByPage.api',
            data :{
                pageNo : num || "1",
                mobile : $scope.Jmobile
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.addJMobile = function(){
        if(!$scope.addMobile){
            showWarn("手机号码不能为空");
            return false;
        }
        else{
            if(!(/^1[3|4|5|7|8]\d{9}$/.test($scope.addMobile))){
                showWarn("手机号码格式错误");
                return false;
            }
        }
        CommonService.httpRequest({
                  url : '/languageMobile/add.api',
                  method : 'post',
                  data :{
                      mobile:$scope.addMobile
                  }
              }).then(function(data){
                  showInfo("新增成功",function(){
                    $scope.getList();
                });
              });
    };
    $scope.deleteJMobile = function(mobile){
        CommonService.httpRequest({
                  url : '/languageMobile/delete.api',
                  method : 'get',
                  data :{
                      mobile:mobile
                  }
              }).then(function(data){
                  showInfo("删除成功",function(){
                    $scope.getList();
                });
              });
    };
    $scope.layerDeleteJMobile = function(mobile){
        layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
          $scope.deleteJMobile(mobile);
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
