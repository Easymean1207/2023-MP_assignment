package com.example.a201835502_leejimin_asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    BackgroundTask task;
    Button exeBtn,cancelBtn;

    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        exeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = new BackgroundTask();
                task.execute();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.cancel(true);
            }
        });
    }

    public void init(){
        progressBar = findViewById(R.id.progressBar);
        exeBtn = findViewById(R.id.exeBtn);
        cancelBtn = findViewById(R.id.cancelBtn);
    }

    class BackgroundTask extends AsyncTask<Integer, Integer, Integer>{
        @Override
        protected void onPreExecute() {
            value = 0;
            progressBar.setProgress(value);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            while(!isCancelled()) {
                value++;
                if (value >= 100) break;

                publishProgress(value); //call onProgressUpdate

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}

            }
            return value;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Integer integer) {
            progressBar.setProgress(0);
            Toast.makeText(MainActivity.this,"완료되었습니다.",Toast.LENGTH_SHORT).show();
        }

        protected void onCancelled() {
            progressBar.setProgress(0);
            Toast.makeText(MainActivity.this,"취소되었습니다.",Toast.LENGTH_SHORT).show();
        }

    }

}