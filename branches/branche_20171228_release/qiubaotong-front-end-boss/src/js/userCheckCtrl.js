"use strict";
angular.module("app.views")
.controller('userCheckCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.selectMobile = CommonService.getQueryString('mobileOfMoreWeixin');
    if(localStorage.getItem('code')!== '' || localStorage.getItem('code')!== null || localStorage.getItem('code')){
      $scope.identify = localStorage.getItem('code');
    }
    $scope.list = [];
  // $scope.thirdOrg = sessionStorage.getItem('thirdId')
  // $scope.getThirdOrg = function () {
  //     CommonService.httpRequest({
  //       url : '/thirdOrg/findAll.api',
  //       method : 'get'
  //     }).then(function (data) {
  //       $scope.thirdChannel = data.datas;
  //       if($scope.thirdOrg || $scope.thirdOrg!=undefined || $scope.thirdOrg!=null){
  //         $scope.thirdOrg = $scope.thirdOrg + '';
  //       }else{
  //         $scope.thirdOrg = '';
  //       }
  //     });
  // }
  // $scope.getThirdOrg();
  // if(sessionStorage.getItem('thirdId') || sessionStorage.getItem('thirdId')!==undefined){
  //   $scope.thirdOrg = sessionStorage.getItem('thirdId') + ''
  // }
    $scope.getList = function(num){
        CommonService.pagination({
            url : '/userWeixin/findByPage.api',
            data :{
                pageNo : num || "1",
                name : $scope.selectName,
                // organizationId : $scope.thirdOrg ? parseInt($scope.thirdOrg) : '',
                mobile : $scope.selectMobile,
                channelQrcodeCode : $scope.identify
            }
        }).then(function(data){
            $scope.list = data.item;
            $scope.page = data.page;
            localStorage.removeItem('code');
            // sessionStorage.removeItem('thirdId')
        });
    };
    $scope.getList();

    $scope.userCheckDetail = function(id,nickname){
        localStorage.removeItem('code');
        tabOpenParent({name:'userCheckDetail'+id,url:'userCheckDetail.html?id='+id,displayName:nickname + '详情'});
    };
    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
                 if(e && e.keyCode==13){ // enter 键
                   $scope.getList();
               }
           };

}]);
