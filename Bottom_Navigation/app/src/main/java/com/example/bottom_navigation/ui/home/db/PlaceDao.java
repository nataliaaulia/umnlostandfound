package com.example.bottom_navigation.ui.home.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.OnConflictStrategy;

import java.util.List;

@Dao
public interface PlaceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Place place);

    @Query("DELETE FROM place_table")
    void deleteAll();

    @Query("SELECT * from place_table")
    LiveData<List<Place>> getPlaces();

    @Query("SELECT item_count from place_table WHERE place_name = :placeName")
    Integer getPlaceItemCount(String placeName);
}
