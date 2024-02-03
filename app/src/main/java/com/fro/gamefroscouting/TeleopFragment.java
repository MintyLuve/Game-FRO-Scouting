package com.fro.gamefroscouting;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fro.gamefroscouting.R;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class TeleopFragment extends Fragment {
    //switches
    MaterialSwitch ground_pk;
    MaterialSwitch single_pk;
    MaterialSwitch double_pk;
    //cone bottom
    ImageButton coBoPlus;
    ImageButton coBoMinus;
    TextView coBoNum;
    //cone middle
    ImageButton coMiPlus;
    ImageButton coMiMinus;
    TextView coMiNum;
    //cone top
    ImageButton coToPlus;
    ImageButton coToMinus;
    TextView coToNum;
    //cube bottom
    ImageButton cuBoPlus;
    ImageButton cuBoMinus;
    TextView cuBoNum;
    //cube middle
    ImageButton cuMiPlus;
    ImageButton cuMiMinus;
    TextView cuMiNum;
    //cube top
    ImageButton cuToPlus;
    ImageButton cuToMinus;
    TextView cuToNum;

    String empty = "";


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_teleop, container, false);
        //instantiating
        //switches
        ground_pk = rootView.findViewById(R.id.groundSwitch);
        single_pk = rootView.findViewById(R.id.singleSwitch);
        double_pk = rootView.findViewById(R.id.doubleSwitch);
        //cone bottom
        coBoPlus = rootView.findViewById(R.id.co_bo_plus);
        coBoMinus = rootView.findViewById(R.id.co_bo_minus);
        coBoNum = rootView.findViewById(R.id.co_bo_num);
        //cone middle
        coMiPlus = rootView.findViewById(R.id.co_mi_plus);
        coMiMinus = rootView.findViewById(R.id.co_mi_minus);
        coMiNum = rootView.findViewById(R.id.co_mi_num);
        //cone top
        coToPlus = rootView.findViewById(R.id.co_to_plus);
        coToMinus = rootView.findViewById(R.id.co_to_minus);
        coToNum = rootView.findViewById(R.id.co_to_num);
        //cube bottom
        cuBoPlus = rootView.findViewById(R.id.cu_bo_plus);
        cuBoMinus = rootView.findViewById(R.id.cu_bo_minus);
        cuBoNum = rootView.findViewById(R.id.cu_bo_num);
        //cube middle
        cuMiPlus = rootView.findViewById(R.id.cu_mi_plus);
        cuMiMinus = rootView.findViewById(R.id.cu_mi_minus);
        cuMiNum = rootView.findViewById(R.id.cu_mi_num);
        //cube top
        cuToPlus = rootView.findViewById(R.id.cu_to_plus);
        cuToMinus = rootView.findViewById(R.id.cu_to_minus);
        cuToNum = rootView.findViewById(R.id.cu_to_num);

        //Saving values when switching pages
        //pickup switches
        ground_pk.setChecked(Values.tele_ground);
        single_pk.setChecked(Values.tele_single);
        double_pk.setChecked(Values.tele_double);
        //cones
        coBoNum.setText(empty+Values.tele_co_bo);
        coMiNum.setText(empty+Values.tele_co_mi);
        coToNum.setText(empty+Values.tele_co_to);
        //cubes
        cuBoNum.setText(empty+Values.tele_cu_bo);
        cuMiNum.setText(empty+Values.tele_cu_mi);
        cuToNum.setText(empty+Values.tele_cu_to);

        //adding switches
        //ground pickup
        ground_pk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Values.tele_ground = ground_pk.isChecked();}
        });
        //single pickup
        single_pk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Values.tele_single = single_pk.isChecked();}
        });
        //double pickup
        double_pk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Values.tele_double = double_pk.isChecked();}
        });

        //adding functions to number buttons
        // cone bottom
        plusOne(coBoPlus, coBoNum,1);
        minusOne(coBoMinus, coBoNum,1);
        // cone middle
        plusOne(coMiPlus, coMiNum,2);
        minusOne(coMiMinus, coMiNum,2);
        // cone top
        plusOne(coToPlus, coToNum,3);
        minusOne(coToMinus, coToNum,3);
        // cube bottom
        plusOne(cuBoPlus, cuBoNum,4);
        minusOne(cuBoMinus, cuBoNum,4);
        // cube middle
        plusOne(cuMiPlus, cuMiNum,5);
        minusOne(cuMiMinus, cuMiNum,5);
        // cube top
        plusOne(cuToPlus, cuToNum,6);
        minusOne(cuToMinus, cuToNum,6);

        // Inflate the layout for this fragment
        return rootView;
    }

    void plusOne(ImageButton button, TextView num, int key){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gets the number from the view
                int number = Integer.parseInt(num.getText().toString());
                //sets the view to the number + 1
                if (number < 20) {
                    number++;
                    String numOutput = empty + number;
                    num.setText(numOutput);
                }
                switch (key){
                    case 1: Values.tele_co_bo = number;
                        break;
                    case 2: Values.tele_co_mi = number;
                        break;
                    case 3: Values.tele_co_to = number;
                        break;
                    case 4: Values.tele_cu_bo = number;
                        break;
                    case 5: Values.tele_cu_mi = number;
                        break;
                    case 6: Values.tele_cu_to = number;
                        break;
                }
            }
        });
    }
    void minusOne(ImageButton button, TextView num, int key){
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
                switch (key){
                    case 1: Values.tele_co_bo = number;
                        break;
                    case 2: Values.tele_co_mi = number;
                        break;
                    case 3: Values.tele_co_to = number;
                        break;
                    case 4: Values.tele_cu_bo = number;
                        break;
                    case 5: Values.tele_cu_mi = number;
                        break;
                    case 6: Values.tele_cu_to = number;
                        break;
                }
            }
        });
    }
}