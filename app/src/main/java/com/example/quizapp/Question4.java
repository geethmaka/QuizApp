package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Question4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question4);


        Button q4BackButton = findViewById(R.id.q4BackButton);
        Button q4NextButton = findViewById(R.id.q4NextButton);


        q4NextButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question4.this, Question5.class);
            startActivity(intent1);
        });

        q4BackButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question4.this, Question3.class);
            startActivity(intent1);
        });

        TextView scoreText = findViewById(R.id.q4scoreText);
        String score = String.valueOf(GlobalData.getInstance().getMark());
        scoreText.setText(score+"/5");
    }
}