package com.example.gamal.backingapp.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Array_Adapter extends RecyclerView.Adapter<Array_Adapter.My_View_Holder> {
    protected ArrayList<String >Names;
    protected int Lay_out_res;


    public Array_Adapter(ArrayList<String> names, int lay_out_res) {
        Names = names;
        Lay_out_res = lay_out_res;

    }

    @NonNull
    @Override
    public My_View_Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View V =  LayoutInflater.from(viewGroup.getContext()).inflate(Lay_out_res,viewGroup,false);
        return new My_View_Holder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull My_View_Holder my_view_holder, int i) {

    }

    @Override
    public int getItemCount() {
        return Names.size();
    }

    protected class My_View_Holder extends RecyclerView.ViewHolder  {


        public My_View_Holder(@NonNull View itemView) {
            super(itemView);

        }
    }

}
