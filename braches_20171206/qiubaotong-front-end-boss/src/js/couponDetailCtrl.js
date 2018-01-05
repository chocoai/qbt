angular.module("app.views")
.controller('couponDetailCtrl',['$scope','CommonService',function ($scope, CommonService) {
  $('body').niceScroll({cursorcolor:"#337ab7"});
  $('.date-picker').datepicker({
    format : 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight:true
  });
  
  $scope.ticketDetailList = JSON.parse(localStorage.getItem('ticketDetail'));
}]);