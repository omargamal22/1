package com.example.gamal.backingapp.Model.Meals;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
 public class Ingredient {
    @PrimaryKey
    public int id;
    private double quantity;
    private String measure;
    private String ingredient;

     public double getQuantity() {
         return quantity;
     }

     public void setQuantity(double quantity) {
         this.quantity = quantity;
     }

     public String getMeasure() {
         return measure;
     }

     public void setMeasure(String measure) {
         this.measure = measure;
     }

     public String getIngredient() {
         return ingredient;
     }

     public void setIngredient(String ingredient) {
         this.ingredient = ingredient;
     }

     public Ingredient(double quantity, String measure, String ingredient) {

         this.quantity = quantity;
         this.measure = measure;
         this.ingredient = ingredient;
     }
 }
