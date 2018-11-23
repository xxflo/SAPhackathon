package com.example.kessr.saphackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class UserEvents extends AppCompatActivity {

    Button editSettings;
    ImageView eventsTitle;
    LinearLayout topLinLay;
    LinearLayout bottomLinLay;

    ScrollView event1;
    ImageView event1Image;
    TextView event1Name;

    ScrollView event2;
    ImageView event2Image;
    TextView event2Name;

    ScrollView event3;
    ImageView event3Image;
    TextView event3Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_events);

        editSettings = findViewById(R.id.edit_setting);
        eventsTitle = findViewById(R.id.events_title);
        topLinLay = findViewById(R.id.topLinLay);
        bottomLinLay = findViewById(R.id.bottomLinLay);

        event1 = findViewById(R.id.carPoolEvent);
        event1Image = findViewById(R.id.event1Image);
        event1Name = findViewById(R.id.event1Name);

        event2 = findViewById(R.id.funDayEvent);
        event2Image = findViewById(R.id.event2Image);
        event2Name = findViewById(R.id.event2Name);

        event3 = findViewById(R.id.funDayCarPool);
        event3Image = findViewById(R.id.event3Image);
        event3Name = findViewById(R.id.event3Name);

    }

    public void carPoolEvent(View view){
        editSettings.setVisibility(View.INVISIBLE);
        eventsTitle.setVisibility(View.INVISIBLE);
        topLinLay.setVisibility(View.INVISIBLE);
        bottomLinLay.setVisibility(View.INVISIBLE);

        event1.setVisibility(View.VISIBLE);
        event1Image.setVisibility(View.VISIBLE);
        event1Name.setVisibility(View.VISIBLE);

    }

    public void funDayEvent(View view){
        editSettings.setVisibility(View.INVISIBLE);
        eventsTitle.setVisibility(View.INVISIBLE);
        topLinLay.setVisibility(View.INVISIBLE);
        bottomLinLay.setVisibility(View.INVISIBLE);

        event2.setVisibility(View.VISIBLE);
        event2Image.setVisibility(View.VISIBLE);
        event2Name.setVisibility(View.VISIBLE);

    }

    public void funDayCarPool(View view){

        editSettings.setVisibility(View.INVISIBLE);
        eventsTitle.setVisibility(View.INVISIBLE);
        topLinLay.setVisibility(View.INVISIBLE);
        bottomLinLay.setVisibility(View.INVISIBLE);

        event3.setVisibility(View.VISIBLE);
        event3Image.setVisibility(View.VISIBLE);
        event3Name.setVisibility(View.VISIBLE);

    }
}
