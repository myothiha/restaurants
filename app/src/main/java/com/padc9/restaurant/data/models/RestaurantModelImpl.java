package com.padc9.restaurant.data.models;

import android.content.Context;

import com.padc9.restaurant.data.vos.RestaurantVO;
import com.padc9.restaurant.data.vos.RestaurantsAndMenusVO;
import com.padc9.restaurant.network.dataagents.RestaurantDataAgent;
import com.padc9.restaurant.network.responses.GetRestaurantResponse;
import com.padc9.restaurant.utils.RestaurantConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantModelImpl extends BaseModel implements RestaurantModel {

    private static RestaurantModelImpl objInstance;

    public RestaurantModelImpl(Context context) {
        super(context);
    }

    public static void initialize(Context context) {
        objInstance = new RestaurantModelImpl(context);
    }

    public static RestaurantModelImpl getObjInstance() {
        if (objInstance == null)
            throw new RuntimeException(RestaurantConstant.MODEL_INITIALIZATION_EXCEPTION);

        return objInstance;
    }

    @Override
    public void getRestaurants(final RestaurantModelDelegates delegates) {

        if (mdatabase.isEmptyRestaurant()) {
            restaurantDataAgent.getRestaurants(new RestaurantDataAgent.GetRestaurantDataAgentDelegate() {
                @Override
                public void onSuccess(GetRestaurantResponse response) {
                    List<RestaurantVO> restaurants = response.getRestaurants();
                    mdatabase.restaurantDAO().save(restaurants, mdatabase.menuDao());

                    delegates.onSuccess(restaurants);
                }

                @Override
                public void onFailure(String errorMessage) {
                    delegates.onFailure(errorMessage);
                }
            });
        } else {
            List<RestaurantsAndMenusVO> restaurantsAndMenus = mdatabase.restaurantDAO().all();
            List<RestaurantVO> restaurants = new ArrayList<>();

            for (RestaurantsAndMenusVO restaurantsAndMenu : restaurantsAndMenus) {

                if (isSameRestaurant(restaurants, restaurantsAndMenu.getRestaurant()))
                    continue;

                restaurantsAndMenu.getRestaurant().setMenus(restaurantsAndMenu.getMenus());
                restaurants.add(restaurantsAndMenu.getRestaurant());
            }

            delegates.onSuccess(restaurants);
        }
    }

    public boolean isSameRestaurant(List<RestaurantVO> restaurants, RestaurantVO search) {
        boolean same = false;
        for (RestaurantVO restaurant : restaurants) {
            if(search.getRestaurantIdPk() == restaurant.getRestaurantIdPk()) {
                same = true;
                break;
            }
        }

        return same;
    }

    @Override
    public RestaurantVO searchById(int id) {
        return mdatabase.restaurantDAO().searchById(id);
    }

    @Override
    public List<RestaurantVO> searchByName(String name) {
        return mdatabase.restaurantDAO().searchByName(name);
    }
}
