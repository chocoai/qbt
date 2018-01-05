"use strict";
angular.module("app.views")
.controller('timelineDetailCtrl',['$scope','CommonService',function($scope,CommonService){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $('.date-picker').datepicker({
        format : 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight : true
    });

    $scope.addTimeline = function(){

        if(!$scope.version){
            showWarn("版本不能为空");
            return false;
        }
        if(!$scope.reversion){
            showWarn("子版本号不能为空");
            return false;
        }
        if(!$scope.publishedOn){
            showWarn("发布日期不能为空");
            return false;
        }
        if(!$scope.description){
            showWarn("版本描述不能为空");
            return false;
        }
        var descriptions = $scope.description.split('\n');
        var description = '';
        for(var i = 0; i < descriptions.length; i++){
            description = description + descriptions[i] + '<br>';
        }
        CommonService.httpRequest({
        	method : 'post',
        	url : '/version/add.api',
        	data:{
        		version : $scope.version,
        		reversion : $scope.reversion,
        		publishedOn : $scope.publishedOn,
        		description : description
        	}
        }).then(function(data){
        	showInfo("新增成功",function(){
        		tabOpenParent({name:'timeline',url:'timeline.html',displayName:'里程碑'});
        	});
        });
    }

}]);
