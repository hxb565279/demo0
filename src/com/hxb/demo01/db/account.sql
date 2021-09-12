/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306_1
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : demo01

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 12/09/2021 10:51:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shouzhi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `yu_e` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jin_e` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shuoming` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (5, '收入', '5721', '5677', '测试');
INSERT INTO `account` VALUES (6, '收入', '5765', '44', '测试');
INSERT INTO `account` VALUES (7, '支出', '5753', '12', '测试');
INSERT INTO `account` VALUES (8, '收入', '5775', '22', '测试');
INSERT INTO `account` VALUES (9, '支出', '220', '5555', '测试');
INSERT INTO `account` VALUES (10, '收入', '4653', '4433', '手手');
INSERT INTO `account` VALUES (11, '支出', '4210', '443', '吃饭');
INSERT INTO `account` VALUES (12, '收入', '4644', '434', '吃饭');
INSERT INTO `account` VALUES (13, '支出', '4210', '434', '吃饭');
INSERT INTO `account` VALUES (14, '收入', '4544', '334', '购物');
INSERT INTO `account` VALUES (15, '支出', '4532', '12', '购物');

SET FOREIGN_KEY_CHECKS = 1;
