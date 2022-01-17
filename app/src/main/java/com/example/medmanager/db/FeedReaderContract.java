package com.example.medmanager.db;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class MedicineEntry implements BaseColumns {
        public static final String TABLE_NAME = "medicines";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_LEAFLET = "leaflet";

    }

    protected static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MedicineEntry.TABLE_NAME + " (" +
                    MedicineEntry._ID + " INTEGER PRIMARY KEY," +
                    MedicineEntry.COLUMN_NAME + " TEXT," +
                    MedicineEntry.COLUMN_PRICE + " TEXT," +
                    MedicineEntry.COLUMN_LEAFLET + " TEXT)";

    protected static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MedicineEntry.TABLE_NAME;


}
