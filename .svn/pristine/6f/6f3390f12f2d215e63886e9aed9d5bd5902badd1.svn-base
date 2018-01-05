var order_commentdetail_view = Vue.extend({
    template: '#order-commentdetail',
    data : function(){
        return {
            detail : {},
            fbaseUrl : ''
        }
    },
    vuex :{
        getters :{
            order_comment_detail : function(state){ return state.order_comment_detail}
        }
    },
    watch : {
        'order_comment_detail' : function(val){
            if(val) this.getDetail();
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getDetail : function(){
            var self = this;
            $.commonAjax({
                url : '/order/my_comment.api',
                data : {
                    orderNumber : this.order_comment_detail
                },
                success : function(data){
                    self.detail = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        showPic : function(url,list){
            var url = this.fbaseUrl + url;
            var urls = [];
            for(var i=0;i<list.length;i++){
                urls[i] = this.fbaseUrl + list[i];
            }
            wx.previewImage({
                current: url,
                urls: urls
            });
        }
    },
    ready : function(){
        this.fbaseUrl = $.fbaseUrl;
        this.getDetail();
    }
});
