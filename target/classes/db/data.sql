CREATE DATABASE  IF NOT EXISTS `qltv` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `qltv`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: qltv
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,1,'Kỹ Năng Đi Trước Đam Mê','Trong quyển sách Kỹ Năng Đi Trước Đam Mê, Cal Newport lột trần niềm tin từ trước đến nay rằng ta nên \"theo đuổi đam mê.\"',9,1,'Cal Newport',2018,'vinh','vinh','2019-04-19 06:25:50','2019-04-23 06:09:06',0),(3,1,'Nghệ Thuật Đàm Phán','Quyển sách cho chúng ta thấy cách Trump làm việc mỗi ngày - cách ông điều hành công việc kinh doanh và cuộc sống - cũng như cách ông trò chuyện với bạn bè và gia đình, làm ăn với đối thủ, mua thành công những sòng bạc hàng đầu ở thành phố Atlantic, thay đổi bộ mặt của những cao ốc ở thành phố New York... và xây dựng những tòa nhà chọc trời trên thế giới. \r\n\r\nQuyển sách đi sâu vào đầu óc của một doanh nhân xuất sắc và khám phá một cách khoa học chưa từng thấy về cách đàm phán một thương vụ thành công. Đây là một cuốn sách thú vị về đàm phán và kinh doanh – và là một cuốn sách nên đọc cho bất kỳ ai quan tâm đến đầu tư, bất động sản và thành công.',0,0,'Donald J. Trump - Tony Schwartz',2019,'dd','dd','2019-04-19 10:31:41','2019-04-19 10:31:41',0),(4,3,'Hướng Dẫn Chẩn Đoán, Điều Trị 65 Bệnh Da Liễu','Tài liệu được xây dựng với sự nỗ lực cao của các nhà khoa học đầu ngành về Da liễu của Việt Nam. Tài liệu bao gồm 11 chương và 65 bài hướng dẫn chẩn đoán và điều trị các bệnh Da liễu. Trong đó, tập trung vào hướng dẫn thực hành chẩn đoán và điều trị, vì vậy sẽ rất hữu ích cho các thầy thuốc đa khoa, chuyên khoa trong thực hành lâm sàng hàng ngày.',2,0,'Bộ Y Tế',2016,'vinh','vinh','2019-04-22 02:55:38','2019-04-22 02:55:38',0),(5,7,'Thomas Edison - Người Thắp Sáng Địa Cầu','Edison thời tiểu học bị cho là đứa trẻ chậm phát triển, lớn lên đối với văn minh nhân loại, có cống hiến rất vĩ đại như đèn điện, điện thoại, điện tín, xe điện, máy ghi âm, điện ảnh, máy thu thanh v.v..., hơn 1000 phát minh hoàn toàn nhờ vào tinh thần nghiên cứu siêu nhân, bền chí bền lòng và sự nổ lực không chịu lùi bước đã thành công. “Bền lòng bền gan là gốc của thành công. Người có chí việc ắt thành.”\r\n\r\nHai câu nói đó, nhìn từ quá trình nghiên cứu của Edison, chúng ta càng nên tin vào sự chính xác của nó.',20,0,'Nguyễn Mạnh Yến',1954,'vinhlibrarian','vinhlibrarian','2019-04-24 09:55:36','2019-04-24 09:55:52',0),(6,8,'Doramon','Nói về cuộc sống của nhóm bạn',198,0,'ggggggggg',1996,'vinhadmin','vinhadmin','2019-04-25 03:01:52','2019-04-25 03:02:19',0);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `borrow_orders`
--

LOCK TABLES `borrow_orders` WRITE;
/*!40000 ALTER TABLE `borrow_orders` DISABLE KEYS */;
INSERT INTO `borrow_orders` VALUES (11,4,1,'2019-04-22 17:00:00','2019-04-23 17:00:00','Mượn 3 ngày',4,'vinhuser','vinh','2019-04-23 04:29:19','2019-04-23 09:59:17',0),(12,3,1,'2019-04-23 17:00:00','2019-04-24 17:00:00','ok',1,'vinhadmin','vinhlibrarian','2019-04-23 04:29:41','2019-04-23 04:30:37',0),(13,2,3,'2019-04-22 17:00:00','2019-04-24 17:00:00','Librarian mượn',4,'vinhlibrarian','vinhlibrarian','2019-04-23 04:31:32','2019-04-25 03:07:49',0),(14,1,1,'2019-04-22 17:00:00','2019-04-26 17:00:00','',3,'vinh','vinhlibrarian','2019-04-23 06:09:42','2019-04-25 03:07:44',0),(15,4,3,'2019-04-22 17:00:00','2019-04-29 17:00:00','',2,'vinhuser','vinhlibrarian','2019-04-23 06:11:56','2019-04-23 06:13:43',0),(16,4,3,'2019-04-22 17:00:00','2019-05-22 17:00:00','',4,'vinhuser','vinhlibrarian','2019-04-23 06:12:09','2019-04-23 06:16:04',0),(17,4,4,'2019-04-22 17:00:00','2019-04-27 17:00:00','',2,'vinhuser','vinhlibrarian','2019-04-23 06:12:41','2019-04-24 03:56:48',0),(18,4,1,'2019-04-23 17:00:00','2019-04-25 17:00:00','',2,'vinhuser','vinhlibrarian','2019-04-23 06:12:52','2019-04-24 03:56:53',0),(19,4,3,'2019-04-22 17:00:00','2019-04-26 17:00:00','',2,'vinhuser','vinhlibrarian','2019-04-23 06:14:12','2019-04-25 03:37:11',0),(20,4,4,'2019-04-22 17:00:00','2019-04-29 17:00:00','',3,'vinhuser','vinhlibrarian','2019-04-23 06:16:28','2019-04-25 03:07:56',0),(21,4,1,'2019-04-24 17:00:00','2019-05-02 17:00:00','',3,'vinhuser','vinhlibrarian','2019-04-24 03:56:03','2019-04-25 03:08:13',0),(22,15,1,'2019-04-23 17:00:00','2019-05-23 17:00:00','Mượn 30 ngày',3,'testuser','vinhlibrarian','2019-04-24 09:51:17','2019-04-25 03:08:17',0),(23,16,1,'2019-04-24 17:00:00','2019-04-29 17:00:00','sdsdsd',2,'Trung1996','vinhlibrarian','2019-04-25 02:44:08','2019-04-25 03:37:15',0),(24,16,5,'2019-04-26 17:00:00','2019-04-29 17:00:00','nhe tay',3,'Trung1996','vinhlibrarian','2019-04-25 02:54:19','2019-04-25 03:08:20',0),(25,16,6,'2019-04-25 17:00:00','2019-04-28 17:00:00','',4,'Trung1996','vinhlibrarian','2019-04-25 03:13:19','2019-04-25 03:15:24',0),(26,16,6,'2019-04-25 17:00:00','2019-04-28 17:00:00','sssssssssssss',4,'Trung1996','vinhlibrarian','2019-04-25 03:14:30','2019-04-25 03:15:26',0);
/*!40000 ALTER TABLE `borrow_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,NULL,'Tâm Lý - Kỹ Năng Sống','vinh','vinh','2019-04-19 06:25:50','2019-04-22 02:54:13',0),(3,NULL,'Y Học - Sức Khỏeaa','vinh','vinh','2019-04-22 02:28:01','2019-04-23 09:58:50',0),(5,NULL,'Thể Thao - Nghệ Thuật','vinh','vinh','2019-04-22 07:58:26','2019-04-22 07:58:26',1),(6,NULL,'tes_category','vinh','vinh','2019-04-23 09:58:19','2019-04-23 09:58:19',1),(7,NULL,'Hồi Ký - Tuỳ Bút','vinhlibrarian','vinhlibrarian','2019-04-24 09:54:41','2019-04-24 09:54:41',0),(8,NULL,'Truyen Tranh','vinhadmin','vinhadmin','2019-04-25 03:01:11','2019-04-25 03:01:11',0);
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (0,'USER'),(1,'LIBRARIAN'),(2,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'vinh','$2a$10$9zxF69EcFWFEbTAaN0HuuOvrE97Rp8aR5l9HsmApR0uonXqCwjSBK','dongoc409@gmail.com','Thái nguyên','0971897597',0,NULL,NULL,NULL,NULL,0,NULL),(2,'vinhlibrarian','$2a$10$mamtz2HLnEw0ScgceSIWQOOlXWdisVrIxF4fL8ppTcDrIR2MoZP6m','vinhlibrarian@gmail.com','Bắc Ninh','0987345234',1,NULL,NULL,NULL,NULL,0,NULL),(3,'vinhadmin','$2a$10$mamtz2HLnEw0ScgceSIWQOOlXWdisVrIxF4fL8ppTcDrIR2MoZP6m','ascc@gmail.com','Hà Nội','056656325',2,NULL,'vinh',NULL,'2019-04-22 04:28:12',0,NULL),(4,'vinhuser','$2a$10$mamtz2HLnEw0ScgceSIWQOOlXWdisVrIxF4fL8ppTcDrIR2MoZP6m','d@gmail.com','Hà Nội','056656345',0,NULL,NULL,NULL,NULL,0,NULL),(13,'testBscrip','$2a$10$R7J2R7XW29gL/pWXnH7dhu51XdBra7xoltYb1UoPMG1oPXPVtF99G','testBscrip@gmail.com','Hà Nội','0971897654',0,NULL,'vinh',NULL,'2019-04-23 09:33:44',0,NULL),(14,'test','$2a$10$mmuEDwRap7jXLy/VPHbmeO3KJ/JI5p/oJO1ItqdOLxb9K2ttYm4Cq','11asd11@gmail.com','Hà Nội','0987654653',0,NULL,'vinhlibrarian',NULL,'2019-04-24 09:53:08',0,NULL),(15,'testuser','$2a$10$TsuC.6YbXR2xRO6UJPd4ae2.fbCZmqjs0nSopo.vvnn9qzA3RLy56','testuser@gmail.com','Hà Nội','01675809930',0,'testuser','testuser','2019-04-24 09:49:39','2019-04-24 09:49:39',0,NULL),(16,'Trung1996','$2a$10$Ymugg1Q77FKq8j76.BkPK./yj7lI4i9Ylu4GxMJVLKdSf8KbOh7oi','trung2671996@gmail.com','20 Hoang Quoc Viet','0916425369',0,'Trung1996',NULL,'2019-04-25 02:37:11',NULL,0,NULL),(19,'testlibrarian','$2a$10$VRVDgJORwQKyQRGHaF2tju5.HyynHPj.99bhgeyEcZ2WWSv4bAc2W','testuser1@gmail.com','Hà Nội','0971897597',0,'testlibrarian','testlibrarian','2019-04-25 03:12:50','2019-04-25 03:12:50',0,NULL);
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

-- Dump completed on 2019-04-25 16:50:30
