"use strict";
angular.module("app.views",['ngFileUpload'])
.controller('travelDetailCtrl',['$scope','$http','CommonService','Constants','Upload',function($scope,$http,CommonService,Constants,Upload){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.orderToTravel = window.location.search.getQueryString('orderToTravel');
    $scope.fBaseUrl = fBaseUrl;
    $scope.lat = '';
    $scope.lon = '';
    $scope.isUpdate = false;
    var id = CommonService.getQueryString('id');
    $scope.partnerType = '1';
    $scope.shareOrder = 'true';
    $scope.settleType = '1';
    $scope.status = '1';
    $scope.settleModel = '1';
    $scope.amountConfigs = [];
    $scope.languageIdList = [];
    $scope.maxRate = '';
    $scope.maxAmount = '';
    $scope.address = '';
    $scope.isTicket = 'true';
    $scope.getLanuage = function(){
        CommonService.httpRequest({
            url : '/baseLanguage/list.api',
            method : 'post',
        }).then(function(data){
            $scope.languageLists = data.datas;
            $scope.languageIdList.push($scope.languageLists[0].id);
        });
    }
    $scope.getLanuage();

    $scope.getList = function(id){
       CommonService.httpRequest({
            url : '/basePartner/findById.api',
            method : 'get',
            data : {
                id : id
            }
        }).then(function(data){
           var manages = data.datas;
           $scope.id = manages.id;
           $scope.name = manages.name;
           $scope.partnerType = manages.partnerType + '';
           $scope.contact = manages.contact;
           $scope.mobile = manages.mobile;
           $scope.image = manages.logo;
           $scope.website = manages.website;
           $scope.memo = manages.memo;
           $scope.shareOrder = manages.shareOrder + '';
           $scope.settleModel = manages.settleMode + '';
           $scope.settleType = manages.settleType + '';
           $scope.status = manages.status + '';
           $scope.province = manages.treeId.split(',')[0];
           $scope.city = manages.treeId.split(',')[1];
           $scope.county = manages.treeId.split(',')[2];
           $scope.address = manages.address;
           $scope.lon = manages.lon;
           $scope.lat = manages.lat;
           $scope.amountConfigs = manages.bsacList;
           $scope.languageIdList = manages.languageIdList;
           $scope.isTicket = manages.isTicket + '';
           $scope.ticketMessage = manages.ticketMessage;
           if($scope.settleModel == 2){
                $scope.maxRate = manages.settleModeValue;
           }
           else if($scope.settleModel == 3){
                $scope.maxAmount = manages.settleModeValue;
           }
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
            });
        });
    };

    $scope.getCoursePerson = function(id){
        CommonService.httpRequest({
                  url : '/userAssistantApply/list.api',
                  method : 'get',
                  data :{
                      applyId : id,
                      applyType : 8
                  }
              }).then(function(data){
                  $scope.persons = data.datas;
              });
    }

    if(!!id){
        $scope.getList(id);
        $scope.isUpdate = true;
        $scope.getCoursePerson(id);
    }

    //结算模式配置
    $scope.addAmount = function(){
        $scope.amountConfigs.push({});
    }

    $scope.deleteAmount = function(id){
        $scope.amountConfigs.splice(id,1);
    }

    $scope.clearAmountConfigs = function(){
        if($scope.settleModel == 1){
            $scope.amountConfigs = [];
        }
        else if($scope.settleModel == 2){
            $scope.amountConfigs = [{'status':1,'maxAmount':0,'rate':$scope.maxRate}];
        }
        else{
            $scope.amountConfigs = [{'status':1,'rate':0,'maxAmount':$scope.maxAmount}];
        }
        
    };
    $scope.updateRate = function(){
        $scope.amountConfigs = [{'status':1,'maxAmount':0,'rate':0 || $scope.maxRate}];
    }
    $scope.updateMaxAmount = function(){
        $scope.amountConfigs = [{'status':1,'rate':0,'maxAmount':0 || $scope.maxAmount}];
    }


    //语言配置
    $scope.isSelected = function(id){
        return $scope.languageIdList.indexOf(id) >= 0;
    }

    $scope.isClick = function(id){
        if($scope.languageIdList.indexOf(id) == -1){
            $scope.languageIdList.push(id);
        }
        else{
            var idx = $scope.languageIdList.indexOf(id);
            $scope.languageIdList.splice(idx,1);
        }
    }


    //图片上传
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
            })
            .then(function(data, status, headers, config){
                layer.closeAll();
                showInfo("上传成功！");
                $scope.image = data.data.datas;
                $scope.logo = data.data.datas;
                if(data.data.message){
                    showErr(data.data.message);
                }
            })
        }
    };

    $scope.addTravel = function(){

        for(var i = 0; i < $scope.amountConfigs.length; i++){
                $scope.amountConfigs[i].status = 1;
            }

        if(!$scope.name){
            showWarn("名称不能为空");
            return false;
        }
        if(!$scope.partnerType){
            showWarn("类型不能为空");
            return false;
        }
        if(!$scope.contact){
            showWarn("联系人不能为空");
            return false;
        }
        if(!$scope.mobile){
            showWarn("联系电话不能为空");
            return false;
        }
        else{
            if((/^1[3|4|5|7|8]\d{9}$/.test($scope.mobile)) || (/\d{3}-\d{8}|\d{4}-\d{7,8}$/.test($scope.mobile))){
            }
            else{
                showWarn("联系电话格式错误");
                return false;
            }
        }
        if(!$scope.image){
            showWarn("logo不能为空");
            return false;
        }
        if(!$scope.mobile){
            showWarn("网址不能为空");
            return false;
        }
        if(!$scope.shareOrder){
            showWarn("共享订单不能为空");
            return false;
        }
        if(!$scope.settleType){
            showWarn("结算模式不能为空");
            return false;
        }
        if(!$scope.settleModel){
            showWarn("结算方式不能为空");
            return false;
        }
        if(!$scope.status){
            showWarn("状态不能为空");
            return false;
        }
        if($scope.settleModel == 1 && $scope.amountConfigs.length == 0){
            showWarn('总金额比例模式配置不能为空');
            return false;
        }
        if($scope.settleModel == 1){
            for(var i = 0; i < $scope.amountConfigs.length; i++){
                if((!$scope.amountConfigs[i].rate && $scope.amountConfigs[i].rate!=0) || (!$scope.amountConfigs[i].maxAmount && $scope.amountConfigs[i].maxAmount!=0)){
                    showWarn('限额和百分百值不能为空');
                    return false;
                }
                else if($scope.amountConfigs[i].rate > 100){
                    showWarn('百分百值不能大于100');
                    return false;
                }
                else if($scope.amountConfigs[i].maxAmount > 999999999){
                    showWarn('限额不能大于999999999');
                    return false;
                }
            }
        }
        if($scope.settleModel == 2){
            if(!$scope.maxRate && $scope.maxRate!=0){
                showWarn('折扣不能为空');
                return false;
            }
            else if($scope.maxRate > 100){
                showWarn('折扣不能大于100');
                return false;
            }
            
        }
        if($scope.settleModel == 3){
            if(!$scope.maxAmount && $scope.maxAmount!=0){
                showWarn('优惠金额不能为空');
                return false;
            }
            else if($scope.maxAmount > 999999999){
                showWarn('优惠金额不能大于999999999');
                    return false;
            }
        }
        if($scope.languageIdList.length == 0){
            showWarn('语言不能为空');
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

        var provinces = $.trim($('#provinces option:selected').text());
        var cities = $.trim($('#cities option:selected').text());
        var counties = $.trim($('#counties option:selected').text());
        if(!id){
            CommonService.httpRequest({
                url : '/basePartner/add.api',
                method : 'post',
                data :{
                    name:$scope.name,
                    partnerType:parseInt($scope.partnerType),
                    contact:$scope.contact,
                    mobile:$scope.mobile,
                    logo:$scope.image,
                    website:$scope.website,
                    memo:$scope.memo,
                    shareOrder:$scope.shareOrder,
                    settleType:parseInt($scope.settleType),
                    settleMode:$scope.settleModel,
                    settleModeValue:$scope.settleModel == 1 ? 0 : ($scope.maxRate || $scope.maxAmount),
                    status:parseInt($scope.status),
                    areaId:$scope.county,
                    treeId:$scope.province + ',' + $scope.city + ',' + $scope.county,
                    treePath:provinces + ',' + cities + ',' + counties,
                    address:$scope.address,
                    lon:parseFloat($scope.lon),
                    lat:parseFloat($scope.lat),
                    languageIdList:$scope.languageIdList,
                    bsacList:$scope.settleModel == 1 ? $scope.amountConfigs : [],
                    isTicket:$scope.isTicket == 'true' ? true : false,
                    ticketMessage:$scope.ticketMessage
                }
            }).then(function(data){
                showInfo("新增成功",function(){
                    tabOpenParent({name:'travel',url:'travel.html',displayName:'合作旅行社查询'});
                });
            });
        }
        else{
             CommonService.httpRequest({
                url : '/basePartner/update.api',
                method : 'post',
                data :{
                    id:$scope.id,
                    name:$scope.name,
                    partnerType:parseInt($scope.partnerType),
                    contact:$scope.contact,
                    mobile:$scope.mobile,
                    logo:$scope.image,
                    website:$scope.website,
                    memo:$scope.memo,
                    shareOrder:$scope.shareOrder,
                    settleType:parseInt($scope.settleType),
                    settleMode:$scope.settleModel,
                    settleModeValue:$scope.settleModel == 1 ? 0 : $scope.maxRate || $scope.maxAmount,
                    status:parseInt($scope.status),
                    areaId:$scope.county,
                    treeId:$scope.province + ',' + $scope.city + ',' + $scope.county,
                    treePath:provinces + ',' + cities + ',' + counties,
                    address:$scope.address,
                    lon:parseFloat($scope.lon),
                    lat:parseFloat($scope.lat),
                    languageIdList:$scope.languageIdList,
                    bsacList:$scope.settleModel == 1 ? $scope.amountConfigs : [],
                    isTicket:$scope.isTicket == 'true' ? true : false,
                    ticketMessage:$scope.ticketMessage
                }
            }).then(function(data){
                showInfo("更新成功",function(){
                    tabOpenParent({name:'travel',url:'travel.html',displayName:'合作旅行社查询'});
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
                $scope.parentId = data.datas.parentId;
            });
        }
        else{
            $scope.countieses = '';
        }
        $scope.county = '';
        $scope.getLatLon($scope.address);
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
       $http.jsonp("http://api.map.baidu.com/geocoder/v2/?ak=h5t9oFdFVTh9Hih6oy0jNOc27LiB2qDm&output=json&address="+ keyword +"&callback=JSON_CALLBACK")
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
                  layer.close(index);
                  $scope.getCoursePerson(id);
                  // tabOpenParent({name:'travel'+id,url:'travel.html',displayName:'合作方机构查询'});
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
                  // tabOpenParent({name:'travel'+id,url:'travel.html',displayName:'合作方机构查询'});
              });
        }, function(index){
          layer.close(index);
        });
    };


}]);
