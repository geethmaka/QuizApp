package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question1);
        TextView welcome= findViewById(R.id.welcomeText);
        TextView q1score= findViewById(R.id.q1scoreText);

        Button q1BackButton = findViewById(R.id.q1BackButton);
        Button q1NextButton = findViewById(R.id.q1NextButton);
        Button q1Check = findViewById(R.id.checkQ1);
        TextView warning = findViewById(R.id.q1WarningLabel);
        RadioGroup q1radioGroup = findViewById(R.id.q1radioGroup);

        int questionNumber = 0;
        String CorrectAnswer = "An Operating System";

        Utils.InitPage(welcome,q1score,questionNumber,warning,CorrectAnswer,q1NextButton,q1Check);


        q1NextButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question1.this, Question2.class);
            startActivity(intent1);
        });

        q1BackButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question1.this, MainActivity.class);
            startActivity(intent1);
        });

        q1Check.setOnClickListener(v->{
            int selectedId = q1radioGroup.getCheckedRadioButtonId(); // Get the ID of the selected RadioButton

            if (selectedId != -1) { // Check if any button is selected
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedText = selectedRadioButton.getText().toString();

                // Instead of if it's just checking the answer value
                Utils.AnswerQuestion(this,q1score,q1NextButton,q1radioGroup,q1Check, selectedText.equals(CorrectAnswer),questionNumber,CorrectAnswer);

            } else {
                Toast.makeText(this, "No selection made", Toast.LENGTH_SHORT).show();
            }
        });
    }
}