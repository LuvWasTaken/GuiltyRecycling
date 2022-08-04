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
    private static final int GLASS_OBJECT_TYPE = 103;
    private static final int PAPER_OBJECT_TYPE = 104;
    private static final int ORGANIC_OBJECT_TYPE = 105;
    private static final int PLASTIC_OBJECT_TYPE = 107;
    private static final int EWASTE_OBJECT_TYPE = 108;


    private String recordedText;
    TextToSpeech textToSpeech;

    String greetingLine = "Hello, what would you like to recycle today? Is it metal, glass, paper, organic, plastic, or e-waste?";


    String recycable = "You can recycle this item";
    String notRecycable = "This item is not recycable";
    String couldNotDetermine = "Could not determine if this item is recycable";

    List<String> recycableMetalItems = Arrays.asList("a soda can", "soda can", "tin can", "metal water bottle",
            "aluminum foil", "a pot", "a pan", "pot", "pan",
            "baking sheet","utensils", "utensil", "bottle caps", "a bottle cap", "bottle cap");

    List<String> recycableGlassItems = Arrays.asList("a bottle", "bottle", "perfume bottle", "a perfume bottle", "a jar", "jar", "glass", "window glass");
    List<String> recycablePaperItems = Arrays.asList("a newspaper", "newspaper", "flattened cardboard", "books", "a book", "food boxes", "a food box", "paper plates", "a paper plate", "paper towel", "a paper towel");
    List<String> recycableOrganicItems = Arrays.asList("food scrapes", "coffee grounds", "eggshells", "egg shells", "banana peels", "paper napkins", "tea bags", "meat");
    List<String> recycablePlasticItems = Arrays.asList("bottles", "milk jug", "a bottle", "bottle");
    List<String> recycableEwasteItems = Arrays.asList("batteries", "printers", "a printer", "a tv", "tv", "led bulbs", "a phone", "phones", "computers", "a fridge", "a freezer", "a computer");

    String whatKindOfMetal = "What kind of metal object is it? Is it a soda can, metal water bottle, aluminum foil, a pot, a pan, baking sheet, utensils, bottle cap or an appliance?";
    String whatKindOfPaper = "What kind of paper is it? A newspaper, flattened cardboard, a book, a food box, paper plates, ir a paper towel";
    String whatKindOfOrganic = "What kind of organic item is it? Food scrapes, coffee grounds, eggshells, banana pee, meat, paper napkins or a tea bag?";
    String whatKindOfPlastic = "What kind of plastic is it? Is it a bottle or milk jug?";
    String whatKindOfEwaste = "What kind of e waste is it? Baterries, a printer, a tv, led bulbs, a phone, a computer, a fridge or a freezer";
    String whatKindOfGlass = "What kind of glass is it? A bottle, perfume bottle, a jar, or window glass";


    TextView displayTextView;

    private boolean listen(int code)
    {
        boolean success = true;
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
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
                    else if(results.equals("glass"))
                    {
                        displayTextView.setText(whatKindOfGlass);
                        textToSpeech.speak(whatKindOfGlass,TextToSpeech.QUEUE_FLUSH,null);
                        listen(GLASS_OBJECT_TYPE);
                    }
                    else if(results.equals("paper"))
                    {
                        displayTextView.setText(whatKindOfPaper);
                        textToSpeech.speak(whatKindOfPaper,TextToSpeech.QUEUE_FLUSH,null);
                        listen(PAPER_OBJECT_TYPE);
                    }
                    else if(results.equals("organic"))
                    {
                        displayTextView.setText(whatKindOfOrganic);
                        textToSpeech.speak(whatKindOfOrganic,TextToSpeech.QUEUE_FLUSH,null);
                        listen(ORGANIC_OBJECT_TYPE);
                    }
                    else if(results.equals("plastic"))
                    {
                        displayTextView.setText(whatKindOfPlastic);
                        textToSpeech.speak(whatKindOfPlastic,TextToSpeech.QUEUE_FLUSH,null);
                        listen(PLASTIC_OBJECT_TYPE);
                    }
                    else if(results.equals("ewaste") || results.equals("e-waste") || results.equals("e waste"))
                    {
                        displayTextView.setText(whatKindOfEwaste);
                        textToSpeech.speak(whatKindOfEwaste,TextToSpeech.QUEUE_FLUSH,null);
                        listen(EWASTE_OBJECT_TYPE);
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

                    if(recycableMetalItems.contains(item))
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
            case GLASS_OBJECT_TYPE: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String item = result.get(0);

                    if(recycableGlassItems.contains(item))
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
            case PAPER_OBJECT_TYPE: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String item = result.get(0);

                    if(recycablePaperItems.contains(item))
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
            case ORGANIC_OBJECT_TYPE: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String item = result.get(0);

                    if(recycableOrganicItems.contains(item))
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
            case PLASTIC_OBJECT_TYPE: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String item = result.get(0);

                    if(recycablePlasticItems.contains(item))
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
            case EWASTE_OBJECT_TYPE: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String item = result.get(0);

                    if(recycableEwasteItems.contains(item))
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