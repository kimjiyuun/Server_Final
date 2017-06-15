package com.jiyun.android.server_final;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>
{
    Context context;
    ArrayList<FoodItemModel> foodItemModelArrayList;


    OrderAdapter(Context context,ArrayList<FoodItemModel> foodItemModelArrayList)
    {
        this.context=context;
        this.foodItemModelArrayList=foodItemModelArrayList;
    }
    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item_layout, parent, false);
        OrderViewHolder categoryViewHolder = new OrderViewHolder(v);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {

        FoodItemModel foodItemModel=foodItemModelArrayList.get(position);
        holder.itemName.setText(foodItemModel.foodItemName);
        holder.itemQuantity.setText(foodItemModel.quantity+"");
        holder.itemImage.setImageResource(foodItemModel.foodItemImageResource);

        holder.clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder
    {
        TextView itemName;
        TextView itemQuantity;
        ImageView itemImage;
        Button clearButton;

        public OrderViewHolder(View itemView) {
            super(itemView);

            itemName=(TextView)itemView.findViewById(R.id.dish_name_tv);
            itemQuantity=(TextView)itemView.findViewById(R.id.dish_quantity_tv);
            clearButton=(Button)itemView.findViewById(R.id.clear_button);
            itemImage=(ImageView)itemView.findViewById(R.id.dish_image_view);
        }
    }
}
