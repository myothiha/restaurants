package com.padc9.restaurant.adapters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.padc9.restaurant.fragments.RestaurantDetailFragment;

public class RestaurantDetailLayoutAdapter extends FragmentStatePagerAdapter {
    SparseArray<RestaurantDetailFragment> registeredFragments = new SparseArray<>();

    public RestaurantDetailLayoutAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Bundle args = new Bundle();
        args.putInt("id", i);

        RestaurantDetailFragment fragment = new RestaurantDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) {
            return "Detail";
        } else if(position == 1) {
            return "Menu";
        } else {
            return "Review";
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        RestaurantDetailFragment fragment = (RestaurantDetailFragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public RestaurantDetailFragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
}
