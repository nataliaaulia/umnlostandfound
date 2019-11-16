package com.example.bottom_navigation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.bottom_navigation.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<Place> allPlaces;
    Map<String, Integer> placesMap;

    SupportMapFragment mapFragment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_map, container, false);
        allPlaces = new ArrayList<>();
        allPlaces.add(new Place("Walter Library", 1));
        allPlaces.add(new Place("Frederick R. Weisman", 1));
        allPlaces.add(new Place("Vincent Hall", 1));
        allPlaces.add(new Place("Malcolm Moos Health", 1));
        allPlaces.add(new Place("Northrop", 1));

        placesMap = new HashMap<String,Integer>();
        for (Place i : allPlaces) placesMap.put(i.getPlaceName(),i.getItemCount());

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

        LatLng umn = new LatLng(44.973086, -93.2370881);

        mMap.setOnPoiClickListener(new GoogleMap.OnPoiClickListener() {
            @Override
            public void onPoiClick(PointOfInterest pointOfInterest) {
                Integer count = placesMap.get(pointOfInterest.name);
                String countStr = Integer.toString(1);
                if(count!=null) {
                    countStr = count.toString();
                } else {
                    Place toAdd = new Place(pointOfInterest.name, 1);
                    allPlaces.add(toAdd);
                    placesMap.put(toAdd.placeName, toAdd.itemCount);
                }
                Marker marker = mMap.addMarker(new MarkerOptions().position(pointOfInterest.latLng).title(countStr));
                marker.showInfoWindow();
                marker.setTag(pointOfInterest.name);
            }
        });
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                ListFragment listFrag = new ListFragment(marker.getTag().toString());
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, listFrag, "Halo")
                        .addToBackStack(null)
                        .commit();
//                getActivity().getSupportFragmentManager().executePendingTransactions();
            }
        });
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coffman));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
    }
}
