package com.example.kessr.saphackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class AmDriver extends AppCompatActivity {
    ScrollView scrollView;
    LinearLayout buttons;
    TextView createdMsg;
    ImageButton lastButton;
    int[] RIDER_IMAGES = {R.drawable.usericon, R.drawable.usericon};
    String[] RIDER_NAMES = {"Alice","Tim"};
    String[] RIDER_DESCRIPTION = {"Alice to leave at 8am.","Tim Hortons"};
    ListView listOfPeople;

    public void lastNextButton(View view){
        // TODO: goto main screen
    }

    public void goBack(View view){
        scrollView.setVisibility(View.VISIBLE);
        listOfPeople.setVisibility(View.INVISIBLE);
        buttons.setVisibility(View.INVISIBLE);
    }

    public void goNext(View view){
        Log.i("info","hi");
        //TODO: selected drivers. Joined carpool event
        listOfPeople.setVisibility(View.INVISIBLE);
        createdMsg.setVisibility(View.VISIBLE);
        buttons.setVisibility(View.INVISIBLE);
        lastButton.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_am_driver);
        lastButton = findViewById(R.id.nextButtonLast2);
        scrollView = findViewById(R.id.linLay);
        buttons = findViewById(R.id.pleaseWork);
        createdMsg = findViewById(R.id.created);
        listOfPeople = findViewById(R.id.listView);
        listOfPeople.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listOfPeople.setSelector(android.R.color.darker_gray);
        //TODO: get driver info from database here and add to DRIVER_IMAGES DRIVER_NAMES DRIVER_DESC
        CustomAdapter customAdapter = new CustomAdapter();
        listOfPeople.setAdapter(customAdapter);
    }

    public void backButton(View view){
        Intent returnIntent = new Intent();
        setResult(RESULT_CANCELED, returnIntent);
        finish();
    }

    public void nextButton(View view){
        scrollView.setVisibility(View.INVISIBLE);
        //todo: save the driver info into the database
        //todo: check in mysql database whether there are passengers whose destination is within the specified radius
        //todo: if passengers > 0, populate the passengers in need page(info: time leaving, distance from you); set event listeners for passengers selected; press ok

        if (RIDER_NAMES.length == 0) {
            createdMsg.setVisibility(View.VISIBLE);
            lastButton.setVisibility(View.VISIBLE);
            // TODO: ADD EVENT TO EVENT LIST//////////////
        }else{
            TextView textView = new TextView(this);
            textView.setText("Passengers in Need");
            listOfPeople.addHeaderView(textView);
            listOfPeople.setVisibility(View.VISIBLE);
            buttons.setVisibility(View.VISIBLE);
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
