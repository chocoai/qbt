var order_voucherbag_view = Vue.extend({
    template : '#order_voucherbag',
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
        },
        active: function() {
            layer.open({
              anim: 'scale',
              content: '<form>'+
            '姓名：<input type="text" placeholder="请输入姓名"></br>'+
            '手机：<input type="number" placeholder="请输入手机号">'+
        '</form>',
              btn: ['提交'],
              shade: 'background-color: rgba(0,0,0,.5)',
            });
        },
        codeSend: function() {
            layer.open({
              anim: 'scale',
              content: '哈哈',
              btn: ['提交'],
              shade: 'background-color: rgba(0,0,0,.5)',
            });
        }
    }
});