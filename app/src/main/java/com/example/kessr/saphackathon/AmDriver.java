package com.example.kessr.saphackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class AmDriver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_am_driver);

        listView = (ListView)findViewById(R.id.listView);

        //TODO: get driver info from database here and add to DRIVER_IMAGES DRIVER_NAMES DRIVER_DESC

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    int[] RIDER_IMAGES = {R.drawable.usericon};
    String[] RIDER_NAMES = {"Alice"};
    String[] RIDER_DESCRIPTION = {"Alice to leave at 8am."};
    LinearLayout layout;
    ListView listView;


    public void nextButton(View view){

        layout = findViewById(R.id.linearLayout);
        layout.setVisibility(View.INVISIBLE);

        //todo: save the driver info into the database

        //todo: check in mysql database whether there are passengers whose destination is within the specified radius

        //todo: if passengers > 0, populate the passengers in need page(info: time leaving, distance from you); set event listeners for passengers selected; press ok

        if (RIDER_NAMES.length == 0) {
            LinearLayout message = findViewById(R.id.message);
            message.setVisibility(View.VISIBLE);
            // TODO: ADD EVENT TO EVENT LIST//////////////
        }else{
            TextView textView = new TextView(this);
            textView.setText("Passengers in Need");
            listView.addHeaderView(textView);
            listView.setVisibility(View.VISIBLE);
        }

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return RIDER_NAMES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout,null);
            ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
            TextView textView_name = (TextView)view.findViewById(R.id.textView_name);
            TextView textView_desc = (TextView)view.findViewById(R.id.textView_description);

            imageView.setImageResource(RIDER_IMAGES[i]);
            textView_name.setText(RIDER_NAMES[i]);
            textView_desc.setText(RIDER_DESCRIPTION[i]);

            return view;
        }
    }
}
