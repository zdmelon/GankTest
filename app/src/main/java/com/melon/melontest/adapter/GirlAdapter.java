package com.melon.melontest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.melon.melontest.R;
import com.melon.melontest.model.Result;

import java.util.List;

public class GirlAdapter extends RecyclerView.Adapter<GirlAdapter.GirlHolder> {

    private Context context;
    private List<Result> datas;

    public GirlAdapter(Context context, List<Result> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public GirlHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_girl, parent, false);
        GirlHolder holder = new GirlHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GirlHolder holder, int position) {
        Result result = datas.get(position);
        Glide.with(context).load(result.getUrl()).into(holder.ivGirl);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class GirlHolder extends RecyclerView.ViewHolder {

        ImageView ivGirl;

        public GirlHolder(View itemView) {
            super(itemView);
            ivGirl = itemView.findViewById(R.id.iv_girl);
        }
    }
}
