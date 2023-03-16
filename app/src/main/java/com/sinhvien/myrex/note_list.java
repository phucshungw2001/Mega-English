package com.sinhvien.myrex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class note_list extends AppCompatActivity {

    ListView lv;
    private ArrayList<note_tu> listTu;
    private note_adapter na;
    private Database db;

    private void bindingView(){
        lv = findViewById(R.id.listviewTu);
    }
    private  void  bindingAction(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        bindingView();
        bindingAction();

        db = new Database(this);
        listTu = db.getAllTu();
        na = new note_adapter(this, listTu);
        lv.setAdapter(na);
    }
}