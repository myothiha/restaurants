package com.padc9.restaurant.persistence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padc9.restaurant.data.vos.MenuVO;

import java.util.List;

@Dao
public interface MenuDao {

    @Query("SELECT * FROM menus")
    List<MenuVO> all();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] save(List<MenuVO> menus);
}
