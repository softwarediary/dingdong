package com.example.habittest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

public class TodayCard extends AppCompatActivity {

    private String[] img = {"card_1", "card_2", "card_3", "card_4", "card_5", "card_6"};
    private String[] words = {"Never put off what you can do today until tomorrow.\n今日事今日毕！。",
            "Believe in yourself.\n\n相信你自己！。",
            "if you smile when one is around, you really mean it.\n\n如果你独自一人笑了，那是真心的笑。",
            "Regardless of the twists and turns， but at the end。\n\n不计波折多，但望结局好。",
            "No way is impossible to courage.\n\n勇敢面前没有通不过的路。",
            "Every cloud has a silver lining.\n\n山穷水尽疑无路，柳暗花明又一村。"};
    private int imgIndex;

    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_card);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar4);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView tWeek = (TextView) findViewById(R.id.textView20);
        tWeek.setText(Utils.date2Week(new Date()));
        TextView tdate = (TextView) findViewById(R.id.textView22);
        String strDate = Utils.date2String(new Date());
        String date = strDate.substring(0, 4) + "." + strDate.substring(4, 6) + "." + strDate.substring(6, 8);
        tdate.setText(date);
        //TextView textView = (TextView) findViewById(R.id.textView23);
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
       // LocalDate localDate = LocalDate.ofYearDay(year, 1);
        //int dayCount = localDate.isLeapYear() ? 366 : 365;
        //textView.setText("『 叮咚！在" + year + "年剩余的" + (dayCount - cal.get(Calendar.DAY_OF_YEAR)) + "个日子里请继续加油 』");
        int day = cal.get(Calendar.DATE);
        imageView = (ImageView) findViewById(R.id.imageView4);
        byte[] image = getIntent().getByteArrayExtra("image");
        if (image != null)
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(image, 0, image.length));
        else
            imageView.setImageResource(getResources().getIdentifier(img[day % 6], "drawable", getPackageName()));
        TextView textView1 = (TextView) findViewById(R.id.textView);
        textView1.setText(words[day % 6]);
        imgIndex = day % 6;

    }


    //  将布局转化为bitmap
    //  这里传入的是你要截的布局的根View
    public Bitmap getBitmapByView(View headerView) {
        int h = headerView.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(headerView.getWidth(), h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        headerView.draw(canvas);
        return bitmap;
    }

    //把bitmap转化为file
    public File bitMap2File(Bitmap bitmap) {
        String path = "";
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            path = Environment.getExternalStorageDirectory() + File.separator;//保存到sd根目录下
        }

        // File f = new File(path, System.currentTimeMillis() + ".jpg");
        File f = new File(path, Integer.valueOf(String.valueOf((new Date()).getTime() / 1000)) + ".jpg");
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            bitmap.recycle();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return f;
        }
    }

    public void shareCard(View view) {
        File file = bitMap2File(getBitmapByView(findViewById(R.id.constraintLayout5)));
        if (file != null && file.exists() && file.isFile()) {
            //由文件得到uri
            Uri imageUri = FileProvider.getUriForFile(getApplicationContext(), "com.example.habittest.fileprovider", file);
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
            shareIntent.setType("image/*");
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(shareIntent, "分享图片"));
        }
    }

    public void changeCard(View view) {
        int i = Calendar.getInstance().get(Calendar.MILLISECOND) % 6;
        if (imgIndex == i) {
            imgIndex = (imgIndex + 1) % 6;
        } else {
            imgIndex = i;
        }
        imageView = (ImageView) findViewById(R.id.imageView4);
        imageView.setImageResource(getResources().getIdentifier(img[imgIndex], "drawable", getPackageName()));


    }
}
