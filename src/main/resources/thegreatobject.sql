/*
 Navicat Premium Data Transfer

 Source Server         : ZZZXXXCCCWXY999
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : thegreatobject

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 02/06/2020 11:39:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_address
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
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_address
-- ----------------------------
BEGIN;
INSERT INTO `t_address` VALUES (1, '857', '一坨小甜甜', '13131375784', '江苏省', '徐州市', '贾汪区', '隔壁老王家', '2020-06-02 11:04:22', '系统管理员', '2020-06-02 11:04:33', '系统管理员', '2020-06-02 11:04:43');
INSERT INTO `t_address` VALUES (11, '555', 'juxing', '110', 'beijieng', 'beijing', 'beijing', 'jingdong', '2020-05-17 06:31:38', 'juxing', '2020-05-17 06:31:38', 'juxing', '2020-05-17 06:31:38');
INSERT INTO `t_address` VALUES (111, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '巨星', '13230301653', '河北省', '邯郸市', '邯山区', '巨星路154684号', NULL, 'juxing', '2020-06-02 03:38:38', 'juxing', '2020-06-02 03:38:38');
INSERT INTO `t_address` VALUES (113, NULL, 'jingfeng', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_appraise
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
BEGIN;
INSERT INTO `t_appraise` VALUES (90910, 0, NULL, 'CDC等等', 'jingfeng', '2020-05-17 06:45:00', 'jingfeng', '2020-05-17 06:45:00');
INSERT INTO `t_appraise` VALUES (90912, 1, NULL, 'CDC等等', 'jingfeng', '2020-05-17 06:46:54', 'jingfeng', '2020-05-17 06:46:54');
COMMIT;

-- ----------------------------
-- Table structure for t_location
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
-- Table structure for t_notification
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notification
-- ----------------------------
BEGIN;
INSERT INTO `t_notification` VALUES (00000000001, '0', -1, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', -1, 'Welcome', '欢迎来到帮跑跑', NULL, '2020-05-29 07:46:14', NULL, '2020-05-29 07:46:14');
INSERT INTO `t_notification` VALUES (00000000002, '0', -1, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', -1, 'Welcome', '欢迎来到帮跑跑', NULL, '2020-05-29 07:50:18', NULL, '2020-05-29 07:50:18');
COMMIT;

-- ----------------------------
-- Table structure for t_order
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
BEGIN;
INSERT INTO `t_order` VALUES (45776318, '777', '帮我取', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '77', '77', NULL, NULL, NULL, NULL, '1', '2020-06-01 16:49:49', NULL, '顺丰快递', '777', 50, '7', NULL, 10, 0000000000, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:49:49', NULL, '2020-06-01 16:49:49');
INSERT INTO `t_order` VALUES (54089096, '6', '帮我取', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '6', '6', NULL, NULL, NULL, NULL, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:34:15', '2020-06-01 16:35:33', '顺丰快递', '6', 50, '6', NULL, 10, 0000000006, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:34:15', NULL, '2020-06-01 16:52:06');
INSERT INTO `t_order` VALUES (67128819, '3', '帮我取', '88', '3', '3', NULL, NULL, NULL, NULL, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:27:02', '2020-06-01 16:27:20', '顺丰快递', '3', 50, '3', NULL, 10, 0000000003, '88', '2020-06-01 16:27:02', NULL, '2020-06-01 16:36:47');
INSERT INTO `t_order` VALUES (337240856, '1', '帮我取', '88', '1', '1', NULL, NULL, NULL, NULL, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:26:36', '2020-06-01 16:35:47', '顺丰快递', '1', 50, '1', NULL, 10, 0000000003, '88', '2020-06-01 16:26:36', NULL, '2020-06-01 16:37:02');
INSERT INTO `t_order` VALUES (1006422505, '2', '帮我取', '88', '2', '2', NULL, NULL, NULL, NULL, '1', '2020-06-01 16:26:47', NULL, '顺丰快递', '2', 50, '2', NULL, 10, 0000000000, '88', '2020-06-01 16:26:47', NULL, '2020-06-01 16:26:47');
INSERT INTO `t_order` VALUES (1187820787, '5', '帮我取', '88', '5', '5', NULL, NULL, NULL, NULL, '1', '2020-06-01 16:32:34', NULL, '顺丰快递', '5', 50, '5', NULL, 10, 0000000000, '88', '2020-06-01 16:32:34', NULL, '2020-06-01 16:32:34');
INSERT INTO `t_order` VALUES (1743869185, '8', '帮我取', 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '8', '8', NULL, NULL, NULL, NULL, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:50:08', '2020-06-01 16:50:18', '顺丰快递', '8', 50, '', NULL, 10, 0000000003, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:50:08', NULL, '2020-06-01 17:08:00');
INSERT INTO `t_order` VALUES (2068860635, '4', '帮我取', '88', '4', '4', NULL, NULL, NULL, NULL, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '2020-06-01 16:28:41', '2020-06-01 16:41:03', '顺丰快递', '4', 50, '4', NULL, 10, 0000000003, '88', '2020-06-01 16:28:41', NULL, '2020-06-01 17:08:15');
COMMIT;

-- ----------------------------
-- Table structure for t_wx_user
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_user`;
CREATE TABLE `t_wx_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `open_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '普通用户的一个唯一的标识',
  `session_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
  `encoded_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '加密的密码',
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
BEGIN;
INSERT INTO `t_wx_user` VALUES (1, '123', '', '123', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_wx_user` VALUES (2, 'oV9m45b5S1RGPf6gTCXu3a5dAgF4', '', 'ZZZXXXCCCWXY999', NULL, '1', 'China', 'Hebei', 'Handan', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJyeUkf7UcgtyE1qj0PO2tZicZ4AtSQKtliaLU6iculltBict3prXmCA5bzGF5CbD7Dbdnan78v29yd4A/132', NULL, NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
