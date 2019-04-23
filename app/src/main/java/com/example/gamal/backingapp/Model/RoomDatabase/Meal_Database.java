package com.example.gamal.backingapp.Model.RoomDatabase;

import com.example.gamal.backingapp.Model.Meals.Ingredient;
import com.example.gamal.backingapp.Model.Meals.Meal;
import com.example.gamal.backingapp.Model.Meals.Step;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Meal.class,Step.class,Ingredient.class}, version = 1)
@TypeConverters(DataConverter.class)
public abstract class Meal_Database extends RoomDatabase {
    public abstract Meal_Opreations meal_opreations();
}
