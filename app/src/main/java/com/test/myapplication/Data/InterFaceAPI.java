package com.test.myapplication.Data;

import com.test.myapplication.Model.Root;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface InterFaceAPI {

    @GET("api/v0.1/countries")
    Observable<Root> getCountries();
}
