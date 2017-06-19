/*
Navicat MySQL Data Transfer

Source Server         : mySqlC
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : transdata

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-16 16:46:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for business_model
-- ----------------------------
DROP TABLE IF EXISTS `business_model`;
CREATE TABLE `business_model` (
  `model_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_class_name` varchar(255) DEFAULT NULL,
  `service_path` varchar(255) DEFAULT NULL,
  `service_bean_name` varchar(255) DEFAULT NULL,
  `method_name` varchar(100) DEFAULT NULL,
  `paramter_object` varchar(255) DEFAULT NULL,
  `paramter_class` varchar(255) DEFAULT NULL,
  `busi_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`model_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_model
-- ----------------------------
INSERT INTO `business_model` VALUES ('1', null, null, 'testBusinessService', 'testObject', null, 'com.creditapp.test.dojo.TestObject', null);
INSERT INTO `business_model` VALUES ('2', null, null, 'testDataBusinessService', 'reciveTestObject', null, 'com.creditapp.test.dojo.TestDataEntity', 'testTrans1');
