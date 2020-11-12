package com.example.banhangrong.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.banhangrong.Class.Food;
import com.example.banhangrong.Class.FoodImage;
import com.example.banhangrong.Class.SellerAccount;
import com.example.banhangrong.ConstanDB.ConstDBName;

import java.util.ArrayList;

public class FoodModel extends DatabaseHandler {

    private ArrayList<Food> foods;
    private ArrayList<FoodImage> foodImages;

    public FoodModel(Context context) {
        super(context);
    }

    public ArrayList<Food> getAllFoods(int type) {
        foods = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Food where typeID="+type, null);
        while (cursor.moveToNext()) {
            int foodId = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_ID));
            String foodName = cursor.getString(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_FOOD_NAME));
            int sellID = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_SELLER_ID));
            int typeID = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_TYPE_ID));
            float price = cursor.getFloat(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_PRICE));
            int number = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_NUMBER));
            String description = cursor.getString(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_DESCRIPTION));
            int status = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_STATUS));
            foods.add(new Food(foodId,foodName,sellID,typeID,price,number,description,status));
        }
        return foods;
    }
    public ArrayList<Food> getFoodByID(int foodID) {
        foods = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Food where foodID = "+foodID, null);
        while (cursor.moveToNext()) {
            int foodId = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_ID));
            String foodName = cursor.getString(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_FOOD_NAME));
            int sellID = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_SELLER_ID));
            int typeID = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_TYPE_ID));
            float price = cursor.getFloat(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_PRICE));
            int number = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_NUMBER));
            String description = cursor.getString(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_DESCRIPTION));
            int status = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_STATUS));
            foods.add(new Food(foodId,foodName,sellID,typeID,price,number,description,status));
        }
        return foods;
    }
    public ArrayList<FoodImage> getAllFoodImageByID(int foodID) {
        foodImages = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM FoodImage where foodID = "+foodID, null);
        while (cursor.moveToNext()) {
            int imageID = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_IMAGE_ID));
            byte[] image = cursor.getBlob(cursor.getColumnIndex(ConstDBName.NAME_TABLE_FOOD_IMAGE_URL));
            foodImages.add(new FoodImage(imageID,image,foodID,1));
        }
        return foodImages;
    }


    public int addFood(Food food) {
        try {
            SQLiteDatabase database = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(ConstDBName.NAME_TABLE_FOOD_FOOD_NAME, food.getFoodName());
            values.put(ConstDBName.NAME_TABLE_FOOD_NUMBER, food.getNumber());
            values.put(ConstDBName.NAME_TABLE_FOOD_DESCRIPTION, food.getDescription());
            values.put(ConstDBName.NAME_TABLE_FOOD_PRICE, food.getPrice());
            values.put(ConstDBName.NAME_TABLE_FOOD_SELLER_ID, food.getSellID());
            values.put(ConstDBName.NAME_TABLE_FOOD_TYPE_ID, food.getTypeID());
            values.put(ConstDBName.NAME_TABLE_FOOD_STATUS, food.getStatus());
            database.insert(ConstDBName.NAME_TABLE_FOOD, null, values);
            int id = getHighestID(database);
            database.close();
            return id;
        } catch (Exception e) {
            Log.e("Insert Fail",e.getMessage());
            return -1;
        }

    }
    public int getHighestID(SQLiteDatabase database) {
        final String MY_QUERY = "SELECT last_insert_rowid()";
        Cursor cur = database.rawQuery(MY_QUERY, null);
        cur.moveToFirst();
        int ID = cur.getInt(0);
        cur.close();
        return ID;
    }

    public void addFoodImage(FoodImage foodImage) {
        try {
            SQLiteDatabase database = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(ConstDBName.NAME_TABLE_FOOD_IMAGE_FOOD_ID, foodImage.getFoodId());
            values.put(ConstDBName.NAME_TABLE_FOOD_IMAGE_URL, foodImage.getURL());
            values.put(ConstDBName.NAME_TABLE_FOOD_IMAGE_STATUS, foodImage.getStatus());
            database.insert(ConstDBName.NAME_TABLE_FOOD_IMAGE, null, values);
            database.close();
        } catch (Exception e) {
            Log.e("SQL", "Can't insert");
        }

    }
    public void deleteFoodImage(String table,String primary,int ID) {
        try {
            SQLiteDatabase database = this.getWritableDatabase();
            database.execSQL("DELETE FROM "+table+" where "+primary+" = "+ID);
        } catch (Exception e) {
            Log.e("SQL", "Can't Delete");
        }

    }
    public void changeStatusFood(int status, int foodId) {
        try {
            SQLiteDatabase database = this.getWritableDatabase();
            database.execSQL("UPDATE Food SET status ="+status+" WHERE foodID= "+foodId);
        } catch (Exception e) {
            Log.e("SQL", "Can't Delete");
        }

    }
    public void editFood(int foodId,String foodName,float price, int number , String des) {
        try {
            SQLiteDatabase database = this.getWritableDatabase();
            String query = "UPDATE Food SET " +
                    " foodName ='"+foodName+"', "+
                    " price ="+price+", "+
                    " number ="+number+", "+
                    " description ='"+des+"' "+
                    " WHERE foodID= "+foodId;
            database.execSQL(query);
        } catch (Exception e) {
            Log.e("SQL", "Can't Delete");
        }

    }

}
