var sale_report_view = Vue.extend({
    template: '#sale-report',
    data : function(){
        return{
            list : [],
            year : '',
            month : '',
            settleStatus : 0,
            tab : 1
        }
    },
    methods : {
        goView : function(view){
            this.$dispatch('view-change',view);
        },
        getList : function(){
            if(!this.year || !this.month){
                return;
            }
            var _this = this;
            $.commonAjax({
                url : this.tab == 1 ? '/saleUser/orderList.api' : '/saleUser/subcripbeList.api',
                type : 'post',
                data : {
                    queryDate : this.year + '-' + this.month,
                    settleStatus : this.settleStatus
                },
                success : function(data){
                    _this.list = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        }
    },
    watch : {
        'year' : 'getList',
        'month' : 'getList',
        'settleStatus' : 'getList',
        'tab' : 'getList'
    },
    ready : function(){
        this.year = new Date().getFullYear();
        var month = new Date().getMonth() + 1;
        this.month = month < 10 ? '0' + month : '' + month;
    }
});
