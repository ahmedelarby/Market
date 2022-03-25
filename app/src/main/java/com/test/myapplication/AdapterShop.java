package com.test.myapplication;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.test.myapplication.Data.OnClickRecyclerChoose;
import com.test.myapplication.Model.DataShop;
import com.test.myapplication.Ui.AdpterRecyclerChoose;
import com.test.myapplication.databinding.ItemAllShopBinding;
import com.test.myapplication.databinding.ItemCollctionBinding;
import com.test.myapplication.databinding.ItemRecyclerChooseBinding;

import java.util.ArrayList;

public class AdapterShop extends RecyclerView.Adapter<AdapterShop.ViewHolder>{
    ArrayList<DataShop> list = new ArrayList<>();




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemAllShopBinding bining1 = DataBindingUtil.inflate(inflater, R.layout.item_all_shop,parent,false);

        return new ViewHolder(bining1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.recyclerChooseBinding.nameShop.setText(list.get(position).getName());









    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<DataShop> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
        private ItemAllShopBinding recyclerChooseBinding;


        public ViewHolder(ItemAllShopBinding binding) {
            super(binding.getRoot());
            this.recyclerChooseBinding=binding;
        }
    }
}
