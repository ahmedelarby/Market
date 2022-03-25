package com.test.myapplication.Ui.Main;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.test.myapplication.AdapterSliderFace;
import com.test.myapplication.Model.DataSliderFace;
import com.test.myapplication.MoveViewModel;
import com.test.myapplication.R;
import com.test.myapplication.databinding.FragmentSliderFaceBinding;

import java.util.ArrayList;
import java.util.List;


public class SliderFace extends Fragment   {
 AdapterSliderFace viewPager;
MoveViewModel moveViewModel;
FragmentSliderFaceBinding binding;
AnimationDrawable drawable;
int positionitem;
    public SliderFace() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_slider_face, container, false);
        moveViewModel = ViewModelProviders.of(this).get(MoveViewModel.class);
        moveViewModel.getMyDataSlider();
        viewPager= new AdapterSliderFace();
        binding.ViewPager.setAdapter(viewPager);
        Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.right);
        binding. ViewPager.startAnimation(animation);
        drawable=(AnimationDrawable)binding.cnnt.getBackground();
        drawable.setEnterFadeDuration(4500);

        drawable.setExitFadeDuration(4500);
        drawable.start();
        binding.ViewPager.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                Toast.makeText(getContext(), ""+v.getHorizontalFadingEdgeLength(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionitem=binding.ViewPager.getCurrentItem();
                positionitem++;
                if (positionitem!=viewPager.getItemCount()){
                    binding.ViewPager.setCurrentItem(positionitem,true);
                    return;
                }

               if (binding.next.getText().equals("Next")){
                     Navigation.findNavController(binding.getRoot()).navigate(R.id.action_sliderFace_to_homeProducts);
                }
            }
        });


        moveViewModel.mutableLiveDataSlider.observe(getViewLifecycleOwner(), new Observer<ArrayList<DataSliderFace>>() {
            @Override
            public void onChanged(ArrayList<DataSliderFace> dataSliderFaces) {

            viewPager.setFragmentList(dataSliderFaces);
            viewPager.notifyDataSetChanged();
            }
        });










        return binding.getRoot();
    }



}