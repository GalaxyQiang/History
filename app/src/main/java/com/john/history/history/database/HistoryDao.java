package com.john.history.history.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/1/28.
 */

@Dao
public interface HistoryDao {



    /**
     * Gets the weather for a single day
     *
     * @param date The date you want weather for
     * @return {@link LiveData} with weather for a single day
     */
    @Query("SELECT * FROM history WHERE date = :date")
    LiveData<EventEntry> getEventByDate(String date);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(EventEntry... event);



}
