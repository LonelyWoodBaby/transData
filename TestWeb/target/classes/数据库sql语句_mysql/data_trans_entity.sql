/*
Navicat MySQL Data Transfer

Source Server         : mySqlC
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : transdata

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-16 16:46:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for data_trans_entity
-- ----------------------------
DROP TABLE IF EXISTS `data_trans_entity`;
CREATE TABLE `data_trans_entity` (
  `data_trans_id` int(11) NOT NULL AUTO_INCREMENT,
  `buss_code` varchar(10) NOT NULL,
  `data_trans_name` varchar(100) NOT NULL,
  `show_chn_name` varchar(150) NOT NULL,
  PRIMARY KEY (`data_trans_id`)
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_trans_entity
-- ----------------------------
INSERT INTO `data_trans_entity` VALUES ('1', 'testTrans1', 'name1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('2', 'testTrans1', 'age1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('3', 'testTrans1', 'salay1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('4', 'testTrans1', 'work1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('5', 'testTrans1', 'username1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('6', 'testTrans1', 'firstName1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('7', 'testTrans1', 'babyName1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('8', 'testTrans1', 'getMoney1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('9', 'testTrans1', 'birthday1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('10', 'testTrans1', 'depaName1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('11', 'testTrans1', 'cause1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('12', 'testTrans1', 'sendDate1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('13', 'testTrans1', 'sendType1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('14', 'testTrans1', 'isDeadLine1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('15', 'testTrans1', 'sign1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('16', 'testTrans1', 'signDate1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('17', 'testTrans1', 'myJugment1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('18', 'testTrans1', 'telephone1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('19', 'testTrans1', 'phoneNumber1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('20', 'testTrans1', 'appname1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('21', 'testTrans1', 'appprice1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('22', 'testTrans1', 'appdate1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('23', 'testTrans1', 'gamename1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('24', 'testTrans1', 'gameprice1', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('25', 'testTrans2', '2name', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('26', 'testTrans2', '2age', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('27', 'testTrans2', '2salary', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('28', 'testTrans2', '2work', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('29', 'testTrans2', '2username', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('30', 'testTrans2', '2firstName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('31', 'testTrans2', '2babyName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('32', 'testTrans2', '2getMoney', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('33', 'testTrans2', '2birthday', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('34', 'testTrans2', '2depaName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('35', 'testTrans2', '2cause', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('36', 'testTrans2', '2sendDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('37', 'testTrans2', '2sendType', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('38', 'testTrans2', '2isDeadLine', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('39', 'testTrans2', '2sign', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('40', 'testTrans2', '2signDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('41', 'testTrans2', '2myJugment', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('42', 'testTrans2', '2telephone', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('43', 'testTrans2', '2phoneNumber', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('44', 'testTrans2', '2appname', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('45', 'testTrans2', '2appprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('46', 'testTrans2', '2appdate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('47', 'testTrans2', '2gamename', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('48', 'testTrans2', '2gameprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('49', 'testTrans4', '4name', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('50', 'testTrans4', '4age', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('51', 'testTrans4', '4salary', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('52', 'testTrans4', '4work', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('53', 'testTrans4', '4username', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('54', 'testTrans4', '4firstName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('55', 'testTrans4', '4babyName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('56', 'testTrans4', '4getMoney', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('57', 'testTrans4', '4birthday', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('58', 'testTrans4', '4depaName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('59', 'testTrans4', '4cause', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('60', 'testTrans4', '4sendDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('61', 'testTrans4', '4sendType', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('62', 'testTrans4', '4isDeadLine', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('63', 'testTrans4', '4sign', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('64', 'testTrans4', '4signDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('65', 'testTrans4', '4myJugment', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('66', 'testTrans4', '4telephone', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('67', 'testTrans4', '4phoneNumber', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('68', 'testTrans4', '4appname', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('69', 'testTrans4', '4appprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('70', 'testTrans4', '4appdate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('71', 'testTrans4', '4gamename', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('72', 'testTrans4', '4gameprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('73', 'testTrans3', '3name', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('74', 'testTrans3', '3age', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('75', 'testTrans3', '3salary', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('76', 'testTrans3', '3work', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('77', 'testTrans3', '3username', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('78', 'testTrans3', '3firstName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('79', 'testTrans3', '3babyName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('80', 'testTrans3', '3getMoney', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('81', 'testTrans3', '3birthday', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('82', 'testTrans3', '3depaName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('83', 'testTrans3', '3cause', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('84', 'testTrans3', '3sendDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('85', 'testTrans3', '3sendType', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('86', 'testTrans3', '3isDeadLine', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('87', 'testTrans3', '3sign', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('88', 'testTrans3', '3signDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('89', 'testTrans3', '3myJugment', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('90', 'testTrans3', '3telephone', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('91', 'testTrans3', '3phoneNumber', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('92', 'testTrans3', '3appname', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('93', 'testTrans3', '3appprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('94', 'testTrans3', '3appdate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('95', 'testTrans3', '3gamename', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('96', 'testTrans3', '3gameprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('97', 'testTrans5', '5name', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('98', 'testTrans5', '5age', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('99', 'testTrans5', '5salary', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('100', 'testTrans5', '5work', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('101', 'testTrans5', '5username', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('102', 'testTrans5', '5firstName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('103', 'testTrans5', '5babyName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('104', 'testTrans5', '5getMoney', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('105', 'testTrans5', '5birthday', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('106', 'testTrans5', '5depaName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('107', 'testTrans5', '5cause', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('108', 'testTrans5', '5sendDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('109', 'testTrans5', '5sendType', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('110', 'testTrans5', '5isDeadLine', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('111', 'testTrans5', '5sign', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('112', 'testTrans5', '5signDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('113', 'testTrans5', '5myJugment', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('114', 'testTrans5', '5telephone', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('115', 'testTrans5', '5phoneNumber', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('116', 'testTrans5', '5appname', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('117', 'testTrans5', '5appprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('118', 'testTrans5', '5appdate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('119', 'testTrans5', '5gamename', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('120', 'testTrans5', '5gameprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('121', 'testTrans6', '6name', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('122', 'testTrans6', '6age', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('123', 'testTrans6', '6salary', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('124', 'testTrans6', '6work', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('125', 'testTrans6', '6username', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('126', 'testTrans6', '6firstName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('127', 'testTrans6', '6babyName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('128', 'testTrans6', '6getMoney', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('129', 'testTrans6', '6birthday', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('130', 'testTrans6', '6depaName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('131', 'testTrans6', '6cause', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('132', 'testTrans6', '6sendDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('133', 'testTrans6', '6sendType', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('134', 'testTrans6', '6isDeadLine', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('135', 'testTrans6', '6sign', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('136', 'testTrans6', '6signDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('137', 'testTrans6', '6myJugment', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('138', 'testTrans6', '6telephone', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('139', 'testTrans6', '6phoneNumber', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('140', 'testTrans6', '6appname', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('141', 'testTrans6', '6appprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('142', 'testTrans6', '6appdate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('143', 'testTrans6', '6gamename', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('144', 'testTrans6', '6gameprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('145', 'testTrans7', '7name', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('146', 'testTrans7', '7age', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('147', 'testTrans7', '7salary', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('148', 'testTrans7', '7work', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('149', 'testTrans7', '7username', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('150', 'testTrans7', '7firstName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('151', 'testTrans7', '7babyName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('152', 'testTrans7', '7getMoney', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('153', 'testTrans7', '7birthday', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('154', 'testTrans7', '7depaName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('155', 'testTrans7', '7cause', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('156', 'testTrans7', '7sendDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('157', 'testTrans7', '7sendType', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('158', 'testTrans7', '7isDeadLine', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('159', 'testTrans7', '7sign', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('160', 'testTrans7', '7signDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('161', 'testTrans7', '7myJugment', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('162', 'testTrans7', '7telephone', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('163', 'testTrans7', '7phoneNumber', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('164', 'testTrans7', '7appname', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('165', 'testTrans7', '7appprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('166', 'testTrans7', '7appdate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('167', 'testTrans7', '7gamename', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('168', 'testTrans7', '7gameprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('169', 'testTrans8', '8name', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('170', 'testTrans8', '8age', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('171', 'testTrans8', '8salary', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('172', 'testTrans8', '8work', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('173', 'testTrans8', '8username', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('174', 'testTrans8', '8firstName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('175', 'testTrans8', '8babyName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('176', 'testTrans8', '8getMoney', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('177', 'testTrans8', '8birthday', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('178', 'testTrans8', '8depaName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('179', 'testTrans8', '8cause', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('180', 'testTrans8', '8sendDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('181', 'testTrans8', '8sendType', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('182', 'testTrans8', '8isDeadLine', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('183', 'testTrans8', '8sign', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('184', 'testTrans8', '8signDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('185', 'testTrans8', '8myJugment', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('186', 'testTrans8', '8telephone', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('187', 'testTrans8', '8phoneNumber', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('188', 'testTrans8', '8appname', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('189', 'testTrans8', '8appprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('190', 'testTrans8', '8appdate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('191', 'testTrans8', '8gamename', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('192', 'testTrans8', '8gameprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('193', 'testTrans9', '9name', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('194', 'testTrans9', '9age', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('195', 'testTrans9', '9salary', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('196', 'testTrans9', '9work', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('197', 'testTrans9', '9username', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('198', 'testTrans9', '9firstName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('199', 'testTrans9', '9babyName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('200', 'testTrans9', '9getMoney', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('201', 'testTrans9', '9birthday', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('202', 'testTrans9', '9depaName', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('203', 'testTrans9', '9cause', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('204', 'testTrans9', '9sendDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('205', 'testTrans9', '9sendType', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('206', 'testTrans9', '9isDeadLine', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('207', 'testTrans9', '9sign', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('208', 'testTrans9', '9signDate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('209', 'testTrans9', '9myJugment', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('210', 'testTrans9', '9telephone', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('211', 'testTrans9', '9phoneNumber', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('212', 'testTrans9', '9appname', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('213', 'testTrans9', '9appprice', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('214', 'testTrans9', '9appdate', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('215', 'testTrans9', '9gamename', '用户名称');
INSERT INTO `data_trans_entity` VALUES ('216', 'testTrans9', '9gameprice', '用户名称');
