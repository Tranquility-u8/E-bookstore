-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `book_id` int NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `inventory` int DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `origin_price` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'鍑疭.闇嶆柉鐗规浖','Java鏍稿績鎶€鏈嵎II','鏈功鏄疛ava棰嗗煙鏈夊奖鍝嶅姏鍜屼环鍊肩殑钁椾綔涔嬩竴锛岀敱鎷ユ湁20澶氬勾鏁欏涓庣爺绌剁粡楠岀殑Java鎶€鏈笓瀹舵挵鍐欙紙鑾稪olt澶у锛夛紝涓庛€奐ava缂栫▼鎬濇兂銆嬮綈鍚嶏紝10浣欏勾鍏ㄧ悆鐣呴攢涓嶈“锛屽箍鍙楀ソ璇勩€傜10鐗堟牴鎹甁avaSE8鍏ㄩ潰鏇存柊锛屽悓鏃朵慨姝ｄ簡绗?鐗堜腑鐨勪笉瓒筹紝绯荤粺鍏ㄩ潰璁茶В浜咼ava璇█鐨勬牳蹇冩蹇点€佽娉曘€侀噸瑕佺壒鎬у拰寮€鍙戞柟娉曪紝鍖呭惈澶ч噺妗堜緥锛屽疄璺垫€у己銆?,'http://img3m9.ddimg.cn/12/36/1546133799-1_w_1.jpg',784,'1',95,95,'java'),(2,'鍏板痉灏斅稥路甯冭幈鎭╃壒','娣卞叆鐞嗚В璁＄畻鏈虹郴缁?,'绋嬪簭鍛樺繀璇荤粡鍏歌憲浣滐紒鐞嗚В璁＄畻鏈虹郴缁?涔︾洰锛?0涓囩▼搴忓憳鍏卞悓閫夋嫨銆傜浜岀増閿€鍞獊鐮?00000鍐岋紝绗笁鐗堥噸纾呬笂甯傦紒','http://img3m7.ddimg.cn/48/0/24106647-1_w_6.jpg',1061,'2',137,137,'璁＄畻鏈?),(3,'姊呰€?,'Effective C++','澶у笀鍚嶈憲绾垫í浜屽崄杞斤紝绋冲眳浠讳竴鑽愪功鍗曚笁鐢诧紱绉拌亴绋嬪簭鍛樺倣韬粷瀛︼紝閫氬悜C++绮惧井濂ュ涔嬮棬銆?,'http://img3m6.ddimg.cn/96/25/21000966-1_u_12.jpg',973,'3',51,51,'c璇█'),(4,'鍦?鍩冨厠鑻忎僵閲?,'灏忕帇瀛?,'璞嗙摚9.7楂樺垎鎺ㄨ崘锛佹梾娉曠炕璇戝姊呭瓙娑典箣濂虫鎬濈箒娉曟枃鐩磋瘧锛岃垝鏈楀ぇ寮€鏈紝澶編鏁欐巿楂樼簿搴﹁繕鍘熷師浣滄彃鐢汇€傞娆℃敹褰曞叏鐞冭垶鍙板墽銆侀煶涔愪細銆佺數褰便€佸姩鐢荤墖绛夊銆婂皬鐜嬪瓙銆嬬殑绮惧僵璇犻噴锛岄€氭檽鍚嶄綔鐨勫墠涓栦粖鐢熴€?,'http://img3m9.ddimg.cn/75/6/25067469-1_u_2.jpg',993,'4',9,9,NULL),(5,'Bruce Eckel','Java缂栫▼鎬濇兂','Java瀛︿範蹇呰缁忓吀,娈垮爞绾ц憲浣滐紒璧㈠緱浜嗗叏鐞冪▼搴忓憳鐨勫箍娉涜禐瑾夈€?,'http://img3m0.ddimg.cn/4/24/9317290-1_w_5.jpg',9082,'5',91,91,NULL),(6,'鍏嬮噷鏂欐妫?,'榄斿吔涓栫晫缂栧勾鍙插瑁?鍏ㄤ笁鍗?','鏆撮洩瀹樻柟鍘嗘椂浜屽崄骞寸紪绾傝€屾垚鐨勫彶鏂欙紒涓夊嵎銆婇瓟鍏戒笘鐣岀紪骞村彶銆嬪皢鍛堢幇澶ч噺浠庢湭鍏竷鐨勭簿缇庡師鐢诲拰鎻掑浘锛岃鑰呭湪闃呰鏁呬簨涔嬩綑锛屾洿鑳戒韩鍙椾竴娆¤瑙変笂鐨勯椁洓瀹达紝鏄瓟鍏界矇涓濇敹钘忕殑浼橀€夈€?,'http://img3m7.ddimg.cn/43/9/25352557-1_w_3.jpg',110,'6',449,449,NULL);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_items`
--

DROP TABLE IF EXISTS `cart_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_items` (
  `cart_item_id` int NOT NULL,
  `amount` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `book_id` int DEFAULT NULL,
  PRIMARY KEY (`cart_item_id`),
  KEY `FKhiu1jw80o45wfiw5tgok1xpkl` (`book_id`),
  CONSTRAINT `FKhiu1jw80o45wfiw5tgok1xpkl` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_items`
--

LOCK TABLES `cart_items` WRITE;
/*!40000 ALTER TABLE `cart_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `order_item_id` int NOT NULL,
  `amount` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `book_id` int DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `FKi4ptndslo2pyfp9r1x0eulh9g` (`book_id`),
  KEY `FKbioxgbv59vetrxe0ejfubep1w` (`order_id`),
  CONSTRAINT `FKbioxgbv59vetrxe0ejfubep1w` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `FKi4ptndslo2pyfp9r1x0eulh9g` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (1,1,95,1,1),(2,1,137,2,2),(3,1,51,3,2),(4,1,51,3,3),(5,1,51,3,4),(6,1,9,4,5),(7,1,137,2,6),(8,2,91,5,6),(9,1,95,1,7),(10,1,9,4,8),(11,1,51,3,9),(12,2,449,6,10),(13,1,51,3,11),(14,1,9,4,12),(15,1,51,3,13),(16,1,137,2,14),(17,1,51,3,14),(18,1,51,3,15),(19,1,137,2,16),(20,4,91,5,16),(21,1,137,2,17),(22,1,51,3,18),(23,1,137,2,19),(24,1,95,1,19),(25,1,9,4,20),(26,1,51,3,20),(27,1,137,2,21),(28,1,95,1,22),(29,1,9,4,23),(30,3,137,2,24),(31,1,51,3,25),(32,1,137,2,25),(33,1,95,1,25),(34,1,51,3,26),(35,1,137,2,26),(36,1,95,1,26),(37,1,51,3,27),(38,1,137,2,27),(39,1,95,1,27),(40,1,51,3,28),(41,1,137,2,28),(42,1,95,1,28),(43,1,51,3,29),(44,1,137,2,29),(45,1,95,1,29),(46,1,51,3,30),(47,1,137,2,30),(48,1,95,1,30),(49,1,51,3,31),(50,1,137,2,31),(51,1,95,1,31),(52,2,95,1,32),(53,1,95,1,33),(54,1,95,1,34),(55,1,137,2,34),(56,1,137,2,35),(57,1,137,2,36),(58,1,95,1,37),(59,1,95,1,38),(60,2,137,2,39),(61,2,137,2,40),(62,2,137,2,41),(63,2,137,2,42),(64,1,137,2,43),(65,1,51,3,43),(66,1,51,3,44),(67,1,51,3,45),(68,1,51,3,46),(69,1,91,5,47),(70,1,137,2,47),(71,1,137,2,48),(72,1,91,5,48),(73,1,137,2,49),(74,1,91,5,49),(75,1,51,3,49),(76,1,51,3,50),(77,2,137,2,51),(78,2,137,2,52),(79,2,51,3,53),(80,2,137,2,54),(81,2,137,2,55),(82,1,449,6,56),(83,2,91,5,57),(84,2,9,4,58);
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_logs`
--

DROP TABLE IF EXISTS `order_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_logs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `end_time` datetime(6) DEFAULT NULL,
  `error_message` varchar(255) DEFAULT NULL,
  `is_success` bit(1) DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq1skbqtirry9w66tqpiqmt2es` (`user_id`),
  CONSTRAINT `FKq1skbqtirry9w66tqpiqmt2es` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_logs`
--

LOCK TABLES `order_logs` WRITE;
/*!40000 ALTER TABLE `order_logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL,
  `order_date` datetime(6) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `total_price` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK32ql8ubntj5uh44ph9659tiih` (`user_id`),
  CONSTRAINT `FK32ql8ubntj5uh44ph9659tiih` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2023-05-06 10:28:38.073000',1,NULL),(2,'2023-05-07 02:26:43.200000',1,NULL),(3,'2023-05-07 03:50:59.070000',1,NULL),(4,'2023-05-07 03:53:21.583000',1,NULL),(5,'2023-05-07 03:54:24.302000',1,NULL),(6,'2023-05-07 04:29:56.324000',1,NULL),(7,'2023-05-07 04:30:31.280000',1,NULL),(8,'2023-05-07 04:31:01.000000',1,NULL),(9,'2023-05-07 04:31:26.804000',1,NULL),(10,'2023-05-07 04:43:00.354000',1,NULL),(11,'2023-05-07 04:44:32.389000',1,NULL),(12,'2023-05-07 04:45:22.269000',1,NULL),(13,'2023-05-07 04:58:36.941000',2,NULL),(14,'2023-05-07 06:45:30.415000',3,NULL),(15,'2023-06-22 03:03:15.749000',2,NULL),(16,'2023-06-22 06:46:41.098000',4,NULL),(17,'2023-09-17 08:35:10.818000',3,NULL),(18,'2023-09-17 08:37:00.974000',3,NULL),(19,'2023-09-17 08:42:16.961000',3,NULL),(20,'2023-09-17 10:22:13.192000',3,NULL),(21,'2023-09-17 10:38:14.524000',3,NULL),(22,'2023-09-17 10:45:46.033000',3,NULL),(23,'2023-09-17 11:04:00.143000',3,NULL),(24,'2023-09-17 13:36:03.145000',3,NULL),(25,'2023-09-18 08:16:25.800000',3,NULL),(26,'2023-09-18 08:21:03.359000',3,NULL),(27,'2023-09-18 08:21:39.642000',3,NULL),(28,'2023-09-18 08:51:03.633000',3,NULL),(29,'2023-09-18 08:51:54.833000',3,NULL),(30,'2023-09-18 08:52:02.801000',3,NULL),(31,'2023-09-18 08:52:33.757000',3,NULL),(32,'2023-09-30 12:45:14.390000',3,NULL),(33,'2023-09-30 12:46:25.735000',3,NULL),(34,'2023-09-30 12:49:19.069000',3,NULL),(35,'2023-10-06 08:14:46.853000',3,NULL),(36,'2023-10-06 08:15:19.682000',3,NULL),(37,'2023-10-06 08:16:35.862000',3,NULL),(38,'2023-10-06 08:21:50.906000',3,NULL),(39,'2023-10-25 00:43:10.843000',3,NULL),(40,'2023-10-25 00:49:37.534000',3,NULL),(41,'2023-10-25 00:57:00.007000',3,NULL),(42,'2023-10-25 01:01:56.554000',3,NULL),(43,'2023-10-25 01:05:59.980000',3,188),(44,'2023-10-30 08:36:44.695000',3,51),(45,'2023-10-30 08:38:48.403000',3,51),(46,'2023-10-30 08:43:09.199000',3,51),(47,'2023-11-10 02:37:27.332000',3,228),(48,'2023-11-10 11:54:54.017000',3,228),(49,'2023-11-10 13:07:50.055000',3,279),(50,'2023-11-10 13:08:00.443000',3,51),(51,'2023-11-10 13:08:13.811000',3,274),(52,'2023-11-10 13:08:42.243000',3,274),(53,'2023-11-10 13:09:29.879000',3,102),(54,'2023-11-10 13:11:05.596000',3,274),(55,'2023-11-10 13:12:12.696000',3,274),(56,'2023-12-11 08:17:41.147000',3,449),(57,'2023-12-11 08:17:48.005000',3,182),(58,'2023-12-11 08:55:01.219000',3,18);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2873561640@qq.com','123456','customer','123456'),(2,'233@163.com','233','ban','233'),(3,'sjtu@163.com','sjtu','admin','sjtu'),(4,'2873561640@qq.com','111','customer','111');
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

-- Dump completed on 2023-12-12 16:26:50
