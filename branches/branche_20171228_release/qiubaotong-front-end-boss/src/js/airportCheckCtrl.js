"use strict";
angular.module("app.views")
.controller('airportCheckCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/airport/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.airportName
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.addAirport = function(){
        localStorage.removeItem('manages');
        tabOpenParent({name:'airportCheckDetail_add',url:'airportCheckDetail.html',displayName:'新增机场'});
    }
    $scope.updateAirport = function(item){
        localStorage.setItem("manages", item);
        tabOpenParent({name:'airportCheckDetail_update',url:'airportCheckDetail.html',displayName:'更新机场'});
        
    }

    $scope.airportDisabled = function(id,isDelete){
      CommonService.httpRequest({
                  url : '/airport/deleteById.api',
                  method : 'get',
                  data :{
                      id : id,
                      isDelete: isDelete ? false : true
                  }
              }).then(function(data){
                  if(isDelete){
                    showInfo("启用成功",function(){
                      location.href = 'airportCheck.html';
                    });
                  }
                  else{
                    showInfo("禁用成功",function(){
                      location.href = 'airportCheck.html';
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
