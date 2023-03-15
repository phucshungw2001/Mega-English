package com.sinhvien.myrex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class note_themtu_activity extends AppCompatActivity {

    Button btnAdd, btnCancel;
    EditText edtWord, edtDef;
    ImageButton ibtnCamera, ibtnFolder;
    ImageView imgHinh;
    private Database db;
    int REQUEST_CODE_CAMERA = 123;
    int REQUEST_CODE_FOLDER = 456;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_themtu);

        db = new Database(this);

        btnAdd    = (Button) findViewById(R.id.btnAdd);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        edtWord   = (EditText) findViewById(R.id.edtWord);
        edtDef    = (EditText) findViewById(R.id.edtDef);
        imgHinh   = (ImageView) findViewById(R.id.imgLoading);
        ibtnCamera=(ImageButton) findViewById(R.id.ibtnCam);
        ibtnFolder=(ImageButton) findViewById(R.id.ibtnFol);

        ibtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, REQUEST_CODE_CAMERA);
            }
        });

        ibtnFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(i,REQUEST_CODE_FOLDER);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //chuyen data imgview -> byte[]
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imgHinh.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                byte[] hinhanh = byteArray.toByteArray();

//                note_activity.database.INSERT_TU(
//                        edtWord.getText().toString().trim(),
//                        edtDef.getText().toString().trim(),
//                        hinhanh
//                )

                    db.addTu(edtWord.getText().toString(), edtDef.getText().toString(), hinhanh);
                    Toast.makeText(note_themtu_activity.this, "Added :))", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(note_themtu_activity.this,note_activity.class));

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(note_themtu_activity.this,note_activity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgHinh.setImageBitmap(bitmap);
        }

        if (requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null)
        {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgHinh.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}