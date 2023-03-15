package com.sinhvien.myrex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class note_list extends AppCompatActivity {

    ListView lv;
    private ArrayList<note_tu> listTu;
    private note_adapter na;
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        lv = (ListView) findViewById(R.id.listviewTu);

        db = new Database(this);

        listTu = db.getAllTu();

        na = new note_adapter(this, listTu);
        lv.setAdapter(na);
    }
}