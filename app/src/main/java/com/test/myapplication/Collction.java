package com.test.myapplication;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.test.myapplication.Data.FirebaseCollction;
import com.test.myapplication.Model.DataShop;
import com.test.myapplication.databinding.FragmentCollctionBinding;

import java.util.ArrayList;

public class Collction extends Fragment {
FragmentCollctionBinding binding;
ArrayList<DataShop> list = new ArrayList<>();

//AnimationDrawable drawable;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
AdapterShop adapterShop;
MoveViewModel moveViewModel;
    public Collction() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_collction, container, false);
        moveViewModel = ViewModelProviders.of(this).get(MoveViewModel.class);
        moveViewModel.get();



        adapterShop= new AdapterShop();
        binding.rec.setHasFixedSize(true);
        binding.rec.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        binding.rec.setAdapter(adapterShop);



        binding.recall.setHasFixedSize(true);
        binding.recall.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.recall.setAdapter(adapterShop);




moveViewModel.data.observe(getViewLifecycleOwner(), new Observer<ArrayList<DataShop>>() {
    @Override
    public void onChanged(ArrayList<DataShop> dataShops) {
        if (dataShops.isEmpty()){
            binding.emptyView.setVisibility(View.VISIBLE);

        }else {
            binding.emptyView.setVisibility(View.GONE);

            adapterShop.setList(dataShops);}

    }
});



        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}