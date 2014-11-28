-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2014 at 12:14 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `prisonbreak`
--

-- --------------------------------------------------------

--
-- Table structure for table `cell`
--

CREATE TABLE IF NOT EXISTS `cell` (
`cell_id` int(10) unsigned NOT NULL,
  `block_id` int(10) unsigned NOT NULL,
  `capacity` int(2) NOT NULL DEFAULT '5',
  `occupied` int(2) NOT NULL DEFAULT '0',
  `free` int(2) NOT NULL DEFAULT '5'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `guard`
--

CREATE TABLE IF NOT EXISTS `guard` (
`ID` int(4) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `date_of_birth` date NOT NULL,
  `gender` enum('M','F') DEFAULT NULL,
  `year_employed` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `role` varchar(25) NOT NULL DEFAULT 'All round',
  `shift_start` varchar(7) NOT NULL DEFAULT '8:00 am',
  `shift_end` varchar(7) NOT NULL DEFAULT '6:00 pm',
  `status` enum('Admin','ordinary') DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `station` enum('Block1','Block2','Block3','Block4','Block5') NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `guard`
--

INSERT INTO `guard` (`ID`, `first_name`, `last_name`, `address`, `date_of_birth`, `gender`, `year_employed`, `role`, `shift_start`, `shift_end`, `status`, `password`, `station`) VALUES
(1, 'Ali', 'Njie', 'new man nigga', '2014-09-02', 'M', '2014-11-26 16:33:36', 'Bath sick prisoners', '2014-11', '10th Ma', 'Admin', 'newman', 'Block2'),
(8, 'Rahab', 'Wangari', 'Nairobi 237', '2014-11-05', 'F', '2014-11-27 10:58:14', 'Good bathing', '4th Jun', 'Forever', 'ordinary', 'takesalifutolunch', 'Block4'),
(11, 'wjrfo', 'kjgnrkjgrn', 'kjbgkrk', '2014-11-27', 'M', '2014-11-28 06:05:36', 'kjgnkje', 'kjgnkjg', 'kjngkjn', 'Admin', 'kjngktntj', 'Block1');

-- --------------------------------------------------------

--
-- Table structure for table `prisonblock`
--

CREATE TABLE IF NOT EXISTS `prisonblock` (
`block_id` int(10) unsigned NOT NULL,
  `name` varchar(20) NOT NULL DEFAULT 'not stated',
  `location` enum('west','south','east','west','central') DEFAULT NULL,
  `capacity` int(5) NOT NULL DEFAULT '200',
  `occupied` int(5) NOT NULL DEFAULT '0',
  `free` int(5) NOT NULL DEFAULT '200',
  `built` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `prisoners`
--

CREATE TABLE IF NOT EXISTS `prisoners` (
`ID` int(4) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `date_of_birth` date NOT NULL,
  `gender` enum('M','F') DEFAULT NULL,
  `crime` varchar(255) NOT NULL,
  `date_imprisoned` date NOT NULL,
  `release_date` date NOT NULL,
  `other_crimes` varchar(255) NOT NULL,
  `cell_block` enum('1','2','3','4','5') DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `prisoners`
--

INSERT INTO `prisoners` (`ID`, `first_name`, `last_name`, `address`, `date_of_birth`, `gender`, `crime`, `date_imprisoned`, `release_date`, `other_crimes`, `cell_block`) VALUES
(9, 'lnrw', 'kwjnwk', 'kjngkw', '2014-11-20', 'F', 'lqknflw', '2014-11-19', '2014-11-03', 'jg nkjw gwl', ''),
(10, 'kejnrjn', 'kjgnjrek', 'kjgnjkr', '1989-12-12', 'M', 'jskjdsk', '1989-12-12', '1989-12-12', 'Stealing', ''),
(11, 'Nathan', 'A', 'Ashesi 123', '1984-11-16', 'M', 'Poor grading ', '2014-11-28', '2014-12-29', 'Not yet', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cell`
--
ALTER TABLE `cell`
 ADD PRIMARY KEY (`cell_id`);

--
-- Indexes for table `guard`
--
ALTER TABLE `guard`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `prisonblock`
--
ALTER TABLE `prisonblock`
 ADD PRIMARY KEY (`block_id`);

--
-- Indexes for table `prisoners`
--
ALTER TABLE `prisoners`
 ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cell`
--
ALTER TABLE `cell`
MODIFY `cell_id` int(10) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `guard`
--
ALTER TABLE `guard`
MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `prisonblock`
--
ALTER TABLE `prisonblock`
MODIFY `block_id` int(10) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `prisoners`
--
ALTER TABLE `prisoners`
MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
