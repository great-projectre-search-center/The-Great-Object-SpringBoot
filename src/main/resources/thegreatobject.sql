/*
Navicat MySQL Data Transfer

Source Server         : win10-jingfeng999
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : thegreatobject

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2020-06-20 14:29:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '收货地址ID',
  `uid` varchar(100) DEFAULT NULL COMMENT '用户ID',
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
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO `t_address` VALUES ('1', '857', '一坨小甜甜', '13131375784', '江苏省', '徐州市', '贾汪区', '隔壁老王家', '2020-06-02 11:04:22', '系统管理员', '2020-06-02 11:04:33', '系统管理员', '2020-06-02 11:04:43');
INSERT INTO `t_address` VALUES ('11', '555', 'juxing', '110', 'beijieng', 'beijing', 'beijing', 'jingdong', '2020-05-17 06:31:38', 'juxing', '2020-05-17 06:31:38', 'juxing', '2020-05-17 06:31:38');
INSERT INTO `t_address` VALUES ('111', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '巨星', '13230301653', '河北省', '邯郸市', '邯山区', '巨星路154684号', null, 'juxing', '2020-06-02 03:38:38', 'juxing', '2020-06-02 03:38:38');
INSERT INTO `t_address` VALUES ('113', null, 'jingfeng', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_address` VALUES ('120', '857', '测试数据', '13833335556', '北京市', '朝阳区', '北京一条街', '朝阳小区', '2020-06-27 00:23:56', '系统管理员', '2020-06-19 00:24:05', '系统管理员', '2020-06-21 00:24:09');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notification
-- ----------------------------
INSERT INTO `t_notification` VALUES ('00000000001', '0', '-1', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '-1', 'Welcome', '欢迎来到帮跑跑', '', '2020-05-29 07:46:14', '', '2020-05-29 07:46:14');
INSERT INTO `t_notification` VALUES ('00000000002', '0', '-1', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '-1', 'Welcome', '欢迎来到帮跑跑', '', '2020-05-29 07:50:18', '', '2020-05-29 07:50:18');
INSERT INTO `t_notification` VALUES ('00000000003', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, '1', null, '订单消息', 'ZZZXXXCCCWXY999已经接收你完成的订单', '1', '2020-06-07 05:49:04', '1', '2020-06-07 05:49:04');
INSERT INTO `t_notification` VALUES ('00000000004', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, '订单消息', 'ZZZXXXCCCWXY999已接受你的订单', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-07 05:55:34', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-07 05:55:34');
INSERT INTO `t_notification` VALUES ('00000000005', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, '订单消息', 'ZZZXXXCCCWXY999取消了你的订单', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-07 05:56:48', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-07 05:56:48');
INSERT INTO `t_notification` VALUES ('00000000006', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, '订单消息', 'ZZZXXXCCCWXY999取消了你的订单', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-07 05:58:43', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-07 05:58:43');
INSERT INTO `t_notification` VALUES ('00000000007', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, '订单消息', 'ZZZXXXCCCWXY999取消了你的订单', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-08 15:51:36', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-08 15:51:36');
INSERT INTO `t_notification` VALUES ('00000000008', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, '订单消息', 'ZZZXXXCCCWXY999取消了你的订单', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-09 03:12:28', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-09 03:12:28');
INSERT INTO `t_notification` VALUES ('00000000009', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, '订单消息', 'ZZZXXXCCCWXY999取消了你的订单', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-13 16:15:09', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-13 16:15:09');
INSERT INTO `t_notification` VALUES ('00000000010', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, '订单消息', 'ZZZXXXCCCWXY999取消了你的订单', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-13 16:24:53', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-13 16:24:53');
INSERT INTO `t_notification` VALUES ('00000000011', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', null, '订单消息', 'ZZZXXXCCCWXY999已经接收你完成的订单', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-15 04:58:37', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-15 04:58:37');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `oid` int(11) NOT NULL DEFAULT '0' COMMENT '订单id',
  `title` varchar(100) DEFAULT NULL COMMENT '订单名称',
  `catalog` varchar(100) DEFAULT NULL COMMENT '订单类型',
  `creater_id` varchar(100) DEFAULT NULL COMMENT '放单人ID',
  `creater_name` varchar(100) DEFAULT NULL COMMENT '放单人姓名',
  `creater_tel` varchar(100) DEFAULT NULL COMMENT '放单人联系方式',
  `creater_longitude` double unsigned DEFAULT NULL COMMENT '放单人位置经度',
  `creater_latitude` double DEFAULT NULL COMMENT '放单人位置纬度',
  `shops_longtitude` double DEFAULT NULL COMMENT '商家位置经度',
  `shops_latitude` double DEFAULT NULL COMMENT '商家位置纬度',
  `accepter_id` varchar(100) DEFAULT NULL COMMENT '接单人ID',
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
INSERT INTO `t_order` VALUES ('45776318', '777', '帮我取', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '77', '77', '0', '0', '0', '0', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:49:49', '2020-06-07 05:55:34', '顺丰快递', '777', '50', '7', '0', '10', '0000000003', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:49:49', '', '2020-06-15 04:58:37');
INSERT INTO `t_order` VALUES ('54089096', '6', '帮我取', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '6', '6', '0', '0', '0', '0', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:34:15', '2020-06-01 16:35:33', '顺丰快递', '6', '50', '6', '0', '10', '0000000006', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:34:15', '', '2020-06-01 16:52:06');
INSERT INTO `t_order` VALUES ('67128819', '3', '帮我取', '88', '3', '3', '0', '0', '0', '0', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:27:02', '2020-06-01 16:27:20', '顺丰快递', '3', '50', '3', '0', '10', '0000000003', '88', '2020-06-01 16:27:02', '', '2020-06-01 16:36:47');
INSERT INTO `t_order` VALUES ('168253069', null, '恶心的订单', null, null, null, null, null, null, null, null, '2020-06-07 05:38:58', null, null, null, null, null, null, null, null, null, '2020-06-07 05:38:58', null, '2020-06-07 05:38:58');
INSERT INTO `t_order` VALUES ('337240856', '1', '帮我取', '88', '1', '1', '0', '0', '0', '0', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:26:36', '2020-06-01 16:35:47', '顺丰快递', '1', '50', '1', '0', '10', '0000000003', '88', '2020-06-01 16:26:36', '', '2020-06-01 16:37:02');
INSERT INTO `t_order` VALUES ('1006422505', '2', '帮我取', '88', '2', '2', '0', '0', '0', '0', '1', '2020-06-01 16:26:47', '0000-00-00 00:00:00', '顺丰快递', '2', '50', '2', '0', '10', '0000000000', '88', '2020-06-01 16:26:47', '', '2020-06-01 16:26:47');
INSERT INTO `t_order` VALUES ('1187820787', '5', '帮我取', '88', '5', '5', '0', '0', '0', '0', '1', '2020-06-01 16:32:34', '0000-00-00 00:00:00', '顺丰快递', '5', '50', '5', '0', '10', '0000000000', '88', '2020-06-01 16:32:34', '', '2020-06-01 16:32:34');
INSERT INTO `t_order` VALUES ('1743869185', '8', '帮我取', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '8', '8', '0', '0', '0', '0', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:50:08', '2020-06-01 16:50:18', '顺丰快递', '8', '50', '', '0', '10', '0000000003', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:50:08', '', '2020-06-01 17:08:00');
INSERT INTO `t_order` VALUES ('2068860635', '4', '帮我取', '88', '4', '4', '0', '0', '0', '0', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:28:41', '2020-06-01 16:41:03', '顺丰快递', '4', '50', '4', '0', '10', '0000000003', '88', '2020-06-01 16:28:41', '', '2020-06-01 17:08:15');

-- ----------------------------
-- Table structure for `t_reward`
-- ----------------------------
DROP TABLE IF EXISTS `t_reward`;
CREATE TABLE `t_reward` (
  `rid` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `open_Id` varchar(200) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `matter` varchar(500) DEFAULT NULL,
  `changed` int(11) DEFAULT NULL,
  `reward` int(11) DEFAULT NULL,
  `created_User` varchar(200) DEFAULT NULL,
  `created_Time` datetime DEFAULT NULL,
  `modified_User` varchar(200) DEFAULT NULL,
  `modified_Time` datetime DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_reward
-- ----------------------------
INSERT INTO `t_reward` VALUES ('00000000003', 'aaa', '2020-06-02 07:16:47', '加分了！！！！', '100', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00');
INSERT INTO `t_reward` VALUES ('00000000004', 'aaa', '2020-06-07 06:06:09', '加分了！！！！', '100', '0', null, null, null, null);
INSERT INTO `t_reward` VALUES ('00000000005', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-15 03:44:37', '新用户的初始积分', '100', '100', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-15 03:44:37', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-15 03:44:37');
INSERT INTO `t_reward` VALUES ('00000000006', 'aaa', '2020-06-15 04:55:50', '加分了！！！！', '100', '0', null, null, null, null);
INSERT INTO `t_reward` VALUES ('00000000007', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-15 04:58:37', '接受订单完成的奖励积分', '10', '110', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-15 04:58:37', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-15 04:58:37');

-- ----------------------------
-- Table structure for `t_wx_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_user`;
CREATE TABLE `t_wx_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `open_id` varchar(100) DEFAULT NULL COMMENT '普通用户的一个唯一的标识',
  `session_key` varchar(255) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `encoded_password` varchar(255) DEFAULT NULL COMMENT '加密的密码',
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_wx_user
-- ----------------------------
INSERT INTO `t_wx_user` VALUES ('1', '123', '', '123', '', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_wx_user` VALUES ('2', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '', 'ZZZXXXCCCWXY999', null, '1', 'China', 'Hebei', 'Handan', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJyeUkf7UcgtyE1qj0PO2tZicZ4AtSQKtliaLU6iculltBict3prXmCA5bzGF5CbD7Dbdnan78v29yd4A/132', null, null, null, null);
