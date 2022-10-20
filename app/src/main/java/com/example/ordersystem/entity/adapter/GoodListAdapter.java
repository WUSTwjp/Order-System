package com.example.ordersystem.entity.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordersystem.DetailActivity;
import com.example.ordersystem.R;
import com.example.ordersystem.goods.Drink;
import com.example.ordersystem.entity.Good;
import com.example.ordersystem.goods.Food;
import com.example.ordersystem.goods.TotalPrice;

import java.util.List;

public class GoodListAdapter extends RecyclerView.Adapter<GoodViewHolder> {
    Drink drink;
    TotalPrice totalPrice;
    Food food;
    private final List<Good> mGoodList;
    private LayoutInflater mInflater;
    private Context context;
    public GoodListAdapter(Context context,
                           List<Good> mGoodList) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mGoodList = mGoodList;
    }

    @NonNull
    @Override
    public GoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.good_list_item, parent, false);
        return new GoodViewHolder(mItemView, this, context);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodViewHolder holder, int position) {
        holder.nameView.setText(mGoodList.get(position).getGoodName());
        holder.contentView.setText(mGoodList.get(position).getGoodDetail());
        holder.imageView.setImageResource(mGoodList.get(position).getDrawableId());
        holder.price.setText('¥'+String.valueOf(mGoodList.get(position).getGoodPrice()));
    }

    @Override
    public int getItemCount() {
        return mGoodList.size();
    }

}

class GoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public final ImageView imageView;
    public final TextView nameView;
    public final TextView contentView;
    public final TextView price;

    final GoodListAdapter mAdapter;
    private Context context;

    public GoodViewHolder(View itemView, GoodListAdapter adapter, Context context) {
        super(itemView);
        this.context = context;
        this.nameView = itemView.findViewById(R.id.name);
        this.contentView = itemView.findViewById(R.id.content);
        this.imageView = itemView.findViewById(R.id.picture);
        this.price= itemView.findViewById(R.id.price1);
        itemView.setOnClickListener(this);
        this.mAdapter = adapter;


    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("detail", nameView.getText());
        context.startActivity(intent);
    }

}
