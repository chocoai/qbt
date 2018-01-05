-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `package_id` int(11) NOT NULL COMMENT '券包id',
  `ticket_price` int(11) DEFAULT NULL COMMENT '票价',
  `ticket_name` varchar(255) DEFAULT NULL COMMENT '票名',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `used_quantity` int(11) DEFAULT NULL COMMENT '已用数量',
  `use_limit` int(11) DEFAULT NULL COMMENT '使用限制',
  `use_status` int(2) DEFAULT NULL COMMENT '0:没有使用，1:已经使用',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
