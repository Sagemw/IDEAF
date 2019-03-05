package com.example.sage.ideaf;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText etwrite;
    Button btnSpeak;
    String write;

    TextToSpeech ttobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etwrite = findViewById(R.id.etWrite);
        btnSpeak = findViewById(R.id.btnSpeak);

        ttobj=new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){
                            ttobj.setLanguage(Locale.UK);
                        }
                    }
                });

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakText();
            }
        });
    }

//    @Override
//    public void onPause(){
//        if(ttobj !=null){
//            ttobj.stop();
//            ttobj.shutdown();
//        }
//        super.onPause();
//    }


    @Override
    public void onBackPressed() {
        if(ttobj !=null){
            ttobj.stop();
            ttobj.shutdown();
        }
        super.onBackPressed();
    }

    public void speakText(){
        float sp = 0000001;
        write = etwrite.getText().toString();
        Toast.makeText(getApplicationContext(), write,
                Toast.LENGTH_SHORT).show();
        Log.d("speak", "pass");
        ttobj.speak(write, TextToSpeech.QUEUE_FLUSH, null);
        ttobj.setSpeechRate(sp);

    }
}
