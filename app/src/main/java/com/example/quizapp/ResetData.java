package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResetData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reset_data);
        Button resetButton = findViewById(R.id.resetButton);
        Button resetback = findViewById(R.id.resetback);
        CheckBox rest = findViewById(R.id.resetcheckBox);

        resetButton.setEnabled(false);
        rest.setOnCheckedChangeListener((buttonView, isChecked)->{
            resetButton.setEnabled(isChecked);
        });

        resetButton.setOnClickListener(v->{
            DatabaseHelper db = new DatabaseHelper(ResetData.this);
            boolean done=db.deleteAllData();
            if(done){
                new AlertDialog.Builder(ResetData.this)
                        .setTitle("Data Deletion")
                        .setMessage("All data has been deleted!")
                        .setPositiveButton("OK", (dialog, which) -> {
                            Intent settingsIntent = new Intent(ResetData.this, MainActivity.class);
                            startActivity(settingsIntent);
                        })
                        .show();
            }
        });

        resetback.setOnClickListener(v->{
            Intent settingsIntent = new Intent(ResetData.this, MainActivity.class);
            startActivity(settingsIntent);
        });
    }
}