"use strict";
angular.module("app.views",['ngFileUpload'])
.controller('advertiseCheckDetailCtrl',['$scope','CommonService','Constants','Upload',function($scope,CommonService,Constants,Upload){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.advertise_seat = Constants.advertise_seat;
    $scope.fBaseUrl = fBaseUrl;
    $scope.type = '';
    $scope.position = '';
    var id = localStorage.getItem('manages');
    $scope.getList = function(id){
       CommonService.httpRequest({
            url : '/baseAdv/findById.api',
            method : 'get',
            data : {
                id : id
            }
        }).then(function(data){
            var manages = data.datas;
            $scope.id = manages.id;
            $scope.name = manages.name;
            $scope.url = manages.url;
            $scope.image = manages.image;
            $scope.type = manages.type + '';
            $scope.position = manages.position + '';
            $scope.number = manages.number;
        });
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
                $scope.image = data.data.datas;
                if(data.data.message){
                    showErr(data.data.message);
                }
            })
        }
    };

    
    $scope.addAdv = function(){
        if(!$scope.name){
            showWarn("图片名称不能为空");
            return false;
        }
        else{
            if($.trim($scope.name.length) > 50){
                showWarn('图片名称长度不能大于50');
                return false;
            }
        }
        if(!$scope.image){
            showWarn("图片上传不能为空");
            return false;
        }
        if(!$scope.type){
            showWarn("类型不能为空");
            return false;
        }
        if(!$scope.position){
            showWarn("位置不能为空");
            return false;
        }
        if(!$scope.number){
            showWarn("顺序不能为空");
            return false;
        }
        else{
            if(($scope.number + '').length > 9){
                showWarn('顺序不能超过9位数');
                return false;
            }
        }
        
        if(!id){
             CommonService.httpRequest({
                url : '/baseAdv/add.api',
                method : 'post',
                data :{
                    name:$scope.name,
                    url:$scope.url,
                    image:$scope.image,
                    type:$scope.type,
                    position:$scope.position,
                    number:$scope.number
                }
            }).then(function(data){
                showInfo("新增成功",function(){
                    tabOpenParent({name:'advertiseCheck',url:'advertiseCheck.html',displayName:'广告位查询'});
                });
            });
        }
        else{
            CommonService.httpRequest({
                url : '/baseAdv/update.api',
                method : 'post',
                data :{
                    id:$scope.id,
                    name:$scope.name,
                    url:$scope.url,
                    image:$scope.image,
                    type:$scope.type,
                    position:$scope.position,
                    number:$scope.number
                }
            }).then(function(data){
                showInfo("更新成功",function(){
                    tabOpenParent({name:'advertiseCheck',url:'advertiseCheck.html',displayName:'广告位查询'});
                });
            });
            localStorage.removeItem('manages');
           
        }
        
    }

    if(!!id){
        $scope.getList(id);
    }

}]);
