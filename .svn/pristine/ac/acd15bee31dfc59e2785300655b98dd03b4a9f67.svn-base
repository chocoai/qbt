-- ----------------------------
-- Table structure for ticket_activity_order
-- ----------------------------
DROP TABLE IF EXISTS `ticket_activity_order`;
CREATE TABLE `ticket_activity_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` int(11) NOT NULL,
  `transaction_number` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `activity_id` int(11) NOT NULL,
  `activity_name` varchar(125) DEFAULT NULL,
  `purchaser` varchar(125) DEFAULT NULL,
  `purchaser_phone_number` int(25) DEFAULT NULL,
  `purchaser_address` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `is_paid` int(11) DEFAULT NULL,
  `proxy_user_id` int(11) DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `operator_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
