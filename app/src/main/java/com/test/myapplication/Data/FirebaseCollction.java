package com.test.myapplication.Data;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.test.myapplication.Model.DataShop;
import com.test.myapplication.Model.DataSliderFace;

import java.util.ArrayList;

public class FirebaseCollction {

    ArrayList<DataShop> list= new ArrayList<>();

    FirebaseFirestore firestore = FirebaseFirestore.getInstance();


    public ArrayList<DataShop> getshop(MutableLiveData<ArrayList<DataShop>> mutableLiveData){
            list.clear();
        firestore.collection("Shop").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot snapshot:queryDocumentSnapshots){
                    if (snapshot.exists()) {
                        DataShop dataShop = snapshot.toObject(DataShop.class);
                        list.add(dataShop);
                    }

                }
                mutableLiveData.postValue(list);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        return list;
    }

}
