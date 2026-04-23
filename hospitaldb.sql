-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2026 at 04:01 PM
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
-- Database: `hospitaldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`email`, `password`) VALUES
('admin@gmail.com', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `appiontment`
--

CREATE TABLE `appiontment` (
  `AID` int(10) NOT NULL,
  `ADoctor` varchar(30) NOT NULL,
  `APatient` varchar(30) NOT NULL,
  `ADate` varchar(50) NOT NULL,
  `ATime` varchar(20) NOT NULL,
  `AStatus` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appiontment`
--

INSERT INTO `appiontment` (`AID`, `ADoctor`, `APatient`, `ADate`, `ATime`, `AStatus`) VALUES
(1, 'chandu', 'Prasad Pawar', '2026-02-12', '11:11', 'aaaaa'),
(2, 'prasad', 'Prasad Pawar', '2026-02-19', '11:11', 'aaaaa'),
(4, 'Dr.Tushar Badgujar', 'Prasad Pawar', '2026-04-15', '10:01', 'a');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `DID` int(10) NOT NULL,
  `DName` varchar(30) NOT NULL,
  `DGender` varchar(10) NOT NULL,
  `DSpecialization` varchar(100) NOT NULL,
  `DContact` varchar(10) NOT NULL,
  `DEmail` varchar(20) NOT NULL,
  `DPassword` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`DID`, `DName`, `DGender`, `DSpecialization`, `DContact`, `DEmail`, `DPassword`) VALUES
(1, 'Dr.Hemant Badgujar', 'Male', 'Orthopedics', '8866402155', 'hemant@gmail.com', 'hemant12'),
(2, 'Dr.Tushar Badgujar', 'Male', 'surgical subspecialties', '9322319811', 'tushar@gmail.com', 'tushar123');

-- --------------------------------------------------------

--
-- Table structure for table `doctor_request`
--

CREATE TABLE `doctor_request` (
  `DID` int(10) NOT NULL,
  `DName` varchar(20) NOT NULL,
  `DGender` varchar(10) NOT NULL,
  `DSpecialization` varchar(50) NOT NULL,
  `DContact` varchar(20) NOT NULL,
  `DEmail` varchar(50) NOT NULL,
  `DPassword` varchar(20) NOT NULL,
  `Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `PID` int(10) NOT NULL,
  `PName` varchar(30) NOT NULL,
  `PAge` int(2) NOT NULL,
  `PGender` varchar(10) NOT NULL,
  `PContact` varchar(15) NOT NULL,
  `PAddress` varchar(50) NOT NULL,
  `PEmail` varchar(20) NOT NULL,
  `PPassword` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`PID`, `PName`, `PAge`, `PGender`, `PContact`, `PAddress`, `PEmail`, `PPassword`) VALUES
(1, 'Rohit Badgujar', 20, 'Male', '932288174', 'Shahada', 'rohit@gmail.com', 'rohit123'),
(2, 'Prasad Pawar', 20, 'Male', '23654789', 'Sakari', 'prasad@gmail.com', 'prasad12'),
(3, 'Harshal Patil', 20, 'Male', '7584938574', 'Sarangkheda', 'harshal@gmail.com', 'harshal123'),
(4, 'rohan nikam', 22, 'Male', '9388484848', 'nashik', 'rohan@gmail.com', 'rohan123');

-- --------------------------------------------------------

--
-- Table structure for table `prescription`
--

CREATE TABLE `prescription` (
  `PRID` int(10) NOT NULL,
  `PRAppointment` int(50) NOT NULL,
  `PRDoctor_ID` int(10) NOT NULL,
  `PRPrescription_Text` int(50) NOT NULL,
  `PRDate` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appiontment`
--
ALTER TABLE `appiontment`
  ADD PRIMARY KEY (`AID`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`DID`);

--
-- Indexes for table `doctor_request`
--
ALTER TABLE `doctor_request`
  ADD PRIMARY KEY (`DID`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`PID`);

--
-- Indexes for table `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`PRID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appiontment`
--
ALTER TABLE `appiontment`
  MODIFY `AID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `DID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `doctor_request`
--
ALTER TABLE `doctor_request`
  MODIFY `DID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `PID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `prescription`
--
ALTER TABLE `prescription`
  MODIFY `PRID` int(10) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
