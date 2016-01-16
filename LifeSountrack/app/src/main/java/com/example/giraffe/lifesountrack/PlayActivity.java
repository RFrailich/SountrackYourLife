package com.example.giraffe.lifesountrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }

    public void play(View view) {
        Intent nextPage = new Intent(this, PauseActivity.class);
        startActivity(nextPage);
    }

    public void skip(View view){
        Intent nextPage = new Intent(this, PlayActivity.class);
        startActivity(nextPage);
    }
}
