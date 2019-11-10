package com.example.bottom_navigation.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bottom_navigation.R;
import com.example.bottom_navigation.ui.home.db.Place;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    SupportMapFragment mapFragment;
    MapViewModel mapViewModel;
    List<Place> mAllPlaces;
    Map<String, Integer> placesMap;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_map, container, false);
        mapViewModel = ViewModelProviders.of(this).get(MapViewModel.class);
        mapViewModel.getAllPlaces().observe(getViewLifecycleOwner(),  new Observer<List<Place>>() {
            @Override
            public void onChanged(List<Place> places) {
                mAllPlaces = places;
                placesMap = new HashMap<String,Integer>();
                for (Place i : places) placesMap.put(i.getPlaceName(),i.getItemCount());
            }
        });
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

        LatLng coffman = new LatLng(44.9728134, -93.2353374);
        mMap.addMarker(new MarkerOptions().position(coffman).title("22")).showInfoWindow();
        LatLng umn = new LatLng(44.973086, -93.2370881);
        mMap.setOnPoiClickListener(new GoogleMap.OnPoiClickListener() {
            @Override
            public void onPoiClick(PointOfInterest pointOfInterest) {
                Log.i("name", pointOfInterest.name);
                Log.i("id", pointOfInterest.placeId);
                Integer count = placesMap.get(pointOfInterest.name);
                Random r = new Random();
                int rInt = r.nextInt(50);
                String countStr = Integer.toString(rInt);
                if(count!=null) {
                    countStr = count.toString();
                } else {
                    mapViewModel.insert(new Place(pointOfInterest.name, rInt));
                }
                mMap.addMarker(new MarkerOptions().position(pointOfInterest.latLng).title(countStr)).showInfoWindow();
            }
        });

        mMap.moveCamera(CameraUpdateFactory.newLatLng(coffman));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
    }
}
