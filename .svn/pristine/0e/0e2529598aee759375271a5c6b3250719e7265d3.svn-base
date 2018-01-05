(function($){
    var app = new Vue({
        data: {
            list:[],
            detail:'',
            fBaseUrl:$.fBaseUrl,
            id:'',
            isFirst:true,
            isLast:true,
            preId:'',
            preTitle:'',
            nextId:'',
            nextTitle:'',
            ids:[],
            titles:[]
        },
        methods:{
            getList : function(num){
                var _this = this;
                var data = {
                    pageNo:num || 1,
                };
                $.ajax({
                    url : $.bossUrl + '/baseNews/findByPageOfficial.api',
                    type : 'post',
                    contentType:'application/json',
                    data : JSON.stringify(data),
                    success : function(data){
                        _this.list = data.datas;
                    }
                });
            },
            getDetail : function(){
                var _this = this;
                $.ajax({
                    url : $.bossUrl + '/baseNews/findByIdOfficial.api',
                    type : 'get',
                    data : {
                        id: _this.id,
                    },
                    success : function(data){
                        _this.detail = data.datas;
                    }
                });
            }
        },
        mounted : function(){
            this.getDetail();
            this.getList();
        }
    }).$mount('#new-contain');

}(jQuery || Zepto));
