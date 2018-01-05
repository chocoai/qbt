-- ----------------------------
-- Table structure for ticket_activity_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `ticket_activity_order_detail`;
CREATE TABLE `ticket_activity_order_detail` (
  `id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `activate_user` varchar(25) DEFAULT NULL,
  `activate_phone_number` int(11) DEFAULT NULL,
  `activate_time` datetime DEFAULT NULL,
  `active_status` int(11) DEFAULT NULL,
  `code` varchar(25) DEFAULT NULL,
  `code_status` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `package_type` int(11) DEFAULT NULL,
  `qr_code` int(11) DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `expiration_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
