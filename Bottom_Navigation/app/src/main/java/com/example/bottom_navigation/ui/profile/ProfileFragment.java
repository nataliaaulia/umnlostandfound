package com.example.bottom_navigation.ui.profile;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_navigation.R;
import com.example.bottom_navigation.ui.listItem.Product;
import com.example.bottom_navigation.ui.listItem.ProductAdapter;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    public static ArrayList<Product> productList;
    ProductAdapter adapter;
    RecyclerView recyclerView;

    @Override
    public void onAttach(Context ctx) {
        super.onAttach(ctx);
        this.productList = populateProductList();
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    private ArrayList<Product> populateProductList() {
        ArrayList<Product> list = new ArrayList<>();
        //adding some items to our list
        list.add(
                new Product(
                        1,
                        "Apple MacBook Air Core i5 5th Gen",
                        "Silver Laptop, Heavy",
                        null,
                        R.drawable.laptop_icon));
        return list;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));

        adapter = new ProductAdapter(getActivity(), productList, true);

        recyclerView.setAdapter(adapter);
        return root;
    }
}
