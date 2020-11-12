package com.example.banhangrong.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.banhangrong.Class.Location;
import com.example.banhangrong.Class.SellerType;
import com.example.banhangrong.ConstanDB.ConstDBName;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.ContentValues.TAG;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(Context context) {
        super(context, ConstDBName.NAME_DB, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryAdminAccount =
                "CREATE TABLE `AdminAccount` (\n" +
                        "  `adminID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `username` String,\n" +
                        "  `password` String,\n" +
                        "  `adminName` String,\n" +
                        "  `dateOfBirth` date,\n" +
                        "  `address` String,\n" +
                        "  `phoneNumber` String,\n" +
                        "   `image` blob,\n" +
                        "  `status` boolean\n" +
                        ");\n";
        String queryLocation =
                "CREATE TABLE `Location` (\n" +
                        "  `locationID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `longitude` float,\n" +
                        "  `latitude` float,\n" +
                        "  `status` int\n" +
                        ");\n";
        String queryCustomerAccount =
                "CREATE TABLE `CustomerAccount` (\n" +
                        "  `customerID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `phoneNumber` string,\n" +
                        "  `password` string,\n" +
                        "  `customerName` string,\n" +
                        "  `locationID` int,\n" +
                        "  `dateOfBirth` date,\n" +
                        "  `gender` boolean,\n" +
                        "  `address` string,\n" +
                        "  `gmail` string,\n" +
                        "  `hash` string,\n" +
                        "  `image` blob,\n" +
                        "  `status` int\n" +
                        ");\n";
        String querySellerAccount =
                "CREATE TABLE `SellerAccount` (\n" +
                        "  `sellerID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `phoneNumber` string,\n" +
                        "  `password` string,\n" +
                        "  `sellerName` string,\n" +
                        "  `locationID` int,\n" +
                        "  `sellerTypeID` int,\n" +
                        "  `dateOfBirth` date,\n" +
                        "  `gender` boolean,\n" +
                        "  `address` string,\n" +
                        "  `gmail` string,\n" +
                        "  `hash` string,\n" +
                        "  `image` blob,\n" +
                        "  `status` int\n" +
                        ");\n";
        String queryFeedBack =
                "CREATE TABLE `Feedback` (\n" +
                        "  `feedbackID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `userID` int,\n" +
                        "  `sellerID` int,\n" +
                        "  `date` datetime,\n" +
                        "  `title` string,\n" +
                        "  `description` string,\n" +
                        "  `status` int\n" +
                        ");\n";
        String queryFood =
                "CREATE TABLE `Food` (\n" +
                        "  `foodID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `foodName` String,\n" +
                        "  `sellerID` int,\n" +
                        "  `typeID` int,\n" +
                        "  `price` float,\n" +
                        "  `number` int,\n" +
                        "  `description` string,\n" +
                        "  `status` int\n" +
                        ");\n";
        String queryFoodType =
                "CREATE TABLE `FoodType` (\n" +
                        "  `foodTypeID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `name` String,\n" +
                        "  `status` int\n" +
                        ");\n";
        String queryFoodImage =
                "CREATE TABLE `FoodImage` (\n" +
                        "  `imageID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `image` blob,\n" +
                        "  `foodID` int,\n" +
                        "  `status` int\n" +
                        ");\n";
        String querySellerType =
                "CREATE TABLE `SellerType` (\n" +
                        "  `sellerTypeID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `name` String,\n" +
                        "  `status` int\n" +
                        ");\n";
        String queryBill =
                "CREATE TABLE `Bill` (\n" +
                        "  `billID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `userId` int,\n" +
                        "  `sellerID` int,\n" +
                        "  `locationID` int,\n" +
                        "  `status` int\n" +
                        ");\n";
        String queryBillDetail =
                "CREATE TABLE `BillDetail` (\n" +
                        "  `billDetailID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "  `billID` int,\n" +
                        "  `foodID` int,\n" +
                        "  `amount` int,\n" +
                        "  `description` String\n" +
                        ");\n";
        db.execSQL(queryAdminAccount);
        db.execSQL(queryLocation);
        db.execSQL(queryCustomerAccount);
        db.execSQL(querySellerAccount);
        db.execSQL(queryFeedBack);
        db.execSQL(queryFood);
        db.execSQL(queryFoodType);
        db.execSQL(queryFoodImage);
        db.execSQL(querySellerType);
        db.execSQL(queryBill);
        db.execSQL(queryBillDetail);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addDefaultLocation() {
        Location location = new Location(3.14f, 2.3f, 1);
        Location location1 = new Location(3.1234f, 2.31f, 1);
        Location location2 = new Location(3.214f, 1.3f, 1);
        addLocation(location);
        addLocation(location1);
        addLocation(location2);
    }

    public void addLocation(Location location) {
        Log.i(TAG, "MyDatabaseHelper.addLocation ... " + location.getLocation_ID());
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstDBName.NAME_TABLE_LOCATION_LONGITUDE, location.getLongitude());
        values.put(ConstDBName.NAME_TABLE_LOCATION_LATITUDE, location.getLatitude());
        values.put(ConstDBName.NAME_TABLE_LOCATION_STATUS, location.getLocation_status());
        database.insert("Location", null, values);
        database.close();
    }

    public Location getLocation(int id) {
        Log.i(TAG, "MyDatabaseHelper.getNote ... " + id);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ConstDBName.NAME_TABLE_LOCATION, new String[]{
                        ConstDBName.NAME_TABLE_LOCATION_LONGITUDE
                        , ConstDBName.NAME_TABLE_LOCATION_LATITUDE
                        , ConstDBName.NAME_TABLE_LOCATION_STATUS}
                , ConstDBName.NAME_TABLE_LOCATION_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Location location = new Location((Float.parseFloat(cursor.getString(0))),
                (Float.parseFloat(cursor.getString(1))), Integer.parseInt(cursor.getString(2)));
        // return note
        return location;
    }

    public void update(Location location) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstDBName.NAME_TABLE_LOCATION_LONGITUDE, location.getLongitude());
        values.put(ConstDBName.NAME_TABLE_LOCATION_LATITUDE, location.getLatitude());
        values.put(ConstDBName.NAME_TABLE_LOCATION_STATUS, location.getLocation_status());

        database.update(ConstDBName.NAME_TABLE_LOCATION,
                values,
                ConstDBName.NAME_TABLE_LOCATION_ID + " = ?",
                new String[]{String.valueOf(location.getLocation_ID())});
    }

    public void delete(Location location) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstDBName.NAME_TABLE_LOCATION_LONGITUDE, location.getLongitude());
        values.put(ConstDBName.NAME_TABLE_LOCATION_LATITUDE, location.getLatitude());
        values.put(ConstDBName.NAME_TABLE_LOCATION_STATUS, 0);

        database.update(ConstDBName.NAME_TABLE_LOCATION,
                values,
                ConstDBName.NAME_TABLE_LOCATION_ID + " = ?",
                new String[]{String.valueOf(location.getLocation_ID())});
    }

    public void addDefaultUserAccount() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        SellerType.UserAccount userAccount = new SellerType.UserAccount("123456789", "Khanh Nguyen", 1, date, 1, "0386686177", "Tra Vinh", 1, "ABC", "khanhndq@gmail.com");
        addUserAccount(userAccount);
    }

    public void addUserAccount(SellerType.UserAccount userAccount) {
        Log.i(TAG, "MyDatabaseHelper.addUserAccount ... " + userAccount.getUserID());
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_PHONE_NUMBER, userAccount.getPhoneNumber());
        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_PASSWORD, userAccount.getPassWord());
        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_NAME_OF_USER, userAccount.getNameUser());
        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_LOCATION_ID, userAccount.getLocationID());
        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_DATE_OF_BIRTH, userAccount.getDateOfBirth());
        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_GENDER, userAccount.getGender());
        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_ADDRESS, userAccount.getAddress());
        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_HASH, userAccount.getHash());
        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_GMAIL, userAccount.getGmail());
        values.put(ConstDBName.NAME_TABLE_USER_ACCOUNT_STATUS, userAccount.getUserStatus());
        database.insert(ConstDBName.NAME_TABLE_USER_ACCOUNT, null, values);
        database.close();
    }

    public SellerType.UserAccount getUserAccount(int id) {
        Log.i(TAG, "MyDatabaseHelper.getNote ... " + id);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ConstDBName.NAME_TABLE_USER_ACCOUNT, new String[]{
                        ConstDBName.NAME_TABLE_USER_ACCOUNT_PHONE_NUMBER
                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_PASSWORD
                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_NAME_OF_USER
                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_LOCATION_ID
                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_DATE_OF_BIRTH
                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_GENDER
                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_ADDRESS
                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_HASH
                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_GMAIL
                        , ConstDBName.NAME_TABLE_USER_ACCOUNT_STATUS}
                , ConstDBName.NAME_TABLE_USER_ACCOUNT_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        SellerType.UserAccount account = new SellerType.UserAccount(cursor.getString(1)
                , cursor.getString(2)
                , Integer.parseInt(cursor.getString(3))
                , cursor.getString(4)
                , Integer.parseInt(cursor.getString(5))
                , cursor.getString(0)
                , cursor.getString(6)
                , Integer.parseInt(cursor.getString(9))
                , cursor.getString(7)
                , cursor.getString(8));
        // return note
        return account;
    }

    public void dropTable() {

    }
}
