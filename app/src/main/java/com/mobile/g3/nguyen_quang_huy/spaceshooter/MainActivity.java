package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    private Game game;
    Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set window to fullscreen
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent intent = getIntent();
        member = new Member();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            member = (Member) intent.getSerializableExtra("member", Member.class);
        }
        game = new Game(this, member, 1, "easy", 1, 1);
        setContentView(game);
    }
    @Override
    protected void onStart() {
        Log.d("MainActivity.java", "onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("MainActivity.java", "onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("MainActivity.java", "onPause()");
        game.pause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("MainActivity.java", "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("MainActivity.java", "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
    }
}