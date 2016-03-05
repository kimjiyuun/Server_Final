package com.example.guneetpc.whatsonmenu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

public class FoodListActivity extends AppCompatActivity {

    ArrayList<FoodItemModel>foodItemModelArrayList;
    ArrayList<Card>cardArrayList;
    DatabaseHelper databaseHelper;
    Context context=this;
    CategoryModel categoryModel;
    String tableName;
    ImageView categoryTypeImageView;
    TextView categoryNameTextView;
    ImageView cartImageView;
    ImageView billImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        Intent intent=getIntent();
        categoryModel= (CategoryModel) intent.getSerializableExtra("categoryModel");
        categoryTypeImageView=(ImageView)findViewById(R.id.category_type_iv);
        cartImageView=(ImageView)findViewById(R.id.cart);
        billImageView=(ImageView)findViewById(R.id.bill);
        categoryNameTextView=(TextView)findViewById(R.id.category_name);
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),categoryModel.imageViewResource);
        Bitmap blurredBitmap = BlurBuilder.blur(this, bitmap);
        categoryTypeImageView.setImageDrawable(new BitmapDrawable(blurredBitmap));
        categoryNameTextView.setText(categoryModel.categoryName);
        tableName=categoryModel.categoryId;
        cardArrayList=new ArrayList<>();
        databaseHelper=new DatabaseHelper(this);
        getFoodListFromDataBase();
        for(int i=0;i<foodItemModelArrayList.size();i++)
        {
            FoodItemModel foodItemModel=foodItemModelArrayList.get(i);
            CustomCard customCard=new CustomCard(context,foodItemModel);
            CustomCardHeader customCardHeader=new CustomCardHeader(context,foodItemModel);
            CustomCardExpand customCardExpand=new CustomCardExpand(context,foodItemModel,tableName);
            customCard.addCardExpand(customCardExpand);
            customCardHeader.setButtonExpandVisible(true);
            customCard.addCardHeader(customCardHeader);
            cardArrayList.add(customCard);
        }

        CardArrayAdapter cardArrayAdapter=new CardArrayAdapter(context,cardArrayList);
        CardListView cardListView=(CardListView)findViewById(R.id.myList);
        cardListView.setAdapter(cardArrayAdapter);

        cartImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, CartActivity.class);
                startActivity(i);
            }
        });

        billImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, BillActivity.class);
                startActivity(i);
            }
        });
    }

    void getFoodListFromDataBase()
    {
        foodItemModelArrayList=databaseHelper.getAllFoodItem(tableName);
    }


}
