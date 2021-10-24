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

 Date: 24/10/2021 17:24:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_review_info
-- ----------------------------
DROP TABLE IF EXISTS `order_review_info`;
CREATE TABLE `order_review_info`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `order_id` int NOT NULL,
  `merchant_id` int NOT NULL,
  `review` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `student`(`student_id`) USING BTREE,
  INDEX `order`(`order_id`) USING BTREE,
  CONSTRAINT `order` FOREIGN KEY (`order_id`) REFERENCES `order_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `student` FOREIGN KEY (`student_id`) REFERENCES `user_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
