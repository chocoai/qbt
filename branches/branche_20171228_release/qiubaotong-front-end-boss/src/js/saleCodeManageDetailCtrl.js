"use strict";
angular.module("app.views")
.controller('saleCodeManageDetailCtrl',['$scope','CommonService','$timeout','Constants',function($scope,CommonService,$timeout,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.fBaseUrl = fBaseUrl;
    $scope.appStatus = Constants.app_Status;
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight:true
    });
    $scope.list = [];
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/saleQrcodeInfo/findByPage.api',
            data :{
                pageNo:num || "1",
                qrcodeCreateInfoId: CommonService.getQueryString('salesmanCode'),
                salesmanCode: $scope.salesmanCode,
                applyStatus: $scope.applyStatus
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
        });
    }
    $scope.getList();

    $scope.detail = function(id,name){
        tabOpenParent({name:'saleManManageDetail'+id,url:'saleManManageDetail.html?id='+id,displayName:'销售人员'+name});
    }

    $scope.imgShow = function(src){
        $scope.imgToBig = src;
        $timeout(function () {
            layer.open({
                type: 1,
                title: false,
                closeBtn: 0,
                // area: '516px',
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

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if(e && e.keyCode==13){ // enter 键
            $scope.getList();
        }
    };
}]);
