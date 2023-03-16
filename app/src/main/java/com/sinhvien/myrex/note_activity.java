package com.sinhvien.myrex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class note_activity extends AppCompatActivity {

    private Button btnThem, btnList;

    private void bindingView(){
        btnThem = (Button) findViewById(R.id.btnThem);
        btnList = (Button) findViewById(R.id.btnList);
    }

    private  void  bindingAction(){
        btnThem.setOnClickListener(this :: onBtnClickThem);
        btnList.setOnClickListener(this :: onBtnClickList);
    }

    private void onBtnClickThem(View view) {
        startActivity(new Intent(note_activity.this, note_themtu_activity.class));
    }
    private void onBtnClickList(View view) {
        startActivity(new Intent(note_activity.this,note_list.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        bindingView();
        bindingAction();
    }
}