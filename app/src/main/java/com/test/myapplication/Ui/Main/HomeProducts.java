package com.test.myapplication.Ui.Main;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.myapplication.R;
import com.test.myapplication.databinding.FragmentHomeProductsBinding;


public class HomeProducts extends Fragment {

FragmentHomeProductsBinding binding;

    public HomeProducts() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_products, container, false);

        NavHostFragment navHostFragment =
                (NavHostFragment) getChildFragmentManager().findFragmentById(binding.navHostFragment.getId());
        NavController navController = navHostFragment.getNavController();




        NavigationUI.setupWithNavController(binding.BottomNavigation,navController);




        return binding.getRoot();
    }

}