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

    Button btnThem, btnList;
    ListView lvTu;
    ArrayList<note_tu> tuArrayList;
    note_adapter adapter;
    public static Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        btnThem = (Button) findViewById(R.id.btnThem);
        btnList = (Button) findViewById(R.id.btnList);
//        lvTu = (ListView) findViewById(R.id.listviewTu);
//        tuArrayList = new ArrayList<>();

//        adapter = new note_adapter(this, R.layout.activity_note_listitem, tuArrayList);
//        lvTu.setAdapter(adapter);

//        database = new Database(this, "ThemTu.sqlite",null,1);
//        database.QueryData("CREATE TABLE IF NOT EXISTS Tu(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenTu TEXT, DinhNghia TEXT, HinhAnh BLOB)");

//        Cursor cursor = database.GetData("SELECT * FROM Tu");
//        while (cursor.moveToNext())
//        {
//            tuArrayList.add(new note_tu(
//                    cursor.getInt(0),
//                    cursor.getString(1),
//                    cursor.getString(2),
//                    cursor.getBlob(3)
//
//           ));
//        }
//        adapter.notifyDataSetChanged();
        btnThem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(note_activity.this, note_themtu_activity.class));
            }
        });

        btnList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(note_activity.this,note_list.class));
            }
        });
    }
}