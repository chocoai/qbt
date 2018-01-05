var vip_detail_view = Vue.extend({
    template: '#vip-detail',
    data : function(){
        return {
            vip : {},
            mobile : '',
            vipType : {},
            fbaseUrl : ''
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getInfo : function(id){
            this.mobile = '';
            var self = this;
            $.commonAjax({
                url : '/vipUser/detail.api',
                data : {
                    id : id
                },
                success : function(data){
                    self.vip = data.datas;
                    self.getVipList();
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
                        item.rules = item.rules.replace(/\n/g,'<br/>');
                        self.vipType = item;
                    }
                });
            });
        },
        updatePic : function(id){
            this.$route.router.go({name : 'updatepic', params : {id : this.vip.id}});
        }
    },
    route :{
        data : function(transition){
            this.fbaseUrl = $.fbaseUrl;
            this.getInfo(transition.to.params.id);
        }
    }
});
