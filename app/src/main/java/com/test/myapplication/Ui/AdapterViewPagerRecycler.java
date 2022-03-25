package com.test.myapplication.Ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;
import com.test.myapplication.R;
import com.test.myapplication.databinding.ItempagerrecyclerBinding;
import com.test.myapplication.databinding.ItemsliderfaceBinding;

import java.util.ArrayList;
import java.util.List;

public class AdapterViewPagerRecycler extends RecyclerView.Adapter<AdapterViewPagerRecycler.ViewHolder> {
    List<String> fragmentList= new ArrayList<>();

    public AdapterViewPagerRecycler(List<String>list) {
        this.fragmentList=list;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItempagerrecyclerBinding bining1 = DataBindingUtil.inflate(inflater, R.layout.itempagerrecycler,parent,false);

        return new ViewHolder(bining1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Picasso.get().load(fragmentList.get(position)).into(holder.recyclerChooseBinding.image);
        Animation animation= AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.blink);
        holder.recyclerChooseBinding.layoutimage.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }



     class ViewHolder extends RecyclerView.ViewHolder{
        private ItempagerrecyclerBinding recyclerChooseBinding;


        public ViewHolder(ItempagerrecyclerBinding binding) {
            super(binding.getRoot());
            this.recyclerChooseBinding=binding;
        }
   }
}
