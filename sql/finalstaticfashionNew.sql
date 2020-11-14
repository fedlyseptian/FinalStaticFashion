CREATE TABLE `admin` (
  `username` varchar(30) NOT NULL PRIMARY KEY,
  `password` varchar(32) NOT NULL
);

CREATE TABLE member (
  `username` varchar(30) NOT NULL PRIMARY KEY,
  `password` varchar(32) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `birthDate` date DEFAULT NULL,
  `point` double DEFAULT NULL,
  `money` double DEFAULT NULL
);

CREATE TABLE seller (
  `storeName` varchar(30) NOT NULL PRIMARY KEY,
  `username` varchar(30) NOT NULL,
  CONSTRAINT FK_Username FOREIGN KEY (username) REFERENCES member(username)
);

CREATE TABLE products (
  `productID` char(10) NOT NULL PRIMARY KEY,
  `productName` varchar(30) DEFAULT NULL,
  `productBrand` varchar(30) DEFAULT NULL,
  `productCategory` varchar(30) DEFAULT NULL,
  `productStock` int(11) DEFAULT NULL,
  `productPrice` double DEFAULT NULL,
  `productSize` char(2) DEFAULT NULL,
  `storeName` varchar(30) DEFAULT NULL,
  CONSTRAINT FK_Storename FOREIGN KEY (storeName) REFERENCES seller(storeName)
);

CREATE TABLE discount (
  `discountID` char(10) NOT NULL PRIMARY KEY,
  `discountValue` double DEFAULT NULL
);

CREATE TABLE taxseller (
  `taxValue` double DEFAULT NULL
);

CREATE TABLE transactions (
  `transactionID` char(10) NOT NULL PRIMARY KEY,
  `username` varchar(30) DEFAULT NULL,
  `productID` char(10) DEFAULT NULL,
  `discountID` char(10) DEFAULT NULL,
  `transactionDate` date DEFAULT NULL,
  `paymentOption` int(11) DEFAULT NULL,
  `subTotalTransaction` double DEFAULT NULL,
  `taxSeller` double DEFAULT NULL,
  CONSTRAINT FK_UsernameTr FOREIGN KEY (username) REFERENCES member(username),
  CONSTRAINT FK_ProductIDTr FOREIGN KEY (productID) REFERENCES products(productID),
  CONSTRAINT FK_DiscountID FOREIGN KEY (discountID) REFERENCES discount(discountID)
);

CREATE TABLE listproduct (
  `transactionID` char(10) DEFAULT NULL,
  `productID` char(10) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (transactionID, productID),
  CONSTRAINT FK_TransactionID FOREIGN KEY (transactionID) REFERENCES transactions(transactionID),
  CONSTRAINT FK_ProductID FOREIGN KEY (productID) REFERENCES products(productID)
);