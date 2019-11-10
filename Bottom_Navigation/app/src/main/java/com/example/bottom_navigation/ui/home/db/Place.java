package com.example.bottom_navigation.ui.home.db;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "place_table")
public class Place {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "place_id")
    public int placeId;

    @ColumnInfo(name = "place_name")
    private String placeName;

    @ColumnInfo(name = "item_count")
    private int itemCount;

    public Place(String placeName, Integer itemCount) {
        this.placeName = placeName;
        this.itemCount = itemCount;
    }

    public int getPlaceId() {
        return this.placeId;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public int getItemCount() {
        return this.itemCount;
    }
}
