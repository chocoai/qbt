"use strict";
angular.module("app.views")
.controller('timelineCtrl',['$scope','CommonService','Constants',function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.detail = function(){
        CommonService.httpRequest({
            url : '/version/list.api',
            method : 'get',
            data : {
            }
        }).then(function(data){
        	$scope.timelines = data.datas;

        });
    };

    $scope.addTimeline = function(){
        tabOpenParent({name:'timeline_add',url:'timelineDetail.html',displayName:'新增里程碑'});
    };

    $scope.detail();

}]);
