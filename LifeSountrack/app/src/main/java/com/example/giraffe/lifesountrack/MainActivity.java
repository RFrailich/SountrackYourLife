package com.example.giraffe.lifesountrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Intent nextPage = new Intent(this, PlayActivity.class);
        startActivity(nextPage);
    }
}
