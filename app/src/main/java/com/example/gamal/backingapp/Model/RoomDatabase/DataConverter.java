package com.example.gamal.backingapp.Model.RoomDatabase;

import com.example.gamal.backingapp.Model.Meals.Ingredient;
import com.example.gamal.backingapp.Model.Meals.Step;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.room.TypeConverter;

public class DataConverter implements Serializable {
    @TypeConverter
    public String fromStepList(ArrayList<Step> countryLang) {
        if (countryLang == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Step>>() {}.getType();
        String json = gson.toJson(countryLang, type);
        return json;
    }

    @TypeConverter
    public ArrayList<Step> toStepLangList(String countryLangString) {
        if (countryLangString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Step>>() {}.getType();
        ArrayList<Step> countryLangList = gson.fromJson(countryLangString, type);
        return countryLangList;
    }

    @TypeConverter
    public String fromIngredientList(ArrayList<Ingredient> countryLang) {
        if (countryLang == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Ingredient>>() {}.getType();
        String json = gson.toJson(countryLang, type);
        return json;
    }

    @TypeConverter
    public ArrayList<Ingredient> toIngredientList(String countryLangString) {
        if (countryLangString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Ingredient>>() {}.getType();
        ArrayList<Ingredient> countryLangList = gson.fromJson(countryLangString, type);
        return countryLangList;
    }
}
