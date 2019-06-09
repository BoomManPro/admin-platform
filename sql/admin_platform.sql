/*
 Navicat Premium Data Transfer

 Source Server         : BoomMan
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : www.boommanpro.cn:3306
 Source Schema         : platform_sys

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 08/06/2019 18:12:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_no` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_no` int(11) NULL DEFAULT NULL,
  `type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(11) NULL DEFAULT 1,
  `url_no` int(11) NULL DEFAULT NULL,
  `disabled` int(2) NULL DEFAULT 0,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`menu_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '基础管理', 0, 'MODULE', '', 1, 1, 0, '基础模块展示');
INSERT INTO `sys_menu` VALUES (2, '权限配置', 1, 'GROUP', '', 1, NULL, 0, '用户管理页面');
INSERT INTO `sys_menu` VALUES (4, '角色管理', 2, 'PAGE', '', 1, 22, 0, '角色管理');
INSERT INTO `sys_menu` VALUES (5, '学校管理', 0, 'MODULE', '', 2, NULL, 0, '学校管理');
INSERT INTO `sys_menu` VALUES (6, 'Socket', 0, 'MODULE', '', 3, NULL, 0, 'TEST');
INSERT INTO `sys_menu` VALUES (7, 'TEST', 6, 'GROUP', '', 3, NULL, 0, 'TEST');
INSERT INTO `sys_menu` VALUES (8, 'webSocket', 7, 'PAGE', '', 1, 40, 0, 'webSocket');
INSERT INTO `sys_menu` VALUES (9, '学校模块', 5, 'GROUP', '', 1, NULL, 0, '学校模块');
INSERT INTO `sys_menu` VALUES (10, '学校管理', 9, 'PAGE', '', 1, 39, 0, '学校管理');
INSERT INTO `sys_menu` VALUES (11, '资源管理', 2, 'PAGE', '', 1, 6, 0, '资源管理');
INSERT INTO `sys_menu` VALUES (12, '组织机构', 1, 'GROUP', '', 2, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (13, '用户管理', 12, 'PAGE', '', 1, 38, 0, '');
INSERT INTO `sys_menu` VALUES (14, '菜单管理', 2, 'PAGE', '', 1, 14, 0, '');
INSERT INTO `sys_menu` VALUES (15, '电商模块', 0, 'MODULE', '', 1, NULL, 0, '商店模块管理');
INSERT INTO `sys_menu` VALUES (16, '商店介绍', 15, 'GROUP', '', 1, NULL, 1, '');
INSERT INTO `sys_menu` VALUES (17, '商品类别', 15, 'GROUP', '', 1, NULL, 1, '');
INSERT INTO `sys_menu` VALUES (18, '商品管理', 15, 'GROUP', '', 1, NULL, 1, '');
INSERT INTO `sys_menu` VALUES (19, '商店管理', 15, 'GROUP', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (20, '用户相关', 15, 'GROUP', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (21, '其他管理', 15, 'GROUP', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (22, '商店介绍', 19, 'PAGE', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (23, '商品类别', 19, 'PAGE', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (24, '商品管理', 19, 'PAGE', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (25, '用户管理', 20, 'PAGE', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (26, '订单管理', 20, 'PAGE', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (27, '排行榜', 21, 'PAGE', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (28, '首页banner', 21, 'PAGE', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (29, '单品推荐', 21, 'PAGE', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (30, '留言板', 20, 'PAGE', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (31, '优惠券', 21, 'PAGE', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (32, '自如查询', 0, 'MODULE', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (33, '简单查询', 32, 'GROUP', '', 1, 43, 0, '');
INSERT INTO `sys_menu` VALUES (34, '查询', 33, 'PAGE', '', 1, 43, 0, '');
INSERT INTO `sys_menu` VALUES (35, '日志模块', 0, 'MODULE', '', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (36, '日志管理', 35, 'GROUP', '开关管理', 1, NULL, 0, '');
INSERT INTO `sys_menu` VALUES (37, '日志开关', 36, 'PAGE', '', 1, 44, 0, '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_no` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `disabled` int(2) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 0, '拥有一切');
INSERT INTO `sys_role` VALUES (2, 'TEST', 0, '测试角色');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_no` int(11) NOT NULL,
  `menu_no` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 0);
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 4);
INSERT INTO `sys_role_menu` VALUES (2, 11);
INSERT INTO `sys_role_menu` VALUES (2, 14);
INSERT INTO `sys_role_menu` VALUES (2, 12);
INSERT INTO `sys_role_menu` VALUES (2, 13);
INSERT INTO `sys_role_menu` VALUES (2, 5);
INSERT INTO `sys_role_menu` VALUES (2, 9);
INSERT INTO `sys_role_menu` VALUES (2, 10);
INSERT INTO `sys_role_menu` VALUES (2, 6);
INSERT INTO `sys_role_menu` VALUES (2, 7);
INSERT INTO `sys_role_menu` VALUES (2, 8);
INSERT INTO `sys_role_menu` VALUES (1, 0);
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 2);
INSERT INTO `sys_role_menu` VALUES (1, 4);
INSERT INTO `sys_role_menu` VALUES (1, 11);
INSERT INTO `sys_role_menu` VALUES (1, 14);
INSERT INTO `sys_role_menu` VALUES (1, 12);
INSERT INTO `sys_role_menu` VALUES (1, 13);
INSERT INTO `sys_role_menu` VALUES (1, 5);
INSERT INTO `sys_role_menu` VALUES (1, 9);
INSERT INTO `sys_role_menu` VALUES (1, 10);
INSERT INTO `sys_role_menu` VALUES (1, 6);
INSERT INTO `sys_role_menu` VALUES (1, 7);
INSERT INTO `sys_role_menu` VALUES (1, 8);

-- ----------------------------
-- Table structure for sys_role_url
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_url`;
CREATE TABLE `sys_role_url`  (
  `role_no` int(11) NOT NULL,
  `url_no` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_url
-- ----------------------------
INSERT INTO `sys_role_url` VALUES (2, 39);
INSERT INTO `sys_role_url` VALUES (2, 40);
INSERT INTO `sys_role_url` VALUES (2, 22);
INSERT INTO `sys_role_url` VALUES (2, 23);
INSERT INTO `sys_role_url` VALUES (2, 24);
INSERT INTO `sys_role_url` VALUES (2, 25);
INSERT INTO `sys_role_url` VALUES (2, 26);
INSERT INTO `sys_role_url` VALUES (2, 27);
INSERT INTO `sys_role_url` VALUES (2, 28);
INSERT INTO `sys_role_url` VALUES (2, 14);
INSERT INTO `sys_role_url` VALUES (2, 15);
INSERT INTO `sys_role_url` VALUES (2, 16);
INSERT INTO `sys_role_url` VALUES (2, 17);
INSERT INTO `sys_role_url` VALUES (2, 18);
INSERT INTO `sys_role_url` VALUES (2, 19);
INSERT INTO `sys_role_url` VALUES (2, 20);
INSERT INTO `sys_role_url` VALUES (2, 21);
INSERT INTO `sys_role_url` VALUES (2, 38);
INSERT INTO `sys_role_url` VALUES (2, 6);
INSERT INTO `sys_role_url` VALUES (2, 7);
INSERT INTO `sys_role_url` VALUES (2, 8);
INSERT INTO `sys_role_url` VALUES (2, 9);
INSERT INTO `sys_role_url` VALUES (2, 10);
INSERT INTO `sys_role_url` VALUES (2, 11);
INSERT INTO `sys_role_url` VALUES (2, 12);
INSERT INTO `sys_role_url` VALUES (2, 13);
INSERT INTO `sys_role_url` VALUES (2, 1);
INSERT INTO `sys_role_url` VALUES (1, 39);
INSERT INTO `sys_role_url` VALUES (1, 40);
INSERT INTO `sys_role_url` VALUES (1, 22);
INSERT INTO `sys_role_url` VALUES (1, 23);
INSERT INTO `sys_role_url` VALUES (1, 24);
INSERT INTO `sys_role_url` VALUES (1, 25);
INSERT INTO `sys_role_url` VALUES (1, 26);
INSERT INTO `sys_role_url` VALUES (1, 27);
INSERT INTO `sys_role_url` VALUES (1, 28);
INSERT INTO `sys_role_url` VALUES (1, 14);
INSERT INTO `sys_role_url` VALUES (1, 15);
INSERT INTO `sys_role_url` VALUES (1, 16);
INSERT INTO `sys_role_url` VALUES (1, 17);
INSERT INTO `sys_role_url` VALUES (1, 18);
INSERT INTO `sys_role_url` VALUES (1, 19);
INSERT INTO `sys_role_url` VALUES (1, 20);
INSERT INTO `sys_role_url` VALUES (1, 21);
INSERT INTO `sys_role_url` VALUES (1, 38);
INSERT INTO `sys_role_url` VALUES (1, 6);
INSERT INTO `sys_role_url` VALUES (1, 7);
INSERT INTO `sys_role_url` VALUES (1, 8);
INSERT INTO `sys_role_url` VALUES (1, 9);
INSERT INTO `sys_role_url` VALUES (1, 10);
INSERT INTO `sys_role_url` VALUES (1, 11);
INSERT INTO `sys_role_url` VALUES (1, 12);
INSERT INTO `sys_role_url` VALUES (1, 13);
INSERT INTO `sys_role_url` VALUES (1, 1);

-- ----------------------------
-- Table structure for sys_url
-- ----------------------------
DROP TABLE IF EXISTS `sys_url`;
CREATE TABLE `sys_url`  (
  `url_no` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `resource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `module` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `data` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(11) NULL DEFAULT 1,
  `view_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `disabled` int(2) NULL DEFAULT 0,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`url_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_url
-- ----------------------------
INSERT INTO `sys_url` VALUES (1, 'BASE', '', 'BASE', 'BASE_INDEX', 1, 'AJAX', 0, '基础页面', 'GET');
INSERT INTO `sys_url` VALUES (6, '路径管理页面', '/sys/UrlManage.html', 'SYS', 'SYS_URL', 1, 'PAGE', 0, '', 'GET');
INSERT INTO `sys_url` VALUES (7, '资源路径树', '/sys/url/listTree', 'SYS', 'SYS_URL', 1, 'AJAX', 0, NULL, 'GET');
INSERT INTO `sys_url` VALUES (8, '角色路径列表', '/sys/url/ofRole', 'SYS', 'SYS_URL', 1, 'AJAX', 0, NULL, 'GET');
INSERT INTO `sys_url` VALUES (9, '所有路径资源', '/sys/url/listAll', 'SYS', 'SYS_URL', 1, 'AJAX', 0, NULL, 'GET');
INSERT INTO `sys_url` VALUES (10, '基础资源树', '/sys/url/listBaseTree', 'SYS', 'SYS_URL', 1, 'AJAX', 0, NULL, 'GET');
INSERT INTO `sys_url` VALUES (11, '增加路径资源', '/sys/url/add', 'SYS', 'SYS_URL', 1, 'AJAX', 0, NULL, 'POST');
INSERT INTO `sys_url` VALUES (12, '删除路径资源', '/sys/url/del', 'SYS', 'SYS_URL', 1, 'AJAX', 0, NULL, 'POST');
INSERT INTO `sys_url` VALUES (13, '修改路径资源', '/sys/url/modify', 'SYS', 'SYS_URL', 1, 'AJAX', 0, NULL, 'POST');
INSERT INTO `sys_url` VALUES (14, '菜单管理页面', '/sys/MenuManage.html', 'SYS', 'SYS_MENU', 1, 'PAGE', 0, '', 'GET');
INSERT INTO `sys_url` VALUES (15, '用户菜单', '/sys/menu/ofUser', 'SYS', 'SYS_MENU', 1, 'AJAX', 0, NULL, 'GET');
INSERT INTO `sys_url` VALUES (16, '菜单列表', '/sys/menu/list', 'SYS', 'SYS_MENU', 1, 'AJAX', 0, NULL, 'GET');
INSERT INTO `sys_url` VALUES (17, '角色菜单列表', '/sys/menu/ofRole', 'SYS', 'SYS_MENU', 1, 'AJAX', 0, NULL, 'GET');
INSERT INTO `sys_url` VALUES (18, '增加菜单', '/sys/menu/add', 'SYS', 'SYS_MENU', 1, 'AJAX', 0, NULL, 'POST');
INSERT INTO `sys_url` VALUES (19, '删除菜单', '/sys/menu/del', 'SYS', 'SYS_MENU', 1, 'AJAX', 0, NULL, 'POST');
INSERT INTO `sys_url` VALUES (20, '修改菜单', '/sys/menu/modify', 'SYS', 'SYS_MENU', 1, 'AJAX', 0, NULL, 'POST');
INSERT INTO `sys_url` VALUES (21, '设置菜单顺序', '/sys/menu/setSort', 'SYS', 'SYS_MENU', 1, 'AJAX', 0, NULL, 'POST');
INSERT INTO `sys_url` VALUES (22, '角色管理页面', '/sys/RoleManage.html', 'SYS', 'SYS_ROLE', 1, 'PAGE', 0, '', 'GET');
INSERT INTO `sys_url` VALUES (23, '角色列表', '/sys/role/list', 'SYS', 'SYS_ROLE', 1, 'AJAX', 0, NULL, 'GET');
INSERT INTO `sys_url` VALUES (24, '增加角色', '/sys/role/add', 'SYS', 'SYS_ROLE', 1, 'AJAX', 0, NULL, 'POST');
INSERT INTO `sys_url` VALUES (25, '删除角色', '/sys/role/del', 'SYS', 'SYS_ROLE', 1, 'AJAX', 0, NULL, 'POST');
INSERT INTO `sys_url` VALUES (26, '修改角色', '/sys/role/modify', 'SYS', 'SYS_ROLE', 1, 'AJAX', 0, NULL, 'POST');
INSERT INTO `sys_url` VALUES (27, '角色路径映射', '/sys/role/url/map', 'SYS', 'SYS_ROLE', 1, 'AJAX', 0, NULL, 'POST');
INSERT INTO `sys_url` VALUES (28, '角色菜单映射', '/sys/role/menu/map', 'SYS', 'SYS_ROLE', 1, 'AJAX', 0, NULL, 'POST');
INSERT INTO `sys_url` VALUES (38, '用户管理页面', '/sys/UserManage.html', 'SYS', 'SYS_USER', 1, 'PAGE', 0, '', 'GET');
INSERT INTO `sys_url` VALUES (39, '学校管理页面', '/school/SchoolManage.html', 'SCHOOL', 'SCHOOL_MANAGE', 1, 'PAGE', 0, '', 'GET');
INSERT INTO `sys_url` VALUES (40, 'socket', '/socket/webSocket.html', 'TEST', 'TEST_RESOURCE', 1, 'PAGE', 0, '', 'GET');
INSERT INTO `sys_url` VALUES (41, 'BoomMan', '', 'BoomMan', 'BoomMan_Home', 1, 'AJAX', 1, '', 'GET');
INSERT INTO `sys_url` VALUES (42, 'HelloWorld', '', 'BoomMan', 'BoomMan_Home', 1, 'AJAX', 1, '', 'GET');
INSERT INTO `sys_url` VALUES (43, '自如', '/ziRoom/simpleSearch.html', 'ZiROOM', 'SEARCH', 1, 'PAGE', 0, '', 'GET');
INSERT INTO `sys_url` VALUES (44, '日志开关', '/sys/logSwitchManage.html', 'SYS', 'LOG_CONFIG', 1, 'PAGE', 0, '日志开关', 'GET');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_no` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `disabled` int(2) NULL DEFAULT NULL,
  `deleted` int(2) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `last_login_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '15735105106', 'Boomman', '15735105106', '15735105106@139.com', 0, 0, '2018-05-03 09:40:16', '2018-05-03 09:40:16', NULL);
INSERT INTO `sys_user` VALUES (2, 'HelloWorld', 'HelloWorld', '15735105106', '592323211@qq.com', 0, 0, '2018-05-03 10:20:32', '2018-05-03 10:20:32', NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_no` int(11) NOT NULL,
  `role_no` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (2, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (1, 2);


