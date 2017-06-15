package com.jiyun.android.server_final;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    CategoryAdapter categoryAdapter;
    ArrayList<CategoryModel> categoryModelArrayList;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerView=(RecyclerView)findViewById(R.id.category_rv);
        gridLayoutManager=new GridLayoutManager(this,2);
        categoryModelArrayList=new ArrayList<>();
        databaseHelper=new DatabaseHelper(getApplication());
        initializeArrayList();
        initializeDataBase();
        categoryAdapter=new CategoryAdapter(categoryModelArrayList,getApplicationContext(),this);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(categoryAdapter);
    }

    void initializeDataBase()
    {
        databaseHelper.addFoodItemToTable(new FoodItemModel("so1","Organic SouthWestern Corn Chowder","175","A delectable blend of roasted corn,red bell pepper,potatoes and peppers",R.drawable.soup,3,0),"soup");

        databaseHelper.addFoodItemToTable(new FoodItemModel("bv1","Strawberry Fields","90","Strawberry,Banana and Apple Juice",R.drawable.beverage,5,0),"beverage");

        databaseHelper.addFoodItemToTable(new FoodItemModel("mo1","WaterMelon Colada","100","Strawberry,Banana and Apple Juice",R.drawable.mocktail,1,0),"mocktail");

        databaseHelper.addFoodItemToTable(new FoodItemModel("bu1","Southern Smokehouse Bacon Burger","325","With maple bacon, smoked cheddar, mayo, crispy onion strings and ancho-chile BBQ sauce",R.drawable.burger,4,0),"burger");

        databaseHelper.addFoodItemToTable(new FoodItemModel("de1","Molten Chocolate Cake","250","Topped with vanilla ice cream under a hard chocolate shell",R.drawable.dessert,4,0),"dessert");

        databaseHelper.addFoodItemToTable(new FoodItemModel("sv1","Hot Spinach & Artichoke Dip","220","Served with warm tostada chips",R.drawable.starter_veg,4,0),"starterVeg");

        databaseHelper.addFoodItemToTable(new FoodItemModel("sn1","Skillet Queso","400","Cheese dip with seasoned beef. Served with warm tostada chips and our house-made salsa",R.drawable.starter_non_veg,4,0),"starterNonVeg");

        databaseHelper.addFoodItemToTable(new FoodItemModel("pi1","VEGGIE SUPREME","425","Mushroom, capsicum, onion, tomato, baby corn and olives.",R.drawable.pizza,4,0),"pizza");

        databaseHelper.addFoodItemToTable(new FoodItemModel("pa1","TURBO PENNE ARRABBIATA","325","A fiery tomato sauce with garlic, basil, Scotch bonnet chillies, Bella Lodi & herby breadcrumbs",R.drawable.pasta,4,0),"pasta");

        databaseHelper.addFoodItemToTable(new FoodItemModel("no1","Singapore Fried Noodles","180","Thin rice noodles with roast pork, shrimp, bean sprouts, onions, carrots and spring onions in a light curry sauce.",R.drawable.noodle,5,0),"noodle");

        databaseHelper.addFoodItemToTable(new FoodItemModel("cg1","Spicy Vegetarian Thai Noodle Bowl","325","The Noodle Bowl is an easy one pot dish with a that is has a thai flavored light broth, packed with vegetables, noodles and sesame crusted tofu.",R.drawable.chinese_gravy,4,0),"chineseGravy");

        databaseHelper.addFoodItemToTable(new FoodItemModel("vg1","Spinach Kofta Curry","250","Spinach kofta curry is an exotic gravy-based dish. These spinach and potato koftas (also known as pakoras or dumplings) are simmered in rich creamy tomato gravy making this a very delicious dish.",R.drawable.indian_gravy_veg,4,0),"indianGravyVeg");

        databaseHelper.addFoodItemToTable(new FoodItemModel("ng1","mangalorean chicken curry","340","Kori Gassi or Mangalore chicken curry with coconut goes well pundi, rotti, neer dosa & rice.",R.drawable.indian_gravy_non_veg,4,0),"indianGravyNonVeg");

        databaseHelper.addFoodItemToTable(new FoodItemModel("br1","Garlic Naan","70","Delicious naan bread topped with chopped garlic, one of our most popular sides.",R.drawable.bread,4,0),"bread");

        databaseHelper.addFoodItemToTable(new FoodItemModel("be1","QUENCHING","390","Softly spicy and fruity German- and Belgian-style wheat beers",R.drawable.beer,4,0),"beer");

        databaseHelper.addFoodItemToTable(new FoodItemModel("wh1","Auchentoshan Classic","499","Honey with light citrus fruit",R.drawable.whisky,4,0),"whisky");

        databaseHelper.addCommentToTable(new Comment("co1", "so1", "Excellent"));

    }

    void initializeArrayList()
    {
        categoryModelArrayList.add(new CategoryModel(R.drawable.soup,"SOUPS","soup"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.beverage,"BEVERAGES","beverage"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.mocktail,"MOCKTAILS","mocktail"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.beer,"BEER","beer"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.whisky,"WHISKY","whisky"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.starter_veg,"VEG STARTERS","starterVeg"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.starter_non_veg,"NON VEG STARTERS","starterNonVeg"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.pizza,"PIZZAS","pizza"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.burger,"BURGERS","burger"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.pasta,"PASTAS","pasta"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.noodle,"NOODLES","noodle"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.chinese_gravy,"CHINESE GRAVIES","chineseGravy"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.indian_gravy_veg,"VEG INDIAN GRAVIES","indianGravyVeg"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.indian_gravy_non_veg,"NON VEG INDIAN GRAVIES","indianGravyNonVeg"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.bread,"BREADS","bread"));
        categoryModelArrayList.add(new CategoryModel(R.drawable.dessert,"DESSERTS","dessert"));
    }
}
