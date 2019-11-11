package com.example.bottom_navigation.ui.home.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item_lost_table")
public class ItemLost {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "item_id")
    public int itemId;

    @ColumnInfo(name = "item_name")
    public String name;

    @ColumnInfo(name = "item_description")
    public String description;

    @ColumnInfo(name = "contact_email")
    private String email;

    public ItemLost(String name, String description, String email) {
        this.name = name;
        this.description = description;
        this.email = email;
    }

    public int getItemId() {
        return this.itemId;
    }

    public String getItemName() {
        return this.name;
    }

    public String getItemDescription() {
        return this.description;
    }

    public String getEmail() { return this.email; }
}
