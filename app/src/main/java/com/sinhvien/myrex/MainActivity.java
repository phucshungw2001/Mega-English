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

    private Button btnSync, btnSch;

    private void bindingView(){
        btnSch = findViewById(R.id.btnSchool);
        btnSync= findViewById(R.id.btnSync);
    }

    private  void  bindingAction(){
        btnSch.setOnClickListener(this :: onBtnClickSch);
        btnSync.setOnClickListener(this :: onBtnClickSync);
    }

    private void onBtnClickSch(View view) {
        Intent i= new Intent(MainActivity.this,school_activity.class);
        startActivity(i);
    }

    private void onBtnClickSync(View view) {
        Intent i = new Intent(MainActivity.this,syncmain.class);
        startActivity(i);
    }

    private MediaPlayer backgroundMusic;
    private Intent service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        service = new Intent(getApplicationContext(),MusicBackGround.class);
        startService(new Intent(getApplicationContext(),MusicBackGround.class));

        bindingView();
        bindingAction();
    }

}