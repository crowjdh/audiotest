package com.ques.audiolibraryexamine;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cleveroad.audiovisualization.AudioVisualization;
import com.cleveroad.audiovisualization.DbmHandler;
import com.cleveroad.audiovisualization.VisualizerDbmHandler;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private AudioVisualization mAudioVisualizationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource("/mnt/sdcard/Documents/Music/a/a.wav");

            mAudioVisualizationView = (AudioVisualization) findViewById(R.id.visualizer_view);

            VisualizerDbmHandler handler = DbmHandler.Factory.newVisualizerHandler(getApplicationContext(), mediaPlayer);
            mAudioVisualizationView.linkTo(handler);

            mAudioVisualizationView.onResume();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
