package com.example.white.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by white on 2016/5/27.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private List<String> home;
    private List<Integer> mHeights;

    public HomeAdapter(List<String> home) {
        if (home == null) {
            throw new IllegalArgumentException("List<String> home must not be null");
        }
        this.home = home;
        getRandomHeight(this.home);
    }

    //得到随机item的高度
    private void getRandomHeight(List<String> lists) {
        mHeights = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            mHeights.add((int) (200 + Math.random() * 400));
        }
    }

        @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams params =  holder.itemView.getLayoutParams();//得到item的LayoutParams布局参数
        params.height = mHeights.get(position);//把随机的高度赋予item布局
        holder.itemView.setLayoutParams(params);//把params设置给item布局
        holder.tv.setText(home.get(position));
    }

    @Override
    public int getItemCount() {
        return home.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item);
        }
    }
}

