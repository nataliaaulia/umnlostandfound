package com.example.bottom_navigation.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.bottom_navigation.R;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent=getIntent();
        String message=intent.getStringExtra(ListFragment.EXTRA_MESSAGE);

        TextView textView=(TextView)findViewById(R.id.textView2);
        textView.setText(message);
    }

}
