"use strict";
angular.module("app.views")
.controller('dashboardCtrl',['$scope','CommonService',function($scope,CommonService){
  $('body').niceScroll({cursorcolor:"#337ab7"});
	$scope.list = [];
  $scope.isDealed = "false";
    $scope.getList = function(num){
        CommonService.pagination({
        	url : '/orderException/findByPage.api',
        	data :{
        		pageNo : num || "1",
            isDealed : $scope.isDealed
            }
        }).then(function(data){
        	$scope.list = data.item;
        	$scope.page = data.page;
        });
    }
    $scope.getList(1);
    $scope.mark = function(id){
      layer.open({
        type: 1,
        title:'标记任务已处理',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '240px'], //宽高
              content: $('#remark'),
              btn:['确定','关闭'],
              yes:function(index, layero){
                if(!$scope.remark){
                  showWarn('处理备注不能为空');
                }
                else{
                  CommonService.httpRequest({
                    url : '/orderException/deal.api',
                    method : 'post',
                    data :{
                      id : parseInt(id),
                      remark: $scope.remark
                    }
                  }).then(function(data){
                    $scope.getList(1);
                    layer.close(index);
                  });

                }
              }
            });
    };

	$scope.detail = function(id){
		tabOpenParent({
            name:'orderDetail' +id,
            url:'orderDetail.html?id='+id,
            displayName: '订单' + id
        });
	};
}]);
