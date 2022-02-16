-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 16, 2022 at 09:28 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projectgrape`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `accountID` int(11) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `accountType` varchar(10) NOT NULL,
  `salt` varchar(50) NOT NULL,
  `hash` mediumtext NOT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`accountID`, `userName`, `nickname`, `accountType`, `salt`, `hash`, `email`) VALUES
(8, 'Chris', NULL, 'Student', 'J9WRSKNI8Z', 'E96655AED50C0994273204E4671B14CD74B2E2FD43ADCB8730705C6DC73B7B87', NULL),
(9, 'David', NULL, 'Student', '8JRL6RQGPA', 'EF5F57568AC917FD396C9C14CB681B4662CDBAD7905374BCE6EFD1E553D14CB7', NULL),
(10, 'AnthonyLacy', NULL, 'Student', 'NDGRXYCLWX', 'B05FFAC1CAA417BB6DC396F4D9EEA158BBB513E696756EB9AE43954BF33A0A6D', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `assessment`
--

CREATE TABLE `assessment` (
  `assessmentID` int(11) NOT NULL,
  `assessmentLevel` int(11) NOT NULL,
  `tag` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `assessmentquestions`
--

CREATE TABLE `assessmentquestions` (
  `assessmentID` int(11) NOT NULL,
  `questionID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `classroom`
--

CREATE TABLE `classroom` (
  `classID` int(11) NOT NULL,
  `teacherID` int(11) NOT NULL,
  `className` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `classstudent`
--

CREATE TABLE `classstudent` (
  `classID` int(11) NOT NULL,
  `studentID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `questionID` int(11) NOT NULL,
  `questionLevel` int(11) NOT NULL,
  `questionText` varchar(255) NOT NULL,
  `questionAnswer` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`questionID`, `questionLevel`, `questionText`, `questionAnswer`, `tag`) VALUES
(1, 1, '1 + 1 ', '2', 'Addition'),
(2, 1, '5 + 5', '10', 'Addition'),
(3, 1, '2 + 2', '4', 'Addition'),
(4, 1, '5 - 3', '2', 'Subtraction'),
(5, 1, '10 - 5', '5', 'Subtraction'),
(6, 1, '1 * 1', '1', 'Multiplication'),
(7, 1, '2 * 2', '4', 'Multiplication'),
(8, 1, '4 / 2', '2', 'Division'),
(9, 1, '25 / 5', '5', 'Division');

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

CREATE TABLE `score` (
  `scoreID` int(11) NOT NULL,
  `accountID` int(11) NOT NULL,
  `assessmentID` int(11) NOT NULL,
  `gradePercent` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`accountID`);

--
-- Indexes for table `assessment`
--
ALTER TABLE `assessment`
  ADD PRIMARY KEY (`assessmentID`);

--
-- Indexes for table `classroom`
--
ALTER TABLE `classroom`
  ADD PRIMARY KEY (`classID`),
  ADD KEY `classroomforeign` (`teacherID`);

--
-- Indexes for table `classstudent`
--
ALTER TABLE `classstudent`
  ADD PRIMARY KEY (`classID`),
  ADD KEY `studentforeign` (`studentID`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`questionID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `accountID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `assessment`
--
ALTER TABLE `assessment`
  MODIFY `assessmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `classroom`
--
ALTER TABLE `classroom`
  MODIFY `classID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `classstudent`
--
ALTER TABLE `classstudent`
  MODIFY `classID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `questionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `classroom`
--
ALTER TABLE `classroom`
  ADD CONSTRAINT `classroomforeign` FOREIGN KEY (`teacherID`) REFERENCES `account` (`accountID`);

--
-- Constraints for table `classstudent`
--
ALTER TABLE `classstudent`
  ADD CONSTRAINT `classstudentforeign` FOREIGN KEY (`classID`) REFERENCES `classroom` (`classID`),
  ADD CONSTRAINT `studentforeign` FOREIGN KEY (`studentID`) REFERENCES `account` (`accountID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
