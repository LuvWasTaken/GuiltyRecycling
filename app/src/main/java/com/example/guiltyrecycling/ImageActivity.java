package com.example.guiltyrecycling;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    ImageButton glassBtn;
    ImageButton paperBtn;
    ImageButton metalBtn;
    ImageButton plasticBtn;
    ImageButton organicBtn;
    ImageButton ewasteBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);

        glassBtn = findViewById(R.id.glassBtn);
        paperBtn = findViewById(R.id.paperBtn);
        metalBtn = findViewById(R.id.metalBtn);
        plasticBtn = findViewById(R.id.plasticBtn);
        organicBtn = findViewById(R.id.organicBtn);
        ewasteBtn = findViewById(R.id.ewasteBtn);

        if (savedInstanceState == null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            Fragment glassfragmentonCreate = new GlassFragment();
            transaction.replace(R.id.container, glassfragmentonCreate);
            transaction.commit();
        }


        glassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (savedInstanceState == null) {
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    Fragment glassfragment = new GlassFragment();
                    fragmentTransaction.replace(R.id.container, glassfragment);
                    fragmentTransaction.commit();
                }
                Toast.makeText(ImageActivity.this,
                        "Glass ImageButton Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        paperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                Fragment paperfragment = new PaperFragment();
                fragmentTransaction.replace(R.id.container, paperfragment);
                fragmentTransaction.commit();
                Toast.makeText(ImageActivity.this,
                        "Paper ImageButton Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        metalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                Fragment metalfragment = new MetalFragment();
                fragmentTransaction.replace(R.id.container, metalfragment);
                fragmentTransaction.commit();
                Toast.makeText(ImageActivity.this,
                        "Metal ImageButton Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        plasticBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                Fragment plasticfragment = new PlasticFragment();
                fragmentTransaction.replace(R.id.container, plasticfragment);
                fragmentTransaction.commit();
                Toast.makeText(ImageActivity.this,
                        "Plastic ImageButton Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        organicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                Fragment organicfragment = new OrganicFragment();
                fragmentTransaction.replace(R.id.container, organicfragment);
                fragmentTransaction.commit();
                Toast.makeText(ImageActivity.this,
                        "Organic ImageButton Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        ewasteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                Fragment ewastefragment = new EWasteFragment();
                fragmentTransaction.replace(R.id.container, ewastefragment);
                fragmentTransaction.commit();
                Toast.makeText(ImageActivity.this,
                        "EWaste ImageButton Clicked.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}