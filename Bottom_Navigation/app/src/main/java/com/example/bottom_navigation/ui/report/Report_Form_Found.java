package com.example.bottom_navigation.ui.report;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.example.bottom_navigation.R;
import com.example.bottom_navigation.ui.listItem.Product;
import com.example.bottom_navigation.ui.profile.ProfileFragment;

public class Report_Form_Found extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    static String itemTypeFound;
    int imageFound;
    static String locationFieldValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_form_found);

        final Spinner spinner = findViewById(R.id.itemTypeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemTypeFound = "";
                switch(position) {
                    case 1:
                        itemTypeFound = "Phone";
                        imageFound = R.drawable.phone_icon;
                        break;
                    case 2:
                        itemTypeFound = "Wallet";
                        imageFound =  R.drawable.wallet_icon;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Spinner spinner2 = findViewById(R.id.locationSpinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.locations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                locationFieldValue = "";
                switch(position) {
                    case 1:
                        locationFieldValue = "Memorial Union";
                        break;
                    case 2:
                        locationFieldValue = "Keller Hall";
                        break;
                    case 3:
                        locationFieldValue = "Nakamura Center";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final EditText descriptionField = findViewById(R.id.descEditText);
        Button reportButton = findViewById(R.id.reportButtonFound);
        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = descriptionField.getText().toString();
                Product toAdd = new Product(2, itemTypeFound, description, null, imageFound, locationFieldValue);
                ProfileFragment profileFrag = new ProfileFragment();
                profileFrag.getProductList().add(toAdd);
                Toast.makeText(getApplicationContext(), "Successfully created report!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
