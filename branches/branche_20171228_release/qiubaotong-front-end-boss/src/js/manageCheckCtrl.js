"use strict";
angular.module("app.views")
.controller('manageCheckCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.mobileSelect = CommonService.getQueryString('loginMobile') || '';
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/adminUser/findByPage.api',
            data :{
                pageNo : num || "1",
                name: $scope.name,
                email : $scope.emailSelect,
                mobile : $scope.mobileSelect
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.manageDetailCheck = function(item){
        var itemStr=JSON.stringify(item);
		localStorage.setItem("manages", itemStr);
    	tabOpenParent({name:'manageDetailCheck',url:'manageDetailCheck.html',displayName:'更新平台用户'});
   		
    }
    $scope.addManage = function(){
    	localStorage.removeItem("manages");
    	tabOpenParent({name:'manageDetailCheck',url:'manageDetailCheck.html',displayName:'新增平台用户'});
    }

    $scope.manageDelete = function(id){
        CommonService.httpRequest({
                method : 'get',
                url : '/adminUser/delete.api',
                data :{
                    id : id
                }
            }).then(function(data){
                showInfo("删除成功",function(){
                    $scope.getList()
                });
            });
    };
    $scope.layerManageDelete = function(id){
        layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
          $scope.manageDelete(id);
          layer.close(index);
        },function(index){
            layer.close(index);
        });
    };

    $scope.resetPassword = function(id){
        CommonService.httpRequest({
                url : '/adminUser/resetPwdByUserId.api',
                method : 'get',
                data :{
                    id : id
                }
            }).then(function(data){
                showInfo("重置密码成功",function(){
                    $scope.getList();
                });
            });
    };
    $scope.layerResetPassword = function(id){
        layer.confirm('确定重置密码吗?', {icon: 3, title:'提示'}, function(index){
          $scope.resetPassword(id);
          layer.close(index);
        },function(index){
            layer.close(index);
        });
    };
    $scope.getWecat = function(num){
        CommonService.pagination({
            url : '/userWeixin/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.wecatName
            }
        }).then(function(data){
            $scope.wecats = data.item;
            $scope.page1 = data.page;
        });
    };
    $scope.showWecat = function(id){
        $scope.userId = id;
        $scope.getWecat();
            layer.open({    
              type: 1,
              title:'请选择微信用户',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo'),
              end : function(){
                $scope.wecatName = '';
              }
            });
        document.onkeydown = '';
    };
    $scope.selectedWecat = function(id){
        CommonService.httpRequest({
            method : 'post',
            url : '/adminUser/update.api',
            data :{
                id : $scope.userId,
                wxOpenId : id
            }
        }).then(function(data){
            showInfo("关联成功",function(){
                $scope.getList();
            });
        });
        layer.closeAll();
        document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                    $('select').blur();
                    $scope.getList();
               }
           };
    }


    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getList();
               }
           };

}]);
