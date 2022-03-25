package com.test.myapplication.Data;


import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.test.myapplication.Model.DataProducts;
import com.test.myapplication.Model.DataSliderFace;

import java.util.ArrayList;

public class Firebase {
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    ArrayList<DataSliderFace> listSliderFace= new ArrayList<>();
    ArrayList<String> listitemchoose= new ArrayList<>();
    ArrayList<DataProducts> listitemProducts= new ArrayList<>();

    CollectionReference SliderFace =firestore.collection("SliderFace");
    CollectionReference itemMain =firestore.collection("ItemMain");
    String item;
    // getData in firebase Slider Face

    public ArrayList<DataSliderFace> getdata(MutableLiveData<ArrayList<DataSliderFace>> mutableLiveData){
        listSliderFace.clear();

        SliderFace.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error!=null){

                    return;
                }
                listSliderFace.clear();
                for (QueryDocumentSnapshot querySnapshot : value){
                    if (querySnapshot.exists()){
                        DataSliderFace dataFirebase = querySnapshot.toObject(DataSliderFace.class);
                        listSliderFace.add(dataFirebase);
                    }else {

                    }



                }
                mutableLiveData.postValue(listSliderFace);

            }
        });

        return listSliderFace;

    }
// getData in firebase Recycler Choose Item
    public ArrayList<String> getdataRecyclerchoose(MutableLiveData<ArrayList<String>> mutableLiveData){
//        listitemchoose.clear();

        itemMain.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error!=null){
                    return;
                }
                listitemchoose.clear();
                for (QueryDocumentSnapshot querySnapshot : value){
                        if (querySnapshot.exists()){
                           String dataFirebase = querySnapshot.get("item").toString();

                            listitemchoose.add(dataFirebase);

                        }else {

                        }


                }
                mutableLiveData.postValue(listitemchoose);

            }
        });

        return listitemchoose;

    }
//getData in firebase Recycler Products
    public ArrayList<DataProducts> getdataRecyclerProducts(MutableLiveData<ArrayList<DataProducts>> mutableLiveData,String type){
        CollectionReference itemproducts =firestore.collection(type);

        listitemProducts.clear();

        itemproducts.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error!=null){
                    return;
                }
                listitemProducts.clear();
                for (QueryDocumentSnapshot querySnapshot : value){
                    if (querySnapshot.exists()){
                        DataProducts dataFirebase = querySnapshot.toObject(DataProducts.class);
                        listitemProducts.add(dataFirebase);
                    }else {

                    }


                }
                mutableLiveData.postValue(listitemProducts);

            }
        });

        return listitemProducts;

    }














}
