package com.padc9.restaurant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.padc9.restaurant.R;
import com.padc9.restaurant.adapters.RestaurantsAdapter;
import com.padc9.restaurant.data.models.RestaurantModel;
import com.padc9.restaurant.data.vos.RestaurantVO;
import com.padc9.restaurant.delegates.RestaurantDelegates;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RestaurantDelegates {

    @BindView(R.id.rv_restaurants)
    RecyclerView rvRestaurants;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        final RestaurantsAdapter restaurantsAdapter = new RestaurantsAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvRestaurants.setAdapter(restaurantsAdapter);
        rvRestaurants.setLayoutManager(layoutManager);

        mrestaurantModel.getRestaurants(new RestaurantModel.RestaurantModelDelegates() {
            @Override
            public void onSuccess(List<RestaurantVO> restaurants) {
                restaurantsAdapter.setNewData(restaurants);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapRestaurant(int restaurantId) {
        Intent intent = DetailRestaurantActivity.createIntent(getApplicationContext(), restaurantId);
        startActivity(intent);
    }
}
