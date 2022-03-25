package com.test.myapplication.Data;

import android.view.View;

import com.test.myapplication.databinding.ItemRecyclerProductsBinding;

import java.util.List;

public interface OnClickRecyclerChoose {
    public void OnClickRecyclerChoose(int postion, View view, String itemname );
    public void OnClickRecyclerProducts( ItemRecyclerProductsBinding binding,List<String> images, String nameProduct, String pric, String Storge, String Detilse );
    public void OnClickopen(ItemRecyclerProductsBinding baning);



}
