"use strict";
angular.module("app.views",['ngFileUpload'])
.controller('addCourseCtrl',['$scope','$http','CommonService','Upload',function($scope,$http,CommonService,Upload){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.fBaseUrl = fBaseUrl;
    $scope.persons = [];
    $scope.lat = '';
    $scope.lon = '';
    $scope.orderToCourse = CommonService.getQueryString('orderToCourse');
    $scope.addrType = CommonService.getQueryString('addrType');
    var id = CommonService.getQueryString('id');
    $scope.golfHole = '0';
    $scope.courseStatus = '1';
    $scope.hasAssistant = 'false';
    $scope.province = '';
    $scope.city = '';
    $scope.county = '';
    $scope.isDelete = 'false';
    $scope.isOutRange = 'false';
    $scope.outRangeTime = 0;
    $scope.outRangePrice = 0;
    $scope.isTip = 'false';
    $scope.wechatTip = '';

    $scope.isHotel = 'true';
    $scope.hotelAreaLimit = 'true';
    $scope.hotelCarLimit = 'true';
    $scope.isFee = 'true';

    $scope.isJoinBag = 'true';
    $scope.isFeeBag = 'true';
    $scope.isCollectBag = 'true';
    $scope.isNote = 'true';
    $scope.isDeclare = 'true';
    $scope.isPosts = 'true';
    $scope.isYlb = 'true';
    $scope.isOrder = 'true';
    $scope.isDeclareService = 'true';
    $scope.isPractice = 'false';

    $scope.SFSites = {
        isAdd : false,
        id : '',
        content : '',
        contentMobile : '',
        name : '',
        address : '',
        treeId : '',
        siteNumber : '',
        province : '',
        city : '',
        county : '',
        provinceses : '',
        citieses : '',
        countieses : ''

    };

    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight : true
    });
    $scope.clearCreateTime = function(){
        $scope.startTime = '';
    }

    $scope.getList = function(id){
       CommonService.httpRequest({
            url : '/course/detail.api',
            method : 'get',
            data : {
                id : id
            }
        }).then(function(data){
            var manages = data.datas;
           $scope.id = manages.id;
           $scope.courseName = manages.name;
           $scope.englishName = manages.englishName;
           $scope.initial = manages.initial;
           $scope.firstLetter = manages.firstLetter;
           $scope.shortName = manages.shortName;
           $scope.logo = manages.logo;
           $scope.website = manages.website;
           $scope.wechat = manages.wechat;
           $scope.signPlace = manages.signPlace;
           $scope.sendPlace = manages.sendPlace;
           $scope.golfHole = manages.golfHole + '';
           $scope.courseStatus = manages.status + '';
           $scope.hasAssistant = manages.hasAssistant + '';
           $scope.isDelete = manages.isDelete + '';
           $scope.address = manages.address;
           $scope.mobile = manages.mobile;
           $scope.contact = manages.contact;
           $scope.telephone = manages.telephone;
           $scope.desc = manages.description;
           $scope.remark = manages.remark;
           $scope.treePath = manages.treePath;
           $scope.province = manages.treeId.split(',')[0];
           $scope.city = manages.treeId.split(',')[1];
           $scope.county = manages.treeId.split(',')[2];
           $scope.lon = manages.lon;
           $scope.lat = manages.lat;
           $scope.isOutRange = manages.isOutRange + '';
           $scope.outRangeTime = manages.outRangeTime;
           $scope.outRangePrice = manages.outRangePrice;
           $scope.isTip = manages.isTip + '';
           $scope.wechatTip = manages.wechatTip;

           $scope.restTime = manages.restTime;
           $scope.otherPlayerNumber = manages.otherPlayerNumber;
           $scope.goodsCompany = manages.goodsCompany;
           $scope.nearestPracticeArea = manages.nearestPracticeArea;
           $scope.nearestHotelAddress = manages.nearestHotelAddress;
           $scope.nearestAirport = manages.nearestAirport;
           $scope.managerSale = manages.managerSale;
           $scope.urgentPersonWechat = manages.urgentPersonWechat;

           $scope.joinBagAddress = manages.joinBagAddress;
           $scope.putBagAddress = manages.putBagAddress;
           $scope.collectBagAddress = manages.collectBagAddress;
           $scope.department = manages.department;
           $scope.bagWorker = manages.bagWorker;
           $scope.bagWorkerMobile = manages.bagWorker;
           $scope.nightAddress = manages.nightAddress;
           $scope.courseWorker = manages.courseWorker;
           $scope.courseFrontWorker = manages.courseFrontWorker;
           $scope.police = manages.police;
           $scope.urgentPerson = manages.urgentPerson;
           $scope.manageMobile = manages.manageMobile;
           $scope.managerFrontMobile = manages.managerFrontMobile;
           $scope.managerSaleMobile = manages.managerSaleMobile;

           $scope.hotelAddress = manages.hotelAddress;
            $scope.isHotel = manages.isHotel + '';
            $scope.hotelRoomNumber = manages.hotelRoomNumber;
            $scope.hotelLevel = manages.hotelLevel;
            $scope.hotelAreaLimit = manages.hotelAreaLimit+'';
            $scope.hotelCarLimit = manages.hotelCarLimit+'';
            $scope.isFee = manages.isFee+'';
            $scope.startTime = manages.startTime;
            $scope.brief = manages.brief;
            $scope.checkMessage = manages.checkMessage;

            $scope.lightVigorousTime = manages.lightVigorousTime;
            $scope.businessTime = manages.businessTime;
            $scope.playerNumber  = manages.playerNumber ;
            $scope.lightVigorousPlayer = manages.lightVigorousPlayer;
            $scope.localPlayerNumber  = manages.localPlayerNumber ;
            $scope.nearestSf  = manages.nearestSf ;
            $scope.siteTime  = manages.siteTime ;
            $scope.sfTime  = manages.sfTime ;
            $scope.temperature  = manages.temperature ;
            $scope.rain  = manages.rain ;
            $scope.nearestWorkshop  = manages.nearestWorkshop ;
            $scope.nearestHotel  = manages.nearestHotel ;
            $scope.nearestHotelRoomNumber  = manages.nearestHotelRoomNumber ;
            $scope.nearestHotelLevel  = manages.nearestHotelLevel ;
            $scope.nearestRail  = manages.nearestRail ;
            $scope.nearestHightRail = manages.nearestHightRail;
            $scope.highwayCourse  = manages.highwayCourse ;

            $scope.isJoinBag = manages.isJoinBag + '';
            $scope.isFeeBag = manages.isFeeBag + '';
            $scope.isCollectBag = manages.isCollectBag + '';

            $scope.isNote = manages.isNote + '';
            $scope.isDeclare = manages.isDeclare + '';
            $scope.isPosts = manages.isPosts + '';
            $scope.isYlb = manages.isYlb + '';
            $scope.isOrder = manages.isOrder + '';
            $scope.isDeclareService = manages.isDeclareService + '';
            $scope.isPractice = manages.isPractice + '';

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
                // $scope.parentId = data.datas.parentId;
            });
        });
    };
    $scope.getCoursePerson = function(id){
        CommonService.httpRequest({
                  url : '/userAssistantApply/list.api',
                  method : 'get',
                  data :{
                      applyId : id,
                      applyType:1
                  }
              }).then(function(data){
                  $scope.persons = data.datas;
              });
    };
    $scope.getSFs = function(page){
        CommonService.pagination({
                  url : '/baseCourseSfSite/findByPage.api',
                  method : 'post',
                  data :{
                    pageNo : page || 1,
                    courseId : parseInt(id),
                    name : $scope.SFSelectName,
                    address : $scope.SFSelectAddress,
                    siteNumber : $scope.SFSelectSiteNumber,
                    content : $scope.SFSelectContent,
                    contentMobile : $scope.SFSelectContentMobile
                  }
              }).then(function(data){
                  $scope.sfs = data.item;
                  $scope.page2 = data.page;
              });
    }
    $scope.getCourseOrder = function(page){
        CommonService.pagination({
            url : '/order/findByPage.api',
            data :{
                pageNo : page || 1,
                addrType : $scope.addrType,
                addrId : id
            }
        }).then(function(data){
            $scope.orders = data.item;
            $scope.page1 = data.page;
        });
    };
    $scope.detail = function(id){
        tabOpenParent({
            name:'orderDetail' +id,
            url:'orderDetail.html?id='+id,
            displayName: '订单' + id
        });
    };
    $scope.isOutRangeValue = function(){
        if($scope.isOutRange == 'false'){
            $scope.outRangeTime = 0;
            $scope.outRangePrice = 0;
        }
        else{
            $scope.outRangeTime = '';
            $scope.outRangePrice = '';
        }
    }

    if(!!id){
        $scope.getList(id);
        $scope.getCoursePerson(id);
        $scope.getCourseOrder();
        $scope.getSFs();
    }

    $scope.uploadImg = function($file){
        if($file){
            var isIntegrate = false;
            if($file.size > (10 * 1024 * 1024)){
                showWarn('上传的图片过大'); return;
            }
            var filetypes = [
                //ie9
                // "jfif", "jpe", "dib",
                //
                'image/png', 'image/jpeg', 'image/jpg'
                // 'image/bmp', "image/jfif", "image/dib", "image/jpe"
            ];
            var i = filetypes.indexOf($file.type);
            if (i < 0){
                showWarn('上传的图片格式不正确'); return;
            };
            Upload.upload({
                url: baseUrl + '/common/imageUpload.api',
                method:'post',
                data:{
                    image: $file
                }
            }).progress(function(evt) {//上传进度
                layer.load(1, {
                  shade: [0.1,'#fff']
                });
            }).then(function(data, status, headers, config){
                layer.closeAll();
                showInfo("上传成功！");
                $scope.logo = data.data.datas;
                if(data.data.message){
                    showErr(data.data.message);
                }
            })
        }
    };

    $scope.addCourse = function(){
        var reg = new RegExp(/[a-zA-Z]/)
        if(!$scope.courseName){
            showWarn("球场名称不能为空");
            return false;
        }
        if(!$scope.shortName){
            showWarn("简称不能为空");
            return false;
        }
				if(!$scope.firstLetter){
					showWarn("名称简拼不能为空");
					return false;
				}
				if(!reg.test($scope.firstLetter)){
          showWarn("名称简拼只能输入英文字母");
          return false;
        }
        if(!$scope.province){
            showWarn("省不能为空");
            return false;
        }
        if(!$scope.city){
            showWarn("市不能为空");
            return false;
        }
        if(!$scope.county){
            showWarn("区不能为空");
            return false;
        }
        if(!$scope.address){
            showWarn("详细地址不能为空");
            return false;
        }
        if(!$scope.lon && $scope.lon != 0){
            showWarn("经度不能为空");
            return false;
        }
        else{
            if($scope.lon > 180){
                showWarn('经度范围：0~180');
                return false;
            }
        }
        if(!$scope.lat && $scope.lat != 0){
            showWarn("纬度不能为空");
            return false;
        }
        else{
            if($scope.lat > 90){
                showWarn('纬度范围：0~90');
                return false;
            }
        }
        if($scope.isOutRange == 'true'){
            if((!$scope.outRangeTime  && $scope.outRangeTime !== 0) || (!$scope.outRangePrice && $scope.outRangePrice !== 0)){
                showWarn('偏远球场时效和偏远球场价格不能为空');
                return false;
            }
            else if($scope.outRangeTime%0.5 != 0 && $scope.outRangeTime%1 != 0){
                showWarn('偏远球场时效为0.5进阶');
                return false;
            }
            else if($scope.outRangeTime > 999999.9 || $scope.outRangePrice > 999999.9){
                showWarn('偏远球场时效和偏远球场价格不能大于999999.9');
                return false;
            }
        }
        if($scope.isTip == 'true'){
            if(!$scope.wechatTip){
                showWarn('提示语不能为空');
                return false;
            }
        }
        if(!!$scope.playerNumber){
            if($scope.playerNumber > 999999){
                showWarn("每年打球人次不能大于999999");
                return false;
            }
        }
        if(!!$scope.localPlayerNumber){
            if($scope.localPlayerNumber > 999999){
                showWarn("本地打球人次不能大于999999");
                return false;
            }
        }
        if(!!$scope.otherPlayerNumber){
            if($scope.otherPlayerNumber > 999999){
                showWarn("外地打球人次不能大于999999");
                return false;
            }
        }
        if(!!$scope.nearestHotelRoomNumber){
            if($scope.nearestHotelRoomNumber > 999999){
                showWarn("最近酒店客房数量不能大于999999");
                return false;
            }
            else if(String($scope.nearestHotelRoomNumber).indexOf('.') > 0){
                showWarn("最近酒店客房数量需为整数");
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
        // if(!$scope.courseWorker){
        //     showWarn("球场负责人不能为空");
        //     return false;
        // }
        if(!$scope.manageMobile){
            // showWarn("球场负责人电话不能为空");
            // return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.manageMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.manageMobile))){
            }
            else{
                showWarn("球场负责人电话格式错误");
                return false;
            }
        }
        // if(!$scope.courseFrontWorker){
        //     showWarn("球场前台负责人不能为空");
        //     return false;
        // }
        if(!$scope.managerFrontMobile){
            // showWarn("球场前台负责人电话不能为空");
            // return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.managerFrontMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.managerFrontMobile))){
            }
            else{
                showWarn("球场前台负责人电话格式错误");
                return false;
            }
        }
        // if(!$scope.managerSale){
        //     showWarn("球场销售负责人不能为空");
        //     return false;
        // }
        if(!$scope.managerSaleMobile){
            // showWarn("球场销售负责人前台电话不能为空");
            // return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.managerSaleMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.managerSaleMobile))){
            }
            else{
                showWarn("球场销售负责人电话格式错误");
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
        // if(!!$scope.telephone){
        //     if(!(/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.telephone))){
        //         showWarn('联系电话格式错误');
        //         return false;
        //     }
        // }
        // if(!!$scope.mobile){
        //     if(!(/^1[3|4|5|7|8]\d{9}$/.test($scope.mobile))){
        //         showWarn("手机号码格式错误");
        //         return false;
        //     }
        // }


        var provinces = $.trim($('#provinces option:selected').text());
        var cities = $.trim($('#cities option:selected').text());
        var counties = $.trim($('#counties option:selected').text());
        if(!id){
            CommonService.httpRequest({
                url : '/course/add.api',
                method : 'post',
                data :{
                    name:$scope.courseName,
                    englishName:$scope.englishName,
                    shortName:$scope.shortName,
                    initial:$scope.initial,
                    firstLetter:$scope.firstLetter,
                    logo:$scope.logo,
                    website:$scope.website,
                    wechat:$scope.wechat,
                    signPlace:$scope.signPlace,
                    sendPlace:$scope.sendPlace,
                    golfHole:parseInt($scope.golfHole),
                    status:parseInt($scope.courseStatus),
                    hasAssistant:$scope.hasAssistant == 'true' ? true : false,
                    isDelete: $scope.isDelete == 'true' ? true : false,
                    treePath :provinces + ',' + cities + ',' + counties,
                    address:$scope.address,
                    mobile:$scope.mobile,
                    contact:$scope.contact,
                    telephone:$scope.telephone,
                    description:$scope.desc,
                    remark : $scope.remark,
                    areaId :  $scope.county,
                    lon:parseFloat($scope.lon),
                    lat:parseFloat($scope.lat),
                    isOutRange:$scope.isOutRange == 'true' ? true : false,
                    outRangeTime:$scope.outRangeTime,
                    outRangePrice:$scope.outRangePrice,
                    isTip:$scope.isTip == 'true' ? true : false,
                    wechatTip:$scope.wechatTip,

                    restTime : $scope.restTime,
                    otherPlayerNumber : $scope.otherPlayerNumber,
                    goodsCompany : $scope.goodsCompany,
                    nearestPracticeArea : $scope.nearestPracticeArea,
                    nearestHotelAddress : $scope.nearestHotelAddress,
                    nearestAirport : $scope.nearestAirport,
                    managerSale : $scope.managerSale,
                    urgentPersonWechat : $scope.urgentPersonWechat,

                    joinBagAddress : $scope.joinBagAddress,
                    putBagAddress : $scope.putBagAddress,
                    collectBagAddress : $scope.collectBagAddress,
                    department : $scope.department,
                    bagWorker : $scope.bagWorker,
                    bagWorkerMobile : $scope.bagWorkerMobile,
                    nightAddress : $scope.nightAddress,
                    courseWorker : $scope.courseWorker,
                    courseFrontWorker : $scope.courseFrontWorker,
                    police : $scope.police,
                    urgentPerson : $scope.urgentPerson,
                    manageMobile : $scope.manageMobile,
                    managerFrontMobile : $scope.managerFrontMobile,
                    managerSaleMobile : $scope.managerSaleMobile,

                    hotelAddress : $scope.hotelAddress,
                    isHotel : $scope.isHotel == 'true' ? true : false,
                    hotelRoomNumber : $scope.hotelRoomNumber,
                    hotelLevel : $scope.hotelLevel,
                    hotelAreaLimit : $scope.hotelAreaLimit == 'true' ? true : false,
                    hotelCarLimit : $scope.hotelCarLimit == 'true' ? true : false,
                    isFee : $scope.isFee == 'true' ? true : false,
                    startTime : $scope.startTime,
                    brief : $scope.brief,
                    checkMessage : $scope.checkMessage,

                    lightVigorousTime : $scope.lightVigorousTime,
                    businessTime : $scope.businessTime,
                    playerNumber : $scope.playerNumber,
                    lightVigorousPlayer : $scope.lightVigorousPlayer,
                    localPlayerNumber : $scope.localPlayerNumber,
                    nearestSf : $scope.nearestSf,
                    siteTime : $scope.siteTime,
                    sfTime : $scope.sfTime,
                    temperature : $scope.temperature,
                    rain : $scope.rain,
                    nearestWorkshop : $scope.nearestWorkshop,
                    nearestHotel : $scope.nearestHotel,
                    nearestHotelRoomNumber : $scope.nearestHotelRoomNumber,
                    nearestHotelLevel : $scope.nearestHotelLevel,
                    nearestRail : $scope.nearestRail,
                    nearestHightRail : $scope.nearestHightRail,
                    highwayCourse : $scope.highwayCourse,

                    isJoinBag : $scope.isJoinBag == 'true' ? true : false,
                    isFeeBag : $scope.isFeeBag == 'true' ? true : false,
                    isCollectBag : $scope.isCollectBag == 'true' ? true : false,

                    isNote : $scope.isNote == 'true' ? true : false,
                    isDeclare : $scope.isDeclare == 'true' ? true : false,
                    isPosts : $scope.isPosts == 'true' ? true : false,
                    isYlb : $scope.isYlb == 'true' ? true : false,
                    isOrder : $scope.isOrder == 'true' ? true : false,
                    isDeclareService : $scope.isDeclareService == 'true' ? true : false,
                    isPractice : $scope.isPractice == 'true' ? true : false
                }
            }).then(function(data){
                showInfo("新增成功",function(){
                    tabOpenParent({name:'findCourse',url:'findCourse.html',displayName:'球场查询'});
                });
            });
        }
        else{
             CommonService.httpRequest({
                url : '/course/update.api',
                method : 'post',
                data :{
                    id:$scope.id,
                    name:$scope.courseName,
                    englishName:$scope.englishName,
                    shortName:$scope.shortName,
                    initial:$scope.initial,
                    firstLetter:$scope.firstLetter,
                    logo:$scope.logo,
                    website:$scope.website,
                    wechat:$scope.wechat,
                    signPlace:$scope.signPlace,
                    sendPlace:$scope.sendPlace,
                    golfHole:parseInt($scope.golfHole),
                    status:parseInt($scope.courseStatus),
                    hasAssistant:$scope.hasAssistant == 'true' ? true : false,
                    isDelete: $scope.isDelete == 'true' ? true : false,
                    treePath :provinces + ',' + cities + ',' + counties,
                    address:$scope.address,
                    mobile:$scope.mobile,
                    contact:$scope.contact,
                    telephone:$scope.telephone,
                    description:$scope.desc,
                    remark:$scope.remark,
                    areaId :  $scope.county,
                    lon:parseFloat($scope.lon),
                    lat:parseFloat($scope.lat),
                    isOutRange:$scope.isOutRange == 'true' ? true : false,
                    outRangeTime:$scope.outRangeTime,
                    outRangePrice:$scope.outRangePrice,
                    isTip:$scope.isTip == 'true' ? true : false,
                    wechatTip:$scope.wechatTip,

                    restTime : $scope.restTime,
                    otherPlayerNumber : $scope.otherPlayerNumber,
                    goodsCompany : $scope.goodsCompany,
                    nearestPracticeArea : $scope.nearestPracticeArea,
                    nearestHotelAddress : $scope.nearestHotelAddress,
                    nearestAirport : $scope.nearestAirport,
                    managerSale : $scope.managerSale,
                    urgentPersonWechat : $scope.urgentPersonWechat,
                    manageMobile : $scope.manageMobile,
                    managerFrontMobile : $scope.managerFrontMobile,
                    managerSaleMobile : $scope.managerSaleMobile,

                    joinBagAddress : $scope.joinBagAddress,
                    putBagAddress : $scope.putBagAddress,
                    collectBagAddress : $scope.collectBagAddress,
                    department : $scope.department,
                    bagWorker : $scope.bagWorker,
                    bagWorkerMobile : $scope.bagWorkerMobile,
                    nightAddress : $scope.nightAddress,
                    courseWorker : $scope.courseWorker,
                    courseFrontWorker : $scope.courseFrontWorker,
                    police : $scope.police,
                    urgentPerson : $scope.urgentPerson,


                    hotelAddress : $scope.hotelAddress,
                    isHotel : $scope.isHotel == 'true' ? true : false,
                    hotelRoomNumber : $scope.hotelRoomNumber,
                    hotelLevel : $scope.hotelLevel,
                    hotelAreaLimit : $scope.hotelAreaLimit == 'true' ? true : false,
                    hotelCarLimit : $scope.hotelCarLimit == 'true' ? true : false,
                    isFee : $scope.isFee == 'true' ? true : false,
                    startTime : $scope.startTime,
                    brief : $scope.brief,
                    checkMessage : $scope.checkMessage,

                    lightVigorousTime : $scope.lightVigorousTime,
                    businessTime : $scope.businessTime,
                    playerNumber : $scope.playerNumber,
                    lightVigorousPlayer : $scope.lightVigorousPlayer,
                    localPlayerNumber : $scope.localPlayerNumber,
                    nearestSf : $scope.nearestSf,
                    siteTime : $scope.siteTime,
                    sfTime : $scope.sfTime,
                    temperature : $scope.temperature,
                    rain : $scope.rain,
                    nearestWorkshop : $scope.nearestWorkshop,
                    nearestHotel : $scope.nearestHotel,
                    nearestHotelRoomNumber : $scope.nearestHotelRoomNumber,
                    nearestHotelLevel : $scope.nearestHotelLevel,
                    nearestRail : $scope.nearestRail,
                    nearestHightRail : $scope.nearestHightRail,
                    highwayCourse : $scope.highwayCourse,

                    isJoinBag : $scope.isJoinBag == 'true' ? true : false,
                    isFeeBag : $scope.isFeeBag == 'true' ? true : false,
                    isCollectBag : $scope.isCollectBag == 'true' ? true : false,

                    isNote : $scope.isNote == 'true' ? true : false,
                    isDeclare : $scope.isDeclare == 'true' ? true : false,
                    isPosts : $scope.isPosts == 'true' ? true : false,
                    isYlb : $scope.isYlb == 'true' ? true : false,
                    isOrder : $scope.isOrder == 'true' ? true : false,
                    isDeclareService : $scope.isDeclareService == 'true' ? true : false,
                    isPractice : $scope.isPractice == 'true' ? true : false
                }
            }).then(function(data){
                showInfo("更新成功",function(){
                    tabOpenParent({name:'findCourse',url:'findCourse.html',displayName:'球场查询'});
                });
            });

        }
    	localStorage.removeItem('manages');
    }
    $scope.getProvinces = function(){
        CommonService.httpRequest({
            url : '/baseSfArea/findByParentId.api?parentId=1000000',
            method : 'post',
        }).then(function(data){
            $scope.provinceses = data.datas;
            $scope.SFSites.provinceses = data.datas;
        });
    }
    $scope.getProvinces();
    $scope.getCitieses = function(type){
        if(type == 1){
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
        else{
            if(!!$scope.SFSites.province){
                CommonService.httpRequest({
                    url : '/baseSfArea/findByParentId.api?parentId=' + $scope.SFSites.province,
                    method : 'post',
                }).then(function(data){
                    $scope.SFSites.citieses = data.datas;
                });
            }
            else{
                $scope.SFSites.citieses = '';
                $scope.SFSites.countieses = '';
            }
            $scope.SFSites.city = '';
            $scope.SFSites.county = '';
        }
    }
    $scope.getCounties = function(type){
        if(type == 1){
            if(!!$scope.city){
                CommonService.httpRequest({
                    url : '/baseSfArea/findByParentId.api?parentId=' + $scope.city,
                    method : 'post',
                }).then(function(data){
                    $scope.countieses = data.datas;
                    $scope.parentId = data.datas.parentId;
                });
            }
            else{
                $scope.countieses = '';
            }
            $scope.county = '';
            $scope.getLatLon($scope.address);
        }
        else{
            if(!!$scope.SFSites.city){
                CommonService.httpRequest({
                    url : '/baseSfArea/findByParentId.api?parentId=' + $scope.SFSites.city,
                    method : 'post',
                }).then(function(data){
                    $scope.SFSites.countieses = data.datas;
                    $scope.SFSites.parentId = data.datas.parentId;
                });
            }
            else{
                $scope.SFSites.countieses = '';
            }
            $scope.SFSites.county = '';
        }
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

    $scope.isWeixin = function(mobile,id){
        CommonService.httpRequest({
          url : '/userWeixin/isWeiXinUser.api',
          method : 'get',
          data:{
            mobile:mobile
          }
          }).then(function(data){
            if(data.datas.isWeiXin){
                if(data.datas.idList.length > 1){
                    tabOpenParent({name:'userCheck'+data.datas.idList[0],url:'userCheck.html?mobileOfMoreWeixin='+mobile,displayName:'微信用户查询'+data.datas.idList[0]});
                }
                else{
                    $scope.userDetail(data.datas.idList[0]);
                }
            }
            else{
                $scope.mobileDetail(mobile,id);
            }
        });
    };
    $scope.mobileDetail = function(mobile,id){
        tabOpenParent({
            name:'contactCheckDetail_update'+id,
            url:'contactCheckDetail.html?mobile='+mobile,
            displayName:'客户信息详情'+id
        });
    };
     $scope.userDetail = function(id){
        tabOpenParent({name:'userCheckDetail'+id,url:'userCheckDetail.html?id='+id,displayName:'用户详情查询'+id});
    };

    $scope.courseDetail = function(id,type){
        tabOpenParent({
            name:'addCourse_update'+id,
            url:'addCourse.html?id='+id+'&orderToCourse=1'+'&addrType='+type,
            displayName:'球场详情'+id
        });
    };

    $scope.toDisable = function(id1){
      layer.confirm('确定设置为禁用吗？', {
          btn: ['确定','取消'] //按钮
        }, function(index){
          CommonService.httpRequest({
                  url : '/userAssistantApply/updateStatus.api',
                  method : 'post',
                  data :{
                      assistantId : parseInt(id1),
                      status:'4'
                  }
              }).then(function(data){
                $scope.getCoursePerson(id);
                layer.close(index);
                  // tabOpenParent({name:'findCourse'+id,url:'findCourse.html',displayName:'球场查询'});
              });
        }, function(index){
          layer.close(index);
        });
    };

    $scope.toEnable = function(id1){
      layer.confirm('确定设置为启用吗？', {
          btn: ['确定','取消'] //按钮
        }, function(index){
          CommonService.httpRequest({
                  url : '/userAssistantApply/updateStatus.api',
                  method : 'post',
                  data :{
                      assistantId : parseInt(id1),
                      status:'5'
                  }
              }).then(function(data){
                $scope.getCoursePerson(id);
                layer.close(index);
              });
        }, function(index){
          layer.close(index);
        });
    };

    $scope.addSFs = function(){
        $scope.SFSites.isAdd = true;
        $scope.SFSites.id = '';
        $scope.SFSites.name = '';
        $scope.SFSites.siteNumber = '';
        $scope.SFSites.content = '';
        $scope.SFSites.contentMobile = '';
        $scope.SFSites.province = '';
        $scope.SFSites.city = '';
        $scope.SFSites.county = '';
        $scope.SFSites.address = '';
    };
    $scope.addToCheck = function(){
        $scope.SFSites.isAdd = false;
    };
    $scope.updateSFSites = function(id){
        CommonService.httpRequest({
          url : '/baseCourseSfSite/findById.api',
          method : 'get',
          data :{
              id : id
          }
      }).then(function(data){
            var manages = data.datas;
            $scope.SFSites.id = manages.id;
            $scope.SFSites.content = manages.content;
            $scope.SFSites.contentMobile = manages.contentMobile;
            $scope.SFSites.siteNumber = manages.siteNumber;
            $scope.SFSites.name = manages.name;
            $scope.SFSites.address = manages.address;
            $scope.SFSites.province = manages.treeId.split(',')[0];
            $scope.SFSites.city = manages.treeId.split(',')[1];
            $scope.SFSites.county = manages.treeId.split(',')[2];
            CommonService.httpRequest({
                url : '/baseSfArea/findByParentId.api?parentId=' + $scope.SFSites.province,
                method : 'post',
            }).then(function(data){
                $scope.SFSites.citieses = data.datas;
            });
            CommonService.httpRequest({
                url : '/baseSfArea/findByParentId.api?parentId=' + $scope.SFSites.city,
                method : 'post',
            }).then(function(data){
                $scope.SFSites.countieses = data.datas;
            });
            $scope.SFSites.isAdd = true;
        });
    }
    $scope.addSFSites = function(){
        if(!$scope.SFSites.name){
            showWarn("网点名称不能为空");
            return false;
        }
        if(!$scope.SFSites.siteNumber){
            showWarn("网点编号不能为空");
            return false;
        }
        if(!$scope.SFSites.content){
            showWarn("联系人不能为空");
            return false;
        }
        if(!$scope.SFSites.contentMobile){
            showWarn("电话不能为空");
            return false;
        }
        if(!$scope.SFSites.province){
            showWarn("省不能为空");
            return false;
        }
        if(!$scope.SFSites.city){
            showWarn("市不能为空");
            return false;
        }
        if(!$scope.SFSites.county){
            showWarn("区不能为空");
            return false;
        }
        if(!$scope.SFSites.address){
            showWarn("地址不能为空");
            return false;
        }
        var provinces = $.trim($('#SFprovinces option:selected').text());
        var cities = $.trim($('#SFcities option:selected').text());
        var counties = $.trim($('#SFcounties option:selected').text());
        if(!$scope.SFSites.id){
            CommonService.httpRequest({
              url : '/baseCourseSfSite/add.api',
              method : 'post',
              data :{
                  name : $scope.SFSites.name,
                  courseId : parseInt(id),
                  areaId : $scope.SFSites.county,
                  address : $scope.SFSites.address,
                  siteNumber : $scope.SFSites.siteNumber,
                  content : $scope.SFSites.content,
                  contentMobile : $scope.SFSites.contentMobile,
                  treePath :provinces + ',' + cities + ',' + counties,
                  }
              }).then(function(data){
                showInfo("新增成功",function(){
                    $scope.getSFs();
                    $scope.SFSites.isAdd = false;
                });
            }); 
        }
        else{
            CommonService.httpRequest({
              url : '/baseCourseSfSite/updateById.api',
              method : 'post',
              data :{
                  id : $scope.SFSites.id,
                  name : $scope.SFSites.name,
                  courseId : parseInt(id),
                  areaId : $scope.SFSites.county,
                  address : $scope.SFSites.address,
                  siteNumber : $scope.SFSites.siteNumber,
                  content : $scope.SFSites.content,
                  contentMobile : $scope.SFSites.contentMobile,
                  treePath :provinces + ',' + cities + ',' + counties,
                  }
              }).then(function(data){
                showInfo("更新成功",function(){
                    $scope.getSFs();
                    $scope.SFSites.isAdd = false;
                });
            }); 
        }
    };

    $scope.deleteSFSites = function(id){
        CommonService.httpRequest({
                  url : '/baseCourseSfSite/deleteById.api',
                  method : 'get',
                  data :{
                      id : id
                  }
              }).then(function(data){
                  showInfo("删除成功",function(){
                    $scope.getSFs();
                });
              });
    };
    $scope.layerDeleteSFSites = function(id){
        layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
          $scope.deleteSFSites(id);
          layer.close(index);
        },function(index){
            layer.close(index);
        });
    };

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];          
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getSFs();
               }
           };

}]);
