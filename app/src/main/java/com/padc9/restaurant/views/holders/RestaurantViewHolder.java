package com.padc9.restaurant.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.padc9.restaurant.R;
import com.padc9.restaurant.data.vos.RestaurantVO;
import com.padc9.restaurant.delegates.RestaurantDelegates;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantViewHolder extends BaseViewHolder<RestaurantVO> {

    @BindView(R.id.tv_restaurant_name)
    TextView tvRestaurantName;

    public RestaurantViewHolder(@NonNull View itemView, final RestaurantDelegates delegates) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                delegates.onTapRestaurant(mdata.getRestaurantIdPk());
            }
        });
    }

    @Override
    public void bindData(RestaurantVO restaurant) {
        mdata = restaurant;
        tvRestaurantName.setText(restaurant.getName());
    }
}
