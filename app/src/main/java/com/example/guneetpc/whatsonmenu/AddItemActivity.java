package com.example.guneetpc.whatsonmenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AddItemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView tvselimage;
    LinearLayout ll1;
    Button addToMenu;
    EditText itemName;
    EditText itemPrice;
    EditText itemDescription;
    String tableName;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        addToMenu=(Button)findViewById(R.id.badditem);
        tvselimage=(ImageView)findViewById(R.id.iv_selectImage);
        databaseHelper=new DatabaseHelper(this);
        ll1=(LinearLayout)findViewById(R.id.lladditem);
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.back11);
        Bitmap blurredBitmap = BlurBuilder.blur(this, bitmap);
        ll1.setBackground(new BitmapDrawable(blurredBitmap));
        tvselimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 0);

            }
        });
        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("soup");
        categories.add("beverage");
        categories.add("mocktail");
        categories.add("beer");
        categories.add("whisky");
        categories.add("burger");
        categories.add("pasta");
        categories.add("pizza");
        categories.add("starterVeg");
        categories.add("starterNonVeg");
        categories.add("noodle");
        categories.add("chineseGravy");
        categories.add("indianGravyVeg");
        categories.add("indianGravyNonVeg");
        categories.add("bread");
        categories.add("dessert");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        itemName=(EditText)findViewById(R.id.et_addinginterface_item_name);
        itemPrice=(EditText)findViewById(R.id.et_addinginterface_item_price);
        itemDescription=(EditText)findViewById(R.id.et_addinginterface_item_description);

        addToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableName=spinner.getSelectedItem().toString();
                addFoodItem();
                Intent intent=new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent);
            }
        });
    }



    public void addFoodItem()
    {
        int id=databaseHelper.getTableSize(tableName)+1;
        databaseHelper.addFoodItemToTable(new FoodItemModel(tableName.substring(0,1)+id,itemName.getText().toString(),itemPrice.getText().toString(),itemDescription.getText().toString(),R.drawable.soup,3,0),tableName);
    }

    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data) {
        if(resCode == Activity.RESULT_OK && data != null){
            String realPath;
            if (Build.VERSION.SDK_INT < 11)
                realPath = RealPathUtil.getRealPathFromURI_BelowAPI11(this, data.getData());
            else if (Build.VERSION.SDK_INT < 19)
                realPath = RealPathUtil.getRealPathFromURI_API11to18(this, data.getData());
            else
                realPath = RealPathUtil.getRealPathFromURI_API19(this, data.getData());
            Uri uriFromPath = Uri.fromFile(new File(realPath));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
        ((TextView) parent.getChildAt(0)).setTextSize(20);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
