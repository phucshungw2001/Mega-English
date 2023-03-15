package com.sinhvien.myrex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

    Button btnSync, btnSch;

    private MediaPlayer backgroundMusic;
    Intent service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        service = new Intent(getApplicationContext(),MusicBackGround.class);
        startService(new Intent(getApplicationContext(),MusicBackGround.class));

        btnSch = (Button)findViewById(R.id.btnSchool);
        btnSync= (Button)findViewById(R.id.btnSync);
        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,syncmain.class);
                startActivity(i);
            }
        });
        btnSch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,school_activity.class);
                startActivity(i);
            }
        });
    }

}