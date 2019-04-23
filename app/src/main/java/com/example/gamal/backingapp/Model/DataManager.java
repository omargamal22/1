package com.example.gamal.backingapp.Model;

import android.content.Context;
import android.net.ConnectivityManager;

import com.example.gamal.backingapp.Model.Meals.Ingredient;
import com.example.gamal.backingapp.Model.Meals.Meal;
import com.example.gamal.backingapp.Model.Meals.Step;
import com.example.gamal.backingapp.Model.RoomDatabase.Meal_Database;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.room.Room;
import retrofit2.Retrofit;

public class DataManager {
    static List<Meal> Data;
    static Meal_Database DP;
    static Context con;
    static  List<Integer> ids;
    static boolean conection_flag=false;
    public ArrayList<String> GetNames(){
        ArrayList<String>Names=new ArrayList<>();
        if(Data.size()==0) {
            return Names;
        }
        for (Meal M:Data) {
            Names.add(M.getName());
        }
        return Names;
    }
    public  ArrayList<String>GetIngradiants( int id){
        ArrayList<String>Ingradiants=new ArrayList<>();
        StringBuilder SB = new StringBuilder();
        int i1=1;
        for (Ingredient i:Data.get(id).getIngredients()) {
            SB.delete(0,SB.capacity()-1);
            SB.append(String.valueOf(i1)+' ');
            SB.append("We Need ");
            SB.append(String.valueOf(i.getQuantity())+' ');
            SB.append(i.getMeasure()+' ');
            SB.append("of"+' '+i.getIngredient());
            Ingradiants.add(SB.toString());
        }
        return Ingradiants;
    }

    public  ArrayList<String>GetSteps( int id){
        ArrayList<String>steps=new ArrayList<>();
        for (Step i:Data.get(id).getSteps()) {
            steps.add(i.getShortDescription());
        }
        return steps;
    }

    public void Load_Data(Context context) throws InterruptedException {
        con=context;
        DP = Room.databaseBuilder(context,Meal_Database.class,"BackingappDataBase").build();
        ids=DP.meal_opreations().GET_ID_form_Data_base();
        ConnectivityManager cm = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(cm.getActiveNetworkInfo()!=null){
            InetAddress ipAddr = null;
            try {
                ipAddr = InetAddress.getByName("google.com");
                if(!ipAddr.equals("")){
                    Retrofit_Service.Get_Retrofit_Service();
                    Data = Retrofit_Service.res;
                    conection_flag=true;
                    return ;
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        Data=DP.meal_opreations().Get_Meals_From_Database();
        return;
    }

    public  String get_uri(int id1,int id2){
        if(id2==Data.get(id1).getSteps().size() || id2 < 0)
            return null;
        return Data.get(id1).getSteps().get(id2).getVideoURL();
    }

    public  String get_Desc(int id1,int id2){
        if(id2==Data.get(id1).getSteps().size() || id2 < 0)
            return null;
        return Data.get(id1).getSteps().get(id2).getDescription();
    }
    public void SaveOffline(int id ){
        Meal M = Data.get(id);
        DP.meal_opreations().Add_Meal(M);
        ids=DP.meal_opreations().GET_ID_form_Data_base();
    }
    public void delete_Meal_from_data_base(int id){
        Meal M = Data.get(id);
        DP.meal_opreations().delete_Meal(M);
        ids=DP.meal_opreations().GET_ID_form_Data_base();
    }
    public Boolean Saved(int id){

        return ids.contains(Integer.valueOf(Data.get(id).getId()));
    }
    public boolean check_connection(){
        return conection_flag;
    }
}
