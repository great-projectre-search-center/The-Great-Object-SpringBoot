/*
Navicat MySQL Data Transfer

Source Server         : win10-jingfeng999
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : thegreatobject

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2020-05-17 18:20:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '收货地址ID',
  `uid` int(11) DEFAULT NULL COMMENT '用户ID',
  `name` varchar(100) DEFAULT NULL COMMENT '收货人姓名',
  `phone` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `province_name` varchar(100) DEFAULT NULL COMMENT '省名',
  `city_name` varchar(100) DEFAULT NULL COMMENT '市名',
  `area_name` varchar(100) DEFAULT NULL COMMENT '区名',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `receiving_time` datetime DEFAULT NULL COMMENT '收货时间',
  `created_user` varchar(255) DEFAULT NULL COMMENT '日志：创建人',
  `created_time` datetime DEFAULT NULL COMMENT '日志：创建时间',
  `modified_user` varchar(255) DEFAULT NULL COMMENT '日志：修改人',
  `modified_time` datetime DEFAULT NULL COMMENT '日志：修改时间',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO `t_address` VALUES ('1', null, 'jingfeng', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_address` VALUES ('11', '555', 'juxing', '110', 'beijieng', 'beijing', 'beijing', 'jingdong', '2020-05-17 06:31:38', 'juxing', '2020-05-17 06:31:38', 'juxing', '2020-05-17 06:31:38');

-- ----------------------------
-- Table structure for `t_appraise`
-- ----------------------------
DROP TABLE IF EXISTS `t_appraise`;
CREATE TABLE `t_appraise` (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价id',
  `oid` int(11) DEFAULT NULL COMMENT '订单id',
  `grade` int(10) unsigned zerofill DEFAULT NULL COMMENT '评价等级:0，1，2，3四个等级(前端可以用五角星来展现等级)',
  `content` varchar(500) DEFAULT NULL COMMENT '评价内容',
  `created_user` varchar(255) DEFAULT NULL COMMENT '日志：创建人',
  `created_time` datetime DEFAULT NULL COMMENT '日志：创建时间',
  `modified_user` varchar(255) DEFAULT NULL COMMENT '日志：修改人',
  `modified_time` datetime DEFAULT NULL COMMENT '日志：修改时间',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=90913 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_appraise
-- ----------------------------
INSERT INTO `t_appraise` VALUES ('90910', '0', null, 'CDC等等', 'jingfeng', '2020-05-17 06:45:00', 'jingfeng', '2020-05-17 06:45:00');
INSERT INTO `t_appraise` VALUES ('90912', '1', null, 'CDC等等', 'jingfeng', '2020-05-17 06:46:54', 'jingfeng', '2020-05-17 06:46:54');

-- ----------------------------
-- Table structure for `t_location`
-- ----------------------------
DROP TABLE IF EXISTS `t_location`;
CREATE TABLE `t_location` (
  `lid` int(11) NOT NULL AUTO_INCREMENT COMMENT '位置id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `longtitude` double NOT NULL COMMENT '位置的经度',
  `latitude` double NOT NULL COMMENT '位置的纬度',
  `created_user` varchar(255) DEFAULT NULL COMMENT '日志：创建人',
  `created_time` datetime DEFAULT NULL COMMENT '日志：创建时间',
  `modified_user` varchar(255) DEFAULT NULL COMMENT '日志：修改人',
  `modified_time` datetime DEFAULT NULL COMMENT '日志：修改时间',
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_location
-- ----------------------------

-- ----------------------------
-- Table structure for `t_notification`
-- ----------------------------
DROP TABLE IF EXISTS `t_notification`;
CREATE TABLE `t_notification` (
  `nid` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '通知id',
  `from_open_id` varchar(255) DEFAULT NULL,
  `from_uid` int(11) DEFAULT NULL COMMENT '通知人id',
  `to_open_id` varchar(255) DEFAULT NULL,
  `to_uid` int(11) DEFAULT NULL COMMENT '被通知人id',
  `title` varchar(100) DEFAULT NULL COMMENT '主题',
  `message` varchar(300) DEFAULT NULL COMMENT '内容信息',
  `created_user` varchar(255) DEFAULT NULL COMMENT '日志：创建人',
  `created_time` datetime DEFAULT NULL COMMENT '日志：创建时间',
  `modified_user` varchar(255) DEFAULT NULL COMMENT '日志：修改人',
  `modified_time` datetime DEFAULT NULL COMMENT '日志：修改时间',
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notification
-- ----------------------------

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `oid` bigint(11) NOT NULL DEFAULT '0' COMMENT '订单id',
  `title` varchar(100) DEFAULT NULL COMMENT '订单名称',
  `catalog` varchar(100) DEFAULT NULL COMMENT '订单类型',
  `creater_id` int(11) DEFAULT NULL COMMENT '放单人ID',
  `creater_name` varchar(100) DEFAULT NULL COMMENT '放单人姓名',
  `creater_tel` varchar(100) DEFAULT NULL COMMENT '放单人联系方式',
  `creater_longitude` double unsigned DEFAULT NULL COMMENT '放单人位置经度',
  `creater_latitude` double DEFAULT NULL COMMENT '放单人位置纬度',
  `shops_longtitude` double DEFAULT NULL COMMENT '商家位置经度',
  `shops_latitude` double DEFAULT NULL COMMENT '商家位置纬度',
  `accepter_id` int(10) unsigned zerofill DEFAULT NULL COMMENT '接单人ID',
  `create_date` datetime DEFAULT NULL COMMENT '订单放单时间',
  `accept_date` datetime DEFAULT NULL COMMENT '订单接受时间',
  `public_field1` varchar(300) DEFAULT NULL COMMENT '公共字段1',
  `public_field2` varchar(300) DEFAULT NULL COMMENT '公共字段2',
  `estimated_worth` int(11) DEFAULT NULL COMMENT '预估价值',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注',
  `aid` int(11) DEFAULT NULL,
  `reward` int(11) DEFAULT NULL,
  `status` int(10) unsigned zerofill DEFAULT NULL COMMENT '订单状态: 0未接单,1已接单,2送货中,3已接收,4已评价,5已取消,6已删除',
  `created_user` varchar(255) DEFAULT NULL COMMENT '日志：创建人',
  `created_time` datetime DEFAULT NULL COMMENT '日志：创建时间',
  `modified_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '日志：修改人',
  `modified_time` datetime DEFAULT NULL COMMENT '日志：修改时间',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('0', 'kuaidi', '快递', '111', 'juxing', '132303015643', '1.1', '1.1', '1.1', '1.1', '0000000999', '2020-05-17 05:15:20', '2020-05-17 05:56:28', '', '', '100', '备注', '1', '123', '0000000004', 'juxing', '2020-05-17 05:15:20', 'juxing', '2020-05-17 06:45:00');
INSERT INTO `t_order` VALUES ('1', null, '测试订单', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '90912', null, '0000000004', null, null, null, '2020-05-17 06:46:54');
INSERT INTO `t_order` VALUES ('2', 'kuaidi', '快递', '111', 'juxing', '132303015643', '1.1', '1.1', '1.1', '1.1', '0000111111', '2020-05-17 05:06:47', '2020-05-17 05:06:47', '', '', '100', '备注', '123', '123', '0000000002', 'juxing', '2020-05-17 05:06:47', 'juxing', '2020-05-17 06:03:35');
INSERT INTO `t_order` VALUES ('3', 'kuaidi', '快递', '111', 'juxing', '132303015643', '1.1', '1.1', '1.1', '1.1', '0000111111', '2020-05-17 05:10:13', '2020-05-17 05:10:13', '', '', '100', '备注', '123', '123', '0000000000', 'juxing', '2020-05-17 05:10:13', 'juxing', '2020-05-17 05:10:13');
INSERT INTO `t_order` VALUES ('15896927030265915', 'kuaidi', '快递', '111', 'juxing', '132303015643', '1.1', '1.1', '1.1', '1.1', '0000111111', '2020-05-17 05:18:23', '2020-05-17 05:18:23', '', '', '100', '备注', '123', '123', '0000000003', 'juxing', '2020-05-17 05:18:23', 'juxing', '2020-05-17 05:23:02');

-- ----------------------------
-- Table structure for `t_wx_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_user`;
CREATE TABLE `t_wx_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `open_id` varchar(100) NOT NULL COMMENT '普通用户的一个唯一的标识',
  `session_key` varchar(255) NOT NULL,
  `nick_name` varchar(50) NOT NULL COMMENT '昵称',
  `encoded_password` varchar(255) NOT NULL COMMENT '加密的密码',
  `gender` varchar(20) DEFAULT NULL COMMENT '性别',
  `country` varchar(100) DEFAULT NULL COMMENT '国家',
  `province` varchar(100) DEFAULT NULL COMMENT '省份',
  `city` varchar(100) DEFAULT NULL COMMENT '城市',
  `avatar_url` varchar(300) DEFAULT NULL COMMENT '头像地址',
  `created_user` varchar(255) DEFAULT NULL COMMENT '日志：创建人',
  `created_time` datetime DEFAULT NULL COMMENT '日志：创建时间',
  `modified_user` varchar(255) DEFAULT NULL COMMENT '日志：修改人',
  `modified_time` datetime DEFAULT NULL COMMENT '日志：修改时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_wx_user
-- ----------------------------
INSERT INTO `t_wx_user` VALUES ('1', '123', '', '123', '', null, null, null, null, null, null, null, null, null);
