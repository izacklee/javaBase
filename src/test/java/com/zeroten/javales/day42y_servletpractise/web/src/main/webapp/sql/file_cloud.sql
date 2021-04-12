/*
 Navicat Premium Data Transfer

 Source Server         : localdb
 Source Server Type    : MySQL
 Source Server Version : 50715
 Source Host           : localhost
 Source Database       : file_cloud

 Target Server Type    : MySQL
 Target Server Version : 50715
 File Encoding         : utf-8

 Date: 05/23/2020 17:33:56 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `file_cloud`
-- ----------------------------
DROP TABLE IF EXISTS `file_cloud`;
CREATE TABLE `file_cloud` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `file_name` varchar(100) NOT NULL COMMENT '文件名',
  `file_path` varchar(500) NOT NULL COMMENT '文件路径',
  `file_type` int(11) NOT NULL COMMENT '文件类型',
  `file_size` int(11) NOT NULL COMMENT '文件大小',
  `file_status` int(11) NOT NULL COMMENT '文件状态',
  `appid` varchar(100) NOT NULL COMMENT '用户唯一标识',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件存储表';

-- ----------------------------
--  Table structure for `file_history`
-- ----------------------------
DROP TABLE IF EXISTS `file_history`;
CREATE TABLE `file_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `file_name` varchar(100) NOT NULL COMMENT '文件名',
  `file_path` varchar(500) NOT NULL COMMENT '文件路径',
  `file_type` int(11) NOT NULL COMMENT '文件类型',
  `file_size` int(11) NOT NULL COMMENT '文件大小',
  `history_status` int(11) NOT NULL COMMENT '历史状态',
  `appid` varchar(100) NOT NULL COMMENT '用户唯一标识',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='文件历史记录表';

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `realname` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `appid` varchar(100) NOT NULL COMMENT '用户唯一标识',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
--  Table structure for `user_volume`
-- ----------------------------
DROP TABLE IF EXISTS `user_volume`;
CREATE TABLE `user_volume` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `size` int(11) NOT NULL COMMENT '容量大小',
  `def_size` int(11) NOT NULL COMMENT '当前容量值',
  `max_size` int(11) NOT NULL COMMENT '最大容量值',
  `expire_time` datetime NOT NULL COMMENT '有效期',
  `appid` varchar(100) NOT NULL COMMENT '用户唯一标识',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户容量表';

SET FOREIGN_KEY_CHECKS = 1;
