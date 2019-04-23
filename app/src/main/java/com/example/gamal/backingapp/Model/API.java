package com.example.gamal.backingapp.Model;

import com.example.gamal.backingapp.Model.Meals.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    final String BASE_URL = "https://d17h27t6h515a5.cloudfront.net/";

    @GET("topher/2017/May/59121517_baking/baking.json")
    Call<List<Meal>> GET_MEALS();

}
