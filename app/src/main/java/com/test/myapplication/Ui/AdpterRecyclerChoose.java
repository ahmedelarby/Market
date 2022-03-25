package com.test.myapplication.Ui;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.test.myapplication.Data.OnClickRecyclerChoose;
import com.test.myapplication.R;
import com.test.myapplication.databinding.ItemRecyclerChooseBinding;

import java.util.ArrayList;

public class AdpterRecyclerChoose extends RecyclerView.Adapter<AdpterRecyclerChoose.ViewHolder> {

    ArrayList<String> list = new ArrayList<>();
    OnClickRecyclerChoose adapterCallBacks;
    int selectPosition= 0;

    public AdpterRecyclerChoose(OnClickRecyclerChoose adapterCallBacks) {

        this.adapterCallBacks = adapterCallBacks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemRecyclerChooseBinding bining1 = DataBindingUtil.inflate(inflater, R.layout.item_recycler_choose,parent,false);

        return new ViewHolder(bining1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,  int position) {

    holder.recyclerChooseBinding.itemChoose.setText(list.get(position));

    holder.recyclerChooseBinding.itemChoose.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            adapterCallBacks.OnClickRecyclerChoose(position,holder.itemView,list.get(position));
            int pos=holder.getAdapterPosition();
            selectPosition=pos;
            notifyDataSetChanged();
        }
    });


        if (selectPosition==position){

            holder.recyclerChooseBinding.Card.setCardBackgroundColor(Color.parseColor("#000000"));
            holder.recyclerChooseBinding.itemChoose.setTextColor(Color.parseColor("#FFFFFF"));
        }else {
            holder.recyclerChooseBinding.Card.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.recyclerChooseBinding.itemChoose.setTextColor(Color.parseColor("#000000"));
        }





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
        private ItemRecyclerChooseBinding recyclerChooseBinding;


        public ViewHolder(ItemRecyclerChooseBinding binding) {
            super(binding.getRoot());
            this.recyclerChooseBinding=binding;
        }
    }
}
