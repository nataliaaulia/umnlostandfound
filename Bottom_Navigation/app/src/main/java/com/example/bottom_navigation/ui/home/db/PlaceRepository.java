package com.example.bottom_navigation.ui.home.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PlaceRepository {
    private PlaceDao mPlaceDao;
    private LiveData<List<Place>> mAllPlaces;

    public PlaceRepository(Application application) {
        LostAndFoundDB db = LostAndFoundDB.getDatabase((application));
        mPlaceDao = db.placeDao();
        mAllPlaces = mPlaceDao.getPlaces();
    }

    public int getPlaceCountByName(String placeName) {
        return mPlaceDao.getPlaceItemCount(placeName);
    }

    public LiveData<List<Place>> getAllPlaces() {
        return mAllPlaces;
    }

    public void insert (Place place) {
        new insertAsyncTask(mPlaceDao).execute(place);
    }

    private static class insertAsyncTask extends AsyncTask<Place, Void, Void> {

        private PlaceDao mAsyncTaskDao;

        insertAsyncTask(PlaceDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Place... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}


