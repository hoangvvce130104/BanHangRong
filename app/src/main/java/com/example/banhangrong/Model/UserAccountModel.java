package com.example.banhangrong.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.banhangrong.Class.Location;
import com.example.banhangrong.Class.UserAccount;
import com.example.banhangrong.ConstanDB.ConstDBName;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.content.ContentValues.TAG;

public class UserAccountModel {
//    ArrayList<UserAccount> userAccounts;
//
//    public UserAccountModel(Context context) {
//        super(context);
//    }
//
//    public void addDefaultUserAccount(){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date = sdf.format(new Date());
//        UserAccount userAccount = new UserAccount("123456789","Khanh Nguyen", 1,date, 1, "0386686177", "Tra Vinh", 1, "ABC","khanhndq@gmail.com" );
//        addUserAccount(userAccount);
//    }
//
//    public void addUserAccount(UserAccount userAccount){
//        Log.i(TAG, "MyDatabaseHelper.addUserAccount ... " + userAccount.getUserID());
//        SQLiteDatabase database = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_PHONE_NUMBER, userAccount.getPhoneNumber());
//        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_PASSWORD, userAccount.getPassWord());
//        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_NAME_OF_USER, userAccount.getNameUser());
//        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_LOCATION_ID, userAccount.getLocationID());
//        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_DATE_OF_BIRTH, userAccount.getDateOfBirth());
//        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_GENDER, userAccount.getGender());
//        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_ADDRESS, userAccount.getAddress());
//        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_HASH, userAccount.getHash());
//        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_GMAIL, userAccount.getGmail());
//        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_STATUS, userAccount.getUserStatus());
//        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_IMAGE, (byte[]) null);
//        database.insert(ConstDBName.NAME_TABLE_USER_ACCOUNT, null, values);
//        database.close();
//    }
//    public UserAccount getUserAccount (int id) {
//        Log.i(TAG, "MyDatabaseHelper.getNote ... " + id);
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(ConstDBName.NAME_TABLE_USER_ACCOUNT, new String[] {
//                        ConstDBName.NAME_TABLE_USER_ACCOUNT_PHONE_NUMBER
//                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_PASSWORD
//                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_NAME_OF_USER
//                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_LOCATION_ID
//                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_DATE_OF_BIRTH
//                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_GENDER
//                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_ADDRESS
//                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_HASH
//                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_GMAIL
//                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_STATUS}
//                , ConstDBName.NAME_TABLE_USER_ACCOUNT_ID + "=?",
//                new String[] { String.valueOf(id) }, null, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        UserAccount account = new UserAccount(cursor.getString(1)
//                , cursor.getString(2)
//                , Integer.parseInt(cursor.getString(3))
//                ,cursor.getString(4)
//                ,Integer.parseInt(cursor.getString(5))
//                , cursor.getString(0)
//                , cursor.getString(6)
//                , Integer.parseInt(cursor.getString(9))
//                , cursor.getString(7)
//                , cursor.getString(8));
//        // return note
//        return account;
//    }
//    public ArrayList<UserAccount> getAllUserAccount(){
//        userAccounts = new ArrayList<>();
//        SQLiteDatabase database = getWritableDatabase();
//        String sql = "select * from UserAccount";
//        Cursor cursor = database.rawQuery(sql,null);
//        while (cursor.moveToNext()){
//            int id = = = cursor.getInt(0);
//            String phone = cursor.getString(1);
//            String password = cursor.getString(2);
//            String name = cursor.getString(3);
//            int location = = = cursor.getInt(4);
//            String date = cursor.getString(5);
//            int gender = = cursor.getInt(6);
//            String address = cursor.getString(7);
//            String hash = cursor.getString(8);
//            String gmail = cursor.getString(9);
//            int status = = cursor.getInt(10);
//            userAccounts.add(new UserAccount(id,phone,password,name,location,date,gender,address,hash,gmail,status));
//
//        }
//        return userAccounts;
//    }
}
