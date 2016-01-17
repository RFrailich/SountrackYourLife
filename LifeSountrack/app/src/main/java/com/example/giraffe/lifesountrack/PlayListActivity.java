
package com.example.giraffe.lifesountrack;

import android.net.Uri;

import com.echonest.api.v4.EchoNestAPI;
import com.echonest.api.v4.EchoNestException;
import com.echonest.api.v4.TimedEvent;
import com.echonest.api.v4.Track;
import com.echonest.api.v4.TrackAnalysis;

import java.io.File;
import java.io.IOException;

/**
 * Created by Julianna on 2016-01-16.
 */

    class TrackAnalysisExample {

        public static void analyze() throws EchoNestException {
            System.out.println("starting this shit");
            EchoNestAPI en = new EchoNestAPI("UT9IR1JFH5JRLJ0N3");
            System.out.println("made new api");
             //path = R.raw.fast;

            //Uri mediaPath = Uri.parse("android.resource://com.example.giraffe.lifesountrack/raw/fast");
            Uri mediaPath = Uri.parse("android.resource://com.example.giraffe.lifesountrack/");
            File file = new File(mediaPath.getPath());
            System.out.println("made new file");
            if (!file.exists()) {
                System.err.println("Can't find ");
                System.out.println("cant find " + mediaPath.getPath());
            } else {
                System.out.println("Found the music yay!");
                String[] files = file.list();
                for (String pfile : files) {
                    System.out.println(pfile+",");
                }
                try {
                    Track track = en.uploadTrack(file);
                    track.waitForAnalysis(30000);
                    if (track.getStatus() == Track.AnalysisStatus.COMPLETE) {
                        System.out.println("Tempo: " + track.getTempo());
                        System.out.println("Danceability: " + track.getDanceability());
                        System.out.println("Speechiness: " + track.getSpeechiness());
                        System.out.println("Liveness: " + track.getLiveness());
                        System.out.println("Energy: " + track.getEnergy());
                        System.out.println("Loudness: " + track.getLoudness());
                        System.out.println();
                        System.out.println("Beat start times:");

                        TrackAnalysis analysis = track.getAnalysis();
                        for (TimedEvent beat : analysis.getBeats()) {
                            System.out.println("beat " + beat.getStart());
                        }
                    } else {
                        System.err.println("Trouble analysing track " + track.getStatus());
                    }
                } catch (IOException e) {
                    System.err.println("Trouble uploading file");
                }

            }
        }
    }
