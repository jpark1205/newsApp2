package com.example.junghwanpark.newsappmodify.data;

/**
 * Created by JungHwanPark on 7/26/2017.
 */

public class ItemClass{

    private String title;
    private String published_date;
    private String abstr;
    private String thumbUrl;
    private String Url;

    public ItemClass(String title, String published_date, String abstr, String thumbUrl, String url) {
        this.title = title;
        this.published_date = published_date;
        this.abstr = abstr;
        this.thumbUrl = thumbUrl;
        Url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getAbstr() {
        return abstr;
    }

    public void setAbstr(String abstr) {
        this.abstr = abstr;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}

