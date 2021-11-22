package com.example.ordersystem;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.example.ordersystem.adapter.ShoppingListAdapter;
import com.example.ordersystem.common.GoodsDB;
import com.example.ordersystem.entity.Good;
import com.example.ordersystem.entity.ShoppingGood;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class ShopActivity extends CommonActivity {
    ShoppingListAdapter mAdapter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Intent intent = getIntent();
        Optional.ofNullable(intent.getStringExtra("select")).ifPresent(name -> {
            Good good = GoodsDB.getByName(name);
            GoodsDB.addShoppingGood(new ShoppingGood(good));
        });
        RecyclerView mRecyclerView = findViewById(R.id.recyclerview1);
        mAdapter = new ShoppingListAdapter(this, GoodsDB.getAllShoppingGoods());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.order);
        fab.setOnClickListener(view -> {
            Intent intent1 = new Intent(ShopActivity.this, OrderActivity.class);
            startActivity(intent1);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                makeDialog(count -> mAdapter.updateCount(count));
                return true;
            case 1:
                mAdapter.remove();
                flush(ShopActivity.class);
                return true;
            default:
        }
        return super.onContextItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void makeDialog(Consumer<Integer> callBack) {
        final EditText editText = new EditText(this);
        new AlertDialog.Builder(this).setTitle("请输入数量")
                .setIcon(android.R.drawable.sym_def_app_icon)
                .setView(editText)
                .setPositiveButton("确定", (dialogInterface, i) -> {
                    callBack.accept(Integer.parseInt(editText.getText().toString()));
                    //AlertDiaLog是非阻塞的，所以出了对话框后会直接执行flush，导致对话框消失，排查很久，才发现，所以将刷新放在成功后。
                    flush(ShopActivity.class);
                })
                .setNegativeButton("取消", null)
                .show();
    }
}