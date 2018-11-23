package com.example.kessr.saphackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class HelpDecisionMaking extends AppCompatActivity {
    ImageButton button;

    public void backButton(View view){
        Intent returnIntent = new Intent();
        setResult(RESULT_CANCELED, returnIntent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_decision_making);
        button = findViewById(R.id.backButton);
    }
}
