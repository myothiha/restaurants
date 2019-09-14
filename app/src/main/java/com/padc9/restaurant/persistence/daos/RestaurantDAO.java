package com.padc9.restaurant.persistence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.view.Menu;

import com.padc9.restaurant.data.vos.MenuVO;
import com.padc9.restaurant.data.vos.RestaurantVO;
import com.padc9.restaurant.data.vos.RestaurantsAndMenusVO;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class RestaurantDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long[] save(List<RestaurantVO> restaurants);

    @Query("SELECT restaurants.*, menus.* FROM restaurants INNER JOIN menus ON menus.restaurant_id = restaurants.id")
    public abstract List<RestaurantsAndMenusVO> all();

    public void save(List<RestaurantVO> restaurants, MenuDao menuDao) {

        List<MenuVO> menus = new ArrayList<>();

        for (RestaurantVO restaurant: restaurants ) {
            for(MenuVO menu : restaurant.getMenus()) {
                menu.setRestaurantId(restaurant.getId());
            }
            menus.addAll(restaurant.getMenus());
        }

        save(restaurants);
        menuDao.save(menus);
    }

    @Query("SELECT * FROM restaurants WHERE restaurant_id_pk = :id")
    public abstract RestaurantVO searchById(int id);

    @Query("SELECT * FROM restaurants WHERE name LIKE :name")
    public abstract List<RestaurantVO> searchByName(String name);

}
