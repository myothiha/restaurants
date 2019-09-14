package com.padc9.restaurant.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc9.restaurant.R;
import com.padc9.restaurant.data.vos.RestaurantVO;
import com.padc9.restaurant.delegates.RestaurantDelegates;
import com.padc9.restaurant.views.holders.RestaurantViewHolder;

public class RestaurantsAdapter extends BaseRecyclerAdapter<RestaurantViewHolder, RestaurantVO> {

    private RestaurantDelegates mDelegate;

    public RestaurantsAdapter(RestaurantDelegates mDelegate) {
        this.mDelegate = mDelegate;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_restaurant, viewGroup, false);
        return new RestaurantViewHolder(view, mDelegate);
    }
}
