/*
Navicat MySQL Data Transfer

Source Server         : mySqlC
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : transdata

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-16 16:46:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for trunk_log
-- ----------------------------
DROP TABLE IF EXISTS `trunk_log`;
CREATE TABLE `trunk_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_number` varchar(20) DEFAULT NULL,
  `operator_no` varchar(10) DEFAULT NULL,
  `request_data_json` text,
  `response_data_json` text,
  `log_time` varchar(20) DEFAULT NULL,
  `trade_code` varchar(10) DEFAULT NULL,
  `user_status` varchar(10) DEFAULT NULL,
  `validate_status` varchar(10) DEFAULT NULL,
  `validate_log` text,
  `business_status` varchar(10) DEFAULT NULL,
  `business_Exception_Msg` text,
  `execute_Class` varchar(255) DEFAULT NULL,
  `execute_Method` varchar(255) DEFAULT NULL,
  `execute_Params` varchar(255) DEFAULT NULL,
  `response_Code` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
