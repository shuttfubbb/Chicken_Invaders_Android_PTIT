package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MemberHomeActivity extends AppCompatActivity {
    Member member;
    Button btnNewGame;
    Button btnHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_home);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent intent = getIntent();
        member = new Member();
        btnNewGame = (Button) findViewById(R.id.btnNewGame);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            member = (Member) intent.getSerializableExtra("member", Member.class);
        }
        TextView wc = (TextView) findViewById(R.id.txtWelcome);
        wc.setText("Welcome " + member.getName());

        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MemberHomeActivity.this, MainActivity.class);
                intent.putExtra("member", member);
                startActivity(intent);
            }
        });
    }
}