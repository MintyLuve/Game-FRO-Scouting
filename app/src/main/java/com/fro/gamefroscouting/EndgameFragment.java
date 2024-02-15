package com.fro.gamefroscouting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.materialswitch.MaterialSwitch;

public class EndgameFragment extends Fragment {
    //declaring
    //throws made
    ImageButton madePlus;
    ImageButton madeMinus;
    TextView madeNum;
    // throws missed
    ImageButton missedPlus;
    ImageButton missedMinus;
    TextView missedNum;
    //switch
    MaterialSwitch buddySwitch;
    MaterialSwitch leftSwitch;
    MaterialSwitch centerSwitch;
    MaterialSwitch rightSwitch;
    //spinners
    Spinner posSpinner;
    Spinner climbSpinner;

    //int totThrows = 3;
    //int throwsMade = 0;
    //int throwsMissed = 0;

    String empty = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_endgame, container, false);
        //instantiating
        //throws made
        madePlus = rootView.findViewById(R.id.made_plus);
        madeMinus = rootView.findViewById(R.id.made_minus);
        madeNum = rootView.findViewById(R.id.made_num);
        // throws missed
        missedPlus = rootView.findViewById(R.id.miss_plus);
        missedMinus = rootView.findViewById(R.id.miss_minus);
        missedNum = rootView.findViewById(R.id.miss_num);
        //switch
        buddySwitch = rootView.findViewById(R.id.buddySwitch);
        leftSwitch = rootView.findViewById(R.id.leftSwitch);
        centerSwitch = rootView.findViewById(R.id.centerSwitch);
        rightSwitch = rootView.findViewById(R.id.rightSwitch);
        //spinners
        posSpinner = rootView.findViewById(R.id.posSpinner);
        climbSpinner = rootView.findViewById(R.id.climbSpinner);

        // adds options to the position spinner
        ArrayAdapter<CharSequence> posAdapter = ArrayAdapter.createFromResource
                (getActivity(), R.array.positions, android.R.layout.simple_spinner_item);
        posAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        posSpinner.setAdapter(posAdapter);

        // adds options to the climb type spinner
        ArrayAdapter<CharSequence> climbAdapter = ArrayAdapter.createFromResource
                (getActivity(), R.array.climb_type, android.R.layout.simple_spinner_item);
        posAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        climbSpinner.setAdapter(posAdapter);

        //Saving values when switching pages
        //leave community switch
        buddySwitch.setChecked(Values.eg_buddy_climb);
        leftSwitch.setChecked(Values.eg_spot_left);
        centerSwitch.setChecked(Values.eg_spot_center);
        rightSwitch.setChecked(Values.eg_spot_right);
        // dropdown
        posSpinner.setSelection(Values.eg_end_pos);
        climbSpinner.setSelection(Values.eg_climb_type);
        //made
        madeNum.setText(empty+Values.eg_made);
        missedNum.setText(empty+Values.eg_missed);

        //when pos item is selected, it sets it's Value var
        posSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(getContext(), posSpinner.getId(), Toast.LENGTH_SHORT).show();
                Values.eg_end_pos = posSpinner.getId();}
            public void onNothingSelected(AdapterView<?> parent) {Values.eg_end_pos = posSpinner.getId();}
        });
        //when climb item is selected, it sets it's Value var
        climbSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {Values.eg_climb_type = parent.getId();}
            public void onNothingSelected(AdapterView<?> parent) {Values.eg_climb_type = parent.getId();}
        });

        //adding bonus switch
        buddySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Values.eg_buddy_climb = buddySwitch.isChecked();}
        });
        //adding bonus switch
        leftSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Values.eg_spot_left = leftSwitch.isChecked();}
        });
        //adding bonus switch
        centerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Values.eg_spot_center = centerSwitch.isChecked();}
        });
        //adding bonus switch
        rightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Values.eg_spot_right = rightSwitch.isChecked();}
        });

        //adding functions to number buttons
        //throws made
        plusOne(madePlus, madeNum,1, 3);
        minusOne(madeMinus, madeNum,1);
        // throws missed
        plusOne(missedPlus, missedNum,2, 3);
        minusOne(missedMinus, missedNum,2);

        // Inflate the layout for this fragment
        return rootView;
    }

    void plusOne(ImageButton button, TextView num, int key, int max){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gets the number from the view
                int number = Integer.parseInt(num.getText().toString());
                //sets the view to the number + 1
                if (number < max) {
                    number++;
                    String numOutput = empty + number;
                    num.setText(numOutput);
                }
                switch (key) {
                    case 1:
                        Values.eg_made = number;
                        break;
                    case 2:
                        Values.eg_missed = number;
                        break;
                }
            }
        });
    }
    void minusOne(ImageButton button, TextView num, int key) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gets the number from the view
                int number = Integer.parseInt(num.getText().toString());
                //sets the view to the number + 1
                if (number > 0) {
                    number--;
                    String numOutput = empty + number;
                    num.setText(numOutput);
                }
                switch (key) {
                    case 1:
                        Values.eg_made = number;
                        break;
                    case 2:
                        Values.eg_missed = number;
                        break;
                }
            }
        });
    }
}