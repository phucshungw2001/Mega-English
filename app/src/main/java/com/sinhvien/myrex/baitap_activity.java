/*
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
}*/


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

    String[] questions = {
            "Who are all ________ people ? ",
            " I ____ a car next year.",
            "They are all ________ ready for the party",
            "When do you go ________ bed?",
            " London is famous for _____ red buses.",
            "Where are _____ children? – They go to school.",
            "What is the tallest mountain in the world?",
            "Dan can _____ the drum very well.",
            "My friend is ______ so she has a lot of free time.",
            "Can you use ________ computer?"
    };
    String[] answers = {"those",
            "am buying",
            "getting",
            "to",
            "its",
            "the",
            "mount everest",
            "play",
            "single",
            "a"};
    int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baitap);

        tvQues = findViewById(R.id.txtQues);
        edtAns = findViewById(R.id.edtAns);
        btnSubmit = findViewById(R.id.btnSubmit);

        tvQues.setText(questions[currentQuestionIndex]);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAnswer = edtAns.getText().toString().toLowerCase();
                String correctAnswer = answers[currentQuestionIndex];

                if (userAnswer.equals(correctAnswer)) {
                    Toast.makeText(baitap_activity.this, "Right", Toast.LENGTH_SHORT).show();
                    currentQuestionIndex++; // Chuyển tiếp đến câu hỏi tiếp theo

                    if (currentQuestionIndex < questions.length) {
                        tvQues.setText(questions[currentQuestionIndex]);
                        edtAns.setText(""); // Xóa nội dung của EditText
                    } else {
                        Toast.makeText(baitap_activity.this, "Congratulations! You have completed the quiz", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(baitap_activity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}