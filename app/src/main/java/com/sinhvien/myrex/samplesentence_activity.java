package com.sinhvien.myrex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class samplesentence_activity extends Activity {

    private Button btngreeting,btnjob,btnhealth,btnentaint,btnplace,btneating,btnmore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_samplesentence);

        btngreeting = (Button) findViewById(R.id.btnGreeting);
        btngreeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(samplesentence_activity.this,greeting_sen.class);
                startActivity(i);
            }
        });
        btnjob      = (Button) findViewById(R.id.btnJob);
        btnjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(samplesentence_activity.this,job_sen.class);
                startActivity(i);
            }
        });
        btnhealth   = (Button) findViewById(R.id.btnHealth);
        btnhealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(samplesentence_activity.this,health_sen.class);
                startActivity(i);
            }
        });
        btnentaint  = (Button) findViewById(R.id.btnEntertain);
        btnentaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(samplesentence_activity.this,entertain_sen.class);
                startActivity(i);
            }
        });
        btnplace    = (Button) findViewById(R.id.btnPlace);
        btnplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(samplesentence_activity.this,place_sen.class);
                startActivity(i);
            }
        });
        btneating   = (Button) findViewById(R.id.btnEating);
        btneating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(samplesentence_activity.this,eating_sen.class);
                startActivity(i);
            }
        });
        btnmore     = (Button) findViewById(R.id.btnMore);
        btnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(samplesentence_activity.this,"Not available now ",Toast.LENGTH_SHORT).show();
            }
        });

    }
}