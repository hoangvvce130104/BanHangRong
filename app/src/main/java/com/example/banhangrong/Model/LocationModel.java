package com.example.banhangrong.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.banhangrong.Class.Location;
import com.example.banhangrong.ConstanDB.ConstDBName;

import static android.content.ContentValues.TAG;

public class LocationModel extends SQLiteOpenHelper {
    public LocationModel(Context context) {
        super(context, ConstDBName.NAME_DB, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryLocation = "CREATE TABLE "+ ConstDBName.NAME_TABLE_LOCATION
                + "("+ ConstDBName.NAME_TABLE_LOCATION_ID+" Integer PRIMARY KEY AUTOINCREMENT , "
                + ConstDBName.NAME_TABLE_LOCATION_LONGITUDE
                + " FLOAT, "+ ConstDBName.NAME_TABLE_LOCATION_LATITUDE+" FLOAT, "
                + ConstDBName.NAME_TABLE_LOCATION_STATUS+" integer);";
        db.execSQL(queryLocation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ ConstDBName.NAME_TABLE_LOCATION);
        onCreate(db);
    }

    /**
     *  Location Table
     *
     */

    public void addDefaultLocation(){
        Location location = new Location(3.14f,2.3f, 1);
        Location location1 = new Location(3.1234f,2.31f, 1);
        Location location2 = new Location(3.214f,1.3f, 1);
        addLocation(location);
        addLocation(location1);
        addLocation(location2);
    }

    public void addLocation(Location location){
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

        Cursor cursor = db.query(ConstDBName.NAME_TABLE_LOCATION, new String[] {
                        ConstDBName.NAME_TABLE_LOCATION_LONGITUDE
                        , ConstDBName.NAME_TABLE_LOCATION_LATITUDE
                        , ConstDBName.NAME_TABLE_LOCATION_STATUS }
                        , ConstDBName.NAME_TABLE_LOCATION_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Location location = new Location((Float.parseFloat(cursor.getString(0))),
                (Float.parseFloat(cursor.getString(1))), Integer.parseInt(cursor.getString(2)));
        // return note
        return location;
    }

    public void update(Location location){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstDBName.NAME_TABLE_LOCATION_LONGITUDE,location.getLongitude());
        values.put(ConstDBName.NAME_TABLE_LOCATION_LATITUDE, location.getLatitude());
        values.put(ConstDBName.NAME_TABLE_LOCATION_STATUS, location.getLocation_status());

        database.update(ConstDBName.NAME_TABLE_LOCATION,
                values,
                ConstDBName.NAME_TABLE_LOCATION_ID+" = ?",
                new String[] { String.valueOf(location.getLocation_ID())});
    }
    public void delete(Location location){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstDBName.NAME_TABLE_LOCATION_LONGITUDE,location.getLongitude());
        values.put(ConstDBName.NAME_TABLE_LOCATION_LATITUDE, location.getLatitude());
        values.put(ConstDBName.NAME_TABLE_LOCATION_STATUS, 0);

        database.update(ConstDBName.NAME_TABLE_LOCATION,
                values,
                ConstDBName.NAME_TABLE_LOCATION_ID+" = ?",
                new String[] { String.valueOf(location.getLocation_ID())});
    }
}
