-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: BookSnippetsHub
-- ------------------------------------------------------
-- Server version	8.0.16

use TheGreatObject;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fromopenid` varchar(40) NOT NULL,
  `toopenid` varchar(40) NOT NULL,
  `msg` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4 ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (1,'0','83f9e43e-7a9a-4326-a90c-9b98bfc979fc','注册成功，欢迎您'),(67,'owh1O5ckqseCFh8ZDmT6mpA7zpPQ','owh1O5ckqseCFh8ZDmT6mpA7zpPQ','雨过天晴、彩虹不在喜欢了你的分享');
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wxaccount`
--

DROP TABLE IF EXISTS `wxaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `wxaccount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openId` varchar(40) NOT NULL,
  `session_key` varchar(25) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `avatarUrl` varchar(300) DEFAULT NULL,
  `encodedPassword` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `openId` (`openId`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8mb4 ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wxaccount`
--

LOCK TABLES `wxaccount` WRITE;
/*!40000 ALTER TABLE `wxaccount` DISABLE KEYS */;
INSERT INTO `wxaccount` VALUES (16,'owh1O5ckqseCFh8ZDmT6mpA7zpPQ','','雨过天晴、彩虹不在','1','Chengde','Hebei','China','https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eq7jPmQqBsraAtkzlJ3HicM5Occ95LNjiapOJKvAJHeZhwOhgsq0XNIfKfgiamgGfLfysaIwwDaeUygg/132',NULL),(127,'83f9e43e-7a9a-4326-a90c-9b98bfc979fc',NULL,'1111',NULL,NULL,NULL,NULL,NULL,'$2a$10$pkdFZ/DVs66NoIXk6KohDuSQxQDBJ66oBuMTYuRRUIjWa5BuecrN2');
/*!40000 ALTER TABLE `wxaccount` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-18  5:27:26

