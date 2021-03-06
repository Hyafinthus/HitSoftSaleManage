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
  `pass` varchar(20) NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `client_table` */

insert  into `client_table`(`client_id`,`client_name`,`sex`,`phone`,`address`,`points`,`wallet`,`pass`) values (1,'零售客户','','','',0,0,''),(18,'皮皮虾','男','15545460000','HIT 9-404',5682140,0,'axiashigedashagua'),(19,'白晶晶','女','18722223142','盘丝洞',5063140,945170.6,'123456'),(20,'至尊宝','男','13978628765','花果山',892450,0,'123456'),(21,'敖烈','男','18167540987','西海龙宫',0,0,'123456'),(22,'叶问','男','16155251111','佛山',0,0,'123456'),(23,'悟能','男','18567862534','高老庄',672360,0,'123456098'),(24,'宫二','女','18276540987','大南戏园子',10293870,0,'123456'),(25,'范国祥','男','11188888888','HIT',1031909,0,'123456'),(26,'撒贝宁','男','13344445555','俺也不知道',0,0,'123456'),(27,'霍元甲','男','18732572109','津门精武门',0,0,'123456'),(28,'玄奘','男','13765472322','东土大唐',0,0,'123456'),(29,'奥术球','男','18145640329','加基森',0,100,'12345678');

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
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `depot_in_table` */

insert  into `depot_in_table`(`depot_in_pri`,`product_id`,`count`,`in_price`,`depot_name`,`time`) values (24,21,10,7000,'仓库','2018-05-28 22:02:17'),(25,21,5,8000,'门店','2018-06-04 22:02:25'),(26,22,10,1500,'仓库','2018-11-08 22:02:32'),(27,22,10,1600,'门店','2018-12-28 22:02:40'),(28,23,10,4000,'仓库','2018-01-30 22:02:57'),(29,23,2,3000,'门店','2018-03-28 22:03:03'),(30,24,2000,20.5,'仓库','2018-07-06 22:03:21'),(31,24,1000,20,'门店','2018-08-19 22:03:29'),(32,25,20,504.5,'仓库','2019-03-28 22:04:23'),(33,26,200,120.6,'仓库','2019-04-08 22:04:41'),(34,27,10,90,'仓库','2019-06-22 22:04:51'),(35,28,11,99,'仓库','2019-09-18 22:05:06'),(36,29,60,99,'仓库','2019-11-21 22:05:18'),(37,30,200,33,'仓库','2019-07-12 22:05:29'),(38,33,600,50.6,'仓库','2019-09-09 22:05:46'),(39,32,200,1.9,'门店','2019-09-28 22:05:59'),(40,34,9,800,'仓库','2019-02-26 22:06:07'),(41,31,8,69.8,'仓库','2019-12-28 22:06:43'),(42,21,10,8000,'仓库','2019-12-29 17:13:07');

/*Table structure for table `depot_prod_table` */

DROP TABLE IF EXISTS `depot_prod_table`;

CREATE TABLE `depot_prod_table` (
  `depot_prod_pri` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `depot_name` varchar(20) NOT NULL,
  `product_id` int(8) unsigned NOT NULL,
  `count` int(8) unsigned NOT NULL,
  PRIMARY KEY (`depot_prod_pri`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

/*Data for the table `depot_prod_table` */

insert  into `depot_prod_table`(`depot_prod_pri`,`depot_name`,`product_id`,`count`) values (37,'仓库',21,13),(38,'门店',21,5),(39,'仓库',22,1),(40,'门店',22,2),(41,'仓库',23,10),(42,'门店',23,0),(43,'仓库',24,1779),(44,'门店',24,853),(45,'仓库',25,13),(46,'门店',25,0),(47,'仓库',26,199),(48,'门店',26,0),(49,'仓库',27,8),(50,'门店',27,4),(51,'仓库',28,3),(52,'门店',28,2),(53,'仓库',29,60),(54,'门店',29,14),(55,'仓库',30,200),(56,'门店',30,100),(57,'仓库',31,3),(58,'门店',31,3),(59,'仓库',32,67),(60,'门店',32,131),(61,'仓库',33,600),(62,'门店',33,0),(63,'仓库',34,5),(64,'门店',34,3);

/*Table structure for table `order_prod_table` */

DROP TABLE IF EXISTS `order_prod_table`;

CREATE TABLE `order_prod_table` (
  `order_prod_pri` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(8) unsigned NOT NULL,
  `product_id` int(8) unsigned NOT NULL,
  `count` int(8) unsigned NOT NULL,
  `bonus` tinyint(1) NOT NULL DEFAULT '0',
  `purchase_price` double NOT NULL,
  PRIMARY KEY (`order_prod_pri`)
) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=utf8;

/*Data for the table `order_prod_table` */

insert  into `order_prod_table`(`order_prod_pri`,`order_id`,`product_id`,`count`,`bonus`,`purchase_price`) values (103,48,21,1,0,7333.333333333333),(104,48,27,2,0,90),(105,48,28,2,0,99),(106,48,30,1,1,33),(107,48,32,1,0,1.9),(108,48,31,1,0,69.8),(109,48,34,1,0,800),(110,49,26,120,0,120.6),(111,49,28,6,0,99),(112,49,29,35,0,99),(113,49,32,4,0,1.9),(114,49,31,3,0,69.8),(115,49,34,1,0,800),(116,49,24,1,1,20.333333333333332),(117,50,22,10,0,1550),(118,50,21,1,0,7333.333333333333),(119,50,28,1,0,99),(120,51,22,10,0,1550),(121,51,23,12,0,3833.3333333333335),(122,52,30,100,0,33),(123,52,29,14,0,99),(124,52,27,4,0,90),(125,52,28,2,0,99),(126,53,25,5,0,504.5),(127,53,24,1,0,20.333333333333332),(128,53,29,49,0,99),(129,53,30,3,0,33),(130,53,33,1,0,50.6),(131,53,31,2,0,69.8),(132,54,23,1,0,3833.3333333333335),(133,54,24,134,0,20.333333333333332),(134,54,29,1,0,99),(135,55,24,1,0,20.333333333333332),(136,55,29,1,0,99),(137,56,25,1,0,504.5),(138,56,24,1,0,20.333333333333332),(139,56,27,1,0,90),(140,57,21,1,0,7333.333333333333),(141,58,28,1,0,99),(142,58,25,1,0,504.5),(143,58,26,1,0,120.6),(144,59,24,1,0,20.333333333333332),(145,59,25,1,0,504.5),(146,59,28,1,0,99),(147,59,22,1,0,1550),(148,60,22,1,0,1550),(149,60,25,1,0,504.5),(150,60,29,1,0,99),(152,62,28,5,0,99),(153,63,21,2,0,7333.333333333333),(154,63,22,2,0,1550),(155,63,23,1,0,3833.3333333333335),(156,64,21,1,0,7333.333333333333),(157,64,22,1,0,1550),(158,65,28,1,0,99),(159,65,25,1,0,504.5),(160,66,32,1,0,1.9),(161,67,24,220,0,20.333333333333332),(162,67,32,1,1,1.9),(163,68,28,7,0,99),(164,69,22,1,0,1550),(165,70,21,1,0,7333.333333333333),(166,70,22,1,0,1550),(167,71,22,1,0,1550),(168,71,24,1,0,20.333333333333332),(169,72,24,5,0,20.333333333333332),(178,75,22,10,0,1550),(179,75,26,1,0,120.6),(180,75,27,1,0,90),(181,76,27,1,1,90),(182,76,25,1,0,504.5),(183,76,24,1,0,20.333333333333332),(184,77,23,1,0,3833.3333333333335),(185,78,24,4,0,20.333333333333332),(186,78,25,1,0,504.5);

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
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

/*Data for the table `order_table` */

insert  into `order_table`(`order_id`,`create_time`,`pay_time`,`return_time`,`client_id`,`order_sale_price`,`order_purchase_price`,`order_profit`,`state`,`wholesale_order`) values (48,'2018-11-02 22:09:02','2019-12-28 22:23:49',NULL,25,10319.099999999999,8616.033333333333,1703.0666666666657,'paid_delivered',1),(49,'2018-02-14 22:09:40','2019-12-28 22:23:55',NULL,24,30633.7,19568.333333333332,11065.366666666669,'paid_delivered',1),(50,'2018-03-11 22:19:40','2019-12-28 22:23:56',NULL,18,28417,22932.333333333332,5484.666666666668,'paid_delivered',1),(51,'2018-03-08 22:20:40','2019-12-28 22:23:46',NULL,24,72305,61500,10805,'paid_delivered',1),(52,'2018-08-21 22:21:00','2019-12-28 22:23:58','2019-12-29 17:28:24',23,6723.6,5244,1479.6000000000004,'returned',1),(53,'2018-09-19 22:21:08','2019-12-28 22:23:54',NULL,20,8924.5,7683.033333333335,1241.4666666666653,'paid_delivered',1),(54,'2019-06-06 22:21:18',NULL,NULL,1,10019.2,6657,3362.2000000000007,'paid_delivered',0),(55,'2019-07-21 22:21:24',NULL,NULL,1,210.20000000000002,152.33333333333331,57.8666666666667,'paid_delivered',0),(56,'2019-03-09 22:21:32',NULL,NULL,1,845.3,614.8333333333334,230.46666666666658,'paid_delivered',0),(57,'2019-05-08 22:27:10',NULL,NULL,1,9000,7333.333333333333,1666.666666666667,'paid_delivered',0),(58,'2019-10-01 22:27:36',NULL,NULL,1,5614.8,4577.766666666666,1037.0333333333338,'paid_delivered',0),(59,'2019-04-28 22:27:54',NULL,NULL,1,2864.8,2173.8333333333335,690.9666666666667,'paid_delivered',0),(60,'2019-12-13 22:28:28',NULL,NULL,1,3169.9,2343.9,826,'paid_delivered',0),(62,'2019-12-25 23:46:06','2019-12-29 16:22:54',NULL,19,560,495,65,'paid_delivered',1),(63,'2019-12-18 12:17:03',NULL,NULL,19,26498,21599.999999999996,4898.000000000004,'paid_delivered',1),(64,'2019-12-03 16:14:53',NULL,NULL,19,10999.5,8883.333333333332,2116.166666666668,'paid_delivered',1),(65,'2019-12-11 16:15:05',NULL,NULL,19,825,603.5,221.5,'paid_delivered',1),(66,'2019-12-06 16:16:11',NULL,NULL,19,3,1.9,1.1,'paid_delivered',1),(67,'2019-12-23 16:21:46','2019-12-29 16:23:01',NULL,18,7810,4475.233333333333,3334.7666666666673,'paid_delivered',1),(68,'2019-12-28 16:23:10','2019-12-29 16:23:27',NULL,18,784,693,91,'paid_undelivered',1),(69,'2019-08-29 16:34:00',NULL,NULL,19,1999.5,1550,449.5,'paid_delivered',1),(70,'2019-01-29 16:36:16',NULL,NULL,19,10999.5,8883.333333333332,2116.166666666668,'paid_delivered',1),(71,'2019-07-29 16:39:22',NULL,NULL,19,2039.8,1570.3333333333333,469.4666666666667,'paid_delivered',1),(72,'0000-00-00 00:00:00',NULL,NULL,19,201.5,101.66666666666666,99.83333333333334,'paid_delivered',1),(75,'2019-12-29 17:17:46','2019-12-29 17:22:35',NULL,18,19810.4,15710.6,4099.800000000001,'paid_delivered',1),(76,'2019-12-29 17:20:54','2019-12-29 17:22:13',NULL,19,644.4,614.8333333333334,29.566666666666606,'paid_delivered',1),(77,'2019-12-29 17:29:24',NULL,NULL,18,4400,3833.3333333333335,566.6666666666665,'published',1),(78,'2019-12-29 17:33:08',NULL,NULL,19,861.2,585.8333333333334,275.3666666666667,'paid_delivered',1);

/*Table structure for table `points_table` */

DROP TABLE IF EXISTS `points_table`;

CREATE TABLE `points_table` (
  `points_id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `points` int(8) unsigned NOT NULL,
  `wallet` double unsigned NOT NULL,
  PRIMARY KEY (`points_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `points_table` */

insert  into `points_table`(`points_id`,`points`,`wallet`) values (1,0,100),(8,50000,70),(9,20000,25),(10,10000,10);

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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `product_table` */

insert  into `product_table`(`product_id`,`product_name`,`type`,`unit`,`purchase_price`,`wholesale_price`,`retail_price`) values (21,'IPHONEX','手机','盒',7666.666666666666,8800,9000),(22,'小米9SE','手机','盒',1550,1950.5,1999.5),(23,'IPHONE4','手机','盒',3833.3333333333335,4400,4499),(24,'清风原木纯品','抽纸','包',20.333333333333332,35.5,40.3),(25,'腾讯蓝牙音箱','电子产品','件',504.5,608.9,700),(26,'飞利浦台灯','办公用品','台',120.6,206.5,250.5),(27,'JAVA核心技术-上','图书','本',90,98.9,105),(28,'JAVA核心技术-下','图书','本',99,112,125),(29,'DELL键盘','电脑耗材','件',99,111,120),(30,'小米活塞耳机','电子产品','只',33,45.5,49.9),(31,'罗技鼠标','电子产品','只',69.8,95.5,99.9),(32,'百事可乐','饮料','瓶',1.9,2.8,3),(33,'百事可乐','饮料','箱',50.6,78,86),(34,'Bose耳机','电子产品','只',800,999,1099);

/*Table structure for table `staff_table` */

DROP TABLE IF EXISTS `staff_table`;

CREATE TABLE `staff_table` (
  `staff_id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `dismiss` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `staff_table` */

insert  into `staff_table`(`staff_id`,`staff_name`,`role`,`pass`,`dismiss`) values (1,'fan','boss','fan',0),(4,'xia','staff','123123',0),(5,'hang','manager','123123',0),(11,'jingli','manager','123123',0),(12,'dianyuan','staff','123456',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
