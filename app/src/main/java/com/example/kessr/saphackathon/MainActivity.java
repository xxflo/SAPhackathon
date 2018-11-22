package com.example.kessr.saphackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String userEmail = null;
    private String userPassword = null;

    public void clickFunction(View button){
        this.userEmail = ((EditText)findViewById(R.id.emailText)).getText().toString();
        this.userPassword = ((EditText)findViewById(R.id.passwordText)).getText().toString();

        if(authenticateUser()){
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
    //TODO
    private boolean authenticateUser(){
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
