/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : friday

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2014-05-22 10:30:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `customerinfo`
-- ----------------------------
DROP TABLE IF EXISTS `customerinfo`;
CREATE TABLE `customerinfo` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `c_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户姓名',
  `c_phone` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '联系电话',
  `c_address` varchar(150) CHARACTER SET utf8 DEFAULT NULL COMMENT '地址',
  `c_note` varchar(150) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customerinfo
-- ----------------------------
INSERT INTO `customerinfo` VALUES ('1', '张小龙', '1234', '腾讯', '请支持微信');
INSERT INTO `customerinfo` VALUES ('2', '马化腾', '9090', '深圳', '');

-- ----------------------------
-- Table structure for `employees`
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `e_id` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '员工编号',
  `e_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '姓名',
  `e_sex` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别',
  `e_phone` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '联系电话',
  `e_address` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '地址',
  `e_date` datetime DEFAULT NULL COMMENT '出生日期',
  `e_price` float DEFAULT NULL COMMENT '工资',
  `e_bz` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('7c401d18-eddf-479f-af15-37b56c4a48bf', '刁月华', '男', '151', '北京', '2014-12-01 00:00:00', '100000000000', 'ceo');

-- ----------------------------
-- Table structure for `goodsback`
-- ----------------------------
DROP TABLE IF EXISTS `goodsback`;
CREATE TABLE `goodsback` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '退货单编号',
  `g_date` datetime DEFAULT NULL COMMENT '退货时间',
  `u_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理员编号',
  `g_price` float DEFAULT NULL COMMENT '合计金额',
  `g_backPrice` float DEFAULT NULL COMMENT '返回金额',
  `g_bz` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of goodsback
-- ----------------------------
INSERT INTO `goodsback` VALUES ('1', '2014-05-05 00:00:00', 'admin', null, null, '有虫子');
INSERT INTO `goodsback` VALUES ('2', '2014-05-17 00:00:00', 'admin', null, null, 'ddd');

-- ----------------------------
-- Table structure for `goodsbackdetails`
-- ----------------------------
DROP TABLE IF EXISTS `goodsbackdetails`;
CREATE TABLE `goodsbackdetails` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '退货详单编号',
  `goodsBack_id` int(11) DEFAULT NULL COMMENT '退货单编号',
  `p_id` int(11) DEFAULT NULL COMMENT '产品编号',
  `g_num` int(11) DEFAULT NULL COMMENT '退货数量',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of goodsbackdetails
-- ----------------------------
INSERT INTO `goodsbackdetails` VALUES ('1', '1', '1', '10');
INSERT INTO `goodsbackdetails` VALUES ('2', '1', '3', '20');
INSERT INTO `goodsbackdetails` VALUES ('3', '2', '1', '1');

-- ----------------------------
-- Table structure for `instock`
-- ----------------------------
DROP TABLE IF EXISTS `instock`;
CREATE TABLE `instock` (
  `i_id` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '入库单编号',
  `u_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理员编号',
  `o_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '订单编号',
  `i_date` datetime DEFAULT NULL COMMENT '入库时间',
  PRIMARY KEY (`i_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of instock
-- ----------------------------
INSERT INTO `instock` VALUES ('RK20140517101018440', 'admin', '20140515133414562', '2014-05-17 00:00:00');
INSERT INTO `instock` VALUES ('RK20140517161211154', 'admin', '20140516204814422', '2014-05-17 00:00:00');
INSERT INTO `instock` VALUES ('RK20140518142921314', 'admin', '20140516204818752', '2014-05-18 14:29:21');
INSERT INTO `instock` VALUES ('RK20140519154119051', 'admin', 'DD20140519154040086', '2014-05-19 00:00:00');
INSERT INTO `instock` VALUES ('RK20140519161659333', 'admin', '20140516204822192', '2014-05-19 16:16:59');

-- ----------------------------
-- Table structure for `instockdetails`
-- ----------------------------
DROP TABLE IF EXISTS `instockdetails`;
CREATE TABLE `instockdetails` (
  `i_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '入库详单编号',
  `inStock_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '入库单编号',
  `p_id` int(11) DEFAULT NULL COMMENT '产品编号',
  `i_num` int(11) DEFAULT NULL COMMENT '入库数量',
  PRIMARY KEY (`i_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of instockdetails
-- ----------------------------
INSERT INTO `instockdetails` VALUES ('1', 'RK20140517101018440', '1', '1');
INSERT INTO `instockdetails` VALUES ('2', 'RK20140517161211154', '2', '2');
INSERT INTO `instockdetails` VALUES ('3', 'RK20140518142921314', '3', '3');
INSERT INTO `instockdetails` VALUES ('4', 'RK20140519154119051', '1', '1000');
INSERT INTO `instockdetails` VALUES ('5', 'RK20140519154119051', '2', '1000');
INSERT INTO `instockdetails` VALUES ('6', 'RK20140519154119051', '3', '1000');
INSERT INTO `instockdetails` VALUES ('7', 'RK20140519154119051', '4', '1000');
INSERT INTO `instockdetails` VALUES ('8', 'RK20140519154119051', '5', '1000');
INSERT INTO `instockdetails` VALUES ('9', 'RK20140519161659333', '4', '1');

-- ----------------------------
-- Table structure for `logs`
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `l_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志单编号',
  `l_msg` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '日志内容',
  `l_date` datetime DEFAULT NULL COMMENT '日志时间',
  `u_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理员编号',
  PRIMARY KEY (`l_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of logs
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `o_id` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '订单编号',
  `u_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理员编号',
  `o_date` datetime DEFAULT NULL COMMENT '订单时间',
  `o_bz` varchar(150) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `o_style` int(11) DEFAULT NULL COMMENT '订单类型',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('20140515133414562', 'admin', '2014-05-15 13:34:14', 'aaa', '1');
INSERT INTO `orders` VALUES ('20140515133905908', 'admin', '2014-05-15 13:39:05', 'ddd', '-1');
INSERT INTO `orders` VALUES ('20140516204809102', 'admin', '2014-05-16 20:48:09', '', '-1');
INSERT INTO `orders` VALUES ('20140516204814422', 'admin', '2014-05-16 20:48:14', '', '1');
INSERT INTO `orders` VALUES ('20140516204818752', 'admin', '2014-05-16 20:48:18', '', '1');
INSERT INTO `orders` VALUES ('20140516204822192', 'admin', '2014-05-16 20:48:22', '', '1');
INSERT INTO `orders` VALUES ('20140516204825647', 'admin', '2014-05-16 20:48:25', '', '0');
INSERT INTO `orders` VALUES ('20140516204831892', 'admin', '2014-05-16 20:48:31', '', '0');
INSERT INTO `orders` VALUES ('20140516204838588', 'admin', '2014-05-16 20:48:38', '', '0');
INSERT INTO `orders` VALUES ('20140516204852627', 'admin', '2014-05-16 20:48:52', '', '0');
INSERT INTO `orders` VALUES ('20140516204857207', 'admin', '2014-05-16 20:48:57', '', '0');
INSERT INTO `orders` VALUES ('20140516204900923', 'admin', '2014-05-16 20:49:00', '', '0');
INSERT INTO `orders` VALUES ('20140516204904886', 'admin', '2014-05-16 20:49:04', '', '0');
INSERT INTO `orders` VALUES ('DD20140519154040086', 'admin', '2014-05-19 00:00:00', '', '1');
INSERT INTO `orders` VALUES ('DD20140520112501274', 'admin', '2014-05-20 00:00:00', '', '0');

-- ----------------------------
-- Table structure for `ordersdetails`
-- ----------------------------
DROP TABLE IF EXISTS `ordersdetails`;
CREATE TABLE `ordersdetails` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单详单编号',
  `order_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '订单编号',
  `p_id` int(11) DEFAULT NULL COMMENT '产品编号',
  `o_num` int(11) DEFAULT NULL COMMENT '订单数量',
  `o_inNum` int(11) DEFAULT NULL COMMENT '入库数量',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ordersdetails
-- ----------------------------
INSERT INTO `ordersdetails` VALUES ('1', '20140515133414562', '1', '1', null);
INSERT INTO `ordersdetails` VALUES ('2', '20140515133905908', '1', '10', null);
INSERT INTO `ordersdetails` VALUES ('3', '20140515133905908', '3', '20', null);
INSERT INTO `ordersdetails` VALUES ('4', '20140516204809102', '1', '1', null);
INSERT INTO `ordersdetails` VALUES ('5', '20140516204814422', '2', '2', null);
INSERT INTO `ordersdetails` VALUES ('6', '20140516204818752', '3', '3', null);
INSERT INTO `ordersdetails` VALUES ('7', '20140516204822192', '4', '1', null);
INSERT INTO `ordersdetails` VALUES ('8', '20140516204825647', '5', '3', null);
INSERT INTO `ordersdetails` VALUES ('9', '20140516204831892', '1', '1', null);
INSERT INTO `ordersdetails` VALUES ('10', '20140516204831892', '2', '1', null);
INSERT INTO `ordersdetails` VALUES ('11', '20140516204838588', '1', '1', null);
INSERT INTO `ordersdetails` VALUES ('12', '20140516204838588', '2', '1', null);
INSERT INTO `ordersdetails` VALUES ('13', '20140516204838588', '3', '1', null);
INSERT INTO `ordersdetails` VALUES ('14', '20140516204838588', '4', '3', null);
INSERT INTO `ordersdetails` VALUES ('15', '20140516204838588', '5', '2', null);
INSERT INTO `ordersdetails` VALUES ('16', '20140516204852627', '1', '11', null);
INSERT INTO `ordersdetails` VALUES ('17', '20140516204857207', '1', '12', null);
INSERT INTO `ordersdetails` VALUES ('18', '20140516204900923', '2', '12', null);
INSERT INTO `ordersdetails` VALUES ('19', '20140516204904886', '2', '12', null);
INSERT INTO `ordersdetails` VALUES ('20', 'DD20140519154040086', '1', '1000', null);
INSERT INTO `ordersdetails` VALUES ('21', 'DD20140519154040086', '2', '1000', null);
INSERT INTO `ordersdetails` VALUES ('22', 'DD20140519154040086', '3', '1000', null);
INSERT INTO `ordersdetails` VALUES ('23', 'DD20140519154040086', '4', '1000', null);
INSERT INTO `ordersdetails` VALUES ('24', 'DD20140519154040086', '5', '1000', null);
INSERT INTO `ordersdetails` VALUES ('25', 'DD20140520112501274', '1', '1', null);
INSERT INTO `ordersdetails` VALUES ('26', 'DD20140520112501274', '2', '1', null);
INSERT INTO `ordersdetails` VALUES ('27', 'DD20140520112501274', '3', '1', null);
INSERT INTO `ordersdetails` VALUES ('28', 'DD20140520112501274', '4', '1', null);
INSERT INTO `ordersdetails` VALUES ('29', 'DD20140520112501274', '5', '1000', null);

-- ----------------------------
-- Table structure for `outstock`
-- ----------------------------
DROP TABLE IF EXISTS `outstock`;
CREATE TABLE `outstock` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库单编号',
  `s_id` int(11) DEFAULT NULL COMMENT '网点编号',
  `o_date` datetime DEFAULT NULL COMMENT '出库时间',
  `u_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理员编号',
  `o_bz` varchar(150) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of outstock
-- ----------------------------
INSERT INTO `outstock` VALUES ('1', '3', '2014-05-18 00:00:00', 'admin', 'sss');
INSERT INTO `outstock` VALUES ('2', '3', '2014-05-18 20:55:44', 'admin', '');
INSERT INTO `outstock` VALUES ('3', '4', '2014-05-18 21:18:26', 'admin', '');

-- ----------------------------
-- Table structure for `outstockdetails`
-- ----------------------------
DROP TABLE IF EXISTS `outstockdetails`;
CREATE TABLE `outstockdetails` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库详单编号',
  `outStock_id` int(11) DEFAULT NULL COMMENT '出库单编号',
  `p_id` int(11) DEFAULT NULL COMMENT '产品编号',
  `o_num` int(11) DEFAULT NULL COMMENT '出库数量',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of outstockdetails
-- ----------------------------
INSERT INTO `outstockdetails` VALUES ('1', '1', '2', '1');
INSERT INTO `outstockdetails` VALUES ('2', '1', '3', '1');
INSERT INTO `outstockdetails` VALUES ('3', '2', '2', '1');
INSERT INTO `outstockdetails` VALUES ('4', '2', '3', '1');
INSERT INTO `outstockdetails` VALUES ('5', '3', '3', '1');

-- ----------------------------
-- Table structure for `products`
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品编号',
  `p_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '产品名称',
  `t_id` int(11) DEFAULT NULL COMMENT '类别编号',
  `p_style` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '产品规格',
  `p_price` float DEFAULT NULL COMMENT '产品单价',
  `p_zt` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '产品状态',
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', '鼠标', '1', '个', '50', null);
INSERT INTO `products` VALUES ('2', '键盘', '1', '个', '100', null);
INSERT INTO `products` VALUES ('3', '显示器', '1', '个', '500', null);
INSERT INTO `products` VALUES ('4', '联想G490', '2', '台', '3500', null);
INSERT INTO `products` VALUES ('5', 'Dell-Ins15', '2', '台', '3000', null);

-- ----------------------------
-- Table structure for `producttype`
-- ----------------------------
DROP TABLE IF EXISTS `producttype`;
CREATE TABLE `producttype` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别编号',
  `t_type` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of producttype
-- ----------------------------
INSERT INTO `producttype` VALUES ('1', '电脑耗材');
INSERT INTO `producttype` VALUES ('2', '笔记本');

-- ----------------------------
-- Table structure for `purchaserecord`
-- ----------------------------
DROP TABLE IF EXISTS `purchaserecord`;
CREATE TABLE `purchaserecord` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `c_id` int(11) DEFAULT NULL COMMENT '客户编号',
  `p_id` int(11) DEFAULT NULL COMMENT '产品编号',
  `t_id` int(11) DEFAULT NULL COMMENT '类别编号',
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of purchaserecord
-- ----------------------------

-- ----------------------------
-- Table structure for `sell`
-- ----------------------------
DROP TABLE IF EXISTS `sell`;
CREATE TABLE `sell` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '销售单编号',
  `shop_id` int(11) DEFAULT NULL COMMENT '网店编号',
  `u_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理员编号',
  `s_date` datetime DEFAULT NULL COMMENT '销售时间',
  `s_bz` varchar(150) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sell
-- ----------------------------
INSERT INTO `sell` VALUES ('1', '3', 'admin', '2014-05-18 21:59:48', '');
INSERT INTO `sell` VALUES ('2', '3', 'admin', '2014-05-19 20:20:11', '');

-- ----------------------------
-- Table structure for `selldetails`
-- ----------------------------
DROP TABLE IF EXISTS `selldetails`;
CREATE TABLE `selldetails` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '销售详单编号',
  `sell_id` int(11) DEFAULT NULL COMMENT '销售单编号',
  `p_id` int(11) DEFAULT NULL COMMENT '产品编号',
  `s_num` int(11) DEFAULT NULL COMMENT '销售数量',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of selldetails
-- ----------------------------
INSERT INTO `selldetails` VALUES ('1', '1', '2', '1');
INSERT INTO `selldetails` VALUES ('2', '2', '2', '1');
INSERT INTO `selldetails` VALUES ('3', '2', '3', '1');

-- ----------------------------
-- Table structure for `shops`
-- ----------------------------
DROP TABLE IF EXISTS `shops`;
CREATE TABLE `shops` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '网点编号',
  `s_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '网点名称',
  `s_bz` varchar(150) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `s_address` char(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '网点地址',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of shops
-- ----------------------------
INSERT INTO `shops` VALUES ('1', '奥格瑞玛', null, null);
INSERT INTO `shops` VALUES ('3', '银月城', null, null);
INSERT INTO `shops` VALUES ('4', '雷霆崖', null, null);
INSERT INTO `shops` VALUES ('5', '幽暗城', null, null);
INSERT INTO `shops` VALUES ('6', '小麦公社', '不要钱', '');

-- ----------------------------
-- Table structure for `stocks`
-- ----------------------------
DROP TABLE IF EXISTS `stocks`;
CREATE TABLE `stocks` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库存编号',
  `shop_id` int(11) DEFAULT NULL COMMENT '网点编号',
  `p_id` int(11) DEFAULT NULL COMMENT '产品编号',
  `s_num` int(11) DEFAULT NULL COMMENT '库存数量',
  `s_maxNum` int(11) DEFAULT NULL COMMENT '库存最大值',
  `s_minNum` int(11) DEFAULT NULL COMMENT '库存最小值',
  `s_price` float DEFAULT NULL COMMENT '库存金额',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of stocks
-- ----------------------------
INSERT INTO `stocks` VALUES ('1', '1', '2', '1000', '2147483647', '0', null);
INSERT INTO `stocks` VALUES ('2', '1', '3', '1000', '2147483647', '0', null);
INSERT INTO `stocks` VALUES ('3', '3', '2', '0', '2147483647', '0', null);
INSERT INTO `stocks` VALUES ('4', '3', '3', '1', '2147483647', '0', null);
INSERT INTO `stocks` VALUES ('5', '4', '3', '1', '2147483647', '0', null);
INSERT INTO `stocks` VALUES ('6', '1', '1', '1000', '2147483647', '0', null);
INSERT INTO `stocks` VALUES ('7', '1', '4', '1001', '2147483647', '0', null);
INSERT INTO `stocks` VALUES ('8', '1', '5', '1000', '2147483647', '0', null);

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `u_id` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '管理员编号',
  `u_pwd` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理员密码',
  `u_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理员姓名',
  `u_bz` varchar(150) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('admin', 'admin', '管理猿', '');
