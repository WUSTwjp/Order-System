package com.example.ordersystem;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SetActivity extends BaseActivity {

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