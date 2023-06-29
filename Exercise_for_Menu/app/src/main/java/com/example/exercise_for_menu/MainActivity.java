package com.example.exercise_for_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
                    msg = "Decaffeine " +  msg;
                if(radioEspresso.getId() == radioId)
                    msg = "Espresso " +  msg;
                if(radioColombian.getId() == radioId)
                    msg = "Colombian " +  msg;

                //send Toast
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);    //menu.xml inflate
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curId = item.getItemId();
        switch(curId)
        {
            case R.id.menu_refresh:
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                Toast.makeText(this,"Selected refresh option",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_search:
                Toast.makeText(this,"Selected search option",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_settings:
                Toast.makeText(this,"Selected settings option",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}