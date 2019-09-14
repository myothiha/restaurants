package com.padc9.restaurant.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.padc9.restaurant.R;
import com.padc9.restaurant.adapters.RestaurantDetailLayoutAdapter;
import com.padc9.restaurant.data.vos.RestaurantVO;
import com.padc9.restaurant.delegates.RestaurantDetailDelegate;
import com.padc9.restaurant.fragments.RestaurantDetailFragment;

public class DetailRestaurantActivity extends BaseActivity implements RestaurantDetailDelegate {

    private ViewPager mPager;
    private PagerAdapter mAdapter;
    private int restaurantId;

    private static final String INTENT_RESTAURANT_ID = "RESTAURANT_ID";

    public static Intent createIntent(Context context, int restaurantId) {
        Intent intent = new Intent(context, DetailRestaurantActivity.class);
        intent.putExtra(INTENT_RESTAURANT_ID, restaurantId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_restaurant);

        TabLayout topTabLayout = findViewById(R.id.restaurant_detail_tab_layout);
        mPager = findViewById(R.id.vp_restaurant_detail);

        mAdapter = new RestaurantDetailLayoutAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);

        topTabLayout.setupWithViewPager(mPager);

        restaurantId = getIntent().getIntExtra(INTENT_RESTAURANT_ID, 0);
    }

    @Override
    public void onViewCreateRestaurantDetailFragment(RestaurantDetailFragment fragment) {
        RestaurantVO restaurant = mrestaurantModel.searchById(restaurantId);
        fragment.bindData(restaurant);
    }
}
