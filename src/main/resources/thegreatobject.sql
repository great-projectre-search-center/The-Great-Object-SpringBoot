/*
Navicat MySQL Data Transfer

Source Server         : win10-jingfeng999
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : thegreatobject

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2020-05-30 01:02:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '收货地址ID',
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `name` varchar(100) NOT NULL COMMENT '收货人姓名',
  `phone` varchar(100) NOT NULL COMMENT '手机号码',
  `province_name` varchar(100) NOT NULL COMMENT '省名',
  `city_name` varchar(100) NOT NULL COMMENT '市名',
  `area_name` varchar(100) NOT NULL COMMENT '区名',
  `address` varchar(255) NOT NULL COMMENT '详细地址',
  `receiving_time` datetime NOT NULL COMMENT '收货时间',
  `created_user` varchar(255) NOT NULL COMMENT '日志：创建人',
  `created_time` datetime NOT NULL COMMENT '日志：创建时间',
  `modified_user` varchar(255) NOT NULL COMMENT '日志：修改人',
  `modified_time` datetime NOT NULL COMMENT '日志：修改时间',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO `t_address` VALUES ('1', '857', '一坨小甜甜', '13131375784', '江苏省', '徐州市', '贾汪区', '隔壁老王家', '2020-05-29 21:05:48', '系统管理员', '2020-05-28 23:06:07', '系统管理员', '0000-00-00 00:00:00');
INSERT INTO `t_address` VALUES ('2', '886', 'wxyg**', '13933336655', '河北省', '张家口市', '宣化区', '第一中学', '2020-05-20 23:12:12', '系统管理员', '2020-05-29 23:12:29', '系统管理员', '0000-00-00 00:00:00');
INSERT INTO `t_address` VALUES ('3', '886', 'wxy*j*', '13933336655', '河北省', '张家口市', '宣化区', '第一中学', '2020-05-28 23:14:02', '系统管理员', '2020-05-23 23:15:18', '系统管理员', '0000-00-00 00:00:00');
INSERT INTO `t_address` VALUES ('4', '886', 'wxy**b', '13933336655', '河北省', '张家口市', '宣化区', '第一中学', '0000-00-00 00:00:00', '系统管理员', '2020-05-29 23:15:11', '系统管理员', '0000-00-00 00:00:00');
INSERT INTO `t_address` VALUES ('5', '857', '一坨小甜甜', '13131375784', '江苏省', '徐州市', '贾汪区', '隔壁老王家', '2020-06-07 23:15:57', '系统管理员', '0000-00-00 00:00:00', '系统管理员', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for `t_appraise`
-- ----------------------------
DROP TABLE IF EXISTS `t_appraise`;
CREATE TABLE `t_appraise` (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价id',
  `oid` int(11) NOT NULL COMMENT '订单id',
  `grade` int(10) unsigned zerofill NOT NULL COMMENT '评价等级:0，1，2，3四个等级(前端可以用五角星来展现等级)',
  `content` varchar(500) NOT NULL COMMENT '评价内容',
  `created_user` varchar(255) NOT NULL COMMENT '日志：创建人',
  `created_time` datetime NOT NULL COMMENT '日志：创建时间',
  `modified_user` varchar(255) NOT NULL COMMENT '日志：修改人',
  `modified_time` datetime NOT NULL COMMENT '日志：修改时间',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=90913 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_appraise
-- ----------------------------
INSERT INTO `t_appraise` VALUES ('90910', '2', '0000000004', '不错不错', 'jingfeng', '2020-05-17 06:45:00', 'jingfeng', '2020-05-17 06:45:00');
INSERT INTO `t_appraise` VALUES ('90912', '3', '0000000003', '辣鸡辣鸡', 'jingfeng', '2020-05-17 06:46:54', 'jingfeng', '2020-05-17 06:46:54');

-- ----------------------------
-- Table structure for `t_location`
-- ----------------------------
DROP TABLE IF EXISTS `t_location`;
CREATE TABLE `t_location` (
  `lid` int(11) NOT NULL AUTO_INCREMENT COMMENT '位置id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `longtitude` double NOT NULL COMMENT '位置的经度',
  `latitude` double NOT NULL COMMENT '位置的纬度',
  `created_user` varchar(255) NOT NULL COMMENT '日志：创建人',
  `created_time` datetime NOT NULL COMMENT '日志：创建时间',
  `modified_user` varchar(255) NOT NULL COMMENT '日志：修改人',
  `modified_time` datetime NOT NULL COMMENT '日志：修改时间',
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_location
-- ----------------------------
INSERT INTO `t_location` VALUES ('1', '857', '1.1', '200', 'user', '2020-05-23 23:43:50', 'user', '2020-05-29 23:43:56');
INSERT INTO `t_location` VALUES ('2', '886', '1.1', '100', 'user', '2020-05-29 23:43:47', 'user', '2020-05-29 23:43:54');

-- ----------------------------
-- Table structure for `t_notification`
-- ----------------------------
DROP TABLE IF EXISTS `t_notification`;
CREATE TABLE `t_notification` (
  `nid` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '通知id',
  `from_open_id` varchar(255) NOT NULL,
  `to_open_id` varchar(255) NOT NULL,
  `title` varchar(100) NOT NULL COMMENT '主题',
  `message` varchar(300) NOT NULL COMMENT '内容信息',
  `created_user` varchar(255) NOT NULL COMMENT '日志：创建人',
  `created_time` datetime NOT NULL COMMENT '日志：创建时间',
  `modified_user` varchar(255) NOT NULL COMMENT '日志：修改人',
  `modified_time` datetime NOT NULL COMMENT '日志：修改时间',
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notification
-- ----------------------------
INSERT INTO `t_notification` VALUES ('00000000001', '0', 'aaa', '该充钱了', '充值1888送娃娃一个', 'system', '2020-05-15 23:38:44', 'system', '2020-05-29 23:38:49');
INSERT INTO `t_notification` VALUES ('00000000002', 'aaa', 'bbb', '拿你的快递', '你的娃娃到了', 'user', '2020-05-29 23:38:47', 'user', '2020-05-29 23:39:05');
INSERT INTO `t_notification` VALUES ('00000000003', 'bbb', 'aaa', '走走走', '酒吧(｡･∀･)ﾉﾞ嗨', 'user', '2020-06-06 23:41:23', 'user', '2020-05-29 23:41:27');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `oid` bigint(11) NOT NULL DEFAULT '0' COMMENT '订单id',
  `title` varchar(100) NOT NULL COMMENT '订单名称',
  `catalog` varchar(100) NOT NULL COMMENT '订单类型',
  `creater_id` int(11) NOT NULL COMMENT '放单人ID',
  `creater_name` varchar(100) NOT NULL COMMENT '放单人姓名',
  `creater_tel` varchar(100) NOT NULL COMMENT '放单人联系方式',
  `creater_longitude` double unsigned NOT NULL COMMENT '放单人位置经度',
  `creater_latitude` double NOT NULL COMMENT '放单人位置纬度',
  `shops_longtitude` double NOT NULL COMMENT '商家位置经度',
  `shops_latitude` double NOT NULL COMMENT '商家位置纬度',
  `accepter_id` int(10) unsigned zerofill NOT NULL COMMENT '接单人ID',
  `create_date` datetime NOT NULL COMMENT '订单放单时间',
  `accept_date` datetime NOT NULL COMMENT '订单接受时间',
  `public_field1` varchar(300) NOT NULL COMMENT '公共字段1',
  `public_field2` varchar(300) NOT NULL COMMENT '公共字段2',
  `estimated_worth` int(11) NOT NULL COMMENT '预估价值',
  `remark` varchar(300) NOT NULL COMMENT '备注',
  `aid` int(11) NOT NULL,
  `reward` int(11) NOT NULL,
  `status` int(10) unsigned zerofill NOT NULL COMMENT '订单状态: 0未接单,1已接单,2送货中,3已接收,4已评价,5已取消,6已删除',
  `created_user` varchar(255) NOT NULL COMMENT '日志：创建人',
  `created_time` datetime NOT NULL COMMENT '日志：创建时间',
  `modified_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '日志：修改人',
  `modified_time` datetime NOT NULL COMMENT '日志：修改时间',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('2', 'kuaidi', '快递', '857', '小甜甜', '132303015643', '1.1', '1.1', '1.1', '1.1', '0000000886', '2020-05-17 05:06:47', '2020-05-17 05:06:47', 'java', 'java', '100', '备注', '123', '123', '0000000002', 'juxing', '2020-05-17 05:06:47', 'juxing', '2020-05-17 06:03:35');
INSERT INTO `t_order` VALUES ('3', 'kuaidi', '快递', '886', 'wxy', '132303015643', '1.1', '1.1', '1.1', '1.1', '0000000857', '2020-05-17 05:10:13', '2020-05-17 05:10:13', 'java', 'java', '100', '备注', '123', '123', '0000000000', 'juxing', '2020-05-17 05:10:13', 'juxing', '2020-05-17 05:10:13');

-- ----------------------------
-- Table structure for `t_reward`
-- ----------------------------
DROP TABLE IF EXISTS `t_reward`;
CREATE TABLE `t_reward` (
  `rid` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `open_Id` varchar(200) NOT NULL,
  `date` datetime NOT NULL,
  `matter` varchar(500) NOT NULL,
  `changed` int(11) NOT NULL,
  `reward` int(11) NOT NULL,
  `created_User` varchar(200) NOT NULL,
  `created_Time` datetime NOT NULL,
  `modified_User` varchar(200) NOT NULL,
  `modified_Time` datetime NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_reward
-- ----------------------------
INSERT INTO `t_reward` VALUES ('00000000001', 'aaa', '2020-05-29 16:59:33', '加分了！！！！', '100', '100', 'user', '2020-05-31 01:01:11', 'user', '2020-05-30 01:01:19');
INSERT INTO `t_reward` VALUES ('00000000002', 'bbb', '2020-05-31 01:00:43', '莫名其妙的加分', '88', '88', 'user', '2020-05-17 01:01:08', 'user', '2020-05-30 01:01:15');

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
  `gender` varchar(20) NOT NULL COMMENT '性别',
  `country` varchar(100) NOT NULL COMMENT '国家',
  `province` varchar(100) NOT NULL COMMENT '省份',
  `city` varchar(100) NOT NULL COMMENT '城市',
  `avatar_url` varchar(300) NOT NULL COMMENT '头像地址',
  `created_user` varchar(255) NOT NULL COMMENT '日志：创建人',
  `created_time` datetime NOT NULL COMMENT '日志：创建时间',
  `modified_user` varchar(255) NOT NULL COMMENT '日志：修改人',
  `modified_time` datetime NOT NULL COMMENT '日志：修改时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=889 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_wx_user
-- ----------------------------
INSERT INTO `t_wx_user` VALUES ('857', '123bbb', 'bbb', '静雨', '123456', '男', '中国', '河北省', '秦皇岛市海港区', '/null.png', 'user', '2020-05-29 23:34:24', 'user', '2020-05-29 23:34:33');
INSERT INTO `t_wx_user` VALUES ('886', '123aaa', 'aaa', '靖枫', '123456', '女', '中国', '河北省', '秦皇岛市开发区', '/null.png', 'user', '2020-05-29 23:34:28', 'user', '2020-05-29 23:34:36');
