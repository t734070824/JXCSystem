/*
Navicat MySQL Data Transfer

Source Server         : 123
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : friday

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2014-05-08 16:12:55
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `customerinfo`
-- ----------------------------
DROP TABLE IF EXISTS `customerinfo`;
CREATE TABLE `customerinfo` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `c_name` varchar(50) DEFAULT NULL COMMENT '客户姓名',
  `c_phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `c_address` varchar(150) DEFAULT NULL COMMENT '地址',
  `c_note` varchar(150) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customerinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `employees`
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `e_id` varchar(50) NOT NULL COMMENT '员工编号',
  `e_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `e_sex` varchar(50) DEFAULT NULL COMMENT '性别',
  `e_phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `e_address` varchar(50) DEFAULT NULL COMMENT '地址',
  `e_date` datetime DEFAULT NULL COMMENT '出生日期',
  `e_price` float DEFAULT NULL COMMENT '工资',
  `e_bz` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of employees
-- ----------------------------

-- ----------------------------
-- Table structure for `goodsback`
-- ----------------------------
DROP TABLE IF EXISTS `goodsback`;
CREATE TABLE `goodsback` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '退货单编号',
  `g_date` datetime DEFAULT NULL COMMENT '退货时间',
  `u_id` varchar(50) DEFAULT NULL COMMENT '管理员编号',
  `g_price` float DEFAULT NULL COMMENT '合计金额',
  `g_backPrice` float DEFAULT NULL COMMENT '返回金额',
  `g_bz` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of goodsback
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of goodsbackdetails
-- ----------------------------

-- ----------------------------
-- Table structure for `instock`
-- ----------------------------
DROP TABLE IF EXISTS `instock`;
CREATE TABLE `instock` (
  `i_id` varchar(50) NOT NULL COMMENT '入库单编号',
  `u_id` varchar(50) DEFAULT NULL COMMENT '管理员编号',
  `o_id` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `i_date` datetime DEFAULT NULL COMMENT '入库时间',
  PRIMARY KEY (`i_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of instock
-- ----------------------------

-- ----------------------------
-- Table structure for `instockdetails`
-- ----------------------------
DROP TABLE IF EXISTS `instockdetails`;
CREATE TABLE `instockdetails` (
  `i_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '入库详单编号',
  `inStock_id` varchar(50) DEFAULT NULL COMMENT '入库单编号',
  `p_id` int(11) DEFAULT NULL COMMENT '产品编号',
  `i_num` int(11) DEFAULT NULL COMMENT '入库数量',
  PRIMARY KEY (`i_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of instockdetails
-- ----------------------------

-- ----------------------------
-- Table structure for `logs`
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `l_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志单编号',
  `l_msg` varchar(50) DEFAULT NULL COMMENT '日志内容',
  `l_date` datetime DEFAULT NULL COMMENT '日志时间',
  `u_id` varchar(50) DEFAULT NULL COMMENT '管理员编号',
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
  `o_id` varchar(50) NOT NULL COMMENT '订单编号',
  `u_id` varchar(50) DEFAULT NULL COMMENT '管理员编号',
  `o_date` datetime DEFAULT NULL COMMENT '订单时间',
  `o_bz` varchar(150) DEFAULT NULL COMMENT '备注',
  `o_style` int(11) DEFAULT NULL COMMENT '订单类型',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for `ordersdetails`
-- ----------------------------
DROP TABLE IF EXISTS `ordersdetails`;
CREATE TABLE `ordersdetails` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单详单编号',
  `order_id` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `p_id` int(11) DEFAULT NULL COMMENT '产品编号',
  `o_num` int(11) DEFAULT NULL COMMENT '订单数量',
  `o_inNum` int(11) DEFAULT NULL COMMENT '入库数量',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ordersdetails
-- ----------------------------

-- ----------------------------
-- Table structure for `outstock`
-- ----------------------------
DROP TABLE IF EXISTS `outstock`;
CREATE TABLE `outstock` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库单编号',
  `s_id` int(11) DEFAULT NULL COMMENT '网点编号',
  `o_date` datetime DEFAULT NULL COMMENT '出库时间',
  `u_id` varchar(50) DEFAULT NULL COMMENT '管理员编号',
  `o_bz` varchar(150) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of outstock
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of outstockdetails
-- ----------------------------

-- ----------------------------
-- Table structure for `products`
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品编号',
  `p_name` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `t_id` int(11) DEFAULT NULL COMMENT '类别编号',
  `p_style` varchar(50) DEFAULT NULL COMMENT '产品规格',
  `p_price` float DEFAULT NULL COMMENT '产品单价',
  `p_zt` varchar(10) DEFAULT NULL COMMENT '产品状态',
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of products
-- ----------------------------

-- ----------------------------
-- Table structure for `producttype`
-- ----------------------------
DROP TABLE IF EXISTS `producttype`;
CREATE TABLE `producttype` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别编号',
  `t_type` varchar(50) DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of producttype
-- ----------------------------

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
  `u_id` varchar(50) DEFAULT NULL COMMENT '管理员编号',
  `s_date` datetime DEFAULT NULL COMMENT '销售时间',
  `s_bz` varchar(150) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sell
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of selldetails
-- ----------------------------

-- ----------------------------
-- Table structure for `shops`
-- ----------------------------
DROP TABLE IF EXISTS `shops`;
CREATE TABLE `shops` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '网点编号',
  `s_name` varchar(50) DEFAULT NULL COMMENT '网点名称',
  `s_bz` varchar(150) DEFAULT NULL COMMENT '备注',
  `s_address` char(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '网点地址',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of shops
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of stocks
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `u_id` varchar(50) NOT NULL COMMENT '管理员编号',
  `u_pwd` varchar(50) DEFAULT NULL COMMENT '管理员密码',
  `u_name` varchar(50) DEFAULT NULL COMMENT '管理员姓名',
  `u_bz` varchar(150) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
