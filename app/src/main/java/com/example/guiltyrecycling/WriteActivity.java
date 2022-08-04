package com.example.guiltyrecycling;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class WriteActivity extends AppCompatActivity {

    ListView search_item;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        search_item = (ListView) findViewById(R.id.search_item);

        ArrayList<String> arrayItem = new ArrayList<>();
        arrayItem.addAll(Arrays.asList(getResources().getStringArray(R.array.my_items)));

        adapter = new ArrayAdapter<String>(
                WriteActivity.this,
                android.R.layout.simple_list_item_1,
                arrayItem
        );

        search_item.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search_item);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }

        });

        return super.onCreateOptionsMenu(menu);
    }
    }
