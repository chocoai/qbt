"use strict";
angular.module("app.views")
    .controller('couponRuleListCtrl', ['$scope', 'CommonService', function($scope, CommonService) {
        $('body').niceScroll({ cursorcolor: "#337ab7" });
        $scope.rules = [];
        $scope.getList = function(num) {
            CommonService.pagination({
                url: '/ticketPackageRule/findByPage.api',
                data: {
                    pageNo: num || "1",
                    ruleName: $scope.ruleName
                }
            }).then(function(data) {
                $scope.rules = data.item;
                $scope.page = data.page;
            });
        }
        $scope.getList();

        $scope.toRuleAdd = function() {
            localStorage.removeItem("manages");
            tabOpenParent({ name: 'couponRuleAdd', url: 'couponRuleAdd.html', displayName: '新增规则' });
        };

        document.onkeydown = function(event) {
            var e = event || window.event || arguments.callee.caller.arguments[0];
            if (e && e.keyCode == 13) { // enter 键
                $scope.getList();
            }
        };
    }]);