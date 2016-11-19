package com.example.mikeacre.booksearch;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mikeacre on 11/19/2016.
 */

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, ArrayList<Book> books){
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.book_item, parent, false);
        }

        Book currBook = getItem(position);

        ImageView thumbnail = (ImageView) listItemView.findViewById(R.id.thumbnail);
        TextView title = (TextView) listItemView.findViewById(R.id.title);
        TextView author = (TextView) listItemView.findViewById(R.id.author);
        TextView summary = (TextView) listItemView.findViewById(R.id.summary);
        ProgressBar progressBar = (ProgressBar) listItemView.findViewById(R.id.progress);

        title.setText(currBook.getTitle());
        author.setText(currBook.getAuthor());
        summary.setText(currBook.getSummary());
        Log.e("adapter", "printing "+currBook.getTitle());
        Log.e("adapter", "Author "+currBook.getAuthor());


        return listItemView;
    }

    /*
    Create thumbnail downloader
     */
}
