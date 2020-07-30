package com.example.xiaoshixunday1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.xiaoshixunday1.R;
import com.example.xiaoshixunday1.bean.FoodBean;

import java.util.ArrayList;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    private ArrayList<FoodBean.DataBean> list;
    private Context context;


    public RecyAdapter(ArrayList<FoodBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodBean.DataBean dataBean = list.get(position);
        holder.tv_home.setText(dataBean.getTitle());
        Glide.with(context).load(dataBean.getPic()).into(holder.iv_home);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_home;
        private TextView tv_home;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_home=itemView.findViewById(R.id.iv_home);
            tv_home=itemView.findViewById(R.id.tv_home);
        }
    }
}
