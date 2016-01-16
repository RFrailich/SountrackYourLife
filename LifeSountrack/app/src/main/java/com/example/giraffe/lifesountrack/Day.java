package com.example.giraffe.lifesountrack;

import java.util.ArrayList;

/**
 * Created by Giraffe on 2016-01-16.
 */
public class Day {

    /** One of 1-7 to represent Mon-Sun */
    private Integer num;
    private ArrayList<String> hours;


    public void Day(Integer num){
        this.num = num;
        this.hours = new ArrayList<String>(23);
    }

    public void setHours(String activity, Integer hr){
        hours.set(hr, activity);
    }

    public void getHours(Integer hr){
        hours.get(hr);
    }



}
