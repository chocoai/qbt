"use strict";
angular.module("app.views")
.controller('bankBranchesCheckCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/baseBankBranch/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.bankBranchesName
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.addBankBranches = function(){
        localStorage.removeItem('manages');
        tabOpenParent({name:'bankBranchesCheckDetail_add',url:'bankBranchesCheckDetail.html',displayName:'新增银行站点'});
    }
    $scope.updateBankBranches = function(item){
        localStorage.setItem("manages", item);
        tabOpenParent({name:'bankBranchesCheckDetail_update',url:'bankBranchesCheckDetail.html',displayName:'更新银行站点'});
        
    }

    $scope.bankDisabled = function(id,isDelete){
      CommonService.httpRequest({
        url : '/baseBankBranch/delete.api',
        method : 'get',
        data :{
          id : id,
          isDelete: isDelete ? false : true
        }
      }).then(function(data){
        if(isDelete){
          showInfo("启用成功",function(){
            location.href = 'bankBranchesCheck.html';
          });
        }
        else{
          showInfo("禁用成功",function(){
            location.href = 'bankBranchesCheck.html';
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
