package com.example.guneetpc.whatsonmenu;

import java.io.Serializable;

/**
 * Created by guneet pc on 17-02-2016.
 */
public class CategoryModel implements Serializable
{
    int imageViewResource;
    String categoryName;
    String categoryId;
    CategoryModel(int imageViewResource,String categoryName,String categoryId)
    {
        this.categoryName=categoryName;
        this.imageViewResource=imageViewResource;
        this.categoryId=categoryId;
    }
}
