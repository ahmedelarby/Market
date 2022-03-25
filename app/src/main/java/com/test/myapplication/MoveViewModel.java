package com.test.myapplication;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.test.myapplication.Data.Firebase;
import com.test.myapplication.Data.FirebaseCollction;
import com.test.myapplication.Data.RetrofitAPI;
import com.test.myapplication.Model.DataProducts;
import com.test.myapplication.Model.DataShop;
import com.test.myapplication.Model.DataSliderFace;
import com.test.myapplication.Model.Root;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MoveViewModel extends ViewModel {
    Firebase firebase = new Firebase();
    FirebaseCollction collction = new FirebaseCollction();
    public MutableLiveData<ArrayList<DataSliderFace>> mutableLiveDataSlider = new MutableLiveData<>();
    public MutableLiveData<ArrayList<String>> mutableLiveDataRecycler = new MutableLiveData<>();
    public MutableLiveData<ArrayList<DataProducts>> mutableLiveDataRecyclerProducts = new MutableLiveData<>();
    public MutableLiveData<ArrayList<DataShop>> data = new MutableLiveData<>();
    public MutableLiveData<Root> country = new MutableLiveData<>();


    public void getMyDataSlider(){
        firebase.getdata(mutableLiveDataSlider);
    }

    public void getMyDataRecycler(){
        firebase.getdataRecyclerchoose(mutableLiveDataRecycler);
    }
    public void  getcountry(){
       Observable observable = RetrofitAPI.getInstans().getPosts()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Object o) {
                country.setValue((Root) o);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }













    public void getMyDataRecyclerProductes(String type){

        firebase.getdataRecyclerProducts(mutableLiveDataRecyclerProducts,type);
    }

    public void get(){
       collction.getshop(data);
    }



}
