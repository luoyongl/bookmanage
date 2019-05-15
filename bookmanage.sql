/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : localhost:3306
 Source Schema         : bookmanage

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 15/05/2019 18:43:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for b_apply_book
-- ----------------------------
DROP TABLE IF EXISTS `b_apply_book`;
CREATE TABLE `b_apply_book`  (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `f_book_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书id',
  `f_apply_year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选用学年',
  `f_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选择班级',
  `f_course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `f_major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `f_course_attribute` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程属性',
  `f_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `f_state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_apply_book
-- ----------------------------
INSERT INTO `b_apply_book` VALUES (26, 1, '3', '2018-2019年一学期', '软件11502', 'html', '软件工程', '必修课', '', '7', NULL, '2019-05-11 00:03:11', NULL, 0);
INSERT INTO `b_apply_book` VALUES (27, 1, '5', '2018-2019年一学期', '软件11502', 'oracle', '计算机科学', '必修课', '', '7', NULL, '2019-05-11 00:03:23', NULL, 0);
INSERT INTO `b_apply_book` VALUES (28, 1, '16', NULL, '软件11503', '阿萨德1', '软件工程', NULL, '', '1', NULL, '2019-05-14 00:36:38', NULL, 0);
INSERT INTO `b_apply_book` VALUES (29, 1, '17', NULL, '软件11501', '1111', '软件工程', NULL, '45', '1', NULL, '2019-05-15 17:17:38', NULL, 0);
INSERT INTO `b_apply_book` VALUES (30, 1, '16', NULL, '软件11501', '111', '计算机科学', NULL, '21', '1', NULL, '2019-05-15 17:28:44', NULL, 0);

-- ----------------------------
-- Table structure for b_book_list
-- ----------------------------
DROP TABLE IF EXISTS `b_book_list`;
CREATE TABLE `b_book_list`  (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_book_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书编号',
  `f_book_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书名称',
  `f_book_publish` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出版社',
  `f_book_isbn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ISBN',
  `f_book_editor` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主编',
  `f_book_edtion` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版次',
  `f_book_price` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '价格',
  `f_book_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书类型（性质）',
  `f_book_iswrite` tinyint(1) NULL DEFAULT 0 COMMENT '是否自编',
  `f_write_id` int(11) NULL DEFAULT 0 COMMENT '教师id',
  `f_book_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自编教材文件路径',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  `f_state` tinyint(4) NULL DEFAULT 0 COMMENT '申请状态',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_book_list
-- ----------------------------
INSERT INTO `b_book_list` VALUES (1, '10010', '毛泽东思想和中国特色社会主义理论体系概论', '高等教育出版社', '9787040494815', '毛概编写组', '2018年第6版', '50.00', '思政教材', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (2, '10011', '软件测试实战教程', '清华大学出版社', '9787302521921', '高科华、高珊珊', '第3版', '49.50', '计算机', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (3, '10012', '	HTML5+CSS3网页设计实例教程', '清华大学出版社', '9787302525004', '杨福贞、何永峰、李岩', '第1版', '68.00', '计算机', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (4, '10013', 'Java Web编程技术题解与实验指导', '清华大学出版社', '	9787302503408', '沈泽刚 ', '第3版', '29.50', '计算机', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (5, '10014', 'Flash二维动画设计与制作', '清华大学出版社', '9787302526001', '孙利娟、缪亮  ', '第3版', '59.80', '计算机', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (6, '10015', '	Oracle从新手到高手', '清华大学出版社', '9787302511595', '杨继萍', '第1版', '88.00', '计算机', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (7, '10016', '移动互联网导论', '清华大学出版社', '9787302519751', '傅洛伊 王新兵', '第3版', '99.00', '计算机', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (8, '10017', '网络攻击与防御技术', '清华大学出版社', '9787302518327', '王群', '第1版', '49.50', '计算机', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (9, '10018', '数据结构简明教程', '清华大学出版社', '9787302516293', '	李春葆、蒋林、方颖、喻丹丹、曾平', '第2版', '49.00', '计算机', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (10, '10019', '单片机原理与应用-基于可仿真的STC15系列', '清华大学出版社', '9787302508878', '冯铁成 ', '第1版', '58.00', '计算机', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (11, '10020', '航空活塞动力装置', '高等教育出版社', '9787564348052', '李卫东、侯甲栋', '第2版', '32.00', '工程制造', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (12, '10021', '	土力学与地基基础', '高等教育出版社', '9787564358297', '苏欣', '第1版', '38.00', '工程制造', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (13, '10022', '水利水电工程计量与计价', '高等教育出版社', '	9787564344939', '代彦芹', '第1版', '39.00', '工程制造', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (14, '10023', '工程造价管理', '高等教育出版社', '9787564357511', '任彦华 ', '第1版', '48.00', '工程制造', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (15, '10024', '应急设施与程序', '高等教育出版社', '	9787564348205', '孙芮', '第1版', '28.00', '工程制造', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `b_book_list` VALUES (16, NULL, '打', NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL, NULL, '2019-05-14 00:36:38', NULL, 0, 1);
INSERT INTO `b_book_list` VALUES (17, NULL, '2222', NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL, NULL, '2019-05-15 17:17:38', NULL, 0, 0);

-- ----------------------------
-- Table structure for b_book_order
-- ----------------------------
DROP TABLE IF EXISTS `b_book_order`;
CREATE TABLE `b_book_order`  (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_book_id` int(11) NULL DEFAULT NULL COMMENT '教材表id',
  `f_order_number` int(11) NULL DEFAULT NULL COMMENT '订单数量',
  `f_create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_book_order
-- ----------------------------
INSERT INTO `b_book_order` VALUES (6, 27, 1, '2019-05-11 13:26:09', 1, NULL, NULL, 0);

-- ----------------------------
-- Table structure for b_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `b_evaluate`;
CREATE TABLE `b_evaluate`  (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_book_id` int(11) NULL DEFAULT NULL,
  `f_grade` int(11) NULL DEFAULT NULL,
  `f_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `f_user_id` int(11) NULL DEFAULT NULL,
  `f_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `f_create_time` timestamp(0) NULL DEFAULT NULL,
  `f_update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_evaluate
-- ----------------------------
INSERT INTO `b_evaluate` VALUES (4, 5, 4, '4154', 4, '内容好,质量合格,难易适度', NULL, '2019-05-14 00:29:08');
INSERT INTO `b_evaluate` VALUES (7, 3, 5, 'adafvcvbnm', 3, '内容好,质量合格,难易适度,印刷差,不易理解', NULL, '2019-05-15 10:54:26');

-- ----------------------------
-- Table structure for b_responsitory
-- ----------------------------
DROP TABLE IF EXISTS `b_responsitory`;
CREATE TABLE `b_responsitory`  (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_book_id` int(11) NULL DEFAULT NULL,
  `f_number` int(11) NULL DEFAULT NULL COMMENT '库存数量',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_responsitory
-- ----------------------------
INSERT INTO `b_responsitory` VALUES (1, 1, 104, NULL, NULL, NULL, 0);
INSERT INTO `b_responsitory` VALUES (2, 2, 100, NULL, NULL, NULL, 0);
INSERT INTO `b_responsitory` VALUES (3, 3, 100, NULL, NULL, NULL, 0);
INSERT INTO `b_responsitory` VALUES (4, 4, 100, NULL, NULL, NULL, 0);
INSERT INTO `b_responsitory` VALUES (5, 5, 99, NULL, NULL, NULL, 0);
INSERT INTO `b_responsitory` VALUES (6, 6, 100, NULL, NULL, NULL, 0);
INSERT INTO `b_responsitory` VALUES (7, 7, 100, NULL, NULL, NULL, 0);
INSERT INTO `b_responsitory` VALUES (8, 8, 100, NULL, NULL, NULL, 0);
INSERT INTO `b_responsitory` VALUES (9, 9, 100, NULL, NULL, NULL, 0);
INSERT INTO `b_responsitory` VALUES (10, 10, 100, NULL, NULL, NULL, 0);
INSERT INTO `b_responsitory` VALUES (11, 11, 100, NULL, NULL, NULL, 0);
INSERT INTO `b_responsitory` VALUES (12, 12, 100, NULL, NULL, NULL, 0);
INSERT INTO `b_responsitory` VALUES (13, 13, 100, NULL, NULL, NULL, 0);
INSERT INTO `b_responsitory` VALUES (14, 14, 100, NULL, NULL, NULL, 0);
INSERT INTO `b_responsitory` VALUES (15, 15, 100, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for b_student_book
-- ----------------------------
DROP TABLE IF EXISTS `b_student_book`;
CREATE TABLE `b_student_book`  (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_user_id` int(11) NULL DEFAULT NULL,
  `f_book_id` int(11) NULL DEFAULT NULL,
  `f_create_time` timestamp(0) NULL DEFAULT NULL,
  `f_update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_student_book
-- ----------------------------
INSERT INTO `b_student_book` VALUES (18, 4, 5, NULL, NULL, 0);
INSERT INTO `b_student_book` VALUES (19, 3, 3, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_dictionary`;
CREATE TABLE `t_dictionary`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_dictionary_type` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '字典类型',
  `f_dictionary_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典代码',
  `f_third_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '三方编码',
  `f_dictionary_content` varchar(320) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典内容(三方编码名称)',
  `f_parent_node` int(11) NULL DEFAULT NULL,
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `f_operator_id` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_dictionary
-- ----------------------------
INSERT INTO `t_dictionary` VALUES (1, NULL, 'college', NULL, '数学与计算机学院', 0, 0, '2019-05-04 12:58:54', NULL, '2019-05-06 13:26:22', 2, 0);
INSERT INTO `t_dictionary` VALUES (2, NULL, 'college', NULL, '电子电气学院', 0, 0, '2019-05-04 12:58:54', NULL, '2019-05-04 12:58:54', NULL, 0);
INSERT INTO `t_dictionary` VALUES (3, NULL, 'college', NULL, '会计学院', 0, 0, '2019-05-04 12:59:09', NULL, '2019-05-04 12:58:54', NULL, 0);
INSERT INTO `t_dictionary` VALUES (4, NULL, 'college', NULL, '软件11502', 1, 0, '2019-05-04 12:59:33', NULL, '2019-05-07 13:25:25', 2, 0);
INSERT INTO `t_dictionary` VALUES (5, NULL, 'college', NULL, '会计11501', 3, 0, '2019-05-04 13:00:40', NULL, '2019-05-04 12:58:54', NULL, 0);
INSERT INTO `t_dictionary` VALUES (6, NULL, 'college', NULL, '光电11501', 2, 0, '2019-05-05 16:12:09', NULL, '2019-05-04 12:58:54', NULL, 0);
INSERT INTO `t_dictionary` VALUES (43, NULL, 'course', NULL, '必修课', 0, 0, '2019-05-06 12:40:22', NULL, '2019-05-06 13:06:16', NULL, 0);
INSERT INTO `t_dictionary` VALUES (44, NULL, 'course', NULL, '专业选修课', 0, 0, '2019-05-06 12:40:40', NULL, '2019-05-06 13:06:17', NULL, 0);
INSERT INTO `t_dictionary` VALUES (45, NULL, 'course', NULL, '学科基础课', 0, 0, '2019-05-06 12:41:07', NULL, '2019-05-06 13:06:17', NULL, 0);
INSERT INTO `t_dictionary` VALUES (46, NULL, 'course', NULL, '专业必修课', 0, 0, '2019-05-06 12:41:26', NULL, '2019-05-06 13:06:18', NULL, 0);
INSERT INTO `t_dictionary` VALUES (47, NULL, 'course', NULL, '通识选修课', 0, 0, '2019-05-06 12:41:43', NULL, '2019-05-06 13:06:20', NULL, 0);
INSERT INTO `t_dictionary` VALUES (55, NULL, 'college', NULL, '会计11502', 3, 0, '2019-05-06 16:03:55', 2, '2019-05-06 16:03:55', NULL, 0);
INSERT INTO `t_dictionary` VALUES (56, NULL, 'undefined', NULL, NULL, 16, 0, '2019-05-15 18:01:35', 1, '2019-05-15 18:01:35', NULL, 0);

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_resource_classification` tinyint(4) NULL DEFAULT NULL COMMENT '资源分类',
  `f_resource_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `f_parent_resource` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '父资源',
  `f_resource_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源路径',
  `f_permission_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限代码',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  `f_resource_ico` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源图标',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO `t_resource` VALUES (1, NULL, '教材申请', 0, NULL, NULL, 0, '2019-04-25 14:49:28', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (2, NULL, '教材选用结果', 1, 'teacher/applyresult', NULL, 1, '2019-04-25 14:51:02', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (3, NULL, '教用教材领用', 1, 'teacher/booklist', NULL, 2, '2019-04-25 14:51:49', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (4, NULL, '自编教材印刷', 1, 'teacher/ownWrite', NULL, 3, '2019-04-25 14:55:13', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (5, NULL, '教材反馈', 0, 'teacher/lookEvalute', NULL, 3, '2019-04-25 14:56:31', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (6, NULL, '教材审批', 0, NULL, NULL, 1, '2019-05-03 22:45:01', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (7, NULL, '教材审批', 6, 'manager/review/applyresult', NULL, 0, '2019-05-03 22:45:56', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (8, NULL, '审批记录', 6, 'manager/review/reviewHistory', NULL, 2, '2019-05-03 22:46:19', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (9, NULL, '教材评价报表', 0, NULL, NULL, 2, '2019-05-03 22:47:05', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (10, NULL, '基础数据管理', 0, 'manager/baseDate', NULL, 4, '2019-05-03 22:47:40', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (11, NULL, '学生教材选用', 0, NULL, NULL, 0, '2019-05-09 22:30:22', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (12, NULL, '教材选用', 11, 'student/confirmApply', NULL, 1, '2019-05-09 22:31:59', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (13, NULL, '教材评价', 11, 'student/evalute', NULL, 2, '2019-05-09 22:32:24', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (14, NULL, '教材订单管理', 0, NULL, NULL, 0, '2019-05-11 01:20:06', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (15, NULL, '订单审批', 14, 'staff/order', NULL, 1, '2019-05-11 01:20:42', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (16, NULL, '库存管理', 14, 'staff/responsitory', NULL, 2, '2019-05-11 01:20:53', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (17, NULL, '确认教材领取', 11, 'student/exitorder', NULL, 0, '2019-05-11 20:26:32', NULL, NULL, NULL, 0, NULL);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `f_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `f_role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `f_role_description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '教师', NULL, 0, '2019-04-25 15:25:06', NULL, NULL, NULL, 0);
INSERT INTO `t_role` VALUES (2, '教学秘书', NULL, 0, '2019-04-25 15:25:34', NULL, NULL, NULL, 0);
INSERT INTO `t_role` VALUES (3, '采购处工作人员', NULL, 0, '2019-04-25 15:25:53', NULL, NULL, NULL, 0);
INSERT INTO `t_role` VALUES (4, '班长', NULL, 0, '2019-04-25 15:26:09', NULL, NULL, NULL, 0);
INSERT INTO `t_role` VALUES (5, '普通学生', NULL, 0, '2019-04-25 15:26:17', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_role_and_resource_link
-- ----------------------------
DROP TABLE IF EXISTS `t_role_and_resource_link`;
CREATE TABLE `t_role_and_resource_link`  (
  `f_role_resources_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_role_id` int(11) UNSIGNED NOT NULL COMMENT '角色id',
  `f_resources_id` int(11) UNSIGNED NOT NULL COMMENT '资源id',
  PRIMARY KEY (`f_role_resources_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与资源相关表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_role_and_resource_link
-- ----------------------------
INSERT INTO `t_role_and_resource_link` VALUES (1, 1, 1);
INSERT INTO `t_role_and_resource_link` VALUES (2, 1, 2);
INSERT INTO `t_role_and_resource_link` VALUES (3, 1, 3);
INSERT INTO `t_role_and_resource_link` VALUES (4, 1, 4);
INSERT INTO `t_role_and_resource_link` VALUES (5, 1, 5);
INSERT INTO `t_role_and_resource_link` VALUES (6, 2, 6);
INSERT INTO `t_role_and_resource_link` VALUES (7, 2, 7);
INSERT INTO `t_role_and_resource_link` VALUES (8, 2, 8);
INSERT INTO `t_role_and_resource_link` VALUES (9, 2, 9);
INSERT INTO `t_role_and_resource_link` VALUES (10, 2, 10);
INSERT INTO `t_role_and_resource_link` VALUES (11, 2, 5);
INSERT INTO `t_role_and_resource_link` VALUES (12, 4, 11);
INSERT INTO `t_role_and_resource_link` VALUES (13, 4, 12);
INSERT INTO `t_role_and_resource_link` VALUES (14, 4, 13);
INSERT INTO `t_role_and_resource_link` VALUES (15, 5, 11);
INSERT INTO `t_role_and_resource_link` VALUES (16, 5, 12);
INSERT INTO `t_role_and_resource_link` VALUES (17, 5, 13);
INSERT INTO `t_role_and_resource_link` VALUES (18, 3, 14);
INSERT INTO `t_role_and_resource_link` VALUES (19, 3, 15);
INSERT INTO `t_role_and_resource_link` VALUES (20, 3, 16);
INSERT INTO `t_role_and_resource_link` VALUES (21, 4, 17);

-- ----------------------------
-- Table structure for t_role_and_user_association
-- ----------------------------
DROP TABLE IF EXISTS `t_role_and_user_association`;
CREATE TABLE `t_role_and_user_association`  (
  `f_role_and_user_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `f_role_id` int(10) UNSIGNED NOT NULL COMMENT '角色id',
  `f_user_id` int(10) UNSIGNED NOT NULL COMMENT '用户id',
  PRIMARY KEY (`f_role_and_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与用户相关表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_role_and_user_association
-- ----------------------------
INSERT INTO `t_role_and_user_association` VALUES (1, 1, 1);
INSERT INTO `t_role_and_user_association` VALUES (2, 2, 2);
INSERT INTO `t_role_and_user_association` VALUES (3, 4, 3);
INSERT INTO `t_role_and_user_association` VALUES (4, 5, 4);
INSERT INTO `t_role_and_user_association` VALUES (5, 3, 5);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `f_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `real_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属单位',
  `f_duties` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称',
  `f_is_effective` tinyint(1) NULL DEFAULT 1 COMMENT '是否有效',
  `f_telphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `f_create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '123', '罗勇', '123', '数学与计算机学院', NULL, 1, NULL, '2019-04-20 20:08:46', NULL, NULL, NULL, 0);
INSERT INTO `t_user` VALUES (2, 'admin', '教学秘书', 'admin', '教务处', NULL, 1, NULL, '2019-04-21 13:27:35', NULL, NULL, NULL, 0);
INSERT INTO `t_user` VALUES (3, 'monitor', '班长', 'monitor', '软件11502', NULL, 1, NULL, '2019-04-21 19:58:08', NULL, NULL, NULL, 0);
INSERT INTO `t_user` VALUES (4, 'stu', 'stu', 'stu', '软件11502', NULL, 1, NULL, '2019-05-10 14:59:15', NULL, NULL, NULL, 0);
INSERT INTO `t_user` VALUES (5, '111', 'order', '111', '1', NULL, 1, NULL, '2019-05-11 01:19:11', NULL, NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
