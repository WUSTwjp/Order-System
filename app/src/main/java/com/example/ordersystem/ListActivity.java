package com.example.ordersystem;

import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.ordersystem.entity.adapter.PagerAdapter;
import com.example.ordersystem.common.TypeConst;
import com.google.android.material.tabs.TabLayout;

public class ListActivity extends BaseActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("烤鸡"));
        tabLayout.addTab(tabLayout.newTab().setText("炸鸡"));
        tabLayout.addTab(tabLayout.newTab().setText("饮品"));
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