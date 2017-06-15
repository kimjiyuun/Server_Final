package com.jiyun.android.server_final;
/**
 * Created by guneet pc on 19-02-2016.
 */
public class OrderModel
{
    String orderId;
    int tableNumber;
    String foodItemId;
    String tableName;
    int quantity;
    OrderModel()
    {

    }
    OrderModel(String orderId,int tableNumber,String foodItemId,String tableName,int quantity)
    {
        this.orderId=orderId;
        this.tableNumber=tableNumber;
        this.foodItemId=foodItemId;
        this.tableName=tableName;
        this.quantity=quantity;
    }
}
