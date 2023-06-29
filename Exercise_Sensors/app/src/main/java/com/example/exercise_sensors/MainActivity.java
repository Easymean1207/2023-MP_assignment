package com.example.exercise_sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView gravityValue;
    private SensorManager sensor_manager;
    private Sensor gravitySensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        gravityValue = (TextView) findViewById(R.id.returnValue);
        sensor_manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        gravitySensor = sensor_manager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensor_manager.registerListener(mySensorListener,gravitySensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sensor_manager.registerListener(mySensorListener,gravitySensor,SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensor_manager.unregisterListener(mySensorListener);
    }

    public SensorEventListener mySensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if(sensorEvent.sensor.getType() == Sensor.TYPE_GRAVITY){
                gravityValue.setText(Float.toString(sensorEvent.values[0]));
                Log.i("TAG",Float.toString(sensorEvent.values[0]));
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

}