package com.example.nutrition.GoS;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Map;

@ParseClassName("specs")
public class specs extends ParseObject {

    //Setters
    public void setName(String Name){
        put("name", Name);
    }
    public void setNutrition(Map<String, Double> nutrition){
        put("nutrition", nutrition);
    }

    //Getters
    public String getName(){
        return getString("name");
    }
    public Map<String, Double> getNutrition(){
        return getMap("nutrition");
    }
}
