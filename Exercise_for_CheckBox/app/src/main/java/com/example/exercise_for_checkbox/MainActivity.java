package com.example.exercise_for_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox chkCream = findViewById(R.id.chkCream);
        CheckBox chkSugar = findViewById(R.id.chkSugar);
        Button btnPay = findViewById(R.id.btnPay);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "Coffee ";
                if(chkCream.isChecked())
                {
                    msg = msg + "& Cream";
                }

                if(chkSugar.isChecked())
                {
                    msg = msg + "& Sugar";
                }

                //send Toast
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        });
    }
}