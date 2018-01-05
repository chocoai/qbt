alter table order_info add column urgent_fee int COMMENT '加急费';


-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `city_id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `course_amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for reminder
-- ----------------------------
DROP TABLE IF EXISTS `reminder`;
CREATE TABLE `reminder` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `name` varchar(100) NOT NULL COMMENT '提示名称，唯一索引',
  `image` varchar(255) NOT NULL COMMENT '提示的图片',
  `description` text COMMENT '提示的描述',
  `order_number` int(11) DEFAULT '1' COMMENT '提示的排序',
  `status` int(11) NOT NULL COMMENT '状态：1-正常，2-禁用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_unique` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for urgent
-- ----------------------------
DROP TABLE IF EXISTS `urgent`;
CREATE TABLE `urgent` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',  
  `name` varchar(100) NOT NULL COMMENT '名称，唯一索引',
  `price` int(11) NOT NULL COMMENT '价格',
  `description` text COMMENT '描述',
  `operator` int(11) COMMENT '操作人',
  `operator_name` varchar(100) COMMENT '操作人名字',
  `from_province` varchar(100) NOT NULL COMMENT '原寄地省',
  `from_city` varchar(100) NOT NULL COMMENT '原寄地市',
  `to_province` varchar(100) NOT NULL COMMENT '目的地省',
  `to_city` varchar(100) NOT NULL COMMENT '目的地市',
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sf_notify_config`
-- ----------------------------
DROP TABLE IF EXISTS `sf_notify_config`;
CREATE TABLE `sf_notify_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',  
  `order_number` varchar(255) NOT NULL COMMENT '订单id，唯一索引',
  `operator` int(11) COMMENT '操作人',
  `operator_name` varchar(100) COMMENT '操作人名字',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_number_unique` (`order_number`) USING BTREE  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO sys_resource(name,url,ioc,plat_id,super_id,status,type) 
VALUES('加急运费管理','urgentFee.html','fa-rmb',1,23,1,1);
INSERT INTO sys_resource(name,url,ioc,plat_id,super_id,status,type) 
VALUES('球场省份排序','courseSort.html','fa-arrows-v',1,11,1,1);

DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `province_id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `course_amount` int(11) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`province_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

