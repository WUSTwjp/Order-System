package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.ordersystem.common.GoodsDB;

public class SetActivity extends CommonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
    }

    public void save(View view) {
        EditText editText = findViewById(R.id.set_text_address);
        orderDao.setAddressAndPay(editText.getText().toString(), "微信");
    }
}