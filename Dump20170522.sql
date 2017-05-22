CREATE DATABASE  IF NOT EXISTS `costumerregistry` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_danish_ci */;
USE `costumerregistry`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
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
  UNIQUE KEY `idCostumer_UNIQUE` (`idCostumer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `costumer_deleted`
--

DROP TABLE IF EXISTS `costumer_deleted`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `costumer_deleted` (
  `idCostumer` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `Customer_name` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `Costumer_adress` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `Customer_date` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `Costumer_Debitor` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `Costumer_payment` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`idCostumer`),
  UNIQUE KEY `idCostumer_UNIQUE` (`idCostumer`),
  UNIQUE KEY `Costumer_Debitor_UNIQUE` (`Costumer_Debitor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `debitor`
--

DROP TABLE IF EXISTS `debitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `debitor` (
  `iddebitor` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `debitor_navn` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  `debitor_kontakt_tlf` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  PRIMARY KEY (`iddebitor`),
  UNIQUE KEY `iddebitor_UNIQUE` (`iddebitor`),
  CONSTRAINT `debitor_costumer_idCostumer_fk` FOREIGN KEY (`iddebitor`) REFERENCES `costumer` (`idCostumer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `faktura`
--

DROP TABLE IF EXISTS `faktura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faktura` (
  `faktura_nr.` int(11) NOT NULL AUTO_INCREMENT,
  `total_beløb` decimal(9,2) NOT NULL,
  `faktura_dato` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `idCostumer` varchar(40) COLLATE utf8_danish_ci NOT NULL,
  PRIMARY KEY (`faktura_nr.`),
  UNIQUE KEY `faktura_nr._UNIQUE` (`faktura_nr.`),
  KEY `faktura_costumer_idCostumer_fk` (`idCostumer`),
  CONSTRAINT `faktura_costumer_idCostumer_fk` FOREIGN KEY (`idCostumer`) REFERENCES `costumer` (`idCostumer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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

-- Dump completed on 2017-05-22 10:56:46
