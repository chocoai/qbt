"use strict";
angular.module("app.views")
.controller('loginCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.platforms = Constants.platforms;
    $scope.mobile = localStorage.getItem('b_mobile') || '';
    $scope.remember = true;
    $scope.platform = localStorage.getItem('b_plat') || "1";
    $scope.login = function(){
        if(!$scope.mobile){
            showWarn('请输入用户名'); return;
        }
        if(!$scope.pwd){
            showWarn('请输入密码'); return;
        }
        CommonService.httpRequest({
            url : '/login.api',
            method : 'post',
            data :{
                mobile : $scope.mobile,
                pwd : rsaEncrypt($scope.pwd)
            }
        }).then(function(data){
            if(data.datas.platIdList.indexOf(parseInt($scope.platform)) == -1){
                showWarn('您无该平台权限');
                return;
            }
            CommonService.setToken(data.datas.token);
            if($scope.remember){
                localStorage.setItem('b_mobile',$scope.mobile);
            }else{
                localStorage.removeItem('b_mobile');
            }
            localStorage.setItem('loginMobile',data.datas.mobile);
            localStorage.setItem('b_name',data.datas.name);
            localStorage.setItem('b_plat',$scope.platform);
            if($scope.platform == "2"){
                location.href = 'golfpay/view/index.html';
            }else{
                location.href = 'index.html';
            }
        });
    };

    function rsaEncrypt(text) {
    	setMaxDigits(130);
    	var key = new RSAKeyPair("10001", "", rsa_modulus);
    	var encryptRtn = encryptedString(key, text);
        // console.log(encryptRtn);
    	return encryptRtn;
    };

    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
                 if(e && e.keyCode==13){ // enter 键
                   $scope.login();
               }
           };


}]);
