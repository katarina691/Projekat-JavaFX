-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 19, 2020 at 12:52 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biblioteka`
--

-- --------------------------------------------------------

--
-- Table structure for table `izdateknjige`
--

CREATE TABLE `izdateknjige` (
  `ID` int(11) NOT NULL,
  `naziv` varchar(30) COLLATE utf32_bin NOT NULL,
  `autor` varchar(30) COLLATE utf32_bin NOT NULL,
  `godina` varchar(10) COLLATE utf32_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `izdateknjige`
--

INSERT INTO `izdateknjige` (`ID`, `naziv`, `autor`, `godina`) VALUES
(1, '#oteta', 'Toni Parsons', '2019.'),
(4, 'Devojka i noc', 'Gijom Muso', '2017.'),
(15, 'Crvena zvezda - moj fudbalski ', 'Bojan Ljubenovic', '2016.'),
(25, 'Smrt u oblacima', 'Vanja Dimitrijevic', '2019.');

-- --------------------------------------------------------

--
-- Table structure for table `raspoloziveknjige`
--

CREATE TABLE `raspoloziveknjige` (
  `ID` int(11) NOT NULL,
  `naziv` varchar(50) COLLATE utf32_bin NOT NULL,
  `autor` varchar(30) COLLATE utf32_bin NOT NULL,
  `godina` varchar(10) COLLATE utf32_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `raspoloziveknjige`
--

INSERT INTO `raspoloziveknjige` (`ID`, `naziv`, `autor`, `godina`) VALUES
(2, 'Covek po imenu Uve', 'Fredrik Bakman', '2017.'),
(3, 'The snowman', 'Ju Nesbe', ' 2015.'),
(5, 'Obloge od mastila', 'Bogdan Stevanovic', '2018.'),
(6, 'Istanbulska lala', 'Iskender Pala', '2019.'),
(7, 'Ples oko sunca', 'Vedrana Rudan', '2019.'),
(8, 'Neispricane price', 'Rajko Grlic', '2018.'),
(9, 'Leonardo Da Vinci', 'Volter Ajzakson', '2019.'),
(10, 'Agi i Ema', 'Igor Kolarov', '2016.'),
(11, 'Hipi', 'Paulo Koeljo', '2018.'),
(12, 'Magi - kao da je bila nekad', 'Dusan Vesic', '2018.'),
(13, 'Vecna carolija pocetka', 'Alojz Princ', '2012.'),
(14, 'Queen - da li je ovo pravi zivot?', 'Mark Blejk', '2019.'),
(17, 'Serviraj za pobedu', 'Novak Djokovic', '2013.'),
(18, 'Na Drini cuprija', 'Ivo Andric', '2001.'),
(20, 'Covek po imenu Uve', 'Fredrik Bakman', '2017.'),
(23, 'Vreme smrti', 'Dobrica Cosic', '1972.'),
(26, 'Starac i more', 'Ernest Hemingvej', '1951.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `izdateknjige`
--
ALTER TABLE `izdateknjige`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `raspoloziveknjige`
--
ALTER TABLE `raspoloziveknjige`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `izdateknjige`
--
ALTER TABLE `izdateknjige`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `raspoloziveknjige`
--
ALTER TABLE `raspoloziveknjige`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
