package com.padc9.restaurant;

import android.app.Application;

import com.padc9.restaurant.data.models.RestaurantModelImpl;

public class RestaurantApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        RestaurantModelImpl.initialize(getApplicationContext());
    }
}
