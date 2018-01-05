(function($){

var store = new Vuex.Store({
    state :{
        applyId : '',
        applyType : '', //1-course球场，2-airport机场,3-bank银行,5-顺丰
        applyName : '',
        memo : '',
        order_detail : {},
        order_type : '',
        order_refresh : '',
        salesmanStatus : -1 //0-未申请 1-待审核 2-审核成功 3-审核拒绝
    },
    mutations : {
        SETVAL : function(state,para,val){
            state[para] = val;
        }
    }
});

function setStore(para,val){
    store.dispatch('SETVAL',para,val);
};


@@include('include/bag-workaddr.js')
@@include('include/bag-apply.js')
@@include('include/bag-address.js')
@@include('include/bag-orderlist.js')
@@include('include/bag-orderdetail.js')
@@include('include/bag-audit.js')
@@include('include/bag-applying.js')
@@include('include/bag-applyfail.js')
@@include('include/bag-login.js')

@@include('include/sale-apply.js')
@@include('include/sale-info.js')
@@include('include/sale-data.js')
@@include('include/sale-commission.js')
@@include('include/sale-report.js')

var app = new Vue({
    el: '#app',
    data: {
        currentView : ''
    },
    events: {
        'view-change': function (view) {
            this.currentView = view;
        }
    },
    ready: function() {
        var self = this;
        var code = $.getQueryString('code');
        if(code == null){
            var fromurl = location.href;
            var url = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid='+$.appId+'&redirect_uri=' + encodeURIComponent(fromurl) + '&response_type=code&scope=snsapi_userinfo&state=0#wechat_redirect';
            location.replace(url);
        }else{
            $.commonAjax({
                url:'/index/assistant_login.api',
                data:{
                    "code" : code
                },
                async : false,
                success:function(data){
                    $.ls('token',data.datas.token);
                    setStore("salesmanStatus",data.datas.salesmanStatus);
                    var status = data.datas.status; //0-未注册 1-审核中 2-通过 3-未通过
                    if(status == 0 || status == 4){
                        self.currentView = 'bag_workaddr_view';
                    }
                    if(status == 1 || data.datas.salesmanStatus == 1){
                        self.currentView = 'bag_audit_view';
                    }
                    if(status == 2){
                        //合作机构
                        if(data.datas.applyType == 8){
                            $.ls('applyId',data.datas.applyId);
                            $.ls('applyName',data.datas.applyName);
                            $.ls('applyType',data.datas.applyType);
                            replaceTo('organization.html');
                        }else{
                            setStore('applyId',data.datas.applyId);
                            setStore('applyType',data.datas.applyType);
                            setStore('applyName',data.datas.applyName);
                            self.currentView = 'bag_login_view';
                        }
                    }
                    if(status == 3){
                        setStore('memo',data.datas.memo);
                        self.currentView = 'bag_applyfail_view';
                    }
                },
                error : function(xhr, type, error){
                    $.toast('获取用户授权失败');
                }
            });
        }

    },
    components: {
        'bag_workaddr_view' : bag_workaddr_view,
        'bag_apply_view' : bag_apply_view,
        'bag_address_view' : bag_address_view,
        'bag_orderlist_view' : bag_orderlist_view,
        'bag_orderdetail_view' : bag_orderdetail_view,
        'bag_audit_view' : bag_audit_view,
        'bag_applying_view' : bag_applying_view,
        'bag_applyfail_view' : bag_applyfail_view,
        'bag_login_view' : bag_login_view,
        'sale_apply_view' : sale_apply_view,
        'sale_info_view' : sale_info_view,
        'sale_data_view' : sale_data_view,
        'sale_commission_view' : sale_commission_view,
        'sale_report_view' : sale_report_view
    },
    store : store
});



}(Zepto))
