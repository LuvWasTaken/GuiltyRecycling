package com.example.guiltyrecycling;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PlasticGridActivity extends AppCompatActivity {
    GridView gridView5;
    ArrayList<GridItem> grid5 = new ArrayList<GridItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plastic_grid);

        gridView5 = (GridView) findViewById(R.id.PlasticGrid);

        Bitmap paper1Im, paper2Im, paper3Im, paper4Im, paper5Im, paper6Im, paper7Im, paper8Im;
        paper1Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper1);
        paper2Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper2);
        paper3Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper3);
        paper4Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper4);
        paper5Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper5);
        paper6Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper6);
        paper7Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper7);
        paper8Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper8);

        GridItem paper1Item = new GridItem();
        paper1Item.image = paper1Im;
        grid5.add(paper1Item);


        GridItemAdapter gridItemAdapter = new GridItemAdapter(this, R.layout.grid_item, grid5);
        gridView5.setAdapter(gridItemAdapter);

    }
}
