var shoplist_list_view = Vue.extend({
    template: '#shoplist-list',
    data : function(){
        return{
            order_list : [],
            checkedAll : true,
            totalAmt : 0,
            totalCount : 0,
            isVip : false, //是否vip
            vipAmt : 0 //vip下单金额
        }
    },
    methods : {
        goView : function(view){
            this.$route.router.go(view);
        },
        getList : function(){
            var self = this;
            $.webService.getShopList().then(function(data){
                var list = data.datas;
                list.forEach(function(item){
                    if(item.status == 1){
                        item.checked = true;
                    }else{
                        item.checked = false;
                    }
                    item.editQuantity = item.quantity;
                });
                self.order_list = list;
                self.checkedAll = true;
                self.getTotalAmt();
            },function(err){
                $.toast(err);
            });
        },
        detail : function(item){
            setStore('order_detail',item);
            this.goView('/detail');
        },
        deleteOne : function(item){
            var self = this;
            $.webService.delShopList({
                ids : [item.id]
            }).then(function(data){
                self.order_list.$remove(item);
                self.getTotalAmt();
            },function(err){
                $.toast(err);
            });
        },
        updateOne : function(item,add){
            var num = item.quantity;
            if(add){
                if(num >= 99){
                    return;
                }else{
                    num ++;
                }
            }else {
                if(num <=1){
                    return;
                }else{
                    num --;
                }
            }
            var self = this;
            var ids = [item.id];
            var nums = [num];
            $.webService.updateShopList({
                ids : ids,
                nums : nums
            }).then(function(data){
                item.quantity = num;
                self.getTotalAmt();
            },function(err){
                $.toast(err);
            });
        },
        checkItem : function(item){
            if(item.status == 1){
                item.checked = !item.checked;
                this.getTotalAmt();
                //检查是否全部选中
                var a=0,b=0;
                this.order_list.forEach(function(i){
                    if(i.status == 1){
                        a ++;
                    }
                    if(i.checked){
                        b ++;
                    }
                });
                this.checkedAll = (a == b) ? true : false;
            }
        },
        checkAll : function(){
            if(this.checkedAll){
                this.checkedAll = false;
                this.order_list.forEach(function(item){
                    item.checked = false;
                });
            }else{
                this.checkedAll = true;
                this.order_list.forEach(function(item){
                    if(item.status == 1){
                        item.checked = true;
                    }else{
                        item.checked = false;
                    }
                });
            }
            this.getTotalAmt();
        },
        getTotalAmt : function(){
            var amt = 0;
            var count = 0;
            this.order_list.forEach(function(item){
                if(item.checked){
                    amt += (item.insuredFee + item.freight) * item.quantity;
                    count += item.quantity;
                }
            });
            this.totalAmt = amt;
            this.totalCount = count;
        },
        confirmOrder : function(){
            var self = this;
            var ids = [];
            this.order_list.forEach(function(item){
                if(item.checked){
                    ids.push(item.id);
                }
            });
            if(ids.length ==0 ){
                $.toast('请选择订单'); return;
            }

            $.webService.confirmOrder({
                ids : ids
            }).then(function(data){
                location.href = 'order.html?v=' + $.version + '#!/mpay/' + data.datas;
            },function(err){
                $.toast(err);
            });

        },
        goIndex : function(){
            if(this.order_list.length>0){
                var item = this.order_list[0];
                var data = {
                    jAddrType: item.jAddrType,
                    jCityName: item.jTreePath,
                    jAddress: item.jAddress,
                    jUserName: item.jContact,
                    jMobile: item.jMobile,
                    jAreaId: item.jAreaId,
                    jAddressName: item.jAddrName || item.jAddress,
                    jAddrId: item.jAddrId,
                    dAddrType: item.dAddrType,
                    dCityName: item.dTreePath,
                    dAddress: item.dAddress,
                    dUserName: item.dContact,
                    dMobile: item.dMobile,
                    dAreaId: item.dAreaId,
                    dAddressName: item.dAddrName || item.dAddress,
                    dAddrId: item.dAddrId,
                    sendTimeSection : item.sendTimeSection,
                    insureValue : item.insuredValue
                };
                $.ls('redoAddrType','1');
                $.ls('redoAddr',JSON.stringify(data));
            }
            locationTo('index_v1.html');
        }
    },
    ready : function(){
        this.getList();
        var self = this;
        //用户信息
        $.webService.getUserInfo().then(function(data){
            self.isVip = data.datas.vip;
            self.vipAmt = data.datas.vipAmount;
        });
    }
});
