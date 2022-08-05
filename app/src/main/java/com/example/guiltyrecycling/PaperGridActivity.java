package com.example.guiltyrecycling;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PaperGridActivity extends AppCompatActivity {
    GridView gridView2;
    ArrayList<GridItem> grid2 = new ArrayList<GridItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paper_grid);

        gridView2 = (GridView) findViewById(R.id.PaperGrid);

//        Bitmap paper1Im, paper2Im, paper3Im, paper4Im, paper5Im, paper6Im, paper7Im, paper8Im;
//        paper1Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper1);
//        paper2Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper2);
//        paper3Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper3);
//        paper4Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper4);
//        paper5Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper5);
//        paper6Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper6);
//        paper7Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper7);
//        paper8Im = BitmapFactory.decodeResource(getResources(), R.drawable.paper8);
//
//        GridItem paper1Item = new GridItem();
//        paper1Item.image = paper1Im;
//        grid2.add(paper1Item);
//
//        GridItem paper2Item = new GridItem();
//        paper2Item.image = paper2Im;
//        grid2.add(paper2Item);
//
//        GridItem paper3Item = new GridItem();
//        paper3Item.image = paper3Im;
//        grid2.add(paper3Item);
//
//        GridItem paper4Item = new GridItem();
//        paper4Item.image = paper4Im;
//        grid2.add(paper4Item);
//
//        GridItem paper5Item = new GridItem();
//        paper5Item.image = paper5Im;
//        grid2.add(paper5Item);
//
//        GridItem paper6Item = new GridItem();
//        paper6Item.image = paper6Im;
//        grid2.add(paper6Item);
//
//        GridItem paper7Item = new GridItem();
//        paper7Item.image = paper7Im;
//        grid2.add(paper7Item);
//
//        GridItem paper8Item = new GridItem();
//        paper8Item.image = paper8Im;
//        grid2.add(paper8Item);

        GridItemAdapter gridItemAdapter = new GridItemAdapter(this, R.layout.grid_item, grid2);
        gridView2.setAdapter(gridItemAdapter);

    }
}
