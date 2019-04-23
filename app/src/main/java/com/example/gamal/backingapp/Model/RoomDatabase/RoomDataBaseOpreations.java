package com.example.gamal.backingapp.Model.RoomDatabase;

import android.content.Context;

import com.example.gamal.backingapp.Model.Meals.Meal;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Room;

public class RoomDataBaseOpreations {
    public static class RoomDataBaseService{
        public static List<Meal> Get_Meals_From_Data_Base(Context con){
            List<Meal> Taked =new ArrayList<>();
            List<Meal_Entity> ME;
            List<Steps_Entity> SE;
            List<Ingredient_Entity> IE;
            Meal_Database DP;
            DP= Room.databaseBuilder(con,Meal_Database.class,"BackingappDataBase").build();
            //ME=DP.meal_opreations().Get_Meals_From_Database();
            //SE=DP.meal_opreations().Get_Steps_From_Database();
            //IE=DP.meal_opreations().Get_Ingredients_From_Database();

            return null;
        }
    }
}
