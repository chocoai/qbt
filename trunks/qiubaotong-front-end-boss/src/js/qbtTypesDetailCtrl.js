"use strict";
angular.module("app.views")
.controller('qbtTypesDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
   	$scope.types = {
   		id: CommonService.getQueryString('id')
   	};

    $scope.getDetail = function(id){
        CommonService.httpRequest({
            url: '/newsCategory/detail.api',
            method: 'get',
            data:{
                id: id
            }
        }).then(function(data){
            $scope.types = data.datas;
        });
    };
    if($scope.types.id){
        $scope.getDetail($scope.types.id);
    }

    $scope.save = function(){
        if(!$scope.types.name){
            showWarn('请输入类型名称');
            return;
        }
        if(!$scope.types.sort && $scope.types.sort !== 0){
            showWarn('请输入排序数字');
            return;
        }
        else {
        	var sort = $scope.types.sort.toString();
        	var pointIndex = sort.indexOf('.');
        	if(pointIndex > 0 && pointIndex != (sort.length - 1)){
        		showWarn('排序数字为整数且不能小于0');
        		return;
        	}
        }
        if($scope.types.id){
            CommonService.httpRequest({
                url: '/newsCategory/update.api',
                method: 'post',
                data:{
                    id:   $scope.types.id,
                    name: $scope.types.name,
                    sort: $scope.types.sort
                }
            }).then(function(data){
                showInfo('更新成功',function(){
                    tabOpenParent({name:'qbtTypes',url:'qbtTypes.html',displayName:'新闻分类'});
                });
            });
        }
        else{
            CommonService.httpRequest({
                url: '/newsCategory/add.api',
                method: 'post',
                data:{
                    name: $scope.types.name,
                    sort: $scope.types.sort
                }
            }).then(function(data){
                showInfo('新增成功',function(){
                    tabOpenParent({name:'qbtTypes',url:'qbtTypes.html',displayName:'新闻分类'});
                });
            });
        }

    };

}]);
