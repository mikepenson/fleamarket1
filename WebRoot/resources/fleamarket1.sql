/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : fleamarket1

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-09-27 15:25:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `goodsName` varchar(30) DEFAULT NULL,
  `releaseDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `count` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `hit` int(11) DEFAULT '0',
  `usetime` varchar(12) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `descriptionUrl` varchar(100) DEFAULT NULL,
  `tag` varchar(1) DEFAULT NULL,
  `bizType` varchar(1) DEFAULT NULL,
  `imgUrl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('17', '1', '1', '2', '全网通6plus，64G，港行...无修~低价出售', '2016-09-23 09:16:57', '1', '3333', '6', '1年', '兰州大学医学校区', '订了7所以低价转让...成色好...兰州可以见面交易，可以去售后查看，保证好机子，自己一手用的', '0', '0', 'b028bdbc-3199-43cb-a8ab-84027e83e97b.jpg');
INSERT INTO `goods` VALUES ('18', '2', '18', '3', '全新红旗山地车', '2016-09-19 21:05:50', '1', '800', '1', '半年', '兰州市城关区东方红广场', '去年脑子一热买的自行车，一共骑了两次不到二十公里！现在放家里占地方', '0', '0', '2b06af8b-a71c-4721-99e0-0e3e10ad6b61.jpg');
INSERT INTO `goods` VALUES ('19', '2', '28', '4', '宝宝自用小龙哈彼电动摩托车出售！', '2016-09-19 21:09:29', '1', '500', '0', '一年半', '兰州甘肃省中医院', '自家宝宝玩的电动摩托车，小龙哈彼的，质量很好，带音乐和灯光，充电一次玩2个小时，9成新，现在宝宝大了换了汽车，所以低价转让，喜欢的宝爸宝妈留言哦！（西站附近可送货上门）', '0', '0', '133054dd-f14f-488b-b59d-d6b1d9f2fb97.jpg');
INSERT INTO `goods` VALUES ('20', null, null, '4', '99新三星S6 edge+ 64G ', '2016-09-19 21:37:55', '1', '4000', '2', null, '宝贝购买时间不长，99.9全新无拆无修用机', '兰州城关', '0', '1', 'c7b28a8c-d887-428a-8e4a-ed2ad319b0a8.jpg');
INSERT INTO `goods` VALUES ('21', '1', '2', '4', '三星s7 edge 32G星钻黑', '2016-09-19 21:23:37', '1', '4600', '0', '半个月', '兰州市区', '全网通，星钻黑，没有磕碰，自用的保护的很好，发票齐全，五月份买的机子，要换肾7，所以出，支持验机\r\n原价5688', '0', '0', 'e24e0779-b44c-4960-ac52-4dbc43946352.jpg');
INSERT INTO `goods` VALUES ('22', '1', '3', '4', '小米高配超强续航', '2016-09-23 09:12:23', '1', '930', '2', '一年', '湛江市', '移动、联通双网通4G高配版红米Note3，今年5月底，花1200购买的套装版（手机+保护套+后壳+2张钢化膜+1张高清膜）。', '0', '0', 'b8b99f1e-fd54-4c62-88b8-3666451159d2.jpg');
INSERT INTO `goods` VALUES ('23', '1', '17', '4', '华为mates新买的刚用了两个月', '2016-09-20 11:27:54', '1', '1300', '2', '半年', '兰州大学医学校区', '新买的刚用了两个月\'\'如果是翻新机或者有维修过的情况存在\'\'立马退款\'\'可告知家庭住址', '1', '0', '03830bcc-fca2-4c66-968c-a2b2e558f20d.jpg');
INSERT INTO `goods` VALUES ('24', '1', '3', '2', '小米4', '2016-09-20 00:00:57', '1', '600', '1', '半月', '兰州-七里河', '价钱不咬死 不会做广告 反正没任何问题 钢化膜 原木后盖 有意者私信 不行自己接着用(ง •̀_•́)ง', '1', '0', 'ae8287dc-f5be-4a20-b153-a6f6a87bcd78.jpg');
INSERT INTO `goods` VALUES ('25', '1', '17', '5', '华为G9出售', '2016-09-20 12:48:01', '1', '1126', '1', '半个月', '兰州市', '9月2号买的，用了半个多月的华为G9手机，全网通，华为G9青春版手机，玫瑰金，16G，带手机壳，绝无划痕，喜欢的话就尽快联系我吧。', '0', '0', '2a77d77e-052d-4b39-ae63-957b563f2b8b.jpg');
INSERT INTO `goods` VALUES ('26', '2', '6', '5', '捷安特OCR3500 图便宜的就别问价了', '2016-09-20 12:40:01', '1', '1650', '0', '4个月', '兰州交大', '现因考研学习 车子放在宿舍吃灰大半年 转给喜爱公路车的朋友 打对折 再自刀100 现1650元', '0', '0', '5ba4f8a7-8f57-4235-a99c-36132e0c43bb.jpg');
INSERT INTO `goods` VALUES ('27', '2', '6', '5', '全新27速40刀公路自行车 ，碳钢框架只试车骑过', '2016-09-20 12:41:37', '1', '400', '0', '7个月', '兰州市', '试车骑过，闪光灯拍的有点暗，黑红色27速40刀，便宜出售 双碟刹，很拉风', '0', '0', 'f3cb0013-da8a-4d58-8fc7-65c632de9248.jpg');

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsTypeName` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES ('1', '二手手机');
INSERT INTO `goodstype` VALUES ('2', '二手车辆');
INSERT INTO `goodstype` VALUES ('3', '电脑配件');
INSERT INTO `goodstype` VALUES ('4', '图书文体');
INSERT INTO `goodstype` VALUES ('15', '数码产品');

-- ----------------------------
-- Table structure for subtype
-- ----------------------------
DROP TABLE IF EXISTS `subtype`;
CREATE TABLE `subtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `subTypeName` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subtype
-- ----------------------------
INSERT INTO `subtype` VALUES ('1', '1', '苹果');
INSERT INTO `subtype` VALUES ('2', '1', '三星');
INSERT INTO `subtype` VALUES ('3', '1', '小米');
INSERT INTO `subtype` VALUES ('4', '2', '普通自行车');
INSERT INTO `subtype` VALUES ('5', '2', '折叠自行车');
INSERT INTO `subtype` VALUES ('6', '2', '公路自行车');
INSERT INTO `subtype` VALUES ('7', '3', '联想');
INSERT INTO `subtype` VALUES ('8', '3', '戴尔');
INSERT INTO `subtype` VALUES ('10', '1', '索尼');
INSERT INTO `subtype` VALUES ('11', '1', '中兴');
INSERT INTO `subtype` VALUES ('17', '1', '华为');
INSERT INTO `subtype` VALUES ('18', '2', '山地自行车');
INSERT INTO `subtype` VALUES ('24', '1', '酷派');
INSERT INTO `subtype` VALUES ('25', '1', 'OPPO');
INSERT INTO `subtype` VALUES ('28', '2', '电动自行车');
INSERT INTO `subtype` VALUES ('29', '1', '手机配件');
INSERT INTO `subtype` VALUES ('30', '2', '骑行装备');
INSERT INTO `subtype` VALUES ('32', '4', '专业书');
INSERT INTO `subtype` VALUES ('34', '3', '台式机');
INSERT INTO `subtype` VALUES ('35', '3', '惠普');
INSERT INTO `subtype` VALUES ('36', '3', '显示器');
INSERT INTO `subtype` VALUES ('37', '3', '主板');
INSERT INTO `subtype` VALUES ('38', '3', '硬盘');
INSERT INTO `subtype` VALUES ('39', '4', '辅导书');
INSERT INTO `subtype` VALUES ('40', '4', '小说文学');
INSERT INTO `subtype` VALUES ('41', '4', '游泳用品');
INSERT INTO `subtype` VALUES ('42', '4', '各类棋牌');
INSERT INTO `subtype` VALUES ('43', '4', '帐篷');
INSERT INTO `subtype` VALUES ('44', '4', '睡袋');
INSERT INTO `subtype` VALUES ('48', '15', '单反');
INSERT INTO `subtype` VALUES ('49', '15', '电子书');
INSERT INTO `subtype` VALUES ('50', '15', 'iPod');
INSERT INTO `subtype` VALUES ('51', '15', 'iPod touch');
INSERT INTO `subtype` VALUES ('52', '15', 'PSP');
INSERT INTO `subtype` VALUES ('53', '15', 'Xbox 360');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `qq` varchar(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'melonydi', '102110nb', '18393817737', '', '1327876510@qq.com');
INSERT INTO `user` VALUES ('3', 'melonydi123', '102110nb', '18393817737', '', 'mikepenson@163.com');
INSERT INTO `user` VALUES ('4', 'mike', '123456', '18393912532', '', '1220@qq.com');
INSERT INTO `user` VALUES ('5', 'jonson', '123456', '18393817737', '54656556', '1387565274@qq.com');

-- ----------------------------
-- Table structure for usercollect
-- ----------------------------
DROP TABLE IF EXISTS `usercollect`;
CREATE TABLE `usercollect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `collectDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_user_collect` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usercollect
-- ----------------------------
