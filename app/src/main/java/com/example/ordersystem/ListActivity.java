package com.example.ordersystem;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.ordersystem.adapter.GoodListAdapter;
import com.example.ordersystem.common.GoodsDB;
import com.example.ordersystem.entity.Good;

import java.util.List;

public class ListActivity extends CommonActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        List<Good> goodList = GoodsDB.getByType(type);
        RecyclerView mRecyclerView = findViewById(R.id.recyclerview);
        GoodListAdapter mAdapter = new GoodListAdapter(this, goodList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}