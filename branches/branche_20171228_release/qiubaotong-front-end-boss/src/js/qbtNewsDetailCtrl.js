"use strict";
angular.module("app.views",['ngFileUpload'])
.controller('qbtNewsDetailCtrl',['$scope','CommonService','Upload',function($scope,CommonService,Upload){
    $('body').niceScroll({cursorcolor:"#337ab7"});
    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
    UE.Editor.prototype.getActionUrl = function(action) {
        if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadimage') {
            return 'http://'+ location.host +'/api/common/imageUpload.api';
        }
        else {
            return this._bkGetActionUrl.call(this, action);
        }
    }
    var ue = UE.getEditor('editor',{
        toolbars: [
            ['simpleupload','|','bold','italic','underline','fontsize','forecolor','backcolor','link','source','justifyleft','justifycenter','justifyright']
        ],
        wordCount:true,//字数统计
        elementPathEnabled:false,//元素路径
        enableAutoSave:false,//启用自动保存
        autoSyncData:false,//自动同步编辑器要提交的数据,
        enableContextMenu:false,//取消右键菜单
        autoHeightEnabled:false//自动长高
    });
    // var ueText = UE.getEditor('editor_text',{
    //     toolbars: [
    //         ['bold','italic','underline','fontsize','forecolor','backcolor','link','source','justifyleft','justifycenter','justifyright']
    //     ],
    //     wordCount:true,
    //     elementPathEnabled:false,
    //     enableAutoSave:false,
    //     autoSyncData:false,
    //     enableContextMenu:false,
    //     autoHeightEnabled:false
    // });

    //获取新闻类型列表
    $scope.getNewsList = function(){
        CommonService.httpRequest({
            url: '/newsCategory/findList.api',
            method: 'get'
        }).then(function(data){
            $scope.newsList = data.datas;
        });
    };

    $scope.id = CommonService.getQueryString('id');
    $scope.previewTitle = {};
    $scope.fBaseUrl = fBaseUrl;
    $scope.getNewsList();

    $scope.getDetail = function(id){
        CommonService.httpRequest({
            url: '/baseNews/findById.api',
            method: 'get',
            data:{
                id: id
            }
        }).then(function(data){
            $scope.title = data.datas.title;
            $scope.imgUrl = data.datas.imgUrl;
            $scope.createTime = data.datas.createTime;
            $scope.category = data.datas.categoryId + '|' + data.datas.categoryName;
            $scope.outline = data.datas.outline;
            $scope.keyword = data.datas.keyword;
            // ueText.addListener("ready", function(){
            //     this.setContent(data.datas.outline);
            // });
            ue.addListener("ready", function(){
                this.setContent(data.datas.content);
            });
        });
    };
    if($scope.id){
        $scope.getDetail($scope.id);
    }

    $scope.newPreview = function(){
        if(!$scope.title){
            showWarn('请输入主题');
            return;
        }
        if(!$scope.imgUrl){
            showWarn('请添加主题照片');
            return;
        }
        if(!$scope.category){
            showWarn('请选择类型');
            return;
        }
        if(!$scope.keyword){
            showWarn('请输入关键字');
            return;
        }
        if(!$scope.outline){
            showWarn('请输入简介');
            return;
        }
        else if($scope.outline.length > 10000){
            showWarn('简介字数最大为10000字');
            return;
        }
        if(!ue.getContentTxt()){
            showWarn('请输入正文');
            return;
        }
        else if(ue.getContentTxt().length > 10000){
            showWarn('正文字数最大为10000字');
            return;
        }
        var nowTime = '';
        if($scope.id){
            nowTime = new Date($scope.createTime);
        }
        else{
            nowTime = new Date();
        }
        $scope.previewMsg = {
            title:$scope.title,
            imgUrl:$scope.imgUrl,
            outline: $scope.outline,
            content: ue.getContent(),
            nowTime : nowTime.getFullYear() + '年' 
                    + (nowTime.getMonth() + 1) + '月'
                    + (nowTime.getDate()) + '日'
        };
        layer.open({
          type: 1,
          title: '预览',
          shadeClose: true,
          shade: 0.8,
          area: ['80%', '90%'],
          content: $('#newPreview'),
        }); 
    };


    $scope.submitNew = function(){
        if(!$scope.title){
            showWarn('请输入主题');
            return;
        }
        if(!$scope.imgUrl){
            showWarn('请添加主题照片');
            return;
        }
        if(!$scope.category){
            showWarn('请选择类型');
            return;
        }
        if(!$scope.keyword){
            showWarn('请输入关键字');
            return;
        }
        if(!$scope.outline){
            showWarn('请输入简介');
            return;
        }
        else if($scope.outline.length > 10000){
            showWarn('简介字数最大为10000字');
            return;
        }
        if(!ue.getContentTxt()){
            showWarn('请输入正文');
            return;
        }
        else if(ue.getContentTxt().length > 10000){
            showWarn('正文字数最大为10000字');
            return;
        }
        if($scope.id){
            CommonService.httpRequest({
                url: '/baseNews/update.api',
                method: 'post',
                data:{
                    id: $scope.id,
                    title: $scope.title,
                    imgUrl: $scope.imgUrl,
                    outline: $scope.outline,
                    keyword: $scope.keyword,
                    content: ue.getContent(),
                    categoryId: $scope.category.split('|')[0],
                    categoryName : $scope.category.split('|')[1]
                }
            }).then(function(data){
                showInfo('更新成功',function(){
                    tabOpenParent({name:'qbtNews',url:'qbtNews.html',displayName:'新闻动态'});
                });
            });
        }
        else{
            CommonService.httpRequest({
                url: '/baseNews/add.api',
                method: 'post',
                data:{
                    title: $scope.title,
                    imgUrl: $scope.imgUrl,
                    outline: $scope.outline,
                    keyword: $scope.keyword,
                    content: ue.getContent(),
                    type:1,
                    categoryId: $scope.category.split('|')[0],
                    categoryName : $scope.category.split('|')[1]
                }
            }).then(function(data){
                showInfo('新增成功',function(){
                    tabOpenParent({name:'qbtNews',url:'qbtNews.html',displayName:'新闻动态'});
                });
            });
        }

    };

    $scope.uploadImg = function($file){
        if($file){
            var isIntegrate = false;
            if($file.size > (10 * 1024 * 1024)){
                showWarn('上传的图片过大'); return;
            }
            var filetypes = [
                //ie9
                // "jfif", "jpe", "dib",
                //
                'image/png', 'image/jpeg', 'image/jpg'
                // 'image/bmp', "image/jfif", "image/dib", "image/jpe"
            ];
            var i = filetypes.indexOf($file.type);
            if (i < 0){
                showWarn('上传的图片格式不正确'); return;
            };
            Upload.upload({
                url: baseUrl + '/common/imageUpload.api',
                method:'post',
                data:{
                    image: $file
                }
            }).progress(function(evt) {//上传进度
                layer.load(1, {
                  shade: [0.1,'#fff']
                });
            }).then(function(data, status, headers, config){
                layer.closeAll();
                $scope.imgUrl = data.data.datas;
                if(data.data.message){
                    showErr(data.data.message);
                }
            })
        }
    };

}]);
