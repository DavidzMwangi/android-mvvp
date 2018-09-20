package com.company.davidmwang.views;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.company.davidmwang.models.Country;
import com.company.davidmwang.repositories.CountyRepository;

import java.util.List;

public class MainActivityView extends AndroidViewModel {

    CountyRepository countyRepository;
  public   LiveData<List<Country>> country;
    public MainActivityView(@NonNull Application application) {
        super(application);

        countyRepository=new CountyRepository(application);
        country=countyRepository.country;
    }

    public void loadCountryOnLine(){
        countyRepository.loadAllCountriesOnline();
    }


}
