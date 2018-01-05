var send_starttime_view = Vue.extend({
    template: '#send-start-time',
    data : function(){
        return{
            day_list : [],
            time_list : [],
            selectDay : ''
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        checkDay : function(day){
            this.selectDay = day;
            for(var i = 0; i < this.day_list.length ; i++){
                var item = this.day_list[i];
                if(item.day == day){
                    this.time_list = item.items;
                    break;
                }
            }
        },
        checkTime : function(time){
            setStore('send_time',this.selectDay + " " + time);
            this.goView('/');
        }
    },
    ready : function(){
        var self = this;
        $.commonAjax({
            url : '/index/time.api',
            success : function(data){
                self.day_list = data.datas;
                self.time_list = data.datas[0].items;
                self.selectDay = data.datas[0].day;
            },
            error : function(){
                $.toast(err);
            }
        });
    }
});
