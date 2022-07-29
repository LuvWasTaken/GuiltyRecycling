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
//public class OrganicGridActivity extends AppCompatActivity {
//    GridView gridView7;
//    ArrayList<GridItem> grid7 = new ArrayList<GridItem>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.organic_grid);
//
//        gridView7 = (GridView) findViewById(R.id.OrganicGrid);
//
//        Bitmap Organic1Im, Organic2Im, Organic3Im, Organic4Im, Organic5Im, Organic6Im, Organic7Im, Organic8Im;
//        Organic1Im = BitmapFactory.decodeResource(getResources(), R.drawable.Organic1);
//        Organic2Im = BitmapFactory.decodeResource(getResources(), R.drawable.Organic2);
//        Organic3Im = BitmapFactory.decodeResource(getResources(), R.drawable.Organic3);
//        Organic4Im = BitmapFactory.decodeResource(getResources(), R.drawable.Organic4);
//        Organic5Im = BitmapFactory.decodeResource(getResources(), R.drawable.Organic5);
//        Organic6Im = BitmapFactory.decodeResource(getResources(), R.drawable.Organic6);
//        Organic7Im = BitmapFactory.decodeResource(getResources(), R.drawable.Organic7);
//        Organic8Im = BitmapFactory.decodeResource(getResources(), R.drawable.Organic8);
//
//        GridItem Organic1Item = new GridItem();
//        Organic1Item.image = Organic1Im;
//        grid7.add(Organic1Item);
//
//        GridItem Organic2Item = new GridItem();
//        Organic2Item.image = Organic2Im;
//        grid7.add(Organic2Item);
//
//        GridItem Organic3Item = new GridItem();
//        Organic3Item.image = Organic3Im;
//        grid7.add(Organic3Item);
//
//        GridItem Organic4Item = new GridItem();
//        Organic4Item.image = Organic4Im;
//        grid7.add(Organic4Item);
//
//        GridItem Organic5Item = new GridItem();
//        Organic5Item.image = Organic5Im;
//        grid7.add(Organic5Item);
//
//        GridItem Organic6Item = new GridItem();
//        Organic6Item.image = Organic6Im;
//        grid7.add(Organic6Item);
//
//        GridItem Organic7Item = new GridItem();
//        Organic7Item.image = Organic7Im;
//        grid7.add(Organic7Item);
//
//        GridItem Organic8Item = new GridItem();
//        Organic8Item.image = Organic8Im;
//        grid7.add(Organic8Item);
//
//        GridItemAdapter gridItemAdapter = new GridItemAdapter(this, R.layout.grid_item, grid7);
//        gridView7.setAdapter(gridItemAdapter);
//
//    }
//}
