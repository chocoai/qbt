var vip_agreement_view = Vue.extend({
    template: '<section class="section bg-white">'+
                '<div class="header tex-c">'+
                  '<a href="javascript:history.back();" class="back"><img src="/img/back.png" /></a>'+
                  '会员卡服务协议'+
                '</div>'+
                '<div id="agreementTpl" class="scroll"></div>'+
              '</section>',
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        }
    },
    ready : function(){
        $('#agreementTpl').load('vipagreement.html #vipagreement');
    }
});
var vip_agreement2_view = Vue.extend({
    template: '<section class="section bg-white">'+
                '<div class="header tex-c">'+
                  '<a href="javascript:history.back();" class="back"><img src="/img/back.png" /></a>'+
                  '会员服务协议实施细则'+
                '</div>'+
                '<div id="agreementTpl" class="scroll"></div>'+
              '</section>',
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        }
    },
    ready : function(){
        $('#agreementTpl').load('vipagreement.html #vipagreement2');
    }
});
