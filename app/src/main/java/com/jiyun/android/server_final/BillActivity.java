package com.jiyun.android.server_final;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;



public class BillActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    CartAdapter cartAdapter;
    ArrayList<CartModel> cartModelArrayList;
    ArrayList<OrderModel> orderModelArrayList;
    DatabaseHelper databaseHelper;
    TextView grandTotal;
    Button finish;
    int total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        recyclerView=(RecyclerView)findViewById(R.id.cart_rv);
        databaseHelper=new DatabaseHelper(this);
        linearLayoutManager=new LinearLayoutManager(this);
        cartModelArrayList=new ArrayList<>();
        orderModelArrayList=new ArrayList<>();
        finish=(Button)findViewById(R.id.finish);
        getData();
        getTotal();
        grandTotal=(TextView)findViewById(R.id.total_tv);
        grandTotal.setText(total + "");
        cartAdapter=new CartAdapter(cartModelArrayList,this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cartAdapter);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteAllTheEntriesFromTable("bill");
                databaseHelper.deleteAllTheEntriesFromTable("orders");
                finish();

            }
        });
    }

    public void getData()
    {
        orderModelArrayList=databaseHelper.getBillsFromTableNumber(1);

        for(int i=0;i<orderModelArrayList.size();i++)
        {
            OrderModel orderModel=orderModelArrayList.get(i);
            String foodItemId=orderModel.foodItemId;
            String tableName=orderModel.tableName;
            String orderId=orderModel.orderId;
            int quantity=orderModel.quantity;
            FoodItemModel foodItemModel=databaseHelper.getFoodItemFromId(foodItemId,tableName);
            cartModelArrayList.add(new CartModel(foodItemModel,quantity,tableName,orderId));
        }
    }

    public void getTotal()
    {
        for(int i=0;i<cartModelArrayList.size();i++)
        {
            CartModel cartModel=cartModelArrayList.get(i);
            int quantity=cartModel.quantity;
            int price=Integer.parseInt(cartModel.foodItemModel.foodItemPrice);
            total=total+price*quantity;
        }
    }
}
