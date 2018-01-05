"use strict";
angular.module("app.views")
.controller('wechatAutoReplyCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/weixinReply/findByPage.api',
            data :{
                pageNo : num || "1",
                keyword : $scope.keyword,
                status : $scope.status,
                type : $scope.type,
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.toAdd = function(){
        tabOpenParent({name:'wechatAutoReply_add',url:'wechatAutoReplyDetail.html',displayName:'新增微信自动回复'});
    };
    $scope.toDetail = function(id){
        tabOpenParent({name:'wechatAutoReply_update',url:'wechatAutoReplyDetail.html?id=' + id,displayName:'修改微信自动回复'});
    };

    $scope.toChange = function(id,status){
        CommonService.httpRequest({
            url : '/weixinReply/updateStatus.api',
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
    };

    $scope.toDelete = function(id){
        layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
            CommonService.httpRequest({
                url : '/weixinReply/delete.api',
                method : 'get',
                data :{
                    id : id
                }
            }).then(function(data){
                showInfo("删除成功",function(){
                    $scope.getList();
                });
            });
            layer.close(index);
        },function(index){
            layer.close(index);
        });
    };

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
        if(e && e.keyCode==13){ // enter 键
            $('select').blur();
            $scope.getList();
        }
    };

}]);
