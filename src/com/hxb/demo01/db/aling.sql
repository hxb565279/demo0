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

 Date: 12/09/2021 06:13:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aling
-- ----------------------------
DROP TABLE IF EXISTS `aling`;
CREATE TABLE `aling`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shouzhi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `yu_e` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jin_e` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shuoming` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of aling
-- ----------------------------
INSERT INTO `aling` VALUES (5, '收入', '5721', '5677', '测试');
INSERT INTO `aling` VALUES (6, '收入', '5765', '44', '测试');
INSERT INTO `aling` VALUES (7, '支出', '5753', '12', '测试');
INSERT INTO `aling` VALUES (8, '收入', '5775', '22', '测试');
INSERT INTO `aling` VALUES (9, '支出', '220', '5555', '测试');
INSERT INTO `aling` VALUES (10, '收入', '4653', '4433', '手手');
INSERT INTO `aling` VALUES (11, '支出', '4210', '443', '吃饭');
INSERT INTO `aling` VALUES (12, '收入', '4644', '434', '吃饭');
INSERT INTO `aling` VALUES (13, '支出', '4210', '434', '吃饭');

SET FOREIGN_KEY_CHECKS = 1;
