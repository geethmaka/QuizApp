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

public class Question3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question3);


        Button q3BackButton = findViewById(R.id.q3BackButton);
        Button q3NextButton = findViewById(R.id.q3NextButton);


        q3NextButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question3.this, Question4.class);
            startActivity(intent1);
        });

        q3BackButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question3.this, Question2.class);
            startActivity(intent1);
        });

        TextView scoreText = findViewById(R.id.q3scoreText);
        String score = String.valueOf(GlobalData.getInstance().getMark());
        scoreText.setText(score+"/5");
    }
}