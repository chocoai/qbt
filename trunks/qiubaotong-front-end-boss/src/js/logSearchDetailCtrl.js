"use strict";
angular.module("app.views")
.controller('logSearchDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.id = CommonService.getQueryString('id');
    $scope.getDetail = function(id){
        CommonService.httpRequest({
            url : '/baseSfExpressLog/findById.api',
            data :{
                id : id
            }
        }).then(function(data){
            if(data.datas){
                $scope.logs = data.datas;
            }
        });
    }
    if($scope.id){
        $scope.getDetail($scope.id);
    }

    
}]);
