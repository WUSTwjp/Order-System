package com.example.ordersystem;

import androidx.annotation.RequiresApi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ordersystem.entity.Good;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity extends BaseActivity {

    private Good good;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StringBuffer extra=new StringBuffer();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        good = goodDao.getByName(intent.getStringExtra("detail"));
        TextView name = findViewById(R.id.detail_name1);
        TextView content = findViewById(R.id.detail_content1);
        ImageView imageView = findViewById(R.id.detail_picture1);
        name.setText(good.getGoodName());
        content.setText(good.getGoodDetail());
        imageView.setImageResource(good.getDrawableId());
        String tp=good.getType();
        FloatingActionButton fab = findViewById(R.id.fab1);
        fab.setOnClickListener(view -> {
            if(tp.equals("甜品")){
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("请选择是否加冰加糖");
                final String[] choice = new String[]{"加冰", "加糖"}; // 选择项
                final boolean[] isCheck = new boolean[choice.length]; // 是否被选中
                builder.setMultiChoiceItems(choice, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked == true)
                                    isCheck[which] = true;
                                else if(isChecked == false)
                                    isCheck[which] = false;
                            }
                        });
                builder.setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        for (int i=0;i<2;i++) {
                            if(isCheck[i]){
                                extra.append(choice[i]);
                            }
                        }
                        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz\n"+extra);
                        Intent intent1 = new Intent(DetailActivity.this, ShopActivity.class);
                        intent1.putExtra("select", extra+good.getGoodName());
                        startActivity(intent1);
                    }
                });
                builder.create();
                builder.show();
            }else{
                Intent intent1 = new Intent(DetailActivity.this, ShopActivity.class);
                intent1.putExtra("select", good.getGoodName());
                startActivity(intent1);
            }



        });
    }
}