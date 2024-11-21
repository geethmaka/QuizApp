package com.example.quizapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Leaderboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_leader_board);
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        DatabaseHelper db = new DatabaseHelper(Leaderboard.this);

        tableLayout.removeAllViews(); // Clear old data
        Cursor cursor = db.readAllData();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                TableRow row = new TableRow(this);

                TextView name = new TextView(this);
                name.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));
                name.setText(cursor.getString(1)); // Assuming 2nd column is Name
                name.setGravity(Gravity.CENTER);
                name.setPadding(10, 10, 10, 10);

                TextView marks = new TextView(this);
                marks.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));
                marks.setText(cursor.getString(2)); // Assuming 3rd column is Marks
                marks.setGravity(Gravity.CENTER);
                marks.setPadding(10, 10, 10, 10);

                row.addView(name);
                row.addView(marks);
                tableLayout.addView(row);
            }
            cursor.close();
        }

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(Leaderboard.this, MainActivity.class);
            startActivity(intent);
        });
    }
}