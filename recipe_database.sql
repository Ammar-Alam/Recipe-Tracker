-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: recipe-tracker-dsa-final-project.cxtu85cyfiz1.us-east-2.rds.amazonaws.com    Database: recipe_database
-- ------------------------------------------------------
-- Server version	8.0.23

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipes` (
  `recipe_id` int NOT NULL AUTO_INCREMENT,
  `recipe_name` varchar(100) NOT NULL,
  `recipe_category` enum('Breakfast','Lunch','Dinner','Snack') NOT NULL,
  `ingredients` text,
  `description` tinytext,
  `procedure` mediumtext,
  PRIMARY KEY (`recipe_name`),
  UNIQUE KEY `recipe_id_UNIQUE` (`recipe_id`),
  UNIQUE KEY `recipe_name_UNIQUE` (`recipe_name`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (30,'ANTS ON A LOG','Snack',NULL,'Celery stick with peanut butter and raisins inside. Favorite of children and anteaters.',NULL),(36,'APPLE','Breakfast',NULL,'Simple red fruit. Sweet, but sometimes sour. An ideal offering for teachers.',NULL),(29,'APPLE PIE','Snack',NULL,'apple pie is a tasty dessert',NULL),(13,'BAKED POTATO','Dinner',NULL,'A simple but filling meal. High in vitamins and low in calories. Irish favorite.',NULL),(38,'BAKED SALMON','Dinner',NULL,'One of my personal favorites. Like a water steak.',NULL),(33,'BURGER','Lunch',NULL,'Fast food never tasted so good. Some form of animal fried and stuffed between two round buns.',NULL),(40,'BUTTERSCOTCH PIE','Lunch',NULL,'I\'m an adult now. No one can stop me from having dessert for lunch. Try and stop me.',NULL),(12,'CARROTS','Snack',NULL,'A healthier way to eat something crunchy',NULL),(37,'CEREAL','Breakfast',NULL,'Add cereal THEN milk, NOT milk then cereal',NULL),(11,'CHIPS','Snack',NULL,'Tasty but unhealthy, chips are a great time waster',NULL),(41,'EGG SANDWICH','Breakfast',NULL,'Like McDonald\'s, but not copyright material',NULL),(44,'GRAPEFRUIT','Breakfast',NULL,'Sweet and orange, but pink on the inside.',NULL),(42,'GRILLED CHEESE','Lunch',NULL,'Sometimes, I dream about cheese',NULL),(35,'LASAGNA','Dinner',NULL,'Like pasta, but with cheese and other goodies. Garfield\'s favorite.',NULL),(8,'OATMEAL','Breakfast',NULL,'Oatmeal is an easy, flexible breakfast that can be made in a microwave or in a corner.',NULL),(34,'PASTA','Dinner',NULL,'Probably Italian. High carb and comes in many shapes. Deceptive.',NULL),(25,'PIZZA','Lunch',NULL,'A greasy yet tasty triangle of health.',NULL),(39,'SALAD','Lunch',NULL,'Next time, eat a salad.',NULL),(31,'SODA','Snack',NULL,'Fizzy water, but with lots of color and LOTS of sugar. Very bad for you, but some like the sting.',NULL),(28,'SPARKLING WATER','Snack',NULL,'Not exactly a snack, but makes you gassy enough to think you\'re full',NULL),(43,'TOAST','Breakfast',NULL,'Basic and buttery. Not allowed in space.',NULL);
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-07  2:17:25
