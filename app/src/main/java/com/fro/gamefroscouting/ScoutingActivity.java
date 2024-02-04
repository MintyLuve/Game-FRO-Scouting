package com.fro.gamefroscouting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class ScoutingActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    ImageButton help;
    ImageButton menu;
    Calendar calendar;
    //defining buttons
    Button yesButton;
    Button noButton;
    //defining text view
    TextView confirmation;
    //defining frame
    ConstraintLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouting);

        // init buttons
        yesButton = (Button) findViewById(R.id.yesButton);
        noButton = (Button) findViewById(R.id.noButton);
        //init textview
        confirmation = (TextView) findViewById(R.id.confirmation);
        //init frame
        frame = findViewById(R.id.confirmFrame);
        //init var
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        drawerLayout = findViewById(R.id.drawer_layout);
        help = findViewById(R.id.helpButton);
        menu = findViewById(R.id.menuButton);
        calendar = Calendar.getInstance();

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

        // help snack bar
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // makes a snack bar with no text (length is time)
                final Snackbar snackbar = Snackbar.make(v, "", Snackbar.LENGTH_INDEFINITE);
                // set the background to my snack bar
                View mySnackBar = getLayoutInflater().inflate(R.layout.help_snackbar, null);
                //makes background transparent so the custom view can be seen
                snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
                //changes snack bar layout
                @SuppressLint("RestrictedApi") Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
                snackbarLayout.setPadding(0, 0, 0, 0);
                //sets the button to have an x
                help.setBackgroundResource(R.drawable.menu_help_exit);

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
                        help.setBackgroundResource(R.drawable.menu_help_button);
                    }});
            }
        });

        // menu snack bar
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // makes a snack bar with no text
                final Snackbar snackbar = Snackbar.make(v, "", Snackbar.LENGTH_INDEFINITE);
                // set the background to my snack bar
                View mySnackbar = getLayoutInflater().inflate(R.layout.menu_snackbar, null);
                //makes background transparent so the custom view can be seen
                snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
                //changes snack bar layout
                @SuppressLint("RestrictedApi") Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
                snackbarLayout.setPadding(0, 0, 0, 0);
                menu.setBackgroundResource(R.drawable.menu_bars_exit);

                // behind button
                View behind = mySnackbar.findViewById(R.id.behind);
                behind.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                // back button
                View back = mySnackbar.findViewById(R.id.returnButton);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                });
                // submit button
                View submit = mySnackbar.findViewById(R.id.submitButton);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        frame.setVisibility(View.VISIBLE);
                        yesButton.setVisibility(View.VISIBLE);
                        noButton.setVisibility(View.VISIBLE);
                        confirmation.setVisibility(View.VISIBLE);

                        //If yes button is clicked, sets the buttons invisible, and outputs the data into a JSON
                        yesButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                yesButton.setVisibility(View.INVISIBLE);
                                noButton.setVisibility(View.INVISIBLE);
                                SubmitJSON submitJSON = new SubmitJSON();
                                submitJSON.submitData(getApplicationContext().getFilesDir());
                                submitJSON.showToast(ScoutingActivity.this, getApplicationContext().getFilesDir());

                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        });
                        //If the no button is clicked it hides the buttons
                        noButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                yesButton.setVisibility(View.INVISIBLE);
                                noButton.setVisibility(View.INVISIBLE);
                                confirmation.setVisibility(View.INVISIBLE);
                                frame.setVisibility(View.INVISIBLE);
                            }
                        });
                    }
                });
                // add the custom snack bar layout to snack bar layout
                snackbarLayout.addView(mySnackbar, 0);
                snackbar.show();

                snackbar.addCallback(new Snackbar.Callback(){
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        menu.setBackgroundResource(R.drawable.menu_bars_button);
                }});
            }
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
    public void toJSON(JSONObject content) throws IOException {
        // Class to put the data into a JSON object
        File path = getApplicationContext().getFilesDir();
        Toast.makeText(ScoutingActivity.this, path.toString(), Toast.LENGTH_SHORT).show();
        FileOutputStream writer = new FileOutputStream(new File(path, "CRESCENDO_SCOUTING_DATA_" + calendar.getTimeInMillis() + ".json"));
        writer.write(content.toString().getBytes());
        writer.close();
    }

}