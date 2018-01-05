-- ----------------------------
-- Table structure for ticket_package
-- ----------------------------
DROP TABLE IF EXISTS `ticket_package`;
CREATE TABLE `ticket_package` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `activity_name` varchar(255) DEFAULT NULL COMMENT '活动名字',
  `type` int(2) DEFAULT NULL,
  `expiration_time` datetime DEFAULT NULL COMMENT '过期日期',
  `effective_day` int(11) DEFAULT NULL COMMENT '有效天数',
  `activate_time` datetime DEFAULT NULL COMMENT '激活日期',
  `activate_user` varchar(255) DEFAULT NULL COMMENT '激活用户',
  `activate_phone_number` varchar(255) DEFAULT NULL COMMENT '激活人的电话',
  `code` varchar(255) DEFAULT NULL COMMENT '激活码',
  `code_status` int(2) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `active_status` int(2) DEFAULT NULL,
  `ticket_type` int(2) DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL COMMENT '操作者id',
  `operator_name` varchar(255) DEFAULT NULL COMMENT '操作者名字',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
