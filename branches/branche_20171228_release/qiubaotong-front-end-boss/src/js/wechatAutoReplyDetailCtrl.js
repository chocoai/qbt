"use strict";
angular.module("app.views")
.controller('wechatAutoReplyDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.details = {
        'type' : 1,
        'id' : CommonService.getQueryString('id')
    };
    $scope.articles = {};
    $scope.getDetail = function(id){
        CommonService.httpRequest({
            url:'/weixinReply/detail.api',
            method:'get',
            data:{
                id:id
            }
        }).then(function(data){
            $scope.details = data.datas;
            if($scope.details.type == 2){
                $scope.articles = data.datas.articles[0];
                if($scope.articles.picurl){
                    $scope.showPicUrl = $scope.articles.picurl;
                }
            }
        });
    };

    if($scope.details.id){
        $scope.getDetail($scope.details.id);
    }

    $scope.update = function(){

        if(!$scope.details.keyword){
            showWarn('关键字不能为空');
            return;
        }
        if($scope.details.type == 1){
            if(!$scope.details.content){
                showWarn('内容不能为空');
                return;
            }
        }
        else{
            if(!$scope.articles.title){
                showWarn('图文标题不能为空');
                return;
            }
            if(!$scope.articles.url){
                showWarn('跳转URL不能为空');
                return;
            }
            if(!$scope.articles.picurl){
                showWarn('图片不能为空');
                return;
            }
            if(!$scope.articles.description){
                showWarn('描述不能为空');
                return;
            } 
        }

        if($scope.details.id){
            CommonService.httpRequest({
                url:'/weixinReply/update.api',
                method:'post',
                data:{
                    id:$scope.details.id,
                    keyword:$scope.details.keyword,
                    type:$scope.details.type,
                    content:$scope.details.type == 1 ? $scope.details.content : '',
                    articles:$scope.details.type == 2 ? [$scope.articles] : [],
                }
            }).then(function(data){
                showInfo('修改成功',function(){
                    tabOpenParent({name:'wechatAutoReply',url:'wechatAutoReply.html',displayName:'微信自动回复'});
                });
            });
        }
        else{
            CommonService.httpRequest({
                url:'/weixinReply/add.api',
                method:'post',
                data:{
                    keyword:$scope.details.keyword,
                    type:$scope.details.type,
                    content:$scope.details.type == 1 ? $scope.details.content : '',
                    articles:$scope.details.type == 2 ? [$scope.articles] : [],
                }
            }).then(function(data){
                showInfo('新增成功',function(){
                    tabOpenParent({name:'wechatAutoReply',url:'wechatAutoReply.html',displayName:'微信自动回复'});
                });
            });
        }
    };

}]);
