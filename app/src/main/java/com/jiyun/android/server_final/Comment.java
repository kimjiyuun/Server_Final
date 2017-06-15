package com.jiyun.android.server_final;
/**
 * Created by guneet pc on 19-02-2016.
 */
public class Comment
{
    String commentId;
    String foodItemId;
    String review;

    Comment()
    {

    }
    Comment(String commentId,String foodItemId,String review)
    {
        this.commentId=commentId;
        this.foodItemId=foodItemId;
        this.review=review;
    }
}
