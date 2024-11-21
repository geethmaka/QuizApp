package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class References extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_references);

        Button back = findViewById(R.id.refbutton);
        back.setOnClickListener(v->{
            Intent profileIntent = new Intent(References.this, MainActivity.class);
            startActivity(profileIntent);
        });
    }
}