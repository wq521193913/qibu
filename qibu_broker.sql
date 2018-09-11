/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.57
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 192.168.0.57:3306
 Source Schema         : qibu_broker

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 11/09/2018 15:04:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for broker_account
-- ----------------------------
DROP TABLE IF EXISTS `broker_account`;
CREATE TABLE `broker_account`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `broker_user` int(11) NULL DEFAULT NULL COMMENT '经纪人ID',
  `bank_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号',
  `bank_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户行',
  `bank_branch` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户支行',
  `account_balance` decimal(24, 2) NULL DEFAULT NULL COMMENT '账户余额',
  `freeze_balance` decimal(24, 2) NULL DEFAULT NULL COMMENT '冻结金额',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '经纪人账户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of broker_account
-- ----------------------------
INSERT INTO `broker_account` VALUES (1, 1, NULL, NULL, NULL, 3010.00, NULL);

-- ----------------------------
-- Table structure for broker_account_detail
-- ----------------------------
DROP TABLE IF EXISTS `broker_account_detail`;
CREATE TABLE `broker_account_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `detail_type` tinyint(1) NULL DEFAULT 0 COMMENT '类别(0=收益;1=充值;2=提现)',
  `amount` decimal(24, 2) NULL DEFAULT 0.00 COMMENT '金额',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `remarks` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '账户明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for broker_activity
-- ----------------------------
DROP TABLE IF EXISTS `broker_activity`;
CREATE TABLE `broker_activity`  (
  `broker_user` int(11) NULL DEFAULT NULL COMMENT '经纪人ID',
  `activity_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '活动时间',
  `activity` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作记录'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '经纪人活动日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for broker_bribe
-- ----------------------------
DROP TABLE IF EXISTS `broker_bribe`;
CREATE TABLE `broker_bribe`  (
  `uid` int(11) NULL DEFAULT NULL,
  `broker_user` int(11) NULL DEFAULT NULL COMMENT '经纪人ID',
  `bribe_id` int(11) NULL DEFAULT NULL COMMENT '红包ID',
  `bribe_amount` decimal(24, 2) NULL DEFAULT NULL COMMENT '红包金额'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'bribe' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for broker_earning
-- ----------------------------
DROP TABLE IF EXISTS `broker_earning`;
CREATE TABLE `broker_earning`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `broker_user` int(11) NULL DEFAULT NULL COMMENT '经纪人ID',
  `earning_amount` decimal(24, 2) NULL DEFAULT NULL COMMENT '收益金额',
  `earning_source` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收益来源',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态(0=待收;1=已收;2=失效)',
  `source_id` int(11) NULL DEFAULT NULL COMMENT '来源ID(客户ID/好友ID/红包ID)',
  `source_type` tinyint(1) NULL DEFAULT NULL COMMENT '来源种类(0=登记客户;1=邀请好友;2=红包)',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '经纪人待收收益' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of broker_earning
-- ----------------------------
INSERT INTO `broker_earning` VALUES (3, 1, 1000.00, '登记的客户洽谈成功', 0, 1, 0);
INSERT INTO `broker_earning` VALUES (4, 1, 1000.00, '客户es,装修完成.获得佣金1000.00元', 1, 2, 0);

-- ----------------------------
-- Table structure for broker_user
-- ----------------------------
DROP TABLE IF EXISTS `broker_user`;
CREATE TABLE `broker_user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `broker_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经济人编号',
  `broker_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经济人姓名',
  `broker_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经济人手机',
  `broker_sex` tinyint(1) NULL DEFAULT -1 COMMENT '经济人性别(-1:没填写;0=女;1=男)',
  `broker_idCard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经济人身份证号',
  `broker_address` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现住址',
  `home_address` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `broker_qq` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经济人QQ',
  `broker_weixin` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经济人微信',
  `broker_weibo` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经济人微博号',
  `broker_img` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经济人头像',
  `other_tel` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他联系电话',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `user_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '认证码',
  `open_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信openid',
  `is_del` tinyint(1) NULL DEFAULT NULL COMMENT '删除(0=未删除;1=已删除)',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机种类(ios/android)',
  PRIMARY KEY (`uid`) USING BTREE,
  INDEX `user_no_UNIQUE`(`broker_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of broker_user
-- ----------------------------
INSERT INTO `broker_user` VALUES (1, '1', '测试', '13386536846', 0, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-03-29 10:39:51', NULL, '1111', 'oXf770Dyx-84ZitlYDgZoErTq9J4', NULL, NULL, NULL);
INSERT INTO `broker_user` VALUES (2, '2', '测试', '13386536841', 1, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-03-29 10:39:52', NULL, '1111', 'oXf770Dyx-84ZitlYDgZoErTq9J1', NULL, NULL, NULL);
INSERT INTO `broker_user` VALUES (3, '3', '测试', '13386536842', 1, '3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-03-29 10:39:55', NULL, '1111', 'oXf770Dyx-84ZitlYDgZoErTq9J1', NULL, NULL, NULL);
INSERT INTO `broker_user` VALUES (4, '4', '测试', '13386536843', 1, '4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-03-29 10:39:55', NULL, '1111', 'oXf770Dyx-84ZitlYDgZoErTq9J1', NULL, NULL, NULL);
INSERT INTO `broker_user` VALUES (5, '5', '测试', '13386536844', 1, '5', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-03-29 10:39:57', NULL, '1111', 'oXf770Dyx-84ZitlYDgZoErTq9J1', NULL, NULL, NULL);
INSERT INTO `broker_user` VALUES (6, '6', '测试', '13386536845', 0, '6', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-03-29 10:39:58', NULL, '1111', 'oXf770Dyx-84ZitlYDgZoErTq9J1', NULL, NULL, NULL);
INSERT INTO `broker_user` VALUES (7, '7', '测试', '13386536847', 0, '7', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-03-29 10:39:59', NULL, '1111', 'oXf770Dyx-84ZitlYDgZoErTq9J1', NULL, NULL, NULL);
INSERT INTO `broker_user` VALUES (8, '8', '测试', '13386536848', 1, '8', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-03-29 10:40:00', NULL, '1111', 'oXf770Dyx-84ZitlYDgZoErTq9J1', NULL, NULL, NULL);
INSERT INTO `broker_user` VALUES (9, '9', '测试', '13386536849', -1, '9', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-03-29 10:39:11', NULL, '1111', 'oXf770Dyx-84ZitlYDgZoErTq9J1', NULL, NULL, NULL);
INSERT INTO `broker_user` VALUES (10, '10', '测试', '13386536850', -1, '10', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-03-29 10:39:12', NULL, '1111', 'oXf770Dyx-84ZitlYDgZoErTq9J1', NULL, NULL, NULL);
INSERT INTO `broker_user` VALUES (11, '11', '测试', '13386536851', -1, '11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-03-29 10:39:14', NULL, '1111', 'oXf770Dyx-84ZitlYDgZoErTq9J1', NULL, NULL, NULL);
INSERT INTO `broker_user` VALUES (12, '12', '测试', '13386536851', -1, '12', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-03-29 10:39:17', NULL, '1111', 'oXf770Dyx-84ZitlYDgZoErTq9J1', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for case_show
-- ----------------------------
DROP TABLE IF EXISTS `case_show`;
CREATE TABLE `case_show`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `case_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '案例标题',
  `case_img` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `case_desc` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` int(11) NULL DEFAULT NULL COMMENT '修改人',
  `case_style` tinyint(1) NULL DEFAULT NULL COMMENT '风格',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '装修案例' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of case_show
-- ----------------------------
INSERT INTO `case_show` VALUES (9, '1', 'group1/M00/00/00/rBB-5lrPC-mAfUjbAABosWWheqc251.jpg', '3', NULL, NULL, NULL, NULL, 2);
INSERT INTO `case_show` VALUES (10, '1', 'group1/M00/00/00/rBB-5lrPFzuALez8AABosWWheqc622.jpg', '3', NULL, NULL, NULL, NULL, 2);
INSERT INTO `case_show` VALUES (11, '1', 'group1/M00/00/00/rBB-5lrPFzuALez8AABosWWheqc622.jpg', '3', NULL, NULL, NULL, NULL, 2);

-- ----------------------------
-- Table structure for case_sketch
-- ----------------------------
DROP TABLE IF EXISTS `case_sketch`;
CREATE TABLE `case_sketch`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `case_id` int(11) NULL DEFAULT NULL COMMENT '案例ID',
  `img_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '案例效果图' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of case_sketch
-- ----------------------------
INSERT INTO `case_sketch` VALUES (3, 9, 'group1/M00/00/00/rBB-5lrPC-uAN2GaAABosWWheqc970.jpg');
INSERT INTO `case_sketch` VALUES (4, 10, 'group1/M00/00/00/rBB-5lrPFz2AHaOSAAFR_groAwQ433.jpg');
INSERT INTO `case_sketch` VALUES (5, 11, 'group1/M00/00/00/rBB-5lrPFz2AHaOSAAFR_groAwQ433.jpg');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `customer_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户电话',
  `customer_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `address` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细住址',
  `broker_user` int(11) NULL DEFAULT NULL COMMENT '录入经纪人',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '装修意向(0=咨询;1=马上会装修;2=已装修;3=不装修了)',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` int(11) NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `province` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `district` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区',
  `address_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '全住址',
  `audit` tinyint(1) NULL DEFAULT 0 COMMENT '审计(0=待审核;1=装修中;2=装修完工;3=洽谈失败)',
  `audit_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审计备注',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '装修客户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '13386536846', '测试', '英飞特大象', 1, 0, '2018-03-30 15:37:34', '2018-03-30 15:37:34', NULL, '让我测试下会不会死,嗯?', '浙江', '杭州', '滨江', '浙江省杭州市滨江区英飞特大象', 1, NULL);
INSERT INTO `customer` VALUES (2, '13386536841', 'es', '英飞特大象飞虹路11111111111111111111111111111111111111111号', 1, NULL, '2018-06-05 15:11:27', '2018-05-23 19:44:01', NULL, 'fggg', '浙江省', '杭州市', '滨江区', '浙江省杭州市滨江区ffffff', 2, NULL);
INSERT INTO `customer` VALUES (3, '13386536842', '1111', '英飞特大象飞虹路2222号', 1, NULL, '2018-06-05 15:11:35', NULL, NULL, '1', '浙江省', '杭州市', '滨江区', '浙江省杭州市滨江区111', NULL, NULL);

-- ----------------------------
-- Table structure for invite_friend
-- ----------------------------
DROP TABLE IF EXISTS `invite_friend`;
CREATE TABLE `invite_friend`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `broker_user` int(11) NULL DEFAULT NULL COMMENT '经纪人ID',
  `friend_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '好友手机号',
  `friend_id` int(11) NULL DEFAULT NULL COMMENT '好友ID',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '好友邀请' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `role_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编号',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `user_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `user_idCard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `user_address` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现住址',
  `home_address` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `user_sex` tinyint(1) NULL DEFAULT -1 COMMENT '性别(-1:未填写;0=男;1=女)',
  `user_birthday` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `user_school` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业院校',
  `user_education` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `user_strong` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '特长',
  `entry_date` datetime(0) NULL DEFAULT NULL COMMENT '入职日期',
  `dimission_date` datetime(0) NULL DEFAULT NULL COMMENT '离职日期',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态(0:在职;1=离职;2=停薪留职)',
  `remarks` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` int(11) NULL DEFAULT NULL COMMENT '修改人',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '1000', 'admin', '1', '13386536846', '1', NULL, 1, '2018-03-27 13:38:39', NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-03-27 13:34:27', NULL, NULL, NULL, '96e79218965eb72c92a549dd5a330112');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `role_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wx_user
-- ----------------------------
DROP TABLE IF EXISTS `wx_user`;
CREATE TABLE `wx_user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `wx_openId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信openid',
  `wx_nickName` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信昵称',
  `wx_country` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在国家',
  `wx_province` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在省',
  `wx_city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  `wx_avatarUrl` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '微信用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wx_user
-- ----------------------------
INSERT INTO `wx_user` VALUES (1, 'oXf770Dyx-84ZitlYDgZoErTq9J4', '①え⑨も⑤', 'China', 'Zhejiang', 'Hangzhou', NULL);

-- ----------------------------
-- Function structure for getTableColumns
-- ----------------------------
DROP FUNCTION IF EXISTS `getTableColumns`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `getTableColumns`(`tableName` varchar(200)) RETURNS varchar(500) CHARSET utf8
BEGIN
  DECLARE tabColumns varchar(500);
	SELECT GROUP_CONCAT(column_name) into tabColumns from information_schema.`COLUMNS`
	where 1=1  and table_schema='qibu_broker' and table_name=tableName;

	RETURN tabColumns;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
