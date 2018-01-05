"use strict";
angular.module("app.views")
.controller('serviceManageDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.level = '1';
    $scope.types = '0';
    $scope.userNameFromUpdate = '选择用户名称';
    $scope.getUser = function(num){
        CommonService.pagination({
                url : '/userWeixin/findByPage.api',
                data :{
                    pageNo : num || "1",
                    name : $scope.userName
                }
            }).then(function(data){
                $scope.users = data.item;
                $scope.page1 = data.page;
            });
    }
    $scope.getList = function(num){
        $scope.getUser();
        var manages = localStorage.getItem('manages');
        if(manages != '' && manages != null){
           manages = JSON.parse(manages);
           $scope.id = manages.id;
           $scope.name = manages.name;
           $scope.mobile = manages.mobile;
           $scope.level = manages.level + '';
           $scope.types = manages.type + '';
           $scope.desc = manages.desc;
           $scope.userId = manages.userId + '';
           CommonService.httpRequest({
                method : 'get',
                url : '/userWeixin/findById.api',
                data:{
                    id : manages.userId
                }
            }).then(function(data){
                $scope.userNameFromUpdate = data.datas.name;
            });
       }
    }
    $scope.getList();

    $scope.selectUser = function(item){
        $scope.selectedCoupun = item;
        $scope.getUser(1);
        layer.open({    
              type: 1,
              title:'请选择分发的用户',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo'),
              end: function(){
                $scope.userName = '';
              }
            });
    }

    $scope.selectedUser = function(id,name){
        $scope.userId = id;
        $('#userText').text(name);
        layer.closeAll();
    }


    $scope.addServerManage = function(){

        if(!$scope.name){
            showWarn("客服名称不能为空");
            return false;
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
        if(!$scope.level){
            showWarn("客服等级不能为空");
            return false;
        }
        if(!$scope.types){
            showWarn("客服分类不能为空");
            return false;
        }
        if(!$scope.userId){
            showWarn("用户名称不能为空");
            return false;
        }

    	if(!$scope.id){
    		CommonService.httpRequest({
	            method : 'post',
	            url : '/kf/add.api',
	            data:{
	            	userId : parseInt($scope.userId),
	            	name : $scope.name,
	            	mobile : $scope.mobile,
	            	level : parseInt($scope.level),
	            	type : parseInt($scope.types),
	            	desc : $scope.desc
	            }
	        }).then(function(data){
                showInfo("新增成功",function(){
                     tabOpenParent({name:'serviceManage',url:'serviceManage.html',displayName:'客服用户信息管理'});
                });
            });
    	}
    	else{
    		CommonService.httpRequest({
	            method : 'post',
	            url : '/kf/update.api',
	            data:{
	            	id : $scope.id,
	            	userId : parseInt($scope.userId),
	            	name : $scope.name,
	            	mobile : $scope.mobile,
	            	level : $scope.level,
	            	type : $scope.types
	            }
	        }).then(function(data){
                showInfo("更新成功",function(){
                    tabOpenParent({name:'serviceManage',url:'serviceManage.html',displayName:'客服用户信息管理'});
                });
            });
            localStorage.removeItem('manages');
    	}
    }

}]);
