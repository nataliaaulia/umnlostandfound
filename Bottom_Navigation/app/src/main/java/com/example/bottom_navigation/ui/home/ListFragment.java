package com.example.bottom_navigation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bottom_navigation.R;

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
        if(placeName != null) {
            TextView textView = root.findViewById(R.id.textView);
            textView.setText(placeName);
        }
        return root;
    }
}
