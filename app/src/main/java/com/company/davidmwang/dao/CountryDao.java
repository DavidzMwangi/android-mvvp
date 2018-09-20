package com.company.davidmwang.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.company.davidmwang.models.Country;

import java.util.List;

@Dao
public interface CountryDao  {

    @Insert
    void insert(Country country);

    @Query("DELETE FROM COUNTRY_TABLE")
    void deleteAll();

    @Query("SELECT * from country_table ORDER BY name ASC")
    LiveData<List<Country>> getAllCountries();
}


