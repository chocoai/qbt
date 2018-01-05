(function($){

if(!$.weixinAuth()){
   return;
};

var app = new Vue({
    el: '#app',
    data: {
        list_1 : [], //1-进行中
        list_2 : [], //2-即将开始
        list_3 : [], //3-已结束
        isList : true,
        info : {}
    },
    methods: {
        getList : function(){
            var self = this;
            $.commonAjax({
                url : '/activity/list.api',
                data : {
                    type : 1
                },
                success : function(data){
                    self.list_1 = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
            $.commonAjax({
                url : '/activity/list.api',
                data : {
                    type : 2
                },
                success : function(data){
                    self.list_2 = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
            $.commonAjax({
                url : '/activity/list.api',
                data : {
                    type : 3
                },
                success : function(data){
                    self.list_3 = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        goBack : function(){
            if(this.isList){
                locationTo("order.html");
            }else{
                this.isList = true;
            }
        },
        detail : function(id){
            var self = this;
            $.commonAjax({
                url : '/activity/detail.api',
                data : {
                    id : id
                },
                success : function(data){
                    self.info = data.datas;
                    self.isList = false;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        }
    },
    ready: function() {
        this.getList();
        $(function(){
           function tabs(tabTit,on,tabCon){
               $(tabTit).children().click(function(){
                   $(this).addClass(on).siblings().removeClass(on);
                   var index = $(tabTit).children().index(this);
                   $(tabCon).children().eq(index).show().siblings().hide();
               });
           };
           tabs(".tab-hd","active",".tab-bd");
        });
    }
});

}(Zepto))
