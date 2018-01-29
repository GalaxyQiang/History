package com.john.history.history.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.util.Log;

/**
 * Created by Administrator on 2018/1/28.
 */


@Database(entities = {EventEntry.class}, version = 1)
//@TypeConverters(DateConverter.class)
public abstract class HistoryDatabase extends RoomDatabase {

    private static final String LOG_TAG = HistoryDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "history";

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static HistoryDatabase sInstance;

    public static HistoryDatabase getInstance(Context context) {
        Log.d(LOG_TAG, "Getting the database");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        HistoryDatabase.class, HistoryDatabase.DATABASE_NAME).build();
                Log.d(LOG_TAG, "Made new database");
            }
        }
        return sInstance;
    }

    // The associated DAOs for the database
    public abstract HistoryDao weatherDao();
}
