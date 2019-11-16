package com.example.habittest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.*;
import java.util.Date;

public class DBManager {
    private static MySqliteHelper helper;
    private SQLiteDatabase db;

    public static MySqliteHelper getIntance(Context context) {
        if (helper == null) {
            helper = new MySqliteHelper(context);
        }
        return helper;
    }

    public DBManager(SQLiteDatabase db) {
        this.db = db;
    }


    //数据库创建函数
    public void createTableOrNot() {
        boolean notable = true;
        boolean notable2=true;
        int count = -1;
        //先判断表是否存在
       // String sql11="drop table habit1";
        //String sql12="drop table dakass";
        //db.execSQL(sql11);
        //db.execSQL(sql12);
        //判断习惯表是否存在
        String sql = "select count(*) as c from sqlite_master where type ='table' and name ='habit1' ";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToNext()) {
            count = cursor.getInt(0);
        }
            if (count > 0) {
                notable = false;

                String sql9 = "select count(*) from habit1";
                Cursor cursor6 = db.rawQuery(sql9, null);
                cursor6.moveToNext();
                int count6 = cursor6.getInt(0);//获取习惯总数
                if(count6==0) {
                    this.insertTestRecord();
                }
            }

        if (notable) {//不存在则创建
            String sql1 = "create table habit1 (hname text primary key,pic text, total_num integer,finished_num integer,time text, fre text, htext text,days integer, curdays integer, highdays integer, credate text , swit integer,aim integer)";


            db.execSQL(sql1);
          

            this.insertTestRecord();


        }
        String sq2 = "select count(*) as c from sqlite_master where type ='table' and name ='rewards1' ";
        Cursor cursor2 = db.rawQuery(sq2, null);
        if (cursor2.moveToNext()) {
            count = cursor2.getInt(0);
        }
            if (count > 0) {
                notable2 = false;
            }

        if (notable2) {//不存在则创建

            String sql3 = "create table rewards1(id integer primary key autoincrement,pic text,content text)";

            db.execSQL(sql3);
        }

            String sql4 = "select count(*) from rewards1";
            Cursor cursor3 = db.rawQuery(sql4, null);
            cursor3.moveToNext();
            int count3 = cursor3.getInt(0);//获取习惯总数
            if(count3==0) {
                this.insertTestReward();
            }
            //打卡表生成
        boolean notable3=true;
        int count666=0;
        String sq111 = "select count(*) as c from sqlite_master where type ='table' and name ='dakass' ";
        Cursor cursor8 = db.rawQuery(sq111, null);
        if (cursor8.moveToNext()) {
            count666 = cursor8.getInt(0);
        }
        if (count666 > 0) {
            notable3= false;
        }

        if (notable3) {//不存在则创建

            String sql2 = "create table dakass (hname text,dakadate date,content text)";

            db.execSQL(sql2);
        }

        String sql44 = "select count(*) from dakass";
        Cursor cursor33 = db.rawQuery(sql44, null);
        int count33=0;
        if(cursor3.moveToNext()){

            count33 = cursor33.getInt(0);//获取习惯总数
        }
        if(count33==0) {
            this.insertTestDaka();
        }
        //调试用Log.i("tag",Integer.toString(count));
        //调试用Log.i("tag",Boolean.toString(notable));
    }

    public void insertTestRecord() {
        String sql1 = "insert into habit1 values ('吃早餐','habit_1',1,0,'生活习惯','每天','健康饮食',7,0,3,'20190526',1,2)";
        String sql2 = "insert into habit1 values ('跑步','habit_2',3,0,'运动习惯','每天','坚持锻炼身体。',3,0,2,'20190515',1,1)";
        String sql3 = "insert into habit1 values ('看书','habit_3',5,0,'学习习惯','每天','好好学习天天向上',4,0,2,'20190522',1,3)";
        String sql4 = "insert into habit1 values ('早起','habit_4',1,0,'生活习惯','每天','早起的鸟儿有虫吃。',6,0,3,'20190531',1,1)";

         db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);

    }

    public void insertTestDaka() {
      

        String sql5 = "insert into dakass values ('吃早餐','20190601','坚持哦'),('吃早餐','20190602','坚持哦'),('吃早餐','20190603','坚持哦'),('吃早餐','20190610','坚持哦'),('吃早餐','20190611','坚持哦')";
        String sql6 = "insert into dakass values ('跑步','20190603','坚持哦'),('跑步','20190610','坚持哦'),('跑步','20190611','坚持哦')";
        String sql7 = "insert into dakass values ('看书','20190603','坚持哦'),('看书','20190604','坚持哦'),('看书','20190610','坚持哦'),('看书','20190611','坚持哦')";
        String sql8 = "insert into dakass values ('早起','20190601','坚持哦'),('早起','20190602','坚持哦'),('早起','20190603','坚持哦'),('早起','20190609','坚持哦'),('早起','20190610','坚持哦'),('早起','20190611','坚持哦')";

        db.execSQL(sql5);
        db.execSQL(sql6);
        db.execSQL(sql7);
        db.execSQL(sql8);
    }

    public void insertTestReward(){
        String sql1="insert into  rewards1 values(null,'reward_1','吃大餐')";
        String sql2="insert into  rewards1 values(null,'reward_2','看电影')";
        String sql3="insert into  rewards1 values(null,'reward_3','旅游')";
        String sql4="insert into  rewards1 values(null,'reward_4','买买买')";

        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);

    }
    public void clockinUpdateDB(String h,String content) {
        //点击签到键更新数据库

        //非必做操作 筛选更新
        String sql3 = "update habit1 set days = days+1 where hname='" + h + "'";
        String sql4 = "update habit1 set curdays = curdays+1 where hname='" + h + "' and finished_num=0 and curdays=0";
        String sql5 = "update habit1 set highdays = highdays+1 where hname='" + h + "' and finished_num=0 and highdays=0";
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
        //必做操作：finished_num++ 、插入打卡记录
        Date date = new Date();     ///获取当前日期
        String date_s = Utils.date2String(date);
        String sql2 = "insert into dakass values ('" + h + "','" + date_s + "','"+content+"')";

        db.execSQL(sql2);
    }

    public void clockUpdateDB(String h) {
        //完成一次打卡
        String sql1 = "update habit1 set finished_num = finished_num+1 where hname ='" + h + "'";

        //非必做操作 筛选更新
        db.execSQL(sql1);

        //必做操作：finished_num++ 、插入打卡记录

    }
    //返回给定时间段下的习惯
    //isNotFinished为1时返回未结束的,为0返回已结束的
    public Habit[] getHabit(String time, int isNotFinished) {
        String[] Time = new String[]{time};
        if (time == "全部习惯") {//选中的是全部习惯habit1，返回全部habit1
            String sql = "select count(*) from habit1 where swit=" + isNotFinished;
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToNext();
            int count = cursor.getInt(0);//获取习惯总数
            Habit[] h = new Habit[count];//创建habit数组
            String sq2 = "select * from habit1 where swit=" + isNotFinished;
            Cursor c = db.rawQuery(sq2, null);
            c.moveToFirst();
            int i = 0;
            while (!c.isAfterLast()) {
                Habit h1 = new Habit(c.getString(0), c.getString(1), c.getInt(2), c.getInt(3), c.getString(4), c.getString(5), c.getString(6), c.getInt(7), c.getInt(8), c.getInt(9), c.getString(10), c.getInt(11),c.getInt(12));
                h[i++] = h1;
                c.moveToNext();
            }
            ///应当有count == h.length;
            return h;
        } else {//其它情况相似
            String sql1 = "select count(*) from habit1 where time=? and swit =" + isNotFinished;
            Cursor cursor = db.rawQuery(sql1, Time);
            cursor.moveToNext();
            int count = cursor.getInt(0);//获取习惯总数
            Habit[] h = new Habit[count];//创建habit数组
            String sql2 = "select * from habit1 where time=? and swit =" + isNotFinished;
            Cursor c = db.rawQuery(sql2, Time);
            c.moveToFirst();
            int i = 0;
            while (!c.isAfterLast()) {
                Habit h1 = new Habit(c.getString(0), c.getString(1), c.getInt(2), c.getInt(3), c.getString(4), c.getString(5), c.getString(6), c.getInt(7), c.getInt(8), c.getInt(9), c.getString(10), c.getInt(11),c.getInt(12));
                h[i++] = h1;
                c.moveToNext();
            }
            ///应当有count == h.length ==i;实际h数组的下标应该为0至i-1
            //调试用Log.i("tag##",Integer.toString(i));
            return h;
        }
    }
    //返回全部奖励
    public Reward[] getReward() {

            String sql = "select count(*) from rewards1";
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToNext();
            int count = cursor.getInt(0);//获取奖励总数
            Reward[] r = new Reward[count];//创建reward数组
            String sq2 = "select * from rewards1";
            Cursor c = db.rawQuery(sq2, null);
            c.moveToFirst();
            int i = 0;
            while (!c.isAfterLast()) {
                Reward r1 = new Reward(c.getString(1), c.getString(2));
                r[i++] = r1;
                c.moveToNext();
            }
            ///应当有count == h.length;
            return r;
    }
    public String getRandomReward() //获取随机奖励
    {

        String sql = "select count(*) from rewards1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToNext();
        int count = cursor.getInt(0);//获取奖励总数
        if(count>0) {
            int random = (int) (Math.random() * count + 1);

            String sq2 = "select * from rewards1 where id=" + String.valueOf(random);
            Cursor c = db.rawQuery(sq2, null);
            c.moveToFirst();

            while (!c.isAfterLast()) {
                Reward r1 = new Reward(c.getString(1), c.getString(2));

                c.moveToNext();
                return r1.getContent();
            }
        }
        ///应当有count == h.length;
        return "iphone";
    }
    //用于在添加新的习惯时更新数据库，成功返回ture，失败返回false（表示该习惯已经存在）。
    public boolean insertHabitDB(Habit habit) {

        //第一步先看要添加的habit名称是否已经存在

        String sql1 = "select count(*) from habit1 where hname = '" + habit.getHname() + "'";    //sql语句查询是否存在该名字
        Cursor cursor = db.rawQuery(sql1, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        if (count == 1)      //若已经存在这个名字的习惯则直接返回false
            return false;
        //否则创建这个习惯。
        String sql2 = "insert into habit1 values('" + habit.getHname() + "','" + habit.getPic() + "'," + habit.getTotal_num() + "," + habit.getFinished_num() + ",'" + habit.getTime() + "','" + habit.getFre() + "','" + habit.getHtext() + "'," + habit.getDays() + "," + habit.getCurdays() + "," + habit.getHighdays() + ",'" + habit.getCredate() + "'," + habit.getSwit()+ "," + habit.getAim() + ")";
        db.execSQL(sql2);
        return true;    ///添加则返回true
    }
    public boolean insertRewardDB(Reward reward) {


        String sql1 = "insert into rewards1 values(null,'" + reward.getPic() + "','" + reward.getContent()+ "')";
        db.execSQL(sql1);
        return true;    ///添加则返回true
    }

    public void switchHabit(String hname,int swit) {
        String sql = "update habit1 set swit = "+swit+" where hname='" + hname + "'";
        db.execSQL(sql);
    }
    public void deleteHabit(String name){
        String sql="delete from habit1 where hname='"+name+"'";
        db.execSQL(sql);
    }

    //获取查看的习惯已经打卡的日期,返回存放已打卡日期的int数组
    public int[] getDates(String hname) {
        int[] dates;//存放结果的int数组
        int count;//数组长度 通过查询记录获得
        String sql1 = "select count(*) from dakass where hname = '" + hname + "'";
        Cursor cursor = db.rawQuery(sql1, null);
        cursor.moveToFirst();
        count = cursor.getInt(0);
        dates = new int[count];  ///获取该习惯打卡总数后，实例化int数组，准备存数据

        String sql2 = "select dakadate from dakass where hname = '" + hname + "'";
        Cursor c = db.rawQuery(sql2, null);
        c.moveToFirst();
        int i = 0;
        while (!c.isAfterLast()) {//获取日期
            String s1 = c.getString(0);
            dates[i++] = Integer.parseInt(s1.substring(6, 8));
            c.moveToNext();
        }
        //while过后，应当有count==i==h.length，且s[]下标范围0至i-1

        return dates;
    }
public void cutdays(String name){
    String sql="update habit1 set days=days-aim where hname='"+name+"'";
    db.execSQL(sql);
}

}
