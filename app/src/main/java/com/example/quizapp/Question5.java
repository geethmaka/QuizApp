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

public class Question5 extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question5);


        Button q5BackButton = findViewById(R.id.q5BackButton);
        Button q5NextButton = findViewById(R.id.q5NextButton);


        q5NextButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question5.this, FinalPage.class);
            startActivity(intent1);
        });

        q5BackButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question5.this, Question4.class);
            startActivity(intent1);
        });

        TextView scoreText = findViewById(R.id.q5scoreText);
        String score = String.valueOf(GlobalData.getInstance().getMark());
        scoreText.setText(score+"/5");
    }
}