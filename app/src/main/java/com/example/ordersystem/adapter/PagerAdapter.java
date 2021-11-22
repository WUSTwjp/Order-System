package com.example.ordersystem.adapter;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ordersystem.ListFragment;
import com.example.ordersystem.common.TypeConst;

import java.lang.reflect.Type;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Fragment getItem(int position) {
        System.out.println("position"+position);
        return new ListFragment(TypeConst.getType(position));
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
