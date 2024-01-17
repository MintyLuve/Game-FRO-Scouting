package com.fro.gamefroscouting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

public class AutoActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ImageButton help;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);

        //bottom nav
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.auto_button);
        help = findViewById(R.id.helpButton);

        //bottom nav
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.teleop_button) {
                startActivity(new Intent(getApplicationContext(), TeleopActivity.class));
                Toast.makeText(this, "Tele Op Button", Toast.LENGTH_SHORT).show();
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

        //snackbar
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // makes a snackbar with no text
                final Snackbar snackbar = Snackbar.make(v, "", Snackbar.LENGTH_LONG);
                // set the background to my snackbar
                View mySnackbar = getLayoutInflater().inflate(R.layout.help_snackbar, null);
                //makes background transparent so the custom view can be seen
                snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
                //changes snackbar layout
                Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
                snackbarLayout.setPadding(0, 0, 0, 0);
                // add the custom snack bar layout to snackbar layout
                snackbarLayout.addView(mySnackbar, 0);
                snackbar.show();
            }
        });
    }
}