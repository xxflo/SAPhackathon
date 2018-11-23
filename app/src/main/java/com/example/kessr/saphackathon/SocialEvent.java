package com.example.kessr.saphackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class SocialEvent extends AppCompatActivity implements Event{

    ArrayList<Event> subevents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_event);

        Intent intent = getIntent();
        HashMap<String,String> data = (HashMap<String, String>) intent.getSerializableExtra("data");
        TextView eventName = (TextView)findViewById(R.id.eventName);
        eventName.setText("  "+data.get("event_name"));
        TextView description = (TextView)findViewById(R.id.Description);
        description.setText("  "+data.get("event_desc"));
        TextView location = (TextView)findViewById(R.id.Location);
        location.setText("  "+ data.get("event_location"));
        TextView time = (TextView)findViewById(R.id.Time);
        time.setText("  "+ data.get("event_time"));


    }

    public void goBackToCreate(View view){
        Intent intent = new Intent(getApplicationContext(), CreateSocialEvents.class);
        startActivityForResult(intent, 100);
    }
}
