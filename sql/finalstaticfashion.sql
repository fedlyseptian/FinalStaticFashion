CREATE TABLE `admin` (
  `username` varchar(30) NOT NULL PRIMARY KEY,
  `password` varchar(32) NOT NULL
);

CREATE TABLE discount (
  `discountID` char(10) NOT NULL PRIMARY KEY,
  `discountValue` double DEFAULT NULL
);

CREATE TABLE taxseller (
  `taxValue` double DEFAULT NULL
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
  `discountID` char(10) DEFAULT NULL,
  `pathLogo` varchar(255) DEFAULT NULL,
  CONSTRAINT FK_Username FOREIGN KEY (username) REFERENCES member(username),
  CONSTRAINT FK_DiscountIDSeller FOREIGN KEY (discountID) REFERENCES discount(discountID)
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
  `pathFotoProduct` varchar(255) DEFAULT NULL,
  CONSTRAINT FK_Storename FOREIGN KEY (storeName) REFERENCES seller(storeName)
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
  `transactionID` char(10) NOT NULL,
  `productID` char(10) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (transactionID, productID),
  CONSTRAINT FK_TransactionID FOREIGN KEY (transactionID) REFERENCES transactions(transactionID),
  CONSTRAINT FK_ProductID FOREIGN KEY (productID) REFERENCES products(productID)
);

CREATE TABLE aboutus (
  `aboutUsID` char(10) NOT NULL PRIMARY KEY,
  `aboutUsText` varchar(255) DEFAULT NULL
);

INSERT INTO discount VALUES ("FED1", 0.05);
INSERT INTO discount VALUES ("non", 0);

INSERT INTO taxSeller VALUES (0.01);

INSERT INTO admin VALUES ("admin", "21232f297a57a5a743894a0e4a801fc3");

INSERT INTO member VALUES ("Jeddi123", "360d913221f977222b9028ada63cf7d7", "Jedediah Fanuel", "Jl. Kembar Sari Indah 1 No. 5", "L", "if-19023@students.ithb.ac.id", "2001-04-28", 0, 0);
INSERT INTO member VALUES ("Fedly123", "eaec8de3a25ffaad45461d875060005f", "Fedly Septian", "Jl. Cicadas", "L", "if-19033@students.ithb.ac.id", "1999-09-05", 0, 0);
INSERT INTO member VALUES ("Timothy123", "fc40bc0ee14780238c5d7dd6e2de5cc0", "Timothy Ray", "Jl. Singapur", "L", "if-19033@students.ithb.ac.id", "2001-02-18", 0, 0);

INSERT INTO seller VALUES ("Bebas Cinta Fashion", "Fedly123", "FED1", "./media/Store/Bebas Cinta Fashion.jpg");

INSERT INTO products VALUES ("PF001", "Kaos Makaroni", "OriginalFedly", "Kaos", 100, 120000, "L", "Bebas Cinta Fashion", "./media/Product/PF001.jpg");
INSERT INTO products VALUES ("PF002", "Kaos Makaroni", "OriginalFedly", "Kaos", 90, 120000, "M", "Bebas Cinta Fashion", "./media/Product/PF002.jpg");
INSERT INTO products VALUES ("PF003", "Kaos Makaroni", "OriginalFedly", "Kaos", 20, 120000, "S", "Bebas Cinta Fashion", "./media/Product/PF003.jpg");

INSERT INTO products VALUES ("PF004", "Celana Merah FD", "OriginalFedly", "Celana", 80, 100000, "L", "Bebas Cinta Fashion", "./media/Product/PF004.jpg");
INSERT INTO products VALUES ("PF005", "Celana Merah FD", "OriginalFedly", "Celana", 76, 100000, "M", "Bebas Cinta Fashion", "./media/Product/PF005.jpg");
INSERT INTO products VALUES ("PF006", "Celana Merah FD", "OriginalFedly", "Celana", 56, 100000, "S", "Bebas Cinta Fashion", "./media/Product/PF006.jpg");

INSERT INTO aboutus VALUES ("AUT", "Final Static Fashion is the new branded fashion online store that gather the most known branded outfit creator. We always care for our customer satisfify. Do not wait any longer. Lets go shopping with us, and become our member or seller.");