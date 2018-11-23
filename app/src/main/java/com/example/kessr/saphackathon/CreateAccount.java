package com.example.kessr.saphackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {


    private EditText userFullName;
    private EditText userEmailAddress;
    private EditText userPassword;
    private EditText userHomeAddress;
    private EditText userEmployeeNum;
    private EditText userTeam;

    public void backButton (View view){
        Intent returnIntent = new Intent();
        setResult(RESULT_CANCELED, returnIntent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        userFullName = findViewById(R.id.userFullName);
        userEmailAddress = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
        userHomeAddress = findViewById(R.id.userHomeAddress);
        userEmployeeNum = findViewById(R.id.userINumber);
        userTeam = findViewById(R.id.userTeam);
    }

    public void signUpUser(View view) {
        String emailStr = userEmailAddress.getText().toString().trim();
        String passwordStr = userPassword.getText().toString().trim();
        String fullNameStr = userFullName.getText().toString().trim();
        String homeAddressStr = userHomeAddress.getText().toString().trim();
        String employeeNumStr = userEmployeeNum.getText().toString().trim();
        String userTeamStr = userTeam.getText().toString().trim();

        if(TextUtils.isEmpty(emailStr)){
            //email is empty
            Toast.makeText(CreateAccount.this, "Please enter your email",Toast.LENGTH_LONG).show();
            //stopping execution further
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailStr).matches()) {
            Toast.makeText(CreateAccount.this, "Please enter a valid email",Toast.LENGTH_LONG).show();
            //stopping execution further
            return;
        }
        if (emailStr.equals("")) {
            Toast.makeText(CreateAccount.this, "Please enter an email address",Toast.LENGTH_LONG).show();
            //stopping execution further
            return;
        }
        if(TextUtils.isEmpty(passwordStr)){
            //email is empty
            Toast.makeText(CreateAccount.this, "Please enter password",Toast.LENGTH_LONG).show();
            //stopping execution further
            return;
        }
        if (passwordStr.length() < 6) {
            Toast.makeText(CreateAccount.this, "Please enter a password with 6 characters or longer",Toast.LENGTH_LONG).show();
            //stopping execution further
            return;
        }

        Toast.makeText(CreateAccount.this, "Sign Up Successful!", Toast.LENGTH_LONG).show();
        Intent activityChangeIntent = new Intent(CreateAccount.this, HomeNav.class);
        CreateAccount.this.startActivity(activityChangeIntent);
    }
}
