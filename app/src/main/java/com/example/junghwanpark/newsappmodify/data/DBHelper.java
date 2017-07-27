package com.example.junghwanpark.newsappmodify.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by JungHwanPark on 7/26/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    //This sqliteopenhelper manage database creation and the version.
    //It also create the name of the database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "articles.db";
    private static final String TAG = "dbhelper";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //The oncreate is called when the database is created and the is where all the population begins
    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryString = "CREATE TABLE " + Contract.TABLE_ARTICLES.TABLE_NAME + " ("+
                Contract.TABLE_ARTICLES._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Contract.TABLE_ARTICLES.COLUMN_NAME_TITLE + " TEXT NOT NULL, " +
                Contract.TABLE_ARTICLES.COLUMN_NAME_PUBLISHED_DATE + " DATE, " +
                Contract.TABLE_ARTICLES.COLUMN_NAME_ABSTRACT + " TEXT, " +
                Contract.TABLE_ARTICLES.COLUMN_NAME_THUMBURL + " TEXT, " +
                Contract.TABLE_ARTICLES.COLUMN_NAME_URL + " TEXT" +
                "); ";

        Log.d(TAG, "Create table SQL: " + queryString);
        db.execSQL(queryString);
    }

    //Like the name of the method, it is called when the database needs to be upgraded
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("drop table " + Contract.TABLE_ARTICLES.TABLE_NAME + " if exists;");
    }
}
