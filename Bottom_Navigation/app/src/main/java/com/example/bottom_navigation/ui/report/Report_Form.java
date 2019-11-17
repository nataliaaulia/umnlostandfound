package com.example.bottom_navigation.ui.report;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.bottom_navigation.R;
import com.example.bottom_navigation.ui.listItem.Product;
import com.example.bottom_navigation.ui.profile.ProfileFragment;

public class Report_Form extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    static String itemType;
    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report__form);

        final Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemType = "";
                Log.i("item", Integer.toString(position));
                switch(position) {
                    case 1:
                        itemType = "Phone";
                        image = R.drawable.phone_icon;
                        break;
                    case 2:
                        itemType = "Wallet";
                        image =  R.drawable.wallet_icon;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText descriptionField = findViewById(R.id.editText);

        Button reportButton = findViewById(R.id.reportButton);
        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = descriptionField.getText().toString();
                Product toAdd = new Product(2, itemType, description, null, image);
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

//    //get the spinner from the xml.
//    Spinner dropdown = findViewById(R.id.spinner);
//    //create a list of items for the spinner.
//    String[] items = new String[]{"1", "2", "three"};
//    //create an adapter to describe how the items are displayed, adapters are used in several places in android.
//    //There are multiple variations of this, but this is the basic variant.
//    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//    //set the spinners adapter to the previously created one.
//    dropdown.setAdapter(adapter);