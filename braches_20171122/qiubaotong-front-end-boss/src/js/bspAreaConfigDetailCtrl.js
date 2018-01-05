"use strict";
angular.module("app.views")
.controller('bspAreaConfigDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
	$scope.province1 = '';
	$scope.province2 = '';
	$scope.city1 = '';
	$scope.city2 = '';

	$scope.addConfig = function(){
        if(!$scope.province1){
            showWarn('源省不能为空');
            return false;
        }
        if(!$scope.city1){
            showWarn('源市不能为空');
            return false;
        }
        if(!$scope.county1){
            showWarn('源区不能为空');
            return false;
        }
        else if($scope.county1.length > 50){
            showWarn('源区的长度不能超过50');
            return false;
        }
        if(!$scope.province2){
            showWarn('目标省不能为空');
            return false;
        }
        if(!$scope.city2){
            showWarn('目标市不能为空');
            return false;
        }
        if(!$scope.county2){
            showWarn('目标区不能为空');
            return false;
        }
        else if($scope.county2.length > 50){
            showWarn('目标区的长度不能超过50');
            return false;
        }

		CommonService.httpRequest({
			url : '/bspAreaConfig/add.api',
			method : 'post',
			data : {
				srcProvince : $scope.province1.split('|')[1],
				srcCity : $scope.city1.split('|')[1],
				srcCountry : $scope.county1,
                srcAreaId : $scope.city1.split('|')[0],
				destProvince : $scope.province2.split('|')[1],
				destCity : $scope.city2.split('|')[1],
				destCountry : $scope.county2,
                destAreaId : $scope.city2.split('|')[0]
			}
		}).then(function(data){
            showInfo("新增成功",function(){
                tabOpenParent({name:'bspAreaConfig',url:'bspAreaConfig.html',displayName:'bsp地区配置管理'});
            });
			
		});
	}

    $scope.getProvinces = function(){
        CommonService.httpRequest({
            url : '/baseSfArea/findByParentId.api?parentId=1000000',
            method : 'post',
        }).then(function(data){
            $scope.provinceses1 = data.datas;
            $scope.provinceses2 = data.datas;
        });
    }
    $scope.getProvinces();
    $scope.getCitieses = function(id){
        if(id == 1){
            if(!!$scope.province1){
                CommonService.httpRequest({
                    url : '/baseSfArea/findByParentId.api?parentId=' + $scope.province1.split('|')[0],
                    method : 'post',
                }).then(function(data){
                    $scope.citieses1 = data.datas;
                });

            }
            else{
                $scope.citieses1 = '';
            }
            $scope.city1 = '';
        }
        else{
            if(!!$scope.province2){
                CommonService.httpRequest({
                    url : '/baseSfArea/findByParentId.api?parentId=' + $scope.province2.split('|')[0],
                    method : 'post',
                }).then(function(data){
                    $scope.citieses2 = data.datas;
                });

            }
            else{
                $scope.citieses2 = '';
            }
            $scope.city2 = '';
        }
    }

}]);