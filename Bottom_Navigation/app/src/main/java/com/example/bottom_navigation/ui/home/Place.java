package com.example.bottom_navigation.ui.home;

public class Place {
    public String placeName;
    public int itemCount;
    public Place(String placeName, Integer itemCount) {
        this.placeName = placeName;
        this.itemCount = itemCount;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public int getItemCount() {
        return this.itemCount;
    }
}
