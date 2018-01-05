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
