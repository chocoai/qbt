var vip_info_view = Vue.extend({
    template: '#vip-info',
    data : function(){
        return {
            list : [],
            rules : ''
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        goEdit : function(id,view){
            this.$route.router.go({name : view, params : {id : id}});
        },
        getInfo : function(){
            var self = this;
            $.commonAjax({
                url : '/vipUser/list.api',
                success : function(data){
                    self.list  = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        getVipList : function(){
            var self = this;
            $.webService.getVipList({status : 0}).then(function(data){
                data.datas.forEach(function(item){
                    if(item.id == self.vip.vipTypeId){
                        self.rules = item.rules.replace(/\n/g,'<br/>');
                    }
                });
            });
        },
        detail : function(id){
            this.$route.router.go({name : 'detail', params : {id : id}});
        }
    },
    route :{
        data : function(){
            this.getInfo();
        }
    }
});
