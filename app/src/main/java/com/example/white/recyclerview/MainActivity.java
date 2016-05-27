package com.example.white.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> home;
    private List<Integer> mHeights;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        //实现GridView布局
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
//        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(getApplicationContext()));

        //实现瀑布流布局
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(new HomeAdapter(home));
    }

    protected void initData()
    {
        home = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++)
        {
            home.add("" + (char) i);
        }
    }


//    public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
//
//
//        public HomeAdapter(List<String> home) {
//            if (home == null) {
//                throw new IllegalArgumentException("List<String> home must not be null");
//            }
//
//        }
//
//        @Override
//        public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(MainActivity.this)
//                    .inflate(R.layout.item_home, parent, false));
//            return holder;
//        }
//
//        @Override
//        public void onBindViewHolder(HomeAdapter.MyViewHolder holder, int position) {
//            holder.tv.setText(home.get(position));
//
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return home.size();
//        }
//
//        class MyViewHolder extends RecyclerView.ViewHolder {
//            TextView tv;
//
//            public MyViewHolder(View itemView) {
//                super(itemView);
//                tv = (TextView) itemView.findViewById(R.id.item);
//            }
//        }
//
//    }
}
