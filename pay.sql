/*
 Navicat Premium Data Transfer

 Source Server         : mysql_local
 Source Server Type    : MySQL
 Source Server Version : 50634
 Source Host           : localhost:3306
 Source Schema         : pay

 Target Server Type    : MySQL
 Target Server Version : 50634
 File Encoding         : 65001

 Date: 13/09/2022 20:30:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pay
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay`  (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `date_time` datetime NULL DEFAULT NULL COMMENT '年/月 组成',
  `user_id` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工资标题',
  `value` int(11) NULL DEFAULT NULL COMMENT '工资金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pay
-- ----------------------------
INSERT INTO `pay` VALUES (13, '2022-09-01 00:00:00', 9, '11', 231231);
INSERT INTO `pay` VALUES (14, '2022-07-01 00:00:00', 9, '222', 123);
INSERT INTO `pay` VALUES (15, '2022-06-01 00:00:00', 9, '1123123', 12312312);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `type` int(11) NULL DEFAULT NULL COMMENT '0 - 管理员 1- 普通用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '202cb962ac59075b964b07152d234b70', 'admin', 0);
INSERT INTO `user` VALUES (5, NULL, NULL, '334', 1);
INSERT INTO `user` VALUES (6, NULL, NULL, '22', 1);
INSERT INTO `user` VALUES (7, NULL, NULL, '222', 1);
INSERT INTO `user` VALUES (8, NULL, NULL, '刘磊', 1);
INSERT INTO `user` VALUES (9, NULL, NULL, '张傲', 1);
INSERT INTO `user` VALUES (10, NULL, NULL, '张傲·', 1);

SET FOREIGN_KEY_CHECKS = 1;
