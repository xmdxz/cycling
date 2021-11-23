/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.23 : Database - cycling
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cycling` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `cycling`;

/*Table structure for table `active` */

DROP TABLE IF EXISTS `active`;

CREATE TABLE `active` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `map_id` int DEFAULT NULL,
  `synopsis` text COLLATE utf8mb4_general_ci COMMENT '概要，摘要',
  `danger` text COLLATE utf8mb4_general_ci COMMENT '危险，注意事项',
  `authorid` int DEFAULT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `stop_time` timestamp NULL DEFAULT NULL,
  `contact` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ischeck` int DEFAULT NULL COMMENT '0为未审核，1为审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `active` */

/*Table structure for table `active_user` */

DROP TABLE IF EXISTS `active_user`;

CREATE TABLE `active_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `activeid` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `active_user` */

/*Table structure for table `attend_activity` */

DROP TABLE IF EXISTS `attend_activity`;

CREATE TABLE `attend_activity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `activityid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `attend_activity` */

/*Table structure for table `collection` */

DROP TABLE IF EXISTS `collection`;

CREATE TABLE `collection` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `dynamicid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `collection` */

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dynamicid` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  `content` text COLLATE utf8mb4_general_ci,
  `time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `comment` */

/*Table structure for table `dynamic` */

DROP TABLE IF EXISTS `dynamic`;

CREATE TABLE `dynamic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `content` text COLLATE utf8mb4_general_ci,
  `images` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  `authorid` int DEFAULT NULL,
  `position` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `dynamic` */

/*Table structure for table `fans` */

DROP TABLE IF EXISTS `fans`;

CREATE TABLE `fans` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `fansid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `fans` */

/*Table structure for table `map` */

DROP TABLE IF EXISTS `map`;

CREATE TABLE `map` (
  `id` int NOT NULL AUTO_INCREMENT,
  `src` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tag` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `type` int DEFAULT NULL COMMENT '地图类型',
  `hot` int DEFAULT NULL,
  `synopsis` text COLLATE utf8mb4_general_ci,
  `area` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `map` */

/*Table structure for table `ride` */

DROP TABLE IF EXISTS `ride`;

CREATE TABLE `ride` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `duration` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '骑行时长',
  `distance` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `avg_speed` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mapid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `ride` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `method` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `wx_openid` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `qq_openid` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(11) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `last_login_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `user` */

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sex` int DEFAULT NULL COMMENT '性别，0代表女，1代表男',
  `height` float DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `birthday` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像外链',
  `introduction` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `level` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `exp` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `user_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
