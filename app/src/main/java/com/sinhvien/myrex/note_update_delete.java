package com.sinhvien.myrex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class note_update_delete extends AppCompatActivity {

    private note_tu noteTu;
    private EditText edtWord,edtDef;
    private ImageButton btnupdate, btndelete;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_update_delete);

        Intent intent = getIntent();
        noteTu = (note_tu)intent.getSerializableExtra("Tu");

//        database = new Database(this);

        edtWord = (EditText) findViewById(R.id.edtWord);
        edtDef  = (EditText) findViewById(R.id.edtDef);
        btnupdate = (ImageButton) findViewById(R.id.ibtnUpdate);
        btndelete = (ImageButton) findViewById(R.id.ibtnDelete);

    }
}