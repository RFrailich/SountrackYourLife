package com.example.giraffe.lifesountrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button myMenu = (Button) findViewById(R.id.list);

        myMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                attempt_analyze();
            }
        });
    }

    public void play(View view) {
        Intent nextPage = new Intent(this,PauseActivity.class);
        startActivity(nextPage);
    }

    public void settings(View view){
        Intent nextPage = new Intent(this, PlayActivity.class);
        startActivity(nextPage);
    }

    public void list(View view){
       attempt_analyze();
    }

    public void attempt_analyze() {
        try {
            TrackAnalysisExample.analyze();
        }
        catch (com.echonest.api.v4.EchoNestException e){
            System.out.println("Error: booooooooooooo");
        }
    }
}
