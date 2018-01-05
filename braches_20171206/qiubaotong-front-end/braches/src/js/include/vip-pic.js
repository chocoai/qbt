var vip_pic_view = Vue.extend({
    template: '#vip-pic',
    data : function(){
        return {
            list : [],
            fbaseUrl : ''
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getImgList : function(){
            var _this = this;
            $.webService.getBagList().then(function(data){
                data.datas.forEach(function(item){
                    item.showDel = false;
                    item.showCheck = false;
                });
                _this.list = data.datas;
            });
        },
        checkImg : function(item){
            var _this = this;
            item.showCheck = true;
            $.confirm2('确定指定该球包吗?',function(){
                item.showCheck = false;
                if(_this.$route.path.indexOf('updatepic')>0){ //详情修改
                    _this.updateImg(item);
                }else{ //申请
                    setStore('vip_img_id',item.id);
                    setStore('vip_img',item.imageUrl);
                    history.back();
                }
            },function(){
                item.showCheck = false;
            });
        },
        updateImg : function(item){
            var _this = this;
            $.commonAjax({
                url : '/vipUser/modifyImg.api',
                type : 'post',
                data : {
                    id : _this.$route.params.id,
                    imgId : item.id
                },
                success : function(){
                    history.back();
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        upload : function(index){
            var _this = this;
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
                    pic : serverId
                },
                success : function(data){
                    var item = {
                        id : data.datas.id,
                        imageUrl : data.datas.imageUrl,
                        showCheck : false,
                        showDel : false
                    };
                    _this.list.push(item);
                    if(_this.$route.path.indexOf('updatepic')>0){ //详情修改
                        _this.updateImg(item);
                    }else{ //申请
                        setStore('vip_img_id',item.id);
                        setStore('vip_img',item.imageUrl);
                        history.back();
                    }
                },
                error : function(err){
                    $.toast(err);
                }
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
