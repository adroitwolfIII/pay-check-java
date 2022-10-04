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

 Date: 04/10/2022 15:32:31
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
  `jcgz` int(11) NULL DEFAULT NULL COMMENT '工资标题',
  `ksf` int(11) NULL DEFAULT NULL COMMENT '课时费',
  `jcjx` int(11) NULL DEFAULT NULL COMMENT '基础绩效',
  `glgz` int(11) NULL DEFAULT NULL COMMENT '工龄工资',
  `dhbz` int(11) NULL DEFAULT NULL COMMENT '电话补助',
  `jtbz` int(11) NULL DEFAULT NULL COMMENT '交通补助',
  `jbbz` int(11) NULL DEFAULT NULL COMMENT '加班补助',
  `ldbx` int(11) NULL DEFAULT NULL COMMENT '劳动保险',
  `sybx` int(11) NULL DEFAULT NULL COMMENT '失业保险',
  `ylbx` int(11) NULL DEFAULT NULL COMMENT '医疗保险',
  `grsds` int(11) NULL DEFAULT NULL COMMENT '个人所得说',
  `gjj` int(11) NULL DEFAULT NULL COMMENT '公积金',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pay
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号-真实姓名',
  `type` int(11) NULL DEFAULT NULL COMMENT '0 - 管理员 1- 普通用户',
  `id_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号-用来找回普通账号',
  `credit_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工资卡卡号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '202cb962ac59075b964b07152d234b70', 'admin', 0, NULL, NULL);
INSERT INTO `user` VALUES (14, '202cb962ac59075b964b07152d234b70', 'zc', 0, '123', '123');
INSERT INTO `user` VALUES (15, '202cb962ac59075b964b07152d234b70', 'za', 0, '123', '123');

SET FOREIGN_KEY_CHECKS = 1;
