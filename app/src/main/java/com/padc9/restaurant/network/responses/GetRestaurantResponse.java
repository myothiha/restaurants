package com.padc9.restaurant.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc9.restaurant.data.vos.RestaurantVO;
import com.padc9.restaurant.utils.RestaurantConstant;

import java.util.List;

public class GetRestaurantResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<RestaurantVO> restaurants;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<RestaurantVO> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantVO> restaurants) {
        this.restaurants = restaurants;
    }

    public boolean isOk() {
        return this.getCode() == RestaurantConstant.HTTP_OK && this.getRestaurants() != null;
    }
}
