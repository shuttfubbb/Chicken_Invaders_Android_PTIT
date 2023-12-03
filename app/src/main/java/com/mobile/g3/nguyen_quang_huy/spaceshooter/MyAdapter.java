package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private ArrayList<History> historyList;
    private Context context;

    MyAdapter(Context context, ArrayList<History> historyList){
        this.context = context;
        this.historyList = historyList;
    }

    @Override
    public int getCount() {
        return this.historyList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.historyList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView  == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_layout, parent, false);
        }

        //Bind sữ liệu phần tử vào View
        History history = (History) getItem(position);
        TextView column1 = convertView.findViewById(R.id.text_column1);
        column1.setText(history.getDatetime().toString());
        TextView column2 = convertView.findViewById(R.id.text_column2);
        column2.setText(history.getScore().toString());
        return convertView;
    }
}