package com.fro.gamefroscouting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button1);
        AutoCompleteTextView teamType = (AutoCompleteTextView) findViewById(R.id.teamType);
        Spinner posSpinner = (Spinner) findViewById(R.id.posSpinner);

        String[] teamNums = getResources().getStringArray(R.array.team_numbers);

        // changes to next page on click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScoutingActivity.class));
            }
        });

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
    }
}