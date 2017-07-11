-- MySQL dump 10.13  Distrib 5.6.27, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: inventory
-- ------------------------------------------------------
-- Server version	5.6.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;



/*Databases are named like eg: hms_service_hub
Tables are named as eg: system_permission
Table fields named as eg: register_date
 */





--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `EmployeeNo` char(100) DEFAULT NULL,
  `IndexNo` int(5) NOT NULL AUTO_INCREMENT,
  `EmployeeName` varchar(20) DEFAULT NULL,
  `Position` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`IndexNo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('HMSK/SE/2013/005',1,'Udara','SE'),('HMSK/SSE/2013/004',2,'Sadupa','SSE'),('',3,'',''),('rtgrr856',4,'tfhytf6541','ghjhgj'),('hhhj',5,'uk654','gjj'),('jkj66',6,'6jhk6','6jhkjkjh'),('fghgfh457',7,'fhfgh7574','ggtgt');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `ItemNo` char(100) DEFAULT NULL,
  `IndexNo` int(5) NOT NULL AUTO_INCREMENT,
  `ItemName` varchar(20) DEFAULT NULL,
  `ItemType` varchar(30) DEFAULT NULL,
  `Assignation` int(20) DEFAULT NULL,
  PRIMARY KEY (`IndexNo`),
  KEY `Assignation` (`Assignation`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`Assignation`) REFERENCES `employee` (`IndexNo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES ('HMSK/2012/06/PC/001',1,'cpu','computer equipment',1),('HMSK/2012/06/PC/005',2,'monitor','computer equipment',1),('HMSK/2017/06/KIT/004',6,'nescafe','kitchen',2),('HMSK/2010/06/PC/008',8,'monitor','computer equipment',NULL),('cbg35135',9,'ghfh544','gfgf',NULL),('jhkj54',10,'kjkh84','ukhuikuh84',NULL),('oooooo',11,'oooo1111','gggggg',NULL);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-11 13:22:56
