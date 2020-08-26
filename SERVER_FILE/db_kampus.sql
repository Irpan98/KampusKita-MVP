-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.13-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for db_kampus
CREATE DATABASE IF NOT EXISTS `db_kampus` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_kampus`;

-- Dumping structure for table db_kampus.mahasiswa
CREATE TABLE IF NOT EXISTS `mahasiswa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `contact` bigint(20) DEFAULT NULL,
  `address` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_kampus.mahasiswa: ~9 rows (approximately)
/*!40000 ALTER TABLE `mahasiswa` DISABLE KEYS */;
REPLACE INTO `mahasiswa` (`id`, `name`, `contact`, `address`) VALUES
	(16, 'Ferdi', 8234033, 'Balikpapan'),
	(20, 'Aldi', 32323123, '23a'),
	(21, 'Irpan Irpan', 8388607, 'Samarinda Seberang'),
	(22, 'Erwin', 823388608, 'Sulsel'),
	(23, 'Irpan irpan', 8388607, 'Samarinda'),
	(24, 'Dia', 8388607, 'Bali'),
	(25, 'asd', 8388607, 'ds'),
	(26, 'w', 8388607, 'q'),
	(27, 'as', 8388607, 'd'),
	(28, 'dsd', 82354046818, 'as');
/*!40000 ALTER TABLE `mahasiswa` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
