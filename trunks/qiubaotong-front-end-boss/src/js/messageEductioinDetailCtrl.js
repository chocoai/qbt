"use strict";
angular.module("app.views")
.controller('messageEductioinDetailCtrl',['$scope','$http','CommonService',function($scope,$http,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    var id = localStorage.getItem('manages');
    $scope.province = '';
    $scope.city = '';
    $scope.county = '';
    $scope.isHotel = 'true';
    $scope.isSign = 'true';
    $scope.isJoinBag = 'true';
    $scope.isFeeBag = 'true';
    $scope.isCollectBag = 'true';
    $scope.isNote = 'true';
    $scope.isDeclare = 'true';
    $scope.isPosts = 'true';
    $scope.isYlb = 'true';
    $scope.isOrder = 'true';
    $scope.isDeclareService = 'true';
    $scope.isAreaLimit = 'true';
    $scope.isCarLimit = 'true';


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
            url : '/baseTeachCenter/findById.api',
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
            $scope.isHotel = manages.isHotel+'';
            $scope.hotelAddress = manages.hotelAddress;
            $scope.hotelRoomNumber = manages.hotelRoomNumber;
            $scope.hotelLevel = manages.hotelLevel;
            $scope.isSign = manages.isSign+'';
            $scope.teacherNumber = manages.teacherNumber;
            $scope.lon = manages.lon;
            $scope.lat = manages.lat;
            $scope.manager = manages.manager;
            $scope.managerFront = manages.managerFront;
            $scope.managerSale = manages.managerSale;
            $scope.manageMobile = manages.manageMobile;
            $scope.managerFrontMobile = manages.managerFrontMobile;
            $scope.managerSaleMobile = manages.managerSaleMobile;
            $scope.isAreaLimit  = manages.isAreaLimit+'';
            $scope.isCarLimit  = manages.isCarLimit+'';
            $scope.brif = manages.brif;
            $scope.lightVigorousTime = manages.lightVigorousTime;
            $scope.businessTime = manages.businessTime;
            $scope.playerNumber  = manages.playerNumber ;
            $scope.lightVigorousNumber = manages.lightVigorousNumber;
            $scope.outPlayerNumber  = manages.outPlayerNumber ;
            $scope.localPlayerNumber  = manages.localPlayerNumber ;
            $scope.nearestDeliver  = manages.nearestDeliver ;
            $scope.goodsCompany  = manages.goodsCompany ;
            $scope.temperature  = manages.temperature ;
            $scope.rain  = manages.rain ;
            $scope.nearestHotel  = manages.nearestHotel ;
            $scope.nearestHotelAddress  = manages.nearestHotelAddress ;
            $scope.nearestHotelRoomNumber  = parseInt(manages.nearestHotelRoomNumber) ;
            $scope.nearestHotelLevel  = parseInt(manages.nearestHotelLevel);
            $scope.nearestRailName  = manages.nearestRailName ;
            $scope.nearestRail  = manages.nearestRail ;
            $scope.highwayCourse  = manages.highwayCourse ;
            $scope.nearestAirport  = manages.nearestAirport ;
            $scope.nearestCourse  = manages.nearestCourse ;
            $scope.joinBagAddress = manages.joinBagAddress;
            $scope.putBagAddress = manages.putBagAddress;
            $scope.collectBagAddress = manages.collectBagAddress;
            $scope.department = manages.department;
            $scope.bagWorker = manages.bagWorker;
            $scope.bagWorkerMobile = manages.bagWorkerMobile;

            $scope.isJoinBag = manages.isJoinBag + '';
		    $scope.isFeeBag = manages.isFeeBag + '';
		    $scope.isCollectBag = manages.isCollectBag + '';

            $scope.isNote = manages.isNote + '';
            $scope.isDeclare = manages.isDeclare + '';
            $scope.isPosts = manages.isPosts + '';
            $scope.isYlb = manages.isYlb + '';
            $scope.isOrder = manages.isOrder + '';
            $scope.isDeclareService = manages.isDeclareService + '';

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
            showWarn("教学中心名称不能为空");
            return false;
        }
        if(!$scope.manager){
            showWarn("教学中心负责人不能为空");
            return false;
        }
        if(!$scope.manageMobile){
            showWarn("教学中心负责人电话不能为空");
            return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.manageMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.manageMobile))){
            }
            else{
                showWarn("教学中心负责人电话格式错误");
                return false;
            }
        }
        if(!$scope.foundTime){
            showWarn("教学中心成立时间不能为空");
            return false;
        }
        // if(!$scope.managerFront){
        //     showWarn("教学中心前台负责人不能为空");
        //     return false;
        // }
        if(!$scope.managerFrontMobile){
            // showWarn("教学中心前台负责人电话不能为空");
            // return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.managerFrontMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.managerFrontMobile))){
            }
            else{
                showWarn("教学中心前台负责人电话格式错误");
                return false;
            }
        }
        if(!$scope.teacherNumber && $scope.teacherNumber != 0){
            showWarn("教学中心教练人数不能为空");
            return false;
        }
        else{
            if($scope.teacherNumber > 999999){
                showWarn("教学中心教练人数不能大于999999");
                return false;
            }
           else if(String($scope.teacherNumber).indexOf('.') > 0){
                showWarn("教学中心教练人数需为整数");
                return false;
            }
        }
        // if(!$scope.managerSale){
        //     showWarn("教学中心销售负责人不能为空");
        //     return false;
        // }
        if(!$scope.managerSaleMobile){
            // showWarn("教学中心销售负责人电话不能为空");
            // return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.managerSaleMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.managerSaleMobile))){
            }
            else{
                showWarn("教学中心销售负责人电话格式错误");
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
            showWarn("教学中心地址不能为空");
            return false;
        }
        if(!!$scope.hotelRoomNumber){
            if($scope.hotelRoomNumber > 999999){
                showWarn("教学中心酒店客房数量不能大于999999");
                return false;
            }
           else if(String($scope.hotelRoomNumber).indexOf('.') > 0){
                showWarn("教学中心酒店客房数量需为整数");
                return false;
            }
        }
        if(!!$scope.hotelLevel){
            if($scope.hotelLevel > 999999){
                showWarn("教学中心酒店等级不能大于999999");
                return false;
            }
           else if(String($scope.hotelLevel).indexOf('.') > 0){
                showWarn("教学中心酒店等级需为整数");
                return false;
            }
        }
        if(!$scope.businessTime){
            showWarn("每日营业时间不能为空");
            return false;
        }
        if(!$scope.playerNumber && $scope.playerNumber != 0){
            showWarn("每年打球人次不能为空");
            return false;
        }
        else{
            if($scope.playerNumber > 999999){
                showWarn("每年打球人次不能大于999999");
                return false;
            }
        }
        if(!$scope.outPlayerNumber && $scope.outPlayerNumber != 0){
            showWarn("外地人打球人次不能为空");
            return false;
        }
        else{
            if($scope.outPlayerNumber > 999999){
                showWarn("外地人打球人次不能大于999999");
                return false;
            }
        }
        if(!$scope.localPlayerNumber && $scope.localPlayerNumber != 0){
            showWarn("本地人打球人次不能为空");
            return false;
        }
        else{
            if($scope.localPlayerNumber > 999999){
                showWarn("本地人打球人次不能大于999999");
                return false;
            }
        }
        if(!!$scope.nearestHotelRoomNumber){
            if($scope.nearestHotelRoomNumber > 999999){
                showWarn("最近酒店客房房间数量不能大于999999");
                return false;
            }
           else if(String($scope.nearestHotelRoomNumber).indexOf('.') > 0){
                showWarn("最近酒店客房房间数量需为整数");
                return false;
            }
        }
        if(!!$scope.nearestHotelLevel){
            if($scope.nearestHotelLevel > 999999){
                showWarn("最近酒店等级不能大于999999");
                return false;
            }
           else if(String($scope.nearestHotelLevel).indexOf('.') > 0){
                showWarn("最近酒店等级需为整数");
                return false;
            }
        }
        if(!!$scope.bagWorkerMobile){
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.bagWorkerMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.bagWorkerMobile))){
            }
            else{
                showWarn("球包负责人电话格式错误");
                return false;
            }
        }

        var provinces = $.trim($('#provinces option:selected').text());
        var cities = $.trim($('#cities option:selected').text());
        var counties = $.trim($('#counties option:selected').text());
        if(!id){
             CommonService.httpRequest({
                url : '/baseTeachCenter/add.api',
                method : 'post',
                data :{
                    foundTime : $scope.foundTime,
                    name : $scope.name,
                    address : $scope.address,
                    isHotel : $scope.isHotel == 'true' ? true : false,
		            hotelAddress : $scope.hotelAddress,
		            hotelRoomNumber : $scope.hotelRoomNumber,
		            hotelLevel : $scope.hotelLevel,
		            isSign : $scope.isSign == 'true' ? true : false,
		            teacherNumber : $scope.teacherNumber,
		            lon : $scope.lon,
		            lat : $scope.lat,
		            manager : $scope.manager,
		            managerFront : $scope.managerFront,
		            managerSale : $scope.managerSale,
		            isAreaLimit : $scope.isAreaLimit == 'true' ? true : false,
		            isCarLimit : $scope.isCarLimit == 'true' ? true : false,
		            brif : $scope.brif,
		            lightVigorousTime : $scope.lightVigorousTime,
		            businessTime : $scope.businessTime,
		            playerNumber : $scope.playerNumber,
		            lightVigorousNumber : $scope.lightVigorousNumber,
		            outPlayerNumber : $scope.outPlayerNumber,
		            localPlayerNumber : $scope.localPlayerNumber,
		            nearestDeliver : $scope.nearestDeliver,
		            goodsCompany : $scope.goodsCompany,
		            temperature : $scope.temperature,
		            rain : $scope.rain,
		            nearestHotel : $scope.nearestHotel,
		            nearestHotelAddress : $scope.nearestHotelAddress,
		            nearestHotelRoomNumber : $scope.nearestHotelRoomNumber,
		            nearestHotelLevel : $scope.nearestHotelLevel,
		            nearestRailName : $scope.nearestRailName,
		            nearestRail : $scope.nearestRail,
		            highwayCourse : $scope.highwayCourse,
		            nearestAirport : $scope.nearestAirport,
		            nearestCourse : $scope.nearestCourse,
                    joinBagAddress : $scope.joinBagAddress,
                    putBagAddress : $scope.putBagAddress,
                    collectBagAddress : $scope.collectBagAddress,
                    department : $scope.department,
                    bagWorker : $scope.bagWorker,
                    bagWorkerMobile : $scope.bagWorkerMobile,
                    manageMobile : $scope.manageMobile,
                    managerFrontMobile : $scope.managerFrontMobile,
                    managerSaleMobile : $scope.managerSaleMobile,

		            isJoinBag : $scope.isJoinBag == 'true' ? true : false,
				    isFeeBag : $scope.isFeeBag == 'true' ? true : false,
				    isCollectBag : $scope.isCollectBag == 'true' ? true : false,

                    isNote : $scope.isNote == 'true' ? true : false,
                    isDeclare : $scope.isDeclare == 'true' ? true : false,
                    isPosts : $scope.isPosts == 'true' ? true : false,
                    isYlb : $scope.isYlb == 'true' ? true : false,
                    isOrder : $scope.isOrder == 'true' ? true : false,
                    isDeclareService : $scope.isDeclareService == 'true' ? true : false,

                    treeId : $scope.province + ',' + $scope.city + ',' + $scope.county,
                    areaId :  $scope.county
                    
                }
            }).then(function(data){
                showInfo("新增成功",function(){
                    tabOpenParent({name:'messageEductioin',url:'messageEductioin.html',displayName:'教育中心信息查询'});
                });
            });
        }
        else{
            CommonService.httpRequest({
                url : '/baseTeachCenter/updateById.api',
                method : 'post',
                data :{
                    id:$scope.id,
                    foundTime : $scope.foundTime,
                    name : $scope.name,
                    address : $scope.address,
                    isHotel : $scope.isHotel == 'true' ? true : false,
                    hotelAddress : $scope.hotelAddress,
                    hotelRoomNumber : $scope.hotelRoomNumber,
                    hotelLevel : $scope.hotelLevel,
                    isSign : $scope.isSign == 'true' ? true : false,
                    teacherNumber : $scope.teacherNumber,
                    lon : $scope.lon,
                    lat : $scope.lat,
                    manager : $scope.manager,
                    managerFront : $scope.managerFront,
                    managerSale : $scope.managerSale,
                    isAreaLimit : $scope.isAreaLimit == 'true' ? true : false,
                    isCarLimit : $scope.isCarLimit == 'true' ? true : false,
                    brif : $scope.brif,
                    lightVigorousTime : $scope.lightVigorousTime,
                    businessTime : $scope.businessTime,
                    playerNumber : $scope.playerNumber,
                    lightVigorousNumber : $scope.lightVigorousNumber,
                    outPlayerNumber : $scope.outPlayerNumber,
                    localPlayerNumber : $scope.localPlayerNumber,
                    matchTime : $scope.matchTime,
                    nearestDeliver : $scope.nearestDeliver,
                    goodsCompany : $scope.goodsCompany,
                    temperature : $scope.temperature,
                    rain : $scope.rain,
                    nearestHotel : $scope.nearestHotel,
                    nearestHotelAddress : $scope.nearestHotelAddress,
                    nearestHotelRoomNumber : $scope.nearestHotelRoomNumber,
                    nearestHotelLevel : $scope.nearestHotelLevel,
                    nearestRailName : $scope.nearestRailName,
                    nearestRail : $scope.nearestRail,
                    highwayCourse : $scope.highwayCourse,
                    nearestAirport : $scope.nearestAirport,
                    nearestCourse : $scope.nearestCourse,
                    joinBagAddress : $scope.joinBagAddress,
                    putBagAddress : $scope.putBagAddress,
                    collectBagAddress : $scope.collectBagAddress,
                    department : $scope.department,
                    bagWorker : $scope.bagWorker,
                    bagWorkerMobile : $scope.bagWorkerMobile,
                    manageMobile : $scope.manageMobile,
                    managerFrontMobile : $scope.managerFrontMobile,
                    managerSaleMobile : $scope.managerSaleMobile,

                    isJoinBag : $scope.isJoinBag == 'true' ? true : false,
                    isFeeBag : $scope.isFeeBag == 'true' ? true : false,
                    isCollectBag : $scope.isCollectBag == 'true' ? true : false,

                    isNote : $scope.isNote == 'true' ? true : false,
                    isDeclare : $scope.isDeclare == 'true' ? true : false,
                    isPosts : $scope.isPosts == 'true' ? true : false,
                    isYlb : $scope.isYlb == 'true' ? true : false,
                    isOrder : $scope.isOrder == 'true' ? true : false,
                    isDeclareService : $scope.isDeclareService == 'true' ? true : false,

                    treeId : $scope.province + ',' + $scope.city + ',' + $scope.county,
                    areaId :  $scope.county
                }
            }).then(function(data){
                showInfo("更新成功",function(){
                    tabOpenParent({name:'messageEductioin',url:'messageEductioin.html',displayName:'教育中心信息查询'});
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
