package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnPlay;
    LevelDBH levelDBH;
    ArrayList<Level> levels;
    Game game;
    Level selectedLevel;
    Spinner spinner;
    Member member;
    History history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);
        // Set window to fullscreen
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        spinner = (Spinner) findViewById(R.id.spinner);
        Intent intent = getIntent();
        member = new Member();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            member = (Member) intent.getSerializableExtra("member", Member.class);
        }
        levelDBH = new LevelDBH(this);
        levels = levelDBH.getAllLevel();
        ArrayAdapter<Level> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, levels);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedPosition = spinner.getSelectedItemPosition();
                selectedLevel = levels.get(selectedPosition);
                game = new Game(MainActivity.this, selectedLevel);
                setContentView(game);
            }
        });

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
        history = new History();
        Intent intent = new Intent(MainActivity.this, EndGameActivity.class);
        history.setScore(game.score);
        history.setMember(this.member);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            history.setDatetime(LocalDateTime.now());
        }
        history.setLevel(selectedLevel);
        intent.putExtra("history", history);
        intent.putExtra("member", member);
        this.startActivity(intent);
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
    }
}