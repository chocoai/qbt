"use strict";
angular.module("app.views")
.controller('orderEvalDetailCtrl',['$scope','CommonService',function($scope,CommonService){
	$('body').niceScroll({cursorcolor:"#337ab7"});
	var manages = JSON.parse(localStorage.getItem('manages'));
	$scope.fBaseUrl = fBaseUrl;
	$scope.orderEvalDetailShow = function(){
		if(!!manages.id){
			$scope.id = manages.id;
			$scope.orderNumber = manages.orderNumber;
			$scope.jTreePath = manages.jTreePath;
			$scope.dTreePath = manages.dTreePath;
			$scope.userName = manages.userName;
			$scope.headImgUrl = manages.headImgUrl;
			$scope.content = $.trim(manages.content);
			$scope.status = manages.status;
			$scope.isTop = manages.isTop;
			$scope.sysUserName = manages.sysUserName;
			$scope.totalLevel = manages.totalLevel;
			$scope.kfLevel = manages.kfLevel;
			$scope.sfPackLevel = manages.sfPackLevel;
			$scope.sfDeliverLevel = manages.sfDeliverLevel;
			$scope.sfServiceLevel = manages.sfServiceLevel;
			$scope.memo = $.trim(manages.memo);
			$scope.imgUrls = manages.imgUrls;
		}
	}



	$scope.orderEvalDetailShow();
	$scope.updateStatus = function(){
		layer.open({
			type: 1,
			title:'请选择审核是否通过',
              skin: 'layui-layer-rim', //加上边框
              area: ['420px', '240px'], //宽高
              content: $('#remark'),
              btn:['通过','不通过'],
              yes:function(index, layero){
              	CommonService.httpRequest({
              		url : '/comment/update.api',
              		method : 'post',
              		data :{
              			id : $scope.id,
              			status:2,
              			memo : $scope.memo
              		}
              	}).then(function(data){
              		tabOpenParent({name:'orderEval',url:'orderEval.html',displayName:'订单评价查询'});
              		layer.close(index);
              	});
              },
              btn2:function(index,layero){
              	CommonService.httpRequest({
              		url : '/comment/update.api',
              		method : 'post',
              		data :{
              			id : $scope.id,
              			status:3,
              			memo : $scope.memo
              		}
              	}).then(function(data){
              		tabOpenParent({name:'orderEval',url:'orderEval.html',displayName:'订单评价查询'});
              		layer.close(index);
              	});
              }
          });
};

}]);

	function imgError(image){  
	    // 隐藏图片  
	    // image.style.display = 'none';  
	    // 替换为默认图片  
	    // document.getElementById("img").setAttribute("src", "images/demo.png");  
	} 
