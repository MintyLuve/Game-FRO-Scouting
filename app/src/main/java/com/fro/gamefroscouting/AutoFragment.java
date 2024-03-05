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

public class AutoFragment extends Fragment {
    //declaring
    //speaker
    ImageButton speakerPlus;
    ImageButton speakerMinus;
    TextView speakerNum;
    //amp
    ImageButton ampPlus;
    ImageButton ampMinus;
    TextView ampNum;
    //trap
    ImageButton trapPlus;
    ImageButton trapMinus;
    TextView trapNum;
    //switch
    MaterialSwitch leaveSwitch;

    String empty = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_auto, container, false);
        //instantiating
        //speaker
        speakerPlus = rootView.findViewById(R.id.speaker_plus);
        speakerMinus = rootView.findViewById(R.id.speaker_minus);
        speakerNum = rootView.findViewById(R.id.speaker_num);
        //amp
        ampPlus = rootView.findViewById(R.id.amp_plus);
        ampMinus = rootView.findViewById(R.id.amp_minus);
        ampNum = rootView.findViewById(R.id.amp_num);
        //trap
        trapPlus = rootView.findViewById(R.id.trap_plus);
        trapMinus = rootView.findViewById(R.id.trap_minus);
        trapNum = rootView.findViewById(R.id.trap_num);
        //switch
        leaveSwitch = rootView.findViewById(R.id.leaveSwitch);

        //Saving values when switching pages
        //leave community switch
        leaveSwitch.setChecked(Values.auto_leave_start);
        //buttons
        speakerNum.setText(empty+Values.auto_speaker);
        ampNum.setText(empty+Values.auto_amp);
        trapNum.setText(empty+Values.auto_trap);

        //adding switch
        leaveSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Values.auto_leave_start = leaveSwitch.isChecked();}
        });

        //adding functions to number buttons
        // speaker
        plusOne(speakerPlus, speakerNum,1, 20);
        minusOne(speakerMinus, speakerNum,1);
        // amp
        plusOne(ampPlus, ampNum,2, 20);
        minusOne(ampMinus, ampNum,2);
        // trap
        plusOne(trapPlus, trapNum,3,3);
        minusOne(trapMinus, trapNum,3);

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
                        Values.auto_speaker = number;
                        break;
                    case 2:
                        Values.auto_amp = number;
                        break;
                    case 3:
                        Values.auto_trap = number;
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
                        Values.auto_speaker = number;
                        break;
                    case 2:
                        Values.auto_amp = number;
                        break;
                    case 3:
                        Values.auto_trap = number;
                        break;
                }
            }
        });
    }
}