package com.example.web.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kslisenko on 2.12.14.
 */
public class SurveyResults {

    private String color;
    private String pet;
    private String food;
    private Integer time;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getTime() {
        // But conversion doesn't work back, only Strings are allowed
        return time.toString();
    }

    public void setTime(Integer time) {
        // Automatic conversion
        this.time = time;
    }
}
