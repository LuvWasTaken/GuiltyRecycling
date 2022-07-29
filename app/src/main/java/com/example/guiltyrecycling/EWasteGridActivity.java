package com.example.guiltyrecycling;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EWasteGridActivity extends AppCompatActivity {
    GridView gridView6;
    ArrayList<GridItem> grid6 = new ArrayList<GridItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ewaste_grid);

        gridView6 = (GridView) findViewById(R.id.EWasteGrid);

        Bitmap EWaste1Im, EWaste2Im, EWaste3Im, EWaste4Im, EWaste5Im, EWaste6Im, EWaste7Im, EWaste8Im;
        EWaste1Im = BitmapFactory.decodeResource(getResources(), R.drawable.EWaste1);
        EWaste2Im = BitmapFactory.decodeResource(getResources(), R.drawable.EWaste2);
        EWaste3Im = BitmapFactory.decodeResource(getResources(), R.drawable.EWaste3);
        EWaste4Im = BitmapFactory.decodeResource(getResources(), R.drawable.EWaste4);
        EWaste5Im = BitmapFactory.decodeResource(getResources(), R.drawable.EWaste5);
        EWaste6Im = BitmapFactory.decodeResource(getResources(), R.drawable.EWaste6);
        EWaste7Im = BitmapFactory.decodeResource(getResources(), R.drawable.EWaste7);
        EWaste8Im = BitmapFactory.decodeResource(getResources(), R.drawable.EWaste8);

        GridItem EWaste1Item = new GridItem();
        EWaste1Item.image = EWaste1Im;
        grid6.add(EWaste1Item);

        GridItem EWaste2Item = new GridItem();
        EWaste2Item.image = EWaste2Im;
        grid6.add(EWaste2Item);

        GridItem EWaste3Item = new GridItem();
        EWaste3Item.image = EWaste3Im;
        grid6.add(EWaste3Item);

        GridItem EWaste4Item = new GridItem();
        EWaste4Item.image = EWaste4Im;
        grid6.add(EWaste4Item);

        GridItem EWaste5Item = new GridItem();
        EWaste5Item.image = EWaste5Im;
        grid6.add(EWaste5Item);

        GridItem EWaste6Item = new GridItem();
        EWaste6Item.image = EWaste6Im;
        grid6.add(EWaste6Item);

        GridItem EWaste7Item = new GridItem();
        EWaste7Item.image = EWaste7Im;
        grid6.add(EWaste7Item);

        GridItem EWaste8Item = new GridItem();
        EWaste8Item.image = EWaste8Im;
        grid6.add(EWaste8Item);

        GridItemAdapter gridItemAdapter = new GridItemAdapter(this, R.layout.grid_item, grid6);
        gridView6.setAdapter(gridItemAdapter);

    }
}
