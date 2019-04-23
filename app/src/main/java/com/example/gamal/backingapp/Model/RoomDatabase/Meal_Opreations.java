package com.example.gamal.backingapp.Model.RoomDatabase;

import com.example.gamal.backingapp.Model.Meals.Ingredient;
import com.example.gamal.backingapp.Model.Meals.Meal;
import com.example.gamal.backingapp.Model.Meals.Step;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface Meal_Opreations {
    @Query("SELECT * FROM Meal")
    List<Meal> Get_Meals_From_Database();
    @Query("SELECT id FROM MEAL")
    List<Integer> GET_ID_form_Data_base();
    @Insert
    void Add_Meal(Meal M);
    @Delete
    void delete_Meal(Meal M);

}
