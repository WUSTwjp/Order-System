package com.example.ordersystem;

import androidx.annotation.RequiresApi;

import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Optional;

public class OrderActivity extends BaseActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Optional.ofNullable(orderDao.getOrder().getAddress()).ifPresent(address -> {
            EditText editText = findViewById(R.id.text_address);
            editText.setText(address);
        });
    }
}