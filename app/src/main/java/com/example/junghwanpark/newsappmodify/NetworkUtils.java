package com.example.junghwanpark.newsappmodify;

import android.net.Uri;
import android.util.Log;

import com.example.junghwanpark.newsappmodify.data.ItemClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by JungHwanPark on 7/26/2017.
 */

public class NetworkUtils {

    public static final String TAG = "NetworkUtils";
    public static final String BASE_URL =
            "https://newsapi.org/v1/articles";

    public static final String PARAM_QUERY = "source";
    public static final String PARAM_SORT = "sortBy";
    public static final String PARAM_API = "apiKey";


    public static URL makeURL() {
        Uri uri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERY, "the-next-web")
                .appendQueryParameter(PARAM_SORT, "latest")
                .appendQueryParameter(PARAM_API, "31c866657ce04490867a8805b898a516")
                .build();

        URL url = null;
        try {
            String urlString = uri.toString();
            Log.d(TAG, "Url: " + urlString);
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner input = new Scanner(in);

            input.useDelimiter("\\A");
            String result = (input.hasNext()) ? input.next() : null;
            return result;

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return null;
    }

    public static ArrayList<ItemClass> parseJSON(String json) throws JSONException {

        ArrayList<ItemClass> result = new ArrayList<>();
        JSONObject main = new JSONObject(json);
        JSONArray it = main.getJSONArray("articles");

        for(int i = 0; i < it.length(); i++){

            JSONObject j = it.getJSONObject(i);
            String titleForArticle = j.getString("title");
            String published_Date = j.getString("publishedAt");
            String abstr = j.getString("description");
            String url = j.getString("url");
            String imageUrl = j.getString("urlToImage");

            result.add(new ItemClass(titleForArticle, published_Date, abstr, imageUrl, url));

        }
        Log.d(TAG, "final articles size: " + result.size());
        return result;
    }
}

