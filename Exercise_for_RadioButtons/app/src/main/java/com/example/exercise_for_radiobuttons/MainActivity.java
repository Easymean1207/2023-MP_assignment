package com.example.exercise_for_radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox chkCream = findViewById(R.id.chkCream);
        CheckBox chkSugar = findViewById(R.id.chkSugar);
        Button btnPay = findViewById(R.id.btnPay);

        RadioGroup radioCoffeeType = findViewById(R.id.radioGroupCoffeeType);
        RadioButton radioDecaf = findViewById(R.id.radioDecaf);
        RadioButton radioEspresso = findViewById(R.id.radioEspresso);
        RadioButton radioColombian = findViewById(R.id.radioColombian);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "Coffee ";

                //for CheckBox
                if(chkCream.isChecked())
                {
                    msg = msg + "& Cream";
                }

                if(chkSugar.isChecked())
                {
                    msg = msg + "& Sugar";
                }

                //for RadioButton
                int radioId = radioCoffeeType.getCheckedRadioButtonId();
                if(radioDecaf.getId() == radioId)
                    msg = "Decaf " +  msg;
                if(radioEspresso.getId() == radioId)
                    msg = "Espresso " +  msg;
                if(radioColombian.getId() == radioId)
                    msg = "Colombian " +  msg;

                //send Toast
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        });

    }
}