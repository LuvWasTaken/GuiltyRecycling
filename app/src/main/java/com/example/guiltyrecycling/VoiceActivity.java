package com.example.guiltyrecycling;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;


public class VoiceActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 100;
    private String recordedText;
    TextToSpeech textToSpeech;

    String greetingLine = "Hello, what would you like to recycle today? Is it metal, glass, paper, organic, plastic, or e-waste?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_activity);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.US);
                    textToSpeech.speak(greetingLine,TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });
    }

    public void recordSpeech(View v)
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        try {

            startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException a) {

        }

    }
    public void recordedText(View v)
    {

        textToSpeech.speak(recordedText,TextToSpeech.QUEUE_FLUSH,null);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String results = result.get(0);
                    recordedText = results;


                }
                break;
            }

        }
    }
}