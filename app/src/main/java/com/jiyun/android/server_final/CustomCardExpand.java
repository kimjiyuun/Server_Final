package com.jiyun.android.server_final;
import android.content.Context;
import android.graphics.Color;
import android.media.Rating;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.CardExpand;

public class CustomCardExpand extends CardExpand
{
    int rating;
    ArrayList<Comment> arrayList;
    DatabaseHelper databaseHelper;
    FoodItemModel foodItemModel;
    TextView quantityTextView;
    Button addItem;
    Button removeItem;
    String tableName;
    public CustomCardExpand(Context context,FoodItemModel foodItemModel,String tableName)
    {
        super(context,R.layout.custom_card_expand);
        rating=foodItemModel.rating;
        this.foodItemModel=foodItemModel;
        this.tableName=tableName;
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view)
    {
        super.setupInnerViewElements(parent, view);


        Button orderButton=(Button)view.findViewById(R.id.order_btn);
        quantityTextView=(TextView)view.findViewById(R.id.quantityTextView);

        LinearLayout linearLayout=(LinearLayout)view.findViewById(R.id.dish_review_ll);
        addItem=(Button)view.findViewById(R.id.add_item_btn);
        removeItem=(Button)view.findViewById(R.id.remove_item_btn);
        arrayList=new ArrayList<>();
        databaseHelper=new DatabaseHelper(getContext());
        arrayList=databaseHelper.getAllCommentFromId(foodItemModel.id);


        linearLayout.removeAllViews();
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        if(arrayList.isEmpty())
        {
            TextView textView=new TextView(getContext());
            textView.setText("Sorry No Reviews Available");
            textView.setTextSize(16);
            textView.setTextColor(Color.parseColor("#ffffff"));
            textView.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            layoutParams.gravity= Gravity.CENTER;
            linearLayout.addView(textView,layoutParams);
        }
        else
        {
            for(int i=0;i<arrayList.size();i++)
            {
                Comment comment=arrayList.get(i);
                TextView textView=new TextView(getContext());
                textView.setText((i+1) + ". " + comment.review);
                textView.setTextSize(16);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
                layoutParams.setMargins(8,8,8,8);
                linearLayout.addView(textView,layoutParams);
            }
        }


        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity=Integer.parseInt(quantityTextView.getText().toString());
                quantity++;
                quantityTextView.setText(quantity+"");
            }
        });

        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity=Integer.parseInt(quantityTextView.getText().toString());
                if(quantity!=0)
                {
                    quantity--;
                    quantityTextView.setText(quantity+"");
                }
            }
        });


        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity=Integer.parseInt(quantityTextView.getText().toString());
                if(quantity==0)
                {
                    Toast.makeText(getContext(),"Please Select Quantity To Order",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int id=databaseHelper.getOrderTableSize()+1;
                    Toast.makeText(getContext(),id+"",Toast.LENGTH_SHORT).show();
                    OrderModel orderModel=new OrderModel("or"+id,1,foodItemModel.id,tableName,quantity);
                    databaseHelper.addOrderToTable(orderModel);
                }
            }
        });

    }
}
