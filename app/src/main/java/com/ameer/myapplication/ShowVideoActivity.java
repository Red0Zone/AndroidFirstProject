package com.ameer.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowVideoActivity extends AppCompatActivity {

    private ListView listViewVideo;
    private VideoView videoPlayer;
    private ArrayAdapter<String> arrayAdapter;
    private int vidPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_video);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listViewVideo = findViewById(R.id.listViewVideo);
        videoPlayer = findViewById(R.id.videoPlayer);
        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        addList();

        listViewVideo.setOnItemClickListener(this::onItemClicked);


//        String videoPath = "android.resource://com.example.firstproject/" + R.raw.mul;
//        Uri uri = Uri.parse(videoPath);
//        videoPlayer.setVideoURI(uri);
//        videoPlayer.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        vidPos = videoPlayer.getCurrentPosition();
        videoPlayer.pause();
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        vidPos=videoPlayer.getCurrentPosition();
//        videoPlayer.pause();
//    }

    @Override
    protected void onResume() {
        super.onResume();
        if (vidPos != 0) {
            videoPlayer.seekTo(vidPos);
            videoPlayer.start();
        }
    }


    private void onItemClicked(AdapterView<?> parent, View view, int position, long id) {

        if (position == 0) {
            playThisVid(R.raw.cell);
        }
        if (position == 1) {
            playThisVid(R.raw.genetics);
        }
        if (position == 2) {
            playThisVid(R.raw.metabolism);
        }
        if (position == 3) {
            playThisVid(R.raw.hormones);
        }
        if (position == 4) {
            playThisVid(R.raw.dna);
        }


    }

    private void playThisVid(int i) {
        String videoPath = "android.resource://com.ameer.myapplication/" + i;
        Uri uri = Uri.parse(videoPath);
        videoPlayer.setVideoURI(uri);
        videoPlayer.start();
    }


    private void addList() {
        String[] arr = new String[]{"The Cell", "Genetics", "Metabolism", "Hormones", "DNA"};
        arrayAdapter = new ArrayAdapter<>(ShowVideoActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr);
        listViewVideo.setAdapter(arrayAdapter);
    }




}