package com.example.kessr.saphackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeNav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_nav);
    }

    public void carPoolEvent(View view){

    }

    public void funDayEvent(View view){

    }

    public void funDayCarPool(View view){


    }

    public void goHome(View view){
        Intent intent = new Intent(getApplicationContext(), HomeNav.class);
        startActivityForResult(intent, 100);
    }

    public void goDashBoard(View view){
        Intent intent = new Intent(getApplicationContext(), HelpDecisionMaking.class);
        startActivityForResult(intent, 100);
    }

    public void goUserAccount(View view){
        Intent intent = new Intent(getApplicationContext(), UserEvents.class);
        startActivityForResult(intent, 100);
    }

    public void createEvent(View view){
        Intent intent = new Intent(getApplicationContext(), CreateSocialEvents.class);
        startActivityForResult(intent, 100);
    }
}
