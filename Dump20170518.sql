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
  `Customer_date` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `Costumer_Debitor` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `Costumer_payment` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`idCostumer`),
  UNIQUE KEY `idCostumer_UNIQUE` (`idCostumer`),
  UNIQUE KEY `Costumer_Debitor_UNIQUE` (`Costumer_Debitor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costumer`
--

LOCK TABLES `costumer` WRITE;
/*!40000 ALTER TABLE `costumer` DISABLE KEYS */;
INSERT INTO `costumer` VALUES ('32','sfoij','sspoj','45','324','25'),('324','fsfm','sefpm','312','4234','gpom');
/*!40000 ALTER TABLE `costumer` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `costumer_deleted`
--

LOCK TABLES `costumer_deleted` WRITE;
/*!40000 ALTER TABLE `costumer_deleted` DISABLE KEYS */;
/*!40000 ALTER TABLE `costumer_deleted` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `debitor`
--

DROP TABLE IF EXISTS `debitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `debitor` (
  `iddebitor` int(10) NOT NULL,
  `debitor_navn` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  `debitor_kontakt_tlf` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `debitor_kontakt_navn` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`iddebitor`),
  UNIQUE KEY `iddebitor_UNIQUE` (`iddebitor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `debitor`
--

LOCK TABLES `debitor` WRITE;
/*!40000 ALTER TABLE `debitor` DISABLE KEYS */;
/*!40000 ALTER TABLE `debitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faktura`
--

DROP TABLE IF EXISTS `faktura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faktura` (
  `faktura_nr.` int(11) NOT NULL AUTO_INCREMENT,
  `faktura_beskrivelse` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  `total_beløb` decimal(9,2) NOT NULL,
  `produkt_type` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `faktura_dato` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  PRIMARY KEY (`faktura_nr.`),
  UNIQUE KEY `faktura_nr._UNIQUE` (`faktura_nr.`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faktura`
--

LOCK TABLES `faktura` WRITE;
/*!40000 ALTER TABLE `faktura` DISABLE KEYS */;
/*!40000 ALTER TABLE `faktura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `idproducts` int(10) NOT NULL,
  `product_name` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `product_price` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  PRIMARY KEY (`idproducts`),
  UNIQUE KEY `idproducts_UNIQUE` (`idproducts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `idsupplier` int(15) NOT NULL,
  `supplier_name` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `supplier_country` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `supplier_contact` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  `supplier_adress` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`idsupplier`),
  UNIQUE KEY `idsupplier_UNIQUE` (`idsupplier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-18 11:12:54
