-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 23, 2022 at 09:37 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

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
(8, 'Chris', NULL, 'Student', 'J9WRSKNI8Z', 'E96655AED50C0994273204E4671B14CD74B2E2FD43ADCB8730705C6DC73B7B87', 'chrislnk12@gmail.com'),
(9, 'David', NULL, 'Student', '8JRL6RQGPA', 'EF5F57568AC917FD396C9C14CB681B4662CDBAD7905374BCE6EFD1E553D14CB7', NULL),
(10, 'AnthonyLacy', NULL, 'Student', 'NDGRXYCLWX', 'B05FFAC1CAA417BB6DC396F4D9EEA158BBB513E696756EB9AE43954BF33A0A6D', NULL),
(17, 'Mr. Teacher', NULL, 'Teacher', 'WW7LY4V5XP', 'F8B4CE9EAAD0977A54187FA2897A09F9504EB065920B03B5CE57B0927E9EE168', NULL),
(18, 'jackson', NULL, 'Student', '0W209V1P3Y', 'B10BADBAF5487D788D9E460F5B8234AE12383475263AFDA65EB83938EC85DB4E', NULL);

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

--
-- Dumping data for table `classroom`
--

INSERT INTO `classroom` (`classID`, `teacherID`, `className`) VALUES
(5, 17, 'New class');

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
-- Table structure for table `grade`
--

CREATE TABLE `grade` (
  `gradeID` int(11) NOT NULL,
  `accountID` int(11) NOT NULL,
  `assessmentID` int(11) NOT NULL
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
(9, 1, '25 / 5', '5', 'Division'),
(10, 1, '3 + 3', '6', 'Addition'),
(11, 1, '4 + 4', '8', 'Addition'),
(12, 1, '6 + 6', '12', 'Addition'),
(13, 1, '7 + 7', '14', 'Addition'),
(14, 1, '8 + 8', '16', 'Addition'),
(15, 1, '9 + 9', '18', 'Addition'),
(16, 1, '10 + 10', '20', 'Addition'),
(17, 1, '9 - 3', '6', 'Subtraction'),
(18, 1, '2 - 2', '0', 'Subtraction'),
(19, 1, '8 - 1', '7', 'Subtraction'),
(20, 1, '3 - 0', '3', 'Subtraction'),
(21, 1, '7 - 6', '1', 'Subtraction'),
(22, 1, '10 - 6', '4', 'Subtraction'),
(23, 1, '4 - 2', '2', 'Subtraction'),
(24, 1, '5 - 0', '5', 'Subtraction'),
(25, 1, '9 - 7', '2', 'Subtraction'),
(26, 1, '6 - 1', '5', 'Subtraction'),
(27, 1, '8 - 8', '0', 'Subtraction'),
(28, 1, '8 * 5', '40', 'Multiplication'),
(29, 1, '7 * 4', '28', 'Multiplication'),
(30, 1, '6 * 3', '18', 'Multiplication'),
(31, 1, '5 * 2', '10', 'Multiplication'),
(32, 1, '4 * 1', '4', 'Multiplication'),
(33, 1, '3 * 8', '24', 'Multiplication'),
(34, 1, '2 * 7', '14', 'Multiplication'),
(35, 1, '1 * 6', '6', 'Multiplication'),
(36, 1, '8 / 2', '4', 'Division'),
(37, 1, '9 / 3', '3', 'Division'),
(38, 1, '16 / 4', '4', 'Division'),
(39, 1, '10 / 5', '2', 'Division'),
(40, 1, '18 / 2', '9', 'Division'),
(41, 1, '3 / 1', '3', 'Division'),
(42, 1, '12 / 6', '2', 'Division'),
(43, 1, '9 / 9', '1', 'Division');

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

CREATE TABLE `score` (
  `scoreID` int(11) NOT NULL,
  `gradeID` int(11) NOT NULL,
  `questionNumber` int(11) NOT NULL,
  `userAnswer` varchar(50) NOT NULL,
  `isCorrect` tinyint(1) NOT NULL
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
  ADD KEY `studentforeign` (`studentID`),
  ADD KEY `classID` (`classID`) USING BTREE;

--
-- Indexes for table `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`gradeID`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`questionID`);

--
-- Indexes for table `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`scoreID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `accountID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `assessment`
--
ALTER TABLE `assessment`
  MODIFY `assessmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `classroom`
--
ALTER TABLE `classroom`
  MODIFY `classID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `grade`
--
ALTER TABLE `grade`
  MODIFY `gradeID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `questionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `score`
--
ALTER TABLE `score`
  MODIFY `scoreID` int(11) NOT NULL AUTO_INCREMENT;

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
