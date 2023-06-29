package com.example.exercise_sensors2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    SensorManager sensor_manager;
    List<Sensor> arSensor;
    String result;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getInfo();
    }

    public void init(){
        sensor_manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        arSensor = sensor_manager.getSensorList(Sensor.TYPE_ALL);
        result = "갯수:" + arSensor.size() + "\n\n";
        textViewResult = findViewById(R.id.result);
    }

    public void getInfo(){
        for(Sensor s: arSensor){
            result += ("이름 = " + s.getName() + "\n 형식 = " + s.getType() +
                    "\n 제조사 = " + s.getVendor() + "\n 전원 = " + s.getPower()+
                    "\n 해상도 = " + s.getResolution() + "\n 범위 = " + s.getMaximumRange()
                    + "\n\n");
        }
        textViewResult.setText(result);
    }
}