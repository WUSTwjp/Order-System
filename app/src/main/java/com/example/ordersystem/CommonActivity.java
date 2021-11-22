package com.example.ordersystem;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ordersystem.common.NetWorkReceiver;
import com.example.ordersystem.dao.GoodDao;
import com.example.ordersystem.dao.OrderDao;
import com.example.ordersystem.dao.ShoppingGoodDao;
import com.example.ordersystem.dao.impl.GoodDaoImpl;
import com.example.ordersystem.dao.impl.OrderDaoImpl;
import com.example.ordersystem.dao.impl.ShoppingGoodDaoImpl;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommonActivity extends AppCompatActivity {
    NetWorkReceiver netWorkReceiver;
    protected GoodDao goodDao = new GoodDaoImpl();
    protected OrderDao orderDao = new OrderDaoImpl();
    protected ShoppingGoodDao shoppingGoodDao = new ShoppingGoodDaoImpl();

    @Override
    protected void onResume() {
        if (netWorkReceiver == null) {
            netWorkReceiver = new NetWorkReceiver();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(netWorkReceiver, filter);
        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(netWorkReceiver);
        super.onPause();
    }

    //该方法用于创建显示Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //在选项菜单打开以后会调用这个方法，设置menu图标显示（icon）
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
                try {
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent intent1 = new Intent(CommonActivity.this, ShopActivity.class);
                startActivity(intent1);
                return true;
            case R.id.set:
                intent1 = new Intent(CommonActivity.this, SetActivity.class);
                startActivity(intent1);
                return true;
            case R.id.search:
                intent1 = new Intent(CommonActivity.this, SearchActivity.class);
                startActivity(intent1);
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }


    public <T extends CommonActivity> void flush(Class<T> current) {
        finish();
        Intent intent = new Intent(this, current);
        startActivity(intent);
    }

}
