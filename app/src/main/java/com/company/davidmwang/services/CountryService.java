package com.company.davidmwang.services;

import com.company.davidmwang.models.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryService {


    @GET("get_countries")
    Call<List<Country>> getCountriesOnline();
}
