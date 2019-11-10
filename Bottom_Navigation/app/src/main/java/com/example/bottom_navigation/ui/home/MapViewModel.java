package com.example.bottom_navigation.ui.home;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bottom_navigation.ui.home.db.Place;
import com.example.bottom_navigation.ui.home.db.PlaceRepository;

import java.util.List;

public class MapViewModel extends AndroidViewModel {
    private PlaceRepository mRepository;
    private LiveData<List<Place>> mAllPlaces;

    public MapViewModel(Application application) {
        super(application);
        mRepository = new PlaceRepository(application);
        mAllPlaces = mRepository.getAllPlaces();
    }

    LiveData<List<Place>> getAllPlaces() {
        return mAllPlaces;
    }

    public int getCountByName(String placeName) {
        return mRepository.getPlaceCountByName(placeName);
    }

    public void insert(Place place) {
        mRepository.insert(place);
    }
}
