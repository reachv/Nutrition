package com.example.nutrition.GoS;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.Map;

public class Counter extends ParseObject {
    public ParseUser getUser(){
        return (ParseUser) get("user");
    }
    public Map<String, Nutrition> getNutritions(){
        return getMap("nutritions");
    }
    public void setNutritions(Map<String, Nutrition> x){
        put("nutritons", x);
    }
    public void setUser(ParseUser x){
        put("user", x);
    }
}
