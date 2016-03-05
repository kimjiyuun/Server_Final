package com.example.guneetpc.whatsonmenu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by guneet pc on 18-02-2016.
 */
public class CustomCard extends Card
{
    String foodItemDescription;
    String foodItemName;
    String foodItemPrice;
    int foodItemImageResource;
    public CustomCard(Context context,FoodItemModel foodItemModel)
    {
        super(context,R.layout.custom_card);
        foodItemDescription=foodItemModel.foodItemDescription;
        foodItemName=foodItemModel.foodItemName;
        foodItemPrice=foodItemModel.foodItemPrice;
        foodItemImageResource=foodItemModel.foodItemImageResource;
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view)
    {
        super.setupInnerViewElements(parent, view);
        TextView foodItemDescriptionTextView=(TextView)view.findViewById(R.id.food_item_description_tv);
        TextView foodItemNameTextView=(TextView)view.findViewById(R.id.food_item_name_tv);
        TextView foodItemPriceTextView=(TextView)view.findViewById(R.id.food_item_price_tv);
        ImageView foodItemImageView=(ImageView)view.findViewById(R.id.food_item_image_view);
        foodItemNameTextView.setText(foodItemName);
        foodItemPriceTextView.setText(foodItemPrice);
        foodItemDescriptionTextView.setText(foodItemDescription);
        foodItemImageView.setImageResource(foodItemImageResource);
    }
}
