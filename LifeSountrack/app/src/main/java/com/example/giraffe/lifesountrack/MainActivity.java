package com.example.giraffe.lifesountrack;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    static int wat;
   // private int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //n = 0;
        //Code to choose a song with a given BPM, right now choose a specific song
        mediaPlayer = MediaPlayer.create(this, R.raw.slow); //change to logical  choice later
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mPlayButton = (Button) findViewById(R.id.playMain);
        Button myMenu = (Button) findViewById(R.id.list);
        // Default button, if need set it in xml via background="@drawable/default"
        mPlayButton.setBackgroundResource(R.drawable.play);
        mPlayButton.setOnClickListener(mTogglePlayButton);
        myMenu.setOnClickListener(mToggleMenuButton);
    }

    View.OnClickListener mTogglePlayButton = new View.OnClickListener(){
        boolean clicked = false;

        @Override
        public void onClick(View v){
            // change your button background
            if(clicked){
                mediaPlayer.pause();
                v.setBackgroundResource(R.drawable.play);
            }else{
                mediaPlayer.start();
                v.setBackgroundResource(R.drawable.pause);
            }

            clicked = !clicked; // reverse
        }

    };

    View.OnClickListener mToggleMenuButton = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            setContentView(R.layout.activity_menu);
            Button lilB = (Button) findViewById(R.id.lowB);
            Button midB = (Button) findViewById(R.id.midB);
            Button bigB = (Button) findViewById(R.id.highB);
            //setContentView(R.layout.activity_menu);
        }
    };

    public void mToggleLoSong() {
        wat = 0;
        setContentView(R.layout.activity_main);
    }

    public void mToggleMidSong() {
        wat = 1;
        setContentView(R.layout.activity_main);
    }

    public void mToggleHiSong() {
        wat = 2;
        setContentView(R.layout.activity_main);
    }

    public void list(View view){
        Intent nextPage = new Intent(this, NewPlaylistActivity.class);
        startActivity(nextPage);
    }
}
