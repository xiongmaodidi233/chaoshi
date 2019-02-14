﻿# Host: localhost  (Version: 5.5.19)
# Date: 2017-12-19 09:35:23
# Generator: MySQL-Front 5.3  (Build 4.214)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "huiyuan"
#

DROP TABLE IF EXISTS `huiyuan`;
CREATE TABLE `huiyuan` (
  `kehuNum` varchar(255) DEFAULT NULL,
  `kehuName` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `dizhi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "huiyuan"
#

INSERT INTO `huiyuan` VALUES ('X0001','李艳玮','15152046970','杭州市余杭区碧天家园3栋202室'),('X0002','李晟才','15152048157','杭州市拱墅区梅艳路小区201室'),('X0003','李恽映','13905223626','杭州市拱墅区梅艳路小区402室'),('X0004','李辰韵','13905224475','凤起路519号3幢一层'),('X0005','丁方豪','13905222684','杭州市上城区解放路156号'),('X0006','李希生','15152040192','杭州市余杭区碧天家园3栋202室'),('X0007','李国伟','13905228422','杭州市拱墅区梅艳路小区201室'),('X0008','孙远高','13905220067','杭州市拱墅区梅艳路小区402室'),('X0009','李秀江','13905224129','凤起路519号3幢一层'),('X0010','李欣颜','13905221565','杭州市上城区解放路156号'),('X0011','李一钰','15152049847','杭州市余杭区碧天家园3栋202室'),('X0012','刘辛华','15895255331','杭州市拱墅区梅艳路小区201室'),('X0013','李川','13905229601','杭州市拱墅区梅艳路小区402室'),('X0014','李雷','15152044824','凤起路519号3幢一层'),('X0015','李蛹','15152043958','杭州市上城区解放路156号'),('X0016','李煜启','15895254891','杭州市余杭区碧天家园3栋202室'),('X0017','李伟','15895257290','杭州市拱墅区梅艳路小区201室'),('X0018','吴瑜刈','13905226648','杭州市拱墅区梅艳路小区402室'),('X0019','李常杰','15895258257','凤起路519号3幢一层'),('X0020','李蒙','15152041019','杭州市上城区解放路156号'),('X0021','李诗晴','13905221000','杭州市余杭区碧天家园3栋202室'),('X0022','李远','15152041816','杭州市拱墅区梅艳路小区201室'),('X0023','李姜芫','15152044476','杭州市拱墅区梅艳路小区402室'),('X0024','李泓翔','13905222619','凤起路519号3幢一层'),('X0025','李进锋','15895256206','杭州市上城区解放路156号'),('X0026','孙为敏','15895257823','杭州市余杭区碧天家园3栋202室'),('X0027','李开心','15152041672','杭州市拱墅区梅艳路小区201室'),('X0028','李皓茗','15152048740','杭州市拱墅区梅艳路小区402室'),('X0029','许可熠','15895250681','凤起路519号3幢一层'),('X0030','李兆峰','15895251334','杭州市上城区解放路156号'),('X0031','李浯','15895256923','杭州市余杭区碧天家园3栋202室'),('X0032','李海必','15895250673','杭州市拱墅区梅艳路小区201室'),('X0033','李雨充','15152045901','杭州市拱墅区梅艳路小区402室'),('X0034','李飞凤','15152045125','凤起路519号3幢一层'),('X0035','李子跃','15152041056','杭州市上城区解放路156号'),('X0036','李鹏赫','13905224340','杭州市余杭区碧天家园3栋202室'),('X0037','许戈','15895251491','杭州市拱墅区梅艳路小区201室'),('X0038','李家沌','15152045740','杭州市拱墅区梅艳路小区402室'),('X0039','许瑜斌','13905222103','凤起路519号3幢一层'),('X0040','李傈吏','15152049837','杭州市余杭区碧天家园3栋202室'),('X0041','李丽波','15895250558','杭州市拱墅区梅艳路小区201室'),('X0042','李祥芝','15152045652','杭州市拱墅区梅艳路小区402室'),('X0043','李波波','15152044041','杭州市余杭区碧天家园3栋202室'),('X0044','许正茂','15152049218','杭州市拱墅区梅艳路小区201室'),('X0045','李致成','13905226591','杭州市拱墅区梅艳路小区402室'),('X0046','李之','13905224447','杭州市余杭区碧天家园3栋202室'),('X0047','李永安','15152047387','杭州市拱墅区梅艳路小区201室'),('X0048','李佳军','15152049477','杭州市拱墅区梅艳路小区402室'),('X0049','李壁遥','13905229415','凤起路519号3幢一层'),('X0050','李方芹','13905227688','杭州市上城区解放路156号');

#
# Structure for table "kucun"
#

DROP TABLE IF EXISTS `kucun`;
CREATE TABLE `kucun` (
  `shangpinNum` varchar(255) DEFAULT '0',
  `kucunshuliang` double DEFAULT NULL,
  `rukushijian` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "kucun"
#

INSERT INTO `kucun` VALUES ('C001',14,'2017年1月22日'),('C002',27,'2017年4月27日'),('C003',8,'2017年5月24日'),('C004',36,'2017年6月8日'),('C005',41,'2017年2月11日'),('C006',46,'2017年6月18日'),('C007',24,'2017年5月19日'),('C008',11,'2017年2月26日'),('C009',42,'2017年3月11日'),('C010',28,'2017年2月19日'),('D001',35,'2017年2月10日'),('D002',32,'2017年6月10日'),('D003',5,'2017年6月25日'),('D004',16,'2017年3月15日'),('D005',34,'2017年5月21日'),('D006',30,'2017年4月15日'),('D007',1,'2017年2月20日'),('D008',29,'2017年1月1日'),('D009',10,'2017年3月2日'),('D010',10,'2017年1月2日'),('D011',50,'2017年3月13日'),('E001',7,'2017年1月18日'),('E002',27,'2017年3月29日'),('E003',43,'2017年3月26日'),('E004',12,'2017年1月29日'),('E005',1,'2017年2月11日'),('E006',46,'2017年2月15日'),('E007',4,'2017年6月2日'),('E008',50,'2017年1月4日'),('E009',16,'2017年3月28日'),('E010',23,'2017年6月25日'),('E011',25,'2017年6月24日'),('E012',18,'2017年1月2日'),('E013',11,'2017年1月14日'),('E014',3,'2017年4月3日'),('E015',48,'2017年2月7日'),('E016',6,'2017年3月23日'),('E017',14,'2017年1月29日'),('E018',9,'2017年1月21日'),('G001',42,'2017年3月8日'),('G002',16,'2017年2月1日'),('G003',27,'2017年3月25日'),('G004',29,'2017年4月28日'),('G005',39,'2017年6月24日'),('G006',9,'2017年1月9日');

#
# Structure for table "shangpin"
#

DROP TABLE IF EXISTS `shangpin`;
CREATE TABLE `shangpin` (
  `shangpinNum` varchar(255) DEFAULT NULL,
  `shangpinId` varchar(255) DEFAULT NULL,
  `leixing` varchar(255) DEFAULT NULL,
  `pinpai` varchar(255) DEFAULT NULL,
  `jinjia` double DEFAULT '0',
  `shoujia` double DEFAULT NULL,
  `zhekou` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "shangpin"
#

INSERT INTO `shangpin` VALUES ('C001','光明牛奶','饮品','光明',1.5,2.5,0.95),('C002','蒙牛牛奶','饮品','蒙牛',1.5,2.5,0.95),('C003','伊利牛奶','饮品','伊利',1.5,2.5,0.95),('C004','旺仔牛奶','饮品','旺仔 ',2,4,0.95),('C005','尖叫','饮品','农夫山泉',2,4,0.9),('C006','水','饮品','农夫山泉',0.8,1.5,0.95),('C007','可口可乐','饮品','可口可乐',1.5,2.5,0.95),('C008','雪碧','饮品','可口可乐',1.5,2.5,0.9),('C009','百事可乐','饮品','百事',1.5,2.5,0.95),('C010','胃动力 ','饮品','乐享',2,4,0.95),('D001','干脆面','食品','小浣熊',0.5,1,0.95),('D002','干脆面','食品','魔法士',0.2,0.5,0.95),('D003','牛肉面 ','食品','康师傅',1.5,3,0.9),('D004','笋干老鸭面','食品','康师傅',1.5,3,0.95),('D005','干拌面 ','食品','UFO',2,3.5,0.95),('D006','火腿肠 ','食品','双汇 ',0.5,1,0.95),('D007','鸡肉肠 ','食品','双汇 ',0.5,1,0.95),('D008','王子饼干','食品','卡夫',2,3,0.95),('D009','薯片','食品','乐事',2,3,0.95),('D010','薯片','食品','可比克',2,3,0.95),('D011','薯片','食品','上好佳',2,3,0.95),('E001','毛巾','日用品','御美',4,8,0.95),('E002','毛巾','日用品','洁丽雅',4,8,0.95),('E003','牙膏','日用品','黑人',3,6,0.95),('E004','牙膏','日用品','佳洁士 ',3,5,0.95),('E005','牙膏','日用品','高露洁',3,5,0.95),('E006','牙膏','日用品','中华',5,9,0.9),('E007','牙刷','日用品','佳洁士 ',2,3,0.95),('E008','牙刷','日用品','高露洁',2,4,0.95),('E009','牙刷','日用品','中华',2,4,0.95),('E010','杯子','日用品','膳魔师',5,8,0.95),('E011','杯子','日用品','虎牌Tiger',5,8,0.95),('E012','杯子','日用品','思宝SIBAO',10,15,0.95),('E013','洗衣粉','日用品','雕牌',8,12,0.95),('E014','洗发水','日用品','飘柔',15,20,0.95),('E015','洗发水','日用品','清扬',15,20,0.9),('E016','洗发水','日用品','霸王',20,30,0.95),('E017','电池','日用品','南孚',1,2,0.95),('E018','电池','日用品','双鹿',1,2,0.95),('F001','吹风机','电器','松下',50,100,0.95),('F002','吹风机','电器','飞科',30,60,0.9),('F003','吹风机','电器','博朗',40,80,0.95),('F004','剃须刀','电器','博朗',50,80,0.95),('F005','剃须刀','电器','飞科',40,70,0.95),('F006','剃须刀','电器','松下',30,60,0.95),('H001','铅笔','文具','派克',0.3,0.5,0.95),('H002','铅笔','文具','得力',0.4,0.5,0.95),('H003','铅笔','文具','施耐德',0.35,0.5,0.95),('H004','钢笔','文具','派克',2,3,0.95),('H005','钢笔','文具','得力',2.5,4,0.95),('H006','钢笔','文具','施耐德',2.5,4,0.95),('H007','橡皮','文具','得力',0.5,1,0.95),('1','1','1','1',1,1,1),('2','2','2','2',2,2,2),('H008','水果','文具','得力',0.2,1,2),('1','1','1','1',1,1,2);

#
# Structure for table "xiaoshou"
#

DROP TABLE IF EXISTS `xiaoshou`;
CREATE TABLE `xiaoshou` (
  `xiaoshoudanhao` varchar(255) DEFAULT NULL,
  `shanpinNum` varchar(255) DEFAULT NULL,
  `kehuNum` varchar(255) DEFAULT NULL,
  `xiaoshoushuliang` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "xiaoshou"
#

INSERT INTO `xiaoshou` VALUES ('Z001','C001','X001',7),('Z001','C002','X001',46),('Z002','C003','X002',26),('Z002','C004','X002',14),('Z003','C005','X003',3),('Z004','C006','X004',16),('Z005','C007','X005',34),('Z006','C008','X006',19),('Z007','C009','X007',20),('Z008','C010','X008',46),('Z008','D001','X008',14),('Z009','D002','X009',22),('Z009','D003','X009',29),('Z010','D004','X010',41),('Z010','D005','X010',43),('Z010','D006','X010',20),('Z010','D007','X010',16),('Z011','D008','X011',17),('Z011','D009','X011',3),('Z012','D010','X012',1),('Z012','D011','X012',49),('Z013','E001','X013',21),('Z013','E002','X013',17),('Z014','E003','X014',24),('Z014','E004','X014',3),('Z014','E005','X014',31),('Z014','E006','X014',23),('Z015','E007','X015',26),('Z015','E008','X015',49),('Z015','E009','X015',35),('Z015','E010','X015',15),('Z016','E011','X016',40),('Z016','E012','X016',18),('Z016','E013','X016',2),('Z017','E014','X017',31),('Z018','E015','X018',9),('Z018','E016','X018',19),('Z018','E017','X018',48),('Z019','E018','X019',33);

#
# Structure for table "zhigong"
#

DROP TABLE IF EXISTS `zhigong`;
CREATE TABLE `zhigong` (
  `zhigongNum` varchar(255) DEFAULT NULL,
  `zhigongName` varchar(255) DEFAULT NULL,
  `zhiwu` varchar(255) DEFAULT NULL,
  `zhigongPhone` varchar(255) DEFAULT NULL,
  `zhigongdizhi` varchar(255) DEFAULT NULL,
  `jiguan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "zhigong"
#

INSERT INTO `zhigong` VALUES ('G001','德化','店经理','15152043588','杭州市余杭区碧天家园3栋202室','温州'),('G002','李像仪','副经理','15895254728','杭州市拱墅区梅艳路小区201室','四川'),('G003','李薇','收银员','15152047906','杭州市拱墅区梅艳路小区402室','温州'),('G004','李立','促销员','15152047230','凤起路519号3幢一层','杭州'),('G005','李芮彬','理货员','13905229586','杭州市上城区解放路156号','四川'),('G006','丁岭兵','收银员','13905224670','杭州市余杭区碧天家园3栋202室','安徽'),('G007','李利军','保安','13905227998','杭州市余杭区碧天家园3栋202室','安徽'),('G008','李雨竺','理货员','15895258226','杭州市拱墅区梅艳路小区201室','绍兴'),('G009','李意如','售后服务员','15895251645','杭州市拱墅区梅艳路小区402室','四川'),('G010','丁志权','接货员','15895256780','凤起路519号3幢一层','杭州'),('G011','李朔珲','接货员','13905224852','杭州市上城区解放路156号','四川'),('G012','孙宁宁','会计','13905228158','杭州市余杭区碧天家园3栋202室','绍兴');
