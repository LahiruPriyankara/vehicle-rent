-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vehicle_rent
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `conditions` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `perDay` varchar(255) DEFAULT NULL,
  `perKm` varchar(255) DEFAULT NULL,
  `rate` varchar(255) DEFAULT NULL,
  `vNumber` varchar(255) DEFAULT NULL,
  `vType` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_l6r17yh6ca1wd5mbvecq3la6o` (`user_id`),
  CONSTRAINT `FK_l6r17yh6ca1wd5mbvecq3la6o` FOREIGN KEY (`user_id`) REFERENCES `appuser` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (1,'AC/TV/AUDIO','UIMGE6B7154B1E','Toyota-KDH','2000','40','','ADC-4555','VAN',1),(2,'AC/AUDIO','UIMG39F5163125','wagon r','4000','55','','ADC-4055','CAR',2),(3,'AUDIO','UIMG690F8F11C6','MARUTI','1000','20','','AFC-4005','CAR',2),(4,'AC/TV/AUDIO','UIMGC30CEDB73B','FIT','2500','45','','ADC-4001','CAR',3),(5,'AUDIO','UIMG94DC6430BC','ROSA','2550','20','','KD-0555','BUS',3),(6,'AC/TV/AUDIO','UIMG1C4AB59A00','wagon r','1250','25','','ADC-0005','CAR',3),(7,'AC/TV/AUDIO','UIMG6C1B3F6920','VITZ','3500','30','','AFC-4005','CAR',4),(8,'AC/TV/AUDIO','UIMGBE76D195E3','','2333','30','5','AFC-4005','VAN',1),(9,'AC/TV/AUDIO','UIMG18C440DF12','vizel','5000','30','','AFC-4005','CAR',6),(10,'AC/TV/AUDIO','UIMGFAF0CAC7C7','bajaj','1233','30','','AFC-4005','THREE WEELER',6),(12,'AC/TV/AUDIO','UIMG59BF7E91CE','CHR','5000','30','','AFC-4555','CAR',9),(13,'AC/AUDIO','UIMG65742B8A53','civic','6000','30','','AFC-4055','CAR',9);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-24 10:17:49
