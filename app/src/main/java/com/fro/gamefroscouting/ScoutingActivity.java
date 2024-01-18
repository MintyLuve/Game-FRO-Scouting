package com.fro.gamefroscouting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ScoutingActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    ImageButton help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouting);

        //init var
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        drawerLayout = findViewById(R.id.drawer_layout);
        help = findViewById(R.id.helpButton);

        // switching fragments
        replaceFragment(new AutoFragment());

        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.auto_button) {
                replaceFragment(new AutoFragment());
            } else if (item.getItemId() == R.id.teleop_button) {
                replaceFragment(new TeleopFragment());
            } else if (item.getItemId() == R.id.endgame_button) {
                replaceFragment(new EndgameFragment());
            } else if (item.getItemId() == R.id.notes_button) {
                replaceFragment(new NotesFragment());
            }
            return true;
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

                View behind = mySnackbar.findViewById(R.id.behind);
                behind.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });

                // add the custom snack bar layout to snackbar layout
                snackbarLayout.addView(mySnackbar, 0);
                snackbar.show();


            }
        });
    }

    private  void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}