/*
Navicat MySQL Data Transfer

Source Server         : mySqlC
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : transdata

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-16 16:46:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for validate_rule_data
-- ----------------------------
DROP TABLE IF EXISTS `validate_rule_data`;
CREATE TABLE `validate_rule_data` (
  `data_valid_id` int(11) NOT NULL AUTO_INCREMENT,
  `enum_type_name` varchar(100) DEFAULT NULL,
  `string_arguments` varchar(255) DEFAULT NULL,
  `number_arguments` varchar(255) DEFAULT NULL,
  `double_arguments` varchar(255) DEFAULT NULL,
  `validate_entity_id` int(11) NOT NULL,
  PRIMARY KEY (`data_valid_id`),
  KEY `validate_rule_id` (`validate_entity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of validate_rule_data
-- ----------------------------
INSERT INTO `validate_rule_data` VALUES ('1', 'NOT_NULL', '', '', '', '1');
INSERT INTO `validate_rule_data` VALUES ('2', 'NOT_BLANK', '', '', '', '1');
INSERT INTO `validate_rule_data` VALUES ('3', 'NOT_EMPTY', '', '', '', '1');
INSERT INTO `validate_rule_data` VALUES ('4', 'MAX_LENGTH', '', '10', '', '1');
INSERT INTO `validate_rule_data` VALUES ('5', 'IS_NUMBER', '', '', '', '2');
INSERT INTO `validate_rule_data` VALUES ('6', 'MAX_VALUE', '', '99', '', '2');
INSERT INTO `validate_rule_data` VALUES ('7', 'MIN_VALUE', '', '1', '', '2');
INSERT INTO `validate_rule_data` VALUES ('8', 'NOT_NULL', '', '1', '', '2');
INSERT INTO `validate_rule_data` VALUES ('9', 'IS_FLOAT_NUMBER', '', '', '', '3');
INSERT INTO `validate_rule_data` VALUES ('10', 'NOT_NULL', '', '', '', '4');
INSERT INTO `validate_rule_data` VALUES ('11', 'NOT_NULL', '', '', '', '5');
INSERT INTO `validate_rule_data` VALUES ('12', 'MAX_LENGTH', '', '20', '', '5');
INSERT INTO `validate_rule_data` VALUES ('13', 'NOT_BLANK', '', '', '', '6');
INSERT INTO `validate_rule_data` VALUES ('14', 'NOT_EMPTY', '', '', '', '7');
INSERT INTO `validate_rule_data` VALUES ('15', 'IS_NUMBER', '', '', '', '8');
INSERT INTO `validate_rule_data` VALUES ('16', 'NOT_NULL', '', '', '', '9');
INSERT INTO `validate_rule_data` VALUES ('17', 'NOT_EMPTY', '', '', '', '9');
INSERT INTO `validate_rule_data` VALUES ('18', 'IS_DATE', '', '', '', '9');
INSERT INTO `validate_rule_data` VALUES ('19', 'NOT_NULL', '', '', '', '10');
INSERT INTO `validate_rule_data` VALUES ('20', 'NOT_EMPTY', '', '', '', '10');
INSERT INTO `validate_rule_data` VALUES ('21', 'MAX_LENGTH', '', '20', '', '10');
INSERT INTO `validate_rule_data` VALUES ('22', 'MIN_LENGTH', '', '3', '', '10');
INSERT INTO `validate_rule_data` VALUES ('23', 'NOT_NULL', '', '', '', '25');
INSERT INTO `validate_rule_data` VALUES ('24', 'NOT_BLANK', '', '', '', '25');
INSERT INTO `validate_rule_data` VALUES ('25', 'NOT_EMPTY', '', '', '', '25');
INSERT INTO `validate_rule_data` VALUES ('26', 'MAX_LENGTH', '', '10', '', '25');
INSERT INTO `validate_rule_data` VALUES ('27', 'IS_NUMBER', '', '', '', '26');
INSERT INTO `validate_rule_data` VALUES ('28', 'MAX_VALUE', '', '99', '', '26');
INSERT INTO `validate_rule_data` VALUES ('29', 'MIN_VALUE', '', '1', '', '26');
INSERT INTO `validate_rule_data` VALUES ('30', 'NOT_NULL', '', '1', '', '26');
INSERT INTO `validate_rule_data` VALUES ('31', 'IS_FLOAT_NUMBER', '', '', '', '27');
INSERT INTO `validate_rule_data` VALUES ('32', 'NOT_NULL', '', '', '', '27');
INSERT INTO `validate_rule_data` VALUES ('33', 'NOT_NULL', '', '', '', '28');
INSERT INTO `validate_rule_data` VALUES ('34', 'MAX_LENGTH', '', '20', '', '28');
INSERT INTO `validate_rule_data` VALUES ('35', 'NOT_BLANK', '', '', '', '29');
INSERT INTO `validate_rule_data` VALUES ('36', 'NOT_EMPTY', '', '', '', '30');
INSERT INTO `validate_rule_data` VALUES ('37', 'IS_NUMBER', '', '', '', '31');
INSERT INTO `validate_rule_data` VALUES ('38', 'NOT_NULL', '', '', '', '32');
INSERT INTO `validate_rule_data` VALUES ('39', 'NOT_EMPTY', '', '', '', '32');
INSERT INTO `validate_rule_data` VALUES ('40', 'IS_DATE', '', '', '', '32');
INSERT INTO `validate_rule_data` VALUES ('41', 'NOT_NULL', '', '', '', '33');
INSERT INTO `validate_rule_data` VALUES ('42', 'NOT_EMPTY', '', '', '', '33');
INSERT INTO `validate_rule_data` VALUES ('43', 'MAX_LENGTH', '', '20', '', '33');
INSERT INTO `validate_rule_data` VALUES ('44', 'MIN_LENGTH', '', '3', '', '33');
INSERT INTO `validate_rule_data` VALUES ('45', 'NOT_NULL', '', '', '', '73');
INSERT INTO `validate_rule_data` VALUES ('46', 'NOT_BLANK', '', '', '', '73');
INSERT INTO `validate_rule_data` VALUES ('47', 'NOT_EMPTY', '', '', '', '73');
INSERT INTO `validate_rule_data` VALUES ('48', 'MAX_LENGTH', '', '10', '', '73');
INSERT INTO `validate_rule_data` VALUES ('49', 'IS_NUMBER', '', '', '', '74');
INSERT INTO `validate_rule_data` VALUES ('50', 'MAX_VALUE', '', '99', '', '74');
INSERT INTO `validate_rule_data` VALUES ('51', 'MIN_VALUE', '', '1', '', '74');
INSERT INTO `validate_rule_data` VALUES ('52', 'NOT_NULL', '', '1', '', '74');
INSERT INTO `validate_rule_data` VALUES ('53', 'IS_FLOAT_NUMBER', '', '', '', '75');
INSERT INTO `validate_rule_data` VALUES ('54', 'NOT_NULL', '', '', '', '75');
INSERT INTO `validate_rule_data` VALUES ('55', 'NOT_NULL', '', '', '', '76');
INSERT INTO `validate_rule_data` VALUES ('56', 'MAX_LENGTH', '', '20', '', '76');
INSERT INTO `validate_rule_data` VALUES ('57', 'NOT_BLANK', '', '', '', '77');
INSERT INTO `validate_rule_data` VALUES ('58', 'NOT_EMPTY', '', '', '', '78');
INSERT INTO `validate_rule_data` VALUES ('59', 'IS_NUMBER', '', '', '', '79');
INSERT INTO `validate_rule_data` VALUES ('60', 'NOT_NULL', '', '', '', '80');
INSERT INTO `validate_rule_data` VALUES ('61', 'NOT_EMPTY', '', '', '', '80');
INSERT INTO `validate_rule_data` VALUES ('62', 'IS_DATE', '', '', '', '80');
INSERT INTO `validate_rule_data` VALUES ('63', 'NOT_NULL', '', '', '', '81');
INSERT INTO `validate_rule_data` VALUES ('64', 'NOT_EMPTY', '', '', '', '81');
INSERT INTO `validate_rule_data` VALUES ('65', 'MAX_LENGTH', '', '20', '', '81');
INSERT INTO `validate_rule_data` VALUES ('66', 'MIN_LENGTH', '', '3', '', '81');
INSERT INTO `validate_rule_data` VALUES ('67', 'NOT_NULL', '', '', '', '49');
INSERT INTO `validate_rule_data` VALUES ('68', 'NOT_BLANK', '', '', '', '49');
INSERT INTO `validate_rule_data` VALUES ('69', 'NOT_EMPTY', '', '', '', '49');
INSERT INTO `validate_rule_data` VALUES ('70', 'MAX_LENGTH', '', '10', '', '49');
INSERT INTO `validate_rule_data` VALUES ('71', 'IS_NUMBER', '', '', '', '50');
INSERT INTO `validate_rule_data` VALUES ('72', 'MAX_VALUE', '', '99', '', '50');
INSERT INTO `validate_rule_data` VALUES ('73', 'MIN_VALUE', '', '1', '', '50');
INSERT INTO `validate_rule_data` VALUES ('74', 'NOT_NULL', '', '1', '', '50');
INSERT INTO `validate_rule_data` VALUES ('75', 'IS_FLOAT_NUMBER', '', '', '', '51');
INSERT INTO `validate_rule_data` VALUES ('76', 'NOT_NULL', '', '', '', '52');
INSERT INTO `validate_rule_data` VALUES ('77', 'NOT_NULL', '', '', '', '53');
INSERT INTO `validate_rule_data` VALUES ('78', 'MAX_LENGTH', '', '20', '', '53');
INSERT INTO `validate_rule_data` VALUES ('79', 'NOT_BLANK', '', '', '', '54');
INSERT INTO `validate_rule_data` VALUES ('80', 'NOT_EMPTY', '', '', '', '55');
INSERT INTO `validate_rule_data` VALUES ('81', 'IS_NUMBER', '', '', '', '56');
INSERT INTO `validate_rule_data` VALUES ('82', 'NOT_NULL', '', '', '', '57');
INSERT INTO `validate_rule_data` VALUES ('83', 'NOT_EMPTY', '', '', '', '57');
INSERT INTO `validate_rule_data` VALUES ('84', 'IS_DATE', '', '', '', '57');
INSERT INTO `validate_rule_data` VALUES ('85', 'NOT_NULL', '', '', '', '58');
INSERT INTO `validate_rule_data` VALUES ('86', 'NOT_EMPTY', '', '', '', '58');
INSERT INTO `validate_rule_data` VALUES ('87', 'MAX_LENGTH', '', '20', '', '58');
INSERT INTO `validate_rule_data` VALUES ('88', 'MIN_LENGTH', '', '3', '', '58');
INSERT INTO `validate_rule_data` VALUES ('89', 'NOT_NULL', '', '', '', '97');
INSERT INTO `validate_rule_data` VALUES ('90', 'NOT_BLANK', '', '', '', '97');
INSERT INTO `validate_rule_data` VALUES ('91', 'NOT_EMPTY', '', '', '', '97');
INSERT INTO `validate_rule_data` VALUES ('92', 'MAX_LENGTH', '', '10', '', '97');
INSERT INTO `validate_rule_data` VALUES ('93', 'IS_NUMBER', '', '', '', '98');
INSERT INTO `validate_rule_data` VALUES ('94', 'MAX_VALUE', '', '99', '', '98');
INSERT INTO `validate_rule_data` VALUES ('95', 'MIN_VALUE', '', '1', '', '98');
INSERT INTO `validate_rule_data` VALUES ('96', 'NOT_NULL', '', '1', '', '98');
INSERT INTO `validate_rule_data` VALUES ('97', 'IS_FLOAT_NUMBER', '', '', '', '99');
INSERT INTO `validate_rule_data` VALUES ('98', 'NOT_NULL', '', '', '', '100');
INSERT INTO `validate_rule_data` VALUES ('99', 'NOT_NULL', '', '', '', '101');
INSERT INTO `validate_rule_data` VALUES ('100', 'MAX_LENGTH', '', '20', '', '101');
INSERT INTO `validate_rule_data` VALUES ('101', 'NOT_BLANK', '', '', '', '102');
INSERT INTO `validate_rule_data` VALUES ('102', 'NOT_EMPTY', '', '', '', '103');
INSERT INTO `validate_rule_data` VALUES ('103', 'IS_NUMBER', '', '', '', '104');
INSERT INTO `validate_rule_data` VALUES ('104', 'NOT_NULL', '', '', '', '105');
INSERT INTO `validate_rule_data` VALUES ('105', 'NOT_EMPTY', '', '', '', '105');
INSERT INTO `validate_rule_data` VALUES ('106', 'IS_DATE', '', '', '', '105');
INSERT INTO `validate_rule_data` VALUES ('107', 'NOT_NULL', '', '', '', '106');
INSERT INTO `validate_rule_data` VALUES ('108', 'NOT_EMPTY', '', '', '', '106');
INSERT INTO `validate_rule_data` VALUES ('109', 'MAX_LENGTH', '', '20', '', '106');
INSERT INTO `validate_rule_data` VALUES ('110', 'MIN_LENGTH', '', '3', '', '106');
