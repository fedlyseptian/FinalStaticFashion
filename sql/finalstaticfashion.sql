-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 25, 2020 at 03:50 AM
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
-- Table structure for table `aboutus`
--

CREATE TABLE `aboutus` (
  `aboutUsID` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `aboutUsText` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `aboutus`
--

INSERT INTO `aboutus` (`aboutUsID`, `aboutUsText`) VALUES
('AUT', 'Final Static Fashion is the new branded fashion online store that gather the most known branded outfit creator. We always care for our customer satisfify. Do not wait any longer. Lets go shopping with us, and become our member or seller.');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
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
  `discountID` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `discountValue` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `discount`
--

INSERT INTO `discount` (`discountID`, `discountValue`) VALUES
('BTN-FY3001', 0.01),
('DOS-DOS001', 0.049999999999999996),
('non', 0);

-- --------------------------------------------------------

--
-- Table structure for table `listproduct`
--

CREATE TABLE `listproduct` (
  `transactionID` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `productID` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `quantity` int DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `listproduct`
--

INSERT INTO `listproduct` (`transactionID`, `productID`, `quantity`, `total`) VALUES
('T000000001', 'B S-BTN001', 1, 500000),
('T000000001', 'BJS-BTN001', 1, 100000),
('T000000001', 'WRS-DOS001', 1, 137000),
('T000000002', 'B S-BTN002', 2, 1000000),
('T000000003', 'WRS-DOS001', 2, 274000),
('T000000004', 'BJS-BTN002', 1, 105000);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `birthDate` date DEFAULT NULL,
  `point` double DEFAULT NULL,
  `money` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`username`, `password`, `name`, `address`, `gender`, `email`, `birthDate`, `point`, `money`) VALUES
('DolorES', '198620d4516fb39bd43d631678aefc58', 'Dolor Septian', 'Jalan Kopo', 'L', 'dolor@yahoo.com', '1984-05-08', 0, 974605.5),
('Fedly123', 'eaec8de3a25ffaad45461d875060005f', 'Fedly', 'Cicadas', 'L', 'Fedly@gmail.com', '1999-09-05', 0, 2516827.5),
('Jeddi123', '360d913221f977222b9028ada63cf7d7', 'Jedediah Fanuel', 'Jl. Kembar Sari Indah 1 No. 5', 'L', 'if-19023@students.ithb.ac.id', '2001-04-28', 13015, 39700),
('Timothy123', 'fc40bc0ee14780238c5d7dd6e2de5cc0', 'Timothy Ray', 'Jl. Singapur', 'L', 'if-19033@students.ithb.ac.id', '2001-02-18', 107157.5, 1000000);

-- --------------------------------------------------------

--
-- Table structure for table `pointSystem`
--

CREATE TABLE `pointSystem` (
  `pointValue` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pointSystem`
--

INSERT INTO `pointSystem` (`pointValue`) VALUES
(0.05);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `productID` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `productName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `productBrand` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `productCategory` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `productStock` int DEFAULT NULL,
  `productPrice` double DEFAULT NULL,
  `productSize` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `storeName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `pathFotoProduct` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`productID`, `productName`, `productBrand`, `productCategory`, `productStock`, `productPrice`, `productSize`, `storeName`, `pathFotoProduct`) VALUES
('B S-BTN001', 'Black Shoes', 'Skechers', 'Shoes', 99, 500000, 'M', 'Bebas Cinta Fashion', './media/Product/B S-BTN001.jpg'),
('B S-BTN002', 'Black Shoes', 'Skechers', 'Shoes', 98, 500000, 'L', 'Bebas Cinta Fashion', './media/Product/B S-BTN002.jpg'),
('BJS-BTN001', 'Blue Jeans', 'Levis', 'Jeans', 99, 100000, 'XS', 'Bebas Cinta Fashion', './media/Product/BJS-BTN001.jpg'),
('BJS-BTN002', 'Blue Jeans', 'Levis', 'Jeans', 149, 105000, 'M', 'Bebas Cinta Fashion', './media/Product/BJS-BTN002.jpg'),
('BJS-BTN003', 'Blue Jeans', 'Levis', 'Jeans', 100, 110000, 'L', 'Bebas Cinta Fashion', './media/Product/BJS-BTN003.jpg'),
('D S-BTN001', 'Denim Jeans', 'Levis', 'Jeans', 150, 110000, 'L', 'Bebas Cinta Fashion', './media/Product/D S-BTN001.jpg'),
('WRS-DOS001', 'Warrior Shoes', 'Warrior', 'Shoes', 197, 137000, 'S', 'DolorES', './media/Product/WRS-DOS001.jpg'),
('WRS-DOS002', 'Warrior Shoes', 'Warrior', 'Shoes', 123, 140000, 'M', 'DolorES', './media/Product/WRS-DOS002.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `seller`
--

CREATE TABLE `seller` (
  `storeName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `discountID` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `pathLogo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `seller`
--

INSERT INTO `seller` (`storeName`, `username`, `discountID`, `pathLogo`) VALUES
('Bebas Cinta Fashion', 'Fedly123', 'BTN-FY3001', './media/Store/Bebas Cinta Fashion.jpg'),
('DolorES', 'DolorES', 'DOS-DOS001', './media/Store/DolorES.jpg');

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
  `transactionID` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `transactionDate` date DEFAULT NULL,
  `paymentOption` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `subTotalTransaction` double DEFAULT NULL,
  `taxSeller` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`transactionID`, `username`, `transactionDate`, `paymentOption`, `subTotalTransaction`, `taxSeller`) VALUES
('T000000001', 'Timothy123', '2020-11-25', 'CASH', 724150, 0.01),
('T000000002', 'Timothy123', '2020-11-25', 'CASH', 990000, 0.01),
('T000000003', 'Jeddi123', '2020-11-25', 'CASH', 260300, 0.01),
('T000000004', 'Timothy123', '2020-11-25', 'CASH', 103950, 0.01);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aboutus`
--
ALTER TABLE `aboutus`
  ADD PRIMARY KEY (`aboutUsID`);

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
  ADD KEY `FK_ProductID` (`productID`),
  ADD KEY `transactionID` (`transactionID`);

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
  ADD KEY `FK_UsernameTr` (`username`);

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
  ADD CONSTRAINT `FK_UsernameTr` FOREIGN KEY (`username`) REFERENCES `member` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
