/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : qibu_broker

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2018-04-05 12:06:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for broker_account
-- ----------------------------
DROP TABLE IF EXISTS `broker_account`;
CREATE TABLE `broker_account` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `broker_user` int(11) DEFAULT NULL COMMENT '经纪人ID',
  `bank_no` varchar(50) DEFAULT NULL COMMENT '银行卡号',
  `bank_name` varchar(100) DEFAULT NULL COMMENT '开户行',
  `bank_branch` varchar(100) DEFAULT NULL COMMENT '开户支行',
  `account_balance` decimal(24,2) DEFAULT NULL COMMENT '账户余额',
  `freeze_balance` decimal(24,2) DEFAULT NULL COMMENT '冻结金额',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='经纪人账户';

-- ----------------------------
-- Records of broker_account
-- ----------------------------
INSERT INTO `broker_account` VALUES ('1', '1', null, null, null, '10.00', null);

-- ----------------------------
-- Table structure for broker_activity
-- ----------------------------
DROP TABLE IF EXISTS `broker_activity`;
CREATE TABLE `broker_activity` (
  `broker_user` int(11) DEFAULT NULL COMMENT '经纪人ID',
  `activity_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '活动时间',
  `activity` varchar(100) DEFAULT NULL COMMENT '操作记录'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='经纪人活动日志表';

-- ----------------------------
-- Records of broker_activity
-- ----------------------------

-- ----------------------------
-- Table structure for broker_earning
-- ----------------------------
DROP TABLE IF EXISTS `broker_earning`;
CREATE TABLE `broker_earning` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `broker_user` int(11) DEFAULT NULL COMMENT '经纪人ID',
  `earning_amount` decimal(24,2) DEFAULT NULL COMMENT '收益金额',
  `earning_source` varchar(100) DEFAULT NULL COMMENT '收益来源',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态(0=待收;1=已收)',
  `source_id` int(11) DEFAULT NULL COMMENT '来源ID',
  `source_type` tinyint(1) DEFAULT NULL COMMENT '来源种类(0=登记客户;1=邀请好友;2=红包)',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='经纪人待收收益';

-- ----------------------------
-- Records of broker_earning
-- ----------------------------
INSERT INTO `broker_earning` VALUES ('1', '1', '1000.00', '登记客户洽谈成功', '0', '1', '0');

-- ----------------------------
-- Table structure for broker_user
-- ----------------------------
DROP TABLE IF EXISTS `broker_user`;
CREATE TABLE `broker_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `broker_no` varchar(10) DEFAULT NULL COMMENT '经济人编号',
  `broker_name` varchar(50) DEFAULT NULL COMMENT '经济人姓名',
  `broker_phone` varchar(15) DEFAULT NULL COMMENT '经济人手机',
  `broker_sex` tinyint(1) DEFAULT '-1' COMMENT '经济人性别(-1:没填写;0=女;1=男)',
  `broker_idCard` varchar(18) DEFAULT NULL COMMENT '经济人身份证号',
  `broker_address` varchar(250) DEFAULT NULL COMMENT '现住址',
  `home_address` varchar(250) DEFAULT NULL COMMENT '家庭住址',
  `broker_qq` varchar(45) DEFAULT NULL COMMENT '经济人QQ',
  `broker_weixin` varchar(45) DEFAULT NULL COMMENT '经济人微信',
  `broker_weibo` varchar(45) DEFAULT NULL COMMENT '经济人微博号',
  `broker_img` varchar(45) DEFAULT NULL COMMENT '经济人头像',
  `other_tel` varchar(45) DEFAULT NULL COMMENT '其他联系电话',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `user_code` varchar(20) DEFAULT NULL COMMENT '认证码',
  `open_id` varchar(50) DEFAULT NULL COMMENT '微信openid',
  PRIMARY KEY (`uid`),
  KEY `user_no_UNIQUE` (`broker_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of broker_user
-- ----------------------------
INSERT INTO `broker_user` VALUES ('1', '1', '测试', '13386536846', '1', '422822', '萧山', null, '', null, '', null, null, '2018-03-28 22:38:13', null, '1521550394685', 'oXf770Dyx-84ZitlYDgZoErTq9J4');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `customer_phone` varchar(15) DEFAULT NULL COMMENT '客户电话',
  `customer_name` varchar(50) DEFAULT NULL COMMENT '客户姓名',
  `address` varchar(250) DEFAULT NULL COMMENT '客户住址',
  `broker_user` int(11) DEFAULT NULL COMMENT '录入经纪人',
  `status` tinyint(1) DEFAULT NULL COMMENT '装修意向(0=咨询;1=马上会装修;2=已装修;3=不装修了)',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(250) DEFAULT NULL COMMENT '备注',
  `province` varchar(50) DEFAULT NULL COMMENT '省',
  `city` varchar(50) DEFAULT NULL COMMENT '市',
  `district` varchar(50) DEFAULT NULL COMMENT '区',
  `address_detail` varchar(250) DEFAULT NULL COMMENT '全地址',
  `audit` tinyint(1) DEFAULT '0' COMMENT '审计(0=待审核;1=装修中;2=装修完工;3=洽谈失败)',
  `audit_remarks` varchar(255) DEFAULT NULL COMMENT '审计备注',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='装修客户表';

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '13386536846', '测试', '萧山区', '1', '0', '2018-03-30 21:30:26', '2018-03-30 21:30:26', null, '点下行不行', '浙江省', '杭州市', '萧山区', '浙江省杭州市萧山区', '1', null);

-- ----------------------------
-- Table structure for invite_friend
-- ----------------------------
DROP TABLE IF EXISTS `invite_friend`;
CREATE TABLE `invite_friend` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `broker_user` int(11) DEFAULT NULL COMMENT '经纪人ID',
  `friend_phone` varchar(15) DEFAULT NULL COMMENT '好友手机号',
  `friend_id` int(11) DEFAULT NULL COMMENT '来源',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友邀请';

-- ----------------------------
-- Records of invite_friend
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `role_no` varchar(10) DEFAULT NULL COMMENT '角色编号',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `is_del` tinyint(1) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `user_no` varchar(20) DEFAULT NULL COMMENT '工号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `user_idCard` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `user_phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `user_address` varchar(250) DEFAULT NULL COMMENT '现住址',
  `home_address` varchar(250) DEFAULT NULL COMMENT '家庭住址',
  `user_sex` tinyint(1) DEFAULT '-1' COMMENT '性别(-1:未填写;0=男;1=女)',
  `user_birthday` datetime DEFAULT NULL COMMENT '生日',
  `user_school` varchar(250) DEFAULT NULL COMMENT '毕业院校',
  `user_education` varchar(20) DEFAULT NULL COMMENT '学历',
  `user_strong` varchar(250) DEFAULT NULL COMMENT '特长',
  `entry_date` datetime DEFAULT NULL COMMENT '入职日期',
  `dimission_date` datetime DEFAULT NULL COMMENT '离职日期',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态(0:在职;1=离职;2=停薪留职)',
  `remarks` varchar(250) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1000', 'admin', '1', '13386536846', null, null, '1', '2018-03-27 20:04:23', null, null, null, null, null, '0', null, '2018-03-27 20:04:14', null, null, null, '96e79218965eb72c92a549dd5a330112');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_no` varchar(10) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Table structure for wx_user
-- ----------------------------
DROP TABLE IF EXISTS `wx_user`;
CREATE TABLE `wx_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `wx_openId` varchar(50) DEFAULT NULL COMMENT '微信openid',
  `wx_nickName` varchar(250) DEFAULT NULL COMMENT '微信昵称',
  `wx_country` varchar(50) DEFAULT NULL COMMENT '所在国家',
  `wx_province` varchar(50) DEFAULT NULL COMMENT '所在省',
  `wx_city` varchar(50) DEFAULT NULL COMMENT '所在城市',
  `wx_avatarUrl` varchar(250) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='微信用户';

-- ----------------------------
-- Records of wx_user
-- ----------------------------
INSERT INTO `wx_user` VALUES ('3', 'oXf770Dyx-84ZitlYDgZoErTq9J4', '①え⑨も⑤', 'China', 'Zhejiang', 'Hangzhou', 'https://wx.qlogo.cn/mmopen/vi_32/ibuDpCPe1SmX87om4DFnibFoQiaR8nhkohFZia4pIvk7ZRw9icTRwf2NMpH44ZKBjoTmuGs78FOt0sO3C2hqxF6dsPw/0');
