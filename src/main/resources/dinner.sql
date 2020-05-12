/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : dinner

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-05-12 13:08:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dining_table
-- ----------------------------
DROP TABLE IF EXISTS `dining_table`;
CREATE TABLE `dining_table` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `table_num` varchar(20) NOT NULL,
  `table_pernum` int(6) NOT NULL,
  `isno` int(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dining_table
-- ----------------------------
INSERT INTO `dining_table` VALUES ('1', '01', '12', '1');
INSERT INTO `dining_table` VALUES ('2', '02', '4', '1');
INSERT INTO `dining_table` VALUES ('3', '03', '4', '0');
INSERT INTO `dining_table` VALUES ('4', '04', '4', '0');
INSERT INTO `dining_table` VALUES ('5', '05', '6', '0');
INSERT INTO `dining_table` VALUES ('6', '06', '6', '0');
INSERT INTO `dining_table` VALUES ('7', '07', '8', '0');
INSERT INTO `dining_table` VALUES ('8', '08', '8', '0');
INSERT INTO `dining_table` VALUES ('9', '09', '10', '0');
INSERT INTO `dining_table` VALUES ('10', '10', '20', '0');
INSERT INTO `dining_table` VALUES ('11', '11', '6', '0');
INSERT INTO `dining_table` VALUES ('12', '12', '10', '0');

-- ----------------------------
-- Table structure for dinner_notice
-- ----------------------------
DROP TABLE IF EXISTS `dinner_notice`;
CREATE TABLE `dinner_notice` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(20) NOT NULL,
  `order_id` int(6) NOT NULL,
  `menunum` int(6) NOT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `menuprice` int(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dinner_notice
-- ----------------------------
INSERT INTO `dinner_notice` VALUES ('1', '丸子', '2', '1', '无', '24');
INSERT INTO `dinner_notice` VALUES ('2', '酱香鸡翅', '7', '1', '无', '28');
INSERT INTO `dinner_notice` VALUES ('3', '可乐鸡翅', '7', '1', '无', '30');
INSERT INTO `dinner_notice` VALUES ('4', '一碗虾', '7', '1', '无', '30');
INSERT INTO `dinner_notice` VALUES ('5', '糖醋排骨', '7', '1', '少放醋', '38');
INSERT INTO `dinner_notice` VALUES ('6', '鱼香肉丝', '7', '1', '无', '18');
INSERT INTO `dinner_notice` VALUES ('7', '白菜心拌豆腐丝', '7', '1', '无', '15');
INSERT INTO `dinner_notice` VALUES ('8', '太极岩红奶茶', '7', '1', '无', '12');
INSERT INTO `dinner_notice` VALUES ('9', '一碗虾', '8', '1', '无', '30');
INSERT INTO `dinner_notice` VALUES ('10', '鱼香肉丝', '8', '1', '无', '18');
INSERT INTO `dinner_notice` VALUES ('11', '糖醋排骨', '8', '1', '无', '38');
INSERT INTO `dinner_notice` VALUES ('12', '红烧肉', '8', '1', '无', '38');
INSERT INTO `dinner_notice` VALUES ('13', '可乐鸡翅', '8', '1', '无', '30');
INSERT INTO `dinner_notice` VALUES ('14', '香酥鸭肉', '8', '1', '无', '27');
INSERT INTO `dinner_notice` VALUES ('15', '丸子', '8', '1', '无', '24');
INSERT INTO `dinner_notice` VALUES ('16', '酱香鸡翅', '8', '1', '无', '28');
INSERT INTO `dinner_notice` VALUES ('17', '白菜心拌豆腐丝', '8', '1', '无', '15');
INSERT INTO `dinner_notice` VALUES ('18', '糖醋心里美萝卜丝', '8', '1', '无', '15');
INSERT INTO `dinner_notice` VALUES ('19', '缤纷拌菜', '8', '1', '无', '18');
INSERT INTO `dinner_notice` VALUES ('20', '太极岩红奶茶', '8', '2', '无', '12');
INSERT INTO `dinner_notice` VALUES ('21', '蓝莓蔬果气泡水', '8', '3', '无', '10');
INSERT INTO `dinner_notice` VALUES ('22', '芝士奶盖太极岩红', '8', '4', '无', '13');
INSERT INTO `dinner_notice` VALUES ('23', '可乐鸡翅', '9', '2', '无', '30');
INSERT INTO `dinner_notice` VALUES ('24', '丸子', '9', '2', '无', '24');
INSERT INTO `dinner_notice` VALUES ('25', '白菜心拌豆腐丝', '9', '1', '无', '15');
INSERT INTO `dinner_notice` VALUES ('26', '太极岩红奶茶', '9', '1', '无', '12');
INSERT INTO `dinner_notice` VALUES ('27', '蓝莓蔬果气泡水', '9', '1', '无', '10');
INSERT INTO `dinner_notice` VALUES ('28', '鱼香肉丝', '10', '2', '无', '18');
INSERT INTO `dinner_notice` VALUES ('29', '香酥鸭肉', '10', '3', '无', '27');
INSERT INTO `dinner_notice` VALUES ('30', '鱼香肉丝', '11', '1', '无', '18');
INSERT INTO `dinner_notice` VALUES ('31', '酱香鸡翅', '12', '3', '无', '28');
INSERT INTO `dinner_notice` VALUES ('32', '红烧肉', '12', '3', '无', '38');
INSERT INTO `dinner_notice` VALUES ('33', '丸子', '13', '3', '无', '24');
INSERT INTO `dinner_notice` VALUES ('34', '可乐鸡翅', '13', '2', '无', '30');
INSERT INTO `dinner_notice` VALUES ('35', '红烧肉', '13', '4', '无', '38');
INSERT INTO `dinner_notice` VALUES ('36', '糖醋排骨', '13', '2', '无', '38');
INSERT INTO `dinner_notice` VALUES ('37', '糖醋心里美萝卜丝', '13', '2', '无', '15');
INSERT INTO `dinner_notice` VALUES ('38', '芝士奶盖太极岩红', '13', '2', '无', '13');
INSERT INTO `dinner_notice` VALUES ('39', '蓝莓蔬果气泡水', '13', '1', '无', '10');
INSERT INTO `dinner_notice` VALUES ('40', '太极岩红奶茶', '13', '1', '无', '12');
INSERT INTO `dinner_notice` VALUES ('41', '香酥鸭肉', '21', '2', '无', '27');
INSERT INTO `dinner_notice` VALUES ('61', '一碗虾', '41', '2', '无', '30');
INSERT INTO `dinner_notice` VALUES ('62', '香酥鸭肉', '41', '2', '无', '27');
INSERT INTO `dinner_notice` VALUES ('63', '酱香鸡翅', '41', '3', '无', '28');
INSERT INTO `dinner_notice` VALUES ('64', '鱼香肉丝', '41', '1', '无', '18');
INSERT INTO `dinner_notice` VALUES ('65', '糖醋心里美萝卜丝', '41', '1', '无', '15');
INSERT INTO `dinner_notice` VALUES ('66', '太极岩红奶茶', '41', '1', '无', '12');
INSERT INTO `dinner_notice` VALUES ('67', '芝士奶盖太极岩红', '41', '1', '无', '13');
INSERT INTO `dinner_notice` VALUES ('68', '蓝莓蔬果气泡水', '41', '1', '无', '10');
INSERT INTO `dinner_notice` VALUES ('69', '丸子', '42', '1', '无', '24');
INSERT INTO `dinner_notice` VALUES ('70', '可乐鸡翅', '42', '1', '无', '30');
INSERT INTO `dinner_notice` VALUES ('71', '红烧肉', '43', '1', '无', '38');
INSERT INTO `dinner_notice` VALUES ('72', '糖醋排骨', '44', '1', '无', '38');
INSERT INTO `dinner_notice` VALUES ('73', '一碗虾', '45', '1', '无', '30');
INSERT INTO `dinner_notice` VALUES ('74', '糖醋排骨', '46', '1', '无', '38');
INSERT INTO `dinner_notice` VALUES ('75', '酱香鸡翅', '47', '1', '无', '28');

-- ----------------------------
-- Table structure for dinner_order
-- ----------------------------
DROP TABLE IF EXISTS `dinner_order`;
CREATE TABLE `dinner_order` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `table_id` varchar(20) NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  `usercode` varchar(20) NOT NULL,
  `personnum` int(6) NOT NULL,
  `ispay` int(6) NOT NULL,
  `price` double(6,2) NOT NULL,
  `isfull` int(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dinner_order
-- ----------------------------
INSERT INTO `dinner_order` VALUES ('7', '02', '2018-02-09 11:11:12', 'lisi', '4', '1', '171.00', '1');
INSERT INTO `dinner_order` VALUES ('8', '10', '2018-02-09 11:11:13', 'lisi', '10', '1', '387.00', '1');
INSERT INTO `dinner_order` VALUES ('9', '01', '2018-02-09 11:11:14', 'lisi', '2', '1', '145.00', '1');
INSERT INTO `dinner_order` VALUES ('10', '01', '2018-02-09 11:11:15', 'lisi', '2', '1', '117.00', '1');
INSERT INTO `dinner_order` VALUES ('11', '01', '2018-02-09 11:11:16', 'lisi', '2', '1', '18.00', '1');
INSERT INTO `dinner_order` VALUES ('12', '01', '2018-02-09 11:11:17', 'lisi', '3', '1', '198.00', '1');
INSERT INTO `dinner_order` VALUES ('13', '01', '2018-02-09 11:11:18', 'lisi', '4', '1', '438.00', '1');
INSERT INTO `dinner_order` VALUES ('21', '01', '2018-02-09 11:11:19', 'lisi', '2', '1', '54.00', '1');
INSERT INTO `dinner_order` VALUES ('43', '01', '2018-04-24 11:11:22', '12', '21', '1', '38.00', '1');
INSERT INTO `dinner_order` VALUES ('44', '01', '2018-04-24 11:11:23', '2', '2', '1', '38.00', '1');
INSERT INTO `dinner_order` VALUES ('45', '01', '2018-04-24 11:11:24', '3', '3', '1', '30.00', '1');
INSERT INTO `dinner_order` VALUES ('46', '01', '2018-04-24 11:11:25', '56', '5', '1', '38.00', '1');
INSERT INTO `dinner_order` VALUES ('47', '01', '2018-04-24 11:11:26', '66', '66', '1', '28.00', '1');
INSERT INTO `dinner_order` VALUES ('48', '01', '2020-02-21 13:00:39', '66', '66', '1', '28.00', '1');
INSERT INTO `dinner_order` VALUES ('49', '02', '2020-02-21 15:36:41', '1111', '3', '1', '43.00', '1');
INSERT INTO `dinner_order` VALUES ('50', '10', '2020-02-21 15:39:43', '222', '5', '1', '177.00', '1');
INSERT INTO `dinner_order` VALUES ('51', '02', '2020-02-21 15:41:58', 'dsd', '2', '1', '15.00', '1');
INSERT INTO `dinner_order` VALUES ('52', '03', '2020-02-21 15:42:17', 'dsd', '2', '1', '15.00', '1');
INSERT INTO `dinner_order` VALUES ('53', '04', '2020-02-21 15:43:11', 'dsd', '2', '1', '33.00', '1');
INSERT INTO `dinner_order` VALUES ('54', '02', '2020-02-21 23:20:45', '1111', '1', '1', '33.00', '1');
INSERT INTO `dinner_order` VALUES ('55', '11', '2020-02-21 23:21:43', '喔喔喔', '10', '1', '15.00', '1');
INSERT INTO `dinner_order` VALUES ('56', '10', '2020-02-21 23:25:46', '你你你你你', '2', '1', '15.00', '1');
INSERT INTO `dinner_order` VALUES ('57', '02', '2020-02-22 08:37:41', '111111111111111', '111', '1', '15.00', '1');
INSERT INTO `dinner_order` VALUES ('58', '03', '2020-02-22 08:45:04', '222222222', '11', '0', '18.00', '0');
INSERT INTO `dinner_order` VALUES ('59', '04', '2020-02-22 08:46:49', '2', '2', '0', '33.00', '0');
INSERT INTO `dinner_order` VALUES ('60', '03', '2020-02-22 08:50:47', '111', '10', '1', '33.00', '1');
INSERT INTO `dinner_order` VALUES ('62', '12', '2020-02-22 22:37:35', '111', '2', '0', '150.00', '0');

-- ----------------------------
-- Table structure for dinner_pc
-- ----------------------------
DROP TABLE IF EXISTS `dinner_pc`;
CREATE TABLE `dinner_pc` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `orderid` int(6) NOT NULL,
  `isok` int(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dinner_pc
-- ----------------------------

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `type_id` int(6) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `mcode` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '4', '王毛毛', '1358956235', '4777');

-- ----------------------------
-- Table structure for member_type
-- ----------------------------
DROP TABLE IF EXISTS `member_type`;
CREATE TABLE `member_type` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of member_type
-- ----------------------------
INSERT INTO `member_type` VALUES ('1', '黄金会员');
INSERT INTO `member_type` VALUES ('2', '铂金会员');
INSERT INTO `member_type` VALUES ('3', '钻石会员');
INSERT INTO `member_type` VALUES ('4', '至尊会员');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `type_id` int(6) NOT NULL,
  `m_name` varchar(50) NOT NULL,
  `m_price` int(6) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '1', '白菜心拌豆腐丝', '15', '237f6772d17a4cec8fdb74c5a72ab9d2.jpg', '白菜心拌豆腐丝');
INSERT INTO `menu` VALUES ('2', '2', '缤纷拌菜', '18', '20180209215539.png', '缤纷拌菜');
INSERT INTO `menu` VALUES ('3', '1', '蓝莓蔬果气泡水', '10', 'f7a3c3e8cfa649febad2589dda3bf517.png', '蓝莓蔬果气泡水');
INSERT INTO `menu` VALUES ('4', '1', '红烧肉', '38', '20180209215641.jpg', '红烧肉');
INSERT INTO `menu` VALUES ('5', '1', '酱香鸡翅', '28', '20180209215657.jpg', '酱香鸡翅');
INSERT INTO `menu` VALUES ('6', '1', '可乐鸡翅', '30', '20180209215714.jpg', '可乐鸡翅');
INSERT INTO `menu` VALUES ('7', '3', '太极岩红奶茶', '12', '20180209215800.png', '太极岩红奶茶');
INSERT INTO `menu` VALUES ('8', '1', '糖醋排骨', '38', '20180209215818.jpg', '糖醋排骨');
INSERT INTO `menu` VALUES ('9', '2', '糖醋心里美萝卜丝', '15', '20180209215859.png', '糖醋心里美萝卜丝');
INSERT INTO `menu` VALUES ('10', '1', '丸子', '24', '20180209215916.jpg', '丸子');
INSERT INTO `menu` VALUES ('11', '1', '香酥鸭肉', '27', '20180209215952.jpg', '香酥鸭肉');
INSERT INTO `menu` VALUES ('12', '1', '一碗虾', '30', '20180209220015.jpg', '一碗虾');
INSERT INTO `menu` VALUES ('13', '1', '鱼香肉丝', '18', '20180209220040.jpg', '鱼香肉丝');
INSERT INTO `menu` VALUES ('14', '3', '芝士奶盖太极岩红', '13', '20180209220056.png', '芝士奶盖太极岩红');
INSERT INTO `menu` VALUES ('15', '3', 'Java海鲜', '100', '789ba8d8c6394d94a25d84a9ae903473.jpg', 'Java真香');

-- ----------------------------
-- Table structure for menu_type
-- ----------------------------
DROP TABLE IF EXISTS `menu_type`;
CREATE TABLE `menu_type` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of menu_type
-- ----------------------------
INSERT INTO `menu_type` VALUES ('1', '热菜');
INSERT INTO `menu_type` VALUES ('2', '凉菜');
INSERT INTO `menu_type` VALUES ('3', '饮品');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `u_loginname` varchar(20) NOT NULL,
  `u_pwd` varchar(20) NOT NULL,
  `u_name` varchar(20) NOT NULL,
  `u_sex` varchar(10) NOT NULL,
  `u_phone` varchar(20) NOT NULL,
  `u_idcard` varchar(20) NOT NULL,
  `u_address` varchar(50) NOT NULL,
  `u_role` int(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('2', 'admin', '123456', '系统管理员（admin）', '男', '13545875688', '210900190000002719', '辽宁省沈阳市', '1');
INSERT INTO `users` VALUES ('3', 'zhangsan', 'zhangsan', '张三', '男', '13696968989', '210900190000002719', '辽宁省沈阳市', '2');
INSERT INTO `users` VALUES ('4', 'lisi', 'lisi', '李四111', '男', '13689897878', '210900190000002719', '辽宁省沈阳市', '3');
INSERT INTO `users` VALUES ('8', 'zhangsan1', '123', '张三', '男', '15735698456', '130283154258452365', '111', '2');
