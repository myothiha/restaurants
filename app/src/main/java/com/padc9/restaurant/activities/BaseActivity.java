package com.padc9.restaurant.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.padc9.restaurant.data.models.RestaurantModel;
import com.padc9.restaurant.data.models.RestaurantModelImpl;

public abstract class BaseActivity extends AppCompatActivity {

    protected RestaurantModel mrestaurantModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mrestaurantModel = RestaurantModelImpl.getObjInstance();
    }
}
