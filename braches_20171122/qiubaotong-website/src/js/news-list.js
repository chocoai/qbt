(function($){
    var app = new Vue({
        data: {
            list:'',
            fBaseUrl:$.fBaseUrl,
            ids:[],
            titles:[],
            page:{},
            pages:[],
            currentPage:1
        },
        methods:{
            
        },
        mounted : function(){
            // this.getList();
        }
    }).$mount('#new-list');

}(jQuery || Zepto));
