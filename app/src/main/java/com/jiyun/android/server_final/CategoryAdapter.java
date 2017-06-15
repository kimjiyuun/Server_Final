package com.jiyun.android.server_final;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>
{
    ArrayList<CategoryModel> categoryModelArrayList;
    Context context;
    Activity activity;

    CategoryAdapter(ArrayList<CategoryModel> categoryModelArrayList,Context context,Activity activity)
    {
        this.categoryModelArrayList=categoryModelArrayList;
        this.context=context;
        this.activity=activity;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout, parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(v);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(final CategoryViewHolder holder, int position) {
        final CategoryModel categoryModel=categoryModelArrayList.get(position);
        holder.imageView.setImageResource(categoryModel.imageViewResource);
        holder.textView.setText(categoryModel.categoryName);
        holder.idTextView.setText(categoryModel.categoryId);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,FoodListActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("categoryModel", categoryModel);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryModelArrayList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        TextView idTextView;
        CardView cardView;
        public CategoryViewHolder(View itemView)
        {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.category_image_iv);
            textView=(TextView)itemView.findViewById(R.id.category_name_tv);
            idTextView=(TextView)itemView.findViewById(R.id.category_id_tv);
            cardView=(CardView)itemView.findViewById(R.id.category_cv);
        }
    }

}
