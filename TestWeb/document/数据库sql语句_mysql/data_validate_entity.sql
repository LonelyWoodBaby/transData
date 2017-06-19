/*
Navicat MySQL Data Transfer

Source Server         : mySqlC
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : transdata

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-16 16:46:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for data_validate_entity
-- ----------------------------
DROP TABLE IF EXISTS `data_validate_entity`;
CREATE TABLE `data_validate_entity` (
  `data_validate_id` int(11) NOT NULL AUTO_INCREMENT,
  `buss_code` varchar(10) DEFAULT NULL,
  `data_valid_name` varchar(100) DEFAULT NULL,
  `validate_rule_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`data_validate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_validate_entity
-- ----------------------------
INSERT INTO `data_validate_entity` VALUES ('1', 'testTrans1', 'name1', ' ');
INSERT INTO `data_validate_entity` VALUES ('2', 'testTrans1', 'age1', ' ');
INSERT INTO `data_validate_entity` VALUES ('3', 'testTrans1', 'salay1', ' ');
INSERT INTO `data_validate_entity` VALUES ('4', 'testTrans1', 'work1', ' ');
INSERT INTO `data_validate_entity` VALUES ('5', 'testTrans1', 'username1', ' ');
INSERT INTO `data_validate_entity` VALUES ('6', 'testTrans1', 'firstName1', ' ');
INSERT INTO `data_validate_entity` VALUES ('7', 'testTrans1', 'babyName1', ' ');
INSERT INTO `data_validate_entity` VALUES ('8', 'testTrans1', 'getMoney1', ' ');
INSERT INTO `data_validate_entity` VALUES ('9', 'testTrans1', 'birthday1', ' ');
INSERT INTO `data_validate_entity` VALUES ('10', 'testTrans1', 'depaName1', ' ');
INSERT INTO `data_validate_entity` VALUES ('11', 'testTrans1', 'cause1', ' ');
INSERT INTO `data_validate_entity` VALUES ('12', 'testTrans1', 'sendDate1', ' ');
INSERT INTO `data_validate_entity` VALUES ('13', 'testTrans1', 'sendType1', ' ');
INSERT INTO `data_validate_entity` VALUES ('14', 'testTrans1', 'isDeadLine1', ' ');
INSERT INTO `data_validate_entity` VALUES ('15', 'testTrans1', 'sign1', ' ');
INSERT INTO `data_validate_entity` VALUES ('16', 'testTrans1', 'signDate1', ' ');
INSERT INTO `data_validate_entity` VALUES ('17', 'testTrans1', 'myJugment1', ' ');
INSERT INTO `data_validate_entity` VALUES ('18', 'testTrans1', 'telephone1', ' ');
INSERT INTO `data_validate_entity` VALUES ('19', 'testTrans1', 'phoneNumber1', ' ');
INSERT INTO `data_validate_entity` VALUES ('20', 'testTrans1', 'appname1', ' ');
INSERT INTO `data_validate_entity` VALUES ('21', 'testTrans1', 'appprice1', ' ');
INSERT INTO `data_validate_entity` VALUES ('22', 'testTrans1', 'appdate1', ' ');
INSERT INTO `data_validate_entity` VALUES ('23', 'testTrans1', 'gamename1', ' ');
INSERT INTO `data_validate_entity` VALUES ('24', 'testTrans1', 'gameprice1', ' ');
INSERT INTO `data_validate_entity` VALUES ('25', 'testTrans2', '2name', ' ');
INSERT INTO `data_validate_entity` VALUES ('26', 'testTrans2', '2age', ' ');
INSERT INTO `data_validate_entity` VALUES ('27', 'testTrans2', '2salary', ' ');
INSERT INTO `data_validate_entity` VALUES ('28', 'testTrans2', '2work', ' ');
INSERT INTO `data_validate_entity` VALUES ('29', 'testTrans2', '2username', ' ');
INSERT INTO `data_validate_entity` VALUES ('30', 'testTrans2', '2firstName', ' ');
INSERT INTO `data_validate_entity` VALUES ('31', 'testTrans2', '2babyName', ' ');
INSERT INTO `data_validate_entity` VALUES ('32', 'testTrans2', '2getMoney', ' ');
INSERT INTO `data_validate_entity` VALUES ('33', 'testTrans2', '2birthday', ' ');
INSERT INTO `data_validate_entity` VALUES ('34', 'testTrans2', '2depaName', ' ');
INSERT INTO `data_validate_entity` VALUES ('35', 'testTrans2', '2cause', ' ');
INSERT INTO `data_validate_entity` VALUES ('36', 'testTrans2', '2sendDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('37', 'testTrans2', '2sendType', ' ');
INSERT INTO `data_validate_entity` VALUES ('38', 'testTrans2', '2isDeadLine', ' ');
INSERT INTO `data_validate_entity` VALUES ('39', 'testTrans2', '2sign', ' ');
INSERT INTO `data_validate_entity` VALUES ('40', 'testTrans2', '2signDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('41', 'testTrans2', '2myJugment', ' ');
INSERT INTO `data_validate_entity` VALUES ('42', 'testTrans2', '2telephone', ' ');
INSERT INTO `data_validate_entity` VALUES ('43', 'testTrans2', '2phoneNumber', ' ');
INSERT INTO `data_validate_entity` VALUES ('44', 'testTrans2', '2appname', ' ');
INSERT INTO `data_validate_entity` VALUES ('45', 'testTrans2', '2appprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('46', 'testTrans2', '2appdate', ' ');
INSERT INTO `data_validate_entity` VALUES ('47', 'testTrans2', '2gamename', ' ');
INSERT INTO `data_validate_entity` VALUES ('48', 'testTrans2', '2gameprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('49', 'testTrans4', '4name', ' ');
INSERT INTO `data_validate_entity` VALUES ('50', 'testTrans4', '4age', ' ');
INSERT INTO `data_validate_entity` VALUES ('51', 'testTrans4', '4salary', ' ');
INSERT INTO `data_validate_entity` VALUES ('52', 'testTrans4', '4work', ' ');
INSERT INTO `data_validate_entity` VALUES ('53', 'testTrans4', '4username', ' ');
INSERT INTO `data_validate_entity` VALUES ('54', 'testTrans4', '4firstName', ' ');
INSERT INTO `data_validate_entity` VALUES ('55', 'testTrans4', '4babyName', ' ');
INSERT INTO `data_validate_entity` VALUES ('56', 'testTrans4', '4getMoney', ' ');
INSERT INTO `data_validate_entity` VALUES ('57', 'testTrans4', '4birthday', ' ');
INSERT INTO `data_validate_entity` VALUES ('58', 'testTrans4', '4depaName', ' ');
INSERT INTO `data_validate_entity` VALUES ('59', 'testTrans4', '4cause', ' ');
INSERT INTO `data_validate_entity` VALUES ('60', 'testTrans4', '4sendDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('61', 'testTrans4', '4sendType', ' ');
INSERT INTO `data_validate_entity` VALUES ('62', 'testTrans4', '4isDeadLine', ' ');
INSERT INTO `data_validate_entity` VALUES ('63', 'testTrans4', '4sign', ' ');
INSERT INTO `data_validate_entity` VALUES ('64', 'testTrans4', '4signDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('65', 'testTrans4', '4myJugment', ' ');
INSERT INTO `data_validate_entity` VALUES ('66', 'testTrans4', '4telephone', ' ');
INSERT INTO `data_validate_entity` VALUES ('67', 'testTrans4', '4phoneNumber', ' ');
INSERT INTO `data_validate_entity` VALUES ('68', 'testTrans4', '4appname', ' ');
INSERT INTO `data_validate_entity` VALUES ('69', 'testTrans4', '4appprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('70', 'testTrans4', '4appdate', ' ');
INSERT INTO `data_validate_entity` VALUES ('71', 'testTrans4', '4gamename', ' ');
INSERT INTO `data_validate_entity` VALUES ('72', 'testTrans4', '4gameprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('73', 'testTrans3', '3name', ' ');
INSERT INTO `data_validate_entity` VALUES ('74', 'testTrans3', '3age', ' ');
INSERT INTO `data_validate_entity` VALUES ('75', 'testTrans3', '3salary', ' ');
INSERT INTO `data_validate_entity` VALUES ('76', 'testTrans3', '3work', ' ');
INSERT INTO `data_validate_entity` VALUES ('77', 'testTrans3', '3username', ' ');
INSERT INTO `data_validate_entity` VALUES ('78', 'testTrans3', '3firstName', ' ');
INSERT INTO `data_validate_entity` VALUES ('79', 'testTrans3', '3babyName', ' ');
INSERT INTO `data_validate_entity` VALUES ('80', 'testTrans3', '3getMoney', ' ');
INSERT INTO `data_validate_entity` VALUES ('81', 'testTrans3', '3birthday', ' ');
INSERT INTO `data_validate_entity` VALUES ('82', 'testTrans3', '3depaName', ' ');
INSERT INTO `data_validate_entity` VALUES ('83', 'testTrans3', '3cause', ' ');
INSERT INTO `data_validate_entity` VALUES ('84', 'testTrans3', '3sendDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('85', 'testTrans3', '3sendType', ' ');
INSERT INTO `data_validate_entity` VALUES ('86', 'testTrans3', '3isDeadLine', ' ');
INSERT INTO `data_validate_entity` VALUES ('87', 'testTrans3', '3sign', ' ');
INSERT INTO `data_validate_entity` VALUES ('88', 'testTrans3', '3signDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('89', 'testTrans3', '3myJugment', ' ');
INSERT INTO `data_validate_entity` VALUES ('90', 'testTrans3', '3telephone', ' ');
INSERT INTO `data_validate_entity` VALUES ('91', 'testTrans3', '3phoneNumber', ' ');
INSERT INTO `data_validate_entity` VALUES ('92', 'testTrans3', '3appname', ' ');
INSERT INTO `data_validate_entity` VALUES ('93', 'testTrans3', '3appprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('94', 'testTrans3', '3appdate', ' ');
INSERT INTO `data_validate_entity` VALUES ('95', 'testTrans3', '3gamename', ' ');
INSERT INTO `data_validate_entity` VALUES ('96', 'testTrans3', '3gameprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('97', 'testTrans5', '5name', ' ');
INSERT INTO `data_validate_entity` VALUES ('98', 'testTrans5', '5age', ' ');
INSERT INTO `data_validate_entity` VALUES ('99', 'testTrans5', '5salary', ' ');
INSERT INTO `data_validate_entity` VALUES ('100', 'testTrans5', '5work', ' ');
INSERT INTO `data_validate_entity` VALUES ('101', 'testTrans5', '5username', ' ');
INSERT INTO `data_validate_entity` VALUES ('102', 'testTrans5', '5firstName', ' ');
INSERT INTO `data_validate_entity` VALUES ('103', 'testTrans5', '5babyName', ' ');
INSERT INTO `data_validate_entity` VALUES ('104', 'testTrans5', '5getMoney', ' ');
INSERT INTO `data_validate_entity` VALUES ('105', 'testTrans5', '5birthday', ' ');
INSERT INTO `data_validate_entity` VALUES ('106', 'testTrans5', '5depaName', ' ');
INSERT INTO `data_validate_entity` VALUES ('107', 'testTrans5', '5cause', ' ');
INSERT INTO `data_validate_entity` VALUES ('108', 'testTrans5', '5sendDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('109', 'testTrans5', '5sendType', ' ');
INSERT INTO `data_validate_entity` VALUES ('110', 'testTrans5', '5isDeadLine', ' ');
INSERT INTO `data_validate_entity` VALUES ('111', 'testTrans5', '5sign', ' ');
INSERT INTO `data_validate_entity` VALUES ('112', 'testTrans5', '5signDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('113', 'testTrans5', '5myJugment', ' ');
INSERT INTO `data_validate_entity` VALUES ('114', 'testTrans5', '5telephone', ' ');
INSERT INTO `data_validate_entity` VALUES ('115', 'testTrans5', '5phoneNumber', ' ');
INSERT INTO `data_validate_entity` VALUES ('116', 'testTrans5', '5appname', ' ');
INSERT INTO `data_validate_entity` VALUES ('117', 'testTrans5', '5appprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('118', 'testTrans5', '5appdate', ' ');
INSERT INTO `data_validate_entity` VALUES ('119', 'testTrans5', '5gamename', ' ');
INSERT INTO `data_validate_entity` VALUES ('120', 'testTrans5', '5gameprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('121', 'testTrans6', '6name', ' ');
INSERT INTO `data_validate_entity` VALUES ('122', 'testTrans6', '6age', ' ');
INSERT INTO `data_validate_entity` VALUES ('123', 'testTrans6', '6salary', ' ');
INSERT INTO `data_validate_entity` VALUES ('124', 'testTrans6', '6work', ' ');
INSERT INTO `data_validate_entity` VALUES ('125', 'testTrans6', '6username', ' ');
INSERT INTO `data_validate_entity` VALUES ('126', 'testTrans6', '6firstName', ' ');
INSERT INTO `data_validate_entity` VALUES ('127', 'testTrans6', '6babyName', ' ');
INSERT INTO `data_validate_entity` VALUES ('128', 'testTrans6', '6getMoney', ' ');
INSERT INTO `data_validate_entity` VALUES ('129', 'testTrans6', '6birthday', ' ');
INSERT INTO `data_validate_entity` VALUES ('130', 'testTrans6', '6depaName', ' ');
INSERT INTO `data_validate_entity` VALUES ('131', 'testTrans6', '6cause', ' ');
INSERT INTO `data_validate_entity` VALUES ('132', 'testTrans6', '6sendDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('133', 'testTrans6', '6sendType', ' ');
INSERT INTO `data_validate_entity` VALUES ('134', 'testTrans6', '6isDeadLine', ' ');
INSERT INTO `data_validate_entity` VALUES ('135', 'testTrans6', '6sign', ' ');
INSERT INTO `data_validate_entity` VALUES ('136', 'testTrans6', '6signDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('137', 'testTrans6', '6myJugment', ' ');
INSERT INTO `data_validate_entity` VALUES ('138', 'testTrans6', '6telephone', ' ');
INSERT INTO `data_validate_entity` VALUES ('139', 'testTrans6', '6phoneNumber', ' ');
INSERT INTO `data_validate_entity` VALUES ('140', 'testTrans6', '6appname', ' ');
INSERT INTO `data_validate_entity` VALUES ('141', 'testTrans6', '6appprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('142', 'testTrans6', '6appdate', ' ');
INSERT INTO `data_validate_entity` VALUES ('143', 'testTrans6', '6gamename', ' ');
INSERT INTO `data_validate_entity` VALUES ('144', 'testTrans6', '6gameprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('145', 'testTrans7', '7name', ' ');
INSERT INTO `data_validate_entity` VALUES ('146', 'testTrans7', '7age', ' ');
INSERT INTO `data_validate_entity` VALUES ('147', 'testTrans7', '7salary', ' ');
INSERT INTO `data_validate_entity` VALUES ('148', 'testTrans7', '7work', ' ');
INSERT INTO `data_validate_entity` VALUES ('149', 'testTrans7', '7username', ' ');
INSERT INTO `data_validate_entity` VALUES ('150', 'testTrans7', '7firstName', ' ');
INSERT INTO `data_validate_entity` VALUES ('151', 'testTrans7', '7babyName', ' ');
INSERT INTO `data_validate_entity` VALUES ('152', 'testTrans7', '7getMoney', ' ');
INSERT INTO `data_validate_entity` VALUES ('153', 'testTrans7', '7birthday', ' ');
INSERT INTO `data_validate_entity` VALUES ('154', 'testTrans7', '7depaName', ' ');
INSERT INTO `data_validate_entity` VALUES ('155', 'testTrans7', '7cause', ' ');
INSERT INTO `data_validate_entity` VALUES ('156', 'testTrans7', '7sendDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('157', 'testTrans7', '7sendType', ' ');
INSERT INTO `data_validate_entity` VALUES ('158', 'testTrans7', '7isDeadLine', ' ');
INSERT INTO `data_validate_entity` VALUES ('159', 'testTrans7', '7sign', ' ');
INSERT INTO `data_validate_entity` VALUES ('160', 'testTrans7', '7signDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('161', 'testTrans7', '7myJugment', ' ');
INSERT INTO `data_validate_entity` VALUES ('162', 'testTrans7', '7telephone', ' ');
INSERT INTO `data_validate_entity` VALUES ('163', 'testTrans7', '7phoneNumber', ' ');
INSERT INTO `data_validate_entity` VALUES ('164', 'testTrans7', '7appname', ' ');
INSERT INTO `data_validate_entity` VALUES ('165', 'testTrans7', '7appprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('166', 'testTrans7', '7appdate', ' ');
INSERT INTO `data_validate_entity` VALUES ('167', 'testTrans7', '7gamename', ' ');
INSERT INTO `data_validate_entity` VALUES ('168', 'testTrans7', '7gameprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('169', 'testTrans8', '8name', ' ');
INSERT INTO `data_validate_entity` VALUES ('170', 'testTrans8', '8age', ' ');
INSERT INTO `data_validate_entity` VALUES ('171', 'testTrans8', '8salary', ' ');
INSERT INTO `data_validate_entity` VALUES ('172', 'testTrans8', '8work', ' ');
INSERT INTO `data_validate_entity` VALUES ('173', 'testTrans8', '8username', ' ');
INSERT INTO `data_validate_entity` VALUES ('174', 'testTrans8', '8firstName', ' ');
INSERT INTO `data_validate_entity` VALUES ('175', 'testTrans8', '8babyName', ' ');
INSERT INTO `data_validate_entity` VALUES ('176', 'testTrans8', '8getMoney', ' ');
INSERT INTO `data_validate_entity` VALUES ('177', 'testTrans8', '8birthday', ' ');
INSERT INTO `data_validate_entity` VALUES ('178', 'testTrans8', '8depaName', ' ');
INSERT INTO `data_validate_entity` VALUES ('179', 'testTrans8', '8cause', ' ');
INSERT INTO `data_validate_entity` VALUES ('180', 'testTrans8', '8sendDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('181', 'testTrans8', '8sendType', ' ');
INSERT INTO `data_validate_entity` VALUES ('182', 'testTrans8', '8isDeadLine', ' ');
INSERT INTO `data_validate_entity` VALUES ('183', 'testTrans8', '8sign', ' ');
INSERT INTO `data_validate_entity` VALUES ('184', 'testTrans8', '8signDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('185', 'testTrans8', '8myJugment', ' ');
INSERT INTO `data_validate_entity` VALUES ('186', 'testTrans8', '8telephone', ' ');
INSERT INTO `data_validate_entity` VALUES ('187', 'testTrans8', '8phoneNumber', ' ');
INSERT INTO `data_validate_entity` VALUES ('188', 'testTrans8', '8appname', ' ');
INSERT INTO `data_validate_entity` VALUES ('189', 'testTrans8', '8appprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('190', 'testTrans8', '8appdate', ' ');
INSERT INTO `data_validate_entity` VALUES ('191', 'testTrans8', '8gamename', ' ');
INSERT INTO `data_validate_entity` VALUES ('192', 'testTrans8', '8gameprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('193', 'testTrans9', '9name', ' ');
INSERT INTO `data_validate_entity` VALUES ('194', 'testTrans9', '9age', ' ');
INSERT INTO `data_validate_entity` VALUES ('195', 'testTrans9', '9salary', ' ');
INSERT INTO `data_validate_entity` VALUES ('196', 'testTrans9', '9work', ' ');
INSERT INTO `data_validate_entity` VALUES ('197', 'testTrans9', '9username', ' ');
INSERT INTO `data_validate_entity` VALUES ('198', 'testTrans9', '9firstName', ' ');
INSERT INTO `data_validate_entity` VALUES ('199', 'testTrans9', '9babyName', ' ');
INSERT INTO `data_validate_entity` VALUES ('200', 'testTrans9', '9getMoney', ' ');
INSERT INTO `data_validate_entity` VALUES ('201', 'testTrans9', '9birthday', ' ');
INSERT INTO `data_validate_entity` VALUES ('202', 'testTrans9', '9depaName', ' ');
INSERT INTO `data_validate_entity` VALUES ('203', 'testTrans9', '9cause', ' ');
INSERT INTO `data_validate_entity` VALUES ('204', 'testTrans9', '9sendDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('205', 'testTrans9', '9sendType', ' ');
INSERT INTO `data_validate_entity` VALUES ('206', 'testTrans9', '9isDeadLine', ' ');
INSERT INTO `data_validate_entity` VALUES ('207', 'testTrans9', '9sign', ' ');
INSERT INTO `data_validate_entity` VALUES ('208', 'testTrans9', '9signDate', ' ');
INSERT INTO `data_validate_entity` VALUES ('209', 'testTrans9', '9myJugment', ' ');
INSERT INTO `data_validate_entity` VALUES ('210', 'testTrans9', '9telephone', ' ');
INSERT INTO `data_validate_entity` VALUES ('211', 'testTrans9', '9phoneNumber', ' ');
INSERT INTO `data_validate_entity` VALUES ('212', 'testTrans9', '9appname', ' ');
INSERT INTO `data_validate_entity` VALUES ('213', 'testTrans9', '9appprice', ' ');
INSERT INTO `data_validate_entity` VALUES ('214', 'testTrans9', '9appdate', ' ');
INSERT INTO `data_validate_entity` VALUES ('215', 'testTrans9', '9gamename', ' ');
INSERT INTO `data_validate_entity` VALUES ('216', 'testTrans9', '9gameprice', ' ');
