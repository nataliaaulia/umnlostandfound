package com.example.bottom_navigation.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_navigation.R;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    public static final String EXTRA_MESSAGE = "com.example.umnlostandfound";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //a list to store all the products
        List<Product> productList;

        //the recyclerview
        RecyclerView recyclerView;

        View root = inflater.inflate(R.layout.fragment_list, container, false);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

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
        ProductAdapter adapter = new ProductAdapter(getActivity(), productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

//        Button mButton = (Button) root.findViewById(R.id.button);
//        mButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                startActivity(new Intent(ListFragment.this, Report_Form.class));
//            }
//        });
        return root;
    }
}
