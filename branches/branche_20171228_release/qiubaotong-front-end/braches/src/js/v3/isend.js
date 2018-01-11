var home_send_view = Vue.extend({
    template : '#index_send',
    data : function(){
        return {
            num : 0
        }
    },
    computed :{
        send_addr : function(){return this.$store.state.send_addr},
        collect_addr : function(){return this.$store.state.collect_addr}
    },
    methods : {
    	goView : function(type){
            var self=this;
            self.num++;
            if(self.num>1) return;
            $("#_loading").show();
            var timer=setTimeout(function(){
                setStore('isJ',type);
                if(type==true)
                {
                    setStore('tabStyle',self.send_addr.tabStyle);
                }else{
                    setStore('tabStyle',self.collect_addr.tabStyle);
                }
                //this.$route.router.go('/isend/address');
                router.push('/isend/address');
                clearTimeout(timer);
            },1000);
    		// setStore('isJ',type);
      //       if(type==true)
      //       {
      //           setStore('tabStyle',this.send_addr.tabStyle);
      //       }else{
      //           setStore('tabStyle',this.collect_addr.tabStyle);
      //       }
      //       //this.$route.router.go('/isend/address');
    		// router.push('/isend/address');
    	},
    	goSend: function(){
            if(this.send_addr.address==""){
                 $.toast("请先输入寄件人地址");
                 return;
            }
            else if(this.collect_addr.address==""){
                 $.toast("请先输入收件人地址");
                 return;
            }
            else{
                if(this.send_addr.address && this.collect_addr.address){
                    router.push('/send');
                }
            }
    	},
        goBack: function(){
            router.push('/');
        }
    },
    activated: function(){
        this.num=0;
        //设置路由标示
        setStore('route_ident',"#isend");
    },
    mounted :function(){
        $.webService.getJsConfig().then(function(data){
            wx.config({
              appId: $.appId,
              timestamp: data.datas.timestamp,
              nonceStr: data.datas.nonceStr,
              signature: data.datas.signature,
              jsApiList: ['getLocation']
            });
            wx.ready(function(){
                wx.getLocation({
                    type: 'wgs84',
                    success: function (res) {
                        setStore('geo_lat',res.latitude);
                        setStore('geo_long',res.longitude);
                    }
                });
            });
        });
    }
});

 