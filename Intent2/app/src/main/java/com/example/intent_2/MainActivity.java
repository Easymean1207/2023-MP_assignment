package com.example.intent_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                    //getApplicationContext() -> 주변 UI 정보를 가져옴
                    //getApplicationContext()에 의해서 MenuAcitivity.class의 UI 정보를 가져옴
                startActivityForResult(intent,101);
                    //intent를 보냈으니 잘 도착했는지 확인 바람 (requestCode: 101)
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101)
        {
            if(data != null)
            {
                String name = data.getStringExtra("name");
                if(name != null){
                    Toast.makeText(this,"응답: " + name, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}