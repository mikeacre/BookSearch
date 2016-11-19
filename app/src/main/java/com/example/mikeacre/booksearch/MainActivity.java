package com.example.mikeacre.booksearch;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView emptyView = (TextView) findViewById(R.id.empty);

        if (checkInternet() == true)
            getLoaderManager().initLoader(1, null, this);
        else
            emptyView.setText("No internet connection");

    }

    public boolean checkInternet() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public void displayBooks(List<Book> books) {
        Log.e("Display", "Lets Display");
        Log.e("Books", "There are: "+books.size());
        ArrayList<Book> finBooks = (ArrayList<Book>) books;
        Log.e("Books", "There are in fin books: "+finBooks.size());


        ListView bookListView = (ListView) findViewById(R.id.displaybooks);

        bookListView.setEmptyView(findViewById(R.id.empty));

        // Create a new {@link ArrayAdapter} of earthquakes
        BookAdapter adapter = new BookAdapter(this, finBooks);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        bookListView.setAdapter(adapter);
    }

    @Override
    public Loader<List<Book>> onCreateLoader(int id, Bundle args) {
        return new BookLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> data) {
        Log.e("Loader", "Loader complete, lets diplay");
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        progressBar.setVisibility(View.GONE);
        displayBooks(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {
        Log.e("Loader", "Loader reset");
    }
}
