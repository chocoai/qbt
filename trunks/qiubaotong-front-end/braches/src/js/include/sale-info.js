var sale_info_view = Vue.extend({
    template: '#sale-info',
    data : function(){
        return{
        }
    },
    vuex :{
        getters : {
            applyId : function(state){ return state.applyId;}
        }
    },
    methods : {
        goView : function(view){
            this.$dispatch('view-change',view);
        },
        goBack : function(){
            if(this.applyId){
                this.goView('bag_login_view');
            }else{
                this.goView('bag_workaddr_view');
            }
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
        _goV2Nav : function(url,hach){
          var _url=location.href;
          _url=_url.replace(location.hash,'');
          var index = _url.indexOf('?');
          var hx="";
          hach && (hx=hach);
          if(index == -1){
            location.href = _url + '?_r=' + $.version;
          }else{
            location.href = url + '?_r=' + $.version + '&' + _url.substr(index + 1)+ '&orderstatus=1&isreplace=1' + '#' + hx;
          }
        }
    }
});
