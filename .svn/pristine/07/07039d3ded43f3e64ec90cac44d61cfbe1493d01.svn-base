var order_voucherbag_view = Vue.extend({
    template : '#order_voucherbag',
    data: function() {
        return {
            count: '', //倒计时
            timer: null, //计时器
            voucher_tab: 1, //切换tab栏
            notActiveList: [], //未激活券包
            activedList: [], //可使用券包
            codeImage: '', //二维码照片
        }
    },
    created() {
        this.getNotActiveList();
        this.getActivedList();
    },
    methods: {
        //返回上一页面
        goBack: function() {
            this.$router.go(-1);
        },
        //切换tab栏
        toggleTab: function(tab) {
            this.voucher_tab = tab;
        },
        //激活券包
        active: function(id) {
            var self = this;
            $.commonAjax({
                url : '/myTicketPackage/activate.api',
                type: 'POST',
                data : {
                    packageId:"62",
                    activateUser:"andytest",
                    activatePhoneNumber:"18617245418"
                },
                success : function(data){
                    self.toggleTab(2);
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        //券包二维码赠送
        codeSend: function() {
            var self = this;
            $.commonAjax({
                url : 'myTicketPackage/qrcode.api',
                type: 'POST',
                data : {
                    url:"http://www.baidu.com?packageId=98&qrCode=431815ad70a69540ba1a1d26b1d629e3",
                    packageId:"98",
                    qrCode:"431815ad70a69540ba1a1d26b1d629e3"
                },
                success : function(data){
                    var datas = 'http://qbt.missionsky.cn:6047/file' + data.datas;
                    self.codeImage = datas;
                    console.log(self.codeImage);
                    setTimeout(function(){
                        layer.open({
                            anim: 'scale',
                            content: $('.codeImage').html(),
                            btn: ['确认赠送'],
                            shade: 'background-color: rgba(0,0,0,.5)',
                            success: function(){
    
                            }
                          });
                    },300);
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        //获取未激活券包
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
        //获取已使用券包
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
        //立即使用券包
        useNow : function(){
            locationTo('index.html');
        }
    }
});