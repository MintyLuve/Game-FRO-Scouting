package com.fro.gamefroscouting;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.fro.gamefroscouting.R;

public class NotesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notes, container, false);

        Spinner defendsSpinner =  rootView.findViewById(R.id.defendsSpinner);
        Spinner defendedSpinner =  rootView.findViewById(R.id.defendedSpinner);

        // adds options to the defends spinner
        ArrayAdapter<CharSequence> defendsAdapter = ArrayAdapter.createFromResource
                (getActivity(), R.array.team_numbers, android.R.layout.simple_spinner_item);
        defendsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defendsSpinner.setAdapter(defendsAdapter);

        // adds options to the defended spinner
        ArrayAdapter<CharSequence> defendedAdapter = ArrayAdapter.createFromResource
                (getActivity(), R.array.team_numbers, android.R.layout.simple_spinner_item);
        defendedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defendedSpinner.setAdapter(defendedAdapter);

        // Inflate the layout for this fragment
        return rootView;
    }
}