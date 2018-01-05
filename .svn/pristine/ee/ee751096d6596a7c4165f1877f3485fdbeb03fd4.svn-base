"use strict";
angular.module("app.views",['ngFileUpload'])
.controller('alertManageDetailCtrl',['$scope','$timeout','CommonService','Constants','Upload',function($scope,$timeout,CommonService,Constants,Upload){
    $('body').niceScroll({cursorcolor:"#337ab7"});

    $scope.fBaseUrl = fBaseUrl;
    $scope.conditionTypes = Constants.condition_type;
    $scope.alertPlatforms = Constants.alert_platform;

    $scope.id = CommonService.getQueryString('id');
    $scope.courseSelect = {
        ids:[],
        names:[],
        selectedCourse:[]
    };
    $scope.areaSelect = {
        ids:[],
        names:[],
        selectedArea:[]
    };
    $scope.allCheck = false;
    $scope.areaAllCheck = false;
    $scope.areaIds = [];
    $scope.list = [];
    $scope.area = [];

    $scope.isSelectDelete = '删除';

    $scope.getDetail = function(id){
        CommonService.httpRequest({
            url: '/popUp/detail.api',
            method : 'get',
            data:{
                id:id
            }
        }).then(function(data){
            $scope.popDetail = data.datas;
            $scope.popDetail.platform += '';
            $scope.popDetail.conditionType += '';
            $scope.popDetail.sort += '';
            $scope.popDetail.contentType += '';
            if($scope.popDetail.configs){
                if($scope.popDetail.conditionType == 2){
                    $scope.popDetail.configs.forEach(function(i){
                        $scope.courseSelect.selectedCourse.push({id:i.conditionId,name:i.conditionName});
                    });
                }
                else if($scope.popDetail.conditionType == 3){
                    $scope.popDetail.configs.forEach(function(i){
                        $scope.areaSelect.selectedArea.push({id:i.conditionId,name:i.conditionName});
                    });
                }
            }
            if($scope.popDetail.contentType == 1){
                $scope.popDetail.message = $scope.popDetail.content;
            }
            else if($scope.popDetail.contentType == 2){
                $scope.popDetail.imgUrl = $scope.popDetail.content;
            }

        });
    }

    $scope.update = function(){
        if(!$scope.popDetail.name){
            showWarn('弹框名称不能为空');
            return;
        }
        if(!$scope.popDetail.platform){
            showWarn('请选择平台');
            return;
        }
        if(!$scope.popDetail.conditionType){
            showWarn('请选择触发条件');
            return;
        }
        if(!$scope.popDetail.sort){
            showWarn('请选择顺序');
            return;
        }
        if($scope.popDetail.conditionType == 2){
            if(!$scope.courseSelect.selectedCourse){
                showWarn('请添加球场');
                return;
            }
            else{
                if($scope.courseSelect.selectedCourse.length == 0){
                    showWarn('请添加球场');
                return;
                }
            }
        }

        if($scope.popDetail.conditionType == 3){
            if(!$scope.areaSelect.selectedArea){
                showWarn('请添加地区');
                return;
            }
            else{
                if($scope.areaSelect.selectedArea.length == 0){
                    showWarn('请添加地区');
                return;
                }
            }
        }
        if(!$scope.popDetail.contentType){
            showWarn('请选择弹框内容类型');
            return;
        }
        if($scope.popDetail.contentType == 1){
            if(!$scope.popDetail.message){
                showWarn('弹框文字内容不能为空');
                return;
            }
        }
        if($scope.popDetail.contentType == 2){
            if(!$scope.popDetail.imgUrl){
                showWarn('弹框图片不能为空');
                return;
            }
        }

        if($scope.popDetail.conditionType == 1){
            $scope.popDetail.configs = undefined;
        }
        else if($scope.popDetail.conditionType == 2){
            $scope.popDetail.configs = [];
            $scope.courseSelect.selectedCourse.forEach(function(i){
                $scope.popDetail.configs.push({conditionId:i.id});
            });
        }
        else if($scope.popDetail.conditionType == 3){
            $scope.popDetail.configs = [];
            $scope.areaSelect.selectedArea.forEach(function(i){
                $scope.popDetail.configs.push({conditionId:i.id});
            });
        }
        if($scope.popDetail.contentType == 1){
            $scope.popDetail.content = $scope.popDetail.message;
        }
        else if($scope.popDetail.contentType == 2){
            $scope.popDetail.content = $scope.popDetail.imgUrl;
        }

        if($scope.id){
            CommonService.httpRequest({
                url: '/popUp/update.api',
                method: 'post',
                data:{
                    id:$scope.id,
                    conditionType:$scope.popDetail.conditionType,
                    configs:$scope.popDetail.configs,
                    content:$scope.popDetail.content,
                    contentType:$scope.popDetail.contentType,
                    name:$scope.popDetail.name,
                    platform:$scope.popDetail.platform,
                    sort:$scope.popDetail.sort
                }
            }).then(function(){
                showInfo('更新成功',function(){
                    tabOpenParent({name:'alertManage',url:'alertManage.html',displayName:'弹框管理'});
                });
            });
        }
        else{
            CommonService.httpRequest({
                url: '/popUp/add.api',
                method: 'post',
                data:{
                    conditionType:$scope.popDetail.conditionType,
                    configs:$scope.popDetail.configs,
                    content:$scope.popDetail.content,
                    contentType:$scope.popDetail.contentType,
                    name:$scope.popDetail.name,
                    platform:$scope.popDetail.platform,
                    sort:$scope.popDetail.sort
                }
            }).then(function(){
                showInfo('新增成功',function(){
                    tabOpenParent({name:'alertManage',url:'alertManage.html',displayName:'弹框管理'});
                });
            });
        }
    };



    //获取球场
    $scope.getCourse = function(){
    	CommonService.pagination({
        	url : '/course/findByPage.api',
        	data :{
        		pageNo : "1",
                name : $scope.courseName,
                areaId : $scope.areaId,
                isOutRange : $scope.isOutRange,
                pageSize:1000
            }
        }).then(function(data){
        	$scope.list = data.item;
        	$scope.page = data.page;
            $scope._ids = [];
            $scope._names = [];
            $scope.list.forEach(function(i){
                $scope._ids.push(i.id);
            });
            $scope.list.forEach(function(i){
                $scope._names.push(i.name);
            });
        });

    };

    $scope.AreaFindCourse = function(){
        $scope.allCheck = false;
        $scope.courseSelect.ids = [];
        $scope.courseSelect.names = [];
        $scope.areaId = $scope.county;
        if(!$scope.county){
            $scope.areaId = $scope.city;
            if(!$scope.city){
                $scope.areaId = $scope.province;
            }
        }
        $scope.getCourse();
    }

    $scope.getProvinces = function(){
        CommonService.httpRequest({
            url : '/baseSfArea/findByParentId.api?parentId=1000000',
            method : 'post',
        }).then(function(data){
            $scope.provinceses = data.datas;
            $scope.provinceses2 = data.datas;
        });
    }
    $scope.getProvinces();

    $scope.getCitieses = function(index){
        if(index == 2){
            if(!!$scope.province2){
                CommonService.httpRequest({
                    url : '/baseSfArea/findByParentId.api?parentId=' + $scope.province2,
                    method : 'post',
                }).then(function(data){
                    $scope.citieses2 = data.datas;
                });

            }
            else{
                $scope.citieses2 = '';
                $scope.countieses2 = '';
            }
            $scope.city2 = '';
            $scope.county2 = ''; 
        }
        else{
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

    }
    $scope.getCounties = function(index){
        if(index == 2){
            if(!!$scope.city2){
                CommonService.httpRequest({
                    url : '/baseSfArea/findByParentId.api?parentId=' + $scope.city2,
                    method : 'post',
                }).then(function(data){
                    $scope.countieses2 = data.datas;
                });
            }
            else{
                $scope.countieses2 = '';
            }
            $scope.county2 = '';

        }
        else{
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

    }

    //添加球场
    $scope.addCourseList = function(){
        for(var i = 0; i < $scope.courseSelect.ids.length; i++){
            var hasCourse = false;
            $scope.courseSelect.selectedCourse.forEach(function(j){
                if(j.id == $scope.courseSelect.ids[i]){
                    hasCourse = true;
                    return;
                }
            });
            if(!hasCourse){
                $scope.courseSelect.selectedCourse.push({id:$scope.courseSelect.ids[i],name:$scope.courseSelect.names[i]});
            }
        }
    };

    //删除球场
    $scope.deleteCourse = function(index){
        $scope.courseSelect.selectedCourse.splice(index,1);
    }

    //球场选择
    $scope.selectId = function(id,name){
        var idx = $scope.courseSelect.ids.indexOf(id);
        var namex = $scope.courseSelect.names.indexOf(name);
        if(idx == -1){
            $scope.courseSelect.ids.push(id);
        }
        else{
            $scope.courseSelect.ids.splice(idx,1);
        }
        if(namex == -1){
            $scope.courseSelect.names.push(name);
        }
        else{
            $scope.courseSelect.names.splice(namex,1);
        }

        if($scope.courseSelect.ids.length == $scope._ids.length){
            $scope.allCheck = true;
        }
    }

    $scope.$watch('allCheck',function(newVal,oldVal){

        if(newVal){
            $scope.list.forEach(function(index){
                index.isSelect = true;
            });
            $scope.courseSelect.ids = angular.copy($scope._ids);
            $scope.courseSelect.names = angular.copy($scope._names);
        }
        else{
            $scope.list.forEach(function(index){
                index.isSelect = false;
            });
            $scope.courseSelect.ids = [];
            $scope.courseSelect.names = [];
        }

    });


    //获取地区
    $scope.getArea = function(){
        CommonService.httpRequest({
            url: '/baseSfArea/findDistrictById.api',
            method: 'get',
            data:{
                id:$scope.areaId2
            }
        }).then(function(data){
            $scope.area = data.datas;
            $scope._idsArea = [];
            $scope._namesArea = [];
            $scope.area.forEach(function(i){
                $scope._idsArea.push(i.id);
            });
            $scope.area.forEach(function(i){
                $scope._namesArea.push(i.treePath);
            });
        });
    };

    $scope.findArea = function(){
        $scope.areaAllCheck = false;
        $scope.areaSelect.ids = [];
        $scope.areaSelect.names = [];
        $scope.areaId2 = $scope.county2;
        if(!$scope.areaId2){
            $scope.areaId2 = $scope.city2;
            if(!$scope.areaId2){
                $scope.areaId2 = $scope.province2;
            }
        }
        if(!$scope.areaId2){
            showWarn('请选择省份');
            return;
        }
        $scope.getArea();
    }

    $scope.selectArea = function(id,name){
        var idx = $scope.areaSelect.ids.indexOf(id);
        var namex = $scope.areaSelect.names.indexOf(name);
        if(idx == -1){
            $scope.areaSelect.ids.push(id);
        }
        else{
            $scope.areaSelect.ids.splice(idx,1);
        }
        if(namex == -1){
            $scope.areaSelect.names.push(name);
        }
        else{
            $scope.areaSelect.names.splice(namex,1);
        }

        if($scope.areaSelect.ids.length == $scope._idsArea.length){
            $scope.areaAllCheck = true;
        }
    }

    $scope.$watch('areaAllCheck',function(newVal,oldVal){

        if(newVal){
            $scope.area.forEach(function(index){
                index.isSelect = true;
            });
            $scope.areaSelect.ids = angular.copy($scope._idsArea);
            $scope.areaSelect.names = angular.copy($scope._namesArea);
        }
        else{
            $scope.area.forEach(function(index){
                index.isSelect = false;
            });
            $scope.areaSelect.ids = [];
            $scope.areaSelect.names = [];
        }

    });

    //添加地区
    $scope.addAreaList = function(){
        for(var i = 0; i < $scope.areaSelect.ids.length; i++){
            var hasCourse = false;
            $scope.areaSelect.selectedArea.forEach(function(j){
                if(j.id == $scope.areaSelect.ids[i]){
                    hasCourse = true;
                    return;
                }
            });
            if(!hasCourse){
                $scope.areaSelect.selectedArea.push({id:$scope.areaSelect.ids[i],name:$scope.areaSelect.names[i]});
            }
        }
    };

    //删除地区
    $scope.deleteArea = function(index){
        $scope.areaSelect.selectedArea.splice(index,1);
    }


    //上传照片
    $scope.uploadImg = function($file){
        if($file){
            var isIntegrate = false;
            if($file.size > (1 * 1024 * 1024)){
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
                showInfo('上传成功!',function(){
                    $scope.popDetail.imgUrl = data.data.datas;
                    $scope.$apply();
                });
                if(data.data.message){
                    showErr(data.data.message);
                }
            })
        }
    };

    $scope.selectToDelete = function(){
        if($scope.isSelectDelete != '确认删除'){
            if(!$scope.isBagSelect && $scope.imgUrl){
                $scope.isSelectDelete = '取消';
            }
            else{
                $scope.isSelectDelete = '删除';
            }
            $scope.isBagSelect = !$scope.isBagSelect;
        }
        else{
            $scope.popDetail.imgUrl = '';
            $scope.isBagSelect = !$scope.isBagSelect;
            $scope.isSelectDelete = '删除';
        }
    };

    $scope.selectBag = function(){
        var bagCol = $('#bagCol i');
        if(bagCol.css('color') == 'rgb(51, 51, 51)' || bagCol.css('color') == '#333'){
            bagCol.css('color','#fff');
            $scope.isSelectDelete = '确认删除';
        }
        else{
            bagCol.css('color','#333');
            $scope.isSelectDelete = '取消';

        }
    }

    $scope.imgShow = function(src){
      $scope.imgToBig = fBaseUrl + src;
        $timeout(function () {
          layer.open({
            type: 1,
            title: false,
            closeBtn: 0,
            area: '40%',
            shadeClose: true,
            closeBtn:true,
            content: $('#picShow')
          });
        },10)
    };
    $scope.picRotate = function(){
      var picShow = document.getElementById('picShow').parentNode.parentNode;
      picShow.style.animation = 'none';
      var picShowRotate = parseInt(picShow.style.transform.replace('rotate(','').replace('deg)',''));
      if(!picShowRotate){
        picShow.style.transform = 'rotate(90deg)';
      }
      else{
        picShowRotate = picShowRotate + 90;
        if(picShowRotate == 360){
          picShowRotate = 0;
        }
        picShow.style.transform = 'rotate(' + picShowRotate + 'deg)';
      }
    };
    if($scope.id){
        $scope.getDetail($scope.id);
    }


}]);
