package com.example.kessr.saphackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class NeedRide extends AppCompatActivity {

    int[] DRIVER_IMAGES = {R.drawable.usericon};
    String[] DRIVER_NAMES = {"Bob"};
    String[] DRIVER_DESCRIPTION = {"Bob is planning to leave at 8am. Meet at lobby, etc etc"};
    LinearLayout linLay;
    ListView listView;


    public void nextButton(View view){
        linLay = findViewById(R.id.linearLayout);
        linLay.setVisibility(View.INVISIBLE);

        if (DRIVER_NAMES.length == 0) {
            LinearLayout message = findViewById(R.id.message);
            message.setVisibility(View.VISIBLE);
            // TODO: ADD EVENT TO EVENT LIST//////////////
        }else{
            TextView textView = new TextView(this);
            textView.setText("List of Available Drivers");
            listView.addHeaderView(textView);
            listView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_ride);

        listView = (ListView)findViewById(R.id.listView);

        //TODO: get driver info from database here and add to DRIVER_IMAGES DRIVER_NAMES DRIVER_DESC

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return DRIVER_NAMES.length;
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

            imageView.setImageResource(DRIVER_IMAGES[i]);
            textView_name.setText(DRIVER_NAMES[i]);
            textView_desc.setText(DRIVER_DESCRIPTION[i]);

            return view;
        }
    }
}
