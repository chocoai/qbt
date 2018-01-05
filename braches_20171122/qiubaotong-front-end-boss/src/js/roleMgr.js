"use strict";
angular.module("app.views")
.controller("roleMgrCtrl", ["$scope", "CommonService","Constants",function($scope,CommonService,Constants){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    $scope.platforms = Constants.platforms;
    $scope.platId = "1";
    init();

    function init(){

        initTree();

        initRole();

        //右键菜单
        $(document).on("mousedown",'#rolelist td',function(events){

            if(events.which == 3){

                var rdata = [
                    [
                        {
                            text: "新增角色",
                            func: function() {
                                $scope.roleId = "";
                                $scope.name = "";
                                $.fn.zTree.getZTreeObj("tree").checkAllNodes(false);
                                $scope.$apply();
                            }
                        },
                        {
                            text: "删除角色",
                            func: function() {
                                var doc = $(this);
                                layer.confirm("是否确认删除该角色?",function(index){
                                    var id = doc.attr("data");
                                    CommonService.httpRequest({
                                        method : 'get',
                                        url : '/adminSysRole/delete.api',
                                        data :{
                                            id : id
                                        }
                                    }).then(function(data){
                                        initRole();
                                        $scope.roleId = "";
                                        $scope.name = "";
                                        $.fn.zTree.getZTreeObj("tree").checkAllNodes(false);
                                        // $scope.$apply();
                                    });

                                    layer.close(index);
                                });
                            }
                        }
                    ]
                ];

                var options = {"name":"rolelist"};
                $(this).smartMenu(rdata,options);
            }
        });
    };

    function initRole(){

        CommonService.httpRequest({
            method : 'get',
            url : '/adminSysRole/list.api'
        }).then(function(data){
            $scope.allRoles = data.datas;
            $scope.roles = data.datas.filter(function(item){
                return item.platId == $scope.platId;
            });
        });
    };

    function initUser(id){
        CommonService.httpRequest({
            method : 'get',
            url : '/adminUser/listUserByRoleId.api',
            data:{
                roleId : id
            }
        }).then(function(data){
            $scope.users = data.datas;
        });
    };

    function initTree(){
         CommonService.httpRequest({
            method : 'get',
            url : '/adminSysResource/list.api'
        }).then(function(data){
             var list = data.datas;

             list.forEach(function(item){
                item.url = '';
             });

             $(document).ready(function(){
                 createTree(list.filter(function(item){
                     return item.platId == $scope.platId;
                 }));
             });

             $scope.allTrees = list;
        });

    };

    function createTree(data){
        //设置ztree属性
		var setting = {
			view: {
				selectedMulti: false
			},
			check: {
				enable: true,
                chkboxType: { "Y" : "ps", "N" : "ps" }
			},
			data: {
				key:{
					name:"name"
				},
				simpleData: {
					enable:true,
					idKey: "id",
					pIdKey: "superId",
					rootPId: ""
				}
			}
		};
		//生成ztree
		$.fn.zTree.init($("#tree"), setting, data);
		//展开所有节点
		$.fn.zTree.getZTreeObj("tree").expandAll(true);
		//选中所有节点
		//$.fn.zTree.getZTreeObj("tree").checkAllNodes(true);

    };

    $scope.changePalt = function(){
        $scope.roles = $scope.allRoles.filter(function(item){
            return item.platId == $scope.platId;
        });
        createTree($scope.allTrees.filter(function(item){
            return item.platId == $scope.platId;
        }));
        $scope.roleId = "";
        $scope.name = "";
    };

    $scope.role_add = function(){
        var zTree = $.fn.zTree.getZTreeObj("tree");
        var selected = [];

        if(!$scope.name){
            showWarn("角色名称不能为空");
            return false;
        }

        var nodes = zTree.getCheckedNodes(true);
        if(nodes == null || nodes.length == 0 ){
            showWarn("授权项不能为空");
            return false;
        }
        //循环已选中资源
        for(var i = 0 ; i < nodes.length ; i++){
            selected.push(nodes[i].id);
        }

        //add
        if($scope.roleId == null || $scope.roleId == ""){
            CommonService.httpRequest({
                method : 'post',
                url : '/adminSysRole/add.api',
                data :{
                    platId : $scope.platId,
                    name : $scope.name,
                    resourceIdList : selected
                }
            }).then(function(data){
                $scope.roleId = "";
                $scope.name = "";
                showInfo("新增成功",function(){
                    $.fn.zTree.getZTreeObj("tree").checkAllNodes(false);
                    initRole();
                });
            });
        }else{
        //modify
            CommonService.httpRequest({
                method : 'post',
                url : '/adminSysRole/update.api',
                data :{
                    id : $scope.roleId,
                    platId : $scope.platId,
                    name : $scope.name,
                    resourceIdList : selected
                }
            }).then(function(data){
                $scope.roleId = "";
                $scope.name = "";
                showInfo("修改成功",function(){
                    $.fn.zTree.getZTreeObj("tree").checkAllNodes(false);
                    initRole();
                });
            });
        }
    };

    $scope.role_detail = function(id){
        for(var i=0; i < $scope.roles.length; i++){
            if($scope.roles[i].id == id){
                $scope.roleId = id;
                $scope.name = $scope.roles[i].name;
                break;
            }
        }
        //根据选中角色查资源
        CommonService.httpRequest({
            method : 'get',
            url : '/sysRoleResource/list.api',
            data :{
                roleId : $scope.roleId
            }
        }).then(function(data){
            var list = data.datas;
            var zTree = $.fn.zTree.getZTreeObj("tree");
            zTree.checkAllNodes(false);
            for(var i = 0 ; i < $scope.allTrees.length ; i++){
                for(var j = 0 ; j < list.length ; j++){
                    if($scope.allTrees[i].id==list[j]){
                        zTree.checkNode(zTree.getNodeByParam("id", list[j]), true, false);
                        break;
                    }
                }
            }

        });

        //根据选中角色获取用户
        initUser(id);
    }

}]);
