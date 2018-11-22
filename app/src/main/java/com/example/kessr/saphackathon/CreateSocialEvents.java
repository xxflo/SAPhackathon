package com.example.kessr.saphackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CreateSocialEvents extends AppCompatActivity {
    ImageButton imageButton;

    public void addEventImage(View view){
        imageButton.setImageResource(R.drawable.event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_social_events);
        imageButton = findViewById(R.id.addImage);
    }
}
