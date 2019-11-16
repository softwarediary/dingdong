package com.example.habittest;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Advice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar5);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ImageButton sub = (ImageButton) findViewById(R.id.tjjy);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etAdvice=(EditText)findViewById(R.id.advice);
                String advice=etAdvice.getText().toString();

                if (advice.equals("")) {
                    Toast.makeText(Advice.this, "意见不能为空", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Advice.this, "反馈成功", Toast.LENGTH_SHORT).show();

            }

        });

    }

}






