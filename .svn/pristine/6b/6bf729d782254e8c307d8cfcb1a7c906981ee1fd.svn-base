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
