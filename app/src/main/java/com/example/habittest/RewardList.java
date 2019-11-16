package com.example.habittest;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class RewardList extends AppCompatActivity {

    private List<Reward> list;
    private ListView listView;
    private RewardListItemAdapter itemAdapter;

    private Reward[] rewards;

    //数据库manager
    public SQLiteDatabase db;
    public DBManager mgr;
    public MySqliteHelper helper;


    @Override
    public void onResume() {
        super.onResume();
        refresh_list();
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reward_main);
        listView = findViewById(R.id.dynamic);
        //数据库变量初始化
        helper = DBManager.getIntance(this);
        db = helper.getWritableDatabase();//创建或打开数据库
        mgr = new DBManager(db);


        //返回事件
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar6);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void addReward(View v) {
        Intent intent = new Intent(RewardList.this, AddReward.class);
        startActivity(intent);
    }


    public void refresh_list() {
        list = new ArrayList<Reward>();
        rewards=mgr.getReward();
        for (int i = 0; i < rewards.length; i++) {
            Reward r = new Reward(rewards[i].getPic(), rewards[i].getContent());
            list.add(r);
        }
        itemAdapter  = new RewardListItemAdapter(RewardList.this, R.layout.reward_list_item, list);
        listView.setAdapter(itemAdapter);
    }

}
