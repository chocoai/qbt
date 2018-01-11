"use strict";
angular.module("app.views")
.controller('insuranceCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/baseInsTemp/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.insuranceName
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.addInsurance = function(){
    	localStorage.removeItem('manages');
    	tabOpenParent({name:'insuranceDetail_add',url:'insuranceDetail.html',displayName:'新增保价'});
    }
    $scope.updateInsurance = function(item){
        var itemStr=JSON.stringify(item);
		  localStorage.setItem("manages", itemStr);
    	tabOpenParent({name:'insuranceDetail_update',url:'insuranceDetail.html',displayName:'更新保价'});
   		
    }

    $scope.deleteInsurance = function(id){
    	CommonService.httpRequest({
                  url : '/baseInsTemp/deleteById.api',
                  method : 'get',
                  data :{
                      id : id,
                  }
              }).then(function(data){
                  showInfo("删除成功",function(){
                    $scope.getList(1);
                });
              });
    };
    $scope.layerDeleteInsurance = function(id){
        layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
          $scope.deleteInsurance(id);
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
