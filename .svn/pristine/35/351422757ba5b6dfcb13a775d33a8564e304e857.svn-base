"use strict";
angular.module("app.views")
.controller('messageWorkShopDetailCtrl',['$scope','$http','CommonService',function($scope,$http,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    var id = localStorage.getItem('manages');
    $scope.province = '';
    $scope.city = '';
    $scope.county = '';
    $scope.isKeepService = 'true';
    $scope.isRepairService = 'true';
    $scope.isBrassieService = 'true';
    $scope.isMakeBrassieService = 'true';
    $scope.isSave = 'true';
    $scope.isChangeGrip = 'true';
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
            url : '/baseWorkshop/findById.api',
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
            $scope.courseId = manages.courseId;
            $scope.nearestCourse = manages.nearestCourse;
            if($scope.courseAddress){
                $scope.courseAddress = manages.courseAddress.replaceAll(',','');
            }
            $scope.lon = manages.lon+'';
            $scope.lat = manages.lat+'';
            $scope.courseWorkshop = manages.courseWorkshop;
            $scope.businessTime = manages.businessTime;
            $scope.teacherNumber = manages.teacherNumber;
            $scope.nearestDeliver = manages.nearestDeliver;
            $scope.goodsCompany = manages.goodsCompany;
            $scope.manager = manages.manager;
            $scope.manageMobile = manages.manageMobile;
            $scope.brif = manages.brif;

            $scope.isKeepService = manages.isKeepService + '';
            $scope.isRepairService = manages.isRepairService + '';
            $scope.isBrassieService = manages.isBrassieService + '';
            $scope.isMakeBrassieService = manages.isMakeBrassieService + '';
            $scope.isSave = manages.isSave + '';
            $scope.isChangeGrip = manages.isChangeGrip + '';
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
            showWarn("工坊名称不能为空");
            return false;
        }
        if(!$scope.manager){
            showWarn("工坊负责人不能为空");
            return false;
        }
        if(!$scope.manageMobile){
            showWarn("工坊负责人电话不能为空");
            return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.manageMobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.manageMobile))){
            }
            else{
                showWarn("工坊负责人电话格式错误");
                return false;
            }
        }
        if(!$scope.foundTime){
            showWarn("工坊成立时间不能为空");
            return false;
        }
        if(!$scope.businessTime){
            showWarn("工坊营业时间不能为空");
            return false;
        }
        if(!$scope.teacherNumber && $scope.teacherNumber!=0){
            showWarn("工坊师傅人数不能为空");
                return false;
        }
        else{
            if($scope.teacherNumber > 999999){
                showWarn("工坊师傅人数不能大于999999");
                return false;
            }
            else if(String($scope.teacherNumber).indexOf('.') > 0){
                showWarn("工坊师傅人数需为整数");
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
            showWarn("工坊地址不能为空");
            return false;
        }
        if(!$scope.courseId){
            showWarn("工坊附近的球场不能为空");
            return false;
        }
        var provinces = $.trim($('#provinces option:selected').text());
        var cities = $.trim($('#cities option:selected').text());
        var counties = $.trim($('#counties option:selected').text());
        if(!id){
             CommonService.httpRequest({
                url : '/baseWorkshop/add.api',
                method : 'post',
                data :{
                    foundTime : $scope.foundTime,
                    name : $scope.name,
                    address : $scope.address,
                    courseId : $scope.courseId,
                    nearestCourse : $scope.nearestCourse,
                    courseAddress : $scope.courseAddress,
                    lon : $scope.lon,
                    lat : $scope.lat,
                    courseWorkshop : $scope.courseWorkshop,
                    businessTime : $scope.businessTime,
                    teacherNumber : $scope.teacherNumber,
                    nearestDeliver : $scope.nearestDeliver,
                    goodsCompany : $scope.goodsCompany,
                    manager : $scope.manager,
                    manageMobile : $scope.manageMobile,
                    brif : $scope.brif,
                    
                    isKeepService : $scope.isKeepService == 'true' ? true : false,
                    isRepairService : $scope.isRepairService == 'true' ? true : false,
                    isBrassieService : $scope.isBrassieService == 'true' ? true : false,
                    isMakeBrassieService : $scope.isMakeBrassieService == 'true' ? true : false,
                    isSave : $scope.isSave == 'true' ? true : false,
                    isChangeGrip : $scope.isChangeGrip == 'true' ? true : false,
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
                    tabOpenParent({name:'messageWorkShop',url:'messageWorkShop.html',displayName:'工坊信息查询'});
                });
            });
        }
        else{
            CommonService.httpRequest({
                url : '/baseWorkshop/updateById.api',
                method : 'post',
                data :{
                    id:$scope.id,
                    foundTime : $scope.foundTime,
                    name : $scope.name,
                    address : $scope.address,
                    courseId : $scope.courseId,
                    nearestCourse : $scope.nearestCourse,
                    courseAddress : $scope.courseAddress,
                    lon : $scope.lon,
                    lat : $scope.lat,
                    courseWorkshop : $scope.courseWorkshop,
                    businessTime : $scope.businessTime,
                    teacherNumber : $scope.teacherNumber,
                    nearestDeliver : $scope.nearestDeliver,
                    goodsCompany : $scope.goodsCompany,
                    manager : $scope.manager,
                    manageMobile : $scope.manageMobile,
                    brif : $scope.brif,
                    
                    isKeepService : $scope.isKeepService == 'true' ? true : false,
                    isRepairService : $scope.isRepairService == 'true' ? true : false,
                    isBrassieService : $scope.isBrassieService == 'true' ? true : false,
                    isMakeBrassieService : $scope.isMakeBrassieService == 'true' ? true : false,
                    isSave : $scope.isSave == 'true' ? true : false,
                    isChangeGrip : $scope.isChangeGrip == 'true' ? true : false,
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
                    tabOpenParent({name:'messageWorkShop',url:'messageWorkShop.html',displayName:'工坊信息查询'});
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
        $('#courseText').text('选择球场');
        $scope.courseId = '';
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
    $scope.selectCourse = function(){
        $scope.courseName = '';
        $scope.getCourse();
            layer.open({    
              type: 1,
              title:'请选择球场',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '535px'], //宽高
              content: $('#memo'),
            });
        document.onkeydown = '';
    };
    $scope.selectedCourse = function(id,name,treePath,address){
        $scope.courseId = id;
        $scope.courseAddress = treePath.replaceAll(',','') + address;
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
