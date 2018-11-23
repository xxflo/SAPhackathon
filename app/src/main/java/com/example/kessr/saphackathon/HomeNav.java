package com.example.kessr.saphackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;

public class HomeNav extends AppCompatActivity {

    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;

    Button button3;
    Button button4;
    Button button5;

    LinearLayout bottomLinLay;
    LinearLayout navbar;

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
        setContentView(R.layout.activity_home_nav);

        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);

        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        bottomLinLay = findViewById(R.id.bottomLinLay);
        navbar = findViewById(R.id.navbar);

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

        textView5.setVisibility(View.VISIBLE);
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        textView8.setVisibility(View.VISIBLE);

        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button5.setVisibility(View.VISIBLE);

        bottomLinLay.setVisibility(View.VISIBLE);
        navbar.setVisibility(View.VISIBLE);

        event1.setVisibility(View.VISIBLE);
        event1Image.setVisibility(View.VISIBLE);
        event1Name.setVisibility(View.VISIBLE);

    }

    public void funDayEvent(View view){

        textView5.setVisibility(View.VISIBLE);
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        textView8.setVisibility(View.VISIBLE);

        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button5.setVisibility(View.VISIBLE);

        bottomLinLay.setVisibility(View.VISIBLE);
        navbar.setVisibility(View.VISIBLE);

        event2.setVisibility(View.VISIBLE);
        event2Image.setVisibility(View.VISIBLE);
        event2Name.setVisibility(View.VISIBLE);
    }

    public void funDayCarPool(View view){

        textView5.setVisibility(View.VISIBLE);
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        textView8.setVisibility(View.VISIBLE);

        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button5.setVisibility(View.VISIBLE);

        bottomLinLay.setVisibility(View.VISIBLE);
        navbar.setVisibility(View.VISIBLE);

        event3.setVisibility(View.VISIBLE);
        event3Image.setVisibility(View.VISIBLE);
        event3Name.setVisibility(View.VISIBLE);

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
