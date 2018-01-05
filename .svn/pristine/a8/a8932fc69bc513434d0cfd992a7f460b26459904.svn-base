(function($){

if(!$.weixinAuth()){
   return;
};

var app = new Vue({
    el: '#app',
    data: {
        list : [],
        hasNext : false,
        busy : false,
        fbaseUrl : '',
        errMsg : ''
    },
    methods: {
        getList : function(){
            var self = this;
            $.commonAjax({
                url : '/order/comment_list.api',
                type : 'post',
                data : {
                    pageSize : 5
                },
                success : function(data){
                    self.list = data.datas;
                    self.hasNext = data.page.hasNext;
                    if(data.datas.length>0){
                        self.errMsg = '';
                    }else{
                        self.errMsg = '暂无评价';
                    }
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        getMore : function(){
            if(!this.hasNext) return;
            var self = this;
            this.busy = true;
            $.commonAjax({
                url : '/order/comment_list.api',
                type : 'post',
                data : {
                    lastRecordId : this.list[this.list.length - 1].id,
                    pageSize : 5
                },
                success : function(data){
                    self.list = self.list.concat(data.datas);
                    self.hasNext = data.page.hasNext;
                    self.busy = false;
                },
                error : function(err){
                    $.toast(err);
                    self.busy = false;
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
    ready: function() {
        this.getList();
        this.fbaseUrl = $.fbaseUrl;
    }
});

}(Zepto))
