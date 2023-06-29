package com.example.exercise_location;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView myLocation;
    Button showMyLocationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        showMyLocationBtn.setOnClickListener(click);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);
    }

    public void init(){
        myLocation = findViewById(R.id.MyLocation);
        showMyLocationBtn = findViewById(R.id.ShowMyLocation);
    }

    View.OnClickListener click = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.ShowMyLocation:
                    startLocationService();
                    break;
            }
        }
    };

    public void startLocationService(){
        //location manager 생성
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        try{
            GPSListener gpsListener = new GPSListener();
            long minTime = 10000;
            float minDistance = 0;

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,minTime,minDistance,gpsListener);

            Toast.makeText(getApplicationContext(),"내 위치 확인 요청",Toast.LENGTH_SHORT).show();
        }catch(SecurityException e){
            e.printStackTrace();
        }

    }

    class GPSListener implements LocationListener{
        @Override
        public void onLocationChanged(@NonNull Location location) {
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();
            String message = "위치:" + "\n위도:" + latitude + "\n경도:" + longitude;
            myLocation.setText(message);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            LocationListener.super.onStatusChanged(provider, status, extras);
        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {
            LocationListener.super.onProviderEnabled(provider);
        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {
            LocationListener.super.onProviderDisabled(provider);
        }
    }

}