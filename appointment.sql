/*
Navicat MySQL Data Transfer

Source Server         : HYY
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : appointment

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-05-07 16:15:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `ID` varchar(50) NOT NULL DEFAULT '' COMMENT '评论Id',
  `dongtaiID` varchar(50) NOT NULL COMMENT '动态ID',
  `name` varchar(50) NOT NULL COMMENT '评论用户',
  `context` varchar(255) NOT NULL COMMENT '评论内容',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for dongtai
-- ----------------------------
DROP TABLE IF EXISTS `dongtai`;
CREATE TABLE `dongtai` (
  `ID` varchar(50) NOT NULL COMMENT '动态id',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `data` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '动态时间',
  `context` varchar(255) NOT NULL COMMENT '内容',
  `imgae` varchar(255) DEFAULT NULL COMMENT '图片路径',
  KEY `name` (`name`),
  CONSTRAINT `dongtai_ibfk_1` FOREIGN KEY (`name`) REFERENCES `user` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dongtai
-- ----------------------------

-- ----------------------------
-- Table structure for like
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like` (
  `ID` varchar(50) NOT NULL COMMENT '动态id',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `username` varchar(255) DEFAULT '' COMMENT '用户名',
  KEY `ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of like
-- ----------------------------

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `ID` varchar(50) NOT NULL COMMENT '回复ID',
  `comment_id` varchar(50) NOT NULL COMMENT '根评论id',
  `reply_id` varchar(50) NOT NULL COMMENT '父回复id',
  `reply_type` varchar(50) NOT NULL COMMENT '评论类型是回复评论还是回复评论的评论',
  `cotext` varchar(255) NOT NULL COMMENT '回复的内容',
  `to_uid` varchar(50) NOT NULL COMMENT '回复的回复人的id',
  `from_uid` varchar(50) NOT NULL COMMENT '回复人id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `school` varchar(50) NOT NULL COMMENT '学校',
  `academy` varchar(50) NOT NULL COMMENT '学院',
  `major` varchar(50) NOT NULL COMMENT '学院',
  `cardzheng` varchar(50) NOT NULL COMMENT '身份证正面照',
  `cardfan` varchar(50) NOT NULL COMMENT '身份证反面',
  `image` varchar(50) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
