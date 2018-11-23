package com.example.kessr.saphackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class NeedRide extends AppCompatActivity {

    int[] DRIVER_IMAGES = {R.drawable.usericon,R.drawable.usericon};
    String[] DRIVER_NAMES = {"Bob","Sue"};
    String[] DRIVER_DESCRIPTION = {"Bob leaves at 8am. etc etc","yeah"};
    LinearLayout linLay;
    ListView listView;
    boolean joined= false;
    LinearLayout buttons;

    public void backButton(View view){
        Intent returnIntent = new Intent();
        setResult(RESULT_CANCELED, returnIntent);
        finish();
    }

    public void backButton222(View view){
        linLay.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
        buttons.setVisibility(View.INVISIBLE);
    }

    public void lastNextButton(View view){
        // TODO: goto main screen
    }
    public void nextButton222(View view){
        //TODO: selected drivers. Joined carpool event
        listView.setVisibility(View.INVISIBLE);
        LinearLayout message2 = findViewById(R.id.message2);
        message2.setVisibility(View.VISIBLE);
        buttons.setVisibility(View.INVISIBLE);
        ImageButton last = findViewById(R.id.nextButtonLast);
        last.setVisibility(View.VISIBLE);
    }

    public void nextButton(View view){
        linLay = findViewById(R.id.linearLayout);
        linLay.setVisibility(View.INVISIBLE);

        if (DRIVER_NAMES.length == 0) {
            // TODO: ADD EVENT TO EVENT LIST//////////////
            LinearLayout message = findViewById(R.id.message);
            message.setVisibility(View.VISIBLE);
        }else{
            TextView textView = new TextView(this);
            textView.setText("List of Available Drivers");
            listView.addHeaderView(textView);
            listView.setVisibility(View.VISIBLE);
            buttons.setVisibility(View.VISIBLE);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_ride);
        buttons = findViewById(R.id.buttons);
        listView = findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setSelector(android.R.color.darker_gray);
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
