package com.company.davidmwang.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.company.davidmwang.dao.CountryDao;
import com.company.davidmwang.models.Country;
import com.company.davidmwang.mvvp.utils.CoreUtils;
import com.company.davidmwang.mvvp.utils.MvDataBase;
import com.company.davidmwang.services.CountryService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountyRepository {
        CountryDao countryDao;
        public LiveData<List<Country>> country;
    public CountyRepository(Application application){
        MvDataBase mvDataBase=MvDataBase.getDatabase(application);
        countryDao=mvDataBase.countryDao();
        country=countryDao.getAllCountries();

    }

    public void loadAllCountriesOnline(){
        Call<List<Country>> call= CoreUtils.getRetrofitClient().create(CountryService.class).getCountriesOnline();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                if (response.body()!=null){
                   for (Country coun:response.body()){
                       insert(coun);
                   }
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.e("Contry","An error was encountered");
            }
        });
    }

    public void insert(Country country){
      new  insertCountryAsync(countryDao).execute(country);
    }

    private static class insertCountryAsync extends AsyncTask<Country, Void, Void> {

        private CountryDao countryDao;

        insertCountryAsync(CountryDao dao) {
            countryDao = dao;
        }


        @Override
        protected Void doInBackground(Country... countries) {
            countryDao.insert(countries[0]);
            return null;
        }
    }
}
