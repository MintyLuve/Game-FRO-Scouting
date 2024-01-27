package com.fro.gamefroscouting;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.fro.gamefroscouting.R;

public class NotesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notes, container, false);

        AutoCompleteTextView defendsSpinner =  rootView.findViewById(R.id.defendsSpinner);
        AutoCompleteTextView defendedSpinner =  rootView.findViewById(R.id.defendedSpinner);

        String[] teamNums = getResources().getStringArray(R.array.team_numbers);

        //adds typable dropdown to spinners
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, teamNums);
        defendsSpinner.setThreshold(1);
        defendsSpinner.setAdapter(adapter);

        defendedSpinner.setThreshold(1);
        defendedSpinner.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }
}