package com.padc9.restaurant.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.padc9.restaurant.views.holders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<ViewHolder extends BaseViewHolder<DataVO>, DataVO> extends RecyclerView.Adapter<ViewHolder> {


    private List<DataVO> mdata;

    public BaseRecyclerAdapter() {
        this.mdata = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mdata.get(position));
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public void setNewData(List<DataVO> data) {
        mdata = data;
        notifyDataSetChanged();
    }

}
