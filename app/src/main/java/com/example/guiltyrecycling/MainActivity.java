package com.example.guiltyrecycling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton writeButton = (ImageButton)findViewById(R.id.writeButton);
        ImageButton voiceButton = (ImageButton)findViewById(R.id.voiceButton);
        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);


        writeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v("myApp", "Write It button is clicked");
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, WriteActivity.class);
                startActivity(intent);
            }
        });

        voiceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v("myApp", "Speak It button is clicked");
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, VoiceActivity.class);
                startActivity(intent);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v("myApp", "Visualize It button is clicked");
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ImageActivity.class);
                startActivity(intent);
            }
        });
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.write:
                Log.v("myApp", "write nav button is clicked");
                intent = new Intent();
                intent.setClass(MainActivity.this, WriteActivity.class);
                startActivity(intent);
                return true;

            case R.id.speak:
                Log.v("myApp", "Speak nav button is clicked");
                intent = new Intent();
                intent.setClass(MainActivity.this, VoiceActivity.class);
                startActivity(intent);
                return true;

            case R.id.image:
                Log.v("myApp", "Visualize nav button is clicked");
                intent = new Intent();
                intent.setClass(MainActivity.this, ImageActivity.class);
                startActivity(intent);
                return true;
        }
        return false;
    }
}