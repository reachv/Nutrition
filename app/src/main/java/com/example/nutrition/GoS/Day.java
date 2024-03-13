package com.example.nutrition.GoS;

import com.parse.ParseObject;

import java.util.Date;
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

    public int getProtein(){
        return (int) get("protien");
    }
    public int getCarbs(){
        return (int) get("carbs");
    }
    public int getFats(){
        return (int) get("fats");
    }
    public int getCalories(){
        return (int) get("calories");
    }
    public boolean getCheat(){
        return (boolean) get("cheat");
    }

    @Override
    public Date getCreatedAt() {
        return super.getCreatedAt();
    }
}
