package com.example.guneetpc.whatsonmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ArrayList<FoodItemModel> foodItemModelArrayList;
    ListView listView;
    ListViewAdapter listViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        foodItemModelArrayList=new ArrayList<>();
        foodItemModelArrayList.add(new FoodItemModel("so1","Organic SouthWestern Corn Chowder","175","A delectable blend of roasted corn,red bell pepper,potatoes and peppers",R.drawable.soup,3,0));
        foodItemModelArrayList.add(new FoodItemModel("so1","Organic SouthWestern Corn Chowder","175","A delectable blend of roasted corn,red bell pepper,potatoes and peppers",R.drawable.soup,3,0));
        foodItemModelArrayList.add(new FoodItemModel("so1","Organic SouthWestern Corn Chowder","175","A delectable blend of roasted corn,red bell pepper,potatoes and peppers",R.drawable.soup,3,0));
        listView=(ListView)findViewById(R.id.listView);
        listViewAdapter=new ListViewAdapter(this,R.layout.cart_layout,foodItemModelArrayList);
        listView.setAdapter(listViewAdapter);
    }
}
