"use strict";
angular.module("app.views")
.controller('messageCourseDetailCtrl',['$scope','$http','CommonService',function($scope,$http,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    var id = localStorage.getItem('manages');
    $scope.province = '';
    $scope.city = '';
    $scope.county = '';
    $scope.isBackLogo  = 'true';
    $scope.isSingleAd = 'true';
    $scope.isWechatDeclare = 'true';
    $scope.isDeclareService = 'true';
    $scope.isWechatGroupDeclare = 'true';
    $scope.isNews = 'true';
    $scope.isWeb = 'true';

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
            url : '/baseBallTeam/findById.api',
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
            $scope.group = manages.group;
            $scope.signWay = manages.signWay;
            $scope.memberNumber  = manages.memberNumber;
            $scope.activityRate = manages.activityRate;
            $scope.joinQbtWay = manages.joinQbtWay;
            $scope.typeNumber = manages.typeNumber;
            $scope.valueTotal = parseFloat(manages.valueTotal);
            $scope.courseManager = manages.courseManager;
            $scope.secretaryManager = manages.secretaryManager;
            $scope.brif = manages.brif;
            $scope.activity = manages.activity;
            $scope.manageMobile = manages.manageMobile;
            $scope.secretaryManagerMobile = manages.secretaryManagerMobile;
            $scope.lon = manages.lon;
            $scope.lat = manages.lat;

            $scope.isBackLogo   = manages.isBackLogo  + '';
            $scope.isSingleAd  = manages.isSingleAd + '';
            $scope.isWechatDeclare  = manages.isWechatDeclare + '';
            $scope.isDeclareService  = manages.isDeclareService + '';
            $scope.isWechatGroupDeclare  = manages.isWechatGroupDeclare + '';
            $scope.isNews  = manages.isNews + '';
            $scope.isWeb  = manages.isWeb + '';
            $scope.qbtWay = manages.qbtWay;

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
            showWarn("球队不能为空");
            return false;
        }
        if(!$scope.courseManager){
            showWarn("球队负责人不能为空");
            return false;
        }
        if(!$scope.manageMobile){
            showWarn("球队负责人电话不能为空");
            return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.manageMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.manageMobile))){
            }
            else{
                showWarn("球队负责人电话格式错误");
                return false;
            }
        }
        if(!$scope.foundTime){
            showWarn("球队成立时间不能为空");
            return false;
        }
        // if(!$scope.secretaryManager){
        //     showWarn("球队秘书负责人不能为空");
        //     return false;
        // }
        if(!$scope.secretaryManagerMobile){
            // showWarn("球队秘书负责人电话不能为空");
            // return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.secretaryManagerMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.secretaryManagerMobile))){
            }
            else{
                showWarn("球队秘书负责人电话格式错误");
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
            showWarn("球队地址不能为空");
            return false;
        }
        if(!$scope.memberNumber && $scope.memberNumber != 0){
            showWarn("球队会员人数不能为空");
            return false;
        }
        else{
            if($scope.memberNumber > 999999){
                showWarn("赛球队会员人数不能大于999999");
                return false;
            }
            else if(String($scope.memberNumber).indexOf('.') > 0){
                showWarn("球队会员人数需为整数");
                return false;
            }
        }
        // if(!!$scope.typeNumber){
        //     if($scope.typeNumber > 999999){
        //         showWarn("类型数量不能大于999999");
        //         return false;
        //     }
        //     else if(String($scope.typeNumber).indexOf('.') > 0){
        //         showWarn("类型数量需为整数");
        //         return false;
        //     }
        // }
        // if(!!$scope.valueTotal){
        //    if($scope.valueTotal > 999999){
        //         showWarn("价值总金额不能大于999999");
        //         return false;
        //     }
        // }
        var provinces = $.trim($('#provinces option:selected').text());
        var cities = $.trim($('#cities option:selected').text());
        var counties = $.trim($('#counties option:selected').text());
        if(!id){
             CommonService.httpRequest({
                url : '/baseBallTeam/add.api',
                method : 'post',
                data :{
                    foundTime : $scope.foundTime,
                    name : $scope.name,
                    address : $scope.address,
                    group : $scope.group,
		            signWay : $scope.signWay,
		            memberNumber : $scope.memberNumber,
		            activityRate : $scope.activityRate,
		            joinQbtWay : $scope.joinQbtWay,
		            typeNumber : $scope.typeNumber,
		            valueTotal : $scope.valueTotal,
		            courseManager : $scope.courseManager,
		            secretaryManager : $scope.secretaryManager,
		            brif : $scope.brif,
		            activity : $scope.activity,
                    manageMobile : $scope.manageMobile,
                    secretaryManagerMobile : $scope.secretaryManagerMobile,
                    lon : $scope.lon,
                    lat : $scope.lat,

		            isBackLogo : $scope.isBackLogo == 'true' ? true : false,
		            isSingleAd : $scope.isSingleAd == 'true' ? true : false,
		            isWechatDeclare : $scope.isWechatDeclare == 'true' ? true : false,
		            isDeclareService : $scope.isDeclareService == 'true' ? true : false,
		            isWechatGroupDeclare : $scope.isWechatGroupDeclare == 'true' ? true : false,
		            isNews : $scope.isNews == 'true' ? true : false,
		            isWeb : $scope.isWeb == 'true' ? true : false,
		            qbtWay : $scope.qbtWay,

		            isNote : $scope.isNote == 'true' ? true : false,
		            isDeclare : $scope.isDeclare == 'true' ? true : false,
		            isYlb : $scope.isYlb == 'true' ? true : false,

                    treePath : provinces + ',' + cities + ',' + counties,
                    treeId : $scope.province + ',' + $scope.city + ',' + $scope.county,
                    areaId :  $scope.county
                    
                }
            }).then(function(data){
                showInfo("新增成功",function(){
                    tabOpenParent({name:'messageCourse',url:'messageCourse.html',displayName:'球队信息查询'});
                });
            });
        }
        else{
            CommonService.httpRequest({
                url : '/baseBallTeam/updateById.api',
                method : 'post',
                data :{
                    id:$scope.id,
                    foundTime : $scope.foundTime,
                    name : $scope.name,
                    address : $scope.address,
                    group : $scope.group,
		            signWay : $scope.signWay,
		            memberNumber : $scope.memberNumber,
		            activityRate : $scope.activityRate,
		            joinQbtWay : $scope.joinQbtWay,
		            typeNumber : $scope.typeNumber,
		            valueTotal : $scope.valueTotal,
		            courseManager : $scope.courseManager,
		            secretaryManager : $scope.secretaryManager,
		            brif : $scope.brif,
		            activity : $scope.activity,
                    manageMobile : $scope.manageMobile,
                    secretaryManagerMobile : $scope.secretaryManagerMobile,
                    lon : $scope.lon,
                    lat : $scope.lat,

		            isBackLogo : $scope.isBackLogo == 'true' ? true : false,
		            isSingleAd : $scope.isSingleAd == 'true' ? true : false,
		            isWechatDeclare : $scope.isWechatDeclare == 'true' ? true : false,
		            isDeclareService : $scope.isDeclareService == 'true' ? true : false,
		            isWechatGroupDeclare : $scope.isWechatGroupDeclare == 'true' ? true : false,
		            isNews : $scope.isNews == 'true' ? true : false,
		            isWeb : $scope.isWeb == 'true' ? true : false,
		            qbtWay : $scope.qbtWay,

		            isNote : $scope.isNote == 'true' ? true : false,
		            isDeclare : $scope.isDeclare == 'true' ? true : false,
		            isYlb : $scope.isYlb == 'true' ? true : false,

                    treePath : provinces + ',' + cities + ',' + counties,
                    treeId : $scope.province + ',' + $scope.city + ',' + $scope.county,
                    areaId :  $scope.county
                }
            }).then(function(data){
                showInfo("更新成功",function(){
                    tabOpenParent({name:'messageCourse',url:'messageCourse.html',displayName:'球队信息查询'});
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
