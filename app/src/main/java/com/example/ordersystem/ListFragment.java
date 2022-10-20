package com.example.ordersystem;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ordersystem.entity.adapter.GoodListAdapter;
import com.example.ordersystem.dao.impl.GoodDaoImpl;
import com.example.ordersystem.entity.Good;

import java.util.List;


public class ListFragment extends Fragment {
    private List<Good> goodList;

    public ListFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ListFragment(String type) {
        goodList = new GoodDaoImpl().getByType(type);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView mRecyclerView = view.findViewById(R.id.recyclerview);
        GoodListAdapter mAdapter = new GoodListAdapter(view.getContext(), goodList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }
}