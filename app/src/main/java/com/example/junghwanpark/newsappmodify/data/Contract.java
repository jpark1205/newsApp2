package com.example.junghwanpark.newsappmodify.data;

import android.provider.BaseColumns;

/**
 * Created by JungHwanPark on 7/26/2017.
 */

public class Contract {

    //This contract class will create the table for the database using the strings
    public static class TABLE_ARTICLES implements BaseColumns {
        public static final String TABLE_NAME = "articles";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_PUBLISHED_DATE = "published_date";
        public static final String COLUMN_NAME_ABSTRACT = "abstract";
        public static final String COLUMN_NAME_THUMBURL = "thumb_url";
        public static final String COLUMN_NAME_URL = "url";
    }
}
