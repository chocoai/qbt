drop table if exists `order_email_templet`;
/*==============================================================*/
/*Table: `order_email_templet`                                         */
/*==============================================================*/
create table `order_email_templet`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`order_email_insured_id` int  not null  comment '订单邮件保价id',
`email_template_code` varchar(50)  not null  comment '邮件模板code',
`email_config_code` varchar(50)  not null  comment '邮件配置code',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `email_config`;
/*==============================================================*/
/*Table: `email_config`                                         */
/*==============================================================*/
create table `email_config`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`platform` varchar(50)  not null  comment '平台类型（球包通：qbt）',
`code` varchar(50)  not null  comment '唯一标识码',
`name` varchar(50)  not null  comment '名称',
`host` varchar(100)  not null  comment '邮箱主机',
`port` varchar(50)  not null  comment '邮箱端口',
`username` varchar(100)  not null  comment '邮箱用户名',
`password` varchar(50)  not null  comment '邮箱密码',
`send_from` varchar(100)  not null  comment '发送者邮箱',
`send_to` text  not null  comment '收件地址列表',
`send_to_cc` text    comment '抄送地址列表',
`operator_id` int  not null  comment '操作人id',
`operator_name` varchar(100)    comment '操作人名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_email_insured`;
/*==============================================================*/
/*Table: `order_email_insured`                                         */
/*==============================================================*/
create table `order_email_insured`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`min` int  not null  comment '保价最小值',
`max` int  not null  comment '保价最大值',
`order_email_id` int  not null  comment '订单邮件id',
`email_template_code` varchar(50)  not null  comment '邮件模板code',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_email`;
/*==============================================================*/
/*Table: `order_email`                                         */
/*==============================================================*/
create table `order_email`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`subject` varchar(255)  not null  comment '标题',
`code` varchar(50)  not null  comment 'code',
`plat_type` varchar(50)  not null  comment '平台类型（球包通：qbt）',
`operator_id` int  not null  comment '操作人id',
`operator_name` varchar(100)    comment '操作人名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `email_template`;
/*==============================================================*/
/*Table: `email_template`                                         */
/*==============================================================*/
create table `email_template`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`subject` varchar(255)  not null  comment '标题',
`content` varchar(255)  not null  comment '内容',
`code` varchar(50)  not null  comment 'code',
`plat_type` varchar(50)  not null  comment '平台类型（球包通：qbt）',
`operator_id` int  not null  comment '操作人id',
`operator_name` varchar(100)    comment '操作人名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_advert`;
/*==============================================================*/
/*Table: `base_advert`                                         */
/*==============================================================*/
create table `base_advert`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`code` varchar(50)  not null  comment '广告位code',
`name` varchar(255)  not null  comment '广告位名称',
`describe` varchar(255)    comment '位置描述',
`flat_type` int(1)  not null  comment '类型（1PC，2微信）',
`open_type` int(1)  not null  comment '展开类型(1本页展开，2新页展开)',
`number` int(1)  not null  comment '顺序（1,2,3.........）',
`status` int(1)  not null  comment '状态（1启用，0禁用）',
`operator_id` int  not null  comment '操作人id',
`operator_name` varchar(100)    comment '操作人名称',
`remark` varchar(255)    comment '备注',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_advert_image`;
/*==============================================================*/
/*Table: `base_advert_image`                                         */
/*==============================================================*/
create table `base_advert_image`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`advert_code` varchar(50)  not null  comment '广告位code',
`image` varchar(255)  not null  comment '图片内容',
`url` varchar(255)  not null  comment '广告链接',
`operator_id` int  not null  comment '操作人id',
`operator_name` varchar(100)    comment '操作人名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_handle_steps`;
/*==============================================================*/
/*Table: `order_handle_steps`                                         */
/*==============================================================*/
create table `order_handle_steps`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`order_handle_id` int  not null  comment '订单事件预警id',
`order_id` int  not null  comment '子订单id',
`type` int(2)  not null  comment '处理类型: 1-预警 2-事件',
`object_id` int  not null  comment '处理对象id',
`object_name` varchar(50)  not null  comment '处理对象名称',
`step` int  not null  comment '处理步骤序号',
`step_name` varchar(100)  not null  comment '处理步骤名称',
`handle_status` int(2)  not null  comment '处理状态 0-未处理 1-已处理',
`handle_time` datetime    comment '处理时间',
`operator_id` int  not null  comment '操作人id',
`operator_name` varchar(100)    comment '操作人名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_handle`;
/*==============================================================*/
/*Table: `order_handle`                                         */
/*==============================================================*/
create table `order_handle`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`order_id` int  not null  comment '子订单id',
`type` int(2)  not null  comment '处理类型: 1-预警 2-事件',
`object_id` int  not null  comment '处理对象id',
`object_name` varchar(50)  not null  comment '处理对象名称',
`weight` int(5)  not null  comment '权重',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_event`;
/*==============================================================*/
/*Table: `base_event`                                         */
/*==============================================================*/
create table `base_event`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`type` int(2)  not null  comment '事件类型:1-时效 2-地点 3-附加',
`name` varchar(50)  not null  comment '事件名称',
`weight` int(5)  not null  comment '权重',
`status` int(2)  not null  comment '状态: 1-启用 2-禁用',
`remark` varchar(200)    comment '备注',
`operator_id` int  not null  comment '操作人id',
`operator_name` varchar(100)    comment '操作人名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_handle_steps`;
/*==============================================================*/
/*Table: `base_handle_steps`                                         */
/*==============================================================*/
create table `base_handle_steps`(
`id` int  not null auto_increment comment '主键',
`handle_id` int  not null  comment '处理信息id',
`name` varchar(100)  not null  comment '处理步骤名称',
`step` int  not null  comment '处理步骤序号',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_handle`;
/*==============================================================*/
/*Table: `base_handle`                                         */
/*==============================================================*/
create table `base_handle`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`type` int(2)  not null  comment '处理类型: 1-预警 2-事件',
`object_id` int  not null  comment '处理对象id',
`name` varchar(100)  not null  comment '处理名称',
`status` int(2)  not null  comment '状态: 1-启用 2-禁用',
`remark` varchar(200)    comment '备注',
`operator_id` int  not null  comment '操作人id',
`operator_name` varchar(100)  not null  comment '操作人名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_warning_config`;
/*==============================================================*/
/*Table: `base_warning_config`                                         */
/*==============================================================*/
create table `base_warning_config`(
`id` int  not null auto_increment comment '主键',
`warning_id` int  not null  comment '预警id',
`code` varchar(50)  not null  comment '配置code',
`name` varchar(50)  not null  comment '配置名称',
`value` decimal(11,2)  not null  comment '配置值',
`remark` varchar(200)    comment '配置值',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_warning`;
/*==============================================================*/
/*Table: `base_warning`                                         */
/*==============================================================*/
create table `base_warning`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`code` varchar(50)  not null  comment '预警code',
`name` varchar(50)  not null  comment '预警名称',
`weight` int(5)  not null  comment '权重',
`status` int(2)  not null  comment '状态: 1-启用 2-禁用',
`remark` varchar(100)    comment '备注',
`operator_id` int  not null  comment '操作人id',
`operator_name` varchar(100)    comment '操作人名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `bag_code_order`;
/*==============================================================*/
/*Table: `bag_code_order`                                         */
/*==============================================================*/
create table `bag_code_order`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`bag_code_partner_id` int  not null  comment '合作方包包码id',
`bag_code_partner_name` varchar(50)  not null  comment '合作方名称',
`bag_code` varchar(20)  not null  comment '包包码',
`user_id` int  not null  comment '用户id',
`nickname` varchar(255)  not null  comment '微信昵称',
`name` varchar(100)  not null  comment '用户名',
`mobile` varchar(20)  not null  comment '手机号',
`activity_id` int  not null  comment '活动id',
`activity_name` varchar(100)  not null  comment '活动名称',
`order_id` int  not null  comment '子订单id',
`order_number` varchar(20)  not null  comment '子订单编号',
`status` int  not null  comment '状态 0-未知 1-成功 2-失败',
`result` varchar(100)    comment '使用结果',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `bag_code_user`;
/*==============================================================*/
/*Table: `bag_code_user`                                         */
/*==============================================================*/
create table `bag_code_user`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`bag_code_partner_id` int  not null  comment '合作方包包码id',
`bag_code_partner_name` varchar(50)  not null  comment '合作方名称',
`bag_code` varchar(20)  not null  comment '包包码',
`user_id` int  not null  comment '用户id',
`nickname` varchar(255)  not null  comment '微信昵称',
`name` varchar(100)  not null  comment '用户名',
`mobile` varchar(20)  not null  comment '手机号',
`activity_id` int  not null  comment '活动id',
`activity_name` varchar(100)  not null  comment '活动名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `bag_code_partner`;
/*==============================================================*/
/*Table: `bag_code_partner`                                         */
/*==============================================================*/
create table `bag_code_partner`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(50)  not null  comment '合作方名称',
`bag_code` varchar(20)  not null  comment '包包码',
`start_date` date  not null  comment '合作开始时间',
`end_date` date  not null  comment '合作结束时间',
`activity_id` int  not null  comment '活动id',
`activity_name` varchar(100)  not null  comment '活动名称',
`same_info` bit(1)  not null  comment '是否需要寄件人和收件人一致',
`sender_random` bit(1)  not null  comment '是否寄件人信息随意',
`status` int  not null  comment '状态 1-可用 2-禁用',
`operator_id` int  not null  comment '操作人id',
`operator_name` varchar(100)  not null  comment '操作人名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `org_group_amount_config`;
/*==============================================================*/
/*Table: `org_group_amount_config`                                         */
/*==============================================================*/
create table `org_group_amount_config`(
`id` int  not null auto_increment comment '主键',
`org_id` int  not null  comment '机构群id',
`type` int  not null  comment '优惠类型 1-满减',
`min_amount` decimal(11,2)  not null  comment '最低金额',
`max_amount` decimal(11,2)  not null  comment '最高金额',
`discount` decimal(11,2)  not null  comment '优惠金额/比例',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `org_group_user`;
/*==============================================================*/
/*Table: `org_group_user`                                         */
/*==============================================================*/
create table `org_group_user`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(100)  not null  comment '用户名',
`mobile` varchar(100)  not null  comment '电话号码',
`status` int  not null  comment '状态 1-可用 2-禁用',
`remark` varchar(200)    comment '备注',
`org_id` int  not null  comment '机构群id',
`org_name` varchar(100)  not null  comment '机构群名称',
`operator_id` int  not null  comment '操作员id',
`operator_name` varchar(100)    comment '操作员名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `org_group`;
/*==============================================================*/
/*Table: `org_group`                                         */
/*==============================================================*/
create table `org_group`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(100)  not null  comment '机构名',
`short_name` varchar(100)  not null  comment '简称',
`start_date` date  not null  comment '合作开始时间',
`end_date` date  not null  comment '合作结束时间',
`contact` varchar(50)    comment '联系人',
`mobile` varchar(50)    comment '联系电话',
`status` int  not null  comment '状态 1-可用 2-禁用',
`remark` varchar(300)    comment '备注',
`operator_id` int  not null  comment '操作员id',
`operator_name` varchar(100)    comment '操作员名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `out_range_address`;
/*==============================================================*/
/*Table: `out_range_address`                                         */
/*==============================================================*/
create table `out_range_address`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`area_id` int  not null  comment '地区ID',
`tree_path` varchar(200)  not null  comment '地区中文路径',
`out_range_time` decimal(8)  not null  comment '偏远球场时效(天数)',
`out_range_price` decimal(8)  not null  comment '偏远球场价格',
`address` varchar(100)    comment '地址',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `channel_qrcode_info`;
/*==============================================================*/
/*Table: `channel_qrcode_info`                                         */
/*==============================================================*/
create table `channel_qrcode_info`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(20)  not null  comment '二维码渠道名称',
`channel_qrcode_code` varchar(20)  not null  comment '识别码标识',
`ticket` varchar(100)  not null  comment '二维码图片ticket',
`qrcode_url` varchar(100)  not null  comment '二维码url',
`status` int(2)  not null  comment '状态（1-正常 2-无效）',
`remark` varchar(255)    comment '备注',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_order_contact`;
/*==============================================================*/
/*Table: `user_order_contact`                                         */
/*==============================================================*/
create table `user_order_contact`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`user_id` int  not null  comment '用户ID',
`contact` varchar(10)  not null  comment '联系人',
`mobile` varchar(20)  not null  comment '手机',
`uuid` varchar(225)  not null  comment '唯一值:md5(user_id+contact+mobile)',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_new_sf_price`;
/*==============================================================*/
/*Table: `base_new_sf_price`                                         */
/*==============================================================*/
create table `base_new_sf_price`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`start_area` varchar(32)  not null  comment '寄件地区',
`end_area` varchar(32)  not null  comment '收件地区',
`cichen_favourable_price` decimal(5,2)  not null  comment '次晨优惠价格',
`cichen_qbt_price` decimal(5,2)  not null  comment '次晨球包通价格',
`ciri_favourable_price` decimal(5,2)  not null  comment '次日优惠价格',
`ciri_qbt_price` decimal(5,2)  not null  comment '次日球包通价格',
`geri_favourable_price` decimal(5,2)  not null  comment '隔日优惠价格',
`geri_qbt_price` decimal(5,2)  not null  comment '隔日球包通价格',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_sf_time`;
/*==============================================================*/
/*Table: `base_sf_time`                                         */
/*==============================================================*/
create table `base_sf_time`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(100)  not null  comment '名称',
`start_date` date  not null  comment '起始日期',
`end_date` date  not null  comment '结束日期',
`adjust_date` date  not null  comment '调整日期',
`reference_date` date  not null  comment '参考日期',
`remark` varchar(200)    comment '备注',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_link`;
/*==============================================================*/
/*Table: `base_link`                                         */
/*==============================================================*/
create table `base_link`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(100)  not null  comment '名称',
`url` varchar(200)  not null  comment '链接',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_news_category`;
/*==============================================================*/
/*Table: `base_news_category`                                         */
/*==============================================================*/
create table `base_news_category`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(100)  not null  comment '分类名称',
`sort` int  not null  comment '排序',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_address_type`;
/*==============================================================*/
/*Table: `order_address_type`                                         */
/*==============================================================*/
create table `order_address_type`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`order_id` int  not null  comment '订单ID',
`order_time` datetime  not null  comment '订单日期',
`user_order_address_id` int  not null  comment '用户下单地址id',
`user_order_address_uuid` varchar(225)  not null  comment '用户下单地址uuid',
`type` int  not null  comment '1-寄件 2-收件',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_address_route`;
/*==============================================================*/
/*Table: `order_address_route`                                         */
/*==============================================================*/
create table `order_address_route`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`order_id` int  not null  comment '订单ID',
`order_time` datetime  not null  comment '订单日期',
`j_user_order_address_id` int  not null  comment '寄件用户下单地址id',
`j_user_order_address_uuid` varchar(225)  not null  comment '寄件用户下单地址uuid',
`d_user_order_address_id` int  not null  comment '收件用户下单地址id',
`d_user_order_address_uuid` varchar(225)  not null  comment '收件用户下单地址uuid',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_order_address`;
/*==============================================================*/
/*Table: `user_order_address`                                         */
/*==============================================================*/
create table `user_order_address`(
`id` int  not null auto_increment comment '主键',
`user_id` int  not null  comment '用户ID',
`addr_type` int  not null  comment '地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址,5-顺丰站点',
`country_area_id` int  not null  comment '国家地区id',
`country_area_name` varchar(100)  not null  comment '国家地区名',
`province_area_id` int  not null  comment '省地区id',
`province_area_name` varchar(100)  not null  comment '省地区名',
`city_area_id` int  not null  comment '市地区id',
`city_area_name` varchar(100)  not null  comment '市地区名',
`district_area_id` int  not null  comment '地区id',
`district_area_name` varchar(100)  not null  comment '地区名',
`tree_path` varchar(200)  not null  comment '地区中文路径',
`addr_id` int  not null  comment '非个人地址ID，个人地址为0',
`addr_name` varchar(100)  not null  comment '地址名称，如果个人地址为空',
`address` varchar(100)  not null  comment '地址',
`contact` varchar(10)  not null  comment '联系人',
`mobile` varchar(20)  not null  comment '手机',
`uuid` varchar(225)  not null  comment '地址唯一值:md5(user_id+addr_type+district_area_id+addr_id+address+contact+mobile)',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_sf_express_log`;
/*==============================================================*/
/*Table: `base_sf_express_log`                                         */
/*==============================================================*/
create table `base_sf_express_log`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`service_name` varchar(100)  not null  comment '方法名称',
`keyword` varchar(100)  not null  comment '关键字',
`request_body` text  not null  comment '请求报文',
`response_body` text  not null  comment '响应报文',
`status` int  not null  comment '状态 1-成功 2-失败',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_proxy`;
/*==============================================================*/
/*Table: `user_proxy`                                         */
/*==============================================================*/
create table `user_proxy`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`user_id` int  not null  comment '被代下单用户ID',
`proxy_user_id` int  not null  comment '销售员用户ID',
`name` varchar(50)  not null  comment '姓名',
`mobile` varchar(20)  not null  comment '手机号',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_proxy_address`;
/*==============================================================*/
/*Table: `user_proxy_address`                                         */
/*==============================================================*/
create table `user_proxy_address`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`user_id` int  not null  comment '被代下单用户ID',
`proxy_user_id` int  not null  comment '销售员用户ID',
`area_id` int  not null  comment '地区ID',
`tree_path` varchar(200)  not null  comment '地区中文路径',
`address` varchar(100)  not null  comment '地址',
`contact` varchar(10)  not null  comment '联系人',
`mobile` varchar(20)  not null  comment '手机',
`is_default` bit(1)  not null  comment '是否默认',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_news`;
/*==============================================================*/
/*Table: `base_news`                                         */
/*==============================================================*/
create table `base_news`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`type` int  not null  comment '1-新闻',
`title` varchar(100)  not null  comment '标题',
`img_url` varchar(100)  not null  comment '新闻图片',
`outline` text  not null  comment '概要',
`content` text  not null  comment '内容',
`read_times` int  not null  comment '阅读次数',
`status` int  not null  comment '1-有效 2-无效',
`keyword` varchar(100)    comment '关键字',
`category_id` int  not null  comment '分类id',
`category_name` varchar(100)    comment '分类名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_weixin_reply`;
/*==============================================================*/
/*Table: `base_weixin_reply`                                         */
/*==============================================================*/
create table `base_weixin_reply`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`type` int  not null  comment '1-文本 2-图文',
`keyword` varchar(40)  not null  comment '关键词',
`content` int  not null  comment '内容，如果是图文是Json内容{title,pic,url,description}',
`status` int  not null  comment '1-有效 2-无效',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `sale_weixin_subcripbe_info`;
/*==============================================================*/
/*Table: `sale_weixin_subcripbe_info`                                         */
/*==============================================================*/
create table `sale_weixin_subcripbe_info`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`subcripbe_time` datetime  not null  comment '关注日期',
`sale_id` int  not null  comment '销售人员ID',
`user_id` int  not null  comment '微信用户ID',
`nickname` varchar(40)  not null  comment '微信昵称',
`amount` decimal(11,2)  not null  comment '提成金额',
`status` int  not null  comment '1-有效 2-无效',
`settle_status` int  not null  comment '1-未结算 2-已结算',
`settle_time` datetime    comment '结算时间',
`sys_user_id` int    comment '结算人员ID',
`sys_user_name` varchar(100)    comment '结算人名称',
`settle_method` int    comment '支付方式 1-微信 3-支付宝 4-汇款 5-现金',
`remark` varchar(100)    comment '备注',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `sale_order_info`;
/*==============================================================*/
/*Table: `sale_order_info`                                         */
/*==============================================================*/
create table `sale_order_info`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`order_time` datetime  not null  comment '下单时间',
`sale_id` int  not null  comment '销售人员ID',
`order_id` int  not null  comment '订单ID',
`order_amount` decimal(11,2)  not null  comment '订单金额',
`amount` decimal(11,2)  not null  comment '提成金额',
`status` int  not null  comment '1-有效 2-待生效 3-无效',
`settle_status` int  not null  comment '1-未结算 2-已结算',
`settle_time` datetime    comment '结算时间',
`sys_user_id` int    comment '结算人员ID',
`sys_user_name` varchar(100)    comment '结算人名称',
`settle_method` int    comment '支付方式 1-微信 3-支付宝 4-汇款 5-现金',
`remark` varchar(100)    comment '备注',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `sale_user`;
/*==============================================================*/
/*Table: `sale_user`                                         */
/*==============================================================*/
create table `sale_user`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`salesman_code` varchar(20)  not null  comment '销售人员编号',
`user_id` int  not null  comment '微信用户ID',
`name` varchar(40)  not null  comment '姓名',
`mobile` varchar(20)  not null  comment '手机号',
`idcard` varchar(20)    comment '身份证号',
`idcard_url` varchar(200)    comment '身份证照片',
`email` varchar(100)    comment '点子邮箱',
`company` varchar(40)    comment '工作单位',
`qrcode` varchar(100)  not null  comment '二维码图片URL',
`type` int  not null  comment '0-未知 1-固定金额 2-订单金额比例',
`type_value` decimal(11,2)    ,
`subscribe_value` decimal(11,2)    comment '关注奖金金额',
`apply_status` int  not null  comment '1-待审核 2-审核通过 3-审核不通过',
`apply_time` datetime    comment '审核时间',
`status` int  not null  comment '状态 1-有效 2-无效',
`status_time` datetime    comment '状态更新时间',
`sys_user_id` int    comment '审核人id',
`sys_user_name` varchar(255)    comment '审核人姓名',
`sys_user_mobile` varchar(20)    comment '审核人手机号',
`first_type` int  not null  comment '首单提成方式: 0-未知 1-固定金额 2-订单金额比例',
`first_type_value` decimal(11,2)    ,
`order_day_type` int  not null  comment '代下单日类型 1-不限 2-有限制天数',
`order_day_value` int    comment '代下单日',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `sale_qrcode_info`;
/*==============================================================*/
/*Table: `sale_qrcode_info`                                         */
/*==============================================================*/
create table `sale_qrcode_info`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`qrcode_create_info_id` int  not null  comment '二维码记录ID',
`salesman_code` varchar(20)  not null  comment '销售人员编号',
`apply_status` int  not null  comment '0-未申请 1-已申请',
`company` varchar(40)    comment '工作单位',
`ticket` varchar(100)    comment '微信永久二维码ticekt',
`qrcode` varchar(100)  not null  comment '二维码图片URL',
`type` int  not null  comment '0-未知 1-固定金额 2-订单金额比例',
`type_value` decimal(11,2)    ,
`subscribe_value` decimal(11,2)    comment '关注奖金金额',
`qrcode_create_info_id` int  not null  comment '销售二维码生成记录id',
`qrcode_create_info_name` varchar(20)  not null  comment '销售二维码生成记录名称',
`first_type` int  not null  comment '首单提成方式: 0-未知 1-固定金额 2-订单金额比例',
`first_type_value` decimal(11,2)    ,
`order_day_type` int  not null  comment '代下单日类型 1-不限 2-有限制天数',
`order_day_value` int    comment '代下单日',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `sale_qrcode_create_info`;
/*==============================================================*/
/*Table: `sale_qrcode_create_info`                                         */
/*==============================================================*/
create table `sale_qrcode_create_info`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(20)  not null  comment '生成批次名称',
`number` int  not null  comment '生成数量',
`apply_number` int default 0.0 not null  comment '已申请数量',
`company` varchar(40)    comment '企业名称',
`type` int  not null  comment '0-未知 1-固定金额 2-订单金额比例',
`type_value` decimal(11,2)  not null  ,
`subscribe_value` decimal(11,2)  not null  comment '关注奖金金额',
`create_type` int  not null  comment '1-人工 2-系统',
`first_type` int  not null  comment '首单提成方式: 0-未知 1-固定金额 2-订单金额比例',
`first_type_value` decimal(11,2)    ,
`order_day_type` int  not null  comment '代下单日类型 1-不限 2-有限制天数',
`order_day_value` int    comment '代下单日',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_weixin_menu`;
/*==============================================================*/
/*Table: `base_weixin_menu`                                         */
/*==============================================================*/
create table `base_weixin_menu`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(20)  not null  comment '菜单名称',
`menu_type` int  not null  comment '1-点击推事件 2-跳转URL',
`type_name` varchar(20)  not null  comment '1-click 2-view',
`type_value` varchar(255)  not null  comment '1-随机值 2-跳转URL',
`super_id` int  not null  comment '父级菜单id',
`sort` int  not null  comment '排序值',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_weixin_menu_temp`;
/*==============================================================*/
/*Table: `base_weixin_menu_temp`                                         */
/*==============================================================*/
create table `base_weixin_menu_temp`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(20)  not null  comment '菜单名称',
`menu_type` int  not null  comment '1-点击推事件 2-跳转URL',
`type_name` varchar(20)  not null  comment '1-click 2-view',
`type_value` varchar(255)  not null  comment '1-随机值 2-跳转URL',
`super_id` int  not null  comment '父级菜单id',
`sort` int  not null  comment '排序值',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_cost_item`;
/*==============================================================*/
/*Table: `order_cost_item`                                         */
/*==============================================================*/
create table `order_cost_item`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`order_id` int  not null  comment '订单id',
`item` varchar(100)  not null  comment '增加项目',
`amount` decimal(11,2)  not null  comment '增加金额',
`sys_user_id` int  not null  comment '记录人id',
`sys_user_name` varchar(255)  not null  comment '记录人名字',
`sys_user_mobile` varchar(20)  not null  comment '记录人手机号',
`remark` varchar(200)    comment '备注',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_pop_up_config`;
/*==============================================================*/
/*Table: `base_pop_up_config`                                         */
/*==============================================================*/
create table `base_pop_up_config`(
`id` int  not null auto_increment comment '主键',
`pop_up_id` int  not null  comment '弹框规则id',
`pop_up_name` varchar(100)  not null  comment '弹框规则名称',
`condition_id` int  not null  comment '触发条件id 如地区id/球场id',
`condition_name` varchar(100)  not null  comment '触发条件名称 如地区名称/球场名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_pop_up`;
/*==============================================================*/
/*Table: `base_pop_up`                                         */
/*==============================================================*/
create table `base_pop_up`(
`id` int  not null auto_increment comment '主键',
`create_time`     ,
`name` varchar(100)  not null  comment '弹框名称',
`platform` int  not null  comment '平台: 1-微信',
`condition_type` int  not null  comment '触发条件: 
1-进入首页即弹框 
2-用户选特定球场 
3-用户选特定地区',
`sort` int  not null  comment '顺序(1-10)',
`content_type` int  not null  comment '弹框内容类型: 
1-文字 
2-图片',
`content` varchar(200)  not null  comment '文字内容/图片路径',
`status` int  not null  comment '状态 1-启用 2-禁用',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_image`;
/*==============================================================*/
/*Table: `user_image`                                         */
/*==============================================================*/
create table `user_image`(
`id` int  not null auto_increment comment '主键',
`user_id` int  not null  comment '用户id',
`image_url` varchar(100)  not null  comment '图片路径',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `vip_create_info`;
/*==============================================================*/
/*Table: `vip_create_info`                                         */
/*==============================================================*/
create table `vip_create_info`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`vip_create_id` int  not null  comment '会员生成记录ID',
`vip_no` varchar(20)  not null  comment '会员卡号',
`vip_random` varchar(10)  not null  comment '验证码',
`vip_order_number` varchar(40)  not null  comment '订单号，生成与购买记录生成一致',
`sell_status` int  not null  comment '1-未售  2-已售',
`pay_amount` decimal(11,2)    comment '销售支付金额',
`pay_method` int default 0.0   comment '支付方式 1-微信 3-支付宝 4-汇款 5-现金',
`activate_status` int  not null  comment '1-未激活 2-已激活',
`activate_date` datetime    comment '激活日期',
`activate_method` int  not null  comment '1-微信 2-APP 3-官网 4-客服人工',
`remark` varchar(255)    comment '备注',
`status` int default 1.0 not null  comment '1-启用 2-禁用',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `vip_create`;
/*==============================================================*/
/*Table: `vip_create`                                         */
/*==============================================================*/
create table `vip_create`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`name` varchar(40)  not null  comment '发行名称',
`number` int  not null  comment '发行数量',
`end_time` date  not null  comment '激活截止日期',
`vip_type_id` int  not null  comment '会员卡类型ID',
`vip_type_name` varchar(40) default 1.0 not null  comment '会员类型名称',
`vip_type_amount` decimal(11)  not null  comment '会员卡面额',
`vip_type_valid_day` int  not null  comment '会员卡有效期天数',
`opt_user_id` int  not null  comment '生成操作人ID',
`opt_user_name` varchar(40)  not null  comment '操作人名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `vip_order`;
/*==============================================================*/
/*Table: `vip_order`                                         */
/*==============================================================*/
create table `vip_order`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`number` varchar(40)  not null  comment '订单号',
`vip_no` varchar(20)  not null  comment '会员卡号',
`user_id` int default 0.0 not null  comment '用户ID',
`pay_amount` decimal(11,2)  not null  comment '支付金额',
`pay_method` int default 1.0 not null  comment '支付方式表，1-微信支付 2-boss购买 3-支付宝 4-汇款 5-现金',
`name` varchar(20)  not null  comment '会员卡名称',
`user_name` varchar(20)  not null  comment '用户名',
`mobile` varchar(15)  not null  comment '手机号',
`valid_desc` varchar(20)  not null  comment '有效期描述',
`valid` int  not null  comment '有效期，单位天',
`settlement_status` int default 1.0 not null  comment '1-已收款 2-未收款',
`pay_id` int  not null  comment '支付流水号',
`pay_number` varchar(40)  not null  comment '商户支付流水号',
`pay_bak_no` varchar(40)    comment '第三方支付流水号',
`vip_card_type` int  not null  comment '1-电子卡 2-实体卡',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `vip_payment`;
/*==============================================================*/
/*Table: `vip_payment`                                         */
/*==============================================================*/
create table `vip_payment`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`uuid` char(32)  not null  comment '唯一号，用于微信支付唯一码（微信订单号）',
`order_id` int default 0.0 not null  comment '订单ID',
`user_id` int default 0.0 not null  comment '用户ID',
`pay_amount` decimal(11,2)  not null  comment '支付金额',
`pay_method` int default 1.0 not null  comment '支付方式表，1-微信支付 2-boss购买',
`status` int  not null  comment '支付状态 1-预支付 2-支付成功 3-支付失败 4-异常',
`pay_status` int  not null  comment '第三方支付支付返回状态，1-初始化 2-成功 3-失败',
`name` varchar(20)  not null  comment '会员卡名称',
`user_name` varchar(20)  not null  comment '用户名',
`mobile` varchar(15)  not null  comment '手机号',
`valid_desc` varchar(20)  not null  comment '有效期描述',
`valid` int  not null  comment '有效期，单位天',
`pay_sign` varchar(20)    comment '支付签名值',
`prepay_id` varchar(40)    comment '统一下单订单串',
`pay_bak_no` varchar(40)    comment '第三方支付返回流水号',
`start_time` bigint(15)    comment '微信开时间',
`expire_time` bigint(15)    comment '微信预支付失效时间',
`paypackage` text    comment '预支付串',
`user_img_id` int    comment '用户图片ID',
`user_image_url` varchat(100)  not null  comment '图片路径',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `vip_info`;
/*==============================================================*/
/*Table: `vip_info`                                         */
/*==============================================================*/
create table `vip_info`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间 激活日期',
`update_time` datetime    comment '更新时间',
`name` varchar(20)  not null  comment '会员卡名称',
`user_name` varchar(20)  not null  comment '用户名',
`mobile` varchar(15)  not null  comment '手机号',
`vip_no` varchar(15)  not null  comment '会员卡号',
`valid_time` datetime  not null  comment '有效期',
`update_mobile_count` int default 0.0 not null  comment '更新手机号次数',
`open_id` varchar(40)    comment '微信ID',
`nickname` varchar(40)    comment '微信昵称',
`status` int  not null  comment '1-正常 2-禁用',
`activate_status` int  not null  comment '1-未激活 2-已激活',
`activate_method` int  not null  comment '1-微信 2-APP 3-官网 4-客服人工',
`used_order` bit(1) default false not null  comment '是否VIP下单成功过',
`user_img_id` int    comment '用户图片ID',
`user_image_url` varchat(100)  not null  comment '图片路径',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `vip_type`;
/*==============================================================*/
/*Table: `vip_type`                                         */
/*==============================================================*/
create table `vip_type`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime    comment '更新时间',
`name` varchar(20)  not null  comment '会员卡名称',
`amount` decimal(11,2)  not null  comment '会员卡购买金额',
`order_amount` decimal(11,2)  not null  comment '下单金额',
`valid_desc` varchar(20)  not null  comment '有效期描述',
`valid` int  not null  comment '有效期，单位天',
`status` int  not null  comment '1-正常 2-禁用',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_shopping_cart`;
/*==============================================================*/
/*Table: `order_shopping_cart`                                         */
/*==============================================================*/
create table `order_shopping_cart`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime    comment '更新时间',
`user_id` int  not null  comment '用户id',
`order_source` int  not null  comment '订单来源：
1-微信下单
2-电话下单
3-PC下单
4-APP下单(预留)
5-BOSS下单',
`send_sf_user_time` datetime  not null  comment '要求顺丰人员取件时间',
`freight` decimal(5,2)    comment '运费',
`deliver_date` varchar(20)    comment '从时效查询获取（顺丰接口）',
`send_time_section` char(32)    comment '要求上门取件开始时间和结束时间，以备注信息发送到顺丰,示例:2012-07-30 09:30-12:00',
`insured_value` decimal(5,2)    comment '保价金额',
`insured_rates` decimal(5,2)    comment '保价费率',
`insured_fee` decimal(5,2)    comment '保价费',
`remark` varchar(255)  not null  comment '客户寄件备注',
`j_addr_type` int    comment '寄件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址',
`j_addr_id` int  not null  comment '寄件非个人地址ID，个人地址为0',
`j_addr_name` varchar(100)  not null  comment '寄件地址名称，如果个人地址为空',
`j_contact` varchar(20)  not null  comment '寄件人',
`j_mobile` varchar(11)  not null  comment '寄件人手机号',
`j_area_id` int  not null  comment '地区ID',
`j_tree_path` varchar(200)  not null  comment '地区中文路径',
`j_address` varchar(200)  not null  comment '寄件人地址，不需要省市县',
`d_addr_type` int    comment '收件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址',
`d_addr_id` int  not null  comment '收件非个人地址ID，个人地址为0',
`d_addr_name` varchar(100)  not null  comment '收件地址名称，如果个人地址为空',
`d_contact` varchar(20)  not null  comment '收件人',
`d_mobile` varchar(11)  not null  comment '收件人手机号',
`d_area_id` int  not null  comment '地区ID',
`d_tree_path` varchar(200)  not null  comment '地区中文路径',
`d_address` varchar(200)  not null  comment '寄件人地址，不需要省市县',
`quantity` int default 1.0 not null  comment '数量',
`express_type` varchar(2)  not null  comment '顺丰时效类型',
`md5` varchar(40)  not null  comment '检查是否同一个种类型单加密串',
`proxy_user_id` int default 0.0 not null  comment '默认0，销售代下单未销售人员ID',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `orders`;
/*==============================================================*/
/*Table: `orders`                                         */
/*==============================================================*/
create table `orders`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`user_id` int  not null  comment '用户id',
`number` varchar(40)  not null  comment '序号（界面显示订单号）',
`sub_number` varchar(40)  not null  comment '第一个子订单订单号',
`pay_time` datetime    comment '支付成功时间',
`pay_method` int default 0.0 not null  comment '0-未支付 1-微信支付 98-合作社下单免支付 99-优惠券支付',
`pay_status` int  not null  comment '订单状态：
1-待支付
2-已支付',
`order_status` int  not null  comment '订单状态：
1-正常
2-订单关闭(子订单全部关闭)',
`quantity` int default 1.0 not null  comment '球包数量',
`is_helped` bit(1) default false not null  comment '是否代下单',
`is_delete` bit(1)  not null  comment '是否删除',
`delete_time` datetime    comment '删除时间',
`open_id` varchar(40)  not null  comment '用户微信ID',
`assistant_name` varchar(20)    comment '合作助理姓名',
`third_type` int default 1.0 not null  comment '1-普通用户  2-合作旅行社',
`third_id` int default 0.0 not null  ,
`third_name` varchar(100)    comment '合作方名称',
`order_source` int  not null  comment '订单来源：
1-微信下单
2-电话下单
3-PC下单
4-APP下单(预留)
5-BOSS下单',
`j_addr_name` varchar(100)  not null  comment '寄件地址名称',
`j_contact` varchar(20)  not null  comment '寄件人',
`j_mobile` varchar(11)  not null  comment '寄件人手机号',
`j_tree_path` varchar(200)  not null  comment '地区中文路径',
`d_addr_name` varchar(100)  not null  comment '收件地址名称',
`d_contact` varchar(20)  not null  comment '收件人',
`d_mobile` varchar(11)  not null  comment '收件人手机号',
`d_tree_path` varchar(200)  not null  comment '地区中文路径',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_settmt_amount_config`;
/*==============================================================*/
/*Table: `base_settmt_amount_config`                                         */
/*==============================================================*/
create table `base_settmt_amount_config`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime    comment '创建时间',
`partnerl_id` int  not null  comment '旅行社ID',
`max_amount` decimal(11,2)  not null  comment '限额',
`rate` decimal(5,3)  not null  comment '百分百值',
`status` int  not null  comment '1-正常 2-无效',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_settlement`;
/*==============================================================*/
/*Table: `order_settlement`                                         */
/*==============================================================*/
create table `order_settlement`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`order_id` int  not null  comment '订单ID',
`order_total_amount` decimal(11,2)  not null  comment '订单总金额',
`order_dicount` decimal(11,2)  not null  comment '订单优惠金额',
`order_amount` decimal(11,2)  not null  comment '订单支付金额',
`settle_amount` decimal(11,2)  not null  comment '结算金额',
`settle_fee` int  not null  comment '分润金额',
`settle_model` int  not null  comment '1-总金额比例模式，2-按单比例，3-按单固定返利',
`settle_mode_value` decimal(5,3) default 0.0 not null  comment 'settle_mode为1模式时为0',
`settle_state` int  not null  comment '1-未结算  2-已结算 3-无效结算记录',
`user_name` varchar(100)  not null  comment '用户微信昵称',
`thrid_id` int  not null  comment '合作方ID',
`thrid_name` varchar(100)  not null  comment '合作方名称',
`settle_time` datetime    comment '结算时间',
`sys_user_id` int    comment '结算人员ID',
`sys_user_name` varchar(100)    comment '结算人名称',
`remark` varchar(100)    comment '备注',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_partner_language`;
/*==============================================================*/
/*Table: `base_partner_language`                                         */
/*==============================================================*/
create table `base_partner_language`(
`id` int  not null auto_increment comment '主键',
`partnerl_id` int  not null  comment '旅行社ID',
`language_id` int  not null  comment '语言ID',
`name` varchar(20)  not null  comment '名称',
`ename` varchar(20)  not null  comment '英文',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_partner`;
/*==============================================================*/
/*Table: `base_partner`                                         */
/*==============================================================*/
create table `base_partner`(
`create_time` datetime  not null  comment '创建时间',
`partner_type` int  not null  comment '1-旅行社',
`name` varchar(100)    comment '名称',
`area_id` int  not null  comment '地区ID',
`tree_path` varchar(200)  not null  comment '地区中文路径',
`address` varchar(100)  not null  comment '地址',
`memo` text    comment '简介',
`contact` varchar(20)  not null  comment '联系人',
`mobile` varchar(20)  not null  comment '联系人手机',
`logo` varchar(200)  not null  comment 'logo',
`website` varchar(100)  not null  comment '网址',
`lon` double    comment '经度',
`lat` double    comment '纬度',
`share_order` bit(1) default true not null  comment '是否共享订单',
`settle_type` int  not null  comment '结算模式：1-按月',
`settle_mode` int  not null  comment '1-总金额比例模式，2-按单比例，3-按单固定返利',
`settle_mode_value` decimal(5,3) default 0.0 not null  comment 'settle_mode为1模式时为0',
`status` int  not null  comment '1-正常 2-无效'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_language`;
/*==============================================================*/
/*Table: `base_language`                                         */
/*==============================================================*/
create table `base_language`(
`id` int  not null auto_increment comment '主键',
`name` varchar(20)  not null  comment '名称',
`ename` varchar(20)  not null  comment '英文',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `sup_language_mobile`;
/*==============================================================*/
/*Table: `sup_language_mobile`                                         */
/*==============================================================*/
create table `sup_language_mobile`(
`id` int  not null auto_increment comment '主键',
`mobile` varchar(20)  not null  comment '手机号',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_change_book`;
/*==============================================================*/
/*Table: `order_change_book`                                         */
/*==============================================================*/
create table `order_change_book`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`order_id` int  not null  comment '订单ID',
`new_order_numer` varchar(40)  not null  comment '新订单编号',
`old_order_numer` varchar(40)  not null  comment '旧订单编号',
`new_mail_no` varchar(20)  not null  comment '新运单号',
`old_mail_no` varchar(20)  not null  comment '旧运单号',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `activity_rule`;
/*==============================================================*/
/*Table: `activity_rule`                                         */
/*==============================================================*/
create table `activity_rule`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime    comment '创建时间',
`upate_time` datetime    comment '修改时间',
`name` varchar(50)  not null  comment '规则名称',
`memo` varchar(255)  not null  comment '规则描述',
`amount` decimal(11,2)  not null  comment '规则总金额',
`status` int  not null  comment '1-正常 2-无效',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `activity_rule_config`;
/*==============================================================*/
/*Table: `activity_rule_config`                                         */
/*==============================================================*/
create table `activity_rule_config`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`upate_time` datetime    comment '修改时间',
`rule_id` int  not null  comment '规则ID',
`amount` decimal(11,2)  not null  comment '规则总金额',
`number` int  not null  comment '数量',
`limit_amount` decimal(11,2)  not null  comment '限制使用金额',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_comment`;
/*==============================================================*/
/*Table: `order_comment`                                         */
/*==============================================================*/
create table `order_comment`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime    comment '创建时间',
`order_id` int  not null  comment '订单ID',
`order_number` varchar(40)  not null  comment '订单编号',
`j_tree_path` varchar(200)  not null  comment '寄件地区中文路径',
`d_tree_path` varchar(200)  not null  comment '收件地区中文路径',
`user_id` int  not null  comment '用户ID',
`user_name` varchar(100)  not null  comment '用户微信昵称',
`head_img_url` varchar(200)    comment '微信头像URL',
`kf_level` int  not null  comment '客服评星',
`sf_pack_level` int  not null  comment '顺丰包装评星',
`sf_deliver_level` int  not null  comment '顺丰送货速度评星',
`sf_service_level` int  not null  comment '顺丰配送服务评星',
`total_level` decimal(5,2)  not null  comment '总评星',
`content` text  not null  comment '平均内容',
`url1` varchar(100)    comment '图片1',
`url2` varchar(100)    comment '图片2',
`url3` varchar(100)    comment '图片3',
`status` int  not null  comment '1-待审核 2-审核通过',
`is_top` bit(1)  not null  comment '是否置顶',
`sys_user_id` int    comment '审核人员ID',
`sys_user_name` varchar(255)    comment '审核人员名称',
`memo` text    comment '客服回复',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_coupon`;
/*==============================================================*/
/*Table: `order_coupon`                                         */
/*==============================================================*/
create table `order_coupon`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime    comment '创建时间',
`order_id` int  not null  comment '定单ID',
`activity_id` int  not null  comment '活动ID',
`activity_name` varchar(100)  not null  comment '活动名称',
`coupon_id` int  not null  comment '优惠券ID',
`user_id` int  not null  comment '用户ID',
`user_name` varchar(40)  not null  comment '用户昵称',
`code` varchar(20)  not null  comment '优惠券编码',
`type` int  not null  comment '优惠券类型：1:代金券;2:折扣券;3:特价券;',
`amount` decimal(11,2)  not null  comment '订单消费金额',
`balance` decimal(11,2)  not null  comment '余额',
`status` int  not null  comment '1-正常 2-订单取消退回',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_kf_time_range`;
/*==============================================================*/
/*Table: `user_kf_time_range`                                         */
/*==============================================================*/
create table `user_kf_time_range`(
`id` int  not null auto_increment comment '主键',
`week_day` int    comment '日期',
`begin` int    comment '开始',
`end` int    comment '结束',
`service_id` int    comment '服务ID',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_sf_kf`;
/*==============================================================*/
/*Table: `user_sf_kf`                                         */
/*==============================================================*/
create table `user_sf_kf`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(20)  not null  comment '名字',
`mobile` varchar(11)  not null  comment '手机',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_exception_book`;
/*==============================================================*/
/*Table: `order_exception_book`                                         */
/*==============================================================*/
create table `order_exception_book`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime    comment '创建时间',
`update_time` datetime    comment '更新时间',
`order_id` int    comment '订单Id',
`order_number` varchar(40)    comment '订单号',
`type` int    comment '任务类型：1:需对订单状态检查;2:订单状态在一定时间内没有变化;3:下单失败的;4:派送失败;5:球场端收件异常;6:快件已退回/转寄;7:快件已退回',
`order_status` int    comment '订单最后的状态',
`description` text    comment '描述',
`is_dealed` bit(1)    comment '是否被客服处理了',
`sys_user_id` int    comment '处理人ID',
`user_name` varchar(40)    comment '处理人名称',
`remark` text    comment '处理备注',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_sf_site`;
/*==============================================================*/
/*Table: `base_sf_site`                                         */
/*==============================================================*/
create table `base_sf_site`(
`id` int  not null auto_increment comment '主键',
`name` varchar(100)    comment '名称',
`area_id` int  not null  comment '地区ID',
`tree_path` varchar(200)  not null  comment '地区中文路径',
`address` varchar(100)    comment '地址',
`contact` varchar(20)    comment '联系人',
`mobile` varchar(20)    comment '联系人手机',
`create_time` datetime    comment '创建时间',
`lon` varchar(20)    comment '经度',
`lat` varchar(20)    comment '纬度',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_sf_price`;
/*==============================================================*/
/*Table: `base_sf_price`                                         */
/*==============================================================*/
create table `base_sf_price`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`start_province` varchar(32)  not null  comment '寄件省',
`start_city` varchar(32)  not null  comment '寄件市',
`start_district` varchar(32)  not null  comment '寄件区县',
`end_province` varchar(32)  not null  comment '收件省',
`end_city` varchar(32)  not null  comment '收件市',
`end_district` varchar(32)  not null  comment '收件区县',
`cichen_sf_price` decimal(5,2)  not null  comment '次晨顺丰价格',
`cichen_qbt_price` decimal(5,2)  not null  comment '次晨球包通价格',
`cichen_first_price` decimal(5,2)  not null  comment '顺丰次晨首重',
`cichen_second_price` decimal(5,2)  not null  comment '顺风次晨续重',
`ciri_sf_price` decimal(5,2)  not null  comment '次日顺丰价格',
`ciri_qbt_price` decimal(5,2)  not null  comment '次日球包通价格',
`ciri_first_price` decimal(5,2)  not null  comment '顺丰次日首重',
`ciri_second_price` decimal(5,2)  not null  comment '顺丰次日续重',
`jiri_sf_price` decimal(5,2)  not null  comment '即日顺丰价格',
`jiri_qbt_price` decimal(5,2)  not null  comment '即日球包通价格',
`jiri_first_price` decimal(5,2)  not null  comment '顺丰即日首重',
`jiri_second_price` decimal(5,2)  not null  comment '顺丰即日续重',
`geri_sf_price` decimal(5,2)  not null  comment '隔日顺风价格',
`geri_qbt_price` decimal(5,2)  not null  comment '隔日球包通价格',
`geri_first_price` decimal(5,2)  not null  comment '顺丰隔日首重',
`geri_second_price` decimal(5,2)  not null  comment '疏风隔日续重',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_waybill`;
/*==============================================================*/
/*Table: `order_waybill`                                         */
/*==============================================================*/
create table `order_waybill`(
`id` int  not null auto_increment comment '主键',
`order_id` int  not null  comment '订单ID',
`mail_no` varchar(20)  not null  comment '运单号码，从路由推送而来',
`sf_id` varchar(255)  not null  comment 'sf订单号码，从路由推送而来',
`accept_time` datetime  not null  comment '路由节点产生的时间,格式:YYYY- MM-DD HH24:MM:SS,示例:2012-7- 30 09:30:00',
`accept_address` varchar(40)    comment '路由节点发生的城市',
`remark` varchar(255)    comment '路由节点具体描述',
`op_code` varchar(20)    comment '路由节点操作码',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_brand`;
/*==============================================================*/
/*Table: `base_brand`                                         */
/*==============================================================*/
create table `base_brand`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`contact_id` int  not null  comment '寄件人id',
`bag_no` varchar(10)  not null  comment '球包牌号码',
`rfid_no` varchar(10)  not null  comment 'rfid编码',
`state` int  not null  comment '状态 1-有效 2-无效',
`remark` varchar(100)  not null  comment '备注',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_route_task`;
/*==============================================================*/
/*Table: `order_route_task`                                         */
/*==============================================================*/
create table `order_route_task`(
`id` int  not null auto_increment comment '主键',
`order_id` int  not null  comment '订单ID',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`is_finish` bit(1) default false not null  comment '是否完成',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_refund`;
/*==============================================================*/
/*Table: `order_refund`                                         */
/*==============================================================*/
create table `order_refund`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`uuid` varchar(32)  not null  comment '唯一号',
`order_id` int  not null  comment '订单ID',
`amount` decimal(11,2)  not null  comment '退款金额',
`status` int  not null  comment '状态：1-待处理 2-已处理',
`user_id` int  not null  comment '退款用户',
`user_name` varchar(20)  not null  comment '用户名',
`mobile` varchar(11)  not null  comment '手机号',
`kf_name` varchar(20)  not null  comment '客服姓名',
`kf_mobile` varchar(11)  not null  comment '客服手机号',
`is_notice` bit(1)  not null  comment '是否通知用户',
`order_pay_type` int default 1.0 not null  comment '1-微信支付  2-合作方免支付',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_pay_info`;
/*==============================================================*/
/*Table: `order_pay_info`                                         */
/*==============================================================*/
create table `order_pay_info`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`uuid` char(32)  not null  comment '唯一号，用于微信支付唯一码（微信订单号）',
`order_id` int  not null  comment '订单ID',
`user_id` int  not null  comment '用户ID',
`coupon_code` varchar(20)    comment '券号',
`pay_amount` decimal(11,2)  not null  comment '支付金额',
`pay_method` int default 1.0 not null  comment '支付方式表，1-微信支付',
`status` int  not null  comment '支付状态 1-预支付 2-支付成功 3-支付失败 4-异常',
`pay_status` int  not null  comment '第三方支付支付返回状态，1-初始化 2-成功 3-失败',
`nonce_str` varchar(20)    comment '支付随机串',
`pay_sign` varchar(20)    comment '支付签名值',
`prepay_id` varchar(40)    comment '统一下单订单串',
`pay_bak_no` varchar(40)  not null  comment '第三方支付返回流水号',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_info`;
/*==============================================================*/
/*Table: `order_info`                                         */
/*==============================================================*/
create table `order_info`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime    comment '更新时间',
`user_id` int  not null  comment '用户id',
`order_id` int default 0.0 not null  comment '大订单ID',
`order_number` varchar(40) default "" not null  comment '大订单序列号',
`number` varchar(40)  not null  comment '序号（界面显示订单号）',
`amount` decimal(5,2)  not null  comment '实际支付金额',
`total_amount` double  not null  comment '原有订单总金额',
`mail_no` varchar(20)    comment '顺丰运单号',
`pay_time` datetime    comment '支付成功时间',
`pay_id` int    comment '支付成功支付ID',
`order_status` int  not null  comment '订单状态：
1-待支付
2-支付中
3-支付成功
4-支付失败(可重新)
5-订单关闭-用户取消
6-订单关闭-系统关单
7-订单关闭-客服取消',
`refund_status` int  not null  comment '退款状态：
1-正常状态
2-待退款
3-退款中
4-退款完成
5-退款失败',
`delivery_status` int  not null  comment '物流状态：
1-尚未下单至顺丰
2-待上门收件
3-顺丰已取件
4-顺丰已取件(客服确认)
5-物流运输中
6-派送中
7-已签收',
`bps_status` int  not null  comment '顺丰BPS状态
1-未发送
2-发送成功
3-发送失败',
`question_status` int  not null  comment '问题签收：
1-正常签收
2-异常签收
注：问题签收备注、是否解决',
`handle_type` int default 1.0 not null  comment '1-正常下单 2-BPS重新下单 3-纸质下单',
`order_source` int  not null  comment '订单来源：
1-微信下单
2-电话下单
3-PC下单
4-APP下单(预留)
5-BOSS下单',
`send_sf_user_time` datetime  not null  comment '要求顺丰人员取件时间',
`coupon_id` int    comment '优惠劵id',
`coupon_code` varchar(20)    comment '折扣券code 交易过程临时使用',
`discount` decimal(5,2)    comment '折扣金额',
`favorable` decimal(5,2)    comment '优惠金额',
`favorable_desc` varchar(100)    comment '优惠描述',
`freight` decimal(5,2)    comment '运费',
`insured_value` decimal(5,2)    comment '保价金额',
`insured_rates` decimal(5,2)    comment '保价费率',
`insured_fee` decimal(5,2)    comment '保价费',
`extra_amount` decimal(5,2)    comment '附加费, 仅可以用代金券支付',
`extra_desc` varchar(100)    comment '附加费具体项描述',
`express_type` char(10)    comment '快递失效表
1-次日达
2-隔日达
5-次午达',
`is_handle_question` bit(1) default true not null  comment 'question_status为2时使用，默认true。',
`handle_remar` varchar(255)    comment '解决备注',
`sign_remark` varchar(255)    comment '签收备注',
`sent_remark` varchar(255)    comment '球场人员发包备注',
`remark` varchar(255)  not null  comment '客户寄件备注',
`deliver_date` varchar(20)    comment '预计到达日期 2006-01-02 从时效查询获取（顺丰接口）',
`deliver_time` varchar(8)    comment '预计到达时间 15:04 从时效查询获取（顺丰接口）',
`send_time_section` char(32)    comment '要求上门取件开始时间和结束时间，以备注信息发送到顺丰,示例:2012-07-30 09:30-12:00',
`j_addr_type` int    comment '寄件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址',
`j_addr_id` int  not null  comment '寄件非个人地址ID，个人地址为0',
`j_addr_name` varchar(100)  not null  comment '寄件地址名称，如果个人地址为空',
`j_contact` varchar(20)  not null  comment '寄件人',
`j_mobile` varchar(11)  not null  comment '寄件人手机号',
`j_area_id` int  not null  comment '地区ID',
`j_tree_path` varchar(200)  not null  comment '地区中文路径',
`j_address` varchar(200)  not null  comment '寄件人地址，不需要省市县',
`j_out_range_type` int(2)  not null  comment '偏远类型 0-非偏远 1-球场 4-地区',
`j_out_range_time` decimal(8,2)  not null  comment '偏远寄件时效(天数)',
`j_out_range_price` decimal(8,2)  not null  comment '偏远寄件价格',
`d_addr_type` int    comment '收件地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址',
`d_addr_id` int  not null  comment '收件非个人地址ID，个人地址为0',
`d_addr_name` varchar(100)  not null  comment '收件地址名称，如果个人地址为空',
`d_contact` varchar(20)  not null  comment '收件人',
`d_mobile` varchar(11)  not null  comment '收件人手机号',
`d_area_id` int  not null  comment '地区ID',
`d_tree_path` varchar(200)  not null  comment '地区中文路径',
`d_address` varchar(200)  not null  comment '寄件人地址，不需要省市县',
`d_out_range_type` int(2)  not null  comment '偏远类型 0-非偏远 1-球场 4-地区',
`d_out_range_time` decimal(8,2)  not null  comment '偏远收件时效(天数)',
`d_out_range_price` decimal(8,2)  not null  comment '偏远收件价格',
`is_helped` bit(1) default false not null  comment '是否代下单',
`is_delete` bit(1)  not null  comment '是否删除',
`delete_time` datetime    comment '删除时间',
`open_id` varchar(40)  not null  comment '用户微信ID',
`first_order` bit(1)  not null  comment '是否首单',
`assistant_name` varchar(20)    comment '合作助理姓名',
`third_type` int default 1.0 not null  comment '1-普通用户  2-合作旅行社',
`third_id` int default 0.0 not null  ,
`third_name` varchar(100)    comment '合作方名称',
`lang_ename` varchar(20) default zh-cn not null  comment 'zh-cn 简体中文 ja-jp 日语',
`md5` varchar(40) default "" not null  comment '购物车检查是否同一个种类型单加密串',
`is_vip` bit(1) default false not null  comment '是否会员卡订单',
`vip_id` int  not null  comment 'VIP订单ID',
`kf_receivable_status` int default 0.0 not null  comment '客服收款状态:0-无需收款 1-是 2-否',
`cw_receivable_status` int default 1.0 not null  comment '财务收款状态:1-是 2-否',
`reason` varchar(100)    comment '下单原由',
`input_discount` decimal(11,2) default 0.0   comment '手动优惠',
`proxy_user_id` int default 0.0   comment '下单代理人ID',
`proxy_self_user_id` int default 0.0   comment '下单真正属于用户人ID',
`play_time` varchar(20) default 0.0   comment '打球时间',
`mail_channel` int default 1.0   comment '快递渠道',
`mail_number` varchar(40) default 0.0   comment '快递渠道单号',
`is_org` bit(1) default false not null  comment '是否机构群优惠',
`org_id` int default 0.0 not null  comment '机构群id',
`org_name` varchar(100)    comment '机构群名称',
`is_bag_code` bit(1) default false not null  comment '是否使用包包码',
`bag_code` varchar(20)    comment '包包码',
`bag_code_partner_id` int default 0.0 not null  comment '包包码合作方id',
`bag_code_partner_name` varchar(50)    comment '包包码合作方名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_operate_log`;
/*==============================================================*/
/*Table: `order_operate_log`                                         */
/*==============================================================*/
create table `order_operate_log`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime    comment '创建时间',
`operator_type` int    comment '操作者类型：1:客户;2:客服;3:球场工作人员;4:顺丰系统;5:球包通系统;6:微信',
`operator_name` varchar(20)    comment ' 姓名',
`order_id` int    comment '订单ID',
`description` text    comment '操作结果',
`operator_id` int    comment '操作者ID，如果是客服，对应Account.Id，如果是客户，对应 User.Id，如果是球场工作人员，对应UserCourse.Id，其余为0',
`action` varchar(200)    comment '客服操作类型',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_memo`;
/*==============================================================*/
/*Table: `order_memo`                                         */
/*==============================================================*/
create table `order_memo`(
`id` int4  not null auto_increment comment '主键',
`create_time` datetime    comment '创建时间',
`order_id` int8    comment '订单Id',
`account_id` int8    comment '账户ID',
`account_name` varchar(40)    comment '账户名称',
`memo` varchar(255)    comment '便签',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_insured_template`;
/*==============================================================*/
/*Table: `base_insured_template`                                         */
/*==============================================================*/
create table `base_insured_template`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`name` varchar(100)  not null  comment '名称',
`insured_rates` decimal(2,2)  not null  comment '保价费率',
`free_insured` decimal(11,2)  not null  comment '免费保价金额',
`insured_minimum` decimal(11,2)  not null  comment '最小保价金额',
`insured_maximum` decimal(11,2)  not null  comment '最大保价金额',
`desc_insured_minimum` varchar(100)    comment '最小保价金额描述',
`desc_insured_maximum` varchar(100)    comment '最大保价金额描述',
`state` int  not null  comment '状态
1-有效
2-无效',
`remark` varchar(100)    comment '备注',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `feedback`;
/*==============================================================*/
/*Table: `feedback`                                         */
/*==============================================================*/
create table `feedback`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`mobile` varchar(11)  not null  comment '电话',
`content` text  not null  comment '联系人',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_express_type`;
/*==============================================================*/
/*Table: `order_express_type`                                         */
/*==============================================================*/
create table `order_express_type`(
`id` int  not null auto_increment comment '主键',
`type` int  not null  comment '快递失效表
1-次日达
2-隔日达
5-次午达',
`name` varchar(10)  not null  comment '类型名称',
`order_value` int  not null  comment '排序',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `order_delay_task`;
/*==============================================================*/
/*Table: `order_delay_task`                                         */
/*==============================================================*/
create table `order_delay_task`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`order_id` int  not null  comment '订单ID',
`delay_time` datetime  not null  comment '预计下发日期',
`status` int  not null  comment '状态 1-待发送  2-发送成功 3-处理失败',
`reason` varchar(100)    comment '原因',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_kf`;
/*==============================================================*/
/*Table: `user_kf`                                         */
/*==============================================================*/
create table `user_kf`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(20)  not null  comment '名字',
`user_id` int  not null  comment '用户ID',
`mobile` varchar(11)    comment '联系方式',
`level` int default 5.0 not null  comment '等级,数字越大等级越高   9最高    1最低',
`type` int default 0.0 not null  comment '客服分类：0-普通客服，1-财务，2-技术管理员',
`desc` varchar(32)    comment '描述',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_assistant_message`;
/*==============================================================*/
/*Table: `user_assistant_message`                                         */
/*==============================================================*/
create table `user_assistant_message`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '消息创建时间，自动生成',
`user_id` int  not null  comment '球场用户Id',
`order_id` int  not null  comment '订单Id',
`title` varchar(100)  not null  comment '消息标题',
`content` text    comment '消息内容',
`type` int  not null  comment '消息类型
1 -待清点通知
2 -移送出发台通知
4 -有球包牌球包启运清点
5-无球包牌球包启运清点通知
6-取消订场通知
',
`status` int  not null  comment '0=未读 1=已读',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `coupon`;
/*==============================================================*/
/*Table: `coupon`                                         */
/*==============================================================*/
create table `coupon`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime    comment '创建时间',
`activity_id` int    comment '优惠券ID',
`code` varchar(20)    comment '优惠券编码',
`type` int    comment '优惠券类型：1:代金券;2:折扣券;3:特价券;',
`amount` decimal(11,2)    comment '代金金额',
`chlid_code` varchar(20)    comment '优惠券子码',
`child_amount` decimal(11,2)    comment '代金子金额',
`description` varchar(255)    comment '描述',
`status` int  not null  comment '1-未使用 2-已使用',
`claim_type` int default 0.0 not null  comment '0-未领取 1-用户领取 2-后台分发',
`user_id` int    comment '用户ID',
`user_name` varchar(40)    comment '用户名称',
`claim_time` datetime    comment '领取时间',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_contact`;
/*==============================================================*/
/*Table: `user_contact`                                         */
/*==============================================================*/
create table `user_contact`(
`id` int4  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`name` varchar(100)  not null  comment '名字',
`mobile` varchar(20)  not null  comment '手机',
`is_delete` bit(1)  not null  comment '是否删除',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_bank_branch`;
/*==============================================================*/
/*Table: `base_bank_branch`                                         */
/*==============================================================*/
create table `base_bank_branch`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime    comment '创建时间',
`name` varchar(100)    comment '名称',
`area_id` int  not null  comment '地区ID',
`tree_path` varchar(200)  not null  comment '地区中文路径',
`address` varchar(100)    comment '地址',
`contact` varchar(20)    comment '联系人',
`mobile` varchar(20)    comment '联系人手机',
`lon` varchar(20)    comment '经度',
`lat` varchar(20)    comment '纬度',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_bank`;
/*==============================================================*/
/*Table: `base_bank`                                         */
/*==============================================================*/
create table `base_bank`(
`id` int  not null auto_increment comment '主键',
`name` varchar(20)  not null  comment '银行名称',
`number` varchar(10)  not null  comment '序号',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_weixin`;
/*==============================================================*/
/*Table: `user_weixin`                                         */
/*==============================================================*/
create table `user_weixin`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime    comment '创建时间',
`name` varchar(20)    comment '姓名',
`email` varchar(64)    comment '邮箱',
`mobile` varchar(20)    comment '手机',
`password` varchar(40)    comment '密码',
`sex` int    comment '性别：1-男性，2-女性，0-未知',
`salt` varchar(64)    comment '加密用的key',
`accept_push` bit(1) default true not null  comment '接受消息推送',
`accept_promotion` bit(1) default true not null  comment '接受促销信息',
`is_validated` bit(1) default true not null  comment '是否可用，如果为 false，该用户将不可用',
`openid` varchar(32)    comment '微信用户身份标识',
`nickname` varchar(60)    comment '微信昵称',
`head_img_url` varchar(200)    comment '微信头像URL',
`lastlon` varchar(20)    comment '最后经度',
`lastlat` varchar(20)    comment '最后纬度',
`coordsrc` varchar(20)    comment '坐标系（不同公司的地图区分，各个公司的经纬度不一样）',
`province` varchar(10)    comment '省',
`city` varchar(10)    comment '市',
`county` varchar(20)    comment '区县',
`first_letter` varchar(100)    comment '首字母',
`subscribe_status` int  not null  comment '0-未知 1-已关注 2-取消关注',
`salesman_code` varchar(100)    comment '业务员编号',
`salesman_id` int  not null  comment '业务员用户ID',
`subscribe_time` datetime    comment '关注时间',
`un_subscribe_time` datetime    comment '取消关注时间',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_assistant`;
/*==============================================================*/
/*Table: `user_assistant`                                         */
/*==============================================================*/
create table `user_assistant`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime    comment '创建时间',
`user_id` int  not null  comment '微信用户ID',
`name` varchar(20)    comment '姓名',
`email` varchar(64)    comment '邮箱',
`mobile` varchar(20)    comment '手机',
`password` varchar(40)    comment '密码',
`salt` varchar(64)    comment '加密用的key',
`enjoy_assistant_fee` bit(1)    comment '球包助理是否可以分润，true=可以分润',
`status` int  not null  comment '申请状态
1-审核中
2-审核通过
3-审核被拒绝',
`memo` varchar(255)    comment '拒绝理由',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_assistant_apply`;
/*==============================================================*/
/*Table: `user_assistant_apply`                                         */
/*==============================================================*/
create table `user_assistant_apply`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`assistant_id` int  not null  comment '助理id',
`name` varchar(20)  not null  comment '姓名',
`identity_code` varchar(20)  not null  comment '身份证号',
`photo1_url` varchar(100)  not null  comment '身份证正面',
`photo2_url` varchar(100)  not null  comment '身份证反面',
`apply_type` int  not null  comment '申请类型
1-球场官方工作人员
2-球场私人工作人员
3-银行站点工作人员
4-顺丰站点工作人员
5-顺丰机场工作人员
6-官方球包助理
7-普通球包助理
8-旅行合作社',
`apply_id` int  not null  comment '申请对象(球场/银行/顺丰站点/机场)id',
`apply_name` varchar(100)  not null  comment '申请对象名称',
`remark` varchar(255)    comment '备注',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_assistant_fee`;
/*==============================================================*/
/*Table: `user_assistant_fee`                                         */
/*==============================================================*/
create table `user_assistant_fee`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime    comment '创建时间',
`order_id` int  not null  comment '订单ID',
`fee` decimal(11,2)  not null  comment '需要支付给球包助理的服务费，现固定5元',
`paid` bit(1)  not null  comment '是否已分润',
`type` int    comment '分润类型 
1=签收分润 
2=代寄分润',
`assistant_id` int    comment '助理Id',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_airport`;
/*==============================================================*/
/*Table: `base_airport`                                         */
/*==============================================================*/
create table `base_airport`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(100)    comment '名称',
`area_id` int  not null  comment '地区ID',
`tree_path` varchar(200)  not null  comment '地区中文路径',
`address` varchar(100)    comment '地址',
`contact` varchar(20)    comment '联系人',
`mobile` varchar(20)    comment '联系人手机',
`lon` varchar(20)    comment '经度',
`lat` varchar(20)    comment '纬度',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `activity`;
/*==============================================================*/
/*Table: `activity`                                         */
/*==============================================================*/
create table `activity`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(100)  not null  comment '活动名称',
`start_time` datetime  not null  comment '券码开始时间',
`end_time` datetime  not null  comment '券码结束时间',
`code` varchar(10)  not null  comment '暗码，唯一索引',
`desc` varchar(100)    comment '活动描述',
`max_per_one` int default 1.0 not null  comment '个人领取次数',
`activity_start_time` datetime  not null  comment '活动领券开始时间 ',
`activity_end_time` datetime  not null  comment '活动领券结束时间 ',
`status` int  not null  comment '状态：1-正常，2-禁用',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_version`;
/*==============================================================*/
/*Table: `base_version`                                         */
/*==============================================================*/
create table `base_version`(
`id` int  not null auto_increment comment '主键',
`version` varchar(10)    comment '版本号',
`reversion` varchar(10)    comment '子版本号',
`description` text    comment '版本描述',
`published_on` varchar(10)    comment '发布日期',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_course`;
/*==============================================================*/
/*Table: `base_course`                                         */
/*==============================================================*/
create table `base_course`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime  not null  comment '更新时间',
`name` varchar(100)  not null  comment '名称',
`short_name` varchar(100)  not null  comment '简称',
`english_name` varchar(100)    comment '英文名称',
`initial` varchar(20)    comment '拼音首字母',
`first_letter` varchar(100)    comment '球场首字母',
`logo` varchar(200)    comment 'logo',
`area_id` int  not null  comment '地区ID',
`tree_path` varchar(200)  not null  comment '地区中文路径',
`address` varchar(100)  not null  comment '地址',
`lon` float8    comment '经度',
`lat` float8    comment '纬度',
`status` int  not null  comment '球场状态：1-已签约 2-未签约但可接受球包通球包 3-不接受球包通球包 4-未知状态',
`is_delete` bit(1) default false not null  comment '是否删除',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_course_info`;
/*==============================================================*/
/*Table: `base_course_info`                                         */
/*==============================================================*/
create table `base_course_info`(
`course_id` int  not null  comment '主键',
`golf_hole` int    comment '高尔夫球洞',
`telephone` varchar(120)    comment '电话',
`description` text    comment '描述',
`contact` varchar(20)    comment '联系人',
`mobile` varchar(20)    comment '联系人电话',
`remark` varchar(255)    comment '时效检查结果，时效正常时为空',
`introducing` text    comment '球场介绍',
`website` varchar(100)    comment '网址',
`wechat` varchar(40)    comment '微信号',
`introducing_href` text    comment '介绍网址',
`has_assistant` bool    comment '是否有助理',
`sign_place` varchar(100)    comment '代签地点',
`send_place` varchar(100)    comment '寄送取包地点',
`start_work_time` varchar(5)    comment '上班时间',
`end_work_time` varchar(5)    comment '下班时间',
`product_intro` text    comment '球场产品或服务优惠介绍',
`feature_intro` text    comment '特色介绍',
`food_intro` text    comment '餐饮介绍',
`other_intro` text    comment '其他服务介绍',
`bag_deposit_charge` float4    comment '球包存放收费标准，单位=元，2位小数',
`tee_time_interval` int2    comment 'TEE TIME 间隔时间',
`tee_time_earliest` varchar(5)    comment 'TEE TIME 最早时间',
`tee_time_latest` varchar(5)    comment 'TEE TIME 最晚时间',
`transition_closed_begin_time` varchar(255)    comment '中间转场封闭开始时间',
`transition_closed_end_time` varchar(255)    comment '中间转场封闭结束时间',
`weather` varchar(100)    comment '当日天气'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_area`;
/*==============================================================*/
/*Table: `base_area`                                         */
/*==============================================================*/
create table `base_area`(
`id` int  not null auto_increment comment '主键',
`name` varchar(40)  not null  comment '名称',
`super_id` int  not null  comment '父级ID',
`tree_path` varchar(200)  not null  comment '地区树名称',
`tree_id` varchar(200)  not null  comment '地区ID树',
`lat` varchar(20)    comment '经度',
`lon` varchar(20)    comment '维度',
`level` int  not null  comment '等级',
`sort` int  not null  comment '排序',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `sys_resource`;
/*==============================================================*/
/*Table: `sys_resource`                                         */
/*==============================================================*/
create table `sys_resource`(
`id` int  not null auto_increment comment '主键',
`name` varchar(40)  not null  comment '名称',
`url` varchar(40)  not null  comment '资源菜单',
`ioc` varchar(40)    comment '图标',
`plat_id` int  not null  comment '平台ID',
`super_id` int default 0.0 not null  comment '父级菜单ID',
`type` int  not null  comment '菜单类型：1-菜单 2-按钮',
`status` int  not null  comment '状态：1-正常，2-禁用',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `sys_role_resource`;
/*==============================================================*/
/*Table: `sys_role_resource`                                         */
/*==============================================================*/
create table `sys_role_resource`(
`role_id` int  not null  comment '角色ID',
`resource_id` int  not null  comment '资源ID'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `sys_user`;
/*==============================================================*/
/*Table: `sys_user`                                         */
/*==============================================================*/
create table `sys_user`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`email` varchar(40)    comment '邮箱',
`mobile` varchar(11)  not null  comment '手机',
`password` varchar(40)  not null  comment '密码',
`salt` varchar(64)    comment '加密用的私有盐',
`is_validated` bit(1)    comment '是否激活',
`is_super_user` bit(1)    comment '是否是超级用户',
`status` int  not null  comment '状态：1-正常，2-禁用',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `sys_role`;
/*==============================================================*/
/*Table: `sys_role`                                         */
/*==============================================================*/
create table `sys_role`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(20)  not null  comment '名称',
`plat_id` int  not null  comment '平台类型ID',
`plat_name` varchar(20)  not null  comment '平台名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `sys_plat`;
/*==============================================================*/
/*Table: `sys_plat`                                         */
/*==============================================================*/
create table `sys_plat`(
`id` int  not null auto_increment comment '主键',
`name` varchar(20)  not null  comment '名称',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `sys_user_role`;
/*==============================================================*/
/*Table: `sys_user_role`                                         */
/*==============================================================*/
create table `sys_user_role`(
`user_id` int  not null  comment '用户ID',
`role_id` int  not null  comment '角色ID',
`plat_name` varchar(20)  not null  comment '平台名称',
`plat_id` int  not null  comment '平台ID'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `user_address`;
/*==============================================================*/
/*Table: `user_address`                                         */
/*==============================================================*/
create table `user_address`(
`id` int  not null auto_increment comment '主键',
`user_id` int  not null  comment '用户ID',
`area_id` int  not null  comment '地区ID',
`tree_path` varchar(200)  not null  comment '地区中文路径',
`address` varchar(100)  not null  comment '地址',
`contact` varchar(10)  not null  comment '联系人',
`mobile` varchar(20)  not null  comment '手机',
`is_default` bit(1)  not null  comment '是否默认',
`uuid` varchar(225)  not null  comment '地址唯一值',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `base_adv`;
/*==============================================================*/
/*Table: `base_adv`                                         */
/*==============================================================*/
create table `base_adv`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`name` varchar(255)  not null  comment '图片名称',
`image` varchar(255)  not null  comment '图片内容',
`url` varchar(255)  not null  comment '广告链接',
`type` varchar(255)  not null  comment '类型（微信：wx，pc：pc）',
`position` varchar(255)  not null  comment '位置（首页：home，设置：set，球场：course）',
`number` int(1)  not null  comment '顺序（1,2,3.........）',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists `coupon_code_activity`;
/*==============================================================*/
/*Table: `coupon_code_activity`                                         */
/*==============================================================*/
create table `coupon_code_activity`(
`id` int  not null auto_increment comment '主键',
`create_time` datetime  not null  comment '创建时间',
`update_time` datetime    comment '更新时间',
`name` varchar(20)  not null  comment '优惠码名称',
`start_time` datetime  not null  comment '优惠开始时间',
`end_time` datetime  not null  comment '优惠结束时间',
`code` varchar(20)  not null  comment '优惠码',
`count` int(11)  not null  comment '优惠次数(-1无限)',
`use_count` int(11)  not null  comment '使用次数',
`rule_full` decimal(11,2)  not null  comment '规则满',
`rule_reduce` decimal(11,2)  not null  comment '规则减',
`rule_type` int(2)  not null  comment '规则类型（1-满减）',
`status` int(2)  not null  comment '状态（1-正常 2-无效）',
`remark` varchar(255)  not null  comment '备注',
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

