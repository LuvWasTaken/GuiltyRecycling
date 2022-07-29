//package com.example.guiltyrecycling;
//
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.widget.GridView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//
//public class MetalGridActivity extends AppCompatActivity {
//    GridView gridView4;
//    ArrayList<GridItem> grid4 = new ArrayList<GridItem>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.metal_grid);
//
//        gridView4 = (GridView) findViewById(R.id.MetalGrid);
//
//        Bitmap metal1Im, metal2Im, metal3Im, metal4Im, metal5Im, metal6Im, metal7Im, metal8Im;
//        metal1Im = BitmapFactory.decodeResource(getResources(), R.drawable.metal1);
//        metal2Im = BitmapFactory.decodeResource(getResources(), R.drawable.metal2);
//        metal3Im = BitmapFactory.decodeResource(getResources(), R.drawable.metal3);
//        metal4Im = BitmapFactory.decodeResource(getResources(), R.drawable.metal4);
//        metal5Im = BitmapFactory.decodeResource(getResources(), R.drawable.metal5);
//        metal6Im = BitmapFactory.decodeResource(getResources(), R.drawable.metal6);
//        metal7Im = BitmapFactory.decodeResource(getResources(), R.drawable.metal7);
//        metal8Im = BitmapFactory.decodeResource(getResources(), R.drawable.metal8);
//
//        GridItem metal1Item = new GridItem();
//        metal1Item.image = metal1Im;
//        grid4.add(metal1Item);
//
//        GridItem metal2Item = new GridItem();
//        metal2Item.image = metal2Im;
//        grid4.add(metal2Item);
//
//        GridItem metal3Item = new GridItem();
//        metal3Item.image = metal3Im;
//        grid4.add(metal3Item);
//
//        GridItem metal4Item = new GridItem();
//        metal4Item.image = metal4Im;
//        grid4.add(metal4Item);
//
//        GridItem metal5Item = new GridItem();
//        metal5Item.image = metal5Im;
//        grid4.add(metal5Item);
//
//        GridItem metal6Item = new GridItem();
//        metal6Item.image = metal6Im;
//        grid4.add(metal6Item);
//
//        GridItem metal7Item = new GridItem();
//        metal7Item.image = metal7Im;
//        grid4.add(metal7Item);
//
//        GridItem metal8Item = new GridItem();
//        metal8Item.image = metal8Im;
//        grid4.add(metal8Item);
//
//        GridItemAdapter gridItemAdapter = new GridItemAdapter(this, R.layout.grid_item, grid4);
//        gridView4.setAdapter(gridItemAdapter);
//
//    }
//}
