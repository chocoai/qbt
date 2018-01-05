"use strict";
angular.module("app.views")
.controller('sfSitesCheckCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/baseSfSite/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.sfSitesName
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.addSFSites = function(){
        localStorage.removeItem('manages');
        tabOpenParent({name:'sfSitesCheckDetail_add',url:'sfSitesCheckDetail.html',displayName:'新增顺丰站点'});
    }
    $scope.updateSFSites = function(item){
        localStorage.setItem("manages", item);
        tabOpenParent({name:'sfSitesCheckDetail_update',url:'sfSitesCheckDetail.html',displayName:'更新顺丰站点'});
        
    }

    $scope.sfSitesDisabled = function(id,isDelete){
      CommonService.httpRequest({
                  url : '/baseSfSite/delete.api',
                  method : 'get',
                  data :{
                      id : id,
                      isDelete: isDelete ? false : true
                  }
              }).then(function(data){
                  if(isDelete){
                    showInfo("启用成功",function(){
                      location.href = 'sfSitesCheck.html';
                    });
                  }
                  else{
                    showInfo("禁用成功",function(){
                      location.href = 'sfSitesCheck.html';
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
