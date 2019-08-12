package com.example.dsckiet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {

    FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences pref=getSharedPreferences("pref",MODE_PRIVATE);
        boolean firstStart=pref.getBoolean("firstStart",true);
        if(firstStart)
        {
            Intent intent=new Intent(this,WelcomeActivity.class);
            startActivity(intent);
        }

        fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();




    }
}
