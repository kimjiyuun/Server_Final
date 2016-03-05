package com.example.guneetpc.whatsonmenu;

/**
 * Created by guneet pc on 20-02-2016.
 */
public class CartModel
{
    FoodItemModel foodItemModel;
    int quantity;
    String tableName;
    String orderId;
    CartModel(FoodItemModel foodItemModel,int quantity,String tableName,String orderId)
    {
        this.foodItemModel=foodItemModel;
        this.quantity=quantity;
        this.tableName=tableName;
        this.orderId=orderId;
    }
}
