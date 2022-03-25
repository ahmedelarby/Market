package com.test.myapplication;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.test.myapplication.Data.OnClickRecyclerChoose;
import com.test.myapplication.Model.DataProducts;
import com.test.myapplication.Ui.AdapterRecyclerProdect;
import com.test.myapplication.Ui.AdpterRecyclerChoose;
import com.test.myapplication.databinding.FragmentHomeBinding;
import com.test.myapplication.databinding.ItemRecyclerProductsBinding;

import java.util.ArrayList;
import java.util.List;


public class Home extends Fragment implements OnClickRecyclerChoose   {
    FragmentHomeBinding binding;
    MoveViewModel moveViewModel;
    AdpterRecyclerChoose adpterRecyclerChoose;
    AdapterRecyclerProdect prodect;
    int open=0;

    public Home() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        Animation a1= AnimationUtils.loadAnimation(getActivity(),R.anim.pull_in_left);

        binding.search.startAnimation(a1);
        binding.f.startAnimation(a1);
        moveViewModel = ViewModelProviders.of(this).get(MoveViewModel.class);
        adpterRecyclerChoose= new AdpterRecyclerChoose(this);
        binding.RecyclerChoose.setHasFixedSize(true);
        binding.RecyclerChoose.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        binding.RecyclerChoose.setAdapter(adpterRecyclerChoose);

    // recyclerProdect
        prodect= new AdapterRecyclerProdect(this);
        binding.recprodect.setHasFixedSize(true);
        binding.recprodect.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        binding.recprodect.setAdapter(prodect);
        Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.up);
        binding. recprodect.startAnimation(animation);
     moveViewModel.mutableLiveDataRecycler.observe(getViewLifecycleOwner(), new Observer<ArrayList<String>>() {
         @Override
         public void onChanged(ArrayList<String> strings) {
             if (strings.isEmpty()){
                 binding.shimmerViewContainer.setVisibility(View.VISIBLE);
                 binding.shimmerViewContainer.startShimmer();
             }else {
                 binding.shimmerViewContainer.stopShimmer();
                 binding.shimmerViewContainer.setVisibility(View.GONE);
                 adpterRecyclerChoose.setList(strings);
             }


                moveViewModel.getMyDataRecyclerProductes(strings.get(0));



             }


     });


        moveViewModel.mutableLiveDataRecyclerProducts.observe(getViewLifecycleOwner(), new Observer<ArrayList<DataProducts>>() {
            @Override
            public void onChanged(ArrayList<DataProducts> dataProducts) {
                if (dataProducts.isEmpty()){
                    binding.shimmerViewprodect.setVisibility(View.VISIBLE);
                }else {
                    binding.shimmerViewprodect.setVisibility(View.GONE);
                    prodect.setList(dataProducts);
                }
            }
        });
















        return binding.getRoot();
    }

    @Override
    public void OnClickRecyclerChoose(int postion, View view, String itemname) {
        moveViewModel.getMyDataRecyclerProductes(itemname);
        Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.up);
        binding. recprodect.startAnimation(animation);



    }

    @Override
    public void OnClickRecyclerProducts(ItemRecyclerProductsBinding binding,List<String> images, String nameProduct, String pric, String Storge, String Detilse) {

        switch (open){
            case 1:
                LayoutAnimationController animation_=AnimationUtils.loadLayoutAnimation(getActivity(),R.anim.layout_animation_up_to_down);

                binding.linercolar.setLayoutAnimation(animation_);
                binding.red.setVisibility(View.GONE);
                binding.green.setVisibility(View.GONE);
                binding.banfsgey.setVisibility(View.GONE);
                break ;


        }

        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_Home_to_detailse);



    }

    @Override
    public void OnClickopen(ItemRecyclerProductsBinding baning) {
        switch (open){
            case 0:
                open=1;
                LayoutAnimationController animation=AnimationUtils.loadLayoutAnimation(getActivity(),R.anim.layout_animation_up_to_down);

                baning.linercolar.setLayoutAnimation(animation);
                baning.red.setVisibility(View.VISIBLE);
                baning.green.setVisibility(View.VISIBLE);
                baning.banfsgey.setVisibility(View.VISIBLE);
                break;
            case 1:
                open=0;
                LayoutAnimationController animation_=AnimationUtils.loadLayoutAnimation(getActivity(),R.anim.layout_animation_up_to_down);

                baning.linercolar.setLayoutAnimation(animation_);
                baning.red.setVisibility(View.GONE);
                baning.green.setVisibility(View.GONE);
                baning.banfsgey.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        moveViewModel.getMyDataRecycler();
    }


}