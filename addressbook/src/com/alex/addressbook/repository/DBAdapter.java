package com.alex.addressbook.repository;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;

/**
 * Created by alex on 2014/08/19.
 */
public class DBAdapter extends SQLiteOpenHelper {

    public static final String TABLE_CONTACTS= "contacts";

    public static final String COLUMN_FIRST_NAME = "firstName";
    public static final String COLUMN_LAST_NAME = "lastName";
    public static final String COLUMN_EMAIL_ADDRESS = "emailAddress";
    public static final String COLUMN_CELL_PHONE_NUMBER = "cellPhoneNumber";
    public static final String COLUMN_HOME_ADDRESS = "homeAddress";

    public static final String DATABASE_NAME = "alex.db";
    public static final int DATABASE_VERSION = 1;

    private static final String CREATE_CONTACT_TABLE = "create table IF NOT EXISTS "
            + TABLE_CONTACTS + " ( "
            + COLUMN_FIRST_NAME  +" "+"text not null ,"
            + COLUMN_LAST_NAME + " "+"text not null ,"
            + COLUMN_EMAIL_ADDRESS + " "+"text not null ,"
            + COLUMN_CELL_PHONE_NUMBER + " "+"text not null ,"
            + COLUMN_HOME_ADDRESS + " "+"text not null); ";

    public DBAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACT_TABLE);
        Log.d("asdasfaf", "oncreate");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBAdapter.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + " which will destroy old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        onCreate(db);
    }
}
