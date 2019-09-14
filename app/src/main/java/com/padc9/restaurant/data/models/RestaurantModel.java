package com.padc9.restaurant.data.models;

import com.padc9.restaurant.data.vos.RestaurantVO;

import java.util.List;

public interface RestaurantModel {
    void getRestaurants(RestaurantModelDelegates delegates);
    RestaurantVO searchById(int id);
    List<RestaurantVO> searchByName(String name);

    interface RestaurantModelDelegates {
        void onSuccess(List<RestaurantVO> restaurants);
        void onFailure(String errorMessage);
    }
}
