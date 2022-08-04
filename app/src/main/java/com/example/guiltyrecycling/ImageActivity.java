package com.example.guiltyrecycling;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity  implements BottomNavigationView.OnItemSelectedListener {
    GridView gridView1;
    ArrayList<GridItem> grid1 = new ArrayList<GridItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);

        gridView1 = (GridView) findViewById(R.id.ImageGrid);

        Bitmap glassIm, plasticIm, metalIm, paperIm, organicIm, ewasteIm;
        glassIm = BitmapFactory.decodeResource(getResources(), R.drawable.glass);
        plasticIm = BitmapFactory.decodeResource(getResources(), R.drawable.plastic);
        metalIm = BitmapFactory.decodeResource(getResources(), R.drawable.metal);
        paperIm = BitmapFactory.decodeResource(getResources(), R.drawable.paper);
        organicIm = BitmapFactory.decodeResource(getResources(), R.drawable.organic);
        ewasteIm = BitmapFactory.decodeResource(getResources(), R.drawable.ewaste);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);

        GridItem glassItem = new GridItem();
        glassItem.image = glassIm;
        glassItem.title = "GLASS";
        grid1.add(glassItem);

        GridItem plasticItem = new GridItem();
        plasticItem.image = plasticIm;
        plasticItem.title = "PLASTIC";
        grid1.add(plasticItem);

        GridItem metalItem = new GridItem();
        metalItem.image = metalIm;
        metalItem.title = "METAL";
        grid1.add(metalItem);

        GridItem paperItem = new GridItem();
        paperItem.image = paperIm;
        paperItem.title = "PAPER";
        grid1.add(paperItem);

        GridItem organicItem = new GridItem();
        organicItem.image = organicIm;
        organicItem.title = "ORGANIC";
        grid1.add(organicItem);

        GridItem ewasteItem = new GridItem();
        ewasteItem.image = ewasteIm;
        ewasteItem.title = "E-WASTE";
        grid1.add(ewasteItem);

        GridItemAdapter gridItemAdapter = new GridItemAdapter(this, R.layout.grid_item, grid1);
        gridView1.setAdapter(gridItemAdapter);

    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.write:
                Log.v("myApp", "write nav button is clicked");
                intent = new Intent();
                intent.setClass(ImageActivity.this, WriteActivity.class);
                startActivity(intent);
                return true;

            case R.id.speak:
                Log.v("myApp", "Speak nav button is clicked");
                intent = new Intent();
                intent.setClass(ImageActivity.this, VoiceActivity.class);
                startActivity(intent);
                return true;

            case R.id.image:
                Log.v("myApp", "Visualize nav button is clicked");
                intent = new Intent();
                intent.setClass(ImageActivity.this, ImageActivity.class);
                startActivity(intent);
                return true;
        }
        return false;
    }
}