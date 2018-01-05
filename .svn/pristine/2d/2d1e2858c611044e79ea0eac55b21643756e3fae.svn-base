"use strict";
angular.module("app.views")
.controller('qbtLinksCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/baseLink/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.name
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.toAdd = function(){
        tabOpenParent({name:'qbtLinks_add',url:'qbtLinksDetail.html',displayName:'新增新闻友情链接'});
    };
    $scope.toDetail = function(id,name){
        tabOpenParent({name:'qbtLinks_update' + id,url:'qbtLinksDetail.html?id=' + id,displayName:name + '详情'});
    };

    $scope.toDelete = function(id,name){
        layer.confirm('确定删除' + name + '吗?', {icon: 3, title:'提示'}, function(index){
            CommonService.httpRequest({
                url : '/baseLink/delete.api',
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

    document.onkeydown = function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
        if(e && e.keyCode==13){ // enter 键
            $scope.getList();
        }
    };

}]);
