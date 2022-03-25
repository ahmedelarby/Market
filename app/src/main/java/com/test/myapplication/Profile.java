package com.test.myapplication;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.test.myapplication.Model.Root;
import com.test.myapplication.databinding.FragmentProfileBinding;

import java.util.ArrayList;


public class Profile extends Fragment {
FragmentProfileBinding binding;
MoveViewModel moveViewModel;
    ArrayList<String> country = new ArrayList<>();
    ArrayList<String> citys = new ArrayList<>();
    public Profile() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false);
        moveViewModel = ViewModelProviders.of(this).get(MoveViewModel.class);
        moveViewModel.getcountry();
        moveViewModel.country.observe(getViewLifecycleOwner(), new Observer<Root>() {
            @Override
            public void onChanged(Root root) {
                for ( int i=0;i<root.getData().size();i++){
                    country.add(root.getData().get(i).getCountry());


                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, country);
                binding.cuntrey.setAdapter(adapter);
            }
        });
        binding.cuntrey.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               String getcountry=binding.cuntrey.getSelectedItem().toString();
                getcitys(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return binding.getRoot();
    }












    private void  getcitys(int posation){

        moveViewModel.country.observe(getViewLifecycleOwner(), new Observer<Root>() {
            @Override
            public void onChanged(Root data) {
                citys.clear();
                for (int i=0; i<data.getData().get(posation).getCities().size();i++){

                    citys.add(data.getData().get(posation).getCities().get(i));

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item,citys );
                binding.citys.setAdapter(adapter);
            }
        });
    }










}