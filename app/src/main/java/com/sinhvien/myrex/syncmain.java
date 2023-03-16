package com.sinhvien.myrex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class syncmain extends Activity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_syncmain);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(syncmain.this,dictionary_activity.class);
                startActivity(i);
            }
        });
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(syncmain.this,samplesentence_activity.class);
                startActivity(i);
            }
        });

        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(syncmain.this,grammar_activity.class);
                startActivity(i);
            }
        });
         btn4 = (Button) findViewById(R.id.btn4);
         btn4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(syncmain.this,idioms_activity.class);
                 startActivity(i);
             }
         });

         btn5 = (Button) findViewById(R.id.btn5);
         btn5.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(syncmain.this,listen_activity.class);
                 startActivity(i);
             }
         });
         btn6 = (Button) findViewById(R.id.btn6);
         btn6.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(syncmain.this,"Make sure you are connected to the Internet",Toast.LENGTH_SHORT).show();
                 Intent i = new Intent(syncmain.this, video_activity.class);
                 startActivity(i);
             }
         });

         btn7 = (Button) findViewById(R.id.btn7);
         btn7.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(syncmain.this, note_activity.class);
                 startActivity(i);
             }
         });
    }
}