/*
 Navicat Premium Data Transfer

 Source Server         : mysql7.7-localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 127.0.0.1:3306
 Source Schema         : pm

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 27/04/2022 22:28:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for adjustsalary
-- ----------------------------
DROP TABLE IF EXISTS `adjustsalary`;
CREATE TABLE `adjustsalary`  (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `eid` int(11) NULL DEFAULT NULL,
                                 `asDate` date NULL DEFAULT NULL COMMENT '调薪日期',
                                 `beforeSalary` int(11) NULL DEFAULT NULL COMMENT '调前薪资',
                                 `afterSalary` int(11) NULL DEFAULT NULL COMMENT '调后薪资',
                                 `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调薪原因',
                                 `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
                                 PRIMARY KEY (`id`) USING BTREE,
                                 INDEX `pid`(`eid`) USING BTREE,
                                 CONSTRAINT `adjustsalary_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for appraise
-- ----------------------------
DROP TABLE IF EXISTS `appraise`;
CREATE TABLE `appraise`  (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `eid` int(11) NULL DEFAULT NULL,
                             `appDate` date NULL DEFAULT NULL COMMENT '考评日期',
                             `appResult` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考评结果',
                             `appContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考评内容',
                             `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
                             PRIMARY KEY (`id`) USING BTREE,
                             INDEX `pid`(`eid`) USING BTREE,
                             CONSTRAINT `appraise_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
                               `parentId` int(11) NULL DEFAULT NULL COMMENT '父部门id',
                               `depPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所有部门id',
                               `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否激活',
                               `isParent` tinyint(1) NULL DEFAULT 0 COMMENT '是否是父部门',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 119 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '股东会', -1, '.1', 1, 1);
INSERT INTO `department` VALUES (4, '董事会', 1, '.1.4', 1, 1);
INSERT INTO `department` VALUES (5, '总办', 4, '.1.4.5', 1, 1);
INSERT INTO `department` VALUES (8, '财务部', 5, '.1.4.5.8', 1, 0);
INSERT INTO `department` VALUES (78, '市场部', 5, '.1.4.5.78', 1, 1);
INSERT INTO `department` VALUES (81, '华北市场部', 78, '.1.4.5.78.81', 1, 1);
INSERT INTO `department` VALUES (82, '华南市场部', 78, '.1.4.5.78.82', 1, 0);
INSERT INTO `department` VALUES (85, '石家庄市场部', 81, '.1.4.5.78.81.85', 1, 0);
INSERT INTO `department` VALUES (86, '西北市场部', 78, '.1.4.5.78.86', 1, 1);
INSERT INTO `department` VALUES (87, '西安市场', 86, '.1.4.5.78.86.87', 1, 1);
INSERT INTO `department` VALUES (89, '莲湖区市场', 87, '.1.4.5.78.86.87.89', 1, 0);
INSERT INTO `department` VALUES (91, '技术部', 5, '.1.4.5.91', 1, 0);
INSERT INTO `department` VALUES (92, '运维部', 5, '.1.4.5.92', 1, 1);
INSERT INTO `department` VALUES (93, '运维1部', 92, '.1.4.5.92.93', 1, 0);
INSERT INTO `department` VALUES (94, '运维2部', 92, '.1.4.5.92.94', 1, 0);
INSERT INTO `department` VALUES (96, 'bbb', 1, '.1.96', 1, 1);
INSERT INTO `department` VALUES (106, '111', 96, '.1.96.106', 1, 1);
INSERT INTO `department` VALUES (112, '222', 106, '.1.96.106.112', 1, 0);
INSERT INTO `department` VALUES (113, '20220417', 96, '.1.96.113', 1, 1);
INSERT INTO `department` VALUES (114, '测试添加部门看回调', 113, '.1.96.113.114', 1, 1);
INSERT INTO `department` VALUES (115, '测试添加部门看回调', 113, '.1.96.113.115', 1, 0);
INSERT INTO `department` VALUES (116, '11', 114, '.1.96.113.114.116', 1, 0);
INSERT INTO `department` VALUES (117, '22', 114, '.1.96.113.114.117', 1, 0);
INSERT INTO `department` VALUES (118, '23', 114, '.1.96.113.114.118', 1, 0);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
                             `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
                             `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
                             `gender` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
                             `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
                             `idCard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
                             `wedlock` enum('已婚','未婚','离异') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '婚姻状况',
                             `nationId` int(11) NULL DEFAULT NULL COMMENT '民族',
                             `nativePlace` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
                             `politicId` int(11) NULL DEFAULT NULL COMMENT '政治面貌',
                             `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
                             `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
                             `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
                             `departmentId` int(11) NULL DEFAULT NULL COMMENT '所属部门',
                             `jobLevelId` int(11) NULL DEFAULT NULL COMMENT '职称ID',
                             `posId` int(11) NULL DEFAULT NULL COMMENT '职位ID',
                             `engageForm` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '聘用形式',
                             `tiptopDegree` enum('博士','硕士','本科','大专','高中','初中','小学','其他') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最高学历',
                             `specialty` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属专业',
                             `school` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业院校',
                             `beginDate` date NULL DEFAULT NULL COMMENT '入职日期',
                             `workState` enum('在职','离职') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '在职' COMMENT '在职状态',
                             `workID` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
                             `contractTerm` double NULL DEFAULT NULL COMMENT '合同期限',
                             `conversionTime` date NULL DEFAULT NULL COMMENT '转正日期',
                             `notWorkDate` date NULL DEFAULT NULL COMMENT '离职日期',
                             `beginContract` date NULL DEFAULT NULL COMMENT '合同起始日期',
                             `endContract` date NULL DEFAULT NULL COMMENT '合同终止日期',
                             `workAge` int(11) NULL DEFAULT NULL COMMENT '工龄',
                             `file_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件地址',
                             PRIMARY KEY (`id`) USING BTREE,
                             INDEX `departmentId`(`departmentId`) USING BTREE,
                             INDEX `jobId`(`jobLevelId`) USING BTREE,
                             INDEX `dutyId`(`posId`) USING BTREE,
                             INDEX `nationId`(`nationId`) USING BTREE,
                             INDEX `politicId`(`politicId`) USING BTREE,
                             INDEX `workID_key`(`workID`) USING BTREE,
                             CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                             CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`jobLevelId`) REFERENCES `joblevel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                             CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`posId`) REFERENCES `position` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                             CONSTRAINT `employee_ibfk_4` FOREIGN KEY (`nationId`) REFERENCES `nation` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                             CONSTRAINT `employee_ibfk_5` FOREIGN KEY (`politicId`) REFERENCES `politicsstatus` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for employeeec
-- ----------------------------
DROP TABLE IF EXISTS `employeeec`;
CREATE TABLE `employeeec`  (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `eid` int(11) NULL DEFAULT NULL COMMENT '员工编号',
                               `ecDate` date NULL DEFAULT NULL COMMENT '奖罚日期',
                               `ecReason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奖罚原因',
                               `ecPoint` int(11) NULL DEFAULT NULL COMMENT '奖罚分',
                               `ecType` int(11) NULL DEFAULT NULL COMMENT '奖罚类别，0：奖，1：罚',
                               `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
                               PRIMARY KEY (`id`) USING BTREE,
                               INDEX `pid`(`eid`) USING BTREE,
                               CONSTRAINT `employeeec_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for employeeremove
-- ----------------------------
DROP TABLE IF EXISTS `employeeremove`;
CREATE TABLE `employeeremove`  (
                                   `id` int(11) NOT NULL AUTO_INCREMENT,
                                   `eid` int(11) NULL DEFAULT NULL,
                                   `afterDepId` int(11) NULL DEFAULT NULL COMMENT '调动后部门',
                                   `afterJobId` int(11) NULL DEFAULT NULL COMMENT '调动后职位',
                                   `removeDate` date NULL DEFAULT NULL COMMENT '调动日期',
                                   `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调动原因',
                                   `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                   PRIMARY KEY (`id`) USING BTREE,
                                   INDEX `pid`(`eid`) USING BTREE,
                                   CONSTRAINT `employeeremove_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for employeetrain
-- ----------------------------
DROP TABLE IF EXISTS `employeetrain`;
CREATE TABLE `employeetrain`  (
                                  `id` int(11) NOT NULL AUTO_INCREMENT,
                                  `eid` int(11) NULL DEFAULT NULL COMMENT '员工编号',
                                  `trainDate` date NULL DEFAULT NULL COMMENT '培训日期',
                                  `trainContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '培训内容',
                                  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
                                  PRIMARY KEY (`id`) USING BTREE,
                                  INDEX `pid`(`eid`) USING BTREE,
                                  CONSTRAINT `employeetrain_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for empsalary
-- ----------------------------
DROP TABLE IF EXISTS `empsalary`;
CREATE TABLE `empsalary`  (
                              `id` int(11) NOT NULL AUTO_INCREMENT,
                              `eid` int(11) NULL DEFAULT NULL,
                              `sid` int(11) NULL DEFAULT NULL,
                              PRIMARY KEY (`id`) USING BTREE,
                              UNIQUE INDEX `eid`(`eid`) USING BTREE,
                              INDEX `empsalary_ibfk_2`(`sid`) USING BTREE,
                              CONSTRAINT `empsalary_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                              CONSTRAINT `empsalary_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `salary` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hr
-- ----------------------------
DROP TABLE IF EXISTS `hr`;
CREATE TABLE `hr`  (
                       `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'hrID',
                       `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
                       `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
                       `telephone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住宅电话',
                       `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
                       `enabled` tinyint(1) NULL DEFAULT 1,
                       `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
                       `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
                       `userface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                       `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hr
-- ----------------------------
INSERT INTO `hr` VALUES (1, '超级管理员', '1555555555', '15555555555', '火星', 1, 'admin', '$2a$10$3MhfCTCMQuiGSrzxHYBZ7eXvnn.Eh5VmjNvosqV7SC/W4cg6XFDOi', 'http://img.codefarmer.fun/handboy-1.png', '超级管理员');
INSERT INTO `hr` VALUES (5, '李四', '18568123489', '029-82123434', '大连瓦房店', 1, 'lisi', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://img.codefarmer.fun/handboy-2.png', NULL);
INSERT INTO `hr` VALUES (10, '韩五', '18568123666', '029-82111555', '大连锦州', 1, 'hanwu', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://img.codefarmer.fun/handgil-1.png', NULL);
INSERT INTO `hr` VALUES (11, '柳六', '18568123377', '029-82111333', '大连高新园', 1, 'liuliu', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://img.codefarmer.fun/handgril-2.png', NULL);
INSERT INTO `hr` VALUES (12, '曾七', '18568128888', '029-82111222', '大连中山', 1, 'zengqi', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://img.codefarmer.fun/handgril-3.png', NULL);
INSERT INTO `hr` VALUES (13, '测试', '110', '120', '测试', 1, 'ceshi', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', NULL, NULL);

-- ----------------------------
-- Table structure for hr_role
-- ----------------------------
DROP TABLE IF EXISTS `hr_role`;
CREATE TABLE `hr_role`  (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `hrid` int(11) NULL DEFAULT NULL,
                            `rid` int(11) NULL DEFAULT NULL,
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `rid`(`rid`) USING BTREE,
                            INDEX `hr_role_ibfk_1`(`hrid`) USING BTREE,
                            CONSTRAINT `hr_role_ibfk_1` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
                            CONSTRAINT `hr_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hr_role
-- ----------------------------
INSERT INTO `hr_role` VALUES (1, 1, 6);
INSERT INTO `hr_role` VALUES (35, 12, 4);
INSERT INTO `hr_role` VALUES (36, 12, 3);
INSERT INTO `hr_role` VALUES (37, 12, 2);
INSERT INTO `hr_role` VALUES (43, 11, 3);
INSERT INTO `hr_role` VALUES (44, 11, 2);
INSERT INTO `hr_role` VALUES (45, 11, 4);
INSERT INTO `hr_role` VALUES (46, 11, 5);
INSERT INTO `hr_role` VALUES (48, 10, 3);
INSERT INTO `hr_role` VALUES (49, 10, 4);
INSERT INTO `hr_role` VALUES (72, 5, 1);
INSERT INTO `hr_role` VALUES (73, 5, 2);
INSERT INTO `hr_role` VALUES (74, 5, 3);

-- ----------------------------
-- Table structure for joblevel
-- ----------------------------
DROP TABLE IF EXISTS `joblevel`;
CREATE TABLE `joblevel`  (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称名称',
                             `titleLevel` enum('正高级','副高级','中级','初级','员级') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                             `createDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
                             `enabled` tinyint(1) NULL DEFAULT 1,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of joblevel
-- ----------------------------
INSERT INTO `joblevel` VALUES (1, '测试职称', '初级', '2022-04-19 19:23:26', 1);
INSERT INTO `joblevel` VALUES (3, '职称2', '正高级', '2022-04-19 19:27:21', 1);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `path` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `component` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `iconCls` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `keepAlive` tinyint(1) NULL DEFAULT NULL,
                         `requireAuth` tinyint(1) NULL DEFAULT NULL,
                         `parentId` int(11) NULL DEFAULT NULL,
                         `enabled` tinyint(1) NULL DEFAULT 1,
                         PRIMARY KEY (`id`) USING BTREE,
                         INDEX `parentId`(`parentId`) USING BTREE,
                         CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '/', NULL, NULL, '所有', NULL, NULL, NULL, NULL, 1);
INSERT INTO `menu` VALUES (2, '/', '/home', 'Home', '员工资料', 'el-icon-user-solid', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (3, '/', '/home', 'Home', '人事管理', 'fa fa-address-card-o', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (4, '/', '/home', 'Home', '薪资管理', 'fa fa-money', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (5, '/', '/home', 'Home', '统计管理', 'fa fa-bar-chart', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (6, '/', '/home', 'Home', '系统管理', 'fa fa-windows', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (7, '/employee/basic/**', '/emp/basic', 'EmpBasic', '基本资料', NULL, NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (8, '/employee/advanced/**', '/emp/adv', 'EmpAdv', '高级资料', NULL, NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (9, '/personnel/emp/**', '/per/emp', 'PerEmp', '员工资料', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (10, '/personnel/ec/**', '/per/ec', 'PerEc', '员工奖惩', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (11, '/personnel/train/**', '/per/train', 'PerTrain', '员工培训', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (12, '/personnel/salary/**', '/per/salary', 'PerSalary', '员工调薪', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (13, '/personnel/remove/**', '/per/mv', 'PerMv', '员工调动', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (14, '/salary/sob/**', '/sal/sob', 'SalSob', '工资账套管理', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (15, '/salary/sobcfg/**', '/sal/sobcfg', 'SalSobCfg', '员工账套设置', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (16, '/salary/table/**', '/sal/table', 'SalTable', '工资表管理', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (17, '/salary/month/**', '/sal/month', 'SalMonth', '月末处理', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (18, '/salary/search/**', '/sal/search', 'SalSearch', '工资表查询', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (19, '/statistics/all/**', '/sta/all', 'StaAll', '综合信息统计', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (20, '/statistics/score/**', '/sta/score', 'StaScore', '员工积分统计', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (21, '/statistics/personnel/**', '/sta/pers', 'StaPers', '人事信息统计', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (22, '/statistics/recored/**', '/sta/record', 'StaRecord', '人事记录统计', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (23, '/system/basic/**', '/sys/basic', 'SysBasic', '基础信息设置', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (24, '/system/cfg/**', '/sys/cfg', 'SysCfg', '系统管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (25, '/system/log/**', '/sys/log', 'SysLog', '操作日志管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (26, '/system/hr/**', '/sys/hr', 'SysHr', '操作员管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (27, '/system/data/**', '/sys/data', 'SysData', '备份恢复数据库', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (28, '/system/init/**', '/sys/init', 'SysInit', '初始化数据库', NULL, NULL, 1, 6, 1);

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role`  (
                              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
                              `mid` int(11) NULL DEFAULT NULL COMMENT '菜单id',
                              `rid` int(11) NULL DEFAULT NULL COMMENT '角色id',
                              PRIMARY KEY (`id`) USING BTREE,
                              INDEX `mid`(`mid`) USING BTREE,
                              INDEX `rid`(`rid`) USING BTREE,
                              CONSTRAINT `menu_role_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                              CONSTRAINT `menu_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 290 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES (161, 7, 3);
INSERT INTO `menu_role` VALUES (162, 7, 6);
INSERT INTO `menu_role` VALUES (163, 9, 6);
INSERT INTO `menu_role` VALUES (164, 10, 6);
INSERT INTO `menu_role` VALUES (165, 11, 6);
INSERT INTO `menu_role` VALUES (166, 12, 6);
INSERT INTO `menu_role` VALUES (167, 13, 6);
INSERT INTO `menu_role` VALUES (168, 14, 6);
INSERT INTO `menu_role` VALUES (169, 15, 6);
INSERT INTO `menu_role` VALUES (170, 16, 6);
INSERT INTO `menu_role` VALUES (171, 17, 6);
INSERT INTO `menu_role` VALUES (172, 18, 6);
INSERT INTO `menu_role` VALUES (173, 19, 6);
INSERT INTO `menu_role` VALUES (174, 20, 6);
INSERT INTO `menu_role` VALUES (175, 21, 6);
INSERT INTO `menu_role` VALUES (176, 22, 6);
INSERT INTO `menu_role` VALUES (177, 23, 6);
INSERT INTO `menu_role` VALUES (178, 25, 6);
INSERT INTO `menu_role` VALUES (179, 26, 6);
INSERT INTO `menu_role` VALUES (180, 27, 6);
INSERT INTO `menu_role` VALUES (181, 28, 6);
INSERT INTO `menu_role` VALUES (182, 24, 6);
INSERT INTO `menu_role` VALUES (247, 7, 4);
INSERT INTO `menu_role` VALUES (248, 8, 4);
INSERT INTO `menu_role` VALUES (249, 11, 4);
INSERT INTO `menu_role` VALUES (250, 7, 2);
INSERT INTO `menu_role` VALUES (251, 8, 2);
INSERT INTO `menu_role` VALUES (252, 9, 2);
INSERT INTO `menu_role` VALUES (253, 10, 2);
INSERT INTO `menu_role` VALUES (254, 12, 2);
INSERT INTO `menu_role` VALUES (255, 13, 2);
INSERT INTO `menu_role` VALUES (256, 7, 1);
INSERT INTO `menu_role` VALUES (257, 8, 1);
INSERT INTO `menu_role` VALUES (258, 9, 1);
INSERT INTO `menu_role` VALUES (259, 10, 1);
INSERT INTO `menu_role` VALUES (260, 11, 1);
INSERT INTO `menu_role` VALUES (261, 12, 1);
INSERT INTO `menu_role` VALUES (262, 13, 1);
INSERT INTO `menu_role` VALUES (263, 14, 1);
INSERT INTO `menu_role` VALUES (264, 15, 1);
INSERT INTO `menu_role` VALUES (265, 16, 1);
INSERT INTO `menu_role` VALUES (266, 17, 1);
INSERT INTO `menu_role` VALUES (267, 18, 1);
INSERT INTO `menu_role` VALUES (268, 19, 1);
INSERT INTO `menu_role` VALUES (269, 20, 1);
INSERT INTO `menu_role` VALUES (270, 21, 1);
INSERT INTO `menu_role` VALUES (271, 22, 1);
INSERT INTO `menu_role` VALUES (272, 23, 1);
INSERT INTO `menu_role` VALUES (273, 24, 1);
INSERT INTO `menu_role` VALUES (274, 25, 1);
INSERT INTO `menu_role` VALUES (275, 26, 1);
INSERT INTO `menu_role` VALUES (276, 27, 1);
INSERT INTO `menu_role` VALUES (277, 28, 1);
INSERT INTO `menu_role` VALUES (280, 7, 14);
INSERT INTO `menu_role` VALUES (281, 8, 14);
INSERT INTO `menu_role` VALUES (282, 9, 14);

-- ----------------------------
-- Table structure for msgcontent
-- ----------------------------
DROP TABLE IF EXISTS `msgcontent`;
CREATE TABLE `msgcontent`  (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                               `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                               `createDate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for nation
-- ----------------------------
DROP TABLE IF EXISTS `nation`;
CREATE TABLE `nation`  (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oplog
-- ----------------------------
DROP TABLE IF EXISTS `oplog`;
CREATE TABLE `oplog`  (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `addDate` date NULL DEFAULT NULL COMMENT '添加日期',
                          `operate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作内容',
                          `hrid` int(11) NULL DEFAULT NULL COMMENT '操作员ID',
                          PRIMARY KEY (`id`) USING BTREE,
                          INDEX `hrid`(`hrid`) USING BTREE,
                          CONSTRAINT `oplog_ibfk_1` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for politicsstatus
-- ----------------------------
DROP TABLE IF EXISTS `politicsstatus`;
CREATE TABLE `politicsstatus`  (
                                   `id` int(11) NOT NULL AUTO_INCREMENT,
                                   `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
                             `createDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
                             `enabled` tinyint(1) NULL DEFAULT 1,
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (2, '测试职位1', '2022-04-18 19:02:43', 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `nameZh` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_manager', '部门经理');
INSERT INTO `role` VALUES (2, 'ROLE_personnel', '人事专员');
INSERT INTO `role` VALUES (3, 'ROLE_recruiter', '招聘主管');
INSERT INTO `role` VALUES (4, 'ROLE_train', '培训主管');
INSERT INTO `role` VALUES (5, 'ROLE_performance', '薪酬绩效主管');
INSERT INTO `role` VALUES (6, 'ROLE_admin', '系统管理员');
INSERT INTO `role` VALUES (13, 'ROLE_test2', '测试角色2');
INSERT INTO `role` VALUES (14, 'ROLE_test1', '测试角色1');
INSERT INTO `role` VALUES (17, 'ROLE_test3', '测试角色3');
INSERT INTO `role` VALUES (18, 'ROLE_test4', '测试角色4');

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `basicSalary` int(11) NULL DEFAULT NULL COMMENT '基本工资',
                           `bonus` int(11) NULL DEFAULT NULL COMMENT '奖金',
                           `lunchSalary` int(11) NULL DEFAULT NULL COMMENT '午餐补助',
                           `trafficSalary` int(11) NULL DEFAULT NULL COMMENT '交通补助',
                           `allSalary` int(11) NULL DEFAULT NULL COMMENT '应发工资',
                           `pensionBase` int(11) NULL DEFAULT NULL COMMENT '养老金基数',
                           `pensionPer` float NULL DEFAULT NULL COMMENT '养老金比率',
                           `createDate` timestamp(0) NULL DEFAULT NULL COMMENT '启用时间',
                           `medicalBase` int(11) NULL DEFAULT NULL COMMENT '医疗基数',
                           `medicalPer` float NULL DEFAULT NULL COMMENT '医疗保险比率',
                           `accumulationFundBase` int(11) NULL DEFAULT NULL COMMENT '公积金基数',
                           `accumulationFundPer` float NULL DEFAULT NULL COMMENT '公积金比率',
                           `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sysmsg
-- ----------------------------
DROP TABLE IF EXISTS `sysmsg`;
CREATE TABLE `sysmsg`  (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `mid` int(11) NULL DEFAULT NULL COMMENT '消息id',
                           `type` int(11) NULL DEFAULT 0 COMMENT '0表示群发消息',
                           `hrid` int(11) NULL DEFAULT NULL COMMENT '这条消息是给谁的',
                           `state` int(11) NULL DEFAULT 0 COMMENT '0 未读 1 已读',
                           PRIMARY KEY (`id`) USING BTREE,
                           INDEX `hrid`(`hrid`) USING BTREE,
                           INDEX `sysmsg_ibfk_1`(`mid`) USING BTREE,
                           CONSTRAINT `sysmsg_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `msgcontent` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                           CONSTRAINT `sysmsg_ibfk_2` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Procedure structure for addDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `addDep`;
delimiter ;;
CREATE PROCEDURE `addDep`(in depName varchar(32),in parentId int,in enabled boolean,out result int,out result2 int)
begin
  declare did int;
  declare pDepPath varchar(64);
insert into department set name=depName,parentId=parentId,enabled=enabled;
select row_count() into result;
select last_insert_id() into did;
set result2=did;
select depPath into pDepPath from department where id=parentId;
update department set depPath=concat(pDepPath,'.',did) where id=did;
update department set isParent=true where id=parentId;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteDep`;
delimiter ;;
CREATE PROCEDURE `deleteDep`(in did int,out result int)
begin
  declare ecount int;
  declare pid int;
  declare pcount int;
  declare a int;
select count(*) into a from department where id=did and isParent=false;
if a=0 then set result=-2;
else
select count(*) into ecount from employee where departmentId=did;
if ecount>0 then set result=-1;
else
select parentId into pid from department where id=did;
delete from department where id=did and isParent=false;
select row_count() into result;
select count(*) into pcount from department where parentId=pid;
if pcount=0 then update department set isParent=false where id=pid;
end if;
end if;
end if;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
