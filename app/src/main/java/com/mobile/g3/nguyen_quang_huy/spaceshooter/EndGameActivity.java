package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import model.History;
import model.Member;

public class EndGameActivity extends AppCompatActivity {
    TextView txtScore;
    Button btnBack;
    History history;
    Member member;
    HistoryDBH historyDBH;
    TCPClient tcpClient = new TCPClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        Log.d("MainActivity.java", "Create EndGame");
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        txtScore = (TextView) findViewById(R.id.txtScore);
        btnBack = (Button) findViewById(R.id.btnBack);
        history = new History();
        historyDBH = new HistoryDBH(EndGameActivity.this);
        member = new Member();
        Intent intent = getIntent();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            member = (Member) intent.getSerializableExtra("member", Member.class);
            history = (History) intent.getSerializableExtra("history", History.class);
        }
        txtScore.setText("Your score: " + history.getScore());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                try {
                    if(historyDBH.add(history)){
                        Intent intent = new Intent(EndGameActivity.this, MemberHomeActivity.class);
                        intent.putExtra("member", member);
                        startActivity(intent);
                    }
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
            }
        });
    }
}