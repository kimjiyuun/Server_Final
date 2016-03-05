package com.example.guneetpc.whatsonmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    CartAdapter cartAdapter;
    ArrayList<CartModel> cartModelArrayList;
    ArrayList<OrderModel> orderModelArrayList;
    DatabaseHelper databaseHelper;
    TextView grandTotal;
    Button confirmOrder;
    BillActivity billActivity;
    int total=0;

    String table1key="O6F4A13MDUEW3740";
    String table2key="UYG7LD9Z0HZ0QJ6V";
    String table3key="6B24KIRRUB40WOPX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerView=(RecyclerView)findViewById(R.id.cart_rv);
        databaseHelper=new DatabaseHelper(this);
        billActivity=new BillActivity();
        linearLayoutManager=new LinearLayoutManager(this);
        cartModelArrayList=new ArrayList<>();
        orderModelArrayList=new ArrayList<>();
        grandTotal=(TextView)findViewById(R.id.total_tv);
        confirmOrder=(Button)findViewById(R.id.confirm_order_Button);
        getData();
        getTotal();
        grandTotal.setText(total + "");
        cartAdapter=new CartAdapter(cartModelArrayList,this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cartAdapter);


        confirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cartModelArrayList.size()>8)
                {
                    Toast.makeText(getApplicationContext(),"Please Remove Some Items",Toast.LENGTH_SHORT).show();
                }
                else
                {
                   // int numItem=cartModelArrayList.size();
                    sendOrderToKitchen();
                }
            }
        });

        SwipeableRecyclerViewTouchListener swipeTouchListener =
                new SwipeableRecyclerViewTouchListener(recyclerView,
                        new SwipeableRecyclerViewTouchListener.SwipeListener() {

                            @Override
                            public boolean canSwipe(int position) {
                                return true;
                            }

                            @Override
                            public boolean canSwipeLeft(int position) {
                                return true;
                            }

                            @Override
                            public boolean canSwipeRight(int position) {
                                return true;
                            }

                            @Override
                            public void onDismissedBySwipeLeft(RecyclerView recyclerView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    CartModel cartModel=cartModelArrayList.get(position);
                                    String orderId=cartModel.orderId;
                                    databaseHelper.deleteOrderWithId(orderId);
                                    cartModelArrayList.remove(position);
                                    cartAdapter.notifyItemRemoved(position);
                                    total=0;
                                    getTotal();
                                    grandTotal.setText(total + "");

                                }
                                cartAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onDismissedBySwipeRight(RecyclerView recyclerView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    CartModel cartModel=cartModelArrayList.get(position);
                                    String orderId=cartModel.orderId;
                                    databaseHelper.deleteOrderWithId(orderId);
                                    cartModelArrayList.remove(position);
                                    cartAdapter.notifyItemRemoved(position);
                                    total=0;
                                    getTotal();
                                    grandTotal.setText(total + "");
                                }
                                cartAdapter.notifyDataSetChanged();
                            }
                        });

        recyclerView.addOnItemTouchListener(swipeTouchListener);
    }

    public void getData()
    {
        orderModelArrayList=databaseHelper.getOrdersFromTableNumber(1);

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


    public void sendOrderToKitchen()
    {
        MyVolley.init(getApplicationContext());
        RequestQueue queue = MyVolley.getRequestQueue();


        StringRequest myReq = new StringRequest(Request.Method.POST,"http://api.thingspeak.com/update"
                , reqSuccessListener(), reqErrorListener()) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                return headers;
            }

            protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();



                    for(int i=0;i<cartModelArrayList.size();i++)
                    {
                        CartModel cartModel=cartModelArrayList.get(i);
                        params.put("key", table2key);
                        params.put("field"+(i+1),cartModel.foodItemModel.id+cartModel.quantity+cartModel.tableName);
                    }

                return params;
            }
        };
        myReq.setRetryPolicy(new DefaultRetryPolicy(25000, 1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(myReq);

    }

    private com.android.volley.Response.Listener<String> reqSuccessListener() {
        return new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Log.d(TAG,"in volley success");
                //Log.d(TAG, "Response" + response);
                Toast.makeText(getApplicationContext(),"Ordered Successfully",Toast.LENGTH_LONG).show();





                int id=databaseHelper.getBillTableSize()+1;
                for(int i=0;i<cartModelArrayList.size();i++)
                {
                    CartModel cartModel=cartModelArrayList.get(i);
                    databaseHelper.addBillOrderToTable(new OrderModel("or"+id+i,1,cartModel.foodItemModel.id,cartModel.tableName,cartModel.quantity));
                }


                databaseHelper.deleteAllTheEntriesFromTable("orders");
                cartModelArrayList.clear();
                cartAdapter.notifyDataSetChanged();
                finish();

            }
        };
    }

    private com.android.volley.Response.ErrorListener reqErrorListener() {
        return new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // Log.d(TAG,"in volley error");
               // Log.d(TAG, error.toString());
                //Toast.makeText(getApplicationContext(), "Couldn't Send Patient Card", Toast.LENGTH_LONG).show();
            }
        };
    }




}
