package com.fro.gamefroscouting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button snackies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        snackies = findViewById(R.id.showSnackbarButton);

        snackies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // makes a snackbar with no text
                final Snackbar snackbar = Snackbar.make(v, "", Snackbar.LENGTH_LONG);
                // set the background to my snackbar
                View mySnackbar = getLayoutInflater().inflate(R.layout.my_snackbar, null);
                //makes background transparent so the custom view can be seen
                snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
                //changes snackbar layout
                Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
                snackbarLayout.setPadding(0, 0, 0, 0);

                //Makes button do things
                Button myButton = mySnackbar.findViewById(R.id.button);
                myButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Button pressed", Toast.LENGTH_SHORT).show();
                    }
                });

                // add the custom snack bar layout to snackbar layout
                snackbarLayout.addView(mySnackbar, 0);
                snackbar.show();
            }
        });


    }
}