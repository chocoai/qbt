var order_comment_view = Vue.extend({
    template: '#order-comment',
    data : function(){
        return {
            comment_kf : 5, //客服
            comment_sf1 : 5, //包装
            comment_sf2 : 5, //速度
            comment_sf3 : 5, //配送
            comment_text : '',
            comment_img : {
                img0 : '',
                img1 : '',
                img2 : '',
            },
            pics : []
        }
    },
    vuex :{
        getters :{
            order_comment : function(state){ return state.order_comment}
        }
    },
    watch : {
        'order_comment' : function(val){
            if(val) this.init();
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        init : function(){
            this.comment_kf = 5;
            this.comment_sf1 = 5;
            this.comment_sf2 = 5;
            this.comment_sf3 = 5;
            this.comment_text = '';
            this.comment_img.img0 = '';
            this.comment_img.img1 = '';
            this.comment_img.img2 = '';
            this.pics = [];
        },
        upload : function(index){
            var self = this;
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
                            var serverId = res.serverId;
                            self.comment_img['img'+index] = localIds[0];
                            self.pics[index] = serverId;
                        }
                    });
                }
            });
        },
        submit : function(){
            if(!this.comment_text || $.trim(this.comment_text).length<10){
                $.toast('评价不能小于10字'); return;
            }
            var self = this;
            var pic = [];
            for(var i = 0;i<this.pics.length;i++){
                if(this.pics[i]){
                    pic.push(this.pics[i]);
                }
            }
            $.commonAjax({
                url : '/order/add_comment.api',
                type : 'post',
                data : {
                    orderNumber : this.order_comment,
                    kfLevel : this.comment_kf,
                    sfPackLevel : this.comment_sf1,
                    sfDeliverLevel : this.comment_sf2,
                    sfServiceLevel : this.comment_sf3,
                    content : $.trim(this.comment_text),
                    pics : pic
                },
                success : function(data){
                    setStore('order_refresh',new Date().getTime());
                    self.goView('/list');
                },
                error : function(err){
                    $.toast(err);
                }
            });
        }
    },
    ready : function(){
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
    }
});
