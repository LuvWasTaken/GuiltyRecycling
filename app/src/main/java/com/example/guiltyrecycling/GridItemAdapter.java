package com.example.guiltyrecycling;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridItemAdapter extends ArrayAdapter {

    private LayoutInflater mInflator;

    public GridItemAdapter(Context context, int rid, ArrayList<GridItem> grid) {
        super(context, rid, grid);
        mInflator = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Retrieve Data
        GridItem item = (GridItem)getItem(position);

        // Use layout file to generate View
        View view = mInflator.inflate(R.layout.grid_item, null);

        // Set image
        ImageView image;
        image = (ImageView) view.findViewById(R.id.image);
        image.setImageBitmap(item.image);

        // Set user name
        TextView title;
        title = (TextView) view.findViewById(R.id.title);
        title.setText(item.title);

        return view;
    }
}
