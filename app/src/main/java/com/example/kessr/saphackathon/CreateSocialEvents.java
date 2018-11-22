package com.example.kessr.saphackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

public class CreateSocialEvents extends AppCompatActivity {
    ImageButton imageButton;
    ScrollView scrollViews;
    LinearLayout selectEventType;
    Spinner dropdown;
    int var = 1; // 1 (Social)/ 2 (Carpool)/ 3(Other)

    public void goBack(View view){ // to main screen (different activity)
        //TODO: go back to screen before
    }

    public void addImage(View view){
        //TODO: change image
        imageButton.setImageResource(R.drawable.event);
    }

    // After selecting event type
    public void goNext(View view){
        String text = dropdown.getSelectedItem().toString();
        if (text.equals("Social")){
            var = 1;
            scrollViews = findViewById(R.id.socialEvent);
        } else if (text.equals("Carpool")) {
            var = 2;
            scrollViews = findViewById(R.id.carpoolEvent);
        } else {
            var = 3;
            scrollViews = findViewById(R.id.otherEvent);
        }
        selectEventType.setVisibility(View.INVISIBLE);
        scrollViews.setVisibility(View.VISIBLE);

    }

    public void addEventImage(View view){
        imageButton.setImageResource(R.drawable.event);
    }

    public void goBackTwo(View view){ //go back to selecting event type
        selectEventType.setVisibility(View.VISIBLE);
        scrollViews.setVisibility(View.INVISIBLE);
    }

    // CREATED EVENT
    public void goNextTwo(View view){
        //TODO: Event is created. Add to Event List
        if (var==1) { //social event

        } else if (var==2){ //carpool

        }else if (var == 3){ //other

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_social_events);
        imageButton = findViewById(R.id.addImage);
        scrollViews = findViewById(R.id.socialEvent);
        selectEventType = findViewById(R.id.selectEventType);

        //get the spinner from the xml.
        dropdown = findViewById(R.id.dropDownMenu);
        //create a list of items for the spinner.
        String[] items = new String[]{"Social", "Carpool", "Others"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
    }
}
