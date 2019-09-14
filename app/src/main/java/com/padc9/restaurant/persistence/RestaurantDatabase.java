package com.padc9.restaurant.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.padc9.restaurant.data.vos.MenuVO;
import com.padc9.restaurant.data.vos.RestaurantVO;
import com.padc9.restaurant.persistence.daos.MenuDao;
import com.padc9.restaurant.persistence.daos.RestaurantDAO;
import com.padc9.restaurant.utils.RestaurantConstant;

@Database(entities = {RestaurantVO.class, MenuVO.class}, version = 4)
public abstract class RestaurantDatabase extends RoomDatabase {

    private static RestaurantDatabase objInstance;

    public static RestaurantDatabase getInstance(Context context){
        if (objInstance == null) {
            objInstance = Room.databaseBuilder(context, RestaurantDatabase.class, RestaurantConstant.RESTAURANT_DB)
                    .allowMainThreadQueries() // Allow Synchronous call
                    .fallbackToDestructiveMigration() // Delete Current Database and add new Database.
                    .build();
        }
        return objInstance;
    }

    public abstract RestaurantDAO restaurantDAO();

    public abstract MenuDao menuDao();

    public boolean isEmptyRestaurant() {
        return restaurantDAO().all().isEmpty();
    }
}
