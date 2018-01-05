DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `province_id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `course_amount` int(11) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`province_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


