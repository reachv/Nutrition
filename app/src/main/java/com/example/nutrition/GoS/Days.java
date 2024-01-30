package com.example.nutrition.GoS;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;
import java.util.Map;


@ParseClassName("Days")
public class Days extends ParseObject {

    //Setters
    public void setDay(Date x){
        put("currDay", x);
    }
    public void setCheat(Boolean x){
        put("cheat", x);
    }
    public void setNutri(Map<String, Double> x){
        put("nutri", x);
    }

    //Getters
    public Date getCurr(){
        return (Date) get("currDay");
    }
    public Boolean getCheat(){
        return (Boolean) get("cheat");
    }
    public Map<String, Double> getNutri(){
        return getMap("nutri");
    }
}
