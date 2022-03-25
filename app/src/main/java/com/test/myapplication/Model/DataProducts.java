package com.test.myapplication.Model;

import java.util.List;

public class DataProducts {
    String NameProducts;
    String Pric;
    String Storge;
    String detilse;
    List<String> images;

    public DataProducts() {
    }

    public DataProducts(String nameProducts, String pric, String storge, String detilse, List<String> images) {
        NameProducts = nameProducts;
        Pric = pric;
        Storge = storge;
        this.detilse = detilse;
        this.images = images;
    }

    public String getNameProducts() {
        return NameProducts;
    }

    public void setNameProducts(String nameProducts) {
        NameProducts = nameProducts;
    }

    public String getPric() {
        return Pric;
    }

    public void setPric(String pric) {
        Pric = pric;
    }

    public String getStorge() {
        return Storge;
    }

    public void setStorge(String storge) {
        Storge = storge;
    }

    public String getDetilse() {
        return detilse;
    }

    public void setDetilse(String detilse) {
        this.detilse = detilse;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
