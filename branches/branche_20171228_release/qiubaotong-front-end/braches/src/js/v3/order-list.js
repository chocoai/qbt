var order_list_view = Vue.extend({
    template : '#orderListTpl',
    data : function(){
        return {
            onFetching : false,
            scroller_a : [],
            scroller_b : [],
            scroller_c : [],
            glob : {
                lastRecordId_a : 0,
                lastRecordId_b : 0,
                lastRownum_b : 0,
                hasNext : true, //是否有下一页数据
                showNotOrderImg : false
            },
            isReplace : 0,
            showDetail : false
        }
    },
    computed :{
        orderStatus : function(){return this.$store.state.orderStatus},
    },
    methods : {
        getOrderListType : function(type)
        {
            var self=this;
            self.glob.showNotOrderImg=false;
            self.onFetching=false;
            setStore('orderStatus',type);
            if(type==0 || type==1)
            {
                self.scroller_a=[];
                self.glob.lastRecordId_a=0;
                self.glob.hasNext=true;
                self.getOrderList(type);
                self.$nextTick(function(){
                    self.$refs.scrollerBottom_a.reset({top:0});
                });    
            }
            else if(type==2 || type==3 || type==4)
            {
                self.scroller_b=[];
                self.glob.lastRecordId_b=0;
                self.glob.lastRownum_b=0;
                self.glob.hasNext=true;
                self.getOrderList(type);
                self.$nextTick(function(){
                    self.$refs.scrollerBottom_b.reset({top:0});
                });    
            }
        },
        goView : function(view){
            router.push(view);
        },
        getOrderList : function(type)
        {
            var self=this;
            if(!self.glob.hasNext) return;
            self.onFetching=true;
            if(type==0 || type==1)
            {
                $.commonAjax({
                    url : '/order/cart_list.api',
                    type : 'post',
                    loading : false,
                    data :{
                        applyId : 0,
                        lastRecordId : self.glob.lastRecordId_a,
                        orderStatus : type,
                        pageSize : 5,
                        proxyUserId : self.isReplace==1?1:0,
                        type : 1
                    },
                    success : function(data){                   
                        setTimeout(function(){
                            self.glob.hasNext=data.page.hasNext;
                            var datas=data.datas
                            if(datas.length==0 && self.scroller_a.length==0)  self.glob.showNotOrderImg=true;
                            if(datas.length==0) return;
                            self.glob.lastRecordId_a=datas[datas.length-1].id;
                            self.scroller_a=self.scroller_a.concat(datas);
                            self.$nextTick(function(){
                                self.$refs.scrollerBottom_a.reset();
                            });
                            self.onFetching=false;
                        },1000);    
                    },
                    error : function(err){
                        $.toast(err);
                    }
                });
            }else if(type==2 || type==3 || type==4)
            {
                $.commonAjax({
                    url : '/order/list.api',
                    type : 'post',
                    loading : false,
                    data :{
                        lastRecordId : self.glob.lastRecordId_b,
                        orderStatus : type,
                        pageSize : 5,
                        proxyUserId : self.isReplace==1?1:0,
                        type : 1,
                        lastRownum : self.glob.lastRownum_b        
                    },
                    success : function(data){                    
                        setTimeout(function(){
                            self.glob.hasNext=data.page.hasNext;
                            var datas=data.datas
                            if(datas.length==0 && self.scroller_b.length==0)  self.glob.showNotOrderImg=true;
                            if(datas.length==0) {
                                return;
                            }else{
                            }
                            self.glob.lastRecordId_b=datas[datas.length-1].id;
                            self.glob.lastRownum_b=datas[datas.length-1].rownum;
                            self.scroller_b=self.scroller_b.concat(datas);
                            self.$nextTick(function(){
                                self.$refs.scrollerBottom_b.reset();
                            });
                            self.onFetching=false;
                        },1000);    
                    },
                    error : function(err){
                        $.toast(err);
                    }
                });
            }else{

            }
        },
        onScrollBottom : function()
        {
            var self=this;
            if(!self.glob.hasNext) return;
            if (self.onFetching) {
            }else 
            {
                self.getOrderList(self.orderStatus)
            }
        },
        showDetails_a : function(index)
        {
            var self=this;
            if(self.orderStatus==0)
            {
                var order_num=self.scroller_a[index].number;
                $.commonAjax({
                    url : '/order/sub_list.api',
                    loading : false,
                    type : 'get',
                    data :{
                        orderId : order_num
                    },
                    success : function(data){  
                        self.scroller_c=data.datas;
                        self.$nextTick(function(){
                            $("#popupDetail").get(0).scrollTop ="0px";
                        });
                        self.showDetail=true;                    
                    },
                    error : function(err){
                        $.toast(err);
                    }
                })
            }
            else if(self.orderStatus==1)
            {
                setStore('orderStatus',1);
                var order_num=self.scroller_a[index].number;
                router.push('/pay/' + order_num);
            }
            else{}
        },
        showDetails_b : function(index,type)
        {
            var self=this;
            //运输中
            if(self.orderStatus==2)
            {
                var order_num=self.scroller_b[index].number;
                if(type==1) {setStore('orderDetail',1);}
                else if(type==2) {setStore('orderDetail',2);}
                else {}
                router.push('/order/' + order_num);
            }
            //已签收
            else if(self.orderStatus==3)
            {
                var order_num=self.scroller_b[index].number;
                setStore('orderDetail',1);
                router.push('/order/' + order_num);
            }
            //待取件
            else if(self.orderStatus==4)
            {
                var order_num=self.scroller_b[index].number;
                setStore('orderDetail',0);
                router.push('/order/' + order_num);
            }
            else{}
        },
        showDetails_c : function(index,type)
        {
            var self=this;
            var obj=self.scroller_c[index];
            //orderStatus:1-待支付 2-支付中 3-支付成功 4-支付失败(可重新) 5-订单关闭-用户取消 6-订单关闭-系统关单 7-订单关闭-客服取消
            //待支付
            if(obj.orderStatus==1 || obj.orderStatus==2)
            {
                setStore('orderStatus',1);
                router.push('/pay/' + obj.orderNumber);
            }else if(obj.orderStatus==3)
            {
                //待取件
                if(obj.deliveryStatus==1 || obj.deliveryStatus==2)
                {
                    setStore('orderStatus',4);
                    setStore('orderDetail',0);
                    router.push('/order/' + obj.number);
                }
                //运输中
                else if(obj.deliveryStatus==3 || obj.deliveryStatus==4 || obj.deliveryStatus==5 || obj.deliveryStatus==6)
                {
                    setStore('orderStatus',2);
                    setStore('orderDetail',type);
                    router.push('/order/' + obj.number);
                }
                //已送达
                else if(obj.deliveryStatus==7)
                {
                    setStore('orderStatus',3);
                    setStore('orderDetail',1);
                    router.push('/order/' + obj.number);
                }else{
                }
            //支付失败
            }else if(obj.orderStatus==4)
            {
                setStore('orderStatus',1);
                setStore('orderDetail',0);
                router.push('/order/' + obj.number);
            }
            //订单关闭
            else if(obj.orderStatus==5 || obj.orderStatus==6 || obj.orderStatus==7)
            {
                setStore('orderStatus',1);
                setStore('orderDetail',0);
                router.push('/order/' + obj.number);
            }
            else{
            }
        },
        //type==1返回文字，type==2返回颜色
        showStart : function(obj,type)
        {
            if(obj.orderStatus==1 || obj.orderStatus==2)
            {
                return type===1 ? "待付款" : "#e9573e"
            }else if(obj.orderStatus==3)
            {
                if(obj.deliveryStatus==1 || obj.deliveryStatus==2)
                {
                    return type===1 ? "待取件" : "#FF9600"
                }else if(obj.deliveryStatus==3 || obj.deliveryStatus==4 || obj.deliveryStatus==5 || obj.deliveryStatus==6)
                {
                    return type===1 ? "运输中" : "#13B2F4"
                }else if(obj.deliveryStatus==7)
                {
                    return type===1 ? "已送达" : "#15ca5f"
                }else{
                    return ""
                }
            }
            else if(obj.orderStatus==4)
            {
                return type===1 ? "支付失败" : "#DADADA"
            }else if(obj.orderStatus==5 || obj.orderStatus==6 || obj.orderStatus==7)
            {
                return type===1 ? "订单关闭" : "#DADADA"
            }
            else{
                return ""
            }
        },
        cancel : function(item,type){
            var self = this;
            var isCurrent = item.isCurrent;
            var str;
            if(isCurrent==true){
                str='当日取消订单，扣除20元服务费，确定取消订单？';
            }
            else{
                str='确定取消订单？';
            }
            $.confirm(str,function(){
                $.commonAjax({
                    url : '/order/cancel.api',
                    type : 'post',
                    data : {orderId : item.number},
                    success : function(data){
                        $.alert('取消成功',function(){
                            //item.orderStatus = 5; //用户取消
                            self.getOrderListType(type);
                        });
                    },
                    error : function(err){
                        $.toast(err);
                    }
                });
            });
        },
        backOrder : function(item){
            var self=this;
            $.commonAjax({
                url : '/order/v2/back.api',
                data :{
                    orderId : item.number
                },
                success : function(data){
                    var datas = data.datas;
                    //1-course球场，2-airport机场,3-bank银行,4-address个人地址,5-顺丰
                    var send_addr={
                        type : 1,
                        name : datas.jContact,
                        mobile : datas.jMobile,
                        address : datas.jAddress,
                        real_address : '',
                        treePath : datas.jTreePath,
                        areaId : datas.jAreaId,
                        addr_type : datas.jAddrType,
                        addr_id : datas.jAddrId,
                        remark : '',
                        tabStyle : datas.jAddrType==1?2:datas.jAddrType==2?3:datas.jAddrType==4?1:'',
                        treeId : datas.jTreeId,
                        label_type : datas.jLabelType,
                        siteName : datas.jAddrName,
                        isOutRange : datas.jIsOutRange,
                        //该id字段只要用于处理address页面确定取值问题
                        id : datas.jAddrId
                    },
                    collect_addr={
                        type : 1,
                        name : datas.dContact,
                        mobile : datas.dMobile,
                        address : datas.dAddress,
                        real_address : '',
                        treePath : datas.dTreePath,
                        areaId : datas.dAreaId,
                        addr_type : datas.dAddrType,
                        addr_id : datas.dAddrId,
                        remark : '',
                        tabStyle : datas.dAddrType==1?2:datas.dAddrType==2?3:datas.dAddrType==4?1:'',
                        treeId : datas.dTreeId,
                        label_type : datas.dLabelType,
                        siteName : datas.dAddrName,
                        isOutRange : datas.dIsOutRange,
                        //该id字段只要用于处理address页面确定取值问题
                        id : datas.dAddrId
                    };
                    setStore('send_addr',send_addr);
                    setStore('collect_addr',collect_addr);
                    self.goView('/send');
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        // 确认已送达
        confirmReceive : function (id) {
            var _self = this;
          $.confirm('确认球包已收到，并且球包完好无损！',function () {
              // 调接口 todo
              $.commonAjax({
                url : '/order/confirm.api',
                type : 'get',
                data : {
                    id : id
                },
                success : function (data) {
                  _self.getOrderListType(3)
                }
              })
          })
        }
    },
    activated : function(){
        this.showDetail=false;
        this.getOrderListType(this.orderStatus);

        //设置路由标示
        setStore('route_ident',"#order");
    },
    mounted : function(){
        //对其他快捷入口的orderStatus进行设定
        var self = this;
        var orderstatus=$.getQueryString('orderstatus');
        var isreplace = $.getQueryString('isreplace');
        if(orderstatus) {
            orderstatus=parseInt(orderstatus);
            if(orderstatus>0 && orderstatus<5) setStore('orderStatus',orderstatus);        
        }
        if(isreplace){
            self.isReplace = isreplace;
        }
    }
});
