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

public class Question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question1);
        TextView welcome= findViewById(R.id.welcomeText);
        Intent intent = getIntent();
        welcome.setText("Welcome, "+intent.getStringExtra("Name"));


        Button q1BackButton = findViewById(R.id.q1BackButton);
        Button q1NextButton = findViewById(R.id.q1NextButton);
        GlobalData.getInstance().setMark(1);

        q1NextButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question1.this, Question2.class);
            startActivity(intent1);
        });

        q1BackButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question1.this, MainActivity.class);
            startActivity(intent1);
        });



    }
}