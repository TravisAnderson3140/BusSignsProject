package com.example.bussigns;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BusService {
    @GET("stop-monitoring.json")
    Call<ResponseBody> getBusData(
            @Query("key") String key,
            @Query("MonitoringRef") String monitoringRef
    );
}