package com.example.kessr.saphackathon;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
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
        boolean loginSuccess = false;

        loginSuccess = authenticateUser();
        if(loginSuccess){
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
            fade();
        }else{
            Toast.makeText(this, "Login Failed, please try again", Toast.LENGTH_SHORT).show();
        }

    }

    public void test(View button){
        Intent activityChangeIntent = new Intent(MainActivity.this, WeatherInformation.class);
        MainActivity.this.startActivity(activityChangeIntent);
    }

    private void fade(){
        ConstraintLayout cl = (ConstraintLayout)findViewById(R.id.parentLayout);
        cl.animate().alpha(0f).setDuration(1000);
    }

    public void createAccount(View button){
        Intent activityChangeIntent = new Intent(MainActivity.this, CreateAccount.class);
        MainActivity.this.startActivity(activityChangeIntent);
    }

    //TODO
    private boolean authenticateUser() throws RuntimeException{
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
