var order_voucher_view = Vue.extend({
    template: "#order-voucher",
    data: function() {
        return {
            voucher_tab: 1
        }
    },
    methods: {
        goBack: function() {
            this.$router.go(-1);
        },
        toggleTab: function(tab) {
            this.voucher_tab = tab;
        }
    }
});