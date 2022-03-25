package com.test.myapplication.Model;

import java.util.ArrayList;

public class Datum {
    public String iso2;
    public String iso3;
    public String country;
    public ArrayList<String> cities;

    public String getCountry() {
        return country;
    }

    public ArrayList<String> getCities() {
        return cities;
    }
}
