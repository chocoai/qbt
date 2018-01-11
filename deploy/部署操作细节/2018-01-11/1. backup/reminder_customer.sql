/*
Navicat MySQL Data Transfer

Source Server         : rm-bp153aw77hb98q95wo.mysql.rds.aliyuncs.com - writeUser
Source Server Version : 50634
Source Host           : rm-bp153aw77hb98q95wo.mysql.rds.aliyuncs.com:3306
Source Database       : qiubaotong

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2018-01-11 11:37:22
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `comments` varchar(255) DEFAULT NULL COMMENT '备注',
  `detail_image` varchar(255) DEFAULT NULL COMMENT '详细图片',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_unique` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reminder
-- ----------------------------
INSERT INTO `reminder` VALUES ('1', '2017-12-14 22:28:59', '准时.', '/images//20180104/04c5ca61ac484958af1183fc40522707.png', null, '1', '1', null, '/images//20171228/f5f5aeeb1f9d468bbf7fb4dcc977aaac.png');
INSERT INTO `reminder` VALUES ('2', '2017-12-14 22:28:59', '可靠.', '/images//20171214/e839e090838b4e3bb07575d907a79a6c.png', null, '1', '1', null, '/images//20171228/b1ffd8fc1b6d47ad81bc6db0522f42e1.png');
INSERT INTO `reminder` VALUES ('3', '2017-12-14 22:28:59', '方便.', '/images//20180104/c9344b7c40704ece95afb25daaa52311.png', null, '1', '1', null, '/images//20171228/0a2b56bc268745ceb3c03e24ea93b84c.png');
