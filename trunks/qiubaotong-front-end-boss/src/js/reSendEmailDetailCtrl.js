"use strict";
angular.module("app.views")
.controller('reSendEmailDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.getList = function(){
        var manages = localStorage.getItem('manages');
        if(manages != '' && manages != null){
         $scope.message = JSON.parse(manages);
       }
    }
    $scope.getList();

}]);
