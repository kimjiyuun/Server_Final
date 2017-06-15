package com.jiyun.android.server_final;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by guneet pc on 20-02-2016.
 */
public class OrderActivityAdapter extends ArrayAdapter<FoodItemModel> {

    LayoutInflater l;
    Context context;
    List<FoodItemModel> objects;

   TextView tvitemname, tvitemqty, tvitemtablename;
    Button bclear;
    ImageView imgv;

    public OrderActivityAdapter(Context context, int resource, List<FoodItemModel> objects, LayoutInflater l) {
        super(context, resource);

        this.l=l;
        this.context=context;
        this.objects=objects;

    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v=convertView;

        if(v==null)
        {
            v=l.inflate(R.layout.order_item_layout, null);
        }

        tvitemname=(TextView)v.findViewById(R.id.dish_name_tv);
        tvitemqty=(TextView)v.findViewById(R.id.dish_quantity_tv);
        tvitemtablename=(TextView)v.findViewById(R.id.dish_tablename);
        bclear=(Button)v.findViewById(R.id.clear_button);
        imgv=(ImageView)v.findViewById(R.id.dish_image_view);

        final FoodItemModel fitem=objects.get(position);
        tvitemname.setText(fitem.foodItemName);
        tvitemqty.setText(fitem.quantity);
      //  tvitemtablename.setText(fitem.foodItemNam);
        imgv.setImageResource(fitem.foodItemImageResource);



        return v;

    }
}
