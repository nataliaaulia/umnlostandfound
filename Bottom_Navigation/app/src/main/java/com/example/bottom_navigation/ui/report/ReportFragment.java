package com.example.bottom_navigation.ui.report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bottom_navigation.R;
import com.example.bottom_navigation.ui.home.ListFragment;

public class ReportFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_report, container, false);

        final Button btn = (Button) root.findViewById(R.id.lostButton);
        final Button btn2 = (Button) root.findViewById(R.id.foundButton);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                LostFragment lostFrag = new LostFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.report_fragment, lostFrag)
                .addToBackStack(null)
                .commit();
                btn.setVisibility(View.GONE);
                btn2.setVisibility(View.GONE);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoundFragment founFrag = new FoundFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.report_fragment, founFrag)
                        .addToBackStack(null)
                        .commit();
                btn.setVisibility(View.GONE);
                btn2.setVisibility(View.GONE);
            }
        });

        return root;
    }
}

