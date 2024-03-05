package com.fro.gamefroscouting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.materialswitch.MaterialSwitch;

public class NotesFragment extends Fragment {
    //declaring
    //switches
    MaterialSwitch robot_break;
    MaterialSwitch robot_tip;
    MaterialSwitch robot_penalties;
    //Typable dropdown
    AutoCompleteTextView defendsType;
    AutoCompleteTextView defendedType;
    //notes box
    EditText typeBox;
    //misc
    String empty = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notes, container, false);
        //instantiating
        //typable dropdown
        defendsType = rootView.findViewById(R.id.defendsType);
        defendedType = rootView.findViewById(R.id.defendedType);
        //switches
        robot_break = rootView.findViewById(R.id.breakSwitch);
        robot_tip = rootView.findViewById(R.id.tipSwitch);
        robot_penalties = rootView.findViewById(R.id.penaltiesSwitch);
        // notes box
        typeBox = rootView.findViewById(R.id.notesType);

        String[] teamNums = getResources().getStringArray(R.array.team_numbers);
        //adds typable dropdown to spinners
        ArrayAdapter<String> defsAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, teamNums);
        defendsType.setThreshold(1);
        defendsType.setAdapter(defsAdapter);
        ArrayAdapter<String> defdAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, teamNums);
        defendedType.setThreshold(1);
        defendedType.setAdapter(defdAdapter);

        //Saving values when switching pages
        //switches
        robot_break.setChecked(Values.notes_robo_break);
        robot_tip.setChecked(Values.notes_robo_tip);
        robot_penalties.setChecked(Values.notes_penalty);
        //dropdowns
        defendsType.setText(String.valueOf(Values.notes_defends));
        defendedType.setText(String.valueOf(Values.notes_defended));
        //type box
        typeBox.setText(Values.notes_type_box);

        //dropdown type return values
        defendsType.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void afterTextChanged(Editable editable) {
                String text = defendsType.getText().toString();
                if (!text.equals("")){
                    Values.notes_defends = Integer.parseInt(defendsType.getText().toString());
                }
            }
        });
        defendedType.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void afterTextChanged(Editable editable) {
                String text = defendedType.getText().toString();
                if (!text.equals("")){
                    Values.notes_defended = Integer.parseInt(defendedType.getText().toString());
                }
            }
        });

        //adding switch return values
        // robot break
        robot_break.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {@Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Values.notes_robo_break = robot_break.isChecked();}
        });
        // robot tipped
        robot_tip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {@Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Values.notes_robo_tip = robot_tip.isChecked();}
        });
        // penalties
        robot_penalties.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {@Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Values.notes_penalty = robot_penalties.isChecked();}
        });

        //adding type box return values
        typeBox.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {Values.notes_type_box = typeBox.getText().toString();}
        });

        // Inflate the layout for this fragment
        return rootView;
    }
}