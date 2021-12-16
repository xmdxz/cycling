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

 Date: 15/12/2021 10:02:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for active
-- ----------------------------
DROP TABLE IF EXISTS `active`;
CREATE TABLE `active` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `map_id` bigint DEFAULT NULL,
  `synopsis` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '概要，摘要',
  `danger` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '危险，注意事项',
  `authorid` bigint DEFAULT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `stop_time` timestamp NULL DEFAULT NULL,
  `contact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ischeck` int DEFAULT NULL COMMENT '0为未审核，1为审核',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activeid` bigint DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `userid` bigint DEFAULT NULL,
  `activityid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `userid` bigint DEFAULT NULL,
  `dynamicid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dynamicid` bigint DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
BEGIN;
INSERT INTO `comment` VALUES (1, 56, 2, '支持一波', '2021-12-13 16:31:05');
COMMIT;

-- ----------------------------
-- Table structure for dynamic
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `time` timestamp NULL DEFAULT NULL,
  `author_id` bigint DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dynamic
-- ----------------------------
BEGIN;
INSERT INTO `dynamic` VALUES (56, '太谷凤凰山骑行', '今天在太谷凤凰山骑行，很不错，景色很不错，也很有挑战难度', '2021-12-08 15:47:11', 1, '山西省-晋中市-太谷县');
INSERT INTO `dynamic` VALUES (57, '太原迎泽街骑行', '今天太原迎泽街日常骑行，打卡', '2021-12-14 21:43:35', 2, '山西省-太原市-迎泽区');
COMMIT;

-- ----------------------------
-- Table structure for dynamic_image
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_image`;
CREATE TABLE `dynamic_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `dynamic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dynamic_image
-- ----------------------------
BEGIN;
INSERT INTO `dynamic_image` VALUES (18, 'FpEuon03JEKTU23AsDUJK3F_ZRvc', 56);
INSERT INTO `dynamic_image` VALUES (19, 'FjUrzo3Ka9uMn_WZn8iDt_3TXK5r', 56);
INSERT INTO `dynamic_image` VALUES (20, 'FpYsEeGGT8AzbYsxd7gNsSwrU1f4', 57);
COMMIT;

-- ----------------------------
-- Table structure for dynamic_topic
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_topic`;
CREATE TABLE `dynamic_topic` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dynamic_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dynamic_topic
-- ----------------------------
BEGIN;
INSERT INTO `dynamic_topic` VALUES (63, 56, 5);
INSERT INTO `dynamic_topic` VALUES (64, 57, 2);
INSERT INTO `dynamic_topic` VALUES (65, 57, 5);
COMMIT;

-- ----------------------------
-- Table structure for fans
-- ----------------------------
DROP TABLE IF EXISTS `fans`;
CREATE TABLE `fans` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `userid` bigint NOT NULL,
  `fansid` bigint NOT NULL,
  `focusTime` timestamp NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of fans
-- ----------------------------
BEGIN;
INSERT INTO `fans` VALUES (1, 1, 2, '2021-11-27 09:27:12');
INSERT INTO `fans` VALUES (12, 2, 1, '2021-11-27 09:27:57');
COMMIT;

-- ----------------------------
-- Table structure for map
-- ----------------------------
DROP TABLE IF EXISTS `map`;
CREATE TABLE `map` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `src` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `type` int DEFAULT NULL COMMENT '地图类型',
  `hot` bigint DEFAULT NULL,
  `synopsis` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `userid` bigint DEFAULT NULL,
  `date` date DEFAULT NULL,
  `duration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '骑行时长',
  `distance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `avg_speed` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mapid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `topic_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of topic
-- ----------------------------
BEGIN;
INSERT INTO `topic` VALUES (1, '风景观');
INSERT INTO `topic` VALUES (2, '日常赛跑');
INSERT INTO `topic` VALUES (3, '冲冲冲');
INSERT INTO `topic` VALUES (4, '日常晒图');
INSERT INTO `topic` VALUES (5, '日常骑行');
INSERT INTO `topic` VALUES (6, '周末放松');
INSERT INTO `topic` VALUES (7, '今日放松');
INSERT INTO `topic` VALUES (8, '一起来玩耍');
INSERT INTO `topic` VALUES (9, '大家一起快乐呀');
INSERT INTO `topic` VALUES (10, '欢乐与你相伴');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `method` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `wx_openid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `qq_openid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `last_login_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '1597d20d1a17bd4ba28d042988ae1f12', 'U8JS07lT', NULL, NULL, NULL, '13994722068', NULL, NULL);
INSERT INTO `user` VALUES (2, '1597d20d1a17bd4ba28d042988ae1f12', 'U8JS07lT', NULL, NULL, NULL, '12345678932', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `userid` bigint NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sex` int DEFAULT NULL COMMENT '性别，0代表女，1代表男',
  `height` float DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像外链',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `level` int DEFAULT '1',
  `exp` bigint DEFAULT '0',
  `praisedCount` bigint unsigned DEFAULT '0',
  `visitorCount` bigint unsigned DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES (1, 1, 'xpdxz', 1, 125, 178, '2000-09-23', '山西省临汾市乡宁县', '9ec6241873634cbeba42be64456af289.jpeg', '个人简介', 1, 1, 0, 1);
INSERT INTO `user_info` VALUES (4, 2, '张三', 0, 123, 160, '2000-09-23', '12', 'afca40de38694644aba4343efccc66f6.jpeg', '2', 1, 0, 0, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
