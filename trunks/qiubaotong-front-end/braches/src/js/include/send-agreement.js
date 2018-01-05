var send_agreement_view = Vue.extend({
    template: '<section class="section bg-white">'+
                '<div class="header tex-c">'+
                  '<a href="javascript:;" class="back" @tap="$route.router.go(\'/\')"><img src="/img/back.png" /></a>'+
                  '球包通服务协议'+
                '</div>'+
                '<div id="agreementTpl" class="scroll"></div>'+
              '</section>',
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        }
    },
    ready : function(){
        $('#agreementTpl').load('agreement.html #agreement');
    }
});
