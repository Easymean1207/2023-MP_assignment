package com.example.exercise_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btn1;
    MainHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackgroundThread thread = new BackgroundThread();
                thread.start();
            }
        });
    }

    public void init(){
        textView = findViewById(R.id.textView);
        btn1 = findViewById(R.id.btn1);
        handler = new MainHandler();
    }

    class BackgroundThread extends Thread{
        int value =0;
        public void run(){
            for(int i=0; i<100; i++){
                try {
                    Thread.sleep(1000);
                }catch(Exception e){}

                value = value +1;
                Log.d("MyThread","value :" + value);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("Value : " + value);
                    }
                });

                Message msg = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("value", value);
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        }
    }

    class MainHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            int value = bundle.getInt("value");

            textView.setText("Value: " + value);
        }
    }
}