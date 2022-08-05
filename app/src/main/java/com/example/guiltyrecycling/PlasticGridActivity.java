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

        Bitmap plastic1Im, plastic2Im, plastic3Im, plastic4Im, plastic5Im, plastic6Im, plastic7Im, plastic8Im;
        //plastic1Im = BitmapFactory.decodeResource(getResources(), R.drawable.plastic1);
        //plastic2Im = BitmapFactory.decodeResource(getResources(), R.drawable.plastic2);
        //plastic3Im = BitmapFactory.decodeResource(getResources(), R.drawable.plastic3);
        //plastic4Im = BitmapFactory.decodeResource(getResources(), R.drawable.plastic4);
        //plastic5Im = BitmapFactory.decodeResource(getResources(), R.drawable.plastic5);
        //plastic6Im = BitmapFactory.decodeResource(getResources(), R.drawable.plastic6);
        //plastic7Im = BitmapFactory.decodeResource(getResources(), R.drawable.plastic7);
        //plastic8Im = BitmapFactory.decodeResource(getResources(), R.drawable.plastic8);

        //GridItem plastic1Item = new GridItem();
        //plastic1Item.image = plastic1Im;
        //grid5.add(plastic1Item);

        //GridItem plastic2Item = new GridItem();
        //plastic2Item.image = plastic2Im;
        //grid5.add(plastic2Item);

        //GridItem plastic3Item = new GridItem();
        //plastic3Item.image = plastic3Im;
        //grid5.add(plastic3Item);

        //GridItem plastic4Item = new GridItem();
        //plastic4Item.image = plastic4Im;
        //grid5.add(plastic4Item);

        //GridItem plastic5Item = new GridItem();
        //plastic5Item.image = plastic5Im;
        //grid5.add(plastic5Item);

        //GridItem plastic6Item = new GridItem();
        //plastic6Item.image = plastic6Im;
        //grid5.add(plastic6Item);

        //GridItem plastic7Item = new GridItem();
        //plastic7Item.image = plastic7Im;
        //grid5.add(plastic7Item);

        //GridItem plastic8Item = new GridItem();
        //plastic8Item.image = plastic8Im;
        //grid5.add(plastic8Item);

        GridItemAdapter gridItemAdapter = new GridItemAdapter(this, R.layout.grid_item, grid5);
        gridView5.setAdapter(gridItemAdapter);

    }
}
