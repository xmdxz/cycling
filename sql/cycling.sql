/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : cycling

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 28/10/2021 10:56:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for active
-- ----------------------------
DROP TABLE IF EXISTS `active`;
CREATE TABLE `active` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `map_id` int DEFAULT NULL,
  `synopsis` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '概要，摘要',
  `danger` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '危险，注意事项',
  `authorid` int DEFAULT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `stop_time` timestamp NULL DEFAULT NULL,
  `contact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ischeck` int DEFAULT NULL COMMENT '0为未审核，1为审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of active
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for active_user
-- ----------------------------
DROP TABLE IF EXISTS `active_user`;
CREATE TABLE `active_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `activeid` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of active_user
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for attend_activity
-- ----------------------------
DROP TABLE IF EXISTS `attend_activity`;
CREATE TABLE `attend_activity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `activityid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of attend_activity
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `dynamicid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of collection
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dynamicid` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of comment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for dynamic
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `time` timestamp NULL DEFAULT NULL,
  `author_id` int DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of dynamic
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for dynamic_image
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_image`;
CREATE TABLE `dynamic_image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `dynamic_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of dynamic_image
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for dynamic_topic
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_topic`;
CREATE TABLE `dynamic_topic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dynamic_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `topic_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of dynamic_topic
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for fans
-- ----------------------------
DROP TABLE IF EXISTS `fans`;
CREATE TABLE `fans` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `fansid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of fans
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for map
-- ----------------------------
DROP TABLE IF EXISTS `map`;
CREATE TABLE `map` (
  `id` int NOT NULL AUTO_INCREMENT,
  `src` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `type` int DEFAULT NULL COMMENT '地图类型',
  `hot` int DEFAULT NULL,
  `synopsis` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of map
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ride
-- ----------------------------
DROP TABLE IF EXISTS `ride`;
CREATE TABLE `ride` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `duration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '骑行时长',
  `distance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `avg_speed` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mapid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of ride
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `topicName` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of topic
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `salt` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `method` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `wx_openid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `qq_openid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `last_login_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '1597d20d1a17bd4ba28d042988ae1f12', 'U8JS07lT', NULL, NULL, NULL, '13994722068', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sex` int DEFAULT NULL COMMENT '性别，0代表女，1代表男',
  `height` float DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像外链',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `level` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `exp` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user_info
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
