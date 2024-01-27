package com.fro.gamefroscouting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton plus;
    ImageButton minus;
    TextView textView;
    int textNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        textView = findViewById(R.id.number);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textNum < 20){
                    textNum++;
                    textView.setText(""+textNum);
                }            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textNum > 0){
                    textNum--;
                    textView.setText(""+textNum);
                }
            }
        });
    }
}