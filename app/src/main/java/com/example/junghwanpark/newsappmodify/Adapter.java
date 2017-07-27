package com.example.junghwanpark.newsappmodify;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.junghwanpark.newsappmodify.data.Contract;

import com.squareup.picasso.Picasso;

/**
 * Created by JungHwanPark on 7/26/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ItemHolder>{

    private Cursor cursor;
    private ItemClickListener listener;
    private Context context;
    public static final String TAG = "myadapter";


    public Adapter(Cursor cursor, ItemClickListener listener){
        this.cursor = cursor;
        this.listener = listener;
    }

    public interface ItemClickListener {
        void onItemClick(Cursor cursor, int clickedItemIndex);
    }



    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.item, parent, shouldAttachToParentImmediately);
        ItemHolder holder = new ItemHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        TextView abstr;
        TextView publishDate;
        ImageView img;

        ItemHolder(View view){
            super(view);
            title = (TextView)view.findViewById(R.id.title);
            abstr = (TextView)view.findViewById(R.id.abstr);
            publishDate = (TextView)view.findViewById(R.id.date);
            img = (ImageView)view.findViewById(R.id.img);
            view.setOnClickListener(this);
        }

        //This picasso allow the image to be loaded to the application
        //It gets the url of the image and put it into the picasso and load it
        public void bind(int pos){
            cursor.moveToPosition(pos);
            title.setText(cursor.getString(cursor.getColumnIndex(Contract.TABLE_ARTICLES.COLUMN_NAME_TITLE)));
            abstr.setText(cursor.getString(cursor.getColumnIndex(Contract.TABLE_ARTICLES.COLUMN_NAME_ABSTRACT)));
            publishDate.setText(cursor.getString(cursor.getColumnIndex(Contract.TABLE_ARTICLES.COLUMN_NAME_PUBLISHED_DATE)));
            String url = cursor.getString(cursor.getColumnIndex(Contract.TABLE_ARTICLES.COLUMN_NAME_THUMBURL));
            Log.d(TAG, url);
            if(url != null){
                Picasso.with(context)
                        .load(url)
                        .into(img);
            }
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            listener.onItemClick(cursor, pos);
        }
    }

}





