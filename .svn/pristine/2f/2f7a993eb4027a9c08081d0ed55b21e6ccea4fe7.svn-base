var order_voucher_view = Vue.extend({
    template: "#order-voucher",
    data: function() {
        return {
            voucher_tab: 1, //tab栏
            voucherAvailableList: [], //可使用券列表
            voucherDisableList: [], //已使用券列表
        }
    },
    created() {
        this.getAvailableList();
        this.getDisableList();
    },
    methods: {
        goBack: function() {
            this.$router.go(-1);
        },
        //切换tab栏
        toggleTab: function(tab) {
            this.voucher_tab = tab;
        },
        //获取可使用券列表
        getAvailableList : function(){
            var self = this;
            $.commonAjax({
                url : '/myTicketPackage/listAvailableTicket.api',
                success : function(data){
                    var datas = data.datas;
                    self.voucherAvailableList = datas;
                },
                error : function(){
                    $.toast('查询失败');
                }
            });
        },
        //获取已使用券列表
        getDisableList : function(){
            var self = this;
            $.commonAjax({
                url : '/myTicketPackage/listDisableTicket.api',
                success : function(data){
                    var datas = data.datas;
                    self.voucherDisableList = datas;
                },
                error : function(){
                    $.toast('查询失败');
                }
            });
        },
        //立即使用
        useNow : function(){
            locationTo('index.html');
        }
    }
});