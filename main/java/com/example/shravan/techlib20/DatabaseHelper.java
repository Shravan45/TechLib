package com.example.shravan.techlib20;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Users.db";
    public static final String TABLE_NAME = "usersInfo";
    public static final String COL_ID = "ID";
    public static final String COL_FNAME = "FNAME";
    public static final String COL_LNAME = "LNAME";
    public static final String COL_GENRE = "GENRE";
    public static final String COL_USERNAME = "USERNAME";
    public static final String COL_PASSWORD = "PASSWORD";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,FNAME TEXT,LNAME TEXT,GENRE TEXT,USERNAME TEXT,PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String fname,String lname,String genre,String username,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_FNAME,fname);
        contentValues.put(COL_LNAME,lname);
        contentValues.put(COL_GENRE,genre);
        contentValues.put(COL_USERNAME,username);
        contentValues.put(COL_PASSWORD,password);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public String searchPass(String passed_username,String passed_password){

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT USERNAME,PASSWORD FROM" + TABLE_NAME, null);

        String u,p;
        p="Valid Password not found";
        if(cursor.moveToFirst())
        {
            do{
                u = cursor.getString(0);    //username will be at index 0 each time
                if(u.equals(passed_username))
                {
                    p = cursor.getString(1);    //password will be at index 1 each time
                    break;
                }
            }while(cursor.moveToNext());
        }

        return p;

        /*Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +COL_USERNAME + "=? AND " + COL_PASSWORD + "=?", new String[]{passed_username,passed_password});
        if (cursor != null) {
            if (cursor.getCount() > 0)
            {
                //Toast.makeText(DatabaseHelper.this, "Login Success" , Toast.LENGTH_SHORT);
                return "s";
            }
            else
            {
                //Toast.makeText(DatabaseHelper.this, "Login error", Toast.LENGTH_SHORT).show();
                return "f";
            }

        }
        else
            return "f";*/
    }
}
