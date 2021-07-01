/*
Navicat MySQL Data Transfer

Source Server         : zy
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : supermarket_manage_system

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-06-23 22:49:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods_list
-- ----------------------------
DROP TABLE IF EXISTS `goods_list`;
CREATE TABLE `goods_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` varchar(255) DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_price` int(10) DEFAULT NULL,
  `goods_counts` int(10) DEFAULT NULL,
  `grade_rule` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_list
-- ----------------------------
INSERT INTO `goods_list` VALUES ('9', 'SDSAM', 'DOLOMIA 杜勒绿脂枕 超酥柔快速入睡记忆枕 高低颈椎枕头护颈枕 颈椎呵护深度睡眠枕芯配定制枕套 0.8KG', '100', '149', '20');
INSERT INTO `goods_list` VALUES ('10', 'ASFAAS', '儿童自行车小孩单车6-10岁山地车变速男女童车20寸8-12岁中大童小学生自行车 黑蓝色 20寸', '399', '291', '25');
INSERT INTO `goods_list` VALUES ('11', 'SAFSAL', '拉菲罗斯柴尔德爱汝红葡萄酒 阿根廷原瓶进口红酒干红 750ml单支', '148', '400', '12');
INSERT INTO `goods_list` VALUES ('12', 'ASFASS', '挂绿 增城丝苗米国家地标（金香） 南方籼米 大米10kg', '104', '300', '10');
INSERT INTO `goods_list` VALUES ('13', 'SADASG', '阿道夫洗发水沐浴露护发素520ml*2组合控油去屑留香洗发水套装洗头膏洗发露洗发香乳男女士 控油清爽520ml+净屑舒爽520ml', '99', '500', '8');
INSERT INTO `goods_list` VALUES ('14', 'SFAWQS', '脱骨李新鲜青脆李子水果当季半边红应季时令四川李子非三华李整箱 净重5斤大果', '30', '300', '5');
INSERT INTO `goods_list` VALUES ('15', 'OUUOU', '福临门 食用油 浓香压榨一级 花生油6.18L 中粮出品', '120', '200', '12');
INSERT INTO `goods_list` VALUES ('16', 'UEVFAS', '浪琴(Longines)瑞士手表 名匠系列 机械皮带男表 L26734783', '25500', '20', '35');
INSERT INTO `goods_list` VALUES ('17', 'HFUNJN', '德国Tomofree 电动滑板车迷你便携锂电池电瓶车代驾便携式全铝合金可折叠两轮电动车 48V1000W电机 全铝合金 双遥控 约35km', '2748', '300', '20');
INSERT INTO `goods_list` VALUES ('18', 'YQVSAF', 'MLB男帽夏季 男女情侣帽子 NY纽约洋基队棒球帽树脂LOGO运动帽户外遮阳帽硬顶休闲帽32CP57 纽约洋基/黑色 F', '398', '300', '12');
INSERT INTO `goods_list` VALUES ('19', 'QWSAFS', 'TOMMY HILFIGER 男装人造革字母LOGO印花手拿包AM0AM06724 藏青色0GJ OS', '545', '400', '20');
INSERT INTO `goods_list` VALUES ('20', 'QEWFSV', 'COACH/蔻驰 潮流前卫蝶形大框渐变女款太阳镜 墨镜 0HC8166F', '1421', '300', '20');
INSERT INTO `goods_list` VALUES ('21', 'DGAFQA', '索尼（SONY）WI-SP510 无线防水运动耳机 蓝色', '479', '200', '20');
INSERT INTO `goods_list` VALUES ('30', 'TESTGOODS', '测试商品', '200', '294', '20');

-- ----------------------------
-- Table structure for goods_records
-- ----------------------------
DROP TABLE IF EXISTS `goods_records`;
CREATE TABLE `goods_records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vip_id` int(10) NOT NULL,
  `goods_id` int(10) NOT NULL,
  `shopping_counts` int(10) NOT NULL,
  `shopping_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_records
-- ----------------------------
INSERT INTO `goods_records` VALUES ('17', '35', '9', '2', '2021-06-20 00:15:27');
INSERT INTO `goods_records` VALUES ('18', '4', '9', '1', '2021-06-20 00:18:24');
INSERT INTO `goods_records` VALUES ('19', '43', '14', '8', '2021-06-20 00:18:47');
INSERT INTO `goods_records` VALUES ('20', '38', '18', '4', '2021-06-20 00:19:21');
INSERT INTO `goods_records` VALUES ('21', '38', '9', '8', '2021-06-20 00:19:21');
INSERT INTO `goods_records` VALUES ('22', '38', '17', '5', '2021-06-20 00:19:21');
INSERT INTO `goods_records` VALUES ('23', '38', '10', '5', '2021-06-20 00:19:21');
INSERT INTO `goods_records` VALUES ('24', '38', '19', '3', '2021-06-20 00:19:21');
INSERT INTO `goods_records` VALUES ('25', '38', '20', '8', '2021-06-20 00:19:21');
INSERT INTO `goods_records` VALUES ('26', '1', '9', '5', '2021-06-20 10:35:21');
INSERT INTO `goods_records` VALUES ('28', '53', '28', '10', '2021-06-20 10:42:58');
INSERT INTO `goods_records` VALUES ('29', '54', '9', '5', '2021-06-20 10:44:00');
INSERT INTO `goods_records` VALUES ('30', '55', '9', '12', '2021-06-20 10:46:03');
INSERT INTO `goods_records` VALUES ('31', '56', '30', '6', '2021-06-20 12:20:52');
INSERT INTO `goods_records` VALUES ('32', '56', '9', '4', '2021-06-20 12:20:52');
INSERT INTO `goods_records` VALUES ('33', '56', '10', '5', '2021-06-20 12:20:52');
INSERT INTO `goods_records` VALUES ('34', '57', '9', '3', '2021-06-20 22:22:41');
INSERT INTO `goods_records` VALUES ('35', '57', '10', '2', '2021-06-20 22:22:41');
INSERT INTO `goods_records` VALUES ('36', '3', '9', '2', '2021-06-21 23:51:09');
INSERT INTO `goods_records` VALUES ('37', '3', '10', '2', '2021-06-22 09:57:56');
INSERT INTO `goods_records` VALUES ('38', '3', '9', '2', '2021-06-22 09:57:56');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '123');
INSERT INTO `user` VALUES ('zy', '123123');

-- ----------------------------
-- Table structure for vip_list
-- ----------------------------
DROP TABLE IF EXISTS `vip_list`;
CREATE TABLE `vip_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vip_name` varchar(255) DEFAULT NULL,
  `vip_level` int(10) DEFAULT NULL,
  `card_money` int(10) DEFAULT NULL,
  `card_grade` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT 'vip_list',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip_list
-- ----------------------------
INSERT INTO `vip_list` VALUES ('1', '张三', '9', '10000', '0', '2021-01-17 00:30:08');
INSERT INTO `vip_list` VALUES ('2', '李四', '2', '5342', '895', '2021-06-09 00:31:34');
INSERT INTO `vip_list` VALUES ('3', '罗杰·勒梅尔', '6', '2256', '783', '2021-06-09 00:32:33');
INSERT INTO `vip_list` VALUES ('4', '雷·让微', '3', '345', '359', '2021-07-03 00:33:03');
INSERT INTO `vip_list` VALUES ('34', '雷·拉蒙坦', '1', '54', '56', '2021-06-18 21:33:48');
INSERT INTO `vip_list` VALUES ('35', '樊少皇', '5', '56', '566', '2021-06-18 21:34:56');
INSERT INTO `vip_list` VALUES ('36', '薇拉·贺兰德', '1', '543', '632', '2021-06-18 21:35:10');
INSERT INTO `vip_list` VALUES ('37', '费尔南达·索萨', '6', '345', '89', '2021-06-18 21:35:21');
INSERT INTO `vip_list` VALUES ('38', '迪翁', '6', '653', '56', '2021-06-18 21:35:38');
INSERT INTO `vip_list` VALUES ('39', '蕾妮·奥斯泰德', '6', '65', '35', '2021-06-18 21:36:05');
INSERT INTO `vip_list` VALUES ('40', '保罗·麦卡特尼', '8', '566', '56', '2021-06-18 21:36:37');
INSERT INTO `vip_list` VALUES ('41', '维克托·拉努', '8', '656', '328', '2021-06-18 21:37:11');
INSERT INTO `vip_list` VALUES ('42', '松原夏海', '3', '56', '68', '2021-06-18 21:37:31');
INSERT INTO `vip_list` VALUES ('43', '赵传伟', '6', '56', '35', '2021-06-18 21:37:42');
INSERT INTO `vip_list` VALUES ('44', '陈懿轩', '6', '56', '68', '2021-06-18 21:39:58');
INSERT INTO `vip_list` VALUES ('56', '测试人员', '1', '6405', '325', '2021-06-20 12:18:19');
