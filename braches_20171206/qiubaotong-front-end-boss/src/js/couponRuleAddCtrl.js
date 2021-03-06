"use strict";
angular.module("app.views")
    .controller('couponRuleAddCtrl', ['$scope', 'CommonService', function ($scope, CommonService) {
        $('body').niceScroll({cursorcolor: "#337ab7"});
        var id = localStorage.getItem('manages');
        $scope.id = '';
        $scope.packages = [];
        $scope.status = '1';

        $scope.addPackage = function () {
            var pack = {'ticketName': '', 'ticketPrice': '', 'payPrice': '', 'quantity': '', 'useLimit': ''};
            $scope.packages.push(pack);
        }


        $scope.countAmount = function () {
            $scope.amount = 0;
            $scope.payAmount = 0;
            angular.forEach($scope.packages, function (item) {
                if (!!parseFloat(item.payPrice) && !!parseInt(item.quantity)) {
                    $scope.payAmount = $scope.payAmount + parseFloat(item.payPrice) * parseInt(item.quantity);
                }
                if (!!parseFloat(item.ticketPrice) && !!parseInt(item.quantity)) {
                    $scope.amount = $scope.amount + parseFloat(item.ticketPrice) * parseInt(item.quantity);
                }
            });
        }

        $scope.deleteMoney = function (id) {
            $scope.packages.splice(id, 1);
            $scope.countAmount();
        }

        $scope.submitPackage = function () {
            //规则名称
            if (!$scope.name) {
                showWarn("规则名称不能为空");
                return false;
            }

            //规则描述
            if (!$scope.memo) {
                showWarn("描述不能为空");
                return false;
            }

            //礼品券清单
            if (!$scope.amount) {
                $scope.amount = '';
                showWarn("请添加礼品券及完善礼包信息");
                return false;
            }
            else if ($scope.amount > 999999999.99) {
                showWarn('金额不能大于999999999.99');
                return false;
            }
            else if ($scope.amount <= 0) {
                for (var i = 0; i < $scope.packages.length; i++) {
                    if ($scope.packages[i].amount <= 0 || $scope.packages[i].number <= 0 || $scope.packages[i].limitAmount <= 0) {
                        showWarn("配置信息不能为小于0");
                        return false;
                    }
                }
            }
            else {
                for (var i = 0; i < $scope.packages.length; i++) {
                    if ($scope.packages[i].limitAmount > 999999999.99) {
                        showWarn('使用限制不能大于999999999.99');
                        return false;
                    }
                }
            }
            ;

            if (!$scope.id) {
                CommonService.httpRequest({
                    url: '/ticketPackageRule/add.api',
                    method: 'post',
                    data: {
                        ruleName: $scope.name,
                        price: $scope.amount,
                        payPrice: $scope.payAmount,
                        status: $scope.status,
                        description: $scope.memo,
                        isStorageService: $scope.isStorageService,
                        ticketPackageRuleConfVolist: $scope.packages
                    }
                }).then(function (data) {
                    showInfo("新增成功", function () {
                        tabOpenParent({name: 'couponRuleList', url: 'couponRuleList.html', displayName: '规则管理'});
                    });
                });
            }
        }
    }]);
