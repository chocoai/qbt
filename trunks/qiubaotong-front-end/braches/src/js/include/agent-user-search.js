var agent_user_search_view = Vue.extend({
    template: '#agent-user-search',
    data:function(){
        return{
            keyword: '',
            userList: [],
        }
    },
    vuex : {
        getters : {
            user_msg : function(state){ return state.user_msg}
        }
    },
    methods : {
        getList : function(){
            var self = this;
            $.commonAjax({
                url : '/userProxy/list.api',
                data :{
                    keyword : this.keyword
                },
                success : function(data){
                    self.userList = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        save : function(item){
            var data = {
                mobile : item.mobile,
                name : item.name,
                userId : item.userIdStr
            };
            setStore('user_msg',data);
            history.back();
        }
    },
    route : {
        data : function(){
            this.getList();
        }
    }
});
