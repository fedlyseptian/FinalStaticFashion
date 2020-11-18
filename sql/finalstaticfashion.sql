-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 18, 2020 at 03:43 AM
-- Server version: 8.0.21
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `finalstaticfashion`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('admin', '21232f297a57a5a743894a0e4a801fc3');

-- --------------------------------------------------------

--
-- Table structure for table `discount`
--

CREATE TABLE `discount` (
  `discountID` char(10) COLLATE utf8mb4_general_ci NOT NULL,
  `discountValue` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `discount`
--

INSERT INTO `discount` (`discountID`, `discountValue`) VALUES
('FED1', 0.05);

-- --------------------------------------------------------

--
-- Table structure for table `listproduct`
--

CREATE TABLE `listproduct` (
  `transactionID` char(10) COLLATE utf8mb4_general_ci NOT NULL,
  `productID` char(10) COLLATE utf8mb4_general_ci NOT NULL,
  `quantity` int DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `username` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` char(1) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `birthDate` date DEFAULT NULL,
  `point` double DEFAULT NULL,
  `money` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`username`, `password`, `name`, `address`, `gender`, `email`, `birthDate`, `point`, `money`) VALUES
('Fedly123', 'eaec8de3a25ffaad45461d875060005f', 'Fedly Septian', 'Jl. Cicadas', 'L', 'if-19033@students.ithb.ac.id', '1999-09-05', 0, 0),
('Jeddi123', '360d913221f977222b9028ada63cf7d7', 'Jedediah Fanuel', 'Jl. Kembar Sari Indah 1 No. 5', 'L', 'if-19023@students.ithb.ac.id', '2001-04-28', 0, 0),
('Timothy123', 'fc40bc0ee14780238c5d7dd6e2de5cc0', 'Timothy Ray', 'Jl. Singapur', 'L', 'if-19033@students.ithb.ac.id', '2001-02-18', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `productID` char(10) COLLATE utf8mb4_general_ci NOT NULL,
  `productName` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `productBrand` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `productCategory` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `productStock` int DEFAULT NULL,
  `productPrice` double DEFAULT NULL,
  `productSize` char(2) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `storeName` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `pathFotoProduct` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`productID`, `productName`, `productBrand`, `productCategory`, `productStock`, `productPrice`, `productSize`, `storeName`, `pathFotoProduct`) VALUES
('PF001', 'Kaos Makaroni', 'OriginalFedly', 'Kaos', 100, 120000, 'L', 'Bebas Cinta Fashion', NULL),
('PF002', 'Kaos Makaroni', 'OriginalFedly', 'Kaos', 90, 120000, 'M', 'Bebas Cinta Fashion', NULL),
('PF003', 'Kaos Makaroni', 'OriginalFedly', 'Kaos', 20, 120000, 'S', 'Bebas Cinta Fashion', NULL),
('PF004', 'Celana Merah FD', 'OriginalFedly', 'Celana', 80, 100000, 'L', 'Bebas Cinta Fashion', NULL),
('PF005', 'Celana Merah FD', 'OriginalFedly', 'Celana', 76, 100000, 'M', 'Bebas Cinta Fashion', NULL),
('PF006', 'Celana Merah FD', 'OriginalFedly', 'Celana', 56, 100000, 'S', 'Bebas Cinta Fashion', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `seller`
--

CREATE TABLE `seller` (
  `storeName` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `discountID` char(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `pathLogo` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `seller`
--

INSERT INTO `seller` (`storeName`, `username`, `discountID`, `pathLogo`) VALUES
('Bebas Cinta Fashion', 'Fedly123', 'FED1', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `taxseller`
--

CREATE TABLE `taxseller` (
  `taxValue` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taxseller`
--

INSERT INTO `taxseller` (`taxValue`) VALUES
(0.01);

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `transactionID` char(10) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `productID` char(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `discountID` char(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `transactionDate` date DEFAULT NULL,
  `paymentOption` int DEFAULT NULL,
  `subTotalTransaction` double DEFAULT NULL,
  `taxSeller` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`discountID`);

--
-- Indexes for table `listproduct`
--
ALTER TABLE `listproduct`
  ADD PRIMARY KEY (`transactionID`,`productID`),
  ADD KEY `FK_ProductID` (`productID`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`productID`),
  ADD KEY `FK_Storename` (`storeName`);

--
-- Indexes for table `seller`
--
ALTER TABLE `seller`
  ADD PRIMARY KEY (`storeName`),
  ADD KEY `FK_Username` (`username`),
  ADD KEY `FK_DiscountIDSeller` (`discountID`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`transactionID`),
  ADD KEY `FK_UsernameTr` (`username`),
  ADD KEY `FK_ProductIDTr` (`productID`),
  ADD KEY `FK_DiscountID` (`discountID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `listproduct`
--
ALTER TABLE `listproduct`
  ADD CONSTRAINT `FK_ProductID` FOREIGN KEY (`productID`) REFERENCES `products` (`productID`),
  ADD CONSTRAINT `FK_TransactionID` FOREIGN KEY (`transactionID`) REFERENCES `transactions` (`transactionID`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FK_Storename` FOREIGN KEY (`storeName`) REFERENCES `seller` (`storeName`);

--
-- Constraints for table `seller`
--
ALTER TABLE `seller`
  ADD CONSTRAINT `FK_DiscountIDSeller` FOREIGN KEY (`discountID`) REFERENCES `discount` (`discountID`),
  ADD CONSTRAINT `FK_Username` FOREIGN KEY (`username`) REFERENCES `member` (`username`);

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `FK_DiscountID` FOREIGN KEY (`discountID`) REFERENCES `discount` (`discountID`),
  ADD CONSTRAINT `FK_ProductIDTr` FOREIGN KEY (`productID`) REFERENCES `products` (`productID`),
  ADD CONSTRAINT `FK_UsernameTr` FOREIGN KEY (`username`) REFERENCES `member` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
