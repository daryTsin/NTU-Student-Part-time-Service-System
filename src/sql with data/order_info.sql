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

 Date: 30/10/2021 22:50:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `merchant_id` int NOT NULL,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `post_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `work_period` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `publish_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `salary` decimal(10, 2) NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `staff_number` tinyint NULL DEFAULT NULL,
  `deadline` timestamp NULL DEFAULT NULL,
  `status` enum('processing','approved','rejected','completed') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `merchant`(`merchant_id`) USING BTREE,
  CONSTRAINT `merchant` FOREIGN KEY (`merchant_id`) REFERENCES `user_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (1, 2, 'cleaner', 'clean the kitchen and stores', 'Marina Bay', '381002', 'once a week', '2021-10-30 22:46:56', 10.00, 'hotel', 5, '2021-11-30 00:00:00', 'processing');
INSERT INTO `order_info` VALUES (2, 2, 'cashier', 'need beauttiful and enthusiastic', 'Pasir Ris', '519943', 'every Monday', '2021-10-30 22:46:58', 15.00, 'store', 10, '2021-11-30 00:00:00', 'processing');
INSERT INTO `order_info` VALUES (3, 5, 'waiter needed', 'work hard and patient', 'Kallang', '474826', 'On weekdays', '2021-10-30 22:47:14', 20.00, 'store', 20, '2021-11-25 22:47:05', 'processing');

SET FOREIGN_KEY_CHECKS = 1;
