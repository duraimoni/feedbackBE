-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 10, 2019 at 04:23 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `feedback`
--
CREATE DATABASE IF NOT EXISTS `feedback` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `feedback`;

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

CREATE TABLE IF NOT EXISTS `application` (
  `app_id` int(3) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(100) NOT NULL,
  `app_desc` varchar(200) NOT NULL,
  `product_id` int(3) NOT NULL,
  `updtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updby` varchar(11) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`app_id`),
  KEY `product_id` (`product_id`,`updby`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`app_id`, `app_name`, `app_desc`, `product_id`, `updtime`, `updby`, `status`) VALUES
(1, 'myapplication', 'ethos', 1, '2019-02-26 15:27:23', '0', 1);

-- --------------------------------------------------------

--
-- Table structure for table `app_user`
--

CREATE TABLE IF NOT EXISTS `app_user` (
  `app_user_id` int(8) NOT NULL AUTO_INCREMENT,
  `app_id` int(4) NOT NULL,
  `domain_id` int(4) NOT NULL,
  `product_id` int(4) NOT NULL,
  `user_id` int(4) NOT NULL,
  `updtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updby` int(4) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`app_user_id`),
  KEY `app_id` (`app_id`,`user_id`),
  KEY `user_id` (`user_id`),
  KEY `domain_id` (`domain_id`,`product_id`),
  KEY `product_id` (`product_id`),
  KEY `app_id_2` (`app_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=70 ;

--
-- Dumping data for table `app_user`
--

INSERT INTO `app_user` (`app_user_id`, `app_id`, `domain_id`, `product_id`, `user_id`, `updtime`, `updby`, `status`) VALUES
(12, 1, 1, 1, 1, '2019-02-27 02:28:03', 0, 0),
(25, 1, 1, 1, 24, '2019-02-27 08:16:38', 0, 0),
(69, 1, 1, 1, 68, '2019-03-04 13:25:52', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `domain`
--

CREATE TABLE IF NOT EXISTS `domain` (
  `domain_id` int(2) NOT NULL AUTO_INCREMENT,
  `domain_name` varchar(10) NOT NULL,
  `domain_desc` varchar(250) NOT NULL,
  `domain_leader` int(4) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  `updtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updby` int(4) NOT NULL,
  PRIMARY KEY (`domain_id`),
  KEY `domain_leader` (`domain_leader`),
  KEY `domain_id` (`domain_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=76 ;

--
-- Dumping data for table `domain`
--

INSERT INTO `domain` (`domain_id`, `domain_name`, `domain_desc`, `domain_leader`, `status`, `updtime`, `updby`) VALUES
(1, 'DI-RE', 'RE nre', 1, -1, '2019-02-26 12:58:00', 0),
(2, 'DI-RF', 'RFC applicat', 1, 1, '2019-02-28 07:02:29', 1),
(3, 'DI-RG', 'customes', 1, 1, '2019-02-28 07:02:52', 0),
(71, 'DIRX', 'my app', 0, 0, '2019-03-10 13:44:49', 1),
(72, 'RK', 'KDls', 0, 1, '2019-03-10 14:10:58', 1),
(73, 'TF', 'JKSDF', 0, 1, '2019-03-10 14:13:26', 1),
(74, 'hsdf', 'dsfsd', 0, 1, '2019-03-10 14:13:53', 1),
(75, 'fsdf', 'dsf', 0, 1, '2019-03-10 14:14:26', 1);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(76);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(4) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `product_descrption` varchar(250) NOT NULL,
  `product_owner` int(4) NOT NULL,
  `updtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updby` varchar(100) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  `domain_id` int(3) NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `product_name` (`product_name`),
  KEY `product_owner` (`product_owner`),
  KEY `domain_id` (`domain_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `product_descrption`, `product_owner`, `updtime`, `updby`, `status`, `domain_id`) VALUES
(1, 'Nre', 'my project', 1, '2019-02-26 15:02:41', '', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(150) NOT NULL,
  `first_name` char(150) NOT NULL,
  `last_name` char(150) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  `updtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(200) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=69 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `password`, `first_name`, `last_name`, `status`, `updtime`, `email`) VALUES
(1, 'rkd', 'durai', 'Rathakrishnna', 'Duraimoni', 0, '2019-02-27 02:08:50', 'd.rathakrishnan@gmail.com'),
(3, 'rksd', 'durai', 'Rathakrishnna', 'Duraimondi', 0, '2019-02-27 02:10:01', ''),
(5, 'sure', 'durai', 'Rathakrishnna', 'Duraimondi', 0, '2019-02-27 02:13:12', ''),
(13, 'd', 'durai', 'Rathakrishnna', 'Duraimondi', 0, '2019-02-27 02:28:03', ''),
(24, 'sek', 'durai', 'sekar', 'Duraimoni', 1, '2019-02-27 08:16:38', ''),
(68, 'd_rathakrishnan@yahoo.co.in', 'ss', 'Duraimoni', '', 1, '2019-03-04 13:25:52', 'd.rathakrishnan@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  UNIQUE KEY `UK_it77eq964jhfqtu54081ebtio` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `application`
--
ALTER TABLE `application`
  ADD CONSTRAINT `application_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

--
-- Constraints for table `app_user`
--
ALTER TABLE `app_user`
  ADD CONSTRAINT `app_user_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `app_user_ibfk_6` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`domain_id`),
  ADD CONSTRAINT `app_user_ibfk_7` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  ADD CONSTRAINT `app_user_ibfk_8` FOREIGN KEY (`app_id`) REFERENCES `application` (`app_id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_3` FOREIGN KEY (`product_owner`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `product_ibfk_4` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`domain_id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  ADD CONSTRAINT `user_role_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
