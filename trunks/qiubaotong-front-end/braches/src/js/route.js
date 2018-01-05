(function($){

var app = new Vue({
    el: '#app',
    data: {
        query : '',
        msg : '',
        info : {}
    },
    methods : {
        search : function(){
            if(!this.query){
                this.info = {};
                this.msg = '请输入查询条件'; return;
            }
            var self = this;
            $.commonAjax({
                url : '/index/query_keyword.api',
                data :{
                    keyword : this.query
                },
                success : function(data){
                    self.info = data.datas;
                    self.msg = '搜索成功';
                },
                error : function(err){
                    self.info = {};
                    self.msg = err;
                }
            });
        }
    },
    ready: function() {

    }
});

}(Zepto))
