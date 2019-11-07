package com.example.bottom_navigation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bottom_navigation.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    SupportMapFragment mapFragment;
    private Marker marker;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_map, container, false);
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        if(mapFragment == null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
        return root;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng coffman = new LatLng(44.9728134,-93.2353374);
        mMap.addMarker(new MarkerOptions().position(coffman).title("1")).showInfoWindow();
        //LatLng umn = new LatLng(44.973086, -93.2370881);
        mMap.setOnPoiClickListener(new GoogleMap.OnPoiClickListener() {
            //@Override
            int count = 1;

            public void onPoiClick(PointOfInterest pointOfInterest) {
//                for (int i = 1; i < 10000; i++){
//                    mMap.addMarker(new MarkerOptions().position(pointOfInterest.latLng).title(Integer.toString(i))).showInfoWindow();
//                }
                count++;
                marker = mMap.addMarker(new MarkerOptions().position(pointOfInterest.latLng).title(Integer.toString(count)));
                marker.setTag(count);
            }
        });

        mMap.moveCamera(CameraUpdateFactory.newLatLng(coffman));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
    }
}
