package com.example.bottom_navigation.ui.home.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    private PlaceDao mPlaceDao;
    private LiveData<List<Place>> mAllPlaces;

    private ItemLostDao mItemLostDao;
    private LiveData<List<ItemLost>> mLostItems;

    public Repository(Application application) {
        LostAndFoundDB db = LostAndFoundDB.getDatabase((application));
        mPlaceDao = db.placeDao();
        mAllPlaces = mPlaceDao.getPlaces();

        mItemLostDao = db.itemLostDao();
        mLostItems = mItemLostDao.getLostItems();
    }

    public int getPlaceCountByName(String placeName) {
        return mPlaceDao.getPlaceItemCount(placeName);
    }

    public LiveData<List<Place>> getAllPlaces() {
        return mAllPlaces;
    }

    public LiveData<List<ItemLost>> getLostItems() {
        return mLostItems;
    }

    public void insert (Place place) {
        new insertAsyncTask(mPlaceDao).execute(place);
    }

    public void insert (ItemLost itemLost) { new insertAsyncTask(mItemLostDao).execute(itemLost); }

    private static class insertAsyncTask extends AsyncTask<Object, Void, Void> {

        private PlaceDao mAsyncTaskPlaceDao;
        private ItemLostDao mAsyncTaskItemLostDao;

        insertAsyncTask(PlaceDao dao) {
            mAsyncTaskPlaceDao = dao;
        }
        insertAsyncTask(ItemLostDao dao) { mAsyncTaskItemLostDao = dao;}

        @Override
        protected Void doInBackground(final Object... params) {
            Object param = params[0];
            if (param instanceof Place) {
                Place place = (Place) param;
                mAsyncTaskPlaceDao.insert(place);
            } else if (param instanceof  ItemLost) {
                ItemLost itemLost = (ItemLost) param;
                mAsyncTaskItemLostDao.insert(itemLost);
            }
            return null;
        }
    }
}


