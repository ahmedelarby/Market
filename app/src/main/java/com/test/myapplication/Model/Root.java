package com.test.myapplication.Model;

import java.util.ArrayList;

public class Root {
    public boolean error;
    public String msg;
    public ArrayList<Datum> data;

    public String getMsg() {
        return msg;
    }

    public ArrayList<Datum> getData() {
        return data;
    }
}
