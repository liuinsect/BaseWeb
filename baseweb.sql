/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : baseweb

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2014-10-09 09:54:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_article`
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` int(32) NOT NULL auto_increment,
  `title` varchar(50) NOT NULL,
  `content` longtext NOT NULL,
  `click_num` int(11) unsigned zerofill default NULL,
  `author` varchar(20) default NULL,
  `create_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `module_id` int(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('1', 'asdfasdf', 'asdfasdfsdaf', null, '管理员', '2014-10-04 22:46:55', '1');
INSERT INTO `t_article` VALUES ('2', 'asdfsadfdsa', 'fasdfsadfsdafsdaf', null, '管理员', '2014-10-04 22:49:30', '1');
INSERT INTO `t_article` VALUES ('3', 'fasdfsdf', 'asdfsdafsadfadsfsdfsdfsdfsdf', null, '管理员', '2014-10-04 22:52:33', '4');
INSERT INTO `t_article` VALUES ('5', 'fasdfasdfsadf', 'asdfasdfsadfdasfsdfadsf', null, '管理员', '2014-10-05 11:15:11', '1');
INSERT INTO `t_article` VALUES ('6', 'asdfasdfsa', 'dfsadfsdafsdfsdfsd', null, '管理员', '2014-10-05 11:16:53', '1');
INSERT INTO `t_article` VALUES ('7', 'sdfsadfasdf', 'asdfsadfasdfasdfs', null, '管理员', '2014-10-05 11:21:10', '1');
INSERT INTO `t_article` VALUES ('8', '测试', '<p>测试<img src=\"/attached/image/20141005/20141005122559_580.jpg\" data-ke-src=\"/attached/image/20141005/20141005122559_580.jpg\" alt=\"\">、</p><p>、、撒旦发生的发生的顶顶顶顶</p>', null, '管理员', '2014-10-05 12:26:08', '2');
INSERT INTO `t_article` VALUES ('10', 'asdfsd ', '范德萨发撒旦法', null, '管理员', '2014-10-05 13:24:13', '1');
INSERT INTO `t_article` VALUES ('11', 'sdfasdf ', 'sadfasdfasdf <br>', null, '管理员', '2014-10-05 13:24:18', '1');
INSERT INTO `t_article` VALUES ('12', 'fasdfasdf', 'asdfasdfsadfsdafsdfdsf', null, '管理员', '2014-10-05 13:24:23', '1');
INSERT INTO `t_article` VALUES ('17', 'asdfa ', 'saf sdf sdf <br>', null, '管理2', '2014-10-07 17:08:13', '1');
INSERT INTO `t_article` VALUES ('18', 'asdfa ', 'sdfsd fsd', null, '管理员', '2014-10-04 22:46:55', '1');
INSERT INTO `t_article` VALUES ('19', 'sdfsadf ', 'sdfsadf ', null, '管理员', '2014-10-07 22:03:15', '1');
INSERT INTO `t_article` VALUES ('20', 'sdfasdfasdf ', 'asfasfadsf safasdfasd <br>', null, '管理2', '2014-10-07 22:26:25', '1');
INSERT INTO `t_article` VALUES ('21', '装修指南', '装修指南装修指南装修指南装修指南装修指南', null, '管理2', '2014-10-07 22:30:32', '3');

-- ----------------------------
-- Table structure for `t_decorate_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_decorate_info`;
CREATE TABLE `t_decorate_info` (
  `id` int(32) NOT NULL auto_increment,
  `title` varchar(50) NOT NULL,
  `content` longtext NOT NULL,
  `author` varchar(20) default NULL,
  `author_id` int(11) default NULL,
  `create_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `user_id` int(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_decorate_info
-- ----------------------------
INSERT INTO `t_decorate_info` VALUES ('3', '士大夫', '撒旦法阿斯蒂芬222', '张三', '8', '2014-10-06 18:26:45', '9');
INSERT INTO `t_decorate_info` VALUES ('4', '按时发地方 ', '<p><img src=\"/attached/image/20141006/20141006203949_982.jpg\" data-ke-src=\"/attached/image/20141006/20141006203949_982.jpg\" alt=\"\">四大地方 撒旦法</p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p>第二阶段阿斯蒂芬阿道夫啊法萨芬</p><p><img src=\"/attached/image/20141006/20141006204007_136.jpg\" data-ke-src=\"/attached/image/20141006/20141006204007_136.jpg\" alt=\"\"></p>', '张三', '8', '2014-10-06 20:40:19', '9');
INSERT INTO `t_decorate_info` VALUES ('6', '李四2的发 ', '发生大发顺丰阿斯顿', '张三2', '10', '2014-10-06 19:00:32', '9');
INSERT INTO `t_decorate_info` VALUES ('7', '李四撒旦法', '敌法是飞洒地方士大夫算法', '张三2', '10', '2014-10-06 19:00:22', '9');

-- ----------------------------
-- Table structure for `t_module`
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(32) default NULL,
  `mark` varchar(32) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_module
-- ----------------------------
INSERT INTO `t_module` VALUES ('1', '新闻中心', 'newsCenter');
INSERT INTO `t_module` VALUES ('2', '装修的金融', 'finance');
INSERT INTO `t_module` VALUES ('3', '装修指南', 'guide');
INSERT INTO `t_module` VALUES ('4', '成功案例', 'case');
INSERT INTO `t_module` VALUES ('5', '金凌峰团队介绍', 'team');

-- ----------------------------
-- Table structure for `t_privilegeofrole`
-- ----------------------------
DROP TABLE IF EXISTS `t_privilegeofrole`;
CREATE TABLE `t_privilegeofrole` (
  `id` int(11) NOT NULL auto_increment,
  `role_id` int(11) default NULL,
  `module_id` int(11) default NULL,
  `can_add` tinyint(4) default NULL,
  `can_modify` tinyint(4) default NULL,
  `can_delete` tinyint(4) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_privilegeofrole
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(32) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员');
INSERT INTO `t_role` VALUES ('2', '施工人员');
INSERT INTO `t_role` VALUES ('3', '业主');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(20) NOT NULL auto_increment COMMENT '用户ID',
  `user_name` varchar(20) default NULL COMMENT '用户名称',
  `account` varchar(20) default NULL COMMENT '账号',
  `password` varchar(10) default NULL COMMENT '密码',
  `role_id` int(11) default NULL,
  PRIMARY KEY  (`user_id`),
  KEY `AK_Identifier_2` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '管理2', 'admin', '1', '1');
INSERT INTO `t_user` VALUES ('6', '444', '4444', '1', '2');
INSERT INTO `t_user` VALUES ('7', '123', '123', '123', '2');
INSERT INTO `t_user` VALUES ('8', '张三', 'zhangsan', '123', '2');
INSERT INTO `t_user` VALUES ('9', '李四', 'lisi', '123', '3');
INSERT INTO `t_user` VALUES ('10', '张三2', 'zhangsan2', '123', '2');
INSERT INTO `t_user` VALUES ('11', '李四2', 'lisi2', '123', '3');
