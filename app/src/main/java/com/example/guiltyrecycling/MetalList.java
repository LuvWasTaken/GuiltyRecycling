package com.example.guiltyrecycling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MetalList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metal_list);

        ListView listView = findViewById(R.id.listview);

        List<String> list = new ArrayList<>();
        list.add("Soda Can / Tin Can");
        list.add("Metal Water Bottle");
        list.add("Aluminum Foil");
        list.add("Pots / Pans");
        list.add("Baking Sheets");
        list.add("Utensils");
        list.add("Bottle Caps");
        list.add("Toasters / Appliances");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
    }
}