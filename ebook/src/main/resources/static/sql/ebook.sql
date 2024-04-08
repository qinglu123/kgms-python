/*
SQLyog Ultimate v11.13 (32 bit)
MySQL - 5.7.34 : Database - ebook
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ebook` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ebook`;

/*Table structure for table `ebook_category` */

DROP TABLE IF EXISTS `ebook_category`;

CREATE TABLE `ebook_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类编号',
  `name` varchar(20) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `ebook_category` */

insert  into `ebook_category`(`id`,`name`) values (1,'Oracle'),(2,'Mysql'),(3,'Java'),(4,'JavaScript');

/*Table structure for table `ebook_entry` */

DROP TABLE IF EXISTS `ebook_entry`;

CREATE TABLE `ebook_entry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `categoryId` bigint(20) NOT NULL COMMENT '分类编号',
  `title` varchar(50) NOT NULL COMMENT '图书名称',
  `summary` varchar(50) DEFAULT NULL COMMENT '摘要',
  `uploaduser` varchar(50) DEFAULT NULL COMMENT '上传人',
  `createdate` date NOT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `ebook_entry` */

insert  into `ebook_entry`(`id`,`categoryId`,`title`,`summary`,`uploaduser`,`createdate`) values (1,1,'Oracle学习1','Oracle学习必备','小兰','2023-02-11'),(2,1,'Oracle学习2','Oracle学习精品','柯南','2012-10-08'),(3,3,'全面解析Java技术','Java学习精品','原子','2000-11-18'),(4,4,'JavaScript学习笔记','JavaScript精品','小艾','2001-11-26'),(5,2,'Mysql学习笔记','学Mysql必备','小五郎','2011-11-11'),(18,2,'嘿嘿嘿','嘿嘿嘿','嘿嘿嘿','2023-02-12');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
