/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : movie_db

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2021-07-24 10:55:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cinema
-- ----------------------------
DROP TABLE IF EXISTS `cinema`;
CREATE TABLE `cinema` (
  `cinema_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `cinema_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '影院名称',
  `cinema_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`cinema_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='电影院表';

-- ----------------------------
-- Records of cinema
-- ----------------------------
INSERT INTO `cinema` VALUES ('1', '北京传奇国际影城', '北京怀柔城区青春路15号四层 ');
INSERT INTO `cinema` VALUES ('2', '北京西部牛仔汽车影院', '北京通州区台湖镇创业园路8号');
INSERT INTO `cinema` VALUES ('3', '乐天新东北影城', '燕郊开发区神威北路精工园西侧乐天玛特商场二楼');
INSERT INTO `cinema` VALUES ('4', '通州区电影院', '通州区西海子西塔胡同1号');
INSERT INTO `cinema` VALUES ('5', '博纳国际影城通州店', '北京市通州区杨庄北里天时名苑14号楼F4-01');
INSERT INTO `cinema` VALUES ('6', '大地数字影院', '北京市昌平区昌崔路203号果岭假日广场四楼大地数字影院');
INSERT INTO `cinema` VALUES ('7', '昌平保利影剧院', '北京市昌平区鼓楼南街佳莲时代广场四层');
INSERT INTO `cinema` VALUES ('8', '北京万达电影城天通苑店', '北京昌平区 立汤路186号龙德广场五层');
INSERT INTO `cinema` VALUES ('9', '星美国际影城·北京回龙观店', '北京市昌平区回龙观西大街111号华联商厦三层');
INSERT INTO `cinema` VALUES ('10', '中影国际影城', '北京市昌平区北清路1号永旺国际商城3楼');
INSERT INTO `cinema` VALUES ('11', '北京新华国际影城（良乡店）', '北京市房山区良乡北关西路14号华冠购物中心五层');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '评论人编号',
  `comment_content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '评论内容',
  `movie_id` bigint DEFAULT NULL COMMENT '电影编号',
  `comment_time` datetime DEFAULT NULL COMMENT '评论时间',
  `comment_score` int DEFAULT NULL COMMENT '评分 最高10分',
  PRIMARY KEY (`comment_id`),
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `movie_id` (`movie_id`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for hall
-- ----------------------------
DROP TABLE IF EXISTS `hall`;
CREATE TABLE `hall` (
  `hall_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `hall_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '放映厅名称',
  `hall_capacity` int DEFAULT NULL COMMENT '放映厅容量',
  `cinema_id` bigint DEFAULT NULL COMMENT '影院编号',
  PRIMARY KEY (`hall_id`),
  KEY `cinema_id` (`cinema_id`) USING BTREE,
  CONSTRAINT `hall_ibfk_1` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`cinema_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='放映厅';

-- ----------------------------
-- Records of hall
-- ----------------------------
INSERT INTO `hall` VALUES ('30', '一号厅', '50', '1');
INSERT INTO `hall` VALUES ('31', '一号厅', '50', '2');
INSERT INTO `hall` VALUES ('32', '二号厅', '150', '3');
INSERT INTO `hall` VALUES ('33', '馨华厅', '64', '5');
INSERT INTO `hall` VALUES ('34', '大地厅', '150', '10');
INSERT INTO `hall` VALUES ('35', '三号厅', '120', '7');
INSERT INTO `hall` VALUES ('36', '日月厅', '65', '6');
INSERT INTO `hall` VALUES ('37', '日月厅', '156', '4');
INSERT INTO `hall` VALUES ('38', '日月厅', '64', '7');
INSERT INTO `hall` VALUES ('39', '日月厅', '100', '11');
INSERT INTO `hall` VALUES ('40', '吉祥厅', '156', '6');
INSERT INTO `hall` VALUES ('41', '测试樱桃', '50', '9');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色',
  `state` int DEFAULT '1' COMMENT '账号状态1正常  0冻结',
  `memo` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'admin', '123456', '13311112222', '22@163.com', '超级管理员', '1', null);
INSERT INTO `manager` VALUES ('8', 'root', '123456', '15735111403', '2578908933@qq.com', '售票人员', '1', '');
INSERT INTO `manager` VALUES ('9', 'sa', '123456', '13312345678', '1123@163.com', '管理员', '1', '好');
INSERT INTO `manager` VALUES ('10', 'scott', '123456', '13312345678', '1123@163.com', '管理员', '1', '好');
INSERT INTO `manager` VALUES ('11', 'xp', '159847', '13312341234', '123456789@qq.com', '管理员', '1', 'hello');
INSERT INTO `manager` VALUES ('12', 'xh', '123456', '15735111403', '111@qq.com', '售票人员', '1', '测试修改');
INSERT INTO `manager` VALUES ('22', '123456', '123456', '15735111403', '2578908933@qq.com', '管理员', '0', '大萨达大所大多撒所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所阿诗丹顿多多多多多多多多多多多多多');
INSERT INTO `manager` VALUES ('23', '', '123456', '15735111403', '2578908933@qq.com', '售票人员', '1', '');
INSERT INTO `manager` VALUES ('25', '123456687', '123', '123', '123', '售票人员', '1', '123');

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `movie_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `movie_cn_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电影名',
  `movie_fg_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电影外名',
  `movie_actor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '饰演人员',
  `movie_director` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '导演',
  `movie_detail` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '电影简介',
  `movie_duration` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电影时长',
  `movie_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电影类型',
  `movie_score` float(10,1) DEFAULT NULL COMMENT '评分',
  `movie_boxOffice` float(10,2) DEFAULT NULL COMMENT '票房',
  `movie_commentCount` bigint DEFAULT '0' COMMENT '评论条数',
  `movie_releaseDate` datetime DEFAULT NULL COMMENT '上映时间',
  `movie_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '海报图',
  `movie_country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '制片商',
  `movie_state` int DEFAULT NULL COMMENT '电影状态 1 上映 0下架',
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=571 DEFAULT CHARSET=utf8 COMMENT='电影表';

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES ('558', '123456', '君の名は', '神木隆之介、上白石萌音', '新海诚', '故事发生的地点是在每千年回归一次的彗星造访过一个月之前，日本飞驒市的乡下小町糸守町。在这里女高中生三叶每天都过着忧郁的生活，而她烦恼的不光有担任町长的父亲所举行的选举运动，还有家传神社的古老习俗。在这个小小的町，周围都只是些爱瞎操心的老人。为此三叶对于大都市充满了憧憬。', '107 分钟', '动漫', '9.1', '250.30', '99451', '2021-07-22 00:00:00', 'images/movie/1.jpg', '日韩', '1');
INSERT INTO `movie` VALUES ('559', '哪吒之魔童降世', 'Ne Zha', '吕艳婷 囧森瑟夫 瀚墨 陈浩 绿绮', '饺子', '《哪吒之魔童降世》是由霍尔果斯彩条屋影业有限公司出品的动画电影，由饺子执导兼编剧，吕艳婷、囧森瑟夫、瀚墨、陈浩、绿绮、张珈铭、杨卫担任主要配音。该片改编自中国神话故事，讲述了哪吒虽“生而为魔”却“逆天而行斗到底”的成长经历的故事。该片于2019年7月26日在中国内地上映。2019年9月6日，第十二届中国国际漫画节开幕式暨第16届中国动漫金龙奖颁奖大会于广州举行。', '110 分钟', '动漫', '8.9', '64.00', '48216', '2019-07-26 00:00:00', 'images/movie/2.jpg', '国产', '1');
INSERT INTO `movie` VALUES ('560', '罗小黑战记', 'The Legend of Hei', '山新、刘明月、郝祥海、皇贞季、杨凝', 'MTJJ', '《罗小黑战记》是由MTJJ执导的中国动画电影，讲述了猫妖罗小黑因为家园被破坏，开始了它的流浪之旅，在一次偶然中遇到了无限，一人一猫展开了一段奇幻的冒险之旅。', '101 分钟', '动漫', '7.8', '3.11', '4548', '2019-09-20 00:00:00', 'images/movie/3.jpg', '欧美', '1');
INSERT INTO `movie` VALUES ('561', '蜘蛛侠:平行宇宙', 'Spider-Man: Into the Spider-Verse', '沙梅克·摩尔、杰克·M·约翰森、海莉·斯坦菲尔德', '鲍勃·佩尔西凯蒂', '《蜘蛛侠：平行宇宙》是由索尼电影娱乐公司、漫威娱乐等公司联合出品，鲍勃·佩尔西凯蒂、彼得·拉姆齐、罗德尼·罗斯曼联合执导，沙梅克·摩尔、杰克·M·约翰森、海莉·斯坦菲尔德等配音的动画电影。该片讲述了蜘蛛侠“彼得·帕克”壮烈牺牲后，普通高中生迈尔斯·莫拉斯如何师从成长为新一代超级英雄，以及和从其它平行宇宙中穿越而来的六位蜘蛛侠首次同框大银幕，对抗蜘蛛侠宇宙最强反派的故事', '116 分钟', '搞笑', '9.4', '247.00', '4648', '2016-06-08 00:00:00', 'images/movie/4.jpg', '欧美', '1');
INSERT INTO `movie` VALUES ('562', '航海王：狂热行动', 'ONE PIECE STAMPEDE', '田中真弓、中井和哉、冈村明美、山口胜平、平田广明、大谷育江、山口由里子、矢尾一树、长岛雄一、矶部勉', '大塚隆史', '《航海王：狂热行动》是东映动画制作发行的剧场版动画，于2019年8月9日在日本上映，2019年10月18日在中国内地上映。该片是《航海王》系列的第十四部剧场版，也是由尾田荣一郎负责原作和监修的航海王20周年纪念剧场版动画作品。', '101 分钟', '搞笑', '9.1', '651.00', '2547', '2019-07-18 00:00:00', 'images/movie/5.jpg', '日韩', '1');
INSERT INTO `movie` VALUES ('563', '白蛇：缘起', 'White Snake', '未知', '黄家康、赵霁', '晚唐年间，国师发动民众大量捕蛇。前去刺杀国师的白蛇意外失忆，被捕蛇村少年阿宣救下。为帮助少女找回记忆，两人踏上了一段冒险旅程。过程中两人感情迅速升温，但少女蛇妖的身份也逐渐显露，另一边国师与蛇族之间不可避免的大战也即将打响，两人的爱情面临着巨大的考验', '95 分钟', '爱情', '9.4', '123.00', '15974', '2019-07-16 00:00:00', 'images/movie/6.jpg', '国产', '1');
INSERT INTO `movie` VALUES ('564', '大鱼海棠', 'Bigfish & Begonia', '季冠霖  苏尚卿', '梁旋', '大鱼海棠》由梁旋、张春执导，季冠霖；苏尚卿；许魏洲；金士杰；潘淑兰；李天湖 ；刘校妤 ；姜广涛 ；张媛媛；宝木中阳等人配音的动画电影。是彼岸天文化有限公司、北京光线影业有限公司、霍尔果斯彩条屋影业有限公司联合出品的动画电影。电影讲述了掌管海棠花生长的少女椿为报恩而努力复活人类男孩“鲲”的灵魂，在本是天神的湫帮助下与彼此纠缠的命运斗争的故事。', '105 分钟', '恐怖', '8.4', '1.24', '13576', '2016-07-07 00:00:00', 'images/movie/7.jpg', '国产', '1');
INSERT INTO `movie` VALUES ('565', '驯龙高手', 'How to Train Your Dragon', '杰伊·巴鲁切尔，杰拉德·巴特勒，亚美莉卡·费雷拉', '迪恩·德布洛斯，克里斯·桑德斯', '《驯龙高手》由梦工厂动画制作，于2010年3月26日上映。其故事内容改编自葛蕾熙达·柯维尔于2003年所作的同名童书《如何驯服你的龙》。负责担任电影的配音演员有杰伊·巴鲁切尔、亚美莉卡·费雷拉、乔纳·希尔、克里斯托夫·梅兹-普莱瑟、克雷格·费格森以及杰拉德·巴特勒等人。故事讲述一个住在博克岛的维京少年希卡普，他必须通过驯龙测验，才能正式成为维京勇士。', '98分钟', '抗战', '8.4', '4.94', '21546', '2018-07-05 00:00:00', 'images/movie/8.jpg', '欧美', '1');
INSERT INTO `movie` VALUES ('566', '神偷奶爸', 'Despicable Me', '史蒂夫·卡瑞尔、杰森·席格尔', '克里斯·雷纳德、皮埃尔·柯芬', '神偷奶爸》是由环球影业及Illumination娱乐公司制作，克里斯·雷诺德和皮埃尔·科芬执导，史蒂夫·卡瑞尔、杰森·赛格尔、拉塞尔·布兰德、朱莉·安德鲁斯等人配音的喜剧3D动画片，于2010年7月9日在美国上映。\n该片讲述了主人公格鲁策划了一出完美的计划，图谋把月亮偷到手，却不料盗取月亮的收缩射线枪被新贼维克托抢走。为了夺回收缩射线枪，格鲁决定领养三位孤儿，利用她们进入维克托戒备森严的城堡兜售饼干的机会实施偷盗的故事', '95 分钟', '搞笑', '7.4', '4.20', '95134', '2018-07-05 00:00:00', 'images/movie/9.jpg', '欧美', '1');
INSERT INTO `movie` VALUES ('567', '冰雪奇缘', 'Frozen', '克里斯汀·贝尔 伊迪娜·门泽尔 乔纳森·格罗夫', '克里斯·巴克 珍妮弗·李', '《冰雪奇缘》（Frozen）是2013年迪士尼出品3D的动画电影，由克里斯·巴克、珍妮弗·李执导，克里斯汀·贝尔、伊迪娜·门泽尔等参与主要配音。该片于2013年11月27日在美国上映 [1]  。\n该片改编自安徒生童话《白雪皇后》，讲述小国阿伦黛尔因一个魔咒永远地被冰天雪地覆盖，为了寻回夏天，安娜公主和山民克里斯托夫以及他的驯鹿搭档组队出发，展开一段拯救王国的历险', '102 分钟', '爱情', '9.1', '11.54', '125466', '2010-07-07 00:00:00', 'images/movie/10.jpg', '欧美', '1');
INSERT INTO `movie` VALUES ('568', '功夫熊猫', 'Kung Fu Panda', '杰克·布莱克、达斯汀·霍夫曼、成龙、安吉丽娜·朱莉、刘玉玲、塞斯·罗根', '梅丽·莎科布', '《功夫熊猫》是一部以中国功夫为主题的美国动作喜剧电影，影片以中国古代为背景，其景观、布景、服装以至食物均充满中国元素。故事讲述了一只笨拙的熊猫立志成为武林高手的故事。该片由约翰·斯蒂芬森和马克·奥斯本执导，梅丽·莎科布制片。杰克·布莱克、成龙、达斯汀·霍夫曼、安吉丽娜·朱莉、刘玉玲、塞斯·罗根、大卫·克罗素和伊恩·麦西恩等配音。', '92 分钟', '恐怖', '9.4', '1.30', '15644', '2008-07-10 00:00:00', 'images/movie/11.jpg', '欧美', '1');
INSERT INTO `movie` VALUES ('569', '哆啦A梦：伴我同行', 'ドラえもん', '水田山葵、大原惠、嘉数由美、木村昴、关智一', '八木龙一，山崎贵', '《哆啦A梦：伴我同行》是一部纪念《哆啦A梦》之父藤子·F·不二雄诞辰80周年的3D动画电影，由八木龙一、山崎贵导演执导，由东宝株式会社出品。该片讲述了哆啦A梦圆满完成了他的使命，启程返回22世纪，大雄该如何以一己之力实现他那来之不易的幸福未来。该片于2014年8月8日在日本上映，2015年5月28日在中国内地上映。', '95 分钟', '爱情', '9.4', '83.80', '516486', '2014-05-07 00:00:00', 'images/movie/12.jpg', '日韩', '1');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号',
  `user_id` bigint DEFAULT NULL COMMENT '订单用户',
  `schedule_id` bigint DEFAULT NULL COMMENT '场次编号',
  `order_position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '座位位置',
  `order_state` int DEFAULT NULL COMMENT '订单状态',
  `order_price` int DEFAULT NULL COMMENT '订单价格',
  `order_time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `schedule_id` (`schedule_id`) USING BTREE,
  CONSTRAINT `orderinfo_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orderinfo_ibfk_2` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`schedule_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of orderinfo
-- ----------------------------

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `schedule_id` bigint NOT NULL AUTO_INCREMENT COMMENT '场次编号',
  `hall_id` bigint DEFAULT NULL COMMENT '放映厅编号',
  `movie_id` bigint DEFAULT NULL COMMENT '电影编号',
  `schedule_startTime` datetime DEFAULT NULL COMMENT '放映时间',
  `schedule_price` int DEFAULT NULL COMMENT '价格',
  `schedule_remain` int DEFAULT NULL COMMENT '剩余票数',
  `schedule_state` int DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`schedule_id`),
  KEY `hall_id` (`hall_id`) USING BTREE,
  KEY `movie_id` (`movie_id`) USING BTREE,
  CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`hall_id`) REFERENCES `hall` (`hall_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `schedule_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='场次表';

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('48', '30', '558', '2021-07-24 02:23:42', '36', '100', '1');
INSERT INTO `schedule` VALUES ('49', '31', '559', '2021-07-21 00:00:00', '34', '100', '1');
INSERT INTO `schedule` VALUES ('50', '37', '559', '2021-07-24 00:00:00', '34', '50', '1');
INSERT INTO `schedule` VALUES ('51', '33', '561', '2021-07-24 20:00:00', '40', '136', '1');
INSERT INTO `schedule` VALUES ('52', '32', '563', '2021-07-25 00:00:00', '40', '34', '1');
INSERT INTO `schedule` VALUES ('53', '31', '561', '2021-07-24 00:00:00', '67', '120', '1');
INSERT INTO `schedule` VALUES ('54', '40', '564', '2021-08-21 00:00:00', '34', '35', '1');
INSERT INTO `schedule` VALUES ('55', '40', '566', '2021-07-24 23:00:00', '43', '65', '1');
INSERT INTO `schedule` VALUES ('56', '37', '559', '2021-07-09 00:00:00', '60', '60', '1');
INSERT INTO `schedule` VALUES ('57', '30', '558', '2021-07-19 00:00:00', '666', '666', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `user_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮件',
  `user_role` int DEFAULT NULL COMMENT '角色',
  `user_headImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `user_state` int DEFAULT '1' COMMENT '账号状态 1正常0冻结',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('27', 'user_002', '1234567', '17835766143', '2578908933@qq.com', '0', 'images/UserHead/head.png', '1');
INSERT INTO `user` VALUES ('31', 'user_009', '123456', '17835766143', '2578908933@qq.com', '1', 'images/User/1626941030000.jpg', '1');
INSERT INTO `user` VALUES ('32', '123456', '123456', '15735111403', '2578908933@qq.com', '0', 'images/User/img.png', '1');
INSERT INTO `user` VALUES ('33', '1234567', '123456', '15735111403', '257890933@qq.com', '0', 'images/User/img.png', '1');

-- ----------------------------
-- View structure for hall_cinema
-- ----------------------------
DROP VIEW IF EXISTS `hall_cinema`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `hall_cinema` AS select `hall`.`hall_id` AS `hall_id`,`hall`.`hall_name` AS `hall_name`,`hall`.`hall_capacity` AS `hall_capacity`,`hall`.`cinema_id` AS `cid`,`cinema`.`cinema_name` AS `cinema_name`,`cinema`.`cinema_address` AS `cinema_address` from (`cinema` join `hall` on((`hall`.`cinema_id` = `cinema`.`cinema_id`))) ;

-- ----------------------------
-- View structure for schedule_movie_hall_cinema
-- ----------------------------
DROP VIEW IF EXISTS `schedule_movie_hall_cinema`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `schedule_movie_hall_cinema` AS select `schedule`.`schedule_id` AS `schedule_id`,`schedule`.`hall_id` AS `hall_id`,`schedule`.`movie_id` AS `movie_id`,`schedule`.`schedule_startTime` AS `schedule_startTime`,`schedule`.`schedule_price` AS `schedule_price`,`schedule`.`schedule_remain` AS `schedule_remain`,`schedule`.`schedule_state` AS `schedule_state`,`hall`.`hall_name` AS `hall_name`,`movie`.`movie_cn_name` AS `movie_cn_name`,`cinema`.`cinema_name` AS `cinema_name` from (((`schedule` join `hall` on((`schedule`.`hall_id` = `hall`.`hall_id`))) join `movie` on((`schedule`.`movie_id` = `movie`.`movie_id`))) join `cinema` on((`hall`.`cinema_id` = `cinema`.`cinema_id`))) ;
