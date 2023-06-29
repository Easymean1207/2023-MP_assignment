package com.example.exercise_mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button startBtn,stopBtn, pauseBtn, restartBtn;
    String url= "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";
    MediaPlayer player;
    int position; //일시정지된 위치 저장


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        startBtn.setOnClickListener(click);
        stopBtn.setOnClickListener(click);
        pauseBtn.setOnClickListener(click);
        restartBtn.setOnClickListener(click);

    }

    //findViewById init()
    public void init(){
        startBtn = findViewById(R.id.StartBtn);
        stopBtn = findViewById(R.id.StopBtn);
        pauseBtn = findViewById(R.id.PauseBtn);
        restartBtn = findViewById(R.id.RestartBtn);
    }

    //listener 통일
    View.OnClickListener click = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.StartBtn:
                    playAudio();
                    break;
                case R.id.StopBtn:
                    stopAudio();
                    break;
                case R.id.PauseBtn:
                    pauseAudio();
                    break;
                case R.id.RestartBtn:
                    restartAudio();
                    break;
            }
        }
    };

    public void playAudio()
    {
        showToast("음악 재생");

        killPlayer();   //player 중복 호출 방지

        player = new MediaPlayer();
        try {
            player.setDataSource(url);
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }//player가 제대로 동작하지 않을 경우 예외처리를 위함
    }

    public void stopAudio()
    {
        showToast("음악 정지");

        if(player != null){
            try{
                player.stop();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    public void pauseAudio()
    {
        showToast("음악 일시 정지");

        if(player != null){
            try{
                position = player.getCurrentPosition();
                player.pause();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void restartAudio()
    {
        showToast("음악 파일 다시 재생");
        if(player != null && !player.isPlaying()){
            try{
                player.start();
                player.seekTo(position);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void killPlayer()
    {
        if(player != null){
            try{
                player.release();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void showToast(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

}