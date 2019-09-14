package com.padc9.restaurant.network.dataagents;

import com.padc9.restaurant.network.responses.GetRestaurantResponse;

public interface RestaurantDataAgent {

    void getRestaurants(GetRestaurantDataAgentDelegate getRestaurantDataAgentDelegate);

    interface GetRestaurantDataAgentDelegate {
        void onSuccess(GetRestaurantResponse response);
        void onFailure(String errorMessage);
    }
}
