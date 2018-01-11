"use strict";
angular.module("app.views")
.controller('qbtLinksDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
   	$scope.links = {
   		id: CommonService.getQueryString('id')
   	};

    $scope.getDetail = function(id){
        CommonService.httpRequest({
            url: '/baseLink/findById.api',
            method: 'get',
            data:{
                id: id
            }
        }).then(function(data){
            $scope.links = data.datas;
        });
    };
    if($scope.links.id){
        $scope.getDetail($scope.links.id);
    }

    $scope.save = function(){
        if(!$scope.links.name){
            showWarn('请输入链接名称');
            return;
        }
        if(!$scope.links.url){
            showWarn('请输入链接地址');
            return;
        }
        else{
            var reg = /^(http|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&amp;:/~\+#]*[\w\-\@?^=%&amp;/~\+#])?/;
            if(!reg.test($scope.links.url)){
                showWarn('链接地址格式错误');
                return;
            }
        }
        if($scope.links.id){
            CommonService.httpRequest({
                url: '/baseLink/update.api',
                method: 'post',
                data:{
                    id:   $scope.links.id,
                    name: $scope.links.name,
                    url: $scope.links.url
                }
            }).then(function(data){
                showInfo('更新成功',function(){
                    tabOpenParent({name:'qbtLinks',url:'qbtLinks.html',displayName:'新闻友情链接'});
                });
            });
        }
        else{
            CommonService.httpRequest({
                url: '/baseLink/add.api',
                method: 'post',
                data:{
                    name: $scope.links.name,
                    url: $scope.links.url
                }
            }).then(function(data){
                showInfo('新增成功',function(){
                    tabOpenParent({name:'qbtLinks',url:'qbtLinks.html',displayName:'新闻友情链接'});
                });
            });
        }

    };

}]);
