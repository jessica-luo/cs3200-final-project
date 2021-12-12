-- MySQL dump 10.13  Distrib 8.0.26, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: db_final_project
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Alice','Smith','alice','passwordddd','alicesmith12@gmail.com','2001-11-21','2021-11-22 20:47:30','2021-12-05 23:28:56'),(2,'Hannah','Ellis','hannah','qwerty1234','hannah@neu.edu','2001-04-03','2021-11-22 20:47:30','2021-12-05 22:44:28'),(3,'Bob','Johnson','robertj','foobar','bob@ccis.neu.edu','1944-12-22','2021-11-22 20:47:30','2021-12-05 22:44:36'),(4,'Sebastian','Toledo','language_bee','gameramogus','seabass@neu.edu','2001-12-20','2021-11-22 20:47:30','2021-12-05 22:44:45'),(5,'Euann','Gu','remaya','toogood2go','gene@gmail.com','2002-12-12','2021-11-22 20:47:30','2021-12-05 22:44:52'),(6,'Radhika','Shivaprasad','radish','ggg2000','radhika@outlook.com','2002-11-23','2021-11-22 20:47:30','2021-12-05 22:44:57'),(7,'Vicky','Adebiyi','imjumokay','RM4lyfe','vadebiyi@gmail.com','2001-12-28','2021-11-22 20:47:30','2021-12-05 22:45:03'),(8,'Jose','Annunziato','jannunzi','elonmusk','jannunzi@ccis.neu.edu','1970-02-14','2021-11-22 20:47:30','2021-12-05 22:45:14'),(10,'Kelly','Ward','kellyw19','cs3200','ward.kelly1@northeastern.edu','2001-01-20',NULL,'2021-12-05 22:45:25'),(11,'Jessica','Luo','jluo','qwertyuiop','luo.jes@northeastern.edu','2001-12-09',NULL,'2021-12-05 22:45:32'),(12,'Hannah','Lauterwasser','hlauterwasser','1234','lauterwasser.h@northeastern.edu','1999-04-14',NULL,'2021-12-06 21:09:54');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-12  1:53:01
