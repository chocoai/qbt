-- ----------------------------
-- Table structure for ticket_package_rule
-- ----------------------------
DROP TABLE IF EXISTS `ticket_package_rule`;
CREATE TABLE `ticket_package_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rule_name` varchar(25) NOT NULL,
  `price` float NOT NULL,
  `status` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_storage_service` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `operator` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
