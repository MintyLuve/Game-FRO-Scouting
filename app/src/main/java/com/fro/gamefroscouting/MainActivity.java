package com.fro.gamefroscouting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    EditText scouterName;
    EditText matchNum;
    AutoCompleteTextView teamType;
    Spinner posSpinner;
    Button startButton;
    ImageButton help;

    String empty = "";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.button1);
        teamType = findViewById(R.id.teamType);
        posSpinner = findViewById(R.id.posSpinner);
        help = findViewById(R.id.helpButton);
        scouterName = findViewById(R.id.nameType);
        matchNum = findViewById(R.id.matchType);

        String[] teamNums = getResources().getStringArray(R.array.team_numbers);

        //adds typable dropdown to team spinner
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, teamNums);
        teamType.setThreshold(1);
        teamType.setAdapter(adapter);

        // adds options to the position spinner
        ArrayAdapter<CharSequence> posAdapter = ArrayAdapter.createFromResource
                (this, R.array.positions, android.R.layout.simple_spinner_item);
        posAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        posSpinner.setAdapter(posAdapter);

        //Saving values when switching pages
        //type dropdown
        teamType.setText(String.valueOf(Values.start_team_num));
        // dropdown
        int spinnerPosition = posAdapter.getPosition(Values.start_robo_pos);
        posSpinner.setSelection(spinnerPosition);
        //type boxes
        scouterName.setText(Values.start_scout_name);
        matchNum.setText(empty+ Values.start_match_num);

        //when item is selected, it sets it's Value var
        posSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Values.start_robo_pos = parent.getItemAtPosition(pos).toString();}
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        //spinner return values
        teamType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
                String returnValue = (String)parent.getItemAtPosition(position);
                Values.start_team_num = Integer.parseInt(returnValue);
            }
        });

        //adding type box return values
        scouterName.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {Values.start_scout_name = scouterName.getText().toString();}
        });
        matchNum.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {
                String stringVal = matchNum.getText().toString();
                if (!stringVal.isEmpty()){Values.start_match_num = Integer.parseInt(stringVal);}
                else {Values.start_match_num = 0;}
            }
        });

        // changes to next page on click
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScoutingActivity.class));
            }
        });

        // help snack bar
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // makes a snack bar with no text (length is time)
                final Snackbar snackbar = Snackbar.make(v, "", Snackbar.LENGTH_INDEFINITE);
                // set the background to my snack bar
                View mySnackBar = getLayoutInflater().inflate(R.layout.help_snackbar_mainpg, null);
                //makes background transparent so the custom view can be seen
                snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
                //changes snack bar layout
                @SuppressLint("RestrictedApi") Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
                snackbarLayout.setPadding(0, 0, 0, 0);
                //sets the button to have an x
                help.setImageResource(R.drawable.menu_help_exit);

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
                        help.setImageResource(R.drawable.menu_help_button);
                    }});
            }
        });
    }
}