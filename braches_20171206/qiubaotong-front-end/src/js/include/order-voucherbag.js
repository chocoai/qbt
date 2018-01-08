var order_voucherbag_view = Vue.extend({
    template : '#order_voucherbag',
    data: function() {
        return {
            count: '', //倒计时
            timer: null, //计时器
            voucher_tab: 1,
            notActiveList: [],
            activedList: [],
        }
    },
    created() {
        this.getNotActiveList();
        this.getActivedList();
    },
    methods: {
        goBack: function() {
            this.$router.go(-1);
        },
        toggleTab: function(tab) {
            this.voucher_tab = tab;
        },
        //激活券包
        active: function(num) {
            var self = this; //vue实例
            layer.open({  //激活券包弹窗
              anim: 'scale',
              content: $('.tankuang').html(),
              btn: ['确认激活'],
              shade: 'background-color: rgba(0,0,0,.5)',
              success: function(elem){
                $(elem).find('.activeCode').click(function(){
                    var TIME_COUNT = 60;
                    var _this = this; //弹窗自身
                    if (!self.timer) {
                        self.count = TIME_COUNT;
                        var that = self;
                        self.timer = setInterval(function() {
                            if (that.count > 0 && that.count <= TIME_COUNT) {
                                that.count--;
                                $(_this).find('span').html('剩余 '+self.count+' s');
                            } else {
                                clearInterval(that.timer);
                                that.timer = null;
                                $(_this).find('span').html('验证码');
                            }
                        }, 1000);
                    }
                });
              },
              yes: function(index){
                layer.close(index);
              }    
            });
        },
        //券包二维码赠送
        codeSend: function() {
            layer.open({
              anim: 'scale',
              content: 'voucherCode',
              btn: ['确认赠送'],
              shade: 'background-color: rgba(0,0,0,.5)',
            });
        },
        getNotActiveList : function(){
            var self = this;
            $.commonAjax({
                url : '/myTicketPackage/listNotActive.api',
                success : function(data){
                    var datas = data.datas;
                    self.notActiveList = datas;
                },
                error : function(){
                    $.toast('查询失败');
                }
            });
        },
        getActivedList : function(){
            var self = this;
            $.commonAjax({
                url : '/myTicketPackage/listUsed.api',
                success : function(data){
                    var datas = data.datas;
                    self.activedList = datas;
                    
                },
                error : function(){
                    $.toast('查询失败');
                }
            });
        },
    }
});