package com.example.bottom_navigation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
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
                Intent intent = new Intent(MainActivity.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public void validateInfo(String userEmail, String userPassword) {
        if((userEmail.equals("a")) && (userPassword.equals("1"))) {
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
            return;
        }

    }

}
