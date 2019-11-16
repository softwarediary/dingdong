package com.example.habittest;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RewardListItemAdapter extends ArrayAdapter<Reward> {
    private int layoutId;

    public RewardListItemAdapter(Context context, int layoutId, List<Reward> list) {
        super(context, layoutId, list);
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Reward item = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(layoutId, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView textContent = (TextView) view.findViewById(R.id.text_name);


        imageView.setImageResource(getContext().getResources().getIdentifier(item.getPic(),"drawable",getContext().getApplicationInfo().packageName));
        textContent.setText(item.getContent());

        return view;
    }
}