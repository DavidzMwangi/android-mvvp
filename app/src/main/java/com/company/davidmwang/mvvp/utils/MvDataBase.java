package com.company.davidmwang.mvvp.utils;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.company.davidmwang.dao.CountryDao;
import com.company.davidmwang.models.Country;

@Database(entities = {Country.class}, version = 1)

public abstract class MvDataBase extends RoomDatabase {

   public abstract CountryDao countryDao();
    private static MvDataBase INSTANCE;



    public static MvDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MvDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MvDataBase.class, " database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
