package com.example.guiltyrecycling;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guiltyrecycling.adapters.ElementAdapter;
import com.example.guiltyrecycling.models.Element;

import java.util.ArrayList;
import java.util.Arrays;

public class WriteActivity extends AppCompatActivity implements ElementAdapter.ElementClickListener {

    // For Categories
    ListView search_item;
    ArrayAdapter<String> adapter;


    // For elements in each categories
    ElementAdapter elementAdapter; // Custom adapter instead of ArrayAdapter
    RecyclerView elementRecyclerView; // Using recyclerview instead of ListView
    ArrayList<Element> elementArrayList = new ArrayList<>(); // Use custom class instead of string

    ArrayList<String> arrayNotRecyclableCount;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        // ***** init gategories
        search_item = (ListView) findViewById(R.id.search_item);

        ArrayList<String> arrayItem = new ArrayList<>();

        arrayItem.addAll(Arrays.asList(getResources().getStringArray(R.array.my_items)));

        arrayNotRecyclableCount = new ArrayList<>();
        arrayNotRecyclableCount.addAll(Arrays.asList(getResources().getStringArray(R.array.items_not_recyclebable_count)));

        adapter = new ArrayAdapter<String>(
                WriteActivity.this,
                android.R.layout.simple_list_item_1,
                arrayItem
        );

        search_item.setAdapter(adapter);

        search_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                initializeList(i); //Init element list when you click on a category
            }
        });


        // ***** element view by category

        elementRecyclerView = findViewById(R.id.element_recycler_view);
        elementAdapter = new ElementAdapter(WriteActivity.this, elementArrayList); // Initialize my adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        elementRecyclerView.setLayoutManager(layoutManager);
        elementRecyclerView.setAdapter(elementAdapter);
        elementAdapter.notifyDataSetChanged();
        elementAdapter.setElementClickListener(this);

    }

    // Handle click event on each element
    @Override
    public void onElementClick(int position) {
        try {

            Element clickedElement = elementAdapter.getElement(position); // Get the clicked element form the adapter

            if (clickedElement.isRecyclable()) {
                Toast.makeText(this, clickedElement.getTitle() + " is recyclable", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, clickedElement.getTitle() + " is not recyclable", Toast.LENGTH_SHORT).show();
            }

            // TODO : add custom action with clicked element

        } catch (Exception e) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search_item);
        searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (search_item.getVisibility() == View.VISIBLE) { // if Category list is visible, filter the category list else filter the elements
                    adapter.getFilter().filter(s);
                } else {
                    elementAdapter.filter(s); // Custom filter in adapters/ElementAdapter.class
                }
                return false;
            }

        });

        return super.onCreateOptionsMenu(menu);
    }


    // Show the list after category click with the corresponding elements
    public void initializeList(int category) {
        try {

            // reset element array for adapter
            elementArrayList.clear();


            // Clear the search view
            searchView.setQuery("", false);
            searchView.clearFocus();

            ArrayList<String> arrayElementName = new ArrayList<>();


            if (category == 0) {
                arrayElementName.addAll(Arrays.asList(getResources().getStringArray(R.array.metals)));
            } else if (category == 1) {
                arrayElementName.addAll(Arrays.asList(getResources().getStringArray(R.array.glass)));
            } else if (category == 2) {
                arrayElementName.addAll(Arrays.asList(getResources().getStringArray(R.array.paper)));
            } else if (category == 3) {
                arrayElementName.addAll(Arrays.asList(getResources().getStringArray(R.array.organic)));
            } else if (category == 4) {
                arrayElementName.addAll(Arrays.asList(getResources().getStringArray(R.array.plastic)));
            } else if (category == 5) {
                arrayElementName.addAll(Arrays.asList(getResources().getStringArray(R.array.ewaste)));
            }

            int notRecyclableCount = Integer.parseInt(arrayNotRecyclableCount.get(category));


            // Create a list of Element
            for (int i = 0; i < arrayElementName.size(); i++) {

                Element element = null;

                if (i < (arrayElementName.size() - notRecyclableCount)) {
                    element = new Element(arrayElementName.get(i), true);
                } else {
                    element = new Element(arrayElementName.get(i), false);
                }

                elementArrayList.add(element);
            }


            elementAdapter.notifyDataSetChanged();
            search_item.setVisibility(View.GONE);
            elementRecyclerView.setVisibility(View.VISIBLE);

        } catch (Exception e) {

        }
    }

    @Override
    public void onBackPressed() {

        if (search_item.getVisibility() == View.VISIBLE) {
            super.onBackPressed();
        } else {
            elementRecyclerView.setVisibility(View.GONE);
            search_item.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
