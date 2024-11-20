package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Question4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question4);
        TextView welcome= findViewById(R.id.welcomeText);
        TextView q4score= findViewById(R.id.q4scoreText);

        Button q4BackButton = findViewById(R.id.q4BackButton);
        Button q4NextButton = findViewById(R.id.q4NextButton);
        Button q4Check = findViewById(R.id.checkq4);
        TextView warning = findViewById(R.id.q4WarningLabel);
        RadioGroup q4radioGroup = findViewById(R.id.q4radioGroup);

        int questionNumber = 3;
        String CorrectAnswer = "Dalvik Virtual Machine";

        Utils.InitPage(welcome,q4score,questionNumber,warning,CorrectAnswer,q4NextButton,q4Check);


        q4NextButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question4.this, Question5.class);
            startActivity(intent1);
        });

        q4BackButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question4.this, Question3.class);
            startActivity(intent1);
        });

        q4Check.setOnClickListener(v->{
            int selectedId = q4radioGroup.getCheckedRadioButtonId(); // Get the ID of the selected RadioButton

            if (selectedId != -1) { // Check if any button is selected
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedText = selectedRadioButton.getText().toString();

                // Instead of if it's just checking the answer value
                Utils.AnswerQuestion(this,q4score,q4NextButton,q4radioGroup,q4Check, selectedText.equals(CorrectAnswer),questionNumber,CorrectAnswer);

            } else {
                Toast.makeText(this, "No selection made", Toast.LENGTH_SHORT).show();
            }
        });
    }
}