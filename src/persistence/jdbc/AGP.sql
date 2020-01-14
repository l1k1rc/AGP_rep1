-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 14, 2020 at 12:28 PM
-- Server version: 5.7.28-0ubuntu0.18.04.4
-- PHP Version: 7.2.24-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `AGP`
--

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `beach` varchar(50) DEFAULT NULL,
  `entertainment` tinyint(1) DEFAULT NULL,
  `quality` int(11) DEFAULT NULL,
  `position_x` int(11) DEFAULT NULL,
  `position_y` int(11) DEFAULT NULL,
  `island_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`id`, `name`, `price`, `beach`, `entertainment`, `quality`, `position_x`, `position_y`, `island_id`) VALUES
(1, 'Vila Lavanda', 90, 'Playa De Las Américas', 0, 3, 9, 4, 1),
(2, 'Jardîn Tropical Hotel', 130, 'Costa Adeje', 1, 4, 11, 4, 1),
(3, 'H10 Tenerife Playa', 120, 'Puerto de la Cruz ', 1, 4, 11, 7, 1),
(4, 'playa arena', 60, 'Playa de la Arena', 0, 2, 9, 8, 1),
(5, 'Hotel SBH Costa Calma Palace', 110, 'Playas de Costa Calma', 1, 4, 14, 7, 2),
(6, 'Hotel Coral Cotillo Beach', 50, 'El Cotillo', 0, 2, 14, 9, 2),
(7, 'IFA Altamarena Hotel', 120, 'Playa del Matorral', 1, 4, 16, 11, 2),
(8, 'Fuerteventura Princess', 140, 'Playa Jandia', 1, 4, 16, 8, 2),
(9, 'Apartamentos Santa Ana', 60, 'playa de Santiago', 0, 2, 7, 6, 3),
(10, 'Santa Catalina', 50, 'Playa Hermigua', 0, 2, 6, 8, 3),
(11, 'Paradors de El Hierro', 80, 'Las Playas', 0, 3, 1, 1, 4),
(12, 'El Cercado de la Montaña', 60, 'Playa del Rio', 0, 2, 0, 3, 4),
(13, 'Sol La Palma Apartamentos', 120, 'Playa dde Puerto Naos', 1, 4, 2, 10, 5),
(14, 'Hotel Holiday Time', 110, 'Playa Santa Cruz de La Palma', 1, 4, 4, 11, 5);

-- --------------------------------------------------------

--
-- Table structure for table `island`
--

CREATE TABLE `island` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `island`
--

INSERT INTO `island` (`id`, `name`) VALUES
(1, 'Tenerife'),
(2, 'Fuerteventura'),
(3, 'La Gomera'),
(4, 'El Hierro'),
(5, 'La Palma');

-- --------------------------------------------------------

--
-- Table structure for table `site`
--

CREATE TABLE `site` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `hist_act` tinyint(1) DEFAULT NULL,
  `position_x` int(11) DEFAULT NULL,
  `position_y` int(11) DEFAULT NULL,
  `island_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `site`
--

INSERT INTO `site` (`id`, `name`, `price`, `hist_act`, `position_x`, `position_y`, `island_id`) VALUES
(1, 'parc Loro parque', 38, 0, 9, 6, 1),
(2, 'Parcours Kayak et Snorkel', 40, 0, 11, 5, 1),
(3, 'Piramides de Guimar', 12, 1, 10, 6, 1),
(4, 'Le centre historique de La Orotava', 0, 1, 10, 8, 1),
(5, 'Le centre historique de Santa Cruz de Tenerife', 0, 1, 9, 7, 1),
(6, 'Tour en jet ski', 75, 0, 15, 6, 2),
(7, 'Parc aquatique de Fuerteventura', 25, 0, 14, 8, 2),
(8, 'Plongée', 50, 0, 15, 11, 2),
(9, 'Eglise de Santa Maria de Betancuria', 0, 1, 17, 10, 2),
(10, 'Faro de la Entallada', 0, 1, 16, 7, 2),
(11, 'Tour de randonnée de la Gomera Canyons', 32, 0, 6, 5, 3),
(12, 'Visite à l intérieur du parc ethnographique historique', 25, 1, 5, 6, 3),
(13, 'Notre Dame de L Assomption', 0, 1, 6, 6, 3),
(14, 'Torre del Conde', 0, 1, 7, 8, 3),
(15, 'Centre historique de San Sebastián de La Gomera', 10, 1, 7, 7, 3),
(16, 'Centre de plongée la Restinga', 50, 0, 0, 1, 4),
(17, 'Randonnée au Sabinar', 0, 0, 0, 2, 4),
(18, 'Spéléologie', 65, 0, 1, 3, 4),
(19, 'Eglise de la Concepción', 0, 1, 1, 2, 4),
(20, 'Eglise de notre Dame de Consolation et St. Simon', 0, 1, 2, 1, 4),
(21, 'La cave Bodegas Teneguía à La Palma', 6, 0, 3, 9, 5),
(22, 'Observation des baleines et des dauphins de 3 heures sur bateau', 65, 0, 2, 11, 5),
(23, 'TandemFly La Palma', 80, 0, 3, 11, 5),
(24, 'Musée archéologique benahoare', 25, 1, 3, 10, 5),
(25, 'Église el Salvador', 0, 1, 4, 10, 5);

-- --------------------------------------------------------

--
-- Table structure for table `transport`
--

CREATE TABLE `transport` (
  `id` int(11) NOT NULL,
  `price_km` int(11) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transport`
--

INSERT INTO `transport` (`id`, `price_km`, `type`) VALUES
(1, 12, 'Bus'),
(2, 6, 'Bateau');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `island_id` (`island_id`);

--
-- Indexes for table `island`
--
ALTER TABLE `island`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `site`
--
ALTER TABLE `site`
  ADD PRIMARY KEY (`id`),
  ADD KEY `island_id` (`island_id`);

--
-- Indexes for table `transport`
--
ALTER TABLE `transport`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `island`
--
ALTER TABLE `island`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `site`
--
ALTER TABLE `site`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `transport`
--
ALTER TABLE `transport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hotel`
--
ALTER TABLE `hotel`
  ADD CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`island_id`) REFERENCES `island` (`id`);

--
-- Constraints for table `site`
--
ALTER TABLE `site`
  ADD CONSTRAINT `site_ibfk_1` FOREIGN KEY (`island_id`) REFERENCES `island` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
