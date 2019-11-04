CREATE DATABASE `dingdong`;					#叮咚打卡app数据库
USE `dingdong`;

CREATE TABLE `user` (#用户表
  `uid` int(11) NOT NULL AUTO_INCREMENT,	#用户id
  `tele` int(11) NOT NULL,					#用户手机号
  `uname` text,								#用户昵称
  `passwd` char(15) NOT NULL,				#用户密码
  `email` text,								#用户邮箱
  `upic` text,								#用户头像
  `uvalue` int(11) DEFAULT NULL,			#用户积分
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `habit` (						#习惯表
  `hid` int(11) NOT NULL AUTO_INCREMENT,	#习惯id
  `uid` int(11) NOT NULL, 					#用户id  
  `hname` text,								#习惯名
  `pic` text,								#习惯图标
  `total_num` int(11) DEFAULT NULL,			#完成一次该习惯需打卡次数
  `finished_num` int(11) DEFAULT NULL,		#完成一次该习惯已打卡次数
  `htype` text,								#习惯属性（学习，运动等）
  `fre` text,								#习惯频率（每日/每周/每月等）
  `htext` text,								#激励自己完成该习惯的话	
  `curdays` int(11) DEFAULT NULL,			#已坚持天数
  `aimdays` int(11) DEFAULT NULL,			#目标坚持天数
  `hvalue` int(11) DEFAULT NULL,			#达到一次目标可获得的分值
  `credate` date DEFAULT NULL,				#习惯创建日期
  PRIMARY KEY (`hid`),
  CONSTRAINT `habit_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `daka` (						#打卡表
  `did` int(11) NOT NULL AUTO_INCREMENT,	#打卡id
  `hid` int(11) NOT NULL, 					#习惯id
  `dakadate` date DEFAULT NULL,				#打卡日期
  `content` text,							#打卡心得
  PRIMARY KEY (`did`),
  KEY `hid` (`hid`),
  CONSTRAINT `daka_ibfk_1` FOREIGN KEY (`hid`) REFERENCES `habit` (`hid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `reward` (						#奖励表
  `rid` int(11) NOT NULL AUTO_INCREMENT,	#奖励id
  `uid` int(11) NOT NULL, 				#用户id  
  `rpic` text,								#奖励图标
  `rcontent` text,							#奖励说明
  `rvalue` int(11) DEFAULT NULL,			#兑换奖励所需分值
  PRIMARY KEY (`rid`),
    CONSTRAINT `daka_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

		