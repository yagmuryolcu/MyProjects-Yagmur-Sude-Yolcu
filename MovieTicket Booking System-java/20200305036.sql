-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 22 May 2023, 01:29:34
-- Sunucu sürümü: 10.4.28-MariaDB
-- PHP Sürümü: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `20200305036`
--
CREATE DATABASE IF NOT EXISTS `20200305036` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `20200305036`;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `movies`
--

DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies` (
  `id` int(20) NOT NULL,
  `movie` varchar(100) NOT NULL,
  `datetime1` varchar(100) NOT NULL,
  `tickets` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `movies`
--

INSERT INTO `movies` (`id`, `movie`, `datetime1`, `tickets`) VALUES
(1, 'JOHN WICK 4', '28-05-2023 5 PM', '4'),
(2, 'DER FUCHS', '29-05-2023 11 PM', '1');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` int(20) NOT NULL,
  `card` varchar(100) NOT NULL,
  `holder` varchar(60) NOT NULL,
  `cvv` varchar(6) NOT NULL,
  `exp` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `payment`
--

INSERT INTO `payment` (`id`, `card`, `holder`, `cvv`, `exp`) VALUES
(1, '20202020202', '215151515', '121', '45454'),
(2, '2021542454241', '54864541', '1245', '1524'),
(3, '2020232522', 'GGGGGG', '123', '123'),
(4, '2023562325252', 'Yağmur Sude Yolcu', '1452', '1256');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `phone`, `address`, `password`) VALUES
(1, 'yağmur', 'yağmur@hotmail.com', '5326532265', 'tuzla', '123'),
(2, 'Oğuz', 'oguz@hotmail.com', '05319863269', 'Maltepe', '1212'),
(3, 'Sinan', 'sinan@hotmail.com', '05319805236', 'esenyurt', 'sinan123'),
(10, 'ozi', 'ozi@hotmail.com', 'dddddd', 'fdddddd', 'ozi'),
(12, 'harun', 'harun@hotmail.com', '05326532222', 'kadıköy', '1234'),
(16, 'ayça', 'ayça@hotmail.com', '05326459865', 'kadıköy', '456'),
(17, 'Yağmur', 'yağmur1@hotmail.com', '05316452321', 'tuzla aydınlı', '123');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `movie` (`movie`);

--
-- Tablo için indeksler `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `card` (`card`);

--
-- Tablo için indeksler `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `movies`
--
ALTER TABLE `movies`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
