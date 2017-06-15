package com.jiyun.android.server_final;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by guneet pc on 18-02-2016.
 */
public class FoodItemModel implements Parcelable
{
    String id;
    String foodItemName;
    String foodItemPrice;
    String foodItemDescription;
    int foodItemImageResource;
    int rating;
    int quantity;

    FoodItemModel()
    {

    }
    FoodItemModel(String id,String foodItemName,String foodItemPrice,String foodItemDescription,int foodItemImageResource,int rating,int quantity)
    {
        this.id=id;
        this.foodItemName=foodItemName;
        this.foodItemPrice=foodItemPrice;
        this.foodItemDescription=foodItemDescription;
        this.foodItemImageResource=foodItemImageResource;
        this.rating=rating;
        this.quantity=quantity;
    }

    protected FoodItemModel(Parcel in) {
        id = in.readString();
        foodItemName = in.readString();
        foodItemPrice = in.readString();
        foodItemDescription = in.readString();
        foodItemImageResource = in.readInt();
        rating = in.readInt();
        quantity = in.readInt();
    }

    public static final Creator<FoodItemModel> CREATOR = new Creator<FoodItemModel>() {
        @Override
        public FoodItemModel createFromParcel(Parcel in) {
            return new FoodItemModel(in);
        }

        @Override
        public FoodItemModel[] newArray(int size) {
            return new FoodItemModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(flags);
    }
}
