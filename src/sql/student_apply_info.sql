/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : parttime_system

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 24/10/2021 17:24:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student_apply_info
-- ----------------------------
DROP TABLE IF EXISTS `student_apply_info`;
CREATE TABLE `student_apply_info`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `order_id` int NOT NULL,
  `status` enum('processing','approved','rejected','completed') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fore_student`(`student_id`) USING BTREE,
  INDEX `fore_order`(`order_id`) USING BTREE,
  CONSTRAINT `fore_student` FOREIGN KEY (`student_id`) REFERENCES `user_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fore_order` FOREIGN KEY (`order_id`) REFERENCES `order_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
