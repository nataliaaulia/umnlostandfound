package com.example.bottom_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottom_navigation.ui.home.HomeFragment;
import com.example.bottom_navigation.ui.information.InformationFragment;
import com.example.bottom_navigation.ui.profile.ProfileFragment;
import com.example.bottom_navigation.ui.report.ReportFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {
    final Fragment homeFragment = new HomeFragment();
    final Fragment reportFragment = new ReportFragment();
    final Fragment infoFragment = new InformationFragment();
    final Fragment profileFragment = new ProfileFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = homeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        fm.beginTransaction().add(R.id.nav_host_fragment, reportFragment, "report").hide(reportFragment).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, infoFragment, "info").hide(infoFragment).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, profileFragment, "profile").hide(profileFragment).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, homeFragment, "home").commit();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fm.beginTransaction().hide(active).show(homeFragment).commit();
                    active = homeFragment;
                    return true;
                case R.id.navigation_report:
                    fm.beginTransaction().hide(active).show(reportFragment).commit();
                    active = reportFragment;
                    return true;
                case R.id.navigation_information:
                    fm.beginTransaction().hide(active).show(infoFragment).commit();
                    active = infoFragment;
                    return true;
                case R.id.navigation_profile:
                    fm.beginTransaction().hide(active).show(profileFragment).commit();
                    active = profileFragment;
                    return true;
            }
            return false;
        }
    };
}
