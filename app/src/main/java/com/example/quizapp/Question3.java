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


public class Question3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question3);
        TextView welcome= findViewById(R.id.welcomeText);
        TextView q3score= findViewById(R.id.q3scoreText);

        Button q3BackButton = findViewById(R.id.q3BackButton);
        Button q3NextButton = findViewById(R.id.q3NextButton);
        Button q3Check = findViewById(R.id.checkq3);
        TextView warning = findViewById(R.id.q3WarningLabel);

        int questionNumber = 2;
        String CorrectAnswer = "T - Mobile G1";

        Utils.InitPage(welcome,q3score,2,warning,CorrectAnswer,q3NextButton,q3Check);


        q3NextButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question3.this, Question4.class);
            startActivity(intent1);
        });

        q3BackButton.setOnClickListener(v->{
            Intent intent1 = new Intent(Question3.this, Question2.class);
            startActivity(intent1);
        });

        q3Check.setOnClickListener(v->{
            RadioGroup radioGroup = findViewById(R.id.q3radioGroup);

            int selectedId = radioGroup.getCheckedRadioButtonId(); // Get the ID of the selected RadioButton

            if (selectedId != -1) { // Check if any button is selected
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedText = selectedRadioButton.getText().toString();

                // Instead of if it's just checking the answer value
                Utils.AnswerQuestion(this,q3score,q3NextButton,radioGroup,q3Check, selectedText.equals(CorrectAnswer),questionNumber,CorrectAnswer);

            } else {
                Toast.makeText(this, "No selection made", Toast.LENGTH_SHORT).show();
            }
        });
    }
}