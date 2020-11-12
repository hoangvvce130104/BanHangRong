package com.example.banhangrong.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.banhangrong.Class.SellerAccount;
import com.example.banhangrong.Class.UserAccount;
import com.example.banhangrong.ConstanDB.ConstDBName;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.content.ContentValues.TAG;

public class SellerAccountModel extends DatabaseHandler {
    private ArrayList<SellerAccount> sellerAccounts;

    public SellerAccountModel(Context context) {
        super(context);
    }

    public void addUserAccount(SellerAccount sellerAccount) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_PHONE_NUMBER, sellerAccount.getPhoneNumber());
        values.put(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_PASSWORD, sellerAccount.getPassword());
        values.put(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_NAME_OF_SELLER, sellerAccount.getSellerName());
        values.put(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_LOCATION_ID, sellerAccount.getLocationID());
        values.put(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_SELLER_TYPE_ID, sellerAccount.getSellerTypeID());
        values.put(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_DATE_OF_BIRTH, sellerAccount.getDateOfBirth());
        values.put(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_GENDER, sellerAccount.isGender());
        values.put(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_ADDRESS, sellerAccount.getAddress());
        values.put(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_GMAIL, sellerAccount.getGmail());
        values.put(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_HASH, sellerAccount.getHash());
        values.put(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_IMAGE, sellerAccount.getImage());
        values.put(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_STATUS, sellerAccount.getStatus());
        database.insert(ConstDBName.NAME_TABLE_SELLER_ACCOUNT, null, values);
        database.close();
    }

    public void addDefaultUserAccount() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("INSERT INTO SellerAccount (phoneNumber,password,sellerName,locationID,sellerTypeID,dateOfBirth,gender,address,gmail,hash,status) VALUES (\n" +
                "  '0963368232',\n" +
                "  'meodien1',\n" +
                "  'Vu Hoang',\n" +
                "  '1',\n" +
                "  '1',\n" +
                "  '2020/10/10',\n" +
                "  '1',\n" +
                "  'Bac Lieu',\n" +
                "  'hoangvvce130104@fpt.edu.vn',\n" +
                "  '1',\n" +
                "  '1'\n" +
                ")");
    }

    public ArrayList<SellerAccount> getAllSelers() {
        sellerAccounts = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM SellerAccount;", null);
        while (cursor.moveToNext()) {
            int sellerID = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_ID));
            String phoneNumber = cursor.getString(cursor.getColumnIndex(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_PHONE_NUMBER));
            String password = cursor.getString(cursor.getColumnIndex(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_PASSWORD));
            String sellerName = cursor.getString(cursor.getColumnIndex(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_NAME_OF_SELLER));
            int locationID = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_LOCATION_ID));
            int sellerTypeID = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_SELLER_TYPE_ID));
            String dateOfBirth = cursor.getString(cursor.getColumnIndex(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_DATE_OF_BIRTH));
            int gender = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_GENDER));
            String address = cursor.getString(cursor.getColumnIndex(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_ADDRESS));
            String gmail = cursor.getString(cursor.getColumnIndex(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_GMAIL));
            int hash = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_HASH));
            byte[] image = cursor.getBlob(cursor.getColumnIndex(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_IMAGE));
            int status = cursor.getInt(cursor.getColumnIndex(ConstDBName.NAME_TABLE_SELLER_ACCOUNT_STATUS));
            sellerAccounts.add(new SellerAccount(sellerID, phoneNumber, password, sellerName, locationID, sellerTypeID, dateOfBirth, gender, address, gmail, hash, image, status));
        }
        return sellerAccounts;
    }
}
