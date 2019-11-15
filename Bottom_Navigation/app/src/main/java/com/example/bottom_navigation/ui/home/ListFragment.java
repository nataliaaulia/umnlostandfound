package com.example.bottom_navigation.ui.home;

import com.example.bottom_navigation.ui.listItem.Product;
import com.example.bottom_navigation.ui.listItem.ProductAdapter;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_navigation.R;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    String placeName;
    ListFragment(String placeName) {
        this.placeName = placeName;
    }
    ListFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        TextView textView = root.findViewById(R.id.listPlaceName);
        if(placeName != null) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(placeName);
            textView.bringToFront();
        } else {
            textView.setVisibility(View.GONE);

        }
        List<Product> productList;

        //the recyclerview
        RecyclerView recyclerView;


        //getting the recyclerview from xml
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        recyclerView.setNestedScrollingEnabled(false);

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
        ProductAdapter adapter = new ProductAdapter(getActivity(), productList, false);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        return root;
    }
}

