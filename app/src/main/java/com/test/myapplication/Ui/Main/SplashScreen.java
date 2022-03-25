package com.test.myapplication.Ui.Main;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.myapplication.R;
import com.test.myapplication.databinding.FragmentSplashScreenBinding;


public class SplashScreen extends Fragment {
FragmentSplashScreenBinding binding;


    public SplashScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash_screen, container, false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                NavOptions builder = new NavOptions.Builder().setPopUpTo(R.id.splashScreen, true).build();
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_splashScreen_to_sliderFace, savedInstanceState, builder);

            }
        }, 3000);
        return binding.getRoot();
    }
}