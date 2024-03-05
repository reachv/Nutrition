package com.example.nutrition.GoS;

import com.parse.ParseObject;

import java.util.Map;

public class Day extends ParseObject {

    public void setCheat(Boolean x){
        put("cheat", x);
    }
    public void setCurrCal(Map<Nutrition, Integer> x) {
        put("currCal", x);
    }

    public Map<Nutrition, Integer> getCurrCal(){
        return (Map<Nutrition, Integer>) getParseObject("currCal");
    }
}
