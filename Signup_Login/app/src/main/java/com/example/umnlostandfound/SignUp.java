package com.example.umnlostandfound;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    public EditText mFirst, mLast, mEmail, mPassword, mConfirm;
    public Button mSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        mFirst = (EditText) findViewById(R.id.firstName);
        mLast = (EditText) findViewById(R.id.lastName);
        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        mConfirm = (EditText) findViewById(R.id.confirmPassword);

        mSignUp = (Button) findViewById(R.id.signup);

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateInfo(mFirst.getText().toString(), mLast.getText().toString(), mEmail.getText().toString(), mPassword.getText().toString(), mConfirm.getText().toString());
                Intent intent = new Intent(SignUp.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void validateInfo(String firstName, String lastName, String email, String password, String confirmPass) {
        if((firstName.equals("Natalia")) && (lastName.equals("Aulia")) && (email.equals("aulia001@umn.edu")) && (password.equals("1234")) && (confirmPass.equals("1234"))) {
            Intent intent = new Intent(SignUp.this, HomePage.class);
            startActivity(intent);
            finish();
        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter an email address", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter a password", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName)) {
            Toast.makeText(getApplicationContext(), "Enter your name", Toast.LENGTH_LONG).show();
            return;
        }

        if(password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password is too short!", Toast.LENGTH_LONG).show();
            return;
        }

        if(password != confirmPass) {
            Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_LONG).show();
            return;
        }

    }
}
