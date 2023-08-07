package com.example.bussigns;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DisplayController displayController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find TextViews from the layout
        TextView busA = findViewById(R.id.busA);
        TextView destinationA = findViewById(R.id.destinationA);
        TextView minutesAwayA = findViewById(R.id.minutesAwayA);

        TextView busB = findViewById(R.id.busB);
        TextView destinationB = findViewById(R.id.destinationB);
        TextView minutesAwayB = findViewById(R.id.minutesAwayB);

        TextView busC = findViewById(R.id.busC);
        TextView destinationC = findViewById(R.id.destinationC);
        TextView minutesAwayC = findViewById(R.id.minutesAwayC);

        TextView busD = findViewById(R.id.busD);
        TextView destinationD = findViewById(R.id.destinationD);
        TextView minutesAwayD = findViewById(R.id.minutesAwayD);

        TextView busStop = findViewById(R.id.busStop);

        // Create an instance of DisplayController
        displayController = new DisplayController(
                new TextView[]{busA, busB, busC, busD},
                new TextView[]{destinationA, destinationB, destinationC, destinationD},
                new TextView[]{minutesAwayA, minutesAwayB, minutesAwayC, minutesAwayD},
                busStop
        );

        // Start updating bus information
        displayController.startUpdatingBusInfo();
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayController.startUpdatingBusInfo();
    }

    @Override
    protected void onPause() {
        super.onPause();
        displayController.stopUpdatingBusInfo();
    }
}

