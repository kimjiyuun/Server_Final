package com.example.guneetpc.whatsonmenu;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>
{

    ArrayList<CartModel> cartModelArrayList;
    Context context;
    DatabaseHelper databaseHelper;

    public CartAdapter(ArrayList<CartModel> cartModelArrayList,Context context)
    {
        this.context=context;
        this.cartModelArrayList=cartModelArrayList;
        databaseHelper=new DatabaseHelper(context);
    }


    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_layout, parent, false);
        CartViewHolder cartViewHolder = new CartViewHolder(v);
        return cartViewHolder;
    }


    @Override
    public void onBindViewHolder(CartViewHolder holder, int position)
    {
        final CartModel cartModel=cartModelArrayList.get(position);

        holder.itemName.setText(cartModel.foodItemModel.foodItemName);
        holder.itemCategory.setText(cartModel.tableName.toLowerCase());
        holder.itemImage.setImageResource(cartModel.foodItemModel.foodItemImageResource);
        holder.itemPrice.setText(cartModel.foodItemModel.foodItemPrice);
        holder.itemQuantity.setText(cartModel.quantity+"");
        int quantity=cartModel.quantity;
        int price=Integer.parseInt(cartModel.foodItemModel.foodItemPrice.toString());
        int total=price*quantity;
        holder.itemTotal.setText(total+"");

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                String orderId=cartModel.orderId;
                databaseHelper.deleteOrderWithId(orderId);
                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return cartModelArrayList.size();
    }


    public class CartViewHolder extends RecyclerView.ViewHolder
    {
        TextView itemName;
        TextView itemPrice;
        TextView itemCategory;
        TextView itemQuantity;
        TextView itemTotal;
        ImageView itemImage;
        CardView cardView;

        public CartViewHolder(View itemView) {
            super(itemView);

            itemName=(TextView)itemView.findViewById(R.id.cart_item_name);
            itemPrice=(TextView)itemView.findViewById(R.id.cart_item_price);
            itemCategory=(TextView)itemView.findViewById(R.id.cart_item_category);
            itemQuantity=(TextView)itemView.findViewById(R.id.cart_item_quantity);
            itemTotal=(TextView)itemView.findViewById(R.id.total_price);
            itemImage=(ImageView)itemView.findViewById(R.id.cart_item_image);
            cardView=(CardView)itemView.findViewById(R.id.cart_cv);
        }

    }
}
