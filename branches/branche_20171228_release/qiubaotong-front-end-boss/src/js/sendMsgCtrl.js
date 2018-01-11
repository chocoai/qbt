"use strict";
angular.module("app.views")
.controller('sendMsgCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.mobile = CommonService.getQueryString('mobile');
    $scope.msgTpl = "【球包通】尊敬的?，您好！?，如有任何疑问，请拨打：400-609-0990";

    $scope.send = function(){
        if(!$scope.mobile){
            showWarn('请输入手机号'); return;
        }
        var mobiles = $scope.mobile.replace(/，/g,',').split(',');
        var sendMobiles = [];
        for(var i =0; i<mobiles.length; i++){
            if(mobiles[i]){
                if(!/1\d{10}/g.test(mobiles[i])){
                    showWarn('手机号'+mobiles[i]+'格式不正确'); return;
                }
                sendMobiles.push(mobiles[i]);
            }
        };
        if(sendMobiles.length==0){
            showWarn('请输入手机号'); return;
        }
        if(!$scope.name){
            showWarn('请输入用户姓名');return;
        }
        if(!$scope.content){
            showWarn('请输入短信内容'); return;
        }

        CommonService.httpRequest({
            url : '/message/send.api',
            method : 'post',
            data :{
                template_id : '162624',
                mobiles : sendMobiles,
                contents : [$scope.name,$scope.content,'400-609-0990']
            }
        }).then(function(data){
            showInfo('发送成功');
            $scope.mobile = '';
        });

    };

}]);
