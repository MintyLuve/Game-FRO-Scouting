package com.fro.gamefroscouting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TeleopActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop);


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.auto_button);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.auto_button) {
                startActivity(new Intent(getApplicationContext(), AutoActivity.class));
                Toast.makeText(this, "Auto Button", Toast.LENGTH_SHORT).show();
                finish();
            }
            else if (item.getItemId() == R.id.endgame_button) {
                startActivity(new Intent(getApplicationContext(), EndgameActivity.class));
                Toast.makeText(this, "Endgame Button", Toast.LENGTH_SHORT).show();
                finish();
            }
            else if (item.getItemId() == R.id.notes_button) {
                startActivity(new Intent(getApplicationContext(), NotesActivity.class));
                Toast.makeText(this, "Notes Button", Toast.LENGTH_SHORT).show();
                finish();
            }

            return false;
        });

        bottomNavigationView.setItemIconTintList(null);
    }
}