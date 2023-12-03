package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

public class TKActivity extends AppCompatActivity {
    Member member;
    ArrayList<History> historyList;
    HistoryDBH historyDBH;
    ListView listView;
    MyAdapter tableAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tkactivity);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        member = new Member();
//        historyDBH = new HistoryDBH(TKActivity.this);
//        historyList = new ArrayList<History>();
//        listView = findViewById(R.id.list_view);
//        Intent intent = getIntent();
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
//            member = (Member) intent.getSerializableExtra("member", Member.class);
//        }
//        historyList = historyDBH.getAllHistory(member.getId());
//        tableAdapter = new MyAdapter(this, historyList);
//        listView.setAdapter(tableAdapter);
    }
}