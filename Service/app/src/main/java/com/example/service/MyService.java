package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate() 호출됨");    //Add
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand() 호출됨");
        //Add start
        if(intent == null) {    //intent로 받은 데이터가 null
            return Service.START_STICKY;    //intent값을 null로 초기화시키면서 서비스 재시작
        }
        else {
            processCommand(intent);
        }
        //Add end
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //make processCommand function
    private void processCommand(Intent intent)
    {
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");

        Log.d(TAG,"command :" + command + ", name :" + name);

        for(int i=0;i<5;i++)
        {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {};
            Log.d(TAG, "waiting" + i + "seconds");
        }
    }
}

