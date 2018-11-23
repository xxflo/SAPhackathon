package com.example.kessr.saphackathon;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.sql.Time;
import java.util.ArrayList;

public class MainFeedPage extends AppCompatActivity {

    private EventManager eventManager;
    public void createEvent(View view){
        Intent activityChangeIntent = new Intent(MainFeedPage.this, CreateEvent.class);
        MainFeedPage.this.startActivity(activityChangeIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ArrayList<Event> events = new ArrayList<Event>();

        for(int i = 0; i<5; i++){
            Event event = new Event("Event"+Integer.toString(i), new Time(i), new Time(i), "Car Pool", "John Doe");
            events.add(event);
        }
        eventManager = new EventManager(events);

        Object[] events1 = events.toArray();
        ListAdapter myAdaptor = new CustomAdapter(this, events1);
        ListView myListView = (ListView) findViewById(R.id.eventFeedView);
        myListView.setAdapter(myAdaptor);


    }


}
