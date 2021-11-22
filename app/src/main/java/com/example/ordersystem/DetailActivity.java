package com.example.ordersystem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ordersystem.common.GoodsDB;
import com.example.ordersystem.entity.Good;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity extends CommonActivity {

    private Good good;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        good = goodDao.getByName(intent.getStringExtra("detail"));
        TextView name = findViewById(R.id.detail_name);
        TextView content = findViewById(R.id.detail_content);
        ImageView imageView = findViewById(R.id.detail_picture);
        name.setText(good.getGoodName());
        content.setText(good.getGoodDetail());
        imageView.setImageResource(good.getDrawableId());
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent1 = new Intent(DetailActivity.this, ShopActivity.class);
            intent1.putExtra("select", good.getGoodName());
            startActivity(intent1);
        });
    }
}