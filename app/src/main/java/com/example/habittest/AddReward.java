package com.example.habittest;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;

import java.util.Calendar;
import java.util.Date;

public class AddReward extends AppCompatActivity {

    private ImageView imageView;
    private Button[] bt = new Button[15];
    private  String img;

    //数据库相关变量
    private MySqliteHelper helper;
    private SQLiteDatabase db;
    private DBManager mgr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_reward);
        final String[] imgName = {"reward_1", "reward_2", "reward_3", "reward_4", "reward_5","reward_6", "reward_7", "reward_8", "reward_9", "reward_10","reward_11", "reward_12", "reward_13", "reward_14", "reward_15"};

        //数据库变量初始化
        helper = DBManager.getIntance(this);
        db = helper.getWritableDatabase();//创建或打开数据库
        mgr = new DBManager(db);

        //返回事件
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        //选择图标事件
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        RadioGroup rg1=(RadioGroup)findViewById(R.id.radioGroup1);
        RadioGroup rg2=(RadioGroup)findViewById(R.id.radioGroup2);

        imageView = (ImageView) findViewById(R.id.reward_img);

        //设置初始图标
        img = imgName[0];
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.img1:
                        imageView.setImageResource(getResources().getIdentifier(imgName[0], "drawable", getPackageName()));
                        img = imgName[0];
                        break;
                    case R.id.img2:
                        imageView.setImageResource(getResources().getIdentifier(imgName[1], "drawable", getPackageName()));
                        img = imgName[1];
                        break;
                    case R.id.img3:
                        imageView.setImageResource(getResources().getIdentifier(imgName[2], "drawable", getPackageName()));
                        img = imgName[2];
                        break;
                    case R.id.img4:
                        imageView.setImageResource(getResources().getIdentifier(imgName[3], "drawable", getPackageName()));
                        img = imgName[3];
                        break;
                    case R.id.img5:
                        imageView.setImageResource(getResources().getIdentifier(imgName[4], "drawable", getPackageName()));
                        img = imgName[4];
                        break;
                }

            }
        });

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.img6:
                        imageView.setImageResource(getResources().getIdentifier(imgName[5], "drawable", getPackageName()));
                        img = imgName[5];
                        break;
                    case R.id.img7:
                        imageView.setImageResource(getResources().getIdentifier(imgName[6], "drawable", getPackageName()));
                        img = imgName[6];
                        break;
                    case R.id.img8:
                        imageView.setImageResource(getResources().getIdentifier(imgName[7], "drawable", getPackageName()));
                        img = imgName[7];
                        break;
                    case R.id.img9:
                        imageView.setImageResource(getResources().getIdentifier(imgName[8], "drawable", getPackageName()));
                        img = imgName[8];
                        break;
                    case R.id.img10:
                        imageView.setImageResource(getResources().getIdentifier(imgName[9], "drawable", getPackageName()));
                        img = imgName[9];
                        break;
                }

            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.img11:
                        imageView.setImageResource(getResources().getIdentifier(imgName[10], "drawable", getPackageName()));
                        img = imgName[10];
                        break;
                    case R.id.img12:
                        imageView.setImageResource(getResources().getIdentifier(imgName[11], "drawable", getPackageName()));
                        img = imgName[11];
                        break;
                    case R.id.img13:
                        imageView.setImageResource(getResources().getIdentifier(imgName[12], "drawable", getPackageName()));
                        img = imgName[12];
                        break;
                    case R.id.img14:
                        imageView.setImageResource(getResources().getIdentifier(imgName[13], "drawable", getPackageName()));
                        img = imgName[13];
                        break;
                    case R.id.img15:
                        imageView.setImageResource(getResources().getIdentifier(imgName[14], "drawable", getPackageName()));
                        img = imgName[14];
                        break;
                }

            }
        });


    }







    //创建奖励
    public void addaReward(View view) {
        //获取输入框
        EditText etName = (EditText) findViewById(R.id.editText);

        String content = etName.getText().toString();


        if (content.equals("")) {
            Toast.makeText(this, "奖励内容不能为空", Toast.LENGTH_SHORT).show();
        } else {

            Reward reward = new Reward(img, content);
            if (mgr.insertRewardDB(reward)) {
                finish();
                return;
            }
        }


    }

}
