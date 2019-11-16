package com.example.habittest;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment1 extends Fragment {
    Habit[] habit;
    private View v;
    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;

    //选择时间button
    private Button[] bt = new Button[4];
    //当前选择的时间段
    private String[] t = {"全部习惯", "学习习惯", "生活习惯", "运动习惯"};
    private String time;

    //数据库manager
    private DBManager mgr;

    public void setDBManager(DBManager mgr) {
        this.mgr = mgr;
    }

    @Override
    public void onResume() {
        super.onResume();
        selectTime(0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.habit_grid, container, false);

        //选择时间button
        bt[0] = (Button) v.findViewById(R.id.anytime);
        bt[1] = (Button) v.findViewById(R.id.morning);
        bt[2] = (Button) v.findViewById(R.id.noon);
        bt[3] = (Button) v.findViewById(R.id.evening);

        //设置默认选择任意时间
        selectTime(0);
        //选择时间事件
        for (int i = 0; i < 4; i++) {
            bt[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.anytime:
                            selectTime(0);
                            break;
                        case R.id.morning:
                            selectTime(1);
                            break;
                        case R.id.noon:
                            selectTime(2);
                            break;
                        case R.id.evening:
                            selectTime(3);
                            break;
                    }
                }
            });
        }


        //监听点击事件
        gview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                change_data(i);
            }
        });
        gview.setOnItemLongClickListener((adapterview,view,i,j)-> {
            delete_habit(i);
            return true;
        });

        return v;
    }

    public void getData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < habit.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("imageView2", getResources().getIdentifier(habit[i].pic, "drawable", getContext().getApplicationInfo().packageName));
            map.put("text_habit_name", habit[i].hname);
            map.put("text_signed_info", habit[i].finished_num + "/" + habit[i].total_num);
            data_list.add(map);
        }
    }

    //选择时间事件
    public void selectTime(int k) {
        for (int i = 0; i < 4; i++) {
            if (k == i) {
                bt[i].setBackgroundResource(R.drawable.shape_1_selected);
            } else {
                bt[i].setBackgroundResource(R.drawable.shape_1);
            }
        }
        time = t[k];
        habit = mgr.getHabit(time, 1);
        for (int i = 0; i < habit.length; i++) {
            if (habit[i].finished_num == habit[i].total_num) {
                habit[i].pic = habit[i].pic + "_gray";
            }
        }
        refresh_grid();
    }

    //更新视图
    private void refresh_grid() {
        gview = (GridView) v.findViewById(R.id._dynamic);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String[] from = {"imageView2", "text_habit_name", "text_signed_info"};//传入数据
        int[] to = {R.id.imageView2, R.id.text_habit_name, R.id.text_signed_info};//传出数据
        sim_adapter = new SimpleAdapter(getActivity(), data_list, R.layout.grid_item, from, to);
        //配置适配器
        gview.setAdapter(sim_adapter);
    }


    //点击的时候更新数据
    private void change_data(int item_id) {
        if (habit[item_id].finished_num < habit[item_id].total_num) {
            habit[item_id].finished_num++;
            if (habit[item_id].finished_num == habit[item_id].total_num) {
                //完成打卡
                habit[item_id].pic = habit[item_id].pic + "_gray";
                refresh_grid();
                EditText edit=new  EditText(getContext());
              AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setTitle("已完成"+habit[item_id].hname+"，写写感想吧：");
                builder.setView(edit);
                builder.setPositiveButton("确认",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mgr.clockinUpdateDB(habit[item_id].hname,edit.getText().toString());

                    }
                });
                builder.show();
            }

            mgr.clockUpdateDB(habit[item_id].hname);
            refresh_grid();
            Toast.makeText(getActivity(), habit[item_id].hname + "已打卡成功", Toast.LENGTH_SHORT).show();




            //更新数据库
        } else {
            Toast.makeText(getActivity(), habit[item_id].hname + "已完成", Toast.LENGTH_SHORT).show();
        }
    }
    private void delete_habit(final int item_id){
        AlertDialog alertDialog=new AlertDialog.Builder(getActivity()).create();
        alertDialog.setTitle("提示");
        alertDialog.setMessage("是否删除习惯"+habit[item_id].hname);

        alertDialog.setButton(DialogInterface.BUTTON1, "否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.setButton(DialogInterface.BUTTON2, "是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mgr.deleteHabit(habit[item_id].hname);

                refresh_grid();


            }
        });

        alertDialog.show();
        refresh_grid();

    }

}