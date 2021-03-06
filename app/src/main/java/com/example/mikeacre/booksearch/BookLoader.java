package com.example.mikeacre.booksearch;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.AsyncTask;
import android.util.EventLogTags;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikeacre on 11/19/2016.
 */

public class BookLoader extends AsyncTaskLoader<List<Book>> {

    String earthquakeUrl = null;

    public BookLoader(Context context){
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<Book> loadInBackground() {
        ArrayList<Book> books = QueryUtils.fetchBookData("test");
        Log.e("Loader", "return objects");
        return books;
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
        Log.e("Loader", "we are loaded");
    }
}
