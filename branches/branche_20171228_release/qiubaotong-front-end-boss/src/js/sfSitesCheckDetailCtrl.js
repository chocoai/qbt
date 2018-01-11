"use strict";
angular.module("app.views")
.controller('sfSitesCheckDetailCtrl',['$scope','$http','CommonService',function($scope,$http,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    var id = localStorage.getItem('manages');
    $scope.province = '';
    $scope.city = '';
    $scope.county = '';
    $scope.getList = function(id){
       CommonService.httpRequest({
            url : '/baseSfSite/findById.api',
            method : 'get',
            data : {
                id : id
            }
        }).then(function(data){
            var manages = data.datas;
            $scope.remark = manages.remark;
            $scope.id = manages.id;
            $scope.name = manages.name;
            $scope.address = manages.address;
            $scope.contact = manages.contact;
            $scope.mobile = manages.mobile;
            $scope.areaId = manages.areaId;
            $scope.lon = manages.lon;
            $scope.lat = manages.lat;
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

    
    $scope.addSFSites = function(){

        if(!$scope.name){
            showWarn("名称不能为空");
            return false;
        }
        if(!$scope.contact){
            showWarn("联系人不能为空");
            return false;
        }
        if(!$scope.mobile){
            showWarn("联系人电话不能为空");
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
        if(!$scope.lat && $scope.lat != 0){
            showWarn("纬度不能为空");
            return false;
        }


        var provinces = $.trim($('#provinces option:selected').text());
        var cities = $.trim($('#cities option:selected').text());
        var counties = $.trim($('#counties option:selected').text());
        if(!id){
             CommonService.httpRequest({
                url : '/baseSfSite/add.api',
                method : 'post',
                data :{
                    name : $scope.name,
                    address : $scope.address,
                    contact : $scope.contact,
                    mobile : $scope.mobile,
                    treePath : provinces + ',' + cities + ',' + counties,
                    treeId : $scope.province + ',' + $scope.city + ',' + $scope.county,
                    areaId :  $scope.county,
                    lon : $scope.lon,
                    lat : $scope.lat,
                    remark : $scope.remark
                }
            }).then(function(data){
                showInfo("新增成功",function(){
                    tabOpenParent({name:'sfSitesCheck',url:'sfSitesCheck.html',displayName:'顺丰站点'});
                });
            });
        }
        else{
            CommonService.httpRequest({
                url : '/baseSfSite/updateById.api',
                method : 'post',
                data :{
                    id:$scope.id,
                    name : $scope.name,
                    address : $scope.address,
                    contact : $scope.contact,
                    mobile : $scope.mobile,
                    treePath : provinces + ',' + cities + ',' + counties,
                    treeId : $scope.province + ',' + $scope.city + ',' + $scope.county,
                    areaId :  $scope.county,
                    lon : $scope.lon,
                    lat : $scope.lat,
                    remark : $scope.remark
                }
            }).then(function(data){
                showInfo("更新成功",function(){
                    tabOpenParent({name:'sfSitesCheck',url:'sfSitesCheck.html',displayName:'顺丰站点'});
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
