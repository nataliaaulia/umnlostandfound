package com.example.bottom_navigation.ui.home;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bottom_navigation.R;
import com.example.bottom_navigation.ui.profile.ProfileFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HostListFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.host_list_fragment, container, false);
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager_list);
        setupViewPager(viewPager);
        final TabLayout tabs = (TabLayout) view.findViewById(R.id.list_tabs);
//        tabs.setupWithViewPager(viewPager);
        tabs.post(new Runnable() {
            @Override
            public void run() {
                tabs.setupWithViewPager(viewPager);
            }
        });
        return view;
    }


    private void setupViewPager(ViewPager viewPager) {
        ListAdapter adapter = new ListAdapter(getChildFragmentManager());
        adapter.addFragment(new ProfileFragment(), "Lost Items");
        adapter.addFragment(new ListFragment(), "Found Items");
        viewPager.setAdapter(adapter);
    }

    private class ListAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        private ListAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
