var order_view = Vue.extend({
    template: '#order-menu',
    data : function(){
        return{
            nickname : '',
            name : '',
            mobile : '',
            img : '',
            update : false,
            list_count : 0,
            isVip : false
        }
    },
    vuex :{
        getters :{
            order_refresh : function(state){ return state.order_refresh}
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        goV2Nav : function(url,hach){
            var _url=location.href;
            _url=_url.replace(location.hash,'');
            var index = _url.indexOf('?');
            var hx="";
            hach && (hx=hach);
            if(index == -1){
                location.href = _url + '?_r=' + $.version;
            }else{
                location.href = url + '?_r=' + $.version + '&' + _url.substr(index + 1)+ '#' + hx;
            }
        },
        goNav : function(url){
            locationTo(url);
        },
        goCoupon : function(tab){
            $.ls('usecoupon','');
            setStore('coupon_tab',tab);
            setStore('coupon_refresh',new Date().getTime());
            this.goView('/coupon');
        },
        //我的代金券
        goVoucher : function(){
            this.goView('/voucher');
        },
        //我的券包
        goVoucherBag : function(){
            this.goView('/voucherbag');
        },
        save : function(){
            if(!this.name){
                $.toast('请填写姓名'); return;
            }
            if(!this.mobile || !/1\d{10}/g.test(this.mobile)){
                $.toast('请填写有效手机号'); return;
            }
            $.commonAjax({
                url : '/user/update_user_info.api',
                type : 'post',
                data : {
                    name : this.name,
                    mobile : this.mobile
                }
            });
            this.update = false;
        },
        goOrder : function(tab){
            setStore('order_tab',tab);
            this.goView('/list');
        },
        goVip : function(){
            $.commonAjax({
                url : '/vipUser/list.api',
                success : function(data){
                    if(data.datas.length>0){
                        location.href = 'vip.html?_r=' + $.version + '#!/info';
                    }else{
                        location.href = 'vip.html?_r=' + $.version + '#!/apply';
                    }
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        goActiveVip : function(){
            location.href = 'vip.html?_r=' + $.version + '#!/active';
        },
        goVipBag : function(){
            location.href = 'vip.html?_r=' + $.version + '#!/bag';
        },
        goMyCert : function(){
            location.href = 'vip.html?_r=' + $.version + '#!/mycert';
        }
    },
    ready : function(){
        var self = this;
        $.webService.getUserInfo().then(function(data){
            self.nickname = data.datas.nickname;
            self.name = data.datas.name;
            self.mobile = data.datas.mobile;
            self.img = data.datas.headImgUrl;
        });
        $.webService.getShopCount().then(function(data){
            self.list_count = data.datas;
        })
    }
});
