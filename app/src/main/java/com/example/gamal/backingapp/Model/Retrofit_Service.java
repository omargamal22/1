package com.example.gamal.backingapp.Model;

import android.util.Log;
import android.widget.Toast;

import com.example.gamal.backingapp.Model.Meals.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_Service  {
    static List<Meal> res;
    static boolean flag_con = false;
    static String E;
    static void  Get_Retrofit_Service(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        API api = retrofit.create(API.class);
        Call<List<Meal>> call_ = api.GET_MEALS();
        call_.enqueue(new Callback<List<Meal>>() {
            @Override
            public void onResponse(Call<List<Meal>> call, Response<List<Meal>> response) {
                res = response.body();
                flag_con = true;
            }

            @Override
            public void onFailure(Call<List<Meal>> call, Throwable t) {
                E=t.getMessage();
            }
        });
        while (!flag_con){}
    }
}
