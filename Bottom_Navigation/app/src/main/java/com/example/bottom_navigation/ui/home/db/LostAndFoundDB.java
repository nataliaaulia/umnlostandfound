package com.example.bottom_navigation.ui.home.db;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Place.class}, version = 1)
public abstract class LostAndFoundDB extends RoomDatabase {
    public abstract  PlaceDao placeDao();
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

        private final PlaceDao mDao;

        PopulateDbAsync(LostAndFoundDB db) {
            mDao = db.placeDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            Place place = new Place("Walter Library", 20);
            mDao.insert(place);
            place = new Place("Frederick R. Weisman", 10);
            mDao.insert(place);
            place = new Place("Vincent Hall", 5);
            mDao.insert(place);
            place = new Place("Malcolm Moos Health", 18);
            mDao.insert(place);
            place = new Place("Northrop", 16);
            mDao.insert(place);
            return null;
        }
    }
}
