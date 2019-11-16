package com.example.bottom_navigation.ui.report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

        Button btn = (Button) root.findViewById(R.id.lostButton);
        Button btn2 = (Button) root.findViewById(R.id.foundButton);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LostFragment lostFrag = new LostFragment();
                FragmentTransaction ft = getFragmentManager()
                getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.report_fragment, lostFrag)
                .addToBackStack(null)
                .commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.report_fragment, new FoundFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return root;
    }
}

