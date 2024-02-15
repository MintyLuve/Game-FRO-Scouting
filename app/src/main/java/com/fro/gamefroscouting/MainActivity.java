package com.fro.gamefroscouting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    //declaring
    //buttons
    TextView startButton;
    ImageButton helpButton;
    //edit texts
    EditText scouterName;
    EditText matchNum;
    //dropdowns
    AutoCompleteTextView teamType;
    Spinner posSpinner;
    Spinner humSpinner;

    String empty = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instantiating
        //button
        startButton = findViewById(R.id.startButton);
        helpButton = findViewById(R.id.helpButton);
        //edit texts
        scouterName = findViewById(R.id.nameType);
        matchNum = findViewById(R.id.matchType);
        //dropdowns
        teamType = findViewById(R.id.teamType);
        posSpinner = findViewById(R.id.posSpinner);
        humSpinner = findViewById(R.id.humanSpinner);

        String[] teamNums = getResources().getStringArray(R.array.team_numbers);
        //adds options to the team type box
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, teamNums);
        teamType.setThreshold(1);
        teamType.setAdapter(adapter);
        // adds options to the position spinner
        ArrayAdapter<CharSequence> posAdapter = ArrayAdapter.createFromResource
                (this, R.array.positions, android.R.layout.simple_spinner_item);
        posAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        posSpinner.setAdapter(posAdapter);
        // adds options to the human player spinner
        ArrayAdapter<CharSequence> humAdapter = ArrayAdapter.createFromResource
                (this, R.array.hum_pos, android.R.layout.simple_spinner_item);
        humAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        humSpinner.setAdapter(humAdapter);

        //Saving values when switching pages
        //type dropdown
        teamType.setText(String.valueOf(Values.start_team_num));
        // dropdown
        posSpinner.setSelection(Values.start_robot_pos);
        humSpinner.setSelection(Values.start_human_pos);
        //type boxes
        scouterName.setText(Values.start_scout_name);
        matchNum.setText(empty+ Values.start_match_num);

        //when item is selected, it sets it's Value var
        posSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {Values.start_robot_pos = posSpinner.getSelectedItemPosition();}
            public void onNothingSelected(AdapterView<?> parent) {Values.start_robot_pos = parent.getSelectedItemPosition();}
        });
        humSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {Values.start_human_pos = humSpinner.getSelectedItemPosition();}
            public void onNothingSelected(AdapterView<?> parent) {Values.start_human_pos = parent.getSelectedItemPosition();}
        });
        //dropdown type return values
        teamType.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void afterTextChanged(Editable editable) {
                String text = teamType.getText().toString();
                if (!text.equals("")){
                    Values.start_team_num = Integer.parseInt(teamType.getText().toString());
                }}
        });

        //adding scouter name return values
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
                    public void onClick(View v) {snackbar.dismiss();}
                });
                // add the custom snack bar layout to snack bar layout
                snackbarLayout.addView(mySnackBar, 0);
                snackbar.show();

                snackbar.addCallback(new Snackbar.Callback(){ @Override
                    public void onDismissed(Snackbar snackbar, int event) {helpButton.setImageResource(R.drawable.menu_help_button);}});
            }
        });

    }
}