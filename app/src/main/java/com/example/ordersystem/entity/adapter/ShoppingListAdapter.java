package com.example.ordersystem.entity.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordersystem.DetailActivity;
import com.example.ordersystem.R;
import com.example.ordersystem.dao.ShoppingGoodDao;
import com.example.ordersystem.dao.impl.ShoppingGoodDaoImpl;
import com.example.ordersystem.entity.ShoppingGood;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingViewHolder> {

    private final List<ShoppingGood> mShoppingGoodList;
    private LayoutInflater mInflater;
    private Context context;
    private int mPosition = -1;
    private ShoppingGoodDao shoppingGoodDao = new ShoppingGoodDaoImpl();

    public ShoppingListAdapter(Context context,
                               List<ShoppingGood> mShoppingGoodList) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mShoppingGoodList = mShoppingGoodList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void remove() {
        System.out.println(mPosition);
        if (mPosition != -1) {
            ShoppingGood shoppingGood = mShoppingGoodList.get(mPosition);
            shoppingGoodDao.countAdd(shoppingGood.getGoodId(), -1 * shoppingGood.getCount());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void updateCount(Integer count) {
        if (mPosition != -1) {
            Integer goodId = mShoppingGoodList.get(mPosition).getGoodId();
            shoppingGoodDao.updateCount(goodId, count);
        }
    }

    @NonNull
    @Override
    public ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.shopping_list_item, parent, false);
        return new ShoppingViewHolder(mItemView, this, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingViewHolder holder, int position) {
        holder.nameView.setText(mShoppingGoodList.get(position).getGoodName());
        holder.contentView.setText(mShoppingGoodList.get(position).getGoodDetail());
        holder.imageView.setImageResource(mShoppingGoodList.get(position).getDrawableId());
        holder.editText.setText(String.valueOf(mShoppingGoodList.get(position).getCount()));
        holder.itemView.setOnLongClickListener(v -> {
            mPosition = holder.getAdapterPosition();
            return false;
        });

    }

    @Override
    public int getItemCount() {
        return mShoppingGoodList.size();
    }

}

class ShoppingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener {
    public final ImageView imageView;
    public final TextView nameView;
    public final TextView contentView;
    public final EditText editText;
    final ShoppingListAdapter mAdapter;
    private Context context;
    private ShoppingGoodDao shoppingGoodDao = new ShoppingGoodDaoImpl();

    public ShoppingViewHolder(View itemView, ShoppingListAdapter adapter, Context context) {
        super(itemView);
        this.context = context;
        this.nameView = itemView.findViewById(R.id.name1);
        this.contentView = itemView.findViewById(R.id.content1);
        this.imageView = itemView.findViewById(R.id.picture1);
        this.editText = itemView.findViewById(R.id.count);
        this.editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    shoppingGoodDao.updateCount(nameView.getText().toString(), Integer.parseInt(s.toString()));
                }
            }
        });

        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);
        this.mAdapter = adapter;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("detail", nameView.getText());
        context.startActivity(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.add(Menu.NONE, 0, Menu.NONE, "EditCount");
        contextMenu.add(Menu.NONE, 1, Menu.NONE, "Delete");
    }
}
