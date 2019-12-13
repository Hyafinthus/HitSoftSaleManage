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
  `client_id` int(8) NOT NULL AUTO_INCREMENT,
  `client_name` varchar(20) NOT NULL,
  `sex` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(40) NOT NULL,
  `points` int(8) NOT NULL DEFAULT '0',
  `wholesale_client` tinyint(1) DEFAULT NULL,
  `retail_client` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `client_table` */

insert  into `client_table`(`client_id`,`client_name`,`sex`,`phone`,`address`,`points`,`wholesale_client`,`retail_client`) values (1,'皮皮虾','男','11122223333','HIT 9公寓 404',404,1,0),(2,'镇皮大将军','男','11133334444','HIT 9公寓 404',123,0,1),(3,'牟老师','男','11144445555','HIT 2公寓 610',233,1,1);

/*Table structure for table `depot_prod_table` */

DROP TABLE IF EXISTS `depot_prod_table`;

CREATE TABLE `depot_prod_table` (
  `depot_prod_pri` int(8) NOT NULL AUTO_INCREMENT,
  `depot_name` varchar(20) NOT NULL,
  `product_id` int(8) NOT NULL,
  `count` int(8) unsigned NOT NULL,
  PRIMARY KEY (`depot_prod_pri`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `depot_prod_table` */

insert  into `depot_prod_table`(`depot_prod_pri`,`depot_name`,`product_id`,`count`) values (1,'仓库',1,40),(2,'门店',1,31),(3,'仓库',2,20),(4,'门店',3,5),(5,'仓库',3,0),(6,'门店',2,0);

/*Table structure for table `order_prod_table` */

DROP TABLE IF EXISTS `order_prod_table`;

CREATE TABLE `order_prod_table` (
  `order_prod_pri` int(8) NOT NULL AUTO_INCREMENT,
  `order_id` int(8) NOT NULL,
  `product_id` int(8) NOT NULL,
  `count` int(8) DEFAULT NULL,
  PRIMARY KEY (`order_prod_pri`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `order_prod_table` */

insert  into `order_prod_table`(`order_prod_pri`,`order_id`,`product_id`,`count`) values (1,1,1,3),(2,1,2,4),(3,1,3,2);

/*Table structure for table `order_table` */

DROP TABLE IF EXISTS `order_table`;

CREATE TABLE `order_table` (
  `order_id` int(8) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `return_time` datetime DEFAULT NULL,
  `client_id` int(8) DEFAULT NULL,
  `order_sale_price` double DEFAULT NULL COMMENT '售价',
  `order_purchase_price` double DEFAULT NULL COMMENT '进价',
  `order_profit` double DEFAULT NULL COMMENT '毛利',
  `state` varchar(20) NOT NULL,
  `wholesale_order` tinyint(1) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `order_table` */

insert  into `order_table`(`order_id`,`create_time`,`pay_time`,`return_time`,`client_id`,`order_sale_price`,`order_purchase_price`,`order_profit`,`state`,`wholesale_order`) values (1,'2015-12-08 14:34:46',NULL,NULL,1,12,10,2,'published',1),(2,'2015-12-09 14:34:46',NULL,NULL,2,33,14,19,'published',1),(3,'2015-12-10 14:34:46',NULL,NULL,1,23,20,3,'published',1),(4,'2015-12-11 14:34:46',NULL,NULL,2,34,33,1,'published',1),(5,'2015-12-12 14:34:46',NULL,NULL,1,25,20,5,'published',1),(6,'2015-12-13 14:34:46',NULL,NULL,1,26,20,6,'published',1),(7,'2015-12-14 14:34:46',NULL,NULL,2,56,50,6,'published',1),(8,'2015-12-15 14:34:46',NULL,NULL,2,16,8,8,'published',1),(9,'2015-12-16 14:34:46',NULL,NULL,2,16,9,7,'published',1),(10,'2015-12-16 14:34:46',NULL,NULL,1,46,39,7,'published',1),(11,'2015-12-17 14:34:46',NULL,NULL,1,67,56,11,'published',1),(12,'0000-00-00 00:00:00',NULL,NULL,1,68,56,12,'published',1);

/*Table structure for table `product_table` */

DROP TABLE IF EXISTS `product_table`;

CREATE TABLE `product_table` (
  `product_id` int(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `unit` varchar(20) NOT NULL,
  `purchase_price` double NOT NULL,
  `wholesale_price` double NOT NULL,
  `retail_price` double NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `product_table` */

insert  into `product_table`(`product_id`,`product_name`,`type`,`unit`,`purchase_price`,`wholesale_price`,`retail_price`) values (1,'货品1','食品','包',3,4,5),(2,'货品2','衣服','件',50,60,70),(3,'货品3','玩具','个',100,120,140);

/*Table structure for table `staff_table` */

DROP TABLE IF EXISTS `staff_table`;

CREATE TABLE `staff_table` (
  `staff_id` int(8) NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `dismiss` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `staff_table` */

insert  into `staff_table`(`staff_id`,`staff_name`,`role`,`pass`,`dismiss`) values (1,'fan','boss','fan',0),(2,'jingli','manager','123',0),(3,'dianyuan','staff','123',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
