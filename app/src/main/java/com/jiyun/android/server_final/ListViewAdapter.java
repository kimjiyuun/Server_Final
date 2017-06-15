package com.jiyun.android.server_final;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by guneet pc on 20-02-2016.
 */
public class ListViewAdapter extends ArrayAdapter
{
    ArrayList<FoodItemModel> foodItemModelArrayList;
    Context context;
    public ListViewAdapter(Context context, int resource,ArrayList<FoodItemModel> foodItemModelArrayList) {
        super(context, resource);
        this.foodItemModelArrayList=foodItemModelArrayList;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if(v==null)
        {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.cart_layout, null);
        }

        FoodItemModel foodItemModel=foodItemModelArrayList.get(position);

        TextView name=(TextView)v.findViewById(R.id.cart_item_name);
        name.setText(foodItemModel.foodItemName);
        return v;
    }
}
