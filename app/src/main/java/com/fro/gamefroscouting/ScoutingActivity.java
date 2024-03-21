package com.fro.gamefroscouting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

public class ScoutingActivity extends AppCompatActivity {
    //declaring
    //bottom menu
    BottomNavigationView menuBar;
    //mg buttons
    ImageButton helpButton;
    ImageButton menuButton;
    // init buttons
    ImageButton yesButton;
    ImageButton noButton;
    //init frame
    View frame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouting);
        //instantiating
        //bottom menu
        menuBar = findViewById(R.id.menu_items);
        //mg buttons
        helpButton = findViewById(R.id.helpButton);
        menuButton = findViewById(R.id.menuButton);
        // init buttons
        yesButton = findViewById(R.id.yesButton);
        noButton = findViewById(R.id.noButton);
        //init frame
        frame = findViewById(R.id.confirmFrame);

        // switching fragments
        replaceFragment(new AutoFragment());

        menuBar.setBackground(null);
        menuBar.setOnItemSelectedListener(item -> {

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
        //no tint on menu icons
        menuBar.setItemIconTintList(null);

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

                //init pages
                LinearLayout page1 = mySnackBar.findViewById(R.id.page1);
                LinearLayout page2 = mySnackBar.findViewById(R.id.page2);
                TextView pageNum = mySnackBar.findViewById(R.id.pageNum);

                //init arrows
                ImageButton leftArrow = mySnackBar.findViewById(R.id.leftArrow);
                ImageButton rightArrow = mySnackBar.findViewById(R.id.rightArrow);

                //when right arrow is clicked it changes the page
                rightArrow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        page1.setVisibility(View.GONE);
                        page2.setVisibility(View.VISIBLE);
                        pageNum.setText("Pg. 2");
                        rightArrow.setVisibility(View.INVISIBLE);
                        leftArrow.setVisibility(View.VISIBLE);
                    }
                });

                //when left arrow is clicked it changes the page
                leftArrow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        page1.setVisibility(View.VISIBLE);
                        page2.setVisibility(View.GONE);
                        pageNum.setText("Pg. 1");
                        rightArrow.setVisibility(View.VISIBLE);
                        leftArrow.setVisibility(View.INVISIBLE);
                    }
                });

                //when behind is clicked it dismisses the snack bar
                View behind = mySnackBar.findViewById(R.id.behind);
                behind.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {snackbar.dismiss();}
                });
                // add the custom snack bar layout to snack bar layout
                snackbarLayout.addView(mySnackBar, 0);
                snackbar.show();

                snackbar.addCallback(new Snackbar.Callback(){ @Override
                public void onDismissed(Snackbar snackbar, int event) {helpButton.setImageResource(R.drawable.menu_help_button);}});
            }
        });

        // menu snack bar
        menuButton.setOnClickListener(new View.OnClickListener() {
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
                menuButton.setImageResource(R.drawable.menu_bars_exit_button);

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
                        snackbar.dismiss();

                        //If yes button is clicked, sets the buttons invisible, and outputs the data into a JSON
                        yesButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                frame.setVisibility(View.INVISIBLE);
                                //Calls submitJSON class and submits all data
                                SubmitJSON submitJSON = new SubmitJSON();

                                submitJSON.submitData();
                                submitJSON.showToast(ScoutingActivity.this);

                                //Calls ResetValues class and clears all data
                                ResetValues resetValues = new ResetValues();
                                resetValues.clearData();

                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        });
                        //If the no button is clicked it hides the buttons
                        noButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
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
                        menuButton.setImageResource(R.drawable.menu_bars_button);
                    }});
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.replaceFrame, fragment);
        fragmentTransaction.commit();
    }
}