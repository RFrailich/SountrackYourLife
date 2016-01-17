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
        Button mPlayButton = (Button) findViewById(R.id.playMain);
        // Default button, if need set it in xml via background="@drawable/default"
        mPlayButton.setBackgroundResource(R.drawable.play);
        mPlayButton.setOnClickListener(mTogglePlayButton);
    }

    View.OnClickListener mTogglePlayButton = new View.OnClickListener(){
        boolean clicked = false;
        @Override
        public void onClick(View v){
            // change your button background

            if(clicked){
                v.setBackgroundResource(R.drawable.play);
            }else{
                v.setBackgroundResource(R.drawable.pause);
            }

            clicked = !clicked; // reverse
        }

    };

    public void settings(View view){
        Intent nextPage = new Intent(this, SettingsActivity.class);
        startActivity(nextPage);
    }

    public void list(View view){
        Intent nextPage = new Intent(this, NewPlaylistActivity.class);
        startActivity(nextPage);
    }
}
