package com.example.gamal.backingapp.Model.RoomDatabase;

import com.example.gamal.backingapp.Model.Meals.Ingredient;
import com.example.gamal.backingapp.Model.Meals.Step;

import java.util.ArrayList;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Meal_Entity {
    @PrimaryKey
    int id;
    String name;
    int servings;
    String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
