package com.example.bussigns;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayController {
    private static final String BASE_URL = "http://bustime.mta.info/api/siri/";
    private static final long REFRESH_INTERVAL = 60 * 1000; // Refresh every minute
    private static final long FLASH_INTERVAL = 500;
    private static final long RETRY_DELAY = 5000;
    private TextView[] busTextViews;
    private TextView[] destinationTextViews;
    private TextView[] minutesAwayTextViews;
    private TextView busStop;
    private Handler handler;
    private BusService busService;
    private Gson gson;

    public DisplayController(TextView[] busTextViews, TextView[] destinationTextViews,
                             TextView[] minutesAwayTextViews, TextView busStop) {
        this.busTextViews = busTextViews;
        this.destinationTextViews = destinationTextViews;
        this.minutesAwayTextViews = minutesAwayTextViews;
        this.busStop = busStop;

        // Initialize Gson
        gson = new GsonBuilder().create();

        // Initialize Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // Create BusService instance
        busService = retrofit.create(BusService.class);

        // Initialize handler
        handler = new Handler(Looper.getMainLooper());
    }

    public void startUpdatingBusInfo() {
        // Fetch initial bus data
        Log.d("initialFetch", "Initial fetching...");
        fetchBusData();

        // Schedule periodic bus data updates
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("periodicFetch", "Clearing and updating data...");
                fetchBusData();
                handler.postDelayed(this, REFRESH_INTERVAL);
            }
        }, REFRESH_INTERVAL);
    }


    public void stopUpdatingBusInfo() {
        handler.removeCallbacksAndMessages(null);
    }

    private void fetchBusData() {
        Log.d("fetchBusData", "Fetching bus data...");
        String key = "524f55c7-e8e3-445d-9919-44ae5dcd843b";
        String monitoringRef = "200660";

        Call<ResponseBody> call = busService.getBusData(key, monitoringRef);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String jsonResponse = response.body().string();
                        Log.d("fetchBusData", "JSON Response: " + jsonResponse); // Print the JSON response
                        Gson gson = new Gson();
                        BusResponse busResponse = gson.fromJson(jsonResponse, BusResponse.class);
                        if (busResponse != null) {
                            updateBusInfo(busResponse);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Handle error response
                    Log.e("fetchBusData", "Error response: " + response.code());
                    // Retry the API call after a delay
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            fetchBusData(); // Retry the API call
                        }
                    }, RETRY_DELAY);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // Handle failure
                Log.e("fetchBusData", "Error: " + t.getMessage());
                // Retry the API call after a delay
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fetchBusData(); // Retry the API call
                    }
                }, RETRY_DELAY);
            }
        });
    }


    private void updateBusInfo(BusResponse busResponse) {
        // Clear previous bus information
        clearBusInfo();

        List<BusResponse.MonitoredStopVisit> monitoredStopVisits = busResponse.getSiri().getServiceDelivery().getStopMonitoringDelivery().get(0).getMonitoredStopVisit();

        // Iterate over each monitored stop visit and update the UI
        for (int i = 0; i < monitoredStopVisits.size(); i++) {
            if (i >= busTextViews.length || i >= destinationTextViews.length || i >= minutesAwayTextViews.length) {
                break; // Ignore if there are not enough UI elements
            }

            BusResponse.MonitoredStopVisit monitoredStopVisit = monitoredStopVisits.get(i);
            BusResponse.MonitoredVehicleJourney vehicleJourney = monitoredStopVisit.getMonitoredVehicleJourney();

            TextView busTextView = busTextViews[i];
            TextView destinationTextView = destinationTextViews[i];
            TextView minutesAwayTextView = minutesAwayTextViews[i];

            // Extract the desired information from the vehicle journey and update the UI
            String busRoute = vehicleJourney.getPublishedLineName();
            String busDestination = vehicleJourney.getDestinationName();

            // Log the bus information
            Log.d("updateBusInfo", "Route: " + busRoute);
            Log.d("updateBusInfo", "Destination: " + busDestination);

            // Update the UI with the bus information
            updateBusInfo(busTextView, destinationTextView, minutesAwayTextView, vehicleJourney);
        }
    }


    private void clearBusInfo() {
        for (TextView busTextView : busTextViews) {
            busTextView.setText("");
        }

        for (TextView destinationTextView : destinationTextViews) {
            destinationTextView.setText("");
        }

        for (TextView minutesAwayTextView : minutesAwayTextViews) {
            minutesAwayTextView.setText("");
        }
    }

    private void updateBusInfo(TextView busTextView, TextView destinationTextView, TextView minutesAwayTextView, BusResponse.MonitoredVehicleJourney vehicleJourney) {
        busTextView.setText(vehicleJourney.getPublishedLineName());
        destinationTextView.setText(vehicleJourney.getDestinationName());
        String minutesAway = calculateMinutesAway(vehicleJourney);
        minutesAwayTextView.setText(minutesAway);
        busStop.setText(vehicleJourney.getMonitoredCall().getStopPointName());


        if (minutesAway.equals("0 minutes")) {
            startFlashingEffect(minutesAwayTextView);
        }
    }

    private String calculateMinutesAway(BusResponse.MonitoredVehicleJourney vehicleJourney) {
        if (vehicleJourney == null) {
            return ""; // or any default value you want to display
        }

        String expectedArrivalTime = vehicleJourney.getMonitoredCall().getExpectedArrivalTime();
        if (expectedArrivalTime == null) {
            return ""; // or any default value you want to display
        }

        try {
            LocalDateTime arrivalTime = LocalDateTime.parse(expectedArrivalTime, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            LocalDateTime currentTime = LocalDateTime.now();

            Duration duration = Duration.between(currentTime, arrivalTime);
            long minutes = duration.toMinutes();

            if (minutes <= 0) {
                return "0 minutes";
            } else {
                return minutes + " minutes";
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return ""; // or any default value you want to display
        }
    }


    private void startFlashingEffect(TextView textView) {
        final Handler handler = new Handler();
        Runnable flashingRunnable = new Runnable() {
            boolean isVisible = true;

            @Override
            public void run() {
                if (textView.getText().toString().equals("0 minutes")) {
                    isVisible = !isVisible;
                    textView.setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);
                    handler.postDelayed(this, FLASH_INTERVAL);
                } else {
                    // Stop flashing effect
                    handler.removeCallbacks(this);
                    textView.setVisibility(View.VISIBLE);
                }
            }
        };
        handler.postDelayed(flashingRunnable, FLASH_INTERVAL);
    }

}