-- ----------------------------
-- Table structure for ticket_package_order
-- ----------------------------
DROP TABLE IF EXISTS `ticket_package_order`;
CREATE TABLE `ticket_package_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL,
  `activity_name` varchar(255) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `purchaser` varchar(255) DEFAULT NULL,
  `purchaser_address` varchar(255) DEFAULT NULL,
  `purchaser_number` varchar(255) DEFAULT NULL,
  `pay_status` int(3) DEFAULT NULL,
  `proxy_user` varchar(255) DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL,
  `operator_name` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
