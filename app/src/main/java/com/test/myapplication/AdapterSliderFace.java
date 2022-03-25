package com.test.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;
import com.test.myapplication.Model.DataSliderFace;
import com.test.myapplication.databinding.ItemsliderfaceBinding;

import java.util.ArrayList;
import java.util.List;

public class AdapterSliderFace extends RecyclerView.Adapter<AdapterSliderFace.ViewHolder> {
    List<DataSliderFace> list= new ArrayList<>();








    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemsliderfaceBinding bining1 = DataBindingUtil.inflate(inflater, R.layout.itemsliderface,parent,false);

        return new ViewHolder(bining1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Picasso.get().load(list.get(position).getUrl()).into(holder.itemsliderfaceBinding.ImageSlider);
        holder.itemsliderfaceBinding.textSlider.setText(list.get(position).getTitil());
        Animation animation= AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.right);
        holder.itemsliderfaceBinding.ImageSlider.startAnimation(animation);
        holder.itemsliderfaceBinding.textSlider.startAnimation(animation);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setFragmentList(List<DataSliderFace> List) {
        this.list = List;
    }

     class ViewHolder extends RecyclerView.ViewHolder{
        private ItemsliderfaceBinding itemsliderfaceBinding;


        public ViewHolder(ItemsliderfaceBinding binding) {
            super(binding.getRoot());
            this.itemsliderfaceBinding=binding;
        }
   }
}
