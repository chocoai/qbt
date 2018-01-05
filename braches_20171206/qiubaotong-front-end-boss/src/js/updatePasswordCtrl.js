"use strict";
angular.module("app.views")
.controller('updatePasswordCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.submitPassword = function(){

        if(!$scope.orginPassword){
            showWarn("原密码不能为空");
            return false;
        }
        if(!$scope.newPassword){
            showWarn("新密码不能为空");
            return false;
        }
        else if($scope.newPassword.length < 6){
          showWarn('密码长度为6位以上');
          return false;
        }
        if(!$scope.surePassword){
            showWarn("确认密码不能为空");
            return false;
        }
        if($scope.surePassword != $scope.newPassword){
            showWarn("新密码与确认密码不一致");
            return false;
        }
        CommonService.httpRequest({
                  url : '/adminUser/updatePwd.api',
                  method : 'post',
                  data :{
                      password : rsaEncrypt($scope.orginPassword),
                      newPassword : rsaEncrypt($scope.newPassword)
                  }
              }).then(function(data){
                  showInfo("修改成功",function(){
                    tabClose();
                });
              });
    };

    function rsaEncrypt(text) {
    	setMaxDigits(130);
    	var key = new RSAKeyPair("10001", "", rsa_modulus);
    	var encryptRtn = encryptedString(key, text);
    	return encryptRtn;
    };

}]);
