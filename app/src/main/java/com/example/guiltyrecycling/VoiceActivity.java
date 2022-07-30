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
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class VoiceActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 100;
    private static final int CATEGORY_CODE = 101;
    private static final int METAL_OBJECT_TYPE = 102;

    private String recordedText;
    TextToSpeech textToSpeech;

    String greetingLine = "Hello, what would you like to recycle today? Is it metal, glass, paper, organic, plastic, or e-waste?";
    String whatKindOfMetal = "What kind of metal object is it? Is it a soda can, metal water bottle, aluminum foil, a pot, a pan, baking sheet, utensils, bottle cap or an appliance?";

    String recycable = "You can recycle this item";
    String notRecycable = "This item is not recycable";
    String couldNotDetermine = "Could not determine if this item is recycable";

    TextView displayTextView;

    private boolean listen(int code)
    {
        boolean success = true;
        while(textToSpeech.isSpeaking())
        {

        }

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        try {

            startActivityForResult(intent, code);

        } catch (ActivityNotFoundException a) {
            success = false;

        }

        return success;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_activity);

        displayTextView = (TextView) findViewById(R.id.displayText);
        displayTextView.setText(greetingLine);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.UK);
                    textToSpeech.speak(greetingLine,TextToSpeech.QUEUE_FLUSH,null);

                    listen(CATEGORY_CODE);



                }
            }
        });
    }

    public void recordSpeech(View v)
    {
        displayTextView.setText(greetingLine);
        textToSpeech.speak(greetingLine,TextToSpeech.QUEUE_FLUSH,null);
        listen(CATEGORY_CODE);

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
            case CATEGORY_CODE: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String results = result.get(0);


                    if(results.equals("metal"))
                    {
                        displayTextView.setText(whatKindOfMetal);
                        textToSpeech.speak(whatKindOfMetal,TextToSpeech.QUEUE_FLUSH,null);
                        listen(METAL_OBJECT_TYPE);
                    }
                    else
                    {
                        textToSpeech.speak(couldNotDetermine,TextToSpeech.QUEUE_FLUSH,null);
                    }

                }
                break;
            }
            case METAL_OBJECT_TYPE: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String item = result.get(0);
                    List<String> recycbleItems = Arrays.asList("a soda can", "soda can", "tin can", "metal water bottle",
                                                                "aluminum foil", "a pot", "a pan", "pot", "pan",
                                                                "baking sheet","utensils", "utensil", "bottle caps", "a bottle cap", "bottle cap");

                    if(recycbleItems.contains(item))
                    {
                        textToSpeech.speak(recycable,TextToSpeech.QUEUE_FLUSH,null);

                    }
                    else
                    {
                        textToSpeech.speak(notRecycable,TextToSpeech.QUEUE_FLUSH,null);
                    }

                }
                break;

            }

        }
    }
}