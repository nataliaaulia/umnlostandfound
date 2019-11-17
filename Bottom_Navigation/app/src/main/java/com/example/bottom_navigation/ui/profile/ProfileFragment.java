package com.example.bottom_navigation.ui.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_navigation.R;
import com.example.bottom_navigation.ui.listItem.Product;
import com.example.bottom_navigation.ui.listItem.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private Uri resultUri;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        RecyclerView recyclerView;

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        //recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));

        List<Product> list = new ArrayList<>();

        //adding some items to our list
        list.add(
                new Product(
                        1,
                        "Apple MacBook Air Core i5 5th Gen",
                        "Silver Laptop, Heavy",
                        "UMN email : lee02157@umn.edu",
                        R.drawable.laptop_icon));


        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(getActivity(), list, true);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        ImageView mProfileImg = root.findViewById(R.id.profileimg);
        mProfileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });

        return root;
    }
}
