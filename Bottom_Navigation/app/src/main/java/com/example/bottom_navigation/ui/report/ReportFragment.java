package com.example.bottom_navigation.ui.report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.bottom_navigation.R;

public class ReportFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_report, container, false);

        final Button btn = (Button) root.findViewById(R.id.lostButton);
        final Button btn2 = (Button) root.findViewById(R.id.foundButton);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                LostFragment lostFrag = new LostFragment(btn, btn2);
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
                FoundFragment founFrag = new FoundFragment(btn, btn2);
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

