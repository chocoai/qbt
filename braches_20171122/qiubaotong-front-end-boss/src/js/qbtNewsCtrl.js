"use strict";
angular.module("app.views")
.controller('qbtNewsCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight:true
    });

    $scope.getNewTypes = function(){
        CommonService.httpRequest({
            url: '/newsCategory/findList.api',
            method: 'get'
        }).then(function(data){
            $scope.newTypes = data.datas || [];
        });
    };

    $scope.list = [];
    $scope.getList = function(num){
        $scope.pageNumber = num;
        CommonService.pagination({
            url : '/baseNews/findByPage.api',
            data :{
                pageNo : num || "1",
                title : $scope.title,
                createTime : $scope.createTime,
                categoryId : $scope.categoryId
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getNewTypes();
    $scope.getList();

    $scope.toAdd = function(){
        tabOpenParent({name:'qbtNews_add',url:'qbtNewsDetail.html',displayName:'新增新闻动态'});
    };
    $scope.toDetail = function(id,title){
        tabOpenParent({name:'qbtNews_update'+id,url:'qbtNewsDetail.html?id=' + id,displayName:title+'详情'});
    };

    $scope.toChange = function(id,status){
        CommonService.httpRequest({
            url : '/baseNews/updateStatus.api',
            method : 'get',
            data :{
                id : id,
                status: status == 1 ? 2 : 1
            }
        }).then(function(data){
            $scope.getList($scope.pageNumber);
        });
    };

    $scope.toDelete = function(id,name){
        layer.confirm('确定删除' + name + '吗?', {icon: 3, title:'提示'}, function(index){
            CommonService.httpRequest({
                url : '/baseNews/delete.api',
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
