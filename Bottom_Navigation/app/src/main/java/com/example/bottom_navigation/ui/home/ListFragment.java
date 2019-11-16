package com.example.bottom_navigation.ui.home;

import com.example.bottom_navigation.ui.listItem.Product;
import com.example.bottom_navigation.ui.listItem.ProductAdapter;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_navigation.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    String placeName;
    Boolean isCompleteList = false;
    ProductAdapter adapter;
    RecyclerView recyclerView;

    public ArrayList<Product> foundItemList;
    public ArrayList<Product> lostItemList;

    ListFragment(String placeName) {
        this.placeName = placeName;
    }
    ListFragment() {

    }
    ListFragment(Boolean isCompleteList) {
        this.isCompleteList = true;
    }

    @Override
    public void onAttach (Context context) {
        super.onAttach(context);
        foundItemList = populateFoundItemList();
        lostItemList = populateLostItemList();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        TextView textView = root.findViewById(R.id.listPlaceName);
        ChipGroup chipGroup = root.findViewById(R.id.chipGroup);
        if(placeName != null) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(placeName);
            textView.bringToFront();
        } else {

            textView.setVisibility(View.GONE);
        }
        if(isCompleteList) {
            chipGroup.setVisibility(View.VISIBLE);
        } else {
            chipGroup.setVisibility(View.GONE);
        }
        //the recyclerview
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        recyclerView.setNestedScrollingEnabled(false);

        Chip lostChip = root.findViewById(R.id.lostChip);
        Chip foundChip = root.findViewById(R.id.foundChip);


        //creating recyclerview adapter
        adapter = new ProductAdapter(getActivity(), lostItemList, false);
        foundChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                productList = populateFoundItemList();
                adapter = new ProductAdapter(getActivity(), foundItemList, false);
                recyclerView.setAdapter(adapter);
            }
        });
        lostChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                productList = populateLostItemList();
                adapter = new ProductAdapter(getActivity(), lostItemList, false);
                recyclerView.setAdapter(adapter);
            }
        });
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        return root;
    }

    private ArrayList<Product> populateFoundItemList() {
        ArrayList<Product> productList;

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "Apple MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierra)",
                        "Silver Laptop, Heavy",
                        "UMN email : lee02157@umn.edu",
                        R.drawable.laptop_icon,
                        "Walter Library"));

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
                        R.drawable.phone_icon,
                        "Northrop"));

        productList.add(
                new Product(
                        4,
                        "Vans Beanie",
                        "Red with Roses",
                        "UMN email: aulia001@umn.edu",
                        R.drawable.beanie_icon));
        return productList;
    }

    private ArrayList<Product> populateLostItemList() {
        ArrayList<Product> productList;

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
        return productList;
    }
}

