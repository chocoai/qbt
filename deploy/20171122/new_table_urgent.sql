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
