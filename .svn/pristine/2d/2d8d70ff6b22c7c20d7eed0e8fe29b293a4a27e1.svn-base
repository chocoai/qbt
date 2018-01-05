var voucher_my_view = Vue.extend({
    template: '#voucher_my',
    data: function() {
        return {
            voucherList: [], //代金券列表
        }
    },
    created: function() {
        this.getVoucherList();
    },
    methods: {
        //返回上一个组件
        getBack: function() {
            router.go(-1);
        },
        //立即使用
        useNow: function() {
            //router.push('/send');
            $.toast('消费金额未达到，无法使用该代金券！');
        },
        //获取代金券列表
        getVoucherList: function() {
            console.log(123);
        }
    }
});