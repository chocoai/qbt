"use strict";
angular.module("app.views")
.controller('messageActivityDetailCtrl',['$scope','$http','CommonService',function($scope,$http,CommonService){
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
    $scope.clearBusinessTime = function(){
        $scope.businessTime = '';
    }

    $scope.getList = function(id){
       CommonService.httpRequest({
            url : '/baseMatchActivity/findById.api',
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
            $scope.courseId = manages.courseid;
            $scope.sponsor = manages.sponsor;
            $scope.mainSeller = manages.mainSeller;
            $scope.group = manages.group;
            $scope.signWay = manages.signWay;
            $scope.joinNumber  = manages.joinNumber ;
            $scope.activityPerson = manages.activityPerson;
            $scope.activityPersonMobile = manages.activityPersonMobile;
            $scope.joinQbtWay = manages.joinQbtWay;
            $scope.typeNumber  = manages.typeNumber ;
            $scope.valueTotal = parseFloat(manages.valueTotal);
            $scope.courseManager = manages.courseManager;
            $scope.managerFront = manages.managerFront;
            $scope.managerSale = manages.managerSale;
            $scope.brif = manages.brif;
            $scope.activity = manages.activity;
            $scope.manageMobile = manages.manageMobile;
            $scope.managerFrontMobile = manages.managerFrontMobile;
            $scope.managerSaleMobile = manages.managerSaleMobile;
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

            $('#courseText').text(manages.courseName);

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
            showWarn("赛事名称不能为空");
            return false;
        }
        if(!$scope.courseManager){
            showWarn("赛事负责人不能为空");
            return false;
        }
        if(!$scope.manageMobile){
            showWarn("赛事负责人电话不能为空");
            return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.manageMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.manageMobile))){
            }
            else{
                showWarn("赛事负责人电话格式错误");
                return false;
            }
        }
        if(!$scope.foundTime){
            showWarn("赛事成立时间不能为空");
            return false;
        }
        // if(!$scope.managerFront){
        //     showWarn("赛事前台负责人不能为空");
        //     return false;
        // }
        if(!$scope.managerFrontMobile){
            // showWarn("赛事前台负责人电话不能为空");
            // return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.managerFrontMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.managerFrontMobile))){
            }
            else{
                showWarn("赛事前台负责人电话格式错误");
                return false;
            }
        }
        if(!$scope.joinNumber && $scope.joinNumber != 0){
            showWarn("赛事参加人数不能为空");
            return false;
        }
        else{
            if($scope.joinNumber > 999999){
                showWarn("赛事参加人数不能大于999999");
                return false;
            }
            else if(String($scope.joinNumber).indexOf('.') > 0){
                showWarn("赛事参加人数需为整数");
                return false;
            }
        }
        // if(!$scope.managerSale){
        //     showWarn("赛事销售负责人不能为空");
        //     return false;
        // }
        if(!$scope.managerSaleMobile){
            // showWarn("赛事销售负责人前台电话不能为空");
            // return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.managerSaleMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.managerSaleMobile))){
            }
            else{
                showWarn("赛事销售负责人电话格式错误");
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
            showWarn("赛事地址不能为空");
            return false;
        }
        if(!$scope.courseId){
            showWarn("赛事场地不能为空");
            return false;
        }
        if(!!$scope.activityPersonMobile){
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.managerSaleMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.managerSaleMobile))){
            }
            else{
                showWarn("赛事活动推广人员电话格式错误");
                return false;
            }
        }
        // if(!$scope.typeNumber){
        //     showWarn("类型数量不能为空");
        //     return false;
        // }
        // else{
        //     if(String($scope.typeNumber).indexOf('.') > 0){
        //         showWarn("类型数量需为整数");
        //         return false;
        //     }
        //     else if($scope.typeNumber > 999999){
        //         showWarn("类型数量不能大于999999");
        //         return false;
        //     }
        // }
        if(!!$scope.valueTotal){
           if($scope.valueTotal > 999999){
                showWarn("价值总金额不能大于999999");
                return false;
            }
        }
        var provinces = $.trim($('#provinces option:selected').text());
        var cities = $.trim($('#cities option:selected').text());
        var counties = $.trim($('#counties option:selected').text());
        if(!id){
             CommonService.httpRequest({
                url : '/baseMatchActivity/add.api',
                method : 'post',
                data :{
                    foundTime : $scope.foundTime,
                    name : $scope.name,
                    address : $scope.address,
                    courseid : $scope.courseId,
                    type : $scope.type,
		            sponsor : $scope.sponsor,
		            mainSeller : $scope.mainSeller,
		            group : $scope.group,
		            signWay : $scope.signWay,
		            joinNumber : $scope.joinNumber,
		            activityPerson : $scope.activityPerson,
                    activityPersonMobile : $scope.activityPersonMobile,
		            joinQbtWay : $scope.joinQbtWay,
		            typeNumber : $scope.typeNumber,
		            valueTotal : $scope.valueTotal,
		            courseManager : $scope.courseManager,
		            managerFront : $scope.managerFront,
		            managerSale : $scope.managerSale,
		            brif : $scope.brif,
		            activity : $scope.activity,
                    manageMobile : $scope.manageMobile,
                    managerFrontMobile : $scope.managerFrontMobile,
                    managerSaleMobile : $scope.managerSaleMobile,
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
                    tabOpenParent({name:'messageActivity',url:'messageActivity.html',displayName:'赛事活动信息查询'});
                });
            });
        }
        else{
            CommonService.httpRequest({
                url : '/baseMatchActivity/updateById.api',
                method : 'post',
                data :{
                    id:$scope.id,
                    foundTime : $scope.foundTime,
                    name : $scope.name,
                    address : $scope.address,
                    courseid : $scope.courseId,
                    type : $scope.type,
		            sponsor : $scope.sponsor,
		            mainSeller : $scope.mainSeller,
		            group : $scope.group,
		            signWay : $scope.signWay,
		            joinNumber : $scope.joinNumber,
		            activityPerson : $scope.activityPerson,
                    activityPersonMobile : $scope.activityPersonMobile,
		            joinQbtWay : $scope.joinQbtWay,
		            typeNumber : $scope.typeNumber,
		            valueTotal : $scope.valueTotal,
		            courseManager : $scope.courseManager,
		            managerFront : $scope.managerFront,
		            managerSale : $scope.managerSale,
		            brif : $scope.brif,
		            activity : $scope.activity,
                    manageMobile : $scope.manageMobile,
                    managerFrontMobile : $scope.managerFrontMobile,
                    managerSaleMobile : $scope.managerSaleMobile,
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
                    tabOpenParent({name:'messageActivity',url:'messageActivity.html',displayName:'赛事活动信息查询'});
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


    $scope.clearSendCourse = function(){
        $('#courseText').text('选择场地');
        $scope.courseId = '';
        $scope.type = '';
    }

    //球场操作
    $scope.getCourse = function(num){
        CommonService.pagination({
            url : '/course/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.courseName
            }
        }).then(function(data){
            $scope.courses = data.item;
            $scope.page1 = data.page;
        });
    };

    $scope.getMessageEducation = function(num){
        CommonService.pagination({
            url : '/baseTeachCenter/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.educationName
            }
        }).then(function(data){
            $scope.educations = data.item;
            $scope.page2 = data.page;
        });
    };

    $scope.selectCourse = function(){
        $scope.courseName = '';
        $scope.getCourse();
        $scope.getMessageEducation();
            layer.open({    
              type: 1,
              title:'请选择球场或教学中心',
              skin: 'layui-layer-rim', //加上边框
              area: ['850px', '535px'], //宽高
              content: $('#memo'),
            });
        document.onkeydown = '';
    };
    $scope.selectedCourse = function(id,name,type){
        $scope.courseId = id;
        $scope.type = type;
        $('#courseText').text(name);
        layer.closeAll();
        document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                    $('select').blur();
                    $scope.getList();
               }
           };
    };
    //球场操作-end

}]);
