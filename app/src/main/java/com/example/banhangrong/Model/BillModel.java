package com.example.banhangrong.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.banhangrong.Class.Bill;
import com.example.banhangrong.Class.Food;
import com.example.banhangrong.Class.SellerAccount;
import com.example.banhangrong.ConstanDB.ConstDBName;

import java.util.ArrayList;

public class BillModel extends DatabaseHandler{

    private Bill bill;
    private ArrayList<Bill> listBill;
    public BillModel(Context context) {
        super(context);
    }

    public ArrayList<Bill> getAllFoods() {
        listBill = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM "+ConstDBName.NAME_TABLE_BILL+";", null);
        while (cursor.moveToNext()) {
            int billID = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_BILL_ID));
            int userID = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_BILL_USER_ID));
            int sellID = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_BILL_SELLER_ID));
            int locationID = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_BILL_LOCATION_ID));
           listBill.add(new Bill(billID,userID,sellID,locationID,1));
        }
        return listBill;
    }

}
