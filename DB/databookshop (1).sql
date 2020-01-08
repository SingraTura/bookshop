-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-01-2020 a las 12:14:41
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `databookshop`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `addAuthor` (IN `firstname` VARCHAR(200), IN `lastname` VARCHAR(200), IN `nationality` VARCHAR(200), IN `theme` VARCHAR(200))  NO SQL
BEGIN

declare themeId int DEFAULT(select theme.ThemeID from theme WHERE theme.ThemeName = theme);

insert into author (author.AuthorFirstname, author.AuthorLastname, author.AuthorNationality, author.AuthorTheme) 
VALUES
(firstname, lastname, nationality, themeId);


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addBook` (IN `isbn` VARCHAR(13), IN `tittle` VARCHAR(200), IN `authorFirstname` VARCHAR(200), IN `authorLastname` VARCHAR(200), IN `numPages` VARCHAR(200), IN `format` VARCHAR(200), IN `state` VARCHAR(200), IN `theme` VARCHAR(200), IN `price` VARCHAR(200))  NO SQL
BEGIN

DECLARE genderId int default (select theme.ThemeID from theme WHERE theme.ThemeName = theme);
DECLARE stateId int default (select state.StateID from state WHERE state.StateName = state);
DECLARE formatId int default (select format.formatId from format WHERE format.formatName = format);
DECLARE authorId int ;

call getIDAuthorByFullName(authorFirstname, authorLastname, authorId);


INSERT into `book`  (book.ISBN, book.Tittle, book.AuthorID, book.ThemeID  , book.NumberOfPages, book.FormatID  , book.StateID  , book.Price) 
values 			(isbn, tittle, authorId, genderId, numPages, formatId, stateId, price);



END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addFormat` (IN `formatName` VARCHAR(200))  NO SQL
BEGIN
insert into format (format.FormatName) VALUES (formatName);


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addState` (IN `stateName` VARCHAR(200))  NO SQL
BEGIN

insert into state (state.StateName) VALUES (stateName);


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addTheme` (IN `themeName` VARCHAR(200))  NO SQL
BEGIN

insert into theme (theme.ThemeName) VALUES (themeName);


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteBook` (IN `isbn` VARCHAR(13))  NO SQL
BEGIN

DELETE FROM `book` WHERE book.ISBN = ISBN;


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllAuthor` (OUT `allAuthor` VARCHAR(2000))  NO SQL
BEGIN
declare id int default '';
declare authorData varchar(2000) default '';
DECLARE cursor_author CURSOR FOR SELECT `author`.`AuthorID` FROM `author` WHERE  1;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET @finCursor = false;
set allAuthor = '';
open cursor_author;
set @finCursor = true;
FETCH cursor_author INTO id;
while @finCursor DO
    call getDataAuthor(id, authorData);
    set allAuthor = concat(allAuthor, authorData, '@');
    FETCH cursor_author INTO id;
    
END WHILE;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllBook` (OUT `allBooks` VARCHAR(20000))  NO SQL
BEGIN
declare isbn varchar(13) default '';
declare bookData varchar(2000) default '';
declare amount int;
DECLARE cursor_book CURSOR FOR SELECT `book`.`ISBN` FROM `book` WHERE  1;

DECLARE CONTINUE HANDLER FOR NOT FOUND SET @finCursor = false;
set allBooks = '';
open cursor_book;
set @finCursor = true;
FETCH cursor_book INTO isbn;
while @finCursor DO
    call getDataBook(isbn, bookData);
    set amount = (select bookshop.Amount from bookshop WHERE bookshop.ISBN = isbn);
    set allBooks = concat(allBooks, bookData,'%',amount, '@');
    FETCH cursor_book INTO isbn;
    
END WHILE;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllFormat` (OUT `allFormats` VARCHAR(20000))  NO SQL
BEGIN
declare id int default '';
declare formatData varchar(2000) default '';
DECLARE cursor_format CURSOR FOR SELECT `format`.`formatId` FROM `format` WHERE  1;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET @finCursor = false;
set allFormats = '';
open cursor_format;
set @finCursor = true;
FETCH cursor_format INTO id;
while @finCursor DO
    call getDataFormat(id, formatData);
    set allFormats = concat(allFormats, formatData, '@');
    FETCH cursor_format INTO id;
    
END WHILE;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllState` (OUT `allState` VARCHAR(2000))  NO SQL
BEGIN
declare id int default '';
declare stateData varchar(2000) default '';
DECLARE cursor_state CURSOR FOR SELECT `state`.`stateId` FROM `state` WHERE  1;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET @finCursor = false;
set allState = '';
open cursor_state;
set @finCursor = true;
FETCH cursor_state INTO id;
while @finCursor DO
    call getDataState(id, stateData);
    set allState = concat(allState, stateData, '@');
    FETCH cursor_state INTO id;
    
END WHILE;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllTheme` (OUT `allTheme` VARCHAR(2000))  NO SQL
BEGIN
declare id int default '';
declare themeData varchar(2000) default '';
DECLARE cursor_theme CURSOR FOR SELECT `theme`.`themeId` FROM `theme` WHERE  1;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET @finCursor = false;
set allTheme = '';
open cursor_theme;
set @finCursor = true;
FETCH cursor_theme INTO id;
while @finCursor DO
    call getDataTheme(id, themeData);
    set allTheme = concat(allTheme, themeData, '@');
    FETCH cursor_theme INTO id;
    
END WHILE;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAmount` (IN `ISBN` VARCHAR(13), OUT `amountData` VARCHAR(200))  NO SQL
BEGIN


set amountData = (SELECT bookshop.Amount from bookshop WHERE bookshop.ISBN = ISBN);



END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAmountBook` (IN `ISBN` VARCHAR(13), OUT `amount` VARCHAR(200))  NO SQL
BEGIN

set amount = (select bookshop.Amount from bookshop where bookshop.ISBN = ISBN);


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getDataAuthor` (IN `id` INT, OUT `dataAuthor` VARCHAR(200))  NO SQL
BEGIN
declare lastname varchar(200) default (select author.AuthorLastname from author WHERE author.authorID = id);
declare firstname varchar(200) default (select author.AuthorFirstname from author where author.authorID = id);

set dataAuthor = concat(firstname, ' ', lastname);


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getDataBook` (IN `isbn` VARCHAR(13), OUT `dataBook` VARCHAR(2000))  NO SQL
BEGIN

declare tittle varchar(200) default '';
declare authorName varchar(200) default '';
declare gender varchar(200) default '';
declare numPages varchar(200) default '';
declare state varchar(200) default '';
declare price varchar(200) default '';
declare amount varchar(200) default '';
DECLARE format varchar(200) default '';

declare genderId int;
declare stateId int;
declare formatId int;
declare authorId int;

set dataBook = '';

set dataBook = concat(dataBook, isbn, '%');
set tittle = (SELECT book.tittle from `book` WHERE book.ISBN = isbn);
set dataBook = concat(dataBook, tittle, '%');


set authorId = (SELECT book.AuthorID from `book` WHERE book.ISBN = isbn);
call getFullnameAuthorByID(authorID, authorName);
set dataBook = concat(dataBook, authorName, '%');

set genderId = (SELECT book.ThemeID from `book` WHERE
              book.ISBN = isbn);
set gender = (SELECT theme.themeName from `theme` WHERE
              theme.themeId = genderId);              
set dataBook = concat(dataBook, gender, '%');

set numPages = (SELECT book.NumberOfPages from `book` WHERE book.ISBN = isbn);
set dataBook = concat(dataBook, numPages, '%');

set formatId = (SELECT book.FormatID from `book` WHERE book.ISBN = isbn);
set format = (SELECT format.formatName from `format` WHERE format.formatId = formatId);
set dataBook = concat(dataBook, format, '%');

set stateId = (SELECT book.StateID from `book` WHERE book.ISBN = isbn);
set state = (SELECT state.stateName from `state` WHERE state.stateId = stateId);
set dataBook = concat(dataBook, state, '%');

set price = (SELECT book.price from `book` WHERE book.ISBN = isbn);
set dataBook = concat(dataBook, price);


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getDataFormat` (IN `id` INT, OUT `formatData` VARCHAR(2000))  NO SQL
BEGIN


set formatData = (select format.formatName from format where id = format.formatId);



END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getDataHistory` (IN `id` INT, OUT `dataH` VARCHAR(2000))  NO SQL
BEGIN
declare tittle varchar(200) default (select operationbookshop.Tittle from operationbookshop WHERE operationbookshop.OperationID = id);

declare isbn varchar(200) default (select operationbookshop.ISBN from operationbookshop WHERE operationbookshop.OperationID = id);

declare operation varchar(200) default (select operationbookshop.Operation from operationbookshop WHERE operationbookshop.OperationID = id);

declare total varchar(200) default (select operationbookshop.TotalBookAfterOperation from operationbookshop WHERE operationbookshop.OperationID = id);

declare dateH varchar(200) default (select operationbookshop.OperationDate from operationbookshop WHERE operationbookshop.OperationID = id);

set dataH='';

set dataH = concat(dataH, tittle, '%');
set dataH = concat(dataH, isbn, '%');
set dataH = concat(dataH, operation, '%');
set dataH = concat(dataH, total, '%');
set dataH = concat(dataH, dateH, '%');

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getDataState` (IN `id` INT, OUT `stateData` VARCHAR(2000))  NO SQL
BEGIN


set stateData = (select state.stateName from state where id = state.stateId);



END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getDataTheme` (IN `id` INT, OUT `themeData` VARCHAR(2000))  NO SQL
BEGIN


set themeData = (select theme.themeName from theme where id = theme.themeId);



END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getFullnameAuthorByID` (IN `id` INT, OUT `dataAuthor` VARCHAR(200))  NO SQL
BEGIN

declare firstname varchar(200) default (select author.AuthorFirstname from author where author.AuthorID = id);
declare lastname varchar(200) default (select author.AuthorLastname from author where author.AuthorID = id);

set dataAuthor = concat(firstname, " ", lastname);




END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHistory` (OUT `allData` VARCHAR(20000))  NO SQL
BEGIN
declare id int default '';
declare dataHistory varchar(2000) default '';
DECLARE cursor_history CURSOR FOR SELECT `operationbookshop`.`OperationID` FROM `operationbookshop` WHERE  1;

DECLARE CONTINUE HANDLER FOR NOT FOUND SET @finCursor = false;
set allData = '';
open cursor_history;
set @finCursor = true;
FETCH cursor_history INTO id;
while @finCursor DO
    call getDataHistory(id, dataHistory);
    set allData = concat(allData, dataHistory, '@');
    FETCH cursor_history INTO id;
    
END WHILE;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getIDAuthorByFullName` (IN `firstname` VARCHAR(200), IN `lastname` VARCHAR(200), OUT `id` INT)  NO SQL
BEGIN

set id = (select author.AuthorID from author where author.AuthorFirstname = firstname and author.AuthorLastname=lastname);


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `removeTheme` (IN `nameTheme` VARCHAR(200))  NO SQL
BEGIN

DELETE theme from theme WHERE theme.ThemeName = nameTheme;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateAmountBook` (IN `ISBN` VARCHAR(13), IN `amount` VARCHAR(200))  NO SQL
BEGIN

update bookshop set bookshop.Amount = amount where bookshop.ISBN = ISBN;



END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBook` (IN `isbn` VARCHAR(13), IN `tittle` VARCHAR(200), IN `firstname` VARCHAR(200), IN `lastname` VARCHAR(200), IN `numPages` VARCHAR(200), IN `formatName` VARCHAR(200), IN `stateName` VARCHAR(200), IN `themeName` VARCHAR(200), IN `price` VARCHAR(200))  NO SQL
begin 

declare authorID int;
declare themeID int;
declare formatID int;
declare stateID int;

call getIDAuthorByFullName(firstname, lastname, authorID);
set themeID = (select theme.ThemeID from theme where theme.ThemeName= themeName);
set formatID= (SELECT format.FormatID from format where format.FormatName = formatName);
set stateID= ( select state.StateID from state where state.StateName = stateName);


update book 
SET
	book.Tittle = tittle,
    book.ThemeID = themeID,
    book.AuthorID = authorID,
    book.NumberOfPages = numPages,
    book.FormatID = formatID,
    book.StateID = stateID,
    book.Price = price
where book.ISBN = isbn;
	

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `author`
--

CREATE TABLE `author` (
  `AuthorID` int(11) NOT NULL,
  `AuthorFirstname` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `AuthorLastname` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `AuthorNationality` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `AuthorTheme` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `author`
--

INSERT INTO `author` (`AuthorID`, `AuthorFirstname`, `AuthorLastname`, `AuthorNationality`, `AuthorTheme`) VALUES
(15, 'Franz', 'Kafka', 'Jewish', 4),
(16, 'Robert', 'Fisher', 'American', 7),
(17, 'George', 'Orwell', 'Indian', 10),
(18, 'Howard-Phillips', 'Lovecraft', 'American', 4),
(19, 'Miguel', 'Unamuno', 'Spanish', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `book`
--

CREATE TABLE `book` (
  `ISBN` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `Tittle` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `AuthorID` int(11) NOT NULL,
  `ThemeID` int(11) NOT NULL,
  `FormatID` int(11) NOT NULL,
  `StateID` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `NumberOfPages` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `book`
--

INSERT INTO `book` (`ISBN`, `Tittle`, `AuthorID`, `ThemeID`, `FormatID`, `StateID`, `Price`, `NumberOfPages`) VALUES
('9780368996467', 'The call of Cthulu', 18, 4, 3, 1, 20, 754),
('9781471331435', '1984', 17, 2, 2, 2, 42, 200),
('9781481540193', 'The metamorphosis', 15, 4, 1, 2, 15, 432),
('9781490995960', 'Niebla', 19, 6, 1, 1, 50, 128),
('9782940500789', 'The Knight in Rusty Armor', 16, 7, 1, 1, 25, 100),
('9788441421110', 'The Necronomicon', 18, 4, 3, 1, 30, 600),
('9788497770170', 'he Cat Who Found God', 16, 6, 1, 2, 52, 100),
('9788854119635', 'The Castle', 15, 1, 3, 1, 40, 532),
('9789516006140', 'San Manuel Bueno, martir', 19, 1, 3, 1, 50, 74),
('9789630793292', 'Animal Farm', 17, 10, 3, 1, 30, 350);

--
-- Disparadores `book`
--
DELIMITER $$
CREATE TRIGGER `bookAI` AFTER INSERT ON `book` FOR EACH ROW BEGIN

declare tittle varchar (200) DEFAULT (select book.Tittle from book where book.ISBN = new.isbn);

insert into `operationbookshop` (operationbookshop.Tittle, operationbookshop.ISBN, operationbookshop.Operation, operationbookshop.TotalBookAfterOperation) 
VALUES 
(tittle, new.isbn, "Added book", 1);

insert into `bookshop` (bookshop.ISBN, bookshop.Amount) 
VALUES 
( new.isbn, 1);

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bookAU` AFTER UPDATE ON `book` FOR EACH ROW BEGIN

declare amount int DEFAULT (select bookshop.Amount from bookshop WHERE bookshop.ISBN = new.isbn);

insert into `operationbookshop` (operationbookshop.Tittle, operationbookshop.ISBN, operationbookshop.Operation, operationbookshop.TotalBookAfterOperation)
VALUES 
(old.tittle, new.isbn, 'Book data update' , amount);


END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `bookBD` BEFORE DELETE ON `book` FOR EACH ROW BEGIN

declare tittle varchar (200) DEFAULT (select book.Tittle from book where book.ISBN = old.isbn);

insert into `operationbookshop` (operationbookshop.Tittle, operationbookshop.ISBN, operationbookshop.Operation, operationbookshop.TotalBookAfterOperation)
VALUES 
(tittle, old.isbn, "Delete book", 0);

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bookshop`
--

CREATE TABLE `bookshop` (
  `ISBN` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `Amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `bookshop`
--

INSERT INTO `bookshop` (`ISBN`, `Amount`) VALUES
('9789516006140', 1),
('9781490995960', 1),
('9780368996467', 1),
('9788441421110', 1),
('9788497770170', 1),
('9782940500789', 1),
('9789630793292', 1),
('9781471331435', 1),
('9788854119635', 1),
('9781481540193', 1);

--
-- Disparadores `bookshop`
--
DELIMITER $$
CREATE TRIGGER `bookshopBU` BEFORE UPDATE ON `bookshop` FOR EACH ROW BEGIN
declare operation varchar(200) default '';
declare tittle varchar (200) DEFAULT (select book.Tittle from book where book.ISBN = new.isbn);


if(old.Amount < new.Amount) then
set operation = 'Amount increased';
end if;

if(old.Amount > new.Amount) then
set operation = 'Amount decreased';
end if;

insert into `operationbookshop` (operationbookshop.Tittle, operationbookshop.ISBN, operationbookshop.Operation, operationbookshop.TotalBookAfterOperation)
VALUES 
(tittle, new.isbn, operation, new.Amount);

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `format`
--

CREATE TABLE `format` (
  `FormatID` int(11) NOT NULL,
  `FormatName` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `format`
--

INSERT INTO `format` (`FormatID`, `FormatName`) VALUES
(1, 'unbound'),
(2, 'rustic'),
(3, 'cantone');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operationbookshop`
--

CREATE TABLE `operationbookshop` (
  `OperationID` int(11) NOT NULL,
  `Tittle` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `ISBN` varchar(13) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Operation` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TotalBookAfterOperation` int(11) DEFAULT NULL,
  `OperationDate` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `operationbookshop`
--

INSERT INTO `operationbookshop` (`OperationID`, `Tittle`, `ISBN`, `Operation`, `TotalBookAfterOperation`, `OperationDate`) VALUES
(115, 'San Manuel Bueno, martir', '9789516006140', 'Added book', 1, '2019-12-02 21:33:57'),
(116, 'Niebla', '9781490995960', 'Added book', 1, '2019-12-02 21:33:57'),
(117, 'The call of Cthulu', '9780368996467', 'Added book', 1, '2019-12-02 21:33:57'),
(118, 'The Necronomicon', '9788441421110', 'Added book', 1, '2019-12-02 21:33:57'),
(119, 'he Cat Who Found God', '9788497770170', 'Added book', 1, '2019-12-02 21:33:57'),
(120, 'The Knight in Rusty Armor', '9782940500789', 'Added book', 1, '2019-12-02 21:33:57'),
(121, 'Animal Farm', '9789630793292', 'Added book', 1, '2019-12-02 21:33:57'),
(122, '1984', '9781471331435', 'Added book', 1, '2019-12-02 21:33:57'),
(123, 'The Castle', '9788854119635', 'Added book', 1, '2019-12-02 21:33:57'),
(124, 'The metamorphosis', '9781481540193', 'Added book', 1, '2019-12-02 21:33:57');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `state`
--

CREATE TABLE `state` (
  `StateID` int(11) NOT NULL,
  `StateName` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `state`
--

INSERT INTO `state` (`StateID`, `StateName`) VALUES
(1, 'reisue'),
(2, 'novelty');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `theme`
--

CREATE TABLE `theme` (
  `ThemeID` int(11) NOT NULL,
  `ThemeName` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `theme`
--

INSERT INTO `theme` (`ThemeID`, `ThemeName`) VALUES
(1, 'novel'),
(2, 'sciFi'),
(3, 'gothicNarrative'),
(4, 'horror'),
(5, 'romantic'),
(6, 'fantastic'),
(7, 'children'),
(8, 'drama'),
(9, 'historical'),
(10, 'dystopic'),
(11, 'mistery'),
(13, 'utopico'),
(16, 'prueba'),
(17, 'aaa');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`AuthorID`),
  ADD KEY `AuthorTheme` (`AuthorTheme`);

--
-- Indices de la tabla `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ISBN`),
  ADD KEY `AuthorID` (`AuthorID`),
  ADD KEY `ThemeID` (`ThemeID`),
  ADD KEY `FormatID` (`FormatID`),
  ADD KEY `FormatID_2` (`FormatID`),
  ADD KEY `StateID` (`StateID`);

--
-- Indices de la tabla `bookshop`
--
ALTER TABLE `bookshop`
  ADD KEY `ISBN` (`ISBN`);

--
-- Indices de la tabla `format`
--
ALTER TABLE `format`
  ADD PRIMARY KEY (`FormatID`);

--
-- Indices de la tabla `operationbookshop`
--
ALTER TABLE `operationbookshop`
  ADD PRIMARY KEY (`OperationID`);

--
-- Indices de la tabla `state`
--
ALTER TABLE `state`
  ADD PRIMARY KEY (`StateID`);

--
-- Indices de la tabla `theme`
--
ALTER TABLE `theme`
  ADD PRIMARY KEY (`ThemeID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `author`
--
ALTER TABLE `author`
  MODIFY `AuthorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `format`
--
ALTER TABLE `format`
  MODIFY `FormatID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `operationbookshop`
--
ALTER TABLE `operationbookshop`
  MODIFY `OperationID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=125;

--
-- AUTO_INCREMENT de la tabla `state`
--
ALTER TABLE `state`
  MODIFY `StateID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `theme`
--
ALTER TABLE `theme`
  MODIFY `ThemeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `AuthorR` FOREIGN KEY (`AuthorID`) REFERENCES `author` (`AuthorID`),
  ADD CONSTRAINT `formatR` FOREIGN KEY (`FormatID`) REFERENCES `format` (`FormatID`),
  ADD CONSTRAINT `stateR` FOREIGN KEY (`StateID`) REFERENCES `state` (`StateID`),
  ADD CONSTRAINT `themeR` FOREIGN KEY (`ThemeID`) REFERENCES `theme` (`ThemeID`);

--
-- Filtros para la tabla `bookshop`
--
ALTER TABLE `bookshop`
  ADD CONSTRAINT `ISBN` FOREIGN KEY (`ISBN`) REFERENCES `book` (`ISBN`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
