package com.example.bottom_navigation.ui.home;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bottom_navigation.ui.home.db.ItemLost;
import com.example.bottom_navigation.ui.home.db.Repository;

import java.util.List;

public class ListViewModel extends AndroidViewModel {
    private Repository mRepository;
    private LiveData<List<ItemLost>> mLostItems;

    public ListViewModel(Application application) {
        super(application);
        mRepository = new Repository(application);
        mLostItems = mRepository.getLostItems();
    }

    LiveData<List<ItemLost>> getLostItems() {
        return mLostItems;
    }
}
