package com.test.myapplication.Data;

import com.test.myapplication.Model.Root;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPI {
    InterFaceAPI interFaceAPI;
    private static final String BASE_URL="https://countriesnow.space/";
    public static RetrofitAPI instans;


    public RetrofitAPI() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        interFaceAPI=retrofit.create(InterFaceAPI.class);

    }




    public static RetrofitAPI getInstans() {
        if (null==instans){
            instans=new RetrofitAPI();
        }
        return instans;
    }



    public Observable<Root> getPosts(){

        return interFaceAPI.getCountries();
    }
}


