/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : carshop

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-07-18 11:05:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `topId` int(11) NOT NULL,
  `topCont` varchar(255) NOT NULL,
  `topTitle` varchar(255) NOT NULL,
  `topBrowes` int(11) NOT NULL,
  `topTime` datetime NOT NULL,
  `topPicture` varchar(255) NOT NULL,
  `topHead` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`topId`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`topId`) REFERENCES `article_page` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '最贵的不过十万    这4款SUV也受欢迎', '汽车前线', '1', '2017-07-04 00:00:00', '[\"http://localhost:8080/image/top5.jpg \",\"http://localhost:8080/image/top6.jpg \",\"http://localhost:8080/image/top10.jpg \"]', 'http://localhost:8080/images/T1.jpg');
INSERT INTO `article` VALUES ('2', '号称国产颜值最高，个头最大的小型SUV，90后能否买账？', '阿贵看车', '1', '2017-07-03 00:00:00', '[\"http://localhost:8080/image/top14.jpg \"]', 'http://localhost:8080/images/T2.jpg');
INSERT INTO `article` VALUES ('3', '号称国产验证最高，隔几天的积分即可', '超级试驾', '1', '2017-07-04 00:00:00', '[\"http://localhost:8080/image/top1.jpg \",\"http://localhost:8080/image/top2.jpg \",\"http://localhost:8080/image/top3.jpg \"]', 'http://localhost:8080/images/T3.jpg');
INSERT INTO `article` VALUES ('4', '看看这几款豪车，你一辈子能买几辆？', '华仔车库', '1', '2017-07-04 00:00:00', '[\"http://localhost:8080/image/top7.jpg \",\"http://localhost:8080/image/top8.jpg \",\"http://localhost:8080/image/top12.jpg \"]', 'http://localhost:8080/images/T4.jpg');
INSERT INTO `article` VALUES ('5', '像这种车，很土豪，买不起其实看看可以呀！', '华仔车库', '2', '2017-07-04 00:00:00', '[\"http://localhost:8080/image/top11.jpg \"]', 'http://localhost:8080/images/T5.jpg');
INSERT INTO `article` VALUES ('6', '搭载7速DCT双离合变速箱，新款吉利博瑞是要优化油耗了？', '华仔车库', '10', '2017-07-10 10:25:20', '[\"http://localhost:8080/image/top11.jpg \"]', 'http://localhost:8080/images/T6.jpg');
INSERT INTO `article` VALUES ('7', '全球SUV领导品牌Jeep两款车型重庆车展上市', '华仔车库', '11', '2017-07-10 11:29:25', '[\"http://localhost:8080/image/top5.jpg \",\"http://localhost:8080/image/top6.jpg \",\"http://localhost:8080/image/top10.jpg \"]', 'http://localhost:8080/images/T7.jpg');
INSERT INTO `article` VALUES ('8', 'woshiceshi', 'fddfs', '3', '2017-07-17 08:43:52', '[\"http://localhost:8080/image/top11.jpg\"]', 'http://localhost:8080/images/T7.jpg');
INSERT INTO `article` VALUES ('9', 'fsdfs', 'feeeee', '23', '2017-07-17 10:01:00', '[\"http://localhost:8080/image/top11.jpg\"]', 'http://localhost:8080/images/T7.jpg');

-- ----------------------------
-- Table structure for article_page
-- ----------------------------
DROP TABLE IF EXISTS `article_page`;
CREATE TABLE `article_page` (
  `id` int(11) NOT NULL,
  `page` text CHARACTER SET utf8,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of article_page
-- ----------------------------
INSERT INTO `article_page` VALUES ('1', '<div style=\"color:red\">我是<br>文章1</div>');
INSERT INTO `article_page` VALUES ('2', '<div style=\"color:red\">我是<br>文章2</div>');
INSERT INTO `article_page` VALUES ('3', '<div style=\"color:red\">我是<br>文章3</div>');
INSERT INTO `article_page` VALUES ('4', '<div style=\"color:red\">我是<br>文章4</div>');
INSERT INTO `article_page` VALUES ('5', ' <div style=\"color:red\">我是<br>文章5</div>');
INSERT INTO `article_page` VALUES ('6', '<div style=\"color:red\">我是<br>文章6</div>');
INSERT INTO `article_page` VALUES ('7', '<div style=\"color:red\">我是<br>文章7</div>');
INSERT INTO `article_page` VALUES ('8', '<div style=\"color:red\">我是<br>文章8</div>');
INSERT INTO `article_page` VALUES ('9', '<div style=\"font-size:17px\">全新的动力总成，输出功率达到261马力和350牛·米，匹配9AT变速箱。而新平台下，整车又进行了减重，这不得不让我对它的测试成绩充满了期待。<br>\r\n<img src=\"http://localhost:8080/wx_CarShop/image/news/1_1.jpg\">\r\n空间方面，新一代君威有了不小改观，一改原来美系车“外大内小”的尴尬局面。首先轴距长了92毫米，车高降低了28毫米，能很直观地感觉它变得更“扁”。这不仅降低了重心，而且另侧面线条更加流畅。而内部空间方面，没有因车辆高度变矮而减小，前排的坐姿非常低，座椅头部空间并没有减少；后排的腿部空间充裕很多，身高1.8米的乘客，膝盖离前排座椅仍有超过2拳的距离。座椅采用皮+翻毛皮的混合材质，所以在激烈驾驶时也能提供足够的支撑和摩擦。\r\n<img src=\"http://localhost:8080/wx_CarShop/image/news/1_2.jpg\">\r\n<br>\r\n2.0T发动机的功率表现很好，这台输出261马力的发动机最先装备在君越上，它的扭矩峰值达到350牛·米，是主流的高输出水平。扭矩平台从2000~5000转，它更注重高转时的表现。从加速过程来看，发动机并不缺少低扭，无论是怠速起步还是弹射起跑，发动机都憋足了力气尽情释放动力。6.8秒的加速成绩是在较潮湿的路面上获得的，而在这条超过1公里长的测试直线上，新君威也是轻松地跑出了200公里的时速。\r\n<img src=\"http://localhost:8080/wx_CarShop/image/news/1_3.jpg\">\r\n</div>\r\n');

-- ----------------------------
-- Table structure for article_review
-- ----------------------------
DROP TABLE IF EXISTS `article_review`;
CREATE TABLE `article_review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `reviewdate` datetime DEFAULT NULL,
  `review` text CHARACTER SET utf8,
  `icon_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `videoid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of article_review
-- ----------------------------
INSERT INTO `article_review` VALUES ('1', '不再為你流淚', '北京市', '2017-07-07 17:05:40', ' 外观设计有些超前，需要时间来适应；四驱系统没有变化；脚踏板后面那一片的车厢做工太糊弄事。这些缺点如果能忍受，就可以很坦然的选它了。', 'http://localhost:8080/images/impic.jpg', '1');
INSERT INTO `article_review` VALUES ('2', '淡妆素描 ㄨ', '东城区', '2017-07-07 17:08:05', '从我们的分析结果来看，全新A4L的综合评分为4.4分', 'http://localhost:8080/images/impic.jpg', '1');
INSERT INTO `article_review` VALUES ('3', '时光说我们会在一起。', '西城区', '2017-07-07 17:08:11', '从车主的口碑中我们发现，大多数车主对于奥迪A4L的外观设计非常满意。全新A4L使用了奥迪最新的家族式设计语言，其中造型犀利的全LED大灯广受车主好评。', 'http://localhost:8080/images/impic.jpg', '1');
INSERT INTO `article_review` VALUES ('4', '指日可待╮', '朝阳区', '2017-07-07 17:08:15', '颜值高，识别度高，体态优雅，车身线条处理非常细腻。LED大灯好看又好用，炯炯有神，自动转向更显得非常有灵气，心灵的窗户。车尾流水转向目前还没普及的状况下，吸睛度高，羡煞旁人。', 'http://localhost:8080/images/impic.jpg', '1');
INSERT INTO `article_review` VALUES ('5', '\r\n浅巷墨漓°', '丰台区', '2017-07-07 17:08:17', '内饰科技感满满，液晶仪表盘，操作简单，中控8.3彩色大屏，完美的MMI操作体验，导航时候触摸输入也很便捷', 'http://localhost:8080/images/impic.jpg', '1');
INSERT INTO `article_review` VALUES ('6', '\r\n长发及腰静电多@', '石景山区', '2017-07-07 17:08:20', '多功能平底方向盘按键回馈很好，操作简单便捷，定速巡航的位置需要适应一下，电子档把等很有逼格', 'http://localhost:8080/images/impic.jpg', '1');
INSERT INTO `article_review` VALUES ('7', '\r\n棈樹喖籐', '海淀区', '2017-07-07 17:08:22', '我的同事试驾我车，赞不绝口，个人感觉银色镀铬装饰有些跟内饰不太搭，风尚版的橡木材质的装饰条，跟内饰搭配更和谐，夜间氛围灯也很迷人，算是逼格加分项。', 'http://localhost:8080/images/impic.jpg', '1');
INSERT INTO `article_review` VALUES ('8', '\r\n致我们终将热死的夏天', '门头沟区', '2017-07-07 17:08:23', '全新A4L在内饰方面可谓是焕然一新，让人眼前一亮', 'http://localhost:8080/images/impic.jpg', '1');
INSERT INTO `article_review` VALUES ('9', 'article_review', '房山区', '2017-07-07 17:08:24', '全新A4L在内饰方面可谓是焕然一新', 'http://localhost:8080/images/impic.jpg', '1');

-- ----------------------------
-- Table structure for ask
-- ----------------------------
DROP TABLE IF EXISTS `ask`;
CREATE TABLE `ask` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL COMMENT '户用ID',
  `carid` int(11) NOT NULL COMMENT '车汽ID',
  `shop` varchar(11) NOT NULL COMMENT '家商id',
  PRIMARY KEY (`id`,`shop`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ask
-- ----------------------------
INSERT INTO `ask` VALUES ('1', '1', '1', '北京');
INSERT INTO `ask` VALUES ('2', '2', '2', '天津');
INSERT INTO `ask` VALUES ('3', '1', '2', '天津');
INSERT INTO `ask` VALUES ('4', '10', '1', '华昌大众');
INSERT INTO `ask` VALUES ('5', '10', '1', '北京捷亚泰汽贸有限公司');
INSERT INTO `ask` VALUES ('6', '10', '1', '华昌大众');
INSERT INTO `ask` VALUES ('7', '10', '1', '北京捷亚泰汽贸有限公司');
INSERT INTO `ask` VALUES ('8', '10', '1', '北京冀东丰');
INSERT INTO `ask` VALUES ('9', '10', '1', '华昌大众');
INSERT INTO `ask` VALUES ('10', '10', '1', '北京捷亚泰汽贸有限公司');
INSERT INTO `ask` VALUES ('11', '10', '1', '北京冀东丰');
INSERT INTO `ask` VALUES ('12', '11', '1', '北京捷亚泰汽贸有限公司');
INSERT INTO `ask` VALUES ('13', '11', '1', '华昌大众');
INSERT INTO `ask` VALUES ('14', '11', '1', '北京冀东丰');
INSERT INTO `ask` VALUES ('15', '12', '1', '一汽大众天津中捷');
INSERT INTO `ask` VALUES ('16', '12', '1', '天津彭中');
INSERT INTO `ask` VALUES ('17', '12', '1', '天津捷世通');
INSERT INTO `ask` VALUES ('18', '13', '1', '北京捷亚泰汽贸有限公司');
INSERT INTO `ask` VALUES ('19', '13', '1', '华昌大众');
INSERT INTO `ask` VALUES ('20', '14', '1', '');

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '品牌名',
  `aplha_code` char(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '字母编号',
  `quantity` int(10) DEFAULT NULL COMMENT '车系数量',
  `logo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `brand_name` (`brand_name`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES ('1', '奥迪', 'A', '6', 'http://localhost:8080/image/audi.jpg');
INSERT INTO `brand` VALUES ('2', '比亚迪', 'B', '6', 'http://localhost:8080/image/byd.jpg');
INSERT INTO `brand` VALUES ('3', '中华', 'Z', '6', 'http://localhost:8080/image/zhonghua.jpg');
INSERT INTO `brand` VALUES ('4', '大众', 'D', '6', 'http://localhost:8080/image/dazhong.jpg');
INSERT INTO `brand` VALUES ('5', '保时捷', 'B', '9', 'http://localhost:8080/image/baoshijie.jpg');
INSERT INTO `brand` VALUES ('6', '奔驰', 'B', '10', 'http://localhost:8080/image/benchi.jpg');
INSERT INTO `brand` VALUES ('7', '兰博基尼', 'L', '11', 'http://localhost:8080/image/lanbojini.jpg');
INSERT INTO `brand` VALUES ('8', '别克', 'B', '5', 'http://localhost:8080/image/bieke.jpg');
INSERT INTO `brand` VALUES ('9', '斯柯达', 'S', '2', 'http://localhost:8080/image/sikeda.jpg');
INSERT INTO `brand` VALUES ('36', '现代', 'X', '8', 'http://localhost:8080/image/xaindai.jpg');
INSERT INTO `brand` VALUES ('37', '阿尔法罗密欧 ', 'A', '5', 'http://localhost:8080/image/aerfa.jpg');
INSERT INTO `brand` VALUES ('38', '法拉利', 'F', '8', 'http://localhost:8080/image/falali.jpg');
INSERT INTO `brand` VALUES ('39', '丰田', 'F', '6', 'http://localhost:8080/image/fengtian.jpg');
INSERT INTO `brand` VALUES ('40', 'MG', 'M', '5', 'http://localhost:8080/image/mg.jpg');
INSERT INTO `brand` VALUES ('41', '福特', 'F', '9', 'http://localhost:8080/image/fute.jpg');
INSERT INTO `brand` VALUES ('42', '帕加尼', 'P', '9', 'http://localhost:8080/image/pajiani.jpg');
INSERT INTO `brand` VALUES ('43', '广汽', 'G', '9', 'http://localhost:8080/image/guangqi.jpg');
INSERT INTO `brand` VALUES ('44', '日产', 'R', null, 'http://localhost:8080/image/richan.jpg');
INSERT INTO `brand` VALUES ('45', '哈飞', 'H', null, 'http://localhost:8080/image/hafei.jpg');
INSERT INTO `brand` VALUES ('46', '斯巴鲁', 'S', null, 'http://localhost:8080/image/sibalu.jpg');
INSERT INTO `brand` VALUES ('47', '本田', 'B', null, 'http://localhost:8080/image/bentian.jpg');
INSERT INTO `brand` VALUES ('48', '红旗', 'H', null, 'http://localhost:8080/image/hongqi.jpg');
INSERT INTO `brand` VALUES ('49', '标志', 'B', null, 'http://localhost:8080/image/biaozhi.jpg');
INSERT INTO `brand` VALUES ('50', '凯迪拉克', 'K', null, 'http://localhost:8080/image/kaidilake.jpg');
INSERT INTO `brand` VALUES ('51', '沃尔沃', 'W', null, 'http://localhost:8080/image/woerwo.jpg');
INSERT INTO `brand` VALUES ('53', '五菱', 'W', null, 'http://localhost:8080/image/wuling.jpg');
INSERT INTO `brand` VALUES ('55', '劳斯莱斯', 'L', null, 'http://localhost:8080/image/laosilaisi.jpg');
INSERT INTO `brand` VALUES ('56', '长城', 'C', null, 'http://localhost:8080/image/changcheng.jpg');
INSERT INTO `brand` VALUES ('57', '雷克萨斯', 'L', null, 'http://localhost:8080/image/lksi.jpg');
INSERT INTO `brand` VALUES ('58', '一汽', 'Y', null, 'http://localhost:8080/image/yiqi.jpg');
INSERT INTO `brand` VALUES ('59', '路虎', 'L', null, 'http://localhost:8080/image/luhu.jpg');
INSERT INTO `brand` VALUES ('61', 'icona', 'I', null, 'http://localhost:8080/image/icona.jpg');
INSERT INTO `brand` VALUES ('62', '吉普', 'J', null, 'http://localhost:8080/image/jipu.jpg');
INSERT INTO `brand` VALUES ('63', '南汽', 'N', null, 'http://localhost:8080/image/nanqi.jpg');
INSERT INTO `brand` VALUES ('64', '讴歌', 'O', null, 'http://localhost:8080/image/ouge.jpg');
INSERT INTO `brand` VALUES ('65', '起亚', 'Q', null, 'http://localhost:8080/image/qiya.jpg');
INSERT INTO `brand` VALUES ('66', 'VLF', 'V', null, 'http://localhost:8080/image/VLF.jpg');
INSERT INTO `brand` VALUES ('67', '塔塔', 'T', null, 'http://localhost:8080/image/tata.jpg');
INSERT INTO `brand` VALUES ('68', '尔诺', 'E', null, 'http://localhost:8080/image/ernuo.jpg');
INSERT INTO `brand` VALUES ('69', 'USA', 'U', null, 'http://localhost:8080/image/UAS.jpg');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `car_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '车名',
  `size` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '型号',
  `price_range` varchar(225) CHARACTER SET utf8 DEFAULT NULL COMMENT '价格范围',
  `brand_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '汽车图片',
  `kind` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `car_name` (`car_name`),
  KEY `brand_name` (`brand_name`),
  KEY `size` (`size`),
  CONSTRAINT `car_ibfk_1` FOREIGN KEY (`brand_name`) REFERENCES `brand` (`brand_name`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', '奥迪A4L', '中型车', '29.98-43.00万', '奥迪', 'http://localhost:8080/image/A4L.jpg', '一汽-大众奥迪');
INSERT INTO `car` VALUES ('2', '奥迪A6L', '中大型车', '41.88-74.60万', '奥迪', 'http://localhost:8080/image/A6L.jpg', '一汽-大众奥迪');
INSERT INTO `car` VALUES ('3', '奥迪A3', '紧凑车型', '18.49-28.10万', '奥迪', 'http://localhost:8080/image/A3.jpg', '一汽-大众奥迪');
INSERT INTO `car` VALUES ('4', '奥迪Q5', '中型SUV', '39.96-52.53', '奥迪', 'http://localhost:8080/image/Q5.jpg', '一汽-大众奥迪');
INSERT INTO `car` VALUES ('5', '奥迪RS 6', '中大型车', '170-190万', '奥迪', 'http://localhost:8080/image/A7.jpg', '奥迪RS');
INSERT INTO `car` VALUES ('6', '奥迪RS 7', '中大型车', '160万', '奥迪', 'http://localhost:8080/image/A5.jpg', '奥迪RS');
INSERT INTO `car` VALUES ('7', '奥迪A8', '豪华型车', '87.98万', '奥迪', 'http://localhost:8080/image/A7.jpg', '奥迪（进口）');
INSERT INTO `car` VALUES ('8', '奥迪Q3(进口)', '紧凑型SUV', '', '奥迪', 'http://localhost:8080/image/Q3.jpg', '奥迪（进口）');
INSERT INTO `car` VALUES ('9', '奥迪SQ5', '中型SUV', '66.80万', '奥迪', 'http://localhost:8080/image/Q1.jpg', '奥迪（进口）');
INSERT INTO `car` VALUES ('10', '奥迪A4', '中型车', '', '奥迪', 'http://localhost:8080/image/A4L.jpg', '一汽-大众奥迪');
INSERT INTO `car` VALUES ('11', '奔驰C级', '中型车', '31.28-59.90万', '奔驰', 'http://localhost:8080/image/A4L.jpg', '北京奔驰');
INSERT INTO `car` VALUES ('12', '奔驰E级', '中大型车', '42.28-62.98万', '奔驰', 'http://localhost:8080/image/C.jpg', '北京奔驰');
INSERT INTO `car` VALUES ('13', '奔驰GLC', '中型SUV', '39.60-57.90万', '奔驰', 'http://localhost:8080/image/E.jpg', '北京奔驰');
INSERT INTO `car` VALUES ('14', '奔驰GLA', '紧凑型SUV', '26.98-39.90万', '奔驰', 'http://localhost:8080/image/GLA.jpg', '北京奔驰');
INSERT INTO `car` VALUES ('15', '奔驰GLK级', '中型SUV', '', '奔驰', 'http://localhost:8080/image/GLS.jpg', '北京奔驰');
INSERT INTO `car` VALUES ('16', '奔驰B级', '紧凑型车', '24.20-36.80万', '奔驰', 'http://localhost:8080/image/B.jpg', '奔驰（进口）');
INSERT INTO `car` VALUES ('17', '奔驰C级（进口）', '中型车', '38.28-57.00万', '奔驰', 'http://localhost:8080/image/A6L.jpg', '奔驰（进口）');
INSERT INTO `car` VALUES ('18', '奔驰E级（进口）', '中大型车', '55.80-85.30万', '奔驰', 'http://localhost:8080/image/C.jpg', '奔驰（进口）');
INSERT INTO `car` VALUES ('19', '奔驰GLA（进口）', '紧凑型SUV', '', '奔驰', 'http://localhost:8080/image/GLA.jpg', '奔驰（进口）');
INSERT INTO `car` VALUES ('20', '奔驰SL级', '跑车', '107-131万', '奔驰', 'http://localhost:8080/image/SL.jpg', '奔驰（进口）');
INSERT INTO `car` VALUES ('21', '奥迪A4L', '中型车', '29.98-43.00万', '奥迪', null, null);

-- ----------------------------
-- Table structure for car_company
-- ----------------------------
DROP TABLE IF EXISTS `car_company`;
CREATE TABLE `car_company` (
  `id` int(11) NOT NULL COMMENT '一辆车对应此车在本经销商下的id',
  `comid` int(11) DEFAULT NULL COMMENT '经销商id',
  `carid` int(11) DEFAULT NULL COMMENT '汽车id',
  `issell` int(11) DEFAULT NULL COMMENT '上市状态 0-没上市 1-在售  2-停售',
  `price` double DEFAULT NULL COMMENT '该汽车在此经销商下的价格',
  PRIMARY KEY (`id`),
  KEY `comid` (`comid`),
  KEY `carid` (`carid`),
  CONSTRAINT `car_company_ibfk_1` FOREIGN KEY (`comid`) REFERENCES `company` (`id`),
  CONSTRAINT `car_company_ibfk_2` FOREIGN KEY (`carid`) REFERENCES `car` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car_company
-- ----------------------------
INSERT INTO `car_company` VALUES ('1', '1', '1', null, '12.73');
INSERT INTO `car_company` VALUES ('2', '2', '1', null, '16.5');
INSERT INTO `car_company` VALUES ('3', '3', '1', null, '11.1');
INSERT INTO `car_company` VALUES ('4', '4', '1', null, '14.43');
INSERT INTO `car_company` VALUES ('5', '5', '1', null, '17.5');
INSERT INTO `car_company` VALUES ('6', '6', '1', null, '44.43');
INSERT INTO `car_company` VALUES ('7', '7', '1', null, '1.34');
INSERT INTO `car_company` VALUES ('8', '8', '1', null, '12.35');
INSERT INTO `car_company` VALUES ('9', '9', '1', null, '16.25');

-- ----------------------------
-- Table structure for car_info
-- ----------------------------
DROP TABLE IF EXISTS `car_info`;
CREATE TABLE `car_info` (
  `id` int(10) NOT NULL,
  `car_name` varchar(255) DEFAULT NULL,
  `brand_name` varchar(255) DEFAULT NULL,
  `car_model` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `condition` varchar(255) DEFAULT NULL,
  `configuration_id` int(11) DEFAULT NULL,
  `image_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `car_model` (`car_model`),
  KEY `configuration_id` (`configuration_id`),
  KEY `car_info_ibfk_3` (`brand_name`),
  KEY `car_name` (`car_name`),
  KEY `image_id` (`image_id`),
  CONSTRAINT `car_info_ibfk_3` FOREIGN KEY (`brand_name`) REFERENCES `brand` (`brand_name`),
  CONSTRAINT `car_info_ibfk_4` FOREIGN KEY (`car_name`) REFERENCES `car` (`car_name`),
  CONSTRAINT `car_info_ibfk_5` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`),
  CONSTRAINT `car_info_ibfk_6` FOREIGN KEY (`configuration_id`) REFERENCES `configuration` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car_info
-- ----------------------------
INSERT INTO `car_info` VALUES ('1', '奥迪A4L', '奥迪', '45 TFSI quanttro 风尚型', '32.80', '2014', '在售', '1', '1');
INSERT INTO `car_info` VALUES ('2', '奥迪A4L', '奥迪', '45 TFSI quanttro 运动型', '33.10', '2017', '在售', '1', '1');
INSERT INTO `car_info` VALUES ('3', '奥迪A4L', '奥迪', 'Plus 45 TFSI quanttro 风尚型', '34.03', '2017', '在售', '2', '1');
INSERT INTO `car_info` VALUES ('4', '奥迪A4L', '奥迪', '40 TFSI 运动型', '29.92', '2017', '已停售', '2', '1');
INSERT INTO `car_info` VALUES ('5', '奥迪A4L', '奥迪', '40 TFSI 风尚型', '29.60', '2015', '已停售', '2', '1');
INSERT INTO `car_info` VALUES ('6', '奥迪A4L', '奥迪', '40 TFSI 时尚型', '27.28', '2019', '未上市', '2', '1');
INSERT INTO `car_info` VALUES ('7', '奥迪A6L', '奥迪', '50 TFSI quanttro 豪华型', '53.66', '2017', '在售', '3', '2');
INSERT INTO `car_info` VALUES ('8', '奥迪A6L', '奥迪', '50 TFSI quanttro 尊享型', '60.60', '2017', '在售', '3', '2');
INSERT INTO `car_info` VALUES ('9', '奥迪A6L', '奥迪', '30 FSI 舒适型', '38.62', '2017', '在售', '4', '2');
INSERT INTO `car_info` VALUES ('10', '奥迪A6L', '奥迪', '30 FSI 技术型', '35.69', '2017', '在售', '4', '2');
INSERT INTO `car_info` VALUES ('11', '奥迪A6L', '奥迪', 'TFSI 运动型', '37.84', '2017', '未上市', '5', '2');
INSERT INTO `car_info` VALUES ('12', '奥迪A4L', '奥迪', '45 TFSI quanttro 风尚型', '37.84', '2016', '已停售', '1', '1');
INSERT INTO `car_info` VALUES ('13', '奥迪A4L', '奥迪', 'TFSI 运动型', '40.00', '2018', '未上市', '1', '1');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '评论人昵称',
  `comment` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `city` varchar(255) DEFAULT NULL COMMENT '城市',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '厂商名',
  `location` varchar(255) DEFAULT NULL COMMENT '地址',
  `provence` varchar(255) DEFAULT NULL COMMENT '省份',
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '北京捷亚泰汽贸有限公司', '北京市朝阳区京顺路', '北京', null);
INSERT INTO `company` VALUES ('2', '华昌大众', '北京市海定区', '北京', null);
INSERT INTO `company` VALUES ('3', '北京冀东丰', '北京市石景山古城', '北京', null);
INSERT INTO `company` VALUES ('4', '天大汽车', '北京市西四环东路', '北京', null);
INSERT INTO `company` VALUES ('5', '一汽大众', '北京市朝阳区京顺路', '北京', null);
INSERT INTO `company` VALUES ('6', '北京运通贾恩', '北京市顺义区', '北京', null);
INSERT INTO `company` VALUES ('7', '一汽大众天津中捷', '天津市和平路339号', '天津', null);
INSERT INTO `company` VALUES ('8', '天津彭中', '天津市和平路384路', '天津', null);
INSERT INTO `company` VALUES ('9', '天津捷世通', '天津市和平路384路', '天津', null);

-- ----------------------------
-- Table structure for configuration
-- ----------------------------
DROP TABLE IF EXISTS `configuration`;
CREATE TABLE `configuration` (
  `id` int(11) NOT NULL,
  `factory_price` double(10,2) DEFAULT NULL COMMENT '厂商指导价',
  `least_price` double(10,2) DEFAULT NULL COMMENT '全国最低价',
  `companyname` varchar(255) DEFAULT NULL COMMENT '厂商名',
  `level` varchar(255) DEFAULT NULL COMMENT '级别 小，中，大型车',
  `date` varchar(255) DEFAULT NULL COMMENT '上市日期',
  `engine` varchar(255) DEFAULT NULL COMMENT '引擎',
  `aidmoney` double(10,2) DEFAULT NULL COMMENT '国家补助',
  `gear_box` varchar(255) DEFAULT NULL COMMENT '变速箱',
  `length` int(11) DEFAULT NULL COMMENT '长度',
  `height` int(11) DEFAULT NULL COMMENT '高度',
  `width` int(11) DEFAULT NULL COMMENT '宽度',
  `structure` varchar(255) DEFAULT NULL COMMENT '车身结构',
  `speed` int(11) DEFAULT NULL COMMENT '最高时速',
  `accelerate` double(10,2) DEFAULT NULL COMMENT '百公里加速时间',
  `oil_wear` double(10,2) DEFAULT NULL COMMENT '综合油耗',
  `oil_cost` varchar(255) DEFAULT NULL COMMENT '每年油费',
  `wheelbase` int(11) DEFAULT NULL COMMENT '轴距',
  `front_gauge` int(11) DEFAULT NULL COMMENT '前轮距',
  `back_gauge` int(11) DEFAULT NULL COMMENT '后轮距',
  `mass` int(11) DEFAULT NULL COMMENT '整备质量',
  `door_num` int(11) DEFAULT NULL COMMENT '车门数',
  `seat_num` int(11) DEFAULT NULL COMMENT '座位数',
  `fuel_tank` int(11) DEFAULT NULL COMMENT '油箱容积',
  `output` varchar(225) DEFAULT NULL COMMENT '发动机排量',
  `cylinder_num` int(11) DEFAULT NULL COMMENT '气缸数',
  `horsepower` int(11) DEFAULT NULL COMMENT '最大马力',
  `capacity` int(11) DEFAULT NULL COMMENT '最大功率',
  `fuel` varchar(255) DEFAULT NULL COMMENT '燃油形式',
  `fuel_model` varchar(255) DEFAULT NULL COMMENT '供油方式',
  `env_standards` varchar(255) DEFAULT NULL COMMENT '环保标准',
  `gear_box_name` varchar(255) DEFAULT NULL COMMENT '变速箱简称',
  `gear_num` int(255) DEFAULT NULL COMMENT '档位个数',
  `gear_box_style` varchar(255) DEFAULT NULL COMMENT '变速箱类型',
  `drive_system` varchar(255) DEFAULT NULL COMMENT '驱动方式',
  `power_type` varchar(255) DEFAULT NULL COMMENT '助力方式',
  `carbody_structure` varchar(255) DEFAULT NULL COMMENT '车体结构',
  `front_brake` varchar(255) DEFAULT NULL COMMENT '前制动器类型',
  `back_brake` varchar(255) DEFAULT NULL COMMENT '后制动器类型',
  `parking_brake` varchar(255) DEFAULT NULL COMMENT '驻车制动类型',
  `front_type` varchar(255) DEFAULT NULL COMMENT '前轮胎规格',
  `back_tyre` varchar(255) DEFAULT NULL COMMENT '后轮胎规格',
  `spare_tire` varchar(255) DEFAULT NULL COMMENT '备胎规格',
  `air_admission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `configuration_ibfk_3` (`companyname`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of configuration
-- ----------------------------
INSERT INTO `configuration` VALUES ('1', '40.88', '28.00', '一汽-大众奥迪', '中型车', '2016-09-10', '2.0T 252马力 L4', '2.00', '7挡双离合', '4818', '1843', '1432', '4门5座三厢车', '250', '5.90', '8.80', '1.23万', '2908', '1146', '1236', '1645', '4', '5', '58', '2.0T', '4', '252', '185', '汽油', '混合喷射', '国v', '7挡双离合', '7', 'DCT', '前置四驱', '电动助力', '承载式', '通风盘式', '盘式', '电子驻车', '245/40 R18', '245/40 R18', '非全尺寸', '涡轮增压');
INSERT INTO `configuration` VALUES ('2', '37.28', '26.00', '一汽-大众奥迪', '中型车', '2016-09-10', '2.0T 252马力 L4', '2.00', '7挡双离合', '4818', '1843', '1432', '4门5座三厢车', '250', '7.90', '8.60', '1.2万', '2908', '1146', '1236', '1565', '4', '5', '54', '2.0T', '4', '190', '140', '汽油', '混合喷射', '国v', '7挡双离合', '7', 'DCT', '前置四驱', '电动助力', '承载式', '通风盘式', '盘式', '电子驻车', '245/40 R18', '245/40 R18', '非全尺寸', '涡轮增压');
INSERT INTO `configuration` VALUES ('3', '66.32', '43.00', '一汽-大众奥迪', '中大型车', '2016-09-30', '3.0T 333马力 V6', '3.00', '7挡双离合', '5036', '1847', '1466', '4门5座三厢车', '250', '5.60', '11.50', '1.61万', '3012', '1569', '1896', '1970', '4', '5', '75', '3.0T', '6', '333', '245', '汽油', '混合喷射', '国v', '7挡双离合', '7', 'DCT', '前置四驱', '电动助力', '承载式', '通风盘式', '通风盘式', '电子驻车', '245/45 R18', '245/45 R18', '非全尺寸', '机械增压');
INSERT INTO `configuration` VALUES ('4', '53.05', '37.00', '一汽-大众奥迪', '中大型车', '2016-09-30', '3.0T 272马力 V6', '3.00', '7挡双离合', '5036', '1847', '1466', '4门5座三厢车', '250', '6.50', '11.40', '1.6万', '3012', '1569', '1896', '1960', '4', '5', '75', '3.0T', '6', '272', '200', '汽油', '混合喷射', '国v', '7挡双离合', '7', 'DCT', '前置四驱', '电动助力', '承载式', '通风盘式', '通风盘式', '电子驻车', '245/45 R18', '245/45 R18', '非全尺寸', '机械增压');
INSERT INTO `configuration` VALUES ('5', '47.65', '32.00', '一汽-大众奥迪', '中大型车', '2016-09-30', '2.5L 204马力 V4', '3.00', 'CVT无敌变速（模拟8挡）', '5036', '1847', '1466', '4门5座三厢车', '236', '8.80', '11.00', '1.54万', '3012', '1569', '1896', '1800', '4', '5', '75', '2.5T', '6', '204', '150', '汽油', '直喷', '国v', 'CVT无敌变速（模拟8挡）', '8', 'CVT', '前置前驱', '电动助力', '承载式', '通风盘式', '通风盘式', '电子驻车', '225/55 R17', '225/55 R17', '非全尺寸', '自然吸气');

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL,
  `imgage_name` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('1', '奥迪A4L', 'http://localhost:8080/image/aodi_A4L.jpg');
INSERT INTO `image` VALUES ('2', '奥迪A6L', 'http://localhost:8080/image/aodi_A4L.jpg');
INSERT INTO `image` VALUES ('3', null, null);
INSERT INTO `image` VALUES ('4', null, null);
INSERT INTO `image` VALUES ('5', null, null);
INSERT INTO `image` VALUES ('6', null, null);

-- ----------------------------
-- Table structure for image_video
-- ----------------------------
DROP TABLE IF EXISTS `image_video`;
CREATE TABLE `image_video` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `image_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '图片名称',
  `image_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `video_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `video_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `icon_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of image_video
-- ----------------------------
INSERT INTO `image_video` VALUES ('1', '图片', 'http://localhost:8080/images/Q1.png', '视频1', '奔驰新款GLA车型正式上市，价格有惊喜！', 'http://localhost:8080/videos/View_TJPU_Autumn.mp4', '爱极客', '2017-07-14 00:00:00', 'http://localhost:8080/images/T7.jpg');
INSERT INTO `image_video` VALUES ('2', null, 'http://localhost:8080/images/Q2.png', null, '搭载7速DCT双离合变速箱，新款吉利博瑞是要优化油耗了？', 'http://localhost:8080/videos/View_TJPU.mp4', '小仓说车', '2017-04-03 00:00:00', 'http://localhost:8080/images/T1.jpg');
INSERT INTO `image_video` VALUES ('3', null, 'http://localhost:8080/images/Q3.png', null, '丰田新款雷凌正式上市，马自达CX-8实车谍照曝光', 'http://localhost:8080/videos/View_TJPU.mp4', '暴走汽车', '2017-05-06 00:00:00', 'http://localhost:8080/images/T4.jpg');
INSERT INTO `image_video` VALUES ('4', null, 'http://localhost:8080/images/Q4.png', null, '空间没增大 配置还缩水 8月份上市的长安马自达CX-5到底在搞什么鬼', 'http://localhost:8080/videos/View_TJPU.mp4', '汽车洋葱圈', '2018-06-12 00:00:00', 'http://localhost:8080/images/T6.jpg');
INSERT INTO `image_video` VALUES ('5', null, 'http://localhost:8080/images/Q5.png', null, '全球SUV领导品牌Jeep两款车型重庆车展上市', 'http://localhost:8080/videos/View_TJPU.mp4', '暴走汽车', '2015-06-20 00:00:00', 'http://localhost:8080/images/T4.jpg');
INSERT INTO `image_video` VALUES ('6', null, 'http://localhost:8080/images/Q6.png', null, '全新一代奥迪A6路试谍照曝光，新款众泰SR7官图发布', 'http://localhost:8080/videos/View_TJPU.mp4', '五号频道', '2011-08-08 00:00:00', 'http://localhost:8080/images/T2.jpg');
INSERT INTO `image_video` VALUES ('7', null, 'http://localhost:8080/images/Q7.png', null, '特斯拉MODEL Y预告图曝光，新款哈弗H2将换双离合变速箱', 'http://localhost:8080/videos/View_TJPU.mp4', '汽车评中评', '2017-07-06 00:00:00', 'http://localhost:8080/images/T3.jpg');
INSERT INTO `image_video` VALUES ('8', null, 'http://localhost:8080/images/Q8.png', null, '外观犀利动力感人全新宝马5系混动版将国产', 'http://localhost:8080/videos/View_TJPU.mp4', '驭动汽车', '2017-03-22 00:00:00', 'http://localhost:8080/images/T5.jpg');
INSERT INTO `image_video` VALUES ('9', null, 'http://localhost:8080/images/Q9.png', null, '新款宝马4系售价正式公布，吉利博瑞官图正式发布', 'http://localhost:8080/videos/View_TJPU.mp4', '小仓说车', '2017-07-10 11:29:23', 'http://localhost:8080/images/T1.jpg');
INSERT INTO `image_video` VALUES ('10', null, 'http://localhost:8080/images/Q10.png', null, '十代雅阁即将问世 九代值得抄底入手吗？', 'http://localhost:8080/videos/View_TJPU.mp4', '爱极客', '2017-07-10 11:29:26', 'http://localhost:8080/images/T7.jpg');
INSERT INTO `image_video` VALUES ('11', null, null, null, '21', null, '12', '2017-07-05 00:00:00', null);

-- ----------------------------
-- Table structure for sell_user
-- ----------------------------
DROP TABLE IF EXISTS `sell_user`;
CREATE TABLE `sell_user` (
  `carid` int(11) DEFAULT NULL COMMENT '汽车ID',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `ischose` int(11) DEFAULT NULL COMMENT '是否被选中 0-未选中 1-选中',
  KEY `carid` (`carid`),
  KEY `userid` (`userid`),
  CONSTRAINT `sell_user_ibfk_1` FOREIGN KEY (`carid`) REFERENCES `car_company` (`id`),
  CONSTRAINT `sell_user_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sell_user
-- ----------------------------

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `ID` varchar(20) NOT NULL,
  `ADMIN` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '用户名',
  `phone` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '手机号',
  `city` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', '李四', '123456', null, null, null);
INSERT INTO `user` VALUES ('5', '刘星星', '1008611', null, null, null);
INSERT INTO `user` VALUES ('6', '王二', '100861111', null, null, null);
INSERT INTO `user` VALUES ('7', '万个女', '15545345', null, null, null);
INSERT INTO `user` VALUES ('8', '是靠减肥', '15545345', null, null, null);
INSERT INTO `user` VALUES ('9', '发广告', '15545345', null, null, null);
INSERT INTO `user` VALUES ('10', '发发发', '6666666', null, null, null);
INSERT INTO `user` VALUES ('11', '欧阳', '15119651112', null, null, null);
INSERT INTO `user` VALUES ('12', '样嘎', '15515151', null, null, null);
INSERT INTO `user` VALUES ('13', 'fds', '341242432', null, null, null);
INSERT INTO `user` VALUES ('14', 'fr', '3231312', null, null, null);

-- ----------------------------
-- Table structure for videoreview
-- ----------------------------
DROP TABLE IF EXISTS `videoreview`;
CREATE TABLE `videoreview` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `reviewdate` datetime DEFAULT NULL,
  `review` text CHARACTER SET utf8,
  `icon_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `videoid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of videoreview
-- ----------------------------
INSERT INTO `videoreview` VALUES ('1', '不再為你流淚', '北京市', '2017-07-07 17:05:40', ' 外观设计有些超前，需要时间来适应；四驱系统没有变化；脚踏板后面那一片的车厢做工太糊弄事。这些缺点如果能忍受，就可以很坦然的选它了。', 'http://localhost:8080/images/impic.jpg', '10');
INSERT INTO `videoreview` VALUES ('2', '淡妆素描 ㄨ', '东城区', '2017-07-07 17:08:05', '从我们的分析结果来看，全新A4L的综合评分为4.4分', 'http://localhost:8080/images/impic.jpg', '9');
INSERT INTO `videoreview` VALUES ('3', '时光说我们会在一起。', '西城区', '2017-07-07 17:08:11', '从车主的口碑中我们发现，大多数车主对于奥迪A4L的外观设计非常满意。全新A4L使用了奥迪最新的家族式设计语言，其中造型犀利的全LED大灯广受车主好评。', 'http://localhost:8080/images/impic.jpg', '9');
INSERT INTO `videoreview` VALUES ('4', '指日可待╮', '朝阳区', '2017-07-07 17:08:15', '颜值高，识别度高，体态优雅，车身线条处理非常细腻。LED大灯好看又好用，炯炯有神，自动转向更显得非常有灵气，心灵的窗户。车尾流水转向目前还没普及的状况下，吸睛度高，羡煞旁人。', 'http://localhost:8080/images/impic.jpg', '9');
INSERT INTO `videoreview` VALUES ('5', '\r\n浅巷墨漓°', '丰台区', '2017-07-07 17:08:17', '内饰科技感满满，液晶仪表盘，操作简单，中控8.3彩色大屏，完美的MMI操作体验，导航时候触摸输入也很便捷', 'http://localhost:8080/images/impic.jpg', '9');
INSERT INTO `videoreview` VALUES ('6', '\r\n长发及腰静电多@', '石景山区', '2017-07-07 17:08:20', '多功能平底方向盘按键回馈很好，操作简单便捷，定速巡航的位置需要适应一下，电子档把等很有逼格', 'http://localhost:8080/images/impic.jpg', '9');
INSERT INTO `videoreview` VALUES ('7', '\r\n棈樹喖籐', '海淀区', '2017-07-07 17:08:22', '我的同事试驾我车，赞不绝口，个人感觉银色镀铬装饰有些跟内饰不太搭，风尚版的橡木材质的装饰条，跟内饰搭配更和谐，夜间氛围灯也很迷人，算是逼格加分项。', 'http://localhost:8080/images/impic.jpg', '9');
INSERT INTO `videoreview` VALUES ('8', '\r\n致我们终将热死的夏天', '门头沟区', '2017-07-07 17:08:23', '全新A4L在内饰方面可谓是焕然一新，让人眼前一亮', 'http://localhost:8080/images/impic.jpg', '9');
INSERT INTO `videoreview` VALUES ('9', '▍ 阳光1抹抹', '房山区', '2017-07-07 17:08:24', '全新A4L在内饰方面可谓是焕然一新，让', 'http://localhost:8080/images/impic.jpg', '9');

-- ----------------------------
-- Table structure for viewpicture
-- ----------------------------
DROP TABLE IF EXISTS `viewpicture`;
CREATE TABLE `viewpicture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `car_model` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of viewpicture
-- ----------------------------
INSERT INTO `viewpicture` VALUES ('1', 'http://localhost:8080/images/center/1.jpg', 'center', '45 TFSI quanttro 风尚型');
INSERT INTO `viewpicture` VALUES ('2', 'http://localhost:8080/images/center/2.jpg', 'center', '45 TFSI quanttro 风尚型');
INSERT INTO `viewpicture` VALUES ('3', 'http://localhost:8080/images/center/3.jpg', 'center', '45 TFSI quanttro 风尚型');
INSERT INTO `viewpicture` VALUES ('4', 'http://localhost:8080/images/chair/1.jpg', 'chair', '45 TFSI quanttro 风尚型');
INSERT INTO `viewpicture` VALUES ('5', 'http://localhost:8080/images/chair/2.jpg', 'chair', '45 TFSI quanttro 风尚型');
INSERT INTO `viewpicture` VALUES ('6', 'http://localhost:8080/images/chair/3.jpg', 'chair', '45 TFSI quanttro 风尚型');
INSERT INTO `viewpicture` VALUES ('7', 'http://localhost:8080/images/exterior/3.jpg', 'exterior', '45 TFSI quanttro 风尚型');
INSERT INTO `viewpicture` VALUES ('8', 'http://localhost:8080/images/exterior/2.jpg', 'exterior', '45 TFSI quanttro 风尚型');
INSERT INTO `viewpicture` VALUES ('9', 'http://localhost:8080/images/exterior/1.jpg', 'exterior', '45 TFSI quanttro 风尚型');
INSERT INTO `viewpicture` VALUES ('10', 'http://localhost:8080/images/other/1.jpg', 'other', '45 TFSI quanttro 风尚型');
INSERT INTO `viewpicture` VALUES ('11', 'http://localhost:8080/images/other/2.jpg', 'other', '45 TFSI quanttro 风尚型');
INSERT INTO `viewpicture` VALUES ('12', 'http://localhost:8080/images/picinfo/1.jpg', 'picinfo', '45 TFSI quanttro 风尚型');
INSERT INTO `viewpicture` VALUES ('13', 'http://localhost:8080/images/picinfo/2.jpg', 'picinfo', '45 TFSI quanttro 风尚型');
INSERT INTO `viewpicture` VALUES ('14', 'http://localhost:8080/images/picinfo/3.jpg', 'picinfo', '45 TFSI quanttro 风尚型');
INSERT INTO `viewpicture` VALUES ('15', 'http://localhost:8080/images/exterior/3.jpg', 'exterior', 'vw');
