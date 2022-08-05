package com.example.guiltyrecycling;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GlassGridActivity extends AppCompatActivity {
    GridView gridView3;
    ArrayList<GridItem> grid3 = new ArrayList<GridItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glass_grid);

        gridView3 = (GridView) findViewById(R.id.GlassGrid);

//        Bitmap glass1Im, glass2Im, glass3Im, glass4Im, glass5Im, glass6Im, glass7Im, glass8Im;
//        glass1Im = BitmapFactory.decodeResource(getResources(), R.drawable.glass1);
//        glass2Im = BitmapFactory.decodeResource(getResources(), R.drawable.glass2);
//        glass3Im = BitmapFactory.decodeResource(getResources(), R.drawable.glass3);
//        glass4Im = BitmapFactory.decodeResource(getResources(), R.drawable.glass4);
//        glass5Im = BitmapFactory.decodeResource(getResources(), R.drawable.glass5);
//        glass6Im = BitmapFactory.decodeResource(getResources(), R.drawable.glass6);
//        glass7Im = BitmapFactory.decodeResource(getResources(), R.drawable.glass7);
//        glass8Im = BitmapFactory.decodeResource(getResources(), R.drawable.glass8);
//
//        GridItem glass1Item = new GridItem();
//        glass1Item.image = glass1Im;
//        grid3.add(glass1Item);
//
//        GridItem glass2Item = new GridItem();
//        glass2Item.image = glass2Im;
//        grid3.add(glass2Item);
//
//        GridItem glass3Item = new GridItem();
//        glass3Item.image = glass3Im;
//        grid3.add(glass3Item);
//
//        GridItem glass4Item = new GridItem();
//        glass4Item.image = glass4Im;
//        grid3.add(glass4Item);
//
//        GridItem glass5Item = new GridItem();
//        glass5Item.image = glass5Im;
//        grid3.add(glass5Item);
//
//        GridItem glass6Item = new GridItem();
//        glass6Item.image = glass6Im;
//        grid3.add(glass6Item);
//
//        GridItem glass7Item = new GridItem();
//        glass7Item.image = glass7Im;
//        grid3.add(glass7Item);
//
//        GridItem glass8Item = new GridItem();
//        glass8Item.image = glass8Im;
//        grid3.add(glass8Item);

        GridItemAdapter gridItemAdapter = new GridItemAdapter(this, R.layout.grid_item, grid3);
        gridView3.setAdapter(gridItemAdapter);

    }
}
