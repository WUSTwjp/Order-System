package com.example.ordersystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void change(View view) {
        Button b = (Button) view;
        CharSequence text = b.getText();
        Intent i = new Intent(MainActivity.this, ListActivity.class);
        i.putExtra("type", text);
        startActivity(i);
    }
}