"use strict";
angular.module("app.views")
.controller('priceManageDetailCtrl',['$scope','CommonService',function($scope,CommonService){
	$('body').niceScroll({cursorcolor:"#337ab7"});
	var manages = localStorage.getItem('manages');

	$scope.startProvince = '';
	$scope.startCity = '';
	$scope.endProvince = '';
	$scope.endCity = '';

	$scope.getMessage = function(num){
		manages = JSON.parse(manages);
		$scope.id = manages.id;
		$scope.startProvince = manages.startProvince;
		$scope.startCity = manages.startCity;
		$scope.endProvince = manages.endProvince;
		$scope.endCity = manages.endCity;
		$scope.cichenSfPrice = manages.cichenSfPrice;
		$scope.cichenQbtPrice = manages.cichenQbtPrice
		$scope.cichenFirstPrice = manages.cichenFirstPrice
		$scope.cichenSecondPrice = manages.cichenSecondPrice
		$scope.ciriSfPrice = manages.ciriSfPrice
		$scope.ciriQbtPrice = manages.ciriQbtPrice
		$scope.ciriFirstPrice = manages.ciriFirstPrice
		$scope.ciriSecondPrice = manages.ciriSecondPrice;
		$scope.jiriSfPrice = manages.jiriSfPrice;
		$scope.jiriQbtPrice = manages.jiriQbtPrice;
		$scope.jiriFirstPrice = manages.jiriFirstPrice;
		$scope.jiriSecondPrice = manages.jiriSecondPrice;
		$scope.geriSfPrice = manages.geriSfPrice;
		$scope.geriQbtPrice = manages.geriQbtPrice;
		$scope.geriFirstPrice = manages.geriFirstPrice;
		$scope.geriSecondPrice = manages.geriSecondPrice;
	}



	$scope.getProvinces = function(){
		CommonService.httpRequest({
			url : '/baseSfArea/findByParentId.api?parentId=1000000',
			method : 'post',
		}).then(function(data){
			$scope.Allprovinces = data.datas;
			$scope.startProvinceses = data.datas;
			$scope.endProvinceses = data.datas;
		});
	}

	$scope.getCitieses = function(id){
		if(id == 1){
			if(!!$scope.startProvince){
				CommonService.httpRequest({
					url : '/baseSfArea/findByParentId.api?parentId=' + $scope.startProvince.split('|')[0],
					method : 'post',
				}).then(function(data){
					$scope.startCitieses = data.datas;
				});
			}
			else{
				$scope.startCitieses = '';
			}
			$scope.startCity = '';
		}
		else{
			if(!!$scope.endProvince){
				CommonService.httpRequest({
					url : '/baseSfArea/findByParentId.api?parentId=' + $scope.endProvince.split('|')[0],
					method : 'post',
				}).then(function(data){
					$scope.endCitieses = data.datas;
				});
			}
			else{
				$scope.endCitieses = '';
			}
			$scope.endCity = '';
		}
	}


	$scope.addPrice = function(){

		if(!$scope.startProvince){
            showWarn("取包省不能为空");
            return false;
        }
        if(!$scope.startCity){
            showWarn("取包市不能为空");
            return false;
        }
        if(!$scope.endProvince){
            showWarn("送包省不能为空");
            return false;
        }
        if(!$scope.endCity){
            showWarn("送包市不能为空");
            return false;
        }
        if(!$scope.cichenSfPrice && $scope.cichenSfPrice != 0){
            showWarn("次晨顺丰价格不能为空或小于0");
            return false;
        }
        else{
        	if($scope.cichenSfPrice > 999.99){
        		showWarn("次晨顺丰价格不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.cichenQbtPrice && $scope.cichenQbtPrice != 0){
            showWarn("次晨球包通价格不能为空或小于0");
            return false;
        }
        else{
        	if($scope.cichenQbtPrice > 999.99){
        		showWarn("次晨球包通价格不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.cichenFirstPrice && $scope.cichenFirstPrice != 0){
            showWarn("次晨顺丰首重不能为空或小于0");
            return false;
        }
        else{
        	if($scope.cichenFirstPrice > 999.99){
        		showWarn("次晨顺丰首重不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.cichenSecondPrice && $scope.cichenSecondPrice != 0){
            showWarn("次晨顺丰续重不能为空或小于0");
            return false;
        }
        else{
        	if($scope.cichenSecondPrice > 999.99){
        		showWarn("次晨顺丰续重不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.ciriSfPrice && $scope.ciriSfPrice != 0){
            showWarn("次日顺丰价格不能为空或小于0");
            return false;
        }
        else{
        	if($scope.ciriSfPrice > 999.99){
        		showWarn("次日顺丰价格不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.ciriQbtPrice && $scope.ciriQbtPrice != 0){
            showWarn("次日球包通价格不能为空或小于0");
            return false;
        }
        else{
        	if($scope.ciriQbtPrice > 999.99){
        		showWarn("次日球包通价格不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.ciriFirstPrice && $scope.ciriFirstPrice != 0){
            showWarn("次日顺丰首重不能为空或小于0");
            return false;
        }
        else{
        	if($scope.ciriFirstPrice > 999.99){
        		showWarn("次日顺丰首重不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.ciriSecondPrice && $scope.ciriSecondPrice != 0){
            showWarn("次日顺丰续重不能为空或小于0");
            return false;
        }
        else{
        	if($scope.ciriSecondPrice > 999.99){
        		showWarn("次日顺丰续重不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.jiriSfPrice && $scope.jiriSfPrice != 0){
            showWarn("即日顺丰价格不能为空或小于0");
            return false;
        }
        else{
        	if($scope.jiriSfPrice > 999.99){
        		showWarn("即日顺丰价格不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.jiriQbtPrice && $scope.jiriQbtPrice != 0){
            showWarn("即日球包通价格不能为空或小于0");
            return false;
        }
        else{
        	if($scope.jiriQbtPrice > 999.99){
        		showWarn("即日球包通价格不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.jiriFirstPrice && $scope.jiriFirstPrice != 0){
            showWarn("即日顺丰首重不能为空或小于0");
            return false;
        }
        else{
        	if($scope.jiriFirstPrice > 999.99){
        		showWarn("即日顺丰首重不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.jiriSecondPrice && $scope.jiriSecondPrice != 0){
            showWarn("即日顺丰续重不能为空或小于0");
            return false;
        }
        else{
        	if($scope.jiriSecondPrice > 999.99){
        		showWarn("即日顺丰续重不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.geriSfPrice && $scope.geriSfPrice != 0){
            showWarn("隔日顺丰价格不能为空或小于0");
            return false;
        }
        else{
        	if($scope.geriSfPrice > 999.99){
        		showWarn("隔日顺丰价格不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.geriQbtPrice && $scope.geriQbtPrice != 0){
            showWarn("隔日球包通不能为空或小于0");
            return false;
        }
        else{
        	if($scope.geriQbtPrice > 999.99){
        		showWarn("隔日球包通不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.geriFirstPrice && $scope.geriFirstPrice != 0){
            showWarn("隔日顺丰首重不能为空或小于0");
            return false;
        }
        else{
        	if($scope.geriFirstPrice > 999.99){
        		showWarn("隔日顺丰首重不能大于999.99");
        		return false;
        	}
        }
        if(!$scope.geriSecondPrice && $scope.geriSecondPrice != 0){
            showWarn("隔日顺丰续重不能为空或小于0");
            return false;
        }
        else{
        	if($scope.geriSecondPrice > 999.99){
        		showWarn("隔日顺丰续重不能大于999.99");
        		return false;
        	}
        }

		if(!$scope.id){
			CommonService.httpRequest({
				method : 'post',
				url : '/baseSFPrice/add.api',
				data:{
					startProvince : $scope.startProvince.split('|')[1],
					startCity : $scope.startCity.split('|')[1],
					endProvince : $scope.endProvince.split('|')[1],
					endCity : $scope.endCity.split('|')[1],
					cichenSfPrice : parseFloat($scope.cichenSfPrice),
					cichenQbtPrice : parseFloat($scope.cichenQbtPrice),
					cichenFirstPrice : parseFloat($scope.cichenFirstPrice),
					cichenSecondPrice : parseFloat($scope.cichenSecondPrice),
					ciriSfPrice : parseFloat($scope.ciriSfPrice),
					ciriQbtPrice : parseFloat($scope.ciriQbtPrice),
					ciriFirstPrice : parseFloat($scope.ciriFirstPrice),
					ciriSecondPrice : parseFloat($scope.ciriSecondPrice),
					jiriSfPrice : parseFloat($scope.jiriSfPrice),
					jiriQbtPrice : parseFloat($scope.jiriQbtPrice),
					jiriFirstPrice : parseFloat($scope.jiriFirstPrice),
					jiriSecondPrice : parseFloat($scope.jiriSecondPrice),
					geriSfPrice : parseFloat($scope.geriSfPrice),
					geriQbtPrice : parseFloat($scope.geriQbtPrice),
					geriFirstPrice : parseFloat($scope.geriFirstPrice),
					geriSecondPrice : parseFloat($scope.geriSecondPrice)
				}
			}).then(function(data){
				showInfo("新增成功",function(){
					tabOpenParent({name:'priceManage',url:'priceManage.html',displayName:'运费管理'});
				});
			});
		}
		else{
			CommonService.httpRequest({
				method : 'post',
				url : '/baseSFPrice/updateById.api',
				data:{
					id : parseInt($scope.id),
					startProvince : $scope.startProvince.split('|')[1],
					startCity : $scope.startCity.split('|')[1],
					endProvince : $scope.endProvince.split('|')[1],
					endCity : $scope.endCity.split('|')[1],
					cichenSfPrice : parseFloat($scope.cichenSfPrice),
					cichenQbtPrice : parseFloat($scope.cichenQbtPrice),
					cichenFirstPrice : parseFloat($scope.cichenFirstPrice),
					cichenSecondPrice : parseFloat($scope.cichenSecondPrice),
					ciriSfPrice : parseFloat($scope.ciriSfPrice),
					ciriQbtPrice : parseFloat($scope.ciriQbtPrice),
					ciriFirstPrice : parseFloat($scope.ciriFirstPrice),
					ciriSecondPrice : parseFloat($scope.ciriSecondPrice),
					jiriSfPrice : parseFloat($scope.jiriSfPrice),
					jiriQbtPrice : parseFloat($scope.jiriQbtPrice),
					jiriFirstPrice : parseFloat($scope.jiriFirstPrice),
					jiriSecondPrice : parseFloat($scope.jiriSecondPrice),
					geriSfPrice : parseFloat($scope.geriSfPrice),
					geriQbtPrice : parseFloat($scope.geriQbtPrice),
					geriFirstPrice : parseFloat($scope.geriFirstPrice),
					geriSecondPrice : parseFloat($scope.geriSecondPrice)
				}
			}).then(function(data){
				showInfo("更新成功",function(){
					tabOpenParent({name:'priceManage',url:'priceManage.html',displayName:'运费管理'});
				});
			});
			localStorage.removeItem('manages');
		}
	}

	if(manages != '' && manages != null && manages != undefined){
		$scope.getMessage();
		CommonService.httpRequest({
			url : '/baseSfArea/findByParentId.api?parentId=1000000',
			method : 'post',
		}).then(function(data){
			var datas = data.datas;
			$scope.startProvinceses = datas;
			$scope.endProvinceses = datas;
			for(var i = 0; i < datas.length; i++){
				if(datas[i].name == $scope.startProvince){
					var startPro = datas[i].id;
					CommonService.httpRequest({
						url : '/baseSfArea/findByParentId.api?parentId=' + startPro,
						method : 'post',
					}).then(function(data){
						$scope.startProvince = startPro + '|' + $scope.startProvince;
						$scope.startCitieses = data.datas;
						CommonService.httpRequest({
							url : '/baseSfArea/findByParentId.api?parentId=' + startPro,
							method : 'post',
						}).then(function(data){
							var city_data = data.datas;
							for(var i = 0; i < city_data.length; i++){
								if(city_data[i].name == $scope.startCity){
									$scope.startCity  = city_data[i].id + '|' + $scope.startCity;
								}
							}
						});
					});


				}
				if(datas[i].name == $scope.endProvince){
					var endPro = datas[i].id;
					CommonService.httpRequest({
						url : '/baseSfArea/findByParentId.api?parentId=' + endPro,
						method : 'post',
					}).then(function(data){
						$scope.endProvince = endPro + '|' + $scope.endProvince;
						$scope.endCitieses = data.datas;
						CommonService.httpRequest({
							url : '/baseSfArea/findByParentId.api?parentId=' + endPro,
							method : 'post',
						}).then(function(data){
							var city_data = data.datas;
							for(var i = 0; i < city_data.length; i++){
								if(city_data[i].name == $scope.endCity){
									$scope.endCity  = city_data[i].id + '|' + $scope.endCity;
								}
							}
						});
					});
				}
			}
		});
    }
    else{
    	$scope.getProvinces();
    }
}]);
