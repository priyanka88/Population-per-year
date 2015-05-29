package com.company;

/**
 * Created by priyankachavan on 3/10/15.
 */
public class Population {
    int aYear2010;
    int aYear2011;
    int aYear2012;
    int aNumber;
    String aCity;
    String aState;

    public Population(String city,String state,int pop10,int pop11,int pop12)
    {
        this.aCity = city;
        this.aState = state;
        this.aYear2010 = pop10;
        this.aYear2011 = pop11;
        this.aYear2012 = pop12;
    }

    public float percentChange12and10()
    {
        float a,b,c;
        a = (this.aYear2012 - this.aYear2010);
        b = a/ this.aYear2010;

         c  = b * 100;
        return c;
    }
    public String getState()
    {
        return aState;
    }


}