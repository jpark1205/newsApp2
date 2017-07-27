package com.example.junghwanpark.newsappmodify;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.junghwanpark.newsappmodify.data.DBHelper;
import com.example.junghwanpark.newsappmodify.data.DatabaseUtils;
import com.example.junghwanpark.newsappmodify.data.ItemClass;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by JungHwanPark on 7/26/2017.
 */

public class RefreshTasks {

    public static final String ACTION_REFRESH = "refresh";


    public static void refreshArticles(Context context) {
        ArrayList<ItemClass> result = null;
        URL url = NetworkUtils.makeURL();

        SQLiteDatabase db = new DBHelper(context).getWritableDatabase();

        try {
            DatabaseUtils.deleteAll(db);
            String json = NetworkUtils.getResponseFromHttpUrl(url);
            result = NetworkUtils.parseJSON(json);
            DatabaseUtils.bulkInsert(db, result);

        } catch (IOException e) {
            e.printStackTrace();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        db.close();
    }
}
