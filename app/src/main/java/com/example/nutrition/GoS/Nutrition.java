package com.example.nutrition.GoS;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Nutrition")
public class Nutrition extends ParseObject {
    public void setProtein(int x){
        put("protein", x);
    }
    public void setFats(int x){
        put("fats", x);
    }
    public void setCarbs(int x){
        put("carbs", x);
    }
    public void setCalories(int x){
        put("calories", x);
    }
}
