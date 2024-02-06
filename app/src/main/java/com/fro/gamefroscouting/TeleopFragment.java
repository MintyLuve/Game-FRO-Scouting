package com.fro.gamefroscouting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TeleopFragment extends Fragment {
    //declaring
    //variable type 1


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_teleop, container, false);
        //instantiating
        //variable type 1


        // Inflate the layout for this fragment
        return rootView;
    }
}