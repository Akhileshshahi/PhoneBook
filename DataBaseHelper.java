package com.example.akhilphotodot.sqlite_example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;


public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="contact_manager.db";
    private static final String tablename="Contacts";
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+tablename+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,NUMBER TEXT,Email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tablename);
        onCreate(db);
    }

    public boolean insertData(String name,String Number,String mailid)
    {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("NAME", name);
            cv.put("NUMBER", Number);
            cv.put("Email", mailid);
            long bool = db.insert(tablename, null, cv);
            if (bool == -1) {
                return false;
            } else {
                return true;
            }

    }
    public Cursor getData(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        final String query="SELECT * FROM "+tablename+" WHERE NAME='"+name+"'";
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }
    public boolean upDate(String name,String Number,String mailid)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NAME", name);
        cv.put("NUMBER", Number);
        cv.put("Email", mailid);
        int bool = db.update(tablename, cv,"NAME='"+name+"'",null);
        if (bool == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public void delDate(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        final String query2="DELETE FROM "+tablename+" WHERE NAME='"+name+"'";
        db.execSQL(query2);
    }
}

