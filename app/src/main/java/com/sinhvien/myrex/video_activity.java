package com.sinhvien.myrex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class video_activity extends AppCompatActivity {

    Button btnvid1, btnvid2, btnvid3;
    String API_KEY = "AIzaSyDDwLpEsQYaH7__VuIVfVnlwG_NbhVzioU";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        btnvid1 = (Button) findViewById(R.id.btnvid1);
        btnvid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(video_activity.this,video_vid1.class);
                startActivity(i);
            }
        });
        btnvid2 = (Button) findViewById(R.id.btnvid2);
        btnvid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(video_activity.this,video_vid2.class);
                startActivity(i);
            }
        });
        btnvid3 = (Button) findViewById(R.id.btnvid3);
        btnvid3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(video_activity.this,video_vid3.class);
                startActivity(i);
            }
        });
    }
}