package com.example.shp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "healthcare.db";

    public static final String TABLE_NAME = "account";

    public static final String COL_1 = "id";

    public static final String COL_2 = "name";



    public static String COL_3 = "email";
    public static String COL_4 = "pass";

    public DatabaseHelper( Context context) {

        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db  = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME +"(ID INTEGER PRIMARY KEY, EMAIL EMAIL, NAME TEXT,PASS PASSWORD)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP  TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
