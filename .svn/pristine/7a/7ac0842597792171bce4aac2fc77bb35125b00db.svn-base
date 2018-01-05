"use strict";
angular.module("app.views")
.controller('messageSellDetailCtrl',['$scope','$http','CommonService',function($scope,$http,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    var id = localStorage.getItem('manages');
    $scope.province = '';
    $scope.city = '';
    $scope.county = '';
    
    $scope.isJoinBag = 'true';
    $scope.isFeeBag = 'true';
    $scope.isCollectBag = 'true';

    $scope.isNote = 'true';
    $scope.isDeclare = 'true';
    $scope.isPosts = 'true';
    $scope.isYlb = 'true';
    $scope.isOrder = 'true';
    $scope.isDeclareService = 'true';


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
            url : '/baseSpecialStore/findById.api',
            method : 'get',
            data : {
                id : id
            }
        }).then(function(data){
            var manages = data.datas;
            $scope.id = manages.id;
            $scope.name = manages.name;
            $scope.foundTime = manages.foundTime;
            $scope.manager  = manages.manager;
            $scope.businessTime  = manages.businessTime;
            $scope.storesNumber = manages.storesNumber;
            $scope.businessScope  = manages.businessScope;
            $scope.address = manages.address;
            $scope.lon  = manages.lon;
            $scope.lat  = manages.lat;
            $scope.frontManager = manages.frontManager;
            $scope.managerSale  = manages.managerSale;
            $scope.nearestCourse  = String(manages.nearestCourse);
            $scope.nearestWorkshop  = manages.nearestWorkshop;
            $scope.nearestPracticRange  = manages.nearestPracticRange;
            $scope.nearestRailName  = manages.nearestRailName;
            $scope.nearestRail  = manages.nearestRail;
            $scope.highwayStore  = manages.highwayStore;
            $scope.nearestAirport  = manages.nearestAirport;
            $scope.nearestSf = manages.nearestSf;
            $scope.goodsCompany  = manages.goodsCompany;
            $scope.manageMobile = manages.manageMobile;
            $scope.managerFrontMobile = manages.managerFrontMobile;
            $scope.managerSaleMobile = manages.managerSaleMobile;

            $scope.isJoinBag = manages.isJoinBag + '';
		    $scope.isFeeBag = manages.isFeeBag + '';
		    $scope.isCollectBag = manages.isCollectBag + '';

            $scope.joinBagAddress = manages.joinBagAddress;
            $scope.putBagAddress = manages.putBagAddress;
            $scope.collectBagAddress = manages.collectBagAddress;
            $scope.department = manages.department;
            $scope.bagWorker = manages.bagWorker;
            $scope.bagWorkerMobile = manages.bagWorkerMobile;

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
            showWarn("专卖店名称不能为空");
            return false;
        }
        if(!$scope.manager){
            showWarn("专卖店负责人不能为空");
            return false;
        }
        if(!$scope.manageMobile){
            showWarn("专卖店负责人电话不能为空");
            return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.manageMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.manageMobile))){
            }
            else{
                showWarn("专卖店负责人电话格式错误");
                return false;
            }
        }
        if(!$scope.foundTime){
            showWarn("专卖店成立时间不能为空");
            return false;
        }
        // if(!$scope.frontManager){
        //     showWarn("专卖店前台负责人不能为空");
        //     return false;
        // }
        if(!$scope.managerFrontMobile){
            // showWarn("专卖店前台负责人电话不能为空");
            // return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.managerFrontMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.managerFrontMobile))){
            }
            else{
                showWarn("专卖店前台负责人电话格式错误");
                return false;
            }
        }
         if(!$scope.businessTime){
            showWarn("每日营业时间不能为空");
            return false;
        }
        // if(!$scope.managerSale){
        //     showWarn("专卖店销售负责人不能为空");
        //     return false;
        // }
        if(!$scope.managerSaleMobile){
            // showWarn("专卖店销售负责人前台电话不能为空");
            // return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.managerSaleMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.managerSaleMobile))){
            }
            else{
                showWarn("专卖店销售负责人电话格式错误");
                return false;
            }
        }
        if(!$scope.storesNumber && $scope.storesNumber != 0){
            showWarn("专卖店分店数量不能为空");
            return false;
        }
        else{
            if($scope.storesNumber > 999999){
                showWarn("专卖店分店数量不能大于999999");
                return false;
            }
            else if(String($scope.storesNumber).indexOf('.') > 0){
                showWarn("专卖店分店数量需为整数");
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
            showWarn("专卖店地址不能为空");
            return false;
        }
         if(!$scope.storesNumber && $scope.storesNumber != 0){
            showWarn("专卖店分店数量不能为空");
            return false;
        }
        else{
            if($scope.storesNumber > 999999){
                showWarn("专卖店分店数量不能大于999999");
                return false;
            }
           else if(String($scope.storesNumber).indexOf('.') > 0){
                showWarn("专卖店分店数量需为整数");
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
                url : '/baseSpecialStore/add.api',
                method : 'post',
                data :{
                    name : $scope.name,
                    foundTime : $scope.foundTime,
                    manager : $scope.manager,
                    businessTime : $scope.businessTime,
                    storesNumber : $scope.storesNumber,
                    businessScope : $scope.businessScope,
                    address : $scope.address,
		            lon : $scope.lon,
		            lat : $scope.lat,
                    frontManager : $scope.frontManager,
		            manager : $scope.manager,
		            managerSale : $scope.managerSale,
		            businessScope : $scope.businessScope,
		            nearestCourse : $scope.nearestCourse,
		            nearestWorkshop : $scope.nearestWorkshop,
		            nearestPracticRange : $scope.nearestPracticRange,
		            nearestRailName : $scope.nearestRailName,
		            nearestRail : $scope.nearestRail,
		            highwayStore : $scope.highwayStore,
		            nearestAirport : $scope.nearestAirport,
                    department : $scope.department,
		            goodsCompany : $scope.goodsCompany,
                    nearestSf : $scope.nearestSf,
                    manageMobile : $scope.manageMobile,
                    managerFrontMobile : $scope.managerFrontMobile,
                    managerSaleMobile : $scope.managerSaleMobile,

		            isJoinBag : $scope.isJoinBag == 'true' ? true : false,
				    isFeeBag : $scope.isFeeBag == 'true' ? true : false,
				    isCollectBag : $scope.isCollectBag == 'true' ? true : false,

                    joinBagAddress : $scope.joinBagAddress,
                    putBagAddress : $scope.putBagAddress,
                    collectBagAddress : $scope.collectBagAddress,
                    department : $scope.department,
                    bagWorker : $scope.bagWorker,
                    bagWorkerMobile : $scope.bagWorkerMobile,

                    isNote : $scope.isNote == 'true' ? true : false,
                    isDeclare : $scope.isDeclare == 'true' ? true : false,
                    isPosts : $scope.isPosts == 'true' ? true : false,
                    isYlb : $scope.isYlb == 'true' ? true : false,
                    isOrder : $scope.isOrder == 'true' ? true : false,
                    isDeclareService : $scope.isDeclareService == 'true' ? true : false,

                    treePath : provinces + ',' + cities + ',' + counties,
                    treeId : $scope.province + ',' + $scope.city + ',' + $scope.county,
                    areaId :  $scope.county
                    
                }
            }).then(function(data){
                showInfo("新增成功",function(){
                    tabOpenParent({name:'messageSell',url:'messageSell.html',displayName:'专卖店信息查询'});
                });
            });
        }
        else{
            CommonService.httpRequest({
                url : '/baseSpecialStore/updateById.api',
                method : 'post',
                data :{
                    id:$scope.id,
                    name : $scope.name,
                    foundTime : $scope.foundTime,
                    manager : $scope.manager,
                    businessTime : $scope.businessTime,
                    storesNumber : $scope.storesNumber,
                    businessScope : $scope.businessScope,
                    address : $scope.address,
                    lon : $scope.lon,
                    lat : $scope.lat,
                    frontManager : $scope.frontManager,
                    manager : $scope.manager,
                    managerSale : $scope.managerSale,
                    businessScope : $scope.businessScope,
                    nearestCourse : $scope.nearestCourse,
                    nearestWorkshop : $scope.nearestWorkshop,
                    nearestPracticRange : $scope.nearestPracticRange,
                    nearestRailName : $scope.nearestRailName,
                    nearestRail : $scope.nearestRail,
                    highwayStore : $scope.highwayStore,
                    nearestAirport : $scope.nearestAirport,
                    department : $scope.department,
                    goodsCompany : $scope.goodsCompany,
                    nearestSf : $scope.nearestSf,
                    manageMobile : $scope.manageMobile,
                    managerFrontMobile : $scope.managerFrontMobile,
                    managerSaleMobile : $scope.managerSaleMobile,

                    isJoinBag : $scope.isJoinBag == 'true' ? true : false,
                    isFeeBag : $scope.isFeeBag == 'true' ? true : false,
                    isCollectBag : $scope.isCollectBag == 'true' ? true : false,

                    joinBagAddress : $scope.joinBagAddress,
                    putBagAddress : $scope.putBagAddress,
                    collectBagAddress : $scope.collectBagAddress,
                    department : $scope.department,
                    bagWorker : $scope.bagWorker,
                    bagWorkerMobile : $scope.bagWorkerMobile,

                    isNote : $scope.isNote == 'true' ? true : false,
                    isDeclare : $scope.isDeclare == 'true' ? true : false,
                    isPosts : $scope.isPosts == 'true' ? true : false,
                    isYlb : $scope.isYlb == 'true' ? true : false,
                    isOrder : $scope.isOrder == 'true' ? true : false,
                    isDeclareService : $scope.isDeclareService == 'true' ? true : false,

                    treePath : provinces + ',' + cities + ',' + counties,
                    treeId : $scope.province + ',' + $scope.city + ',' + $scope.county,
                    areaId :  $scope.county
                }
            }).then(function(data){
                showInfo("更新成功",function(){
                    tabOpenParent({name:'messageSell',url:'messageSell.html',displayName:'专卖店信息查询'});
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
