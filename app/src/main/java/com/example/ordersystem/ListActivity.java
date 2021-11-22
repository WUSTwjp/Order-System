package com.example.ordersystem;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.ordersystem.adapter.GoodListAdapter;
import com.example.ordersystem.adapter.PagerAdapter;
import com.example.ordersystem.common.GoodsDB;
import com.example.ordersystem.common.TypeConst;
import com.example.ordersystem.entity.Good;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ListActivity extends CommonActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("EAT"));
        tabLayout.addTab(tabLayout.newTab().setText("DRINK"));
        tabLayout.addTab(tabLayout.newTab().setText("FUN"));
        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(TypeConst.getCode(type));
        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                System.out.println("tab.getPosition()"+tab.getPosition());
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //viewPager.setCurrentItem(TypeConst.getCode(type));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}