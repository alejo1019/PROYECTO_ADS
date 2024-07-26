-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 26, 2024 at 06:55 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proyecto`
--

-- --------------------------------------------------------

--
-- Table structure for table `encuesta`
--

CREATE TABLE `encuesta` (
  `cedula` int(10) NOT NULL,
  `datos` varchar(500) NOT NULL,
  `experiencia` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Dumping data for table `encuesta`
--

INSERT INTO `encuesta` (`cedula`, `datos`, `experiencia`) VALUES
(12, '13', '15'),
(123, '123123', '123123'),
(123456789, 'Pepe mmartinez', '1 anio '),
(1234567890, 'a o', '1 anio ');

-- --------------------------------------------------------

--
-- Table structure for table `pdf_table`
--

CREATE TABLE `pdf_table` (
  `id` int(11) NOT NULL,
  `file_name` varchar(250) NOT NULL,
  `file_data` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Table structure for table `trabajadores`
--

CREATE TABLE `trabajadores` (
  `usuarios` varchar(100) NOT NULL,
  `contrasenia` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Dumping data for table `trabajadores`
--

INSERT INTO `trabajadores` (`usuarios`, `contrasenia`) VALUES
('user1@kas.com', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `encuesta`
--
ALTER TABLE `encuesta`
  ADD PRIMARY KEY (`cedula`);

--
-- Indexes for table `pdf_table`
--
ALTER TABLE `pdf_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD PRIMARY KEY (`usuarios`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `encuesta`
--
ALTER TABLE `encuesta`
  MODIFY `cedula` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1234567891;

--
-- AUTO_INCREMENT for table `pdf_table`
--
ALTER TABLE `pdf_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
