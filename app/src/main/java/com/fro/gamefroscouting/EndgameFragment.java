package com.fro.gamefroscouting;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.fro.gamefroscouting.R;

public class EndgameFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_endgame, container, false);

        Spinner posSpinner =  rootView.findViewById(R.id.posSpinner);

        // adds options to the position spinner
        ArrayAdapter<CharSequence> posAdapter = ArrayAdapter.createFromResource
                (getActivity(), R.array.end_pos, android.R.layout.simple_spinner_item);
        posAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        posSpinner.setAdapter(posAdapter);

        //Saving values when switching pages
        // spinner
        int spinnerPosition = posAdapter.getPosition(Values.eg_end_pos);
        posSpinner.setSelection(spinnerPosition);

        //when item is selected, it sets it's Value var
        posSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Values.eg_end_pos = parent.getItemAtPosition(pos).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }
}