"use strict";
angular.module("app.views")
.controller('messageTravelDetailCtrl',['$scope','$http','CommonService',function($scope,$http,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    var id = localStorage.getItem('manages');
    $scope.province = '';
    $scope.city = '';
    $scope.county = '';
    $scope.isWechatDeclare = 'true';
    $scope.isOrder = 'true';
    $scope.isNote = 'true';
    $scope.isDeclare = 'true';
    $scope.isYlb = 'true';


    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight : true
    });
    $scope.clearCreateTime = function(){
        $scope.foundTime = '';
    }

    $scope.getList = function(id){
       CommonService.httpRequest({
            url : '/baseTravelAgency/findById.api',
            method : 'get',
            data : {
                id : id
            }
        }).then(function(data){
            var manages = data.datas;
            $scope.id = manages.id;
            $scope.foundTime = manages.foundTime;
            $scope.name = manages.name;
            $scope.address = manages.address;
            $scope.homeRouteNumber = manages.homeRouteNumber;
            $scope.abroadRouteNumber = manages.abroadRouteNumber;
            $scope.group = manages.group;
            $scope.manager = manages.manager;
            $scope.brif = manages.brif;
            $scope.frontManager = manages.frontManager;
            $scope.activity = manages.activity;
            $scope.lon = manages.lon;
            $scope.lat = manages.lat;
            $scope.manageMobile = manages.manageMobile;
            $scope.managerFrontMobile = manages.managerFrontMobile;

            $scope.isWechatDeclare  = manages.isWechatDeclare + '';
            $scope.qbtWay = manages.qbtWay;
            $scope.isOrder  = manages.isOrder + '';

            $scope.isNote = manages.isNote + '';
            $scope.isDeclare = manages.isDeclare + '';
            $scope.isYlb = manages.isYlb + '';

            $scope.treeId = manages.treeId.split(',');
            $scope.province = $scope.treeId[0];
            $scope.city = $scope.treeId[1];
            $scope.county = $scope.treeId[2];
            CommonService.httpRequest({
                url : '/baseSfArea/findByParentId.api?parentId=' + $scope.province,
                method : 'post',
            }).then(function(data){
                $scope.citieses = data.datas;
            });
            CommonService.httpRequest({
                url : '/baseSfArea/findByParentId.api?parentId=' + $scope.city,
                method : 'post',
            }).then(function(data){
                $scope.countieses = data.datas;
                $scope.parentId = data.datas.parentId;
            });
        });
    }

    
    $scope.addBankBranches = function(){

        if(!$scope.name){
            showWarn("旅行社名称不能为空");
            return false;
        }
        if(!$scope.manager){
            showWarn("旅行社负责人不能为空");
            return false;
        }
        if(!$scope.manageMobile){
            showWarn("旅行社负责人电话不能为空");
            return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.manageMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.manageMobile))){
            }
            else{
                showWarn("旅行社负责人电话格式错误");
                return false;
            }
        }
        if(!$scope.foundTime){
            showWarn("旅行社成立时间不能为空");
            return false;
        }
        // if(!$scope.frontManager){
        //     showWarn("旅行社前台负责人不能为空");
        //     return false;
        // }
        if(!$scope.managerFrontMobile){
            // showWarn("旅行社前台负责人电话不能为空");
            // return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.managerFrontMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.managerFrontMobile))){
            }
            else{
                showWarn("旅行社前台负责人电话格式错误");
                return false;
            }
        }
        if(!$scope.province){
            showWarn("所在省不能为空");
            return false;
        }
        if(!$scope.city){
            showWarn("所在市不能为空");
            return false;
        }
        if(!$scope.county){
            showWarn("所在区不能为空");
            return false;
        }
        if(!$scope.address){
            showWarn("旅行社地址不能为空");
            return false;
        }
        if(!!$scope.homeRouteNumber){
            if($scope.homeRouteNumber > 999999){
                showWarn("国内线路数量不能大于999999");
                return false;
            }
            else if(String($scope.homeRouteNumber).indexOf('.') > 0){
                showWarn("国内线路数量需为整数");
                return false;
            }
        }
        if(!!$scope.abroadRouteNumber){
            if($scope.abroadRouteNumber > 999999){
                showWarn("出境游线路数量不能大于999999");
                return false;
            }
            else if(String($scope.abroadRouteNumber).indexOf('.') > 0){
                showWarn("出境游线路数量需为整数");
                return false;
            }
        }
        var provinces = $.trim($('#provinces option:selected').text());
        var cities = $.trim($('#cities option:selected').text());
        var counties = $.trim($('#counties option:selected').text());
        if(!id){
             CommonService.httpRequest({
                url : '/baseTravelAgency/add.api',
                method : 'post',
                data :{
                    foundTime : $scope.foundTime,
                    name : $scope.name,
                    address : $scope.address,
                    homeRouteNumber : $scope.homeRouteNumber,
		            abroadRouteNumber : $scope.abroadRouteNumber,
		            group : $scope.group,
		            manager : $scope.manager,
		            brif : $scope.brif,
                    frontManager : $scope.frontManager,
                    activity : $scope.activity,
                    lon : $scope.lon,
                    lat : $scope.lat,
                    manageMobile : $scope.manageMobile,
                    managerFrontMobile : $scope.managerFrontMobile,
		            
		            isWechatDeclare : $scope.isWechatDeclare == 'true' ? true : false,
		            qbtWay : $scope.qbtWay,
		            isOrder : $scope.isOrder == 'true' ? true : false,

		            isNote : $scope.isNote == 'true' ? true : false,
		            isDeclare : $scope.isDeclare == 'true' ? true : false,
		            isYlb : $scope.isYlb == 'true' ? true : false,

                    treePath : provinces + ',' + cities + ',' + counties,
                    treeId : $scope.province + ',' + $scope.city + ',' + $scope.county,
                    areaId :  $scope.county
                    
                }
            }).then(function(data){
                showInfo("新增成功",function(){
                    tabOpenParent({name:'messageTravel',url:'messageTravel.html',displayName:'旅行社信息查询'});
                });
            });
        }
        else{
            CommonService.httpRequest({
                url : '/baseTravelAgency/updateById.api',
                method : 'post',
                data :{
                    id:$scope.id,
                    foundTime : $scope.foundTime,
                    name : $scope.name,
                    address : $scope.address,
                    homeRouteNumber : $scope.homeRouteNumber,
		            abroadRouteNumber : $scope.abroadRouteNumber,
		            group : $scope.group,
		            manager : $scope.manager,
		            brif : $scope.brif,
                    frontManager : $scope.frontManager,
                    activity : $scope.activity,
                    lon : $scope.lon,
                    lat : $scope.lat,
                    manageMobile : $scope.manageMobile,
                    managerFrontMobile : $scope.managerFrontMobile,
		            
		            isWechatDeclare : $scope.isWechatDeclare == 'true' ? true : false,
		            qbtWay : $scope.qbtWay,
		            isOrder : $scope.isOrder == 'true' ? true : false,

		            isNote : $scope.isNote == 'true' ? true : false,
		            isDeclare : $scope.isDeclare == 'true' ? true : false,
		            isYlb : $scope.isYlb == 'true' ? true : false,

                    treePath : provinces + ',' + cities + ',' + counties,
                    treeId : $scope.province + ',' + $scope.city + ',' + $scope.county,
                    areaId :  $scope.county
                }
            }).then(function(data){
                showInfo("更新成功",function(){
                    tabOpenParent({name:'messageTravel',url:'messageTravel.html',displayName:'旅行社信息查询'});
                });
            });
            localStorage.removeItem('manages');
           
        }
        
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
        $scope.getLatLon($scope.address);
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
        $scope.getLatLon($scope.address);
    }


    if(!!id){
        $scope.getList(id);
    }

    $scope.getLatLon = function(keyword){
        var aheadKeyWord = '';
        if(!!$scope.province){
            aheadKeyWord = aheadKeyWord + $.trim($('#provinces option:selected').text());
        }
        if(!!$scope.city){
            aheadKeyWord = aheadKeyWord + $.trim($('#cities option:selected').text());
        }
        if(!!$scope.county){
            aheadKeyWord = aheadKeyWord + $.trim($('#counties option:selected').text());
        }
        keyword = aheadKeyWord + keyword;
       $http.jsonp("http://api.map.baidu.com/geocoder/v2/?ak=h5t9oFdFVTh9Hih6oy0jNOc27LiB2qDm&coordtype=wgs84ll&output=json&address="+ keyword +"&callback=JSON_CALLBACK")
       .success(function(data){
            if(data.status == 0){
                var address = data.result.location;
                if(!!address){
                    $scope.lat = address.lat;
                    $scope.lon = address.lng;
                }
            }
            else{
                $scope.lat = '';
                $scope.lon = '';
            }
        });
    };


}]);
