package com.example.bottom_navigation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bottom_navigation.R;
import com.example.bottom_navigation.ui.home.db.ItemLost;
import com.example.bottom_navigation.ui.home.db.Place;

import java.util.List;

public class ListFragment extends Fragment {
    List<ItemLost> mLostItems;
    ListViewModel listViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listViewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        listViewModel.getLostItems().observe(getViewLifecycleOwner(),  new Observer<List<ItemLost>>() {
            @Override
            public void onChanged(List<ItemLost> itemLost) {
                mLostItems = itemLost;
            }
        });
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

}
