var send_view = Vue.extend({
    template : '#sendTpl',
    data : function(){
        return {
            title1 : '取包时间',
            quantity : 1, //数量
            money : '1',
            timeList : [],
            timeValue : [],

            min : 0,
            amount_bj : 0, //保价费用
            amount_yf : 0, //球包实价(或是优惠价)
            amount_op : 0, //球包原价
            amount_py : 0, //球包偏远费
            amount_dis : 0, //会员优惠金额
            expect_times : [],
            expect_selected : {},
            isVip : false,
            showNum : false,
            showInsure : false,
            showUseDiscount : false,
            showDeliver : false,

            selectMebPoint : false,

            coupon_count : 0, //coupon_count大于或等于0表示会员卡数量，coupon_count=-1表示是优惠券，coupon_count=-2表示是机构优惠
            discountType : 0,//1-优惠券优惠 2-会员卡优惠 3-机构群会员优惠
            vipCodes : [],
            coupCode : '',

            vipList : [],
            orderAmount : 0,

            pop_num : 1,
            pop_remark : '',
            pop_num_input : '',

            pop_insure : 1,
            pop_insure_input : '',
            pop_insure_money : 0,
            pop_insure_money_org : 0 ,// 保价费用

            coupon_data : "",

            limitHourValue : "",
            defaultSelVal : '',
            start_date : '',
            minH : 6,
            maxH : 23,

            //机构群会员
            orgNo : 0,
            //orgName : '',
            orgShortName : '',
            isOrg : false, //是否是机构
            isCheck : true,
            amount_org : 0, //机构优惠金额

            isF : true,
            markCtl : true,
            priceIntro : '',
        }
    },
    computed:{
        send_addr : function(){return this.$store.state.send_addr},
        collect_addr : function(){return this.$store.state.collect_addr},
        route_ident : function(){return this.$store.state.route_ident},
        totalAmt : function(){
            var self=this;
            var amount_dis=0; //定义全部优惠金额
            // 除了机构群会员的优惠券和球包通会员
            amount_dis = self.amount_dis; //默认全部优惠金额为会员优惠的方式
            var amount_calcula=function(m){ //优惠劵优惠金额计算
                var freight=self.quantity*(self.amount_yf-self.amount_py),mon=0;
                if(m>freight){
                    mon=freight;
                }else{
                    mon=m
                }
                return mon;
            };
            self.amount_dis != 0 && (amount_dis = self.amount_dis)
            self.coupon_data && self.coupon_data.chlidAmount && (amount_dis = amount_calcula(self.coupon_data.chlidAmount))
            self.amount_org != 0 && (amount_dis = self.isCheck==true?self.amount_org*self.quantity:0)
            var _totalAmt=(self.amount_bj + self.amount_yf) * self.quantity - amount_dis;
            //当优惠券金额大小于总运费的时候的总金额结果
            var num1=(self.amount_bj + self.amount_yf) * self.quantity - amount_dis;
            //当优惠券金额小于总运费金额的时候的总金额结果等于实际保价费X数量
            var num2=self.amount_bj*self.quantity;
            var _totalAmt=self.amount_yf*self.quantity-amount_dis>0 ? num1 : num2;
            return _totalAmt;
        }
    },
    watch : {
        //'timeValue' : 'getAmount',
        'timeValue' : '_getAmount',
        'send_addr.address' : 'getAmount',
        // 'collect_addr.address' : 'getAmount',
        // 'send_addr.name' : 'checkVip',
        // 'send_addr.mobile' : 'checkVip',
        // 'collect_addr.name' : 'checkVip',
        // 'collect_addr.mobile' : 'checkVip',
        'send_addr.name' : 'checkOrg',
        'send_addr.mobile' : 'checkOrg',
        'isCheck' : function(){
            if(this.markCtl){
                this.coupon_count=-2,//coupon_count=-2代表使用的是机构优惠
                this.amount_dis=0,//清空会员优惠券缓存金额
                this.amount_org = window.amount_org,
                this.coupon_data = ''; //清空优惠券当前route缓存数据
                window.couponInfo=undefined ;//清空优惠券全局缓存数据
            }
            else{
                this.markCtl = true;
            }
        },
        'pop_insure' : function(val){
            if(val != -1){
                this.pop_insure_input='';
                this.money=val;
                this.getPrice(val);
            }
        },
        'pop_insure_input' : function(val,oldVal){
            var self=this;
            if(val=='') return;
            $("#pop_insure_input").val(parseInt($("#pop_insure_input").val())); //将输入值取整
            $("#pop_insure_input").trigger("input"); //手动刷新model
            self.pop_insure_input=$("#pop_insure_input").val();
            if(val==$("#pop_insure_input").val())
            {
                self.money=$("#pop_insure_input").val();
                self.getPrice(val);
            }
        },
        'expect_selected' : function(newVal,oldVal){
            newVal.deliver_time && (this.selHourValue=this.start_date = newVal.deliver_time.split(',')[1]);
            // this.min_hour = this.start_date.split(' ')[1].split(':')[0];
            this.limitHourValue = "";
       }
    },
    methods : {
        goView : function(view){
            router.push(view);
        },
        goAddr : function(isJ) {
            var self=this;
            setStore('isJ',isJ);
            if(isJ==true)
            {
                setStore('tabStyle',this.send_addr.tabStyle);
            }else{
                setStore('tabStyle',this.collect_addr.tabStyle);
            }
            this.goView('/isend/address');
        },
        getTime : function(fn){
            var _this = this;
            $.commonAjax({
                url : '/index/time.api',
                success : function(data){
                    var list = [];
                    data.datas.forEach(function(item){
                        var obj = {
                            name : item.day,
                            value : item.day,
                            parent : 0
                        };
                        list.push(obj);
                        item.items.forEach(function(subitem){
                            var subobj = {
                                name : subitem,
                                value : subitem,
                                parent : item.day
                            }
                            list.push(subobj);
                        });
                    });
                    _this.timeList = list;
                    _this.timeValue = [data.datas[0].day,data.datas[0].items[0]];
                    fn && fn();
                },
                error : function(){
                    $.toast(err);
                }
            });
        },
        getPrice : function(val,callback){
            var _this = this;
            $.commonAjax({
                url : '/index/insure.api',
                data : {
                    price : val
                },
                success : function(data){
                    _this.pop_insure_money = data.datas;
                    callback && callback();
                },
                error : function(err){
                    $.toast(err);
                    _this.pop_insure_input = '';
                    _this.pop_insure_money  = 0;
                    _this.pop_insure_money_org = 0;
                }
            });
            $.commonAjax({
                url : '/index/insure_origin.api',
                data : {
                    price : val
                },
                success : function(data){
                    _this.pop_insure_money_org = data.datas;
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        _getAmount : function(){
            var self = this;
            return self.getAmount(self.checkVip,self.checkVip);
        },
        getAmount : function(callbackA,callbackB){
            var self = this;
            $.commonAjax({
                url : '/comm/v2/query_sf_recive_time.api',
                type : 'POST',
                data : {
                    business_type : '0',
                    consigned_time : self.timeValue.join(' ').substr(0,16)+':00',
                    src_address : self.send_addr.address,
                    src_area_id : self.send_addr.areaId,
                    dest_address : self.collect_addr.address,
                    dest_area_id : self.collect_addr.areaId,
                    src_course_id : self.send_addr.addr_type == '1' ? self.send_addr.addr_id : '',
                    dest_course_id : self.collect_addr.addr_type == '1' ? self.collect_addr.addr_id : ''
                },
                success : function(data)
                {
                    if(data.datas && data.datas.length>0)
                    {
                        data.datas.forEach(function(i){
                            i.checked = false;
                        });
                        data.datas[0].checked = true;
                        self.expect_times = data.datas;
                        self.expect_selected = data.datas[0];
                        self.amount_yf = data.datas[0].sf_price;
                        self.amount_op = data.datas[0].origin_price;
                        self.amount_py = data.datas[0].out_range_price;
                        if(self.orgNo!==0)
                        {
                            self.isOrg = true;
                            if(typeof callbackA === "function"){
                                callbackA(self.getAmountConfig)
                            }
                            else{
                                self.getAmountConfig();
                            }
                        }else{
                            self.isOrg = false;
                            self.amount_org = 0;
                        }

                    }else{
                        self.expect_times = [];
                        self.expect_selected = {};
                        self.amount_yf = 0;
                        self.amount_op = 0;
                        self.amount_py = 0;
                    }
                    callbackB && (typeof callbackB === "function") && callbackB();
                },
                error : function(err){
                    self.expect_times = [];
                    self.expect_selected = {};
                    self.amount_yf = 0;
                    $.toast(err);
                }
            });
        },
        checkVip : function(callback){
            var _this = this;
            $.commonAjax({
                url : '/vipInfo/checkVipOrder.api',
                type : 'POST',
                data : {
                    consignedTime : this.timeValue.join(' '),
                    jMobile : this.send_addr.mobile,
                    jName : this.send_addr.name,
                    dMobile : this.collect_addr.mobile,
                    dName : this.collect_addr.name
                },
                success : function(data){
                    _this.isVip=data.datas.isVip;
                    if(data.datas.vipInfos.length>0){
                        var index = 0,money=0;
                        _this.vipList = data.datas.vipInfos.map(function(m,_index){
                            if(index==_index){
                                money = parseFloat(m.orderAmount);
                                index = _index;
                            }else{
                                money>parseFloat(m.orderAmount) && (index=_index,money=parseFloat(m.orderAmount));
                            }
                            return $.extend(m,{checked:false})
                        });
                        _this.vipList[index].checked = true;
                        _this.vipCodes = [data.datas.vipInfos[0].vipNo];
                        _this.discountType = 2;
                        _this.orderAmount = data.datas.vipInfos[0].orderAmount;
                    }else{
                        _this.vipList=[];
                        _this.vipCodes = [];
                        _this.discountType = 0;
                    }
                    _this.saveUseDiscount(1);
                    callback && (typeof callback === "function") && callback();
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        checkOrg : function () {
          var self = this;
          $.commonAjax({
            url:'/index/jContactIsOrg.api',
            type:'post',
            data:{
              jContact:this.send_addr.name,
              jMobile:this.send_addr.mobile
            },
            success : function (data) {
              self.orgNo = data.datas.orgId;
              self.orgShortName = data.datas.orgShortName;
            }
          })
        },
        save : function(){
            var self = this;
            if(self.quantity==0){$.toast("请先选择球包数量！");return}
            (self.send_addr.tabStyle==1) && self.saveAddress(self.send_addr);
            (self.collect_addr.tabStyle==1) && self.saveAddress(self.collect_addr);
            var mdata={
                    business_type : this.expect_selected.business_type,
                    consigned_time : this.timeValue.join(' '),
                    deliver_time : this.expect_selected.deliver_time.split(',')[1],
                    src_address : this.send_addr.address,
                    src_area_id : this.send_addr.areaId,
                    dest_address : this.collect_addr.address,
                    dest_area_id : this.collect_addr.areaId,
                    src_type : this.send_addr.addr_type,
                    src_id : this.send_addr.addr_id,
                    src_moibile : this.send_addr.mobile,
                    src_name : $.trim(this.send_addr.name),
                    dest_type : this.collect_addr.addr_type,
                    dest_id : this.collect_addr.addr_id,
                    dest_moibile : this.collect_addr.mobile,
                    dest_name : $.trim(this.collect_addr.name),
                    price : this.totalAmt,
                    insure_price : this.money,
                    quantity : this.quantity,
                    remark : this.pop_remark,
                    playTime : this.limitHourValue
                };
                if(self.coupon_data=='' && self.amount_dis==0 && self.isCheck===false )
                {
                    mdata.discountType=0;
                }else if(self.coupon_data!='' && self.amount_dis==0 && self.isCheck===false )
                {
                    mdata.discountType=1;
                    mdata.coupCode=self.coupon_data.childCode;
                }else if(self.coupon_data=='' && self.amount_dis!=0 && self.isCheck===false )
                {
                    mdata.discountType=2;
                    mdata.vipCodes=self.vipCodes;
                }else if(self.coupon_data=='' && self.isCheck===true && self.isOrg===true){
                  mdata.discountType=3;
                  mdata.orgId = self.orgNo;
                }else{

                }
            $.commonAjax({
                url : '/order/v2/confirm_order.api',
                type : 'POST',
                data:mdata,
                success : function(data){
                    router.push('/pay/' + data.datas);
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        goCoupon : function(){
            if(this.quantity==0){
                 $.toast("请先选择球包数量！");
                 return;
            }
            //if(this.coupon_count == 0) return;
            this.isCheck = false;
            window.sendTotal=(this.amount_bj + this.amount_yf) * this.quantity;
            router.push('/send/coupon');
        },
        confirmNum : function(){
            var self=this;
            //每次选球包数量的时候，将本地的会员优惠和优惠券优惠置空
            self.amount_dis=0;
            self.coupon_data='';
            if(self.pop_num>1 && self.pop_remark==""){
                $.toast('请填写备注信息'); return;
            }
            self.quantity = self.pop_num;
            self.showNum = false;
        },
        callCust : function(){
           this.showNum = false;
           location.href="tel:400-609-0990";
        },
        showBagNum : function(){
            var self=this;
            self.pop_num=self.quantity;
            self.showNum = true
        },
        confirmInsure : function(){
            var self=this;
            if(self.pop_insure == -1){
                if(!self.pop_insure_input){
                    $.toast('请输入球包保价额'); return;
                }
                self.money = self.pop_insure_input;
            }else{
                self.money = self.pop_insure;
            }
            self.amount_bj = self.pop_insure_money;
            window.pop_insure=self.pop_insure;
            window.pop_insure_input=self.pop_insure_input;
            self.showInsure = false;
        },
        _showInsure : function(){
            if(this.quantity==0) {$.toast("球包数量不能为0！");return;};
            this.showInsure = true;
        },
        showDeliverPop : function(){
            if(this.expect_times.length>0){
                this.showDeliver = true;
            }
        },
        // 点击选择时效
        confirmDeliver : function(){
            var _this = this;
            //每次选送达时间是，将本地的会员优惠和优惠券优惠置空
            _this.amount_dis=0;
            _this.coupon_data='';
            _this.isCheck = false;
            this.expect_times.forEach(function(i){
                if(i.checked){
                    _this.expect_selected = i;
                    _this.amount_yf = i.sf_price;
                    _this.amount_op = i.origin_price;
                    _this.amount_py = i.out_range_price;
                }
            });
            if(_this.orgNo!==0){
                _this.isOrg = true;
                _this.getAmountConfig();
            }else{
                _this.isOrg = false;
                _this.amount_org = 0;
            }
            this.showDeliver = false;
        },
        getAmountConfig:function(){
            var _this = this;
            $.commonAjax({
              url:'/index/suitableOrgGroupAmountConfig.api',
              type:'get',
              data:{
                orgId:_this.orgNo,
                amount:_this.amount_yf
              },
              success : function (data) {
                window.amount_org = data.datas!==null?data.datas.discount:0;
                _this.amount_org = data.datas!==null?data.datas.discount:0;

                _this.isCheck = true;

                _this.vipList = _this.vipList.map(function(m){
                    return $.extend(m,{checked:false})
                });
                _this.saveUseDiscount();

              }
            })
        },
        checkDeliver : function(item){
            this.expect_times.forEach(function(i){
                i.checked = false;
            });
            item.checked = true;
        },
        change : function(){
            var contain_send = $.extend(this.send_addr,{});
            var contain_collect = $.extend(this.collect_addr,{});
            setStore('send_addr',contain_collect);
            setStore('collect_addr',contain_send);
        },
        selectMeb : function(index)
        {
            this.vipList.map(function(m,_index){
                if(index==_index){
                    m.checked = !m.checked;
                }else{
                    m.checked = false;
                }
            });
        },
        saveUseDiscount : function(type)
        {
            var self=this;
            if(type===1){ //重置优惠券及机构群信息
                self.coupon_data = ''; //清空优惠券当前route缓存数据
                window.couponInfo=undefined ;//清空优惠券全局缓存数据
                self.amount_org = 0;  //清空机构优惠金额
                self.isCheck = false; //设置机构优惠选中状态
            } 
            if(self.vipList.length>0){
                var index=0,money=0;
                var some=self.vipList.some(function(m,_index)
                    {
                        return (index=_index,m.checked==true);
                    });
                if(some)
                {
                    money = self.vipList[index].orderAmount;
                    money = parseFloat(money);
                    self.vipCodes=[self.vipList[index].vipNo];
                    self.amount_dis = self.amount_yf-money-self.amount_py;
                }
                else{
                    self.vipCodes = [];
                    self.amount_dis = 0;
                }

            }

            // if(num<=self.quantity)
            // {
            //     self.vipCodes=self.vipList.map(function(m)
            //                   {
            //                     return m.vipNo
            //                   });
            //     self.amount_dis=num*(self.amount_yf-50-self.amount_py);
            // }
            // else
            // {
            //     var arr=[];
            //     for(var i=0;i<self.quantity;i++)
            //     {
            //         arr.push(self.vipCodes[i].vipNo);
            //     };
            //     self.amount_dis=self.quantity*(self.amount_yf-50-self.amount_py);
            // }
            self.showUseDiscount = false;
            self.markCtl = false;
        },
        memberPre : function()
        {
            var self=this;
            if(self.quantity==0) {$.toast("球包数量不能为0！");return;};
            if(self.amount_dis==0){
                self.selectMebPoint=false;
                self.vipList.map(function(m){m.checked=false;});
            }
            self.showUseDiscount=true;
        },
        saveAddress: function(obj){
            var self = this;
            $.commonAjax({
                url : '/userAddress/add.api',
                type : 'POST',
                data : {
                    name : '',
                    mobile : '',
                    areaId : obj.areaId,
                    address : obj.address,
                    labelType : obj.label_type
                },
                success : function(data){
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        clearLimit : function(){
            this.limitHourValue="";
        },
        showLog : function (e) {
          if (e && e.stopPropagation) {//非IE浏览器
            e.stopPropagation();
          }
          else {//IE浏览器
            window.event.cancelBubble = true;
          }
          $(".tip.bottom").removeClass('fade')
        },
        fadeLog : function () {
          $(".tip.bottom").addClass('fade')
        },
        goVip : function(){
            $.commonAjax({
                url : '/vipUser/list.api',
                success : function(data){
                    if(data.datas.length>0){
                        location.href = 'vip.html?_r=' + $.version + '#!/info';
                    }else{
                        location.href = 'vip.html?_r=' + $.version + '#!/apply';
                    }
                },
                error : function(err){
                    $.toast(err);
                }
            });
        },
        compatible_ios_show : function()
        {
            $(".page").css("overflow","hidden");
        },
        compatible_ios_hide : function(){
            this.pop_insure=window.pop_insure || 0;
            this.pop_insure_input=window.pop_insure_input || '';
            $(".page").css("overflow","auto");
        },
        _compatible_ios_hide : function(){
            this.pop_insure=window.pop_insure || 0;
            this.pop_insure_input=window.pop_insure_input || '';
            if(this.pop_insure==-1) {
                this.money=this.pop_insure_input;
            }
            else {
                this.money=this.pop_insure;
            }
            this.getPrice(this.money);
            $(".page").css("overflow","auto");
        },
        
        getPriceIntro : function(){
          var _self = this;
          $.commonAjax({
            url : '/sysConfig/findByCode.api',
            type : 'get',
            data : {
              code : '4'
            },
            success : function (data) {
              _self.priceIntro = data.datas;
            },
            error : function (err) {
              $.toast(err);
            }
          })
        }
    },
    activated : function(){
        var self=this;
        self.getPriceIntro();
        //查询保价 如果收件人和寄件人都存在，默认更新保价这部分逻辑
        if(self.send_addr.address!='' && self.collect_addr.address!='') self.getPrice(self.pop_insure,self.confirmInsure);

        if(self.route_ident=="#coupon")
        {
            //self.coupon_count=-1,代表使用的是优惠码
            window.couponInfo && (
                self.coupon_data=window.couponInfo,//全局优惠券缓存赋予本地路由优惠券缓存
                self.coupon_count=-1,//代表使用的是优惠码
                self.amount_dis=0,//清空会员优惠券缓存金额
                self.amount_org = 0, //清空机构会员优惠的缓存金额
                self.isCheck = false //重置机构优惠的选中状态

                );
        }
        else
        {          
            if(!self.isF)
            {
                self.getAmount(self.checkVip,self.checkVip);
                //判断是否为机构会员
                self.checkOrg();
            }
        };

        //设置路由标示
        setStore('route_ident',"#send");
    },
    mounted : function(){
        var _this = this,
        callback=function(){
            //_this.getAmount(function(){_this.checkVip();});
            _this.checkOrg();
            _this.isF=false;
            _this.getAmount(_this.checkVip,_this.checkVip);
        };
        _this.getTime(callback);
        $.inputRegExp("#pop_insure_input",/^\d+$/);

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

        //保价
        $.commonAjax({
            url : '/index/query_insured.api',
            loading : false,
            success : function(data){
                _this.min = data.datas.min;
                _this.money = data.datas.min;
                _this.amount_bj = data.datas.insuredPrice;
            }
        });

        $.commonAjax({
            url : '/myCoupon/valid_count.api',
            success : function(data){
                _this.coupon_count = data.datas;
            }
        });
    }
});
