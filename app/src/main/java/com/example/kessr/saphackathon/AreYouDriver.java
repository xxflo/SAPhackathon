package com.example.kessr.saphackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AreYouDriver extends AppCompatActivity {
    ImageButton needRide;

    public void needRide(View view){
        Intent intent = new Intent(getApplicationContext(), NeedRide.class);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_are_you_driver);

        needRide = findViewById(R.id.riderButton);
    }
}