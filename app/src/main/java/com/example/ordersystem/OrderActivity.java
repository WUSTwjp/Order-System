package com.example.ordersystem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;

import com.example.ordersystem.common.GoodsDB;
import com.example.ordersystem.entity.Order;

import java.util.Optional;

public class OrderActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Optional.ofNullable(GoodsDB.getOrder().getAddress()).ifPresent(address -> {
            EditText editText = findViewById(R.id.text_address);
            editText.setText(address);
        });
    }
}