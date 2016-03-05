package com.example.guneetpc.whatsonmenu;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class MainMainActivity extends AppCompatActivity {


    ListView lv;
    LayoutInflater l;
    ArrayList<FoodItemModel> dataaa;
    ListItemAdapter adapter;
    DatabaseHelper databaseHelper;

    String entry_id1="0";
    String entry_id2="0";
    String entry_id3="0";
    String lastentry_id1="77", lastentry_id2="77", lastentry_id3="77";

    int count=0;



    String addTable1="http://api.thingspeak.com/channels/89560/feeds/last";
    String addTable2="http://api.thingspeak.com/channels/89597/feeds/last";
    String addTable3="http://api.thingspeak.com/channels/89598/feeds/last";
    String addToPing=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);

        databaseHelper=new DatabaseHelper(this);

        lv=(ListView)findViewById(R.id.lvmain);
        dataaa=new ArrayList<FoodItemModel>();
        l=getLayoutInflater();

        ListItem l1=new ListItem("Chetan");
        ListItem l2=new ListItem("Mann");




        adapter=new ListItemAdapter(this, 0, dataaa, l);

        lv.setAdapter(adapter);

    }




    @Override
    protected void onResume() {
        super.onResume();
        callAsynchronousTask();
    }



    public void getOrderFromTable()
    {
        MyVolley.init(getApplicationContext());
        RequestQueue queue = MyVolley.getRequestQueue();


        count=(count+1)%3;

        Log.i("valuessssss", String.valueOf(count));

        if(count==0)
        {
            addToPing=addTable1;
            Log.i("valuesssssaa", "link1");
        }
        else if(count==1)
        {
            addToPing=addTable2;
            Log.i("valuesssssaa", "link2");
        }
        else if(count==2)
        {
            addToPing=addTable3;
            Log.i("valuesssssaa", "link3");
        }

        StringRequest myReq = new StringRequest(Request.Method.GET,addToPing
                , reqSuccessListener(), reqErrorListener()) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                return headers;
            }

            protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        myReq.setRetryPolicy(new DefaultRetryPolicy(5000, 1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(myReq);

    }

    public void callAsynchronousTask()
    {

        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            getOrderFromTable();
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                        }
                    }
                });
            }
        };
        timer.schedule(doAsynchronousTask, 0, 5000); //execute in every 50000 ms



    }

    private com.android.volley.Response.Listener<String> reqSuccessListener() {
        return new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject=new JSONObject(response);

                    int tableNo=count+1;
                    String fld1, fld2, fld3, fld4, fld5, fld6, fld7, fld8;

                    if(tableNo==1) {
                        entry_id1 = jsonObject.getString("entry_id");
                    }
                    else if(tableNo==2)
                    {
                        entry_id2 = jsonObject.getString("entry_id");
                    }
                    else if(tableNo==3)
                    {
                        entry_id3 = jsonObject.getString("entry_id");
                    }

                    fld1=jsonObject.getString("field1");
                    fld2=jsonObject.getString("field2");
                    fld3=jsonObject.getString("field3");
                    fld4=jsonObject.getString("field4");
                    fld5=jsonObject.getString("field5");
                    fld6=jsonObject.getString("field6");
                    fld7=jsonObject.getString("field7");
                    fld8=jsonObject.getString("field8");

                    switch (tableNo)
                    {
                        case 1:
                            if(!entry_id1.contentEquals(lastentry_id1))
                            {
                                decodeDataTable1(fld1);
                                decodeDataTable1(fld2);
                                decodeDataTable1(fld3);
                                decodeDataTable1(fld4);
                                decodeDataTable1(fld5);
                                decodeDataTable1(fld6);
                                decodeDataTable1(fld7);
                                decodeDataTable1(fld8);
                            }
                            break;
                        case 2:
                            if(!entry_id2.contentEquals(lastentry_id2))
                            {
                                decodeDataTable1(fld1);
                                decodeDataTable1(fld2);
                                decodeDataTable1(fld3);
                                decodeDataTable1(fld4);
                                decodeDataTable1(fld5);
                                decodeDataTable1(fld6);
                                decodeDataTable1(fld7);
                                decodeDataTable1(fld8);
                            }
                            break;
                        case 3:
                            if(!entry_id2.contentEquals(lastentry_id2))
                            {
                                decodeDataTable1(fld1);
                                decodeDataTable1(fld2);
                                decodeDataTable1(fld3);
                                decodeDataTable1(fld4);
                                decodeDataTable1(fld5);
                                decodeDataTable1(fld6);
                                decodeDataTable1(fld7);
                                decodeDataTable1(fld8);
                            }
                            break;

                    }




                    if(tableNo==1) {
                        lastentry_id1 = entry_id1;
                    }
                    else if(tableNo==2)
                    {
                        lastentry_id2 = entry_id2;
                    }
                    else if(tableNo==3)
                    {
                        lastentry_id3 =entry_id3;
                    }


                    Log.i("valuessssss", fld1+" "+fld2+" "+fld3+" "+fld4+" "+fld5+" "+fld6+" "+fld7+" "+fld8);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
    }



    public void decodeDataTable1(String data)
    {

        if((!data.isEmpty())&&(!data.equals("null")))
        {
            String id = data.substring(0, 3);
            String tableName = data.substring(4, data.length());
            int quantitity=Integer.parseInt(data.substring(3, 4));
            Log.i("dataaaaaa", "data :" + data + " id:" + id+" quantitity: "+String.valueOf(quantitity));

           // databaseHelper=new DatabaseHelper(this);

            FoodItemModel foodItemModel = databaseHelper.getFoodItemFromId(id, tableName);
            foodItemModel.quantity=quantitity;


            //  orderAdapter=new OrderAdapter(getApplicationContext(),foodItemModelArrayListTable1);
            // recyclerView.setAdapter(orderAdapter);
            dataaa.add(foodItemModel);
            adapter.notifyDataSetChanged();

            Log.i("arraylisttt", dataaa.toString());
        }

    }




    private com.android.volley.Response.ErrorListener reqErrorListener() {
        return new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }


}
