package com.example.medmanager.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import com.example.medmanager.models.Medicine;


public class SQLiteDB extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "med_manager.db";


    public SQLiteDB(@Nullable Context context, @Nullable SQLiteDatabase.CursorFactory factory) {
        super(context,
                DB_NAME,
                null,
                DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FeedReaderContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    /*
    public void addMedicine(Medicine medicine){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.MedicineEntry.COLUMN_NAME, medicine.getName());
        values.put(FeedReaderContract.MedicineEntry.COLUMN_PRICE, medicine.getPrice());
        values.put(FeedReaderContract.MedicineEntry.COLUMN_LEAFLET, medicine.getLeaflet());
        long newRowId = db.insert(FeedReaderContract.MedicineEntry.TABLE_NAME, null, values);
    }

    public void readMedicine(){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] projection = {
                FeedReaderContract.MedicineEntry._ID,
                FeedReaderContract.MedicineEntry.COLUMN_NAME,
                FeedReaderContract.MedicineEntry.COLUMN_PRICE,
                FeedReaderContract.MedicineEntry.COLUMN_LEAFLET
        };
    }
*/

}



