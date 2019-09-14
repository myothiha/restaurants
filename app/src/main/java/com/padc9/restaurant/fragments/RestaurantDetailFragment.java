package com.padc9.restaurant.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.padc9.restaurant.R;
import com.padc9.restaurant.data.vos.RestaurantVO;
import com.padc9.restaurant.delegates.RestaurantDetailDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantDetailFragment extends Fragment {

    private RestaurantDetailDelegate mDelegates;

    private TextView tvRestaurantName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_detail, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvRestaurantName = view.findViewById(R.id.tv_restaurant_name);
        mDelegates.onViewCreateRestaurantDetailFragment(this);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mDelegates = (RestaurantDetailDelegate) context;
    }

    public void bindData(RestaurantVO restaurant) {
        tvRestaurantName.setText(restaurant.getName());
    }
}
