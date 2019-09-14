package com.padc9.restaurant.data.models;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.content.Context;
import android.support.annotation.NonNull;

import com.padc9.restaurant.network.dataagents.RestaurantDataAgent;
import com.padc9.restaurant.network.dataagents.RetrofitRestaurantDataAgent;
import com.padc9.restaurant.persistence.RestaurantDatabase;
import com.padc9.restaurant.persistence.daos.RestaurantDAO;

public abstract class BaseModel {

    protected RestaurantDataAgent restaurantDataAgent;
    protected RestaurantDatabase mdatabase;

    public BaseModel(Context context) {
        this.restaurantDataAgent = RetrofitRestaurantDataAgent.getObjInstance();
        mdatabase = RestaurantDatabase.getInstance(context);
    }
}
