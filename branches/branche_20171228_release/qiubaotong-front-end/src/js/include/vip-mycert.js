var vip_mycert_view = Vue.extend({
    template: '#vip-mycert',
    data : function(){
        return {
            list : [],
            showList : true,
            fbaseUrl : '',
            detail : {},
            showDel : false,
            allImgNum : 0
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getImgList : function(){
            var _this = this;
            $.webService.getBagList(2).then(function(data){
                data.datas.forEach(function(item){
                    item.showDel = false;
                    item.showCheck = false;
                });
                _this.list = data.datas;
                _this.allImgNum = data.datas.length;
            });
        },
        checkImg : function(item){
            if(this.showDel){ //删除模式
                item.showCheck = !item.showCheck;
                item.showDel = !item.showCheck;
            }else{//详情
                this.showList = false;
                this.detail = item;
            }
        },
        delImg : function(item){
            this.showDel = true;
            this.list.forEach(function(item){
                item.showDel = true;
            });
        },
        delImgs : function(){
            var _this = this;
            var ids = [];
            this.list.forEach(function(item){
                if(item.showCheck){
                    ids.push(item.id);
                }
            });
            if(ids.length==0){
                $.toast('请选择删除球包'); return;
            }
            $.confirm2('确认删除选中球包吗?',function(){
                $.commonAjax({
                    url : '/userImage/delete.api',
                    type : 'post',
                    data : {
                        ids : ids
                    },
                    success : function(){
                        _this.showDel = false;
                        _this.getImgList();
                    },
                    error : function(err){
                        $.toast(err);
                    }
                });
            });

        },
        cancelDel : function(){
            this.showDel = false;
            this.list.forEach(function(item){
                item.showCheck = false;
                item.showDel = false;
            });
        },
        upload : function(index){
            var _this = this;
            if(_this.allImgNum>=2){
                 $.toast("最多只能上传两张证件照");
                 return;
            }
            wx.chooseImage({
                count: 1,
                sizeType: ['compressed'],
                sourceType: ['album', 'camera'],
                success: function (res) {
                    var localIds = res.localIds;
                    wx.uploadImage({
                        localId: localIds[0],
                        isShowProgressTips: 1,
                        success: function (res) {
                            _this.uploadImage(res.serverId);
                        }
                    });
                }
            });
        },
        uploadImage : function(serverId){
            var _this = this;
            $.commonAjax({
                url : '/userImage/add.api',
                data : {
                    pic : serverId,
                    imgType : 2
                },
                success : function(data){
                    _this.list.push({
                        id : data.datas.id,
                        imageUrl : data.datas.imageUrl,
                        showDel : false,
                        showCheck : false
                    });
                    _this.allImgNum =  _this.list.length;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        cancel : function(){
            this.showList = true;
        },
        delete : function(){
            var _this = this;
            $.confirm2('确认删除该球包吗?',function(){
                $.commonAjax({
                    url : '/userImage/delete.api',
                    type : 'post',
                    data : {
                        ids : [_this.detail.id]
                    },
                    success : function(){
                        _this.getImgList();
                        _this.showList = true;
                    },
                    error : function(err){
                        $.toast(err);
                    }
                });
            });

        }
    },
    ready : function(){
        this.fbaseUrl = $.fbaseUrl;
        $.webService.getJsConfig().then(function(data){
            wx.config({
                // debug: true,
                appId: $.appId,
                timestamp: data.datas.timestamp,
                nonceStr: data.datas.nonceStr,
                signature: data.datas.signature,
                jsApiList: ['chooseImage','uploadImage']
            });
        });

        this.getImgList();
    }
});
