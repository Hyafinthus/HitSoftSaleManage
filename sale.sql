/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.27 : Database - hit_software_sale
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hit_software_sale` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hit_software_sale`;

/*Table structure for table `client_table` */

DROP TABLE IF EXISTS `client_table`;

CREATE TABLE `client_table` (
  `client_id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `client_name` varchar(20) NOT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `points` int(8) unsigned NOT NULL DEFAULT '0',
  `wallet` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `client_table` */

insert  into `client_table`(`client_id`,`client_name`,`sex`,`phone`,`address`,`points`,`wallet`) values (1,'零售客户',NULL,NULL,NULL,0,0),(4,'皮皮虾','男','11122223333','地址000',0,0),(5,'客户2','女','11155556666','地址2',0,0),(6,'客户3','男','11133334444','地址3',0,0),(7,'客户4','男','11188886666','地址2',0,0),(8,'客户5','女','11188884444','地址2',0,0),(9,'客户6','女','11144447777','地址4',0,0),(10,'客户7','男','11133337777','地址8',0,0),(11,'客户8','男','11166662222','地址3',0,0),(12,'客户9','女','11166660000','地址9',0,0),(13,'客户10','男','11144449999','地址',0,0),(14,'客户11','男','11133336666','地址',0,0),(15,'客户12','男','11177779999','地址11',0,0),(16,'111','男','111','111',0,0);

/*Table structure for table `depot_in_table` */

DROP TABLE IF EXISTS `depot_in_table`;

CREATE TABLE `depot_in_table` (
  `depot_in_pri` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(8) unsigned NOT NULL,
  `count` int(8) unsigned NOT NULL,
  `in_price` double NOT NULL,
  `depot_name` varchar(20) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`depot_in_pri`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `depot_in_table` */

insert  into `depot_in_table`(`depot_in_pri`,`product_id`,`count`,`in_price`,`depot_name`,`time`) values (1,10,10,100,'仓库','2019-12-01 00:00:00'),(2,10,20,300,'门店','2019-12-26 00:00:01'),(3,11,5,20,'门店','2019-12-26 00:00:02');

/*Table structure for table `depot_prod_table` */

DROP TABLE IF EXISTS `depot_prod_table`;

CREATE TABLE `depot_prod_table` (
  `depot_prod_pri` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `depot_name` varchar(20) NOT NULL,
  `product_id` int(8) unsigned NOT NULL,
  `count` int(8) unsigned NOT NULL,
  PRIMARY KEY (`depot_prod_pri`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Data for the table `depot_prod_table` */

insert  into `depot_prod_table`(`depot_prod_pri`,`depot_name`,`product_id`,`count`) values (13,'仓库',8,40),(14,'门店',8,3),(15,'仓库',10,133),(16,'门店',10,45),(17,'仓库',11,3444),(18,'门店',11,43),(19,'仓库',12,23),(20,'门店',12,52),(21,'仓库',13,77),(22,'门店',13,45),(23,'仓库',14,23),(24,'门店',14,5),(25,'仓库',15,60),(26,'门店',15,9),(27,'仓库',16,688),(28,'门店',16,54),(29,'仓库',17,63),(30,'门店',17,30),(31,'仓库',18,56),(32,'门店',18,687),(33,'仓库',19,23),(34,'门店',19,22),(35,'仓库',20,0),(36,'门店',20,0);

/*Table structure for table `order_prod_table` */

DROP TABLE IF EXISTS `order_prod_table`;

CREATE TABLE `order_prod_table` (
  `order_prod_pri` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(8) unsigned NOT NULL,
  `product_id` int(8) unsigned NOT NULL,
  `count` int(8) unsigned NOT NULL,
  `bonus` tinyint(1) NOT NULL DEFAULT '0',
  `purchase_price` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_prod_pri`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

/*Data for the table `order_prod_table` */

insert  into `order_prod_table`(`order_prod_pri`,`order_id`,`product_id`,`count`,`bonus`,`purchase_price`) values (4,13,12,2,0,0),(5,13,11,2,0,0),(6,13,10,1,0,0),(10,15,9,2,0,0),(11,15,11,1,0,0),(12,15,12,1,0,0),(13,16,11,3,0,0),(14,16,12,1,0,0),(15,17,9,1,0,0),(16,17,10,1,0,0),(17,18,9,100,0,0),(18,19,9,100,0,0),(19,20,10,100,0,0),(20,20,9,100,0,0),(21,21,11,1,0,0),(22,21,12,3,0,0),(23,21,18,1,0,0),(24,21,16,4,0,0),(25,21,14,1,0,0),(26,21,13,1,0,0),(27,22,13,25,0,0),(28,23,12,1,0,0),(29,23,11,1,0,0),(30,23,13,1,0,0),(31,24,16,1,0,0),(32,24,18,1,0,0),(33,24,11,1,0,0),(34,25,9,1,0,0),(35,25,10,1,0,0),(36,25,19,1,0,0),(37,26,17,1,0,0),(38,26,18,1,0,0),(39,26,15,1,0,0),(40,26,19,166,0,0),(41,27,12,1,0,0),(42,27,11,1,0,0),(43,28,11,1,0,0),(44,28,10,1,0,0),(45,29,16,1,0,0),(46,29,9,1,0,0),(47,30,11,1,0,0),(48,30,13,1,0,0),(49,31,14,17,0,0),(50,31,15,25,0,0),(51,31,12,15,0,0),(52,32,15,1,0,0),(53,32,17,1,0,0),(62,35,9,10,0,0),(63,35,11,1,0,0),(64,35,17,1,0,0),(65,35,14,1,0,0),(66,36,9,1,0,0),(67,36,10,1,0,0);

/*Table structure for table `order_table` */

DROP TABLE IF EXISTS `order_table`;

CREATE TABLE `order_table` (
  `order_id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `return_time` datetime DEFAULT NULL,
  `client_id` int(8) unsigned DEFAULT NULL,
  `order_sale_price` double DEFAULT NULL COMMENT '售价',
  `order_purchase_price` double DEFAULT NULL COMMENT '进价',
  `order_profit` double DEFAULT NULL COMMENT '毛利',
  `state` varchar(20) NOT NULL,
  `wholesale_order` tinyint(1) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Data for the table `order_table` */

insert  into `order_table`(`order_id`,`create_time`,`pay_time`,`return_time`,`client_id`,`order_sale_price`,`order_purchase_price`,`order_profit`,`state`,`wholesale_order`) values (13,'2019-12-14 23:20:49',NULL,NULL,4,5038,4034,1004,'paid_delivered',0),(15,'2019-12-14 23:23:03','2019-12-14 23:28:35','2019-12-15 16:27:44',5,12019,10017,2002,'returned',1),(16,'2019-12-14 23:23:15','2019-12-14 23:28:23','2019-12-14 23:28:28',5,45,41,4,'returned',1),(17,'2019-12-15 00:14:37',NULL,NULL,4,13000,9000,4000,'unpaid_delivered',0),(18,'2019-12-15 15:53:33',NULL,NULL,6,1300000,900000,400000,'unpaid_delivered',0),(19,'2019-12-15 15:53:35',NULL,NULL,6,1300000,900000,400000,'paid_undelivered',0),(20,'2019-12-15 15:57:50','2019-12-15 16:27:35',NULL,4,1100000,900000,200000,'paid_delivered',1),(21,'2019-12-15 15:58:09',NULL,NULL,4,12332,10282,2050,'rejected',1),(22,'2019-12-15 15:58:39','2019-12-15 16:27:37',NULL,4,300000,250000,50000,'paid_undelivered',1),(23,'2019-12-15 15:59:16',NULL,NULL,12,12019,10017,2002,'approved',1),(24,'2019-12-15 15:59:42',NULL,NULL,9,128.5,112,16.5,'approved',1),(25,'2019-12-15 15:59:57',NULL,NULL,15,11300,9200,2100,'approved',1),(26,'2019-12-15 16:00:24',NULL,NULL,11,49980.5,33350,16630.5,'approved',1),(27,'2019-12-15 16:00:34',NULL,NULL,11,19,17,2,'published',1),(28,'2019-12-15 16:00:41',NULL,NULL,13,5013,4012,1001,'published',1),(29,'2019-12-15 16:00:54',NULL,NULL,12,6060,5050,1010,'published',1),(30,'2019-12-15 16:01:01',NULL,NULL,5,12013,10012,2001,'published',1),(31,'2019-12-15 16:01:19',NULL,NULL,4,1464.5,1160,304.5,'paid_delivered',0),(32,'2019-12-15 16:02:11',NULL,NULL,5,125,100,25,'published',1),(35,'2019-12-15 16:25:09',NULL,NULL,13,60098.5,10077,50021.5,'published',1),(36,'2019-12-15 16:28:36',NULL,NULL,7,13000,5000,8000,'unpaid_delivered',0);

/*Table structure for table `points_table` */

DROP TABLE IF EXISTS `points_table`;

CREATE TABLE `points_table` (
  `points_id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `points` int(8) unsigned NOT NULL,
  `wallet` double unsigned NOT NULL,
  PRIMARY KEY (`points_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `points_table` */

insert  into `points_table`(`points_id`,`points`,`wallet`) values (1,0,100),(2,10000,10),(3,20000,25),(4,50000,70);

/*Table structure for table `product_table` */

DROP TABLE IF EXISTS `product_table`;

CREATE TABLE `product_table` (
  `product_id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `product_name` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `unit` varchar(20) NOT NULL,
  `purchase_price` double NOT NULL,
  `wholesale_price` double NOT NULL,
  `retail_price` double NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `product_table` */

insert  into `product_table`(`product_id`,`product_name`,`type`,`unit`,`purchase_price`,`wholesale_price`,`retail_price`) values (9,'IPHONEX','手机','盒',1000,6000,7000),(10,'IPHONE8','手机','盒',4000,5000,6000),(11,'货品1','衣服','件',12,13,16),(12,'货品2','食品','包',5,6,7.5),(13,'DELL电脑','电脑','盒',10000,12000,15000),(14,'薯片','食品','包',5,5.5,6),(15,'电话卡','虚拟','张',40,45,50),(16,'键盘','办公','个',50,60,80),(17,'台灯','办公','个',60,80,100),(18,'鼠标','办公','个',50,55.5,60),(19,'手柄','游戏','只',200,300,320),(20,'111','11','包',10,13,16.5);

/*Table structure for table `staff_table` */

DROP TABLE IF EXISTS `staff_table`;

CREATE TABLE `staff_table` (
  `staff_id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `dismiss` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `staff_table` */

insert  into `staff_table`(`staff_id`,`staff_name`,`role`,`pass`,`dismiss`) values (1,'fan','boss','fan',0),(4,'xia','staff','123123',0),(5,'hang','manager','123456',0),(6,'jingli','manager','123456',0),(7,'dianyuan1','staff','123456',0),(8,'dianyuan2','staff','123456',0),(9,'经理','manager','123456',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
