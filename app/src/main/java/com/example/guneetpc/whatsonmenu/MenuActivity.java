package com.example.guneetpc.whatsonmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {



    Button bhotel, bcutomer,manageOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bhotel=(Button)findViewById(R.id.bhm);
        bcutomer=(Button)findViewById(R.id.bcustomer);
        manageOrder=(Button)findViewById(R.id.manage_order);
        bhotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent();
                i.setClass(getApplicationContext(), AddItemActivity.class);
                startActivity(i);

            }
        });

        bcutomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent();
                i.setClass(getApplicationContext(), CategoryActivity.class);
                startActivity(i);

            }
        });

        manageOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainMainActivity.class);
                startActivity(i);
            }
        });

    }
}
