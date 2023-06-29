package com.example.exercise_videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button playBtn;
    VideoView video;
    MediaController mediaController;
    String url = "https://media.w3.org/2010/05/sintel/trailer.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        playBtn.setOnClickListener(click);
    }

    public void init(){
        video = findViewById(R.id.Video);
        playBtn = findViewById(R.id.PlayBtn);
        mediaController = new MediaController(this);
        video.setMediaController(mediaController);
    }

    View.OnClickListener click = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.PlayBtn:
                    playVideo();
                    break;
            }
        }
    };

    public void playVideo(){
        video.setVideoURI(Uri.parse(url));
        video.requestFocus();
        video.start();
    }


}