package com.test.myapplication.Ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.test.myapplication.Data.OnClickRecyclerChoose;
import com.test.myapplication.Model.DataProducts;
import com.test.myapplication.R;
import com.test.myapplication.databinding.ItemRecyclerProductsBinding;

import java.util.ArrayList;

public class AdapterRecyclerProdect extends RecyclerView.Adapter<AdapterRecyclerProdect.ViewHolder> {

    ArrayList<DataProducts> list = new ArrayList<>();
    OnClickRecyclerChoose onClickRecycler;
Context context;
AnimationDrawable drawable,drawable1;
    public AdapterRecyclerProdect(OnClickRecyclerChoose onClickRecycler) {
        this.onClickRecycler = onClickRecycler;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemRecyclerProductsBinding bining1 = DataBindingUtil.inflate(inflater, R.layout.item_recycler_products,parent,false);

        return new ViewHolder(bining1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.recyclerChooseBinding.nameProdect.setText(list.get(position).getNameProducts());
        holder.recyclerChooseBinding.textprice.setText(list.get(position).getPric());
        holder.recyclerChooseBinding.textstorge.setText(list.get(position).getStorge());
        holder.recyclerChooseBinding.newone.setText("New");
        holder.recyclerChooseBinding.viewPagerRecycler.setAdapter(new AdapterViewPagerRecycler(list.get(position).getImages()));
//        drawable= (AnimationDrawable) holder.recyclerChooseBinding.c22.getBackground();
//        drawable1=(AnimationDrawable)holder.recyclerChooseBinding.open.getBackground();
//        drawable.setEnterFadeDuration(4500);
//
//        drawable.setExitFadeDuration(4500);
//        drawable.start();
//        drawable1.setEnterFadeDuration(4500);
//        drawable1.setExitFadeDuration(4500);
//        drawable1.start();
      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              onClickRecycler.OnClickRecyclerProducts(holder.recyclerChooseBinding,list.get(holder.getAdapterPosition()).getImages(),
                      list.get(position).getNameProducts(),
                      list.get(position).getPric(),
                      list.get(position).getStorge(),
                      list.get(position).getDetilse());
          }
      });
      holder.recyclerChooseBinding.open.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              onClickRecycler.OnClickopen(holder.recyclerChooseBinding);
          }
      });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<DataProducts> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    protected class ViewHolder extends RecyclerView.ViewHolder{
        private ItemRecyclerProductsBinding recyclerChooseBinding;


        public ViewHolder(ItemRecyclerProductsBinding binding) {
            super(binding.getRoot());
            this.recyclerChooseBinding=binding;
        }
    }
}
