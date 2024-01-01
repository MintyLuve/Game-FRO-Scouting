package com.fro.gamefroscouting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AutoActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.page_2);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.page_1) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(this, "Page 2 thing", Toast.LENGTH_SHORT).show();
                finish();
            }
            else if (item.getItemId() == R.id.submit) {
                //startActivity(new Intent(getApplicationContext(), SubmitActivity.class));
                Toast.makeText(this, "Submit thing", Toast.LENGTH_SHORT).show();

                finish();
            }
            return false;
        });
    }
}