package com.fro.gamefroscouting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button bShowSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // register the button with appropriate ID
        bShowSnackbar = findViewById(R.id.showSnackbarButton);

        bShowSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // create an instance of the snackbar
                final Snackbar snackbar = Snackbar.make(v, "", Snackbar.LENGTH_LONG);

                // inflate the custom_snackbar_view created previously
                View customSnackView = getLayoutInflater().inflate(R.layout.custom_snackbar_view, null);

                // set the background of the default snackbar as transparent
                snackbar.getView().setBackgroundColor(Color.TRANSPARENT);

                // now change the layout of the snackbar
                Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();

                // set padding of the all corners as 0
                snackbarLayout.setPadding(0, 0, 0, 0);

                // register the button from the custom_snackbar_view layout file
                Button bGotoWebsite = customSnackView.findViewById(R.id.gotoWebsiteButton);

                // now handle the same button with onClickListener
                bGotoWebsite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Redirecting to Website", Toast.LENGTH_SHORT).show();
                        snackbar.dismiss();
                    }
                });

                // add the custom snack bar layout to snackbar layout
                snackbarLayout.addView(customSnackView, 0);

                snackbar.show();
            }
        });
    }
}
