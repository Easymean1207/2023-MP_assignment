package com.example.simplefragment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        menuFragment = new MenuFragment();
    }
        public void onFragmentChanged(int index)
        {
            if(index == 0)
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,menuFragment).commit();
                Toast.makeText(getApplicationContext(),"Go to Menu",Toast.LENGTH_SHORT).show();
            }
            else if(index == 1)
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFragment).commit();
                Toast.makeText(getApplicationContext(),"Return to Main",Toast.LENGTH_SHORT).show();
            }
        }

}