package com.example.deneme;

import java.util.HashMap;

public class Constants {
    public static final String ENTRY_ID = "entry_id";
    public static final String FIELD1 = "field1";
    public static final String FIELD2 = "field2";
    public static final String FIELD3 = "field3";
    public static final String FIELD4 = "field4";
    public static final String FIELD5 = "field5";
    public static final String FIELD6 = "field6";
    private HashMap<String,String> relateds;

    //getter method to get the json data
    public HashMap<String,String> getRelateds() {
        return relateds;
    }

    //setter method to set json data on textview
    public void setRelateds(HashMap<String, String> relateds) {
        this.relateds = relateds;
    }
}
