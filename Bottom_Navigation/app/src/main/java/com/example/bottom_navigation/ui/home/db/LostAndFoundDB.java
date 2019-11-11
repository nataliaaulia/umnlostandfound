package com.example.bottom_navigation.ui.home.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Place.class, ItemLost.class}, version = 1)
public abstract class LostAndFoundDB extends RoomDatabase {
    public abstract  PlaceDao placeDao();
    public abstract ItemLostDao itemLostDao();
    private static volatile LostAndFoundDB INSTANCE;
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
    static LostAndFoundDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LostAndFoundDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LostAndFoundDB.class, "lostandfound_db").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final PlaceDao mPlaceDao;
        private final ItemLostDao mItemLostDao;

        PopulateDbAsync(LostAndFoundDB db) {
            mPlaceDao = db.placeDao();
            mItemLostDao = db.itemLostDao();
        }

        protected Void populatePlaceTable() {
            mPlaceDao.deleteAll();
            Place place = new Place("Walter Library", 20);
            mPlaceDao.insert(place);
            place = new Place("Frederick R. Weisman", 10);
            mPlaceDao.insert(place);
            place = new Place("Vincent Hall", 5);
            mPlaceDao.insert(place);
            place = new Place("Malcolm Moos Health", 18);
            mPlaceDao.insert(place);
            place = new Place("Northrop", 16);
            mPlaceDao.insert(place);
            return null;
        }

        protected Void populateItemLostTable() {
            mItemLostDao.deleteAll();
            ItemLost item = new ItemLost("name1", "description1", "email1");
            mItemLostDao.insert(item);
            item = new ItemLost("name2", "description2", "email2");
            mItemLostDao.insert(item);
            item = new ItemLost("name3", "description3", "email3");
            mItemLostDao.insert(item);
            item = new ItemLost("name4", "description4", "email4");
            mItemLostDao.insert(item);
            return null;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populatePlaceTable();
            populateItemLostTable();
            return null;
        }
    }
}
