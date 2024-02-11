package com.fro.gamefroscouting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    //declaring
    //button
    TextView startButton;
    ImageButton helpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instantiating
        //button
        startButton = findViewById(R.id.startButton);
        helpButton = findViewById(R.id.helpButton);

        // changes to next page on click
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScoutingActivity.class));
            }
        });

        // help snack bar
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // makes a snack bar with no text (length is time)
                final Snackbar snackbar = Snackbar.make(v, "", Snackbar.LENGTH_INDEFINITE);
                // set the background to my snack bar
                View mySnackBar = getLayoutInflater().inflate(R.layout.help_snackbar_main, null);
                //makes background transparent so the custom view can be seen
                snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
                //changes snack bar layout
                @SuppressLint("RestrictedApi") Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
                snackbarLayout.setPadding(0, 0, 0, 0);
                //sets the button to have an x
                helpButton.setImageResource(R.drawable.menu_help_exit_button);

                //when behind is clicked it dismisses the snack bar
                View behind = mySnackBar.findViewById(R.id.behind);
                behind.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                // add the custom snack bar layout to snack bar layout
                snackbarLayout.addView(mySnackBar, 0);
                snackbar.show();

                snackbar.addCallback(new Snackbar.Callback(){
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        helpButton.setImageResource(R.drawable.menu_help_button);
                    }});
            }
        });

    }
}