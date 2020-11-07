package com.example.evernote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Intro extends AppCompatActivity {
    Handler handler;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                intent = new Intent(Intro.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }
}