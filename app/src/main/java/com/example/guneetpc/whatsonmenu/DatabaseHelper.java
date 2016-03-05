package com.example.guneetpc.whatsonmenu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper
{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "FoodManager";


    public static final String TABLE_SOUP = "soup";
    public static final String TABLE_MOCKTAIL = "mocktail";
    public static final String TABLE_BEVERAGE = "beverage";
    public static final String TABLE_WHISKY = "whisky";
    public static final String TABLE_BEER = "beer";
    public static final String TABLE_STARTER_VEG = "starterVeg";
    public static final String TABLE_STARTER_NON_VEG = "starterNonVeg";
    public static final String TABLE_PIZZA = "pizza";
    public static final String TABLE_BURGER = "burger";
    public static final String TABLE_PASTA = "pasta";
    public static final String TABLE_NOODLE = "noodle";
    public static final String TABLE_CHINESE_GRAVY = "chineseGravy";
    public static final String TABLE_INDIAN_GRAVY_VEG = "indianGravyVeg";
    public static final String TABLE_INDIAN_GRAVY_NON_VEG = "indianGravyNonVeg";
    public static final String TABLE_BREAD = "bread";
    public static final String TABLE_DESSERT = "dessert";
    public static final String TABLE_COMMENT = "comment";
    public static final String TABLE_ORDER = "orders";
    public static final String TABLE_BILL = "bill";


    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PRICE = "price";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE_ID = "imageId";
    private static final String KEY_RATING = "rating";
    private static final String KEY_QUANTITY = "quantity";

    private static final String KEY_REVIEW = "review";
    private static final String KEY_FOOD_ITEM_ID = "foodItemId";
    private static final String KEY_TABLE_NUMBER = "tableNumber";
    private static final String KEY_TABLE_NAME = "tableName";



    private static final String CREATE_TABLE_SOUP = "CREATE TABLE IF NOT EXISTS "
            + TABLE_SOUP + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_MOCKTAIL = "CREATE TABLE IF NOT EXISTS "
            + TABLE_MOCKTAIL + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_BEVERAGE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_BEVERAGE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_WHISKY = "CREATE TABLE IF NOT EXISTS "
            + TABLE_WHISKY + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_BEER = "CREATE TABLE IF NOT EXISTS "
            + TABLE_BEER + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_STARTER_VEG = "CREATE TABLE IF NOT EXISTS "
            + TABLE_STARTER_VEG + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_STARTER_NON_VEG = "CREATE TABLE IF NOT EXISTS "
            + TABLE_STARTER_NON_VEG + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_PIZZA = "CREATE TABLE IF NOT EXISTS "
            + TABLE_PIZZA + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_BURGER = "CREATE TABLE IF NOT EXISTS "
            + TABLE_BURGER + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_PASTA = "CREATE TABLE IF NOT EXISTS "
            + TABLE_PASTA + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_NOODLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NOODLE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_CHINESE_GRAVY = "CREATE TABLE IF NOT EXISTS "
            + TABLE_CHINESE_GRAVY + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_INDIAN_GRAVY_VEG = "CREATE TABLE IF NOT EXISTS "
            + TABLE_INDIAN_GRAVY_VEG + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_INDIAN_GRAVY_NON_VEG = "CREATE TABLE IF NOT EXISTS "
            + TABLE_INDIAN_GRAVY_NON_VEG + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_BREAD= "CREATE TABLE IF NOT EXISTS "
            + TABLE_BREAD + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";


    private static final String CREATE_TABLE_DESSERT = "CREATE TABLE IF NOT EXISTS "
            + TABLE_DESSERT + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESCRIPTION
            + " TEXT," + KEY_IMAGE_ID + " INTEGER," + KEY_RATING + " INTEGER," + KEY_QUANTITY + " INTEGER" + ")";

    private static final String CREATE_TABLE_COMMENT = "CREATE TABLE IF NOT EXISTS "
            + TABLE_COMMENT + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_FOOD_ITEM_ID
            + " TEXT," + KEY_REVIEW + " TEXT" + ")";

    private static final String CREATE_TABLE_ORDER = "CREATE TABLE IF NOT EXISTS "
            + TABLE_ORDER + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_TABLE_NUMBER
            + " INTEGER," + KEY_FOOD_ITEM_ID + " TEXT," + KEY_TABLE_NAME + " TEXT," + KEY_QUANTITY + " INTEGER" + ")";

    private static final String CREATE_TABLE_BILL = "CREATE TABLE IF NOT EXISTS "
            + TABLE_BILL + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_TABLE_NUMBER
            + " INTEGER," + KEY_FOOD_ITEM_ID + " TEXT," + KEY_TABLE_NAME + " TEXT," + KEY_QUANTITY + " INTEGER" + ")";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BEER);
        db.execSQL(CREATE_TABLE_BREAD);
        db.execSQL(CREATE_TABLE_BURGER);
        db.execSQL(CREATE_TABLE_SOUP);
        db.execSQL(CREATE_TABLE_MOCKTAIL);
        db.execSQL(CREATE_TABLE_BEVERAGE);
        db.execSQL(CREATE_TABLE_WHISKY);
        db.execSQL(CREATE_TABLE_STARTER_VEG);
        db.execSQL(CREATE_TABLE_STARTER_NON_VEG);
        db.execSQL(CREATE_TABLE_PIZZA);
        db.execSQL(CREATE_TABLE_PASTA);
        db.execSQL(CREATE_TABLE_NOODLE);
        db.execSQL(CREATE_TABLE_CHINESE_GRAVY);
        db.execSQL(CREATE_TABLE_INDIAN_GRAVY_VEG);
        db.execSQL(CREATE_TABLE_INDIAN_GRAVY_NON_VEG);
        db.execSQL(CREATE_TABLE_DESSERT);
        db.execSQL(CREATE_TABLE_COMMENT);
        db.execSQL(CREATE_TABLE_ORDER);
        db.execSQL(CREATE_TABLE_BILL);
    }

    public void addFoodItemToTable(FoodItemModel foodItemModel,String tableName)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY_ID, foodItemModel.id);
        contentValues.put(KEY_NAME, foodItemModel.foodItemName);
        contentValues.put(KEY_PRICE, foodItemModel.foodItemPrice);
        contentValues.put(KEY_DESCRIPTION, foodItemModel.foodItemDescription);
        contentValues.put(KEY_IMAGE_ID, foodItemModel.foodItemImageResource);
        contentValues.put(KEY_RATING, foodItemModel.rating);
        contentValues.put(KEY_QUANTITY, foodItemModel.quantity);
        sqLiteDatabase.insert(tableName, null, contentValues);
        sqLiteDatabase.close();
    }

    public ArrayList<FoodItemModel> getAllFoodItem(String tableName)
    {
        ArrayList<FoodItemModel> foodItemModelArrayList = new ArrayList<FoodItemModel>();
        String selectQuery = "SELECT  * FROM " + tableName;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                FoodItemModel contact = new FoodItemModel();
                contact.id=cursor.getString(0);
                contact.foodItemName=cursor.getString(1);
                contact.foodItemPrice=cursor.getString(2);
                contact.foodItemDescription=cursor.getString(3);
                contact.foodItemImageResource=Integer.parseInt(cursor.getString(4));
                contact.rating=Integer.parseInt(cursor.getString(5));
                contact.quantity=(Integer.parseInt(cursor.getString(6)));
                foodItemModelArrayList.add(contact);
            } while (cursor.moveToNext());
        }
        return foodItemModelArrayList;
    }

    public FoodItemModel getFoodItemFromId(String id,String tableName)
    {
        String selectQuery = "SELECT * FROM "+tableName+" WHERE id = '" + id + "'";
        FoodItemModel contact=null;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do {
                contact = new FoodItemModel();
                contact.id=cursor.getString(0);
                contact.foodItemName=cursor.getString(1);
                contact.foodItemPrice=cursor.getString(2);
                contact.foodItemDescription=cursor.getString(3);
                contact.foodItemImageResource=Integer.parseInt(cursor.getString(4));
                contact.rating=Integer.parseInt(cursor.getString(5));
                contact.quantity=(Integer.parseInt(cursor.getString(6)));
            } while (cursor.moveToNext());
        }
        return contact;
    }

    public void addOrderToTable(OrderModel orderModel)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(KEY_ID,orderModel.orderId);
        value.put(KEY_TABLE_NUMBER,orderModel.tableNumber);
        value.put(KEY_FOOD_ITEM_ID,orderModel.foodItemId);
        value.put(KEY_TABLE_NAME,orderModel.tableName);
        value.put(KEY_QUANTITY,orderModel.quantity);
        db.insert(TABLE_ORDER,null,value);
        db.close();
    }

    public void addBillOrderToTable(OrderModel orderModel)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(KEY_ID,orderModel.orderId);
        value.put(KEY_TABLE_NUMBER,orderModel.tableNumber);
        value.put(KEY_FOOD_ITEM_ID,orderModel.foodItemId);
        value.put(KEY_TABLE_NAME,orderModel.tableName);
        value.put(KEY_QUANTITY, orderModel.quantity);
        db.insert(TABLE_BILL,null,value);
        db.close();
    }

    public ArrayList<OrderModel> getOrdersFromTableNumber(int tableNumber)
    {
        ArrayList<OrderModel> orderModelArrayList=new ArrayList<OrderModel>();

        String selectQuery = "SELECT * FROM orders WHERE tableNumber = '" + tableNumber + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do {
                OrderModel contact = new OrderModel();
                contact.orderId=(cursor.getString(0));
                contact.tableNumber=Integer.parseInt(cursor.getString(1));
                contact.foodItemId=(cursor.getString(2));
                contact.tableName=(cursor.getString(3));
                contact.quantity=Integer.parseInt(cursor.getString(4));
                orderModelArrayList.add(contact);
            } while (cursor.moveToNext());
        }
        return orderModelArrayList;
    }

    public ArrayList<OrderModel> getBillsFromTableNumber(int tableNumber)
    {
        ArrayList<OrderModel> orderModelArrayList=new ArrayList<OrderModel>();
        String selectQuery = "SELECT * FROM bill WHERE tableNumber = '" + tableNumber + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do {
                OrderModel contact = new OrderModel();
                contact.orderId=(cursor.getString(0));
                contact.tableNumber=Integer.parseInt(cursor.getString(1));
                contact.foodItemId=(cursor.getString(2));
                contact.tableName=(cursor.getString(3));
                contact.quantity=Integer.parseInt(cursor.getString(4));
                orderModelArrayList.add(contact);
            } while (cursor.moveToNext());
        }
        return orderModelArrayList;
    }

    public void addCommentToTable(Comment comment)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(KEY_ID,comment.commentId);
        value.put(KEY_FOOD_ITEM_ID,comment.foodItemId);
        value.put(KEY_REVIEW,comment.review);
        db.insert(TABLE_COMMENT,null,value);
        db.close();
    }

    public ArrayList<Comment> getAllCommentFromId(String id)
    {
        ArrayList<Comment> commentArrayList=new ArrayList<Comment>();
        String selectQuery = "SELECT * FROM comment WHERE foodItemId = '" + id + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do {
                Comment contact = new Comment();
                contact.commentId=(cursor.getString(0));
                contact.foodItemId=(cursor.getString(1));
                contact.review=(cursor.getString(2));
                commentArrayList.add(contact);
            } while (cursor.moveToNext());
        }
        return commentArrayList;
    }

    public void deleteOrderWithId(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_ORDER,KEY_ID + "=?",new String[]{id});
    }

    public void deleteAllTheEntriesFromTable(String tableName)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from "+ tableName);
    }

    public int getOrderTableSize()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from orders", null);
        return c.getCount();
    }

    public int getBillTableSize()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from bill", null);
        return c.getCount();
    }

    public int getTableSize(String tableName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from "+tableName, null);
        return c.getCount();
    }


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
