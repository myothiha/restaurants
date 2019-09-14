package com.padc9.restaurant.network.dataagents;

import com.padc9.restaurant.network.RestaurantApi;
import com.padc9.restaurant.network.responses.GetRestaurantResponse;
import com.padc9.restaurant.utils.RestaurantConstant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRestaurantDataAgent implements RestaurantDataAgent {

    private static RetrofitRestaurantDataAgent objInstance;
    private RestaurantApi mRestaurantApi;

    private RetrofitRestaurantDataAgent() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.DAYS.SECONDS)
                .readTimeout(30, TimeUnit.DAYS.SECONDS)
                .writeTimeout(30, TimeUnit.DAYS.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestaurantConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mRestaurantApi = retrofit.create(RestaurantApi.class);
    }

    public static RetrofitRestaurantDataAgent getObjInstance() {
        if (objInstance == null)
            objInstance = new RetrofitRestaurantDataAgent();
        return objInstance;
    }

    @Override
    public void getRestaurants(final GetRestaurantDataAgentDelegate getRestaurantDataAgentDelegate) {
        Call<GetRestaurantResponse> restaurantCall = mRestaurantApi.getAllRestaurants(RestaurantConstant.DUMMY_ACCESS_TOKEN);

        restaurantCall.enqueue(new Callback<GetRestaurantResponse>() {
            @Override
            public void onResponse(Call<GetRestaurantResponse> call, Response<GetRestaurantResponse> response) {
                GetRestaurantResponse getRestaurantResponse = response.body();

                getRestaurantDataAgentDelegate.onSuccess(getRestaurantResponse);
            }

            @Override
            public void onFailure(Call<GetRestaurantResponse> call, Throwable t) {
                getRestaurantDataAgentDelegate.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
