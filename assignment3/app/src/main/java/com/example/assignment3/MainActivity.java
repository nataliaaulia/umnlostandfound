package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.umnlostandfound";

    //a list to store all the products
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "Apple MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierra)",
                        "Silver Laptop, Heavy",
                        "UMN email : lee02157@umn.edu",
                        R.drawable.laptop_icon));

        productList.add(
                new Product(
                        2,
                        "Leather Wallet (Brown Colored)",
                        "A size of an elephant",
                        "UMN email : barnh043@umn.edu",
                        R.drawable.wallet_icon));

        productList.add(
                new Product(
                        3,
                        "iPhone XR",
                        "Silver, 1.35 kg",
                        "UMN email: aulia001@umn.edu",
                        R.drawable.phone_icon));

        productList.add(
                new Product(
                        4,
                        "Vans Beanie",
                        "Red with Roses",
                        "UMN email: aulia001@umn.edu",
                        R.drawable.beanie_icon));

        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.button);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
