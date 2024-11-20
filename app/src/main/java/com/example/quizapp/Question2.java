package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question2);


        Button q2BackButton = findViewById(R.id.q2BackButton);
        Button q2NextButton = findViewById(R.id.q2NextButton);


        q2NextButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question2.this, Question3.class);
            startActivity(intent1);
        });

        q2BackButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question2.this, Question1.class);
            startActivity(intent1);
        });

        TextView scoreText = findViewById(R.id.q1scoreText);
        String score = String.valueOf(GlobalData.getInstance().getMark());
        scoreText.setText(score+"/5");
    }
}