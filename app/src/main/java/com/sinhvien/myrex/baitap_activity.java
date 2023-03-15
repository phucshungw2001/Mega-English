package com.sinhvien.myrex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class baitap_activity extends AppCompatActivity
{
    TextView tvQues;
    EditText edtAns;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baitap);

        tvQues = findViewById(R.id.txtQues);
        edtAns = findViewById(R.id.edtAns);
        btnSubmit = findViewById(R.id.btnSubmit);

        tvQues.setText("A dog has ... legs ? ");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (edtAns.getText().toString().equals("four"))
                {
                    tvQues.setText("2 + 2 = ...");
                    Toast.makeText(baitap_activity.this, "Right", Toast.LENGTH_SHORT).show();
                }
                else if (edtAns.getText().toString().equals("4"))
                {
                    Toast.makeText(baitap_activity.this, "Right", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(baitap_activity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}