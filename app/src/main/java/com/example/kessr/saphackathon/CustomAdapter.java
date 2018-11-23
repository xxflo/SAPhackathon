package com.example.kessr.saphackathon;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<Object> {

    public CustomAdapter(@NonNull Context context, Object[] events) {
        super(context, R.layout.event_feed, events);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View customView = myInflater.inflate(R.layout.event_feed, parent, false);

        Event event = (Event)getItem(position);
        TextView titleText = (TextView)customView.findViewById(R.id.eventTitle);
        TextView startText = (TextView)customView.findViewById(R.id.eventStart);
        TextView endText = (TextView)customView.findViewById(R.id.eventEnd);
        TextView hostText = (TextView)customView.findViewById(R.id.eventHost);

        ImageView eventImage = (ImageView)customView.findViewById(R.id.eventImage);

        titleText.setText(event.getTitle());
        startText.setText("Start: "+event.getStart().toString());
        endText.setText("End: "+event.getEnd().toString());
        hostText.setText(event.getHostName());
        eventImage.setImageResource(R.drawable.saplogo);

        return customView;
    }
}
