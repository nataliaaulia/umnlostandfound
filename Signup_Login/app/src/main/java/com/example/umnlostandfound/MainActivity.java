package com.example.umnlostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button mLogIn;
    public EditText mEmail, mPassword;
    public TextView mSignUpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLogIn = (Button) findViewById(R.id.login);
        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        mSignUpText = (TextView) findViewById(R.id.signuptext);

        mSignUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
                finish();
            }
        });

        mLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateInfo(mEmail.getText().toString(), mPassword.getText().toString());
            }
        });


    }

    public void validateInfo(String userEmail, String userPassword) {
        if((userEmail.equals("aulia001@umn.edu")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(MainActivity.this, HomePage.class);
            startActivity(intent);
            finish();
        }

        if (TextUtils.isEmpty(userEmail)) {
            Toast.makeText(getApplicationContext(), "Enter an email address", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(userPassword)) {
            Toast.makeText(getApplicationContext(), "Enter a password", Toast.LENGTH_LONG).show();
        }

        if(userPassword.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password is too short!", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
