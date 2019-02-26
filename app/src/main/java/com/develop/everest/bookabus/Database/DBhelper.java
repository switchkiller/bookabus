package com.develop.everest.bookabus.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.Inet4Address;

public class DBhelper extends SQLiteOpenHelper {
    public static final String DB_Name = "BUS.db";
    public static final String TABLE_Name = "Search_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Dest_To";
    public static final String COL_3 = "Dest_From";
    public static final String COL_4 = "NAME";
    public static final String COL_5 = "TIME";
    public static final String COL_6 = "PRICE";

    //Whenever this constructor is called our DB will be created
    public DBhelper(Context context) {
        super(context, DB_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_Name +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Dest_To TEXT NOT NULL," +
                "Dest_From TEXT NOT NULL, NAME TEXT NOT NULL, TIME TEXT NOT NULL, " +
                "PRICE INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table IF  EXISTS " + TABLE_Name);
        onCreate(db);
    }

    public boolean insertData(String Dest, String Src, String name, String Time, String price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, Dest);
        contentValues.put(COL_3, Src);
        contentValues.put(COL_4, name);
        contentValues.put(COL_5, Time);
        contentValues.put(COL_6, price);
        long res = db.insert(TABLE_Name, null, contentValues);
        if (res == -1)
            return false;
        else
            return true;


    }
}
