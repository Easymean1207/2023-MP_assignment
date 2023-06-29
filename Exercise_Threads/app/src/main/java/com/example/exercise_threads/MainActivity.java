package com.example.exercise_threads;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button startThreadBtn;
    String tag = "MyThread";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        startThreadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackgroundThread thread = new BackgroundThread();
                thread.start();
            }
        });
    }

    public void init(){
        startThreadBtn = findViewById(R.id.startThreadBtn);
    }

    class BackgroundThread extends Thread{
        int value =0;
        public void run(){
            for(int i=0; i<100; i++){
                try {
                    Thread.sleep(1000);
                }catch(Exception e){}

                value = value +1;
                Log.d(tag,"value :" + value);
            }
        }
    }

}