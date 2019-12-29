CREATE DATABASE `dingdong`;					#叮咚打卡app数据库
USE `dingdong`;
CREATE TABLE `user` (#用户表
  `uid` int(11) NOT NULL AUTO_INCREMENT,	#用户id
  `tele` int(11) NOT NULL,					#用户手机号
  `uname` text,								#用户昵称
  `passwd` char(15) NOT NULL,				#用户密码
  `uvalue` int(11) DEFAULT NULL,			#用户积分
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `habit` (						#习惯表
  `hid` int(11) NOT NULL AUTO_INCREMENT,	#习惯id
  `uid` int(11) not null,
  `hname` text,								#习惯名
  pic text,#习惯图标
  `total_num` int(11),						#完成一次该习惯需打卡次数
  `finished_num` int(11) DEFAULT NULL,		#完成一次该习惯已打卡次数
  `htext` text,								#激励自己完成该习惯的话	
  `hvalue` int(11) DEFAULT NULL,			#达到一次目标可获得的分值
  PRIMARY KEY (`hid`),
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `dingdong`.`user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `reward` (						#奖励表
  `rid` int(11) NOT NULL AUTO_INCREMENT,	#奖励id
  `rpic` text,								#奖励图标
  `rcontent` text,							#奖励说明
  `rvalue` int(11) DEFAULT NULL,			#兑换奖励所需分值
  `uid` int(11),
  PRIMARY KEY (`rid`)
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ur` (
  `user` int(11) DEFAULT NULL,
  `reward` int(11) DEFAULT NULL,
  `urid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`urid`),
  KEY `u_idx` (`user`),
  KEY `r_idx` (`reward`),
  KEY `FKE9D446FB124` (`reward`),
  KEY `FKE9D40D0E3DC` (`user`),
  CONSTRAINT `FKE9D40D0E3DC` FOREIGN KEY (`user`) REFERENCES `user` (`uid`),
  CONSTRAINT `FKE9D446FB124` FOREIGN KEY (`reward`) REFERENCES `reward` (`rid`),
  CONSTRAINT `r` FOREIGN KEY (`reward`) REFERENCES `reward` (`rid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `u` FOREIGN KEY (`user`) REFERENCES `user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



INSERT INTO `dingdong`.`reward` (`rid`, `rpic`, `rcontent`, `rvalue`) VALUES ('4', '1.吃了辣的东西，感觉就要被辣死了，就往嘴里放上少许盐，含一下，吐掉，漱下口，就不辣了；
2.牙齿黄，可以把花生嚼碎后含在嘴里，并刷牙三分钟，很有效；
3.若有小面积皮肤损伤或者烧伤、烫伤，抹上少许牙膏，可立即止血止痛；
4.经常装茶的杯子里面留下难看的茶渍，用牙膏洗之，非常干净；
5.仰头点眼药水时微微张嘴，这样眼睛就不会乱眨了；
6.嘴里有溃疡，就用维生素C贴在溃疡处，等它溶化后溃疡基本就好了；
7.眼睛进了小灰尘，闭上眼睛用力咳嗽几下，灰尘就会自己出来；
8.洗完脸后，用手指沾些细盐在鼻头两侧轻轻按摩，然后再用清水冲洗，黑头和粉刺就会清除干净，毛细孔也会变小；9.刚刚被蚊子咬完时，涂上肥皂就不会痒了；
10.如果嗓子、牙龈发炎了，在晚上把西瓜切成小块，沾着盐吃，记得一定要是晚上，当时症状就会减轻，第二天就好了。', '你不能不知道的10条健康小常识', '10');



INSERT INTO `dingdong`.`reward` (`rid`, `rpic`, `rcontent`, `rvalue`) VALUES ('2', '1、记者采访一位老奶奶!记者问:“你对在城市随便燃放鞭炮这个问题您怎么看啊?”老奶奶:“我还能怎么看啊?就是爬窗户上看……”

2、医生问病人是怎么骨折的。病人说，我觉得鞋里有沙子，就扶着电线杆抖鞋。TMD有个混蛋经过那里，以为我触电了，便抄起木棍给了我两棍子!

3、【麦兜的爱情观】1、爱情就像便便;来了挡也挡不住。2、爱情就像便便;水一冲就再也回不来了。3、爱情就像便便;每一次都一样，又不大一样。4、爱情就像便便;有时候努力了很久却只是个屁!

4、一女新婚第二天头晕去看医生，医生问:何故? 答曰:吃了20片避孕药。 又问:为何不按说明书用药? 又答:就是按说明书用药的，说明上写着一次一片。医生……

5、联通推出iphone沃信来对抗微信【据知情人士透露】联通将会继续推出专门为iphone设计的座充“沃槽”，手机支架“沃靠”，屏幕清洁布“沃擦”，地图软件“沃去”，日历插件“沃日”，播放器“沃勒歌去”!!!!。', '幽默小段子', '10');



INSERT INTO `dingdong`.`reward` (`rid`, `rpic`, `rcontent`, `rvalue`) VALUES ('3', '1:辞职
A对B说:“我要离开这个公司。我恨这个公司!”B建议道:“我举双手赞成你报复!!破公司一定要给它点颜色看看。不过你现在离开，还不是最好的时机。” A问:为什么?B说:“如果你现在走，公司的损失并不大。你应该趁着在公司的机会，拼命去为自己拉一些客户，成为公司独挡一面的人物，然后带着这些客户突然离开公司，公司才会受到重大损失，非常被动。”A觉得B说的非常在理。于是努力工作，事遂所愿，半年多的努力工作后，他有了许多的忠实客户。再见面时B问A:现在是时机了，要跳赶快行动哦!A淡然笑道:老总跟我长谈过，准备升我做总经理助理，我暂时没有离开的打算了。

其实这也正是B的初衷。一个人的工作，永远只是为自己的简历。只有付出大于得到，让老板真正看到你的能力大于位置，才会给你更多的机会替他创造更多利润。', '励志笑话', '15');



INSERT INTO `dingdong`.`reward` (`rid`, `rpic`, `rcontent`, `rvalue`) VALUES ('1', '1、不要抱怨，抱我。
2、近朱者赤，近你者甜。
3、我是九你是三，除了你还是你。
4、你知道我的缺点是什么吗? 是缺点你。
5、最近有谣言说我喜欢你，我要澄清一下，那不是谣言。
6、我怀疑你的本质是一本书，不然为什么让我越看越想睡。
7、我发现昨天很喜欢你，今天也很喜欢你，而且有预感明天也会喜欢你。
8、“我觉得你这个人不适合谈恋爱”  “为什么?” “适合结婚。”
9、你知道你和星星有什么区别吗?星星在天上，你在我心里。
10、“你最近是不是又胖了?” “没有啊，为什么这么说?” “那为什么在我心里的分量越来越重了?”', '土味情话合集', '20');
