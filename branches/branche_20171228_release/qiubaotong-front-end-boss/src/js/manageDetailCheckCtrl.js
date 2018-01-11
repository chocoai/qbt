"use strict";
angular.module("app.views")
.controller('manageDetailCheckCtrl',['$scope','CommonService',function($scope,CommonService){
	$('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.roleIdList = [];
	$scope.platforms = [
		{platId : 1 , platName : "球包通平台"},
		{platId : 2 , platName : "高付通平台"},
		{platId : 0 , platName : "基础平台"}
	];
    $scope.getList = function(num){

    	CommonService.httpRequest({
            method : 'get',
            url : '/adminSysRole/list.api'
        }).then(function(data){
			var list = data.datas;
			$scope.allRoles = [];
			for(var i = 0; i<$scope.platforms.length ; i++){
				var plat = $scope.platforms[i];
				var sublist = data.datas.filter(function(item){return item.platId === plat.platId});
				if(sublist.length>0){
					var item = {platId : plat.platId, platName:plat.platName, items : sublist};
					$scope.allRoles.push(item);
				}
			}
        });

       var manages = localStorage.getItem('manages');
       if(manages != '' && manages != null && manages != undefined){
	       manages = JSON.parse(manages);
	       $scope.roleId = manages.id;
	       $scope.name = manages.name;
	       $scope.email = manages.email;
	       $scope.mobile = manages.mobile;
	       $scope.roleIdList = manages.roleIdList;
       }
    }

    $scope.getList();
    $scope.isSelected = function(id){
    	return $scope.roleIdList.indexOf(id) >= 0;
    }

    $scope.isClick = function(id){
    	if($scope.roleIdList.indexOf(id) == -1){
    		$scope.roleIdList.push(id);
    	}
    	else{
            var idx = $scope.roleIdList.indexOf(id);
    		$scope.roleIdList.splice(idx,1);
    	}
    }

    $scope.manage_add = function(){

        if(!$scope.name){
            showWarn("用户名称不能为空");
            return false;
        }
        if(!$scope.email){
            showWarn("邮箱不能为空");
            return false;
        }
        else{
            var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
            if(!(reg.test($scope.email))){
                showWarn("邮箱格式错误");
                return false;
            }
        }
        if(!$scope.mobile){
            showWarn("手机号码不能为空");
            return false;
        }
        else{
            if(!(/^1[3|4|5|7|8]\d{9}$/.test($scope.mobile))){
                showWarn("手机号码格式错误");
                return false;
            }
        }
        if($scope.roleIdList.length <= 0){
            showWarn('角色不能为空');
            return false;
        }

        if(!$scope.roleId){
        	 //add
            CommonService.httpRequest({
                method : 'post',
                url : '/adminUser/add.api',
                data :{
                    name : $scope.name,
                    email : $scope.email,
                    mobile : $scope.mobile,
                    roleIdList : $scope.roleIdList
                }
            }).then(function(data){
                $scope.name = "";
                $scope.email = "";
                $scope.mobile = "";
                showInfo("新增成功",function(){
                    tabOpenParent({name:'manageCheck',url:'manageCheck.html',displayName:'平台用户管理'});
                });
            });
        }
        else{
        	CommonService.httpRequest({
                method : 'post',
                url : '/adminUser/update.api',
                data :{
                	id : $scope.roleId,
                    name : $scope.name,
                    email : $scope.email,
                    mobile : $scope.mobile,
                    roleIdList : $scope.roleIdList
                }
            }).then(function(data){
                showInfo("更新成功",function(){
                    tabOpenParent({name:'manageCheck',url:'manageCheck.html',displayName:'平台用户管理'});
                });
            });
            localStorage.removeItem('manages');
        }

}


}]);
