"use strict";
angular.module("app.views")
.controller('findCourseCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
	$('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.course_status_types = Constants.course_status_type;
    $scope.list = [];
    $scope.province = '';
    $scope.city = '';
    $scope.county = '';
    $scope.areaId = '';
    $scope.getList = function(num){
        var isDelete = $scope.isDelete;
        var isOutRange = $scope.isOutRange;
        if(!!isDelete){
            isDelete = isDelete == 'true' ? true : false;
        }
        if(!!isOutRange){
            isOutRange = isOutRange == 'true' ? true : false;
        }
        CommonService.pagination({
        	url : '/course/findByPage.api',
        	data :{
        		pageNo : num || "1",
                name : $scope.course_name,
                areaId : $scope.areaId,
                isDelete : isDelete,
                status : $scope.status,
                isOutRange : isOutRange
            }
        }).then(function(data){
        	$scope.list = data.item;
        	$scope.page = data.page;
        });
    }
    $scope.getList(1);


    $scope.findCourse = function(){
        $scope.getList(1);
    }

    $scope.addCourse = function(){
        tabOpenParent({name:'addCourse_add',url:'addCourse.html',displayName:'增加球场'});
    }
    $scope.updateCourse = function(item){
        tabOpenParent({name:'addCourse_update'+item,url:'addCourse.html?id='+item,displayName:'球场更新'+item});
    }

    $scope.getProvinces = function(){
        CommonService.httpRequest({
            url : '/baseSfArea/findByParentId.api?parentId=1000000',
            method : 'post',
        }).then(function(data){
            $scope.provinceses = data.datas;
        });
    }
    $scope.getProvinces();
    $scope.getCitieses = function(){
        if(!!$scope.province){
            CommonService.httpRequest({
                url : '/baseSfArea/findByParentId.api?parentId=' + $scope.province,
                method : 'post',
            }).then(function(data){
                $scope.citieses = data.datas;
            });

        }
        else{
            $scope.citieses = '';
            $scope.countieses = '';
        }
        $scope.city = '';
        $scope.county = '';
    }
    $scope.getCounties = function(){
        if(!!$scope.city){
            CommonService.httpRequest({
                url : '/baseSfArea/findByParentId.api?parentId=' + $scope.city,
                method : 'post',
            }).then(function(data){
                $scope.countieses = data.datas;
            });
        }
        else{
            $scope.countieses = '';
        }
        $scope.county = '';
    }
    $scope.AreaFindCourse = function(){
        $scope.areaId = $scope.county;
        if(!$scope.county){
            $scope.areaId = $scope.city;
            if(!$scope.city){
                $scope.areaId = $scope.province;
            }
        }
        $scope.getList();

    }

    $scope.toTheCourse = function(id){
        localStorage.setItem('manages',id);
        tabOpenParent({name:'courseUserCheck',url:'courseUserCheck.html',displayName:'球场助理查询'});
    }

    $scope.bankDisabled = function(id,isDelete){
      CommonService.httpRequest({
                  url : '/course/delete.api',
                  method : 'get',
                  data :{
                      id : id,
                      isDelete: isDelete ? false : true
                  }
              }).then(function(data){
                  if(isDelete){
                    showInfo("启用成功",function(){
                      location.href = 'findCourse.html';
                    });
                  }
                  else{
                    showInfo("禁用成功",function(){
                      location.href = 'findCourse.html';
                    });
                  }
                  
              });
    };

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                   $('select').blur();
                   $scope.AreaFindCourse();
               }
           };

}]);
