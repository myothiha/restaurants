package com.padc9.restaurant.network;

import com.padc9.restaurant.network.responses.GetRestaurantResponse;
import com.padc9.restaurant.utils.RestaurantConstant;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestaurantApi {

    @GET(RestaurantConstant.GET_ALL_RESTAURANTS)
    Call<GetRestaurantResponse> getAllRestaurants(@Query(RestaurantConstant.PARAM_ACCESS_TOKEN) String accessToken);
}
