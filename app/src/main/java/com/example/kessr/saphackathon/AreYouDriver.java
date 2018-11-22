package com.example.kessr.saphackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AreYouDriver extends AppCompatActivity {
    ImageButton needRide;
    ImageButton driver;

    public void needRide(View view){
        Intent intent = new Intent(getApplicationContext(), NeedRide.class);
        startActivityForResult(intent, 100);
    }

<<<<<<< HEAD
    public void amDriver(View view){
=======
    public void driver(View view){
>>>>>>> b5c67bcdad457d8ab5b48d866f7ccac2aa79053c
        Intent intent = new Intent(getApplicationContext(), AmDriver.class);
        startActivityForResult(intent, 100);
    }

<<<<<<< HEAD
=======

>>>>>>> b5c67bcdad457d8ab5b48d866f7ccac2aa79053c
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_are_you_driver);

        needRide = findViewById(R.id.riderButton);
        driver = findViewById(R.id.driverButton);
    }
}
