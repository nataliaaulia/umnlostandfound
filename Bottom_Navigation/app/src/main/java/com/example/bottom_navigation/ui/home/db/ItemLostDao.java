package com.example.bottom_navigation.ui.home.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemLostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ItemLost itemLost);

    @Query("DELETE FROM item_lost_table")
    void deleteAll();

    @Query("SELECT * from item_lost_table")
    LiveData<List<ItemLost>> getLostItems();
}
