package com.fro.gamefroscouting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.materialswitch.MaterialSwitch;

public class TeleopFragment extends Fragment {
    //declaring
    //not amplified speaker
    ImageButton nSpeakerPlus;
    ImageButton nSpeakerMinus;
    TextView nSpeakerNum;
    // amplified speaker
    ImageButton aSpeakerPlus;
    ImageButton aSpeakerMinus;
    TextView aSpeakerNum;
    //amp
    ImageButton ampPlus;
    ImageButton ampMinus;
    TextView ampNum;
    //trap
    ImageButton trapPlus;
    ImageButton trapMinus;
    TextView trapNum;
    //switch
    MaterialSwitch groundSwitch;
    MaterialSwitch sourceSwitch;
    MaterialSwitch bonusSwitch;

    String empty = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_teleop, container, false);
        //instantiating
        //not amplified speaker
        nSpeakerPlus = rootView.findViewById(R.id.nSpeaker_plus);
        nSpeakerMinus = rootView.findViewById(R.id.nSpeaker_minus);
        nSpeakerNum = rootView.findViewById(R.id.nSpeaker_num);
        //amplified speaker
        aSpeakerPlus = rootView.findViewById(R.id.aSpeaker_plus);
        aSpeakerMinus = rootView.findViewById(R.id.aSpeaker_minus);
        aSpeakerNum = rootView.findViewById(R.id.aSpeaker_num);
        //amp
        ampPlus = rootView.findViewById(R.id.amp_plus);
        ampMinus = rootView.findViewById(R.id.amp_minus);
        ampNum = rootView.findViewById(R.id.amp_num);
        //trap
        trapPlus = rootView.findViewById(R.id.trap_plus);
        trapMinus = rootView.findViewById(R.id.trap_minus);
        trapNum = rootView.findViewById(R.id.trap_num);
        //switch
        groundSwitch = rootView.findViewById(R.id.groundSwitch);
        sourceSwitch = rootView.findViewById(R.id.sourceSwitch);
        bonusSwitch = rootView.findViewById(R.id.bonusSwitch);

        //Saving values when switching pages
        //switches
        groundSwitch.setChecked(Values.tele_ground_pickup);
        sourceSwitch.setChecked(Values.tele_source_pickup);
        bonusSwitch.setChecked(Values.tele_bonus);
        //buttons
        aSpeakerNum.setText(empty+Values.tele_aSpeaker);
        nSpeakerNum.setText(empty+Values.tele_nSpeaker);
        ampNum.setText(empty+Values.tele_amp);
        trapNum.setText(empty+Values.tele_trap);

        //adding ground switch
        groundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Values.tele_ground_pickup = groundSwitch.isChecked();}
        });
        //adding source switch
        sourceSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Values.tele_source_pickup = sourceSwitch.isChecked();}
        });
        //adding bonus switch
         bonusSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Values.tele_bonus = bonusSwitch.isChecked();}
        });

        //adding functions to number buttons
        // not amplified speaker
        plusOne(nSpeakerPlus, nSpeakerNum,1, 20);
        minusOne(nSpeakerMinus, nSpeakerNum,1);
        // amp
        plusOne(ampPlus, ampNum,2, 20);
        minusOne(ampMinus, ampNum,2);
        // trap
        plusOne(trapPlus, trapNum,3,3);
        minusOne(trapMinus, trapNum,3);
        // amplified speaker
        plusOne(aSpeakerPlus, aSpeakerNum,4, 20);
        minusOne(aSpeakerMinus, aSpeakerNum,4);

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
                        Values.tele_nSpeaker = number;
                        break;
                    case 2:
                        Values.tele_amp = number;
                        break;
                    case 3:
                        Values.tele_trap = number;
                        break;
                    case 4:
                        Values.tele_aSpeaker = number;
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
                        Values.tele_nSpeaker = number;
                        break;
                    case 2:
                        Values.tele_amp = number;
                        break;
                    case 3:
                        Values.tele_trap = number;
                        break;
                    case 4:
                        Values.tele_aSpeaker = number;
                }
            }
        });
    }
}