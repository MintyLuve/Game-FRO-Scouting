package com.fro.gamefroscouting;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fro.gamefroscouting.R;

public class AutoFragment extends Fragment {
    Spinner posSpinner;

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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_auto, container, false);
        //instantiating
        //spinner
        posSpinner =  rootView.findViewById(R.id.posSpinner);
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

        // adds options to the position spinner
        ArrayAdapter<CharSequence> posAdapter = ArrayAdapter.createFromResource
                (getActivity(), R.array.end_pos, android.R.layout.simple_spinner_item);
        posAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        posSpinner.setAdapter(posAdapter);

        //adding functions to them
        // cone bottom
        plusOne(coBoPlus, coBoNum);
        minusOne(coBoMinus, coBoNum);
        // cone middle
        plusOne(coMiPlus, coMiNum);
        minusOne(coMiMinus, coMiNum);
        // cone top
        plusOne(coToPlus, coToNum);
        minusOne(coToMinus, coToNum);
        // cube bottom
        plusOne(cuBoPlus, cuBoNum);
        minusOne(cuBoMinus, cuBoNum);
        // cube middle
        plusOne(cuMiPlus, cuMiNum);
        minusOne(cuMiMinus, cuMiNum);
        // cube top
        plusOne(cuToPlus, cuToNum);
        minusOne(cuToMinus, cuToNum);

        // Inflate the layout for this fragment
        return rootView;
    }

    void plusOne(ImageButton button, TextView num){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gets the number from the view
                int number = Integer.parseInt(num.getText().toString());
                //sets the view to the number + 1
                if (number < 20) {
                    number++;
                    num.setText("" + number);
                }}
        });
    }
    void minusOne(ImageButton button, TextView num){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gets the number from the view
                int number = Integer.parseInt(num.getText().toString());
                //sets the view to the number + 1
                if (number > 0) {
                    number--;
                    num.setText("" + number);
                }}
        });
    }
}