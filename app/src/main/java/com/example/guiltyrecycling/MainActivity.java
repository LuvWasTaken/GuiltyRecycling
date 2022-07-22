package com.example.guiltyrecycling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton writeButton = (ImageButton)findViewById(R.id.writeButton);
        ImageButton voiceButton = (ImageButton)findViewById(R.id.voiceButton);
        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton);

        writeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v("myApp", "Write It button is clicked");
                Intent intent = new Intent();
                //writeActivity to be created by Mirelys
                intent.setClass(MainActivity.this, WriteActivity.class);
            }
        });

        voiceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v("myApp", "Speak It button is clicked");
                Intent intent = new Intent();
                //voiceActivity to be created by Luis
                intent.setClass(MainActivity.this, VoiceActivity.class);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v("myApp", "Visualize It button is clicked");
                Intent intent = new Intent();
                //imageActivity to be created by Tsuf
                intent.setClass(MainActivity.this, ImageActivity.class);
                startActivity(intent);
            }
        });
    }
}