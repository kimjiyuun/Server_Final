package com.example.guneetpc.whatsonmenu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import it.gmariotti.cardslib.library.internal.CardHeader;

/**
 * Created by guneet pc on 18-02-2016.
 */
public class CustomCardHeader extends CardHeader
{
    public CustomCardHeader(Context context,FoodItemModel foodItemModel)
    {
        super(context,R.layout.custom_card_header);
    }
}
