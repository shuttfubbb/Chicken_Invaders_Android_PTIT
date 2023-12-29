package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import model.Member;

public class LoginActivity extends AppCompatActivity {
    EditText inpUsername;
    EditText inpPassword;
    Button btnLogin;
    MemberDBH memberDBH;
    TCPClient tcpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        inpUsername = (EditText) findViewById(R.id.inpUsername);
        inpPassword = (EditText) findViewById(R.id.inpPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        memberDBH = new MemberDBH(LoginActivity.this);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = inpUsername.getText().toString();
                String password = inpPassword.getText().toString();

                Member member = new Member();
                member.setUsername(username);
                member.setPassword(password);
                if(memberDBH.checkLogin(member)){
                    Intent intent = new Intent(LoginActivity.this, MemberHomeActivity.class);
                    intent.putExtra("member", member);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "The Username or Password is Incorrect", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}