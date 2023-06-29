package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;  //Add

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText); //editText를 activity_main.xml에서 가져옴

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String name = editText.getText().toString();   //editText를 String으로 변환
             Intent intent = new Intent(getApplicationContext(),MyService.class);
             intent.putExtra("command","show");
             intent.putExtra("name",name);
             startService(intent);
            }
        });
    }
}