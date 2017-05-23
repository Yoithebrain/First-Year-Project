CREATE DATABASE  IF NOT EXISTS `costumerregistry` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_danish_ci */;
USE `costumerregistry`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: costumerregistry
-- ------------------------------------------------------
-- Server version	5.7.17-log

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

--
-- Table structure for table `costumer`
--

DROP TABLE IF EXISTS `costumer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `costumer` (
  `idCostumer` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `Customer_name` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `Costumer_adress` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `iddebitor` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  PRIMARY KEY (`idCostumer`),
  UNIQUE KEY `idCostumer_UNIQUE` (`idCostumer`),
  KEY `test_idx` (`iddebitor`),
  CONSTRAINT `fk_iddebitor` FOREIGN KEY (`iddebitor`) REFERENCES `debitor` (`iddebitor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costumer`
--

LOCK TABLES `costumer` WRITE;
/*!40000 ALTER TABLE `costumer` DISABLE KEYS */;
INSERT INTO `costumer` VALUES ('42342','wrijj','psfjpj','447');
/*!40000 ALTER TABLE `costumer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `debitor`
--

DROP TABLE IF EXISTS `debitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `debitor` (
  `iddebitor` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `debitor_navn` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  `debitor_kontakt_tlf` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  UNIQUE KEY `iddebitor_UNIQUE` (`iddebitor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `debitor`
--

LOCK TABLES `debitor` WRITE;
/*!40000 ALTER TABLE `debitor` DISABLE KEYS */;
INSERT INTO `debitor` VALUES ('35434',NULL,NULL),('447',NULL,NULL);
/*!40000 ALTER TABLE `debitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faktura`
--

DROP TABLE IF EXISTS `faktura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faktura` (
  `fakturaNr` varchar(40) COLLATE utf8_danish_ci NOT NULL,
  `total_beløb` decimal(9,2) NOT NULL,
  `faktura_dato` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `idCostumer` varchar(40) COLLATE utf8_danish_ci NOT NULL,
  PRIMARY KEY (`fakturaNr`),
  UNIQUE KEY `faktura_nr._UNIQUE` (`fakturaNr`),
  KEY `faktura_costumer_idCostumer_fk` (`idCostumer`),
  CONSTRAINT `faktura_costumer_idCostumer_fk` FOREIGN KEY (`idCostumer`) REFERENCES `costumer` (`idCostumer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faktura`
--

LOCK TABLES `faktura` WRITE;
/*!40000 ALTER TABLE `faktura` DISABLE KEYS */;
INSERT INTO `faktura` VALUES ('13124',4345.00,'5756','42342');
/*!40000 ALTER TABLE `faktura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'costumerregistry'
--

--
-- Dumping routines for database 'costumerregistry'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-23 10:25:48
