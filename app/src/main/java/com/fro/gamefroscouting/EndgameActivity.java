package com.fro.gamefroscouting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EndgameActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endgame);


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.auto_button);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.teleop_button) {
                startActivity(new Intent(getApplicationContext(), TeleopActivity.class));
                Toast.makeText(this, "Tele Op Button", Toast.LENGTH_SHORT).show();
                finish();
            }
            else if (item.getItemId() == R.id.auto_button) {
                startActivity(new Intent(getApplicationContext(), AutoActivity.class));
                Toast.makeText(this, "Auto Button", Toast.LENGTH_SHORT).show();
                finish();
            }
            else if (item.getItemId() == R.id.notes_button) {
                startActivity(new Intent(getApplicationContext(), NotesActivity.class));
                Toast.makeText(this, "Notes Button", Toast.LENGTH_SHORT).show();
                finish();
            }
            else if (item.getItemId() == R.id.help_button) {
                Toast.makeText(this, "Help Button", Toast.LENGTH_SHORT).show();
                finish();
            }
            return false;
        });

        bottomNavigationView.setItemIconTintList(null);
    }
}