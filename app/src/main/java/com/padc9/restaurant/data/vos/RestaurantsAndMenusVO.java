package com.padc9.restaurant.data.vos;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class RestaurantsAndMenusVO {

    @Embedded
    private RestaurantVO restaurant;

    @Relation(parentColumn = "id", entityColumn = "restaurant_id")
    private List<MenuVO> menus;

    public RestaurantVO getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantVO restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuVO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuVO> menus) {
        this.menus = menus;
    }
}
