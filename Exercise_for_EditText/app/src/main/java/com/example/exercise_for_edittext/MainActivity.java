package com.example.exercise_for_edittext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Slide;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView labelUserName = findViewById(R.id.textView);
        EditText txtUserName = findViewById(R.id.txtUserName);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = txtUserName.getText().toString();
                if(userName.compareToIgnoreCase("jimin lee") == 0)
                {
                    labelUserName.setText("OK, Please wait....");
                    Toast toast = Toast.makeText(MainActivity.this,"Hi! " + userName, Toast.LENGTH_LONG);
                    toast.show();
                }
                else
                {
                    Toast toast = Toast.makeText(MainActivity.this,userName + "is Not valid user", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    
}